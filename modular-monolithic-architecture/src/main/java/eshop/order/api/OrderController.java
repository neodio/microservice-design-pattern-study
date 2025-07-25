package eshop.order.api;

import eshop.order.application.OrderService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class OrderController {
    private final OrderService orderService;
    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    // 주문 확정 (결제 처리 포함)
    @GetMapping("/order/checkout")
    public String checkoutOrder(Model model) {
        try {
            orderService.placeOrder();
        } catch (Exception e) {
            model.addAttribute("errorMessage", e.getMessage());
            return "order/cart";
        }
        // 주문 후에는 주문 내역 페이지로 이동
        return "redirect:/orders";
    }

    // 주문 내역 보기
    @GetMapping("/orders")
    public String listOrders(Model model) {
        model.addAttribute("orders", orderService.getAllOrders());
        return "order/list";  // templates/order/list.html
    }
}