package shop.repository;


import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import shop.domain.Product;

// Spring Data JPA 레포지토리 (어댑터 내부 용도)
interface SpringDataProductRepository extends JpaRepository<Product, Long> {
    List<Product> findByCategory(String category);
    List<Product> findByManufacturer(String manufacturer);
    List<Product> findByManufacturerAndCategory(String manufacturer, String category);
}