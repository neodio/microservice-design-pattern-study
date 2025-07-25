package eshop.product.infrastructure;

import eshop.common.infrastructure.SpringDataProductRepository;
import eshop.product.domain.Product;
import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Repository;

@Repository  // Spring Bean 등록
public class ProductRepositoryAdapter implements ProductRepository {
    private final SpringDataProductRepository jpaRepo;

    public ProductRepositoryAdapter(SpringDataProductRepository jpaRepo) {
        this.jpaRepo = jpaRepo;
    }

    @Override
    public List<Product> findAll() {
        return jpaRepo.findAll();
    }
    @Override
    public Optional<Product> findById(Long id) {
        return jpaRepo.findById(id);
    }
    @Override
    public List<Product> findByCategory(String category) {
        return jpaRepo.findByCategory(category);
    }
    @Override
    public List<Product> findByManufacturer(String manufacturer) {
        return jpaRepo.findByManufacturer(manufacturer);
    }
    @Override
    public List<Product> findByManufacturerAndCategory(String manufacturer, String category) {
        return jpaRepo.findByManufacturerAndCategory(manufacturer, category);
    }
    @Override
    public Product save(Product product) {
        return jpaRepo.save(product);
    }
    @Override
    public List<Product> saveAll(Iterable<Product> products) {
        return jpaRepo.saveAll(products);
    }

    @Override
    public long count() { return jpaRepo.count(); }
}