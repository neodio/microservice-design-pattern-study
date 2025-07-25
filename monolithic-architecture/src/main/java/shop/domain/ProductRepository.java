package shop.domain;

import java.util.List;
import java.util.Optional;

public interface ProductRepository {
    List<Product> findAll();
    Optional<Product> findById(Long id);
    List<Product> findByCategory(String category);
    List<Product> findByManufacturer(String manufacturer);
    List<Product> findByManufacturerAndCategory(String manufacturer, String category);
    Product save(Product product);
    List<Product> saveAll(Iterable<Product> products);
}