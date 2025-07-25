package eshop.order.application;

import eshop.order.domain.Order;
import eshop.order.domain.OrderItem;
import eshop.order.infrastructure.OrderRepository;
import eshop.product.domain.Product;
import eshop.product.infrastructure.ProductRepository;
import jakarta.transaction.Transactional;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class OrderService {
    private final ProductRepository productRepo;
    private final OrderRepository orderRepo;
    private final PaymentService paymentService;

    // 간단히 한 사용자 시나리오로 가정하여, 서비스 내에 장바구니 상태 유지
    private final List<OrderItem> cartItems = new ArrayList<>();

    public OrderService(ProductRepository productRepo,
                        OrderRepository orderRepo,
                        PaymentService paymentService) {
        this.productRepo = productRepo;
        this.orderRepo = orderRepo;
        this.paymentService = paymentService;
    }

    /** 장바구니에 상품 추가 */
    public void addToCart(Long productId, int quantity) {
        // 상품 조회 (상품 모듈의 ProductRepository 활용)
        Product product = productRepo.findById(productId)
                .orElseThrow(() -> new IllegalArgumentException("상품이 존재하지 않습니다."));
        if (quantity < 1) quantity = 1; // 수량 최소 1
        if (product.getStock() < quantity) {
            throw new IllegalArgumentException("재고 부족: 요청 수량이 재고를 초과했습니다.");
        }
        // 장바구니에 아이템 추가 (중복 상품 처리 단순화: 새로운 항목으로 추가)
        OrderItem item = new OrderItem(product, quantity, product.getPrice());
        cartItems.add(item);
    }

    /** 현재 장바구니 내 상품 목록 조회 */
    public List<OrderItem> getCartItems() {
        return cartItems;
    }

    /** 장바구니 초기화 (비우기) */
    public void clearCart() {
        cartItems.clear();
    }

    /** 주문 확정 및 결제 처리 */
    public Order placeOrder() {
        if (cartItems.isEmpty()) {
            throw new IllegalStateException("장바구니가 비어 있습니다.");
        }
        // Order 객체 생성 및 데이터 설정
        Order order = new Order();
        order.setOrderDate(LocalDateTime.now());
        BigDecimal total = BigDecimal.ZERO;
        for (OrderItem item : cartItems) {
            // 주문 총액 누적 계산 (price * quantity)
            BigDecimal lineTotal = item.getPrice().multiply(BigDecimal.valueOf(item.getQuantity()));
            total = total.add(lineTotal);
            // Order에 OrderItem 추가 (연관관계 설정)
            order.addItem(item);
        }
        order.setTotalAmount(total);

        // 결제 처리 (Payment 모듈의 서비스 호출)
        boolean paymentResult = paymentService.processPayment(order);
        if (!paymentResult) {
            throw new RuntimeException("결제 실패: 주문을 완료할 수 없습니다.");
        }

        // 주문 저장 (DB 저장)
        Order savedOrder = orderRepo.save(order);
        // 주문 완료 후 장바구니 비우기
        clearCart();
        return savedOrder;
    }

    /** 주문 내역 조회 */
    public List<Order> getAllOrders() {
        return orderRepo.findAll();
    }
}