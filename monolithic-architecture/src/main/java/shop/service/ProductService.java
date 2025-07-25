package shop.service;

import java.util.List;
import org.springframework.stereotype.Service;
import shop.domain.Product;
import shop.domain.ProductRepository;

@Service
public class ProductService {
    private final ProductRepository productRepo;

    public ProductService(ProductRepository productRepo) {
        this.productRepo = productRepo;
    }

    /** 전체 상품 목록 조회 */
    public List<Product> getAllProducts() {
        return productRepo.findAll();
    }

    /** 제조사로 상품 검색 */
    public List<Product> getProductsByManufacturer(String manufacturer) {
        return productRepo.findByManufacturer(manufacturer);
    }

    /** 카테고리로 상품 검색 */
    public List<Product> getProductsByCategory(String category) {
        return productRepo.findByCategory(category);
    }

    /** 제조사+카테고리로 상품 검색 */
    public List<Product> getProductsByManufacturerAndCategory(String manufacturer, String category) {
        return productRepo.findByManufacturerAndCategory(manufacturer, category);
    }
}