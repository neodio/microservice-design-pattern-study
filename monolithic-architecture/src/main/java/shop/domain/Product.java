package shop.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.math.BigDecimal;
import lombok.Data;

@Data
@Entity
@Table(name = "products")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;            // 상품명
    private String category;        // 카테고리
    private String manufacturer;    // 제조사
    private BigDecimal price;       // 가격
    private int stock;              // 재고 수량

    // 기본 생성자, getters/setters 생략 (엔티티 요건)
    public Product() {}
    public Product(String name, String category, String manufacturer, BigDecimal price, int stock) {
        this.name = name;
        this.category = category;
        this.manufacturer = manufacturer;
        this.price = price;
        this.stock = stock;
    }
    // ... (toString 등 필요시 추가)
}