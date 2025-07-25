package shop.service;

import shop.domain.Order;

public interface PaymentService {
    /** 주문에 대해 결제를 처리하고 성공 여부를 반환 */
    boolean processPayment(Order order);
}