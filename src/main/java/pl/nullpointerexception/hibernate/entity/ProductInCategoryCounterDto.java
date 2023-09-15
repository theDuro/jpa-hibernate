package pl.nullpointerexception.hibernate.entity;

public class ProductInCategoryCounterDto {
    private Long categoryId;
    private Long productInCategoryCounter;

    public ProductInCategoryCounterDto(long categoryId, long productInCategoryCounter) {
        this.categoryId = categoryId;
        this.productInCategoryCounter = productInCategoryCounter;
    }

    @Override
    public String toString() {
        return "ProductInCategoryCounterDto{" +
                "categoryId=" + categoryId +
                ", productInCategoryCounter=" + productInCategoryCounter +
                '}';
    }

    public long getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(long categoryId) {
        this.categoryId = categoryId;
    }

    public long getProductInCategoryCounter() {
        return productInCategoryCounter;
    }

    public void setProductInCategoryCounter(long productInCategoryCounter) {
        this.productInCategoryCounter = productInCategoryCounter;
    }
}
