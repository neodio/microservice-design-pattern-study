package eshop.common.infrastructure;

import eshop.product.domain.Product;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

// Spring Data JPA 레포지토리 (어댑터 내부 용도)
public interface SpringDataProductRepository extends JpaRepository<Product, Long> {
    List<Product> findByCategory(String category);
    List<Product> findByManufacturer(String manufacturer);
    List<Product> findByManufacturerAndCategory(String manufacturer, String category);
}