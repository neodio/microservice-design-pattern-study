package eshop.product.api;

import eshop.product.application.ProductService;
import eshop.product.domain.Product;
import java.util.List;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ProductController {
    private final ProductService productService;
    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    // 메인 페이지 리디렉션
    @GetMapping("/")
    public String home() {
        return "redirect:/products";
    }

    // 상품 목록 및 검색
    @GetMapping("/products")
    public String listProducts(
            @RequestParam(required = false) String category,
            @RequestParam(required = false) String manufacturer,
            Model model) {
        List<Product> products;
        if (category != null && !category.isEmpty() && manufacturer != null && !manufacturer.isEmpty()) {
            // 제조사+카테고리 동시 필터
            products = productService.getProductsByManufacturerAndCategory(manufacturer, category);
        } else if (category != null && !category.isEmpty()) {
            products = productService.getProductsByCategory(category);
        } else if (manufacturer != null && !manufacturer.isEmpty()) {
            products = productService.getProductsByManufacturer(manufacturer);
        } else {
            products = productService.getAllProducts();
        }
        model.addAttribute("products", products);
        model.addAttribute("selectedCategory", category);
        model.addAttribute("selectedManufacturer", manufacturer);
        return "product/list";  // templates/product/list.html 뷰 템플릿
    }
}