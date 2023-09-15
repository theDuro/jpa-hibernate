package pl.nullpointerexception.hibernate.entity.batching;

import javax.persistence.*;

@Entity
@Table(name = "review")
public class BatchReview {
    @Id
    @Column(name = "id", nullable = false)
    private Long id;
    private String content;
    private int rating;

    public BatchReview() {
    }

    public BatchReview(Long id, String content, int rating, long productId) {
        this.id = id;
        this.content = content;
        this.rating = rating;
        this.productId = productId;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public long getProductId() {
        return productId;
    }

    public void setProductId(long productId) {
        this.productId = productId;
    }

    @Column(name = "product_id")
    private long productId;
}
