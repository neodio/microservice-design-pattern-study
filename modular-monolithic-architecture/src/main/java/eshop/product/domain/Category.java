package eshop.product.domain;

public enum Category {
    ELECTRONICS("전자제품"),
    CLOTHING("의류"),
    BOOKS("도서"),
    HOME("홈&리빙"),
    KITCHEN("주방용품"),
    FOOD("식품"),
    SPORTS("스포츠");

    private final String displayName;

    Category(String displayName) {
        this.displayName = displayName;
    }

    public String getDisplayName() {
        return displayName;
    }
}
