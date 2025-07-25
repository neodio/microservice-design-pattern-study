package eshop.common.infrastructure;

import eshop.product.domain.Category;
import eshop.product.domain.Product;
import eshop.product.infrastructure.ProductRepository;
import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
@RequiredArgsConstructor
@Slf4j
public class DataLoader implements CommandLineRunner {

//    private final UserRepository userRepository;
    private final ProductRepository productRepository;
//    private final PasswordEncoder passwordEncoder;

    @Override
    @Transactional
    public void run(String... args) {
        // 사용자 데이터 로드
//        loadUsers();

        // 상품 데이터 로드
        loadProducts();

        log.info("Sample data loaded successfully");
    }

//    private void loadUsers() {
//        if (userRepository.count() > 0) {
//            return;
//        }
//
//        User admin = User.builder()
//                .email("admin@example.com")
//                .password(passwordEncoder.encode("admin123"))
//                .name("Admin User")
//                .phone("010-1234-5678")
//                .role(Role.ADMIN)
//                .build();
//
//        User user = User.builder()
//                .email("user@example.com")
//                .password(passwordEncoder.encode("user123"))
//                .name("Normal User")
//                .phone("010-8765-4321")
//                .role(Role.USER)
//                .build();
//
//        userRepository.saveAll(Arrays.asList(admin, user));
//        log.info("Loaded users: {}", userRepository.count());
//    }

    private void loadProducts() {
        if (productRepository.count() > 0) {
            return;
        }

        List<Product> products = Arrays.asList(
                Product.builder()
                        .name("스프링 티셔츠")
                        .category(Category.CLOTHING)
                        .manufacturer("SpringCorp")
                        .price(BigDecimal.valueOf(25000))
                        .stock(100)
                        .build(),

                Product.builder()
                        .name("자바 머그컴")
                        .category(Category.KITCHEN)
                        .manufacturer("JavaKitchen")
                        .price(BigDecimal.valueOf(15000))
                        .stock(50)
                        .build(),

                Product.builder()
                        .name("데이터베이스 교재")
                        .category(Category.BOOKS)
                        .manufacturer("TechBooks")
                        .price(BigDecimal.valueOf(30000))
                        .stock(500)
                        .build(),

                Product.builder()
                        .name("노트북")
                        .category(Category.ELECTRONICS)
                        .manufacturer("TechCompany")
                        .price(BigDecimal.valueOf(1200000))
                        .stock(30)
                        .build(),

                Product.builder()
                        .name("캐주얼 데님 자켓")
                        .category(Category.CLOTHING)
                        .manufacturer("FashionBrand")
                        .price(BigDecimal.valueOf(89000))
                        .stock(150)
                        .build(),

                Product.builder()
                        .name("런닝화 Air Max")
                        .category(Category.SPORTS)
                        .manufacturer("SportyWear")
                        .price(BigDecimal.valueOf(129000))
                        .stock(100)
                        .build(),

                Product.builder()
                        .name("비즈니스 캐주얼 셔츠")
                        .category(Category.CLOTHING)
                        .manufacturer("FashionBrand")
                        .price(BigDecimal.valueOf(59000))
                        .stock(200)
                        .build(),

                Product.builder()
                        .name("헤드폰 NoiseCancel Pro")
                        .category(Category.ELECTRONICS)
                        .manufacturer("SoundMaster")
                        .price(BigDecimal.valueOf(299000))
                        .stock(80)
                        .build(),

                Product.builder()
                        .name("프리미엄 쇼파")
                        .category(Category.HOME)
                        .manufacturer("FitLife")
                        .price(BigDecimal.valueOf(1990000))
                        .stock(120)
                        .build(),

                Product.builder()
                        .name("홈 오피스 책상")
                        .category(Category.HOME)
                        .manufacturer("HomeStyle")
                        .price(BigDecimal.valueOf(249000))
                        .stock(40)
                        .build(),

                Product.builder()
                        .name("아로마 디퓨저")
                        .category(Category.HOME)
                        .manufacturer("HomeLiving")
                        .price(BigDecimal.valueOf(39000))
                        .stock(100)
                        .build(),

                Product.builder()
                        .name("베스트셀러 소설")
                        .category(Category.BOOKS)
                        .manufacturer("BookHouse")
                        .price(BigDecimal.valueOf(15000))
                        .stock(300)
                        .build()
        );

        productRepository.saveAll(products);
        log.info("Loaded products: {}", productRepository.count());
    }

//    private void loadCoupons() {
//        if (couponRepository.count() > 0) {
//            return;
//        }
//
//        LocalDateTime now = LocalDateTime.now();
//
//        List<Coupon> coupons = Arrays.asList(
//                Coupon.builder()
//                        .code("WELCOME10")
//                        .name("신규 회원 10% 할인")
//                        .description("신규 회원을 위한 10% 할인 쿠폰입니다.")
//                        .discountType(DiscountType.PERCENTAGE)
//                        .discountValue(new BigDecimal("10"))
//                        .minimumOrderAmount(new BigDecimal("30000"))
//                        .maximumDiscountAmount(new BigDecimal("50000"))
//                        .validFrom(now.minusDays(1))
//                        .validTo(now.plusMonths(1))
//                        .build(),
//
//                Coupon.builder()
//                        .code("SAVE5000")
//                        .name("5,000원 할인")
//                        .description("5,000원 즉시 할인 쿠폰입니다.")
//                        .discountType(DiscountType.FIXED_AMOUNT)
//                        .discountValue(new BigDecimal("5000"))
//                        .minimumOrderAmount(new BigDecimal("50000"))
//                        .validFrom(now.minusDays(1))
//                        .validTo(now.plusMonths(1))
//                        .build(),
//
//                Coupon.builder()
//                        .code("SUMMER20")
//                        .name("여름 시즌 20% 할인")
//                        .description("여름 시즌 특별 20% 할인 쿠폰입니다.")
//                        .discountType(DiscountType.PERCENTAGE)
//                        .discountValue(new BigDecimal("20"))
//                        .minimumOrderAmount(new BigDecimal("100000"))
//                        .maximumDiscountAmount(new BigDecimal("100000"))
//                        .validFrom(now.minusDays(1))
//                        .validTo(now.plusMonths(3))
//                        .build(),
//
//                Coupon.builder()
//                        .code("SPECIAL15")
//                        .name("특별 15% 할인")
//                        .description("VIP 고객을 위한 15% 할인 쿠폰입니다.")
//                        .discountType(DiscountType.PERCENTAGE)
//                        .discountValue(new BigDecimal("15"))
//                        .minimumOrderAmount(new BigDecimal("50000"))
//                        .maximumDiscountAmount(new BigDecimal("70000"))
//                        .validFrom(now.minusDays(1))
//                        .validTo(now.plusMonths(2))
//                        .build(),
//
//                Coupon.builder()
//                        .code("WEEKEND10")
//                        .name("주말 10% 할인")
//                        .description("주말에만 사용 가능한 10% 할인 쿠폰입니다.")
//                        .discountType(DiscountType.PERCENTAGE)
//                        .discountValue(new BigDecimal("10"))
//                        .minimumOrderAmount(new BigDecimal("30000"))
//                        .maximumDiscountAmount(new BigDecimal("50000"))
//                        .validFrom(now.minusDays(1))
//                        .validTo(now.plusWeeks(2))
//                        .build()
//        );
//
//        couponRepository.saveAll(coupons);
//        log.info("Loaded coupons: {}", couponRepository.count());
//    }
}