package eshop.order.infrastructure;

import eshop.common.infrastructure.SpringDataOrderRepository;
import eshop.order.domain.Order;
import java.util.List;
import org.springframework.stereotype.Repository;

@Repository
public class OrderRepositoryAdapter implements OrderRepository {
    private final SpringDataOrderRepository jpaRepo;
    public OrderRepositoryAdapter(SpringDataOrderRepository jpaRepo) {
        this.jpaRepo = jpaRepo;
    }

    @Override
    public Order save(Order order) {
        return jpaRepo.save(order);
    }
    @Override
    public List<Order> findAll() {
        return jpaRepo.findAll();
    }

    @Override
    public long count() { return jpaRepo.count(); }
}
