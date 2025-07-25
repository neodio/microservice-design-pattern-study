package shop.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import shop.service.OrderService;

@Controller
public class CartController {
    private final OrderService orderService;
    public CartController(OrderService orderService) {
        this.orderService = orderService;
    }

    // 장바구니 목록 보기
    @GetMapping("/cart")
    public String viewCart(Model model) {
        model.addAttribute("items", orderService.getCartItems());
        return "order/cart";  // templates/order/cart.html
    }

    // 장바구니에 상품 추가 (예제 단순화를 위해 GET 사용)
    @GetMapping("/cart/add")
    public String addToCart(@RequestParam("productId") Long productId) {
        orderService.addToCart(productId, 1);  // 수량은 1개씩 추가
        return "redirect:/cart";
    }
}