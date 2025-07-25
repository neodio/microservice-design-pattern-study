package shop.service;

import org.springframework.stereotype.Service;
import shop.domain.Order;

@Service
public class FakePaymentService implements PaymentService {
    @Override
    public boolean processPayment(Order order) {
        // 실제 PG 연동 로직 대신, 로그 출력 후 항상 성공으로 간주
        System.out.println("[Payment] 주문 " + order.getId() + " 결제 처리 완료 (가상 성공)");
        return true;
    }
}