package eshop.common.infrastructure;

import eshop.order.domain.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SpringDataOrderRepository extends JpaRepository<Order, Long> {
    // 추가로 필요한 쿼리 메서드가 있다면 정의 (예: findBy... 등)
}