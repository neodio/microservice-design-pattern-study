package eshop.order.domain;

import eshop.product.domain.Product;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import java.math.BigDecimal;
import lombok.Data;

@Data
@Entity
@Table(name = "orderitems")
public class OrderItem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "order_id")
    private Order order;          // 어떤 주문에 속한 항목인지 (부모 주문)
    @ManyToOne
    @JoinColumn(name = "product_id")
    private Product product;      // 주문한 상품 (상품 엔티티 참조)
    private int quantity;         // 수량
    private BigDecimal price;     // 주문 당시 상품 단가

    // getters/setters ...

    public OrderItem() {}
    public OrderItem(Product product, int quantity, BigDecimal price) {
        this.product = product;
        this.quantity = quantity;
        this.price = price;
    }
    // ... (toString 등 필요시)
}