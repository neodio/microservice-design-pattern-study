package shop.domain;

import java.util.List;

public interface OrderRepository {
    Order save(Order order);
    List<Order> findAll();
    // (실제 서비스라면 사용자별 조회 등이 필요하나, 예제에서는 모든 주문 조회)
}