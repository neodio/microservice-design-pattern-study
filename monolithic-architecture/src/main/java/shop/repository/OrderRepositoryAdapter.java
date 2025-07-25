package shop.repository;


import java.util.List;
import org.springframework.stereotype.Repository;
import shop.domain.Order;
import shop.domain.OrderRepository;

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
}
