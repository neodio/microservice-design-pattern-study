package eshop.product.domain;

import eshop.common.domain.BaseEntity;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.math.BigDecimal;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Builder
@Data
@Entity
@AllArgsConstructor(access = AccessLevel.PACKAGE)
@Table(name = "products")
public class Product extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;            // 상품명
//    private String category;
    @Enumerated(EnumType.STRING)
    private Category category;      // 카테고리
    private String manufacturer;    // 제조사
    private BigDecimal price;       // 가격
    private int stock;              // 재고 수량
    private String imageUrl;        // 제품 이미지

    public Product() {}
    public Product(String name, Category category, String manufacturer, BigDecimal price, int stock) {
        this.name = name;
        this.category = category;
        this.manufacturer = manufacturer;
        this.price = price;
        this.stock = stock;
    }
    public Product(String name, Category category, String manufacturer, BigDecimal price, int stock, String imageUrl) {
        this.name = name;
        this.category = category;
        this.manufacturer = manufacturer;
        this.price = price;
        this.stock = stock;
        this.imageUrl = imageUrl;
    }

}