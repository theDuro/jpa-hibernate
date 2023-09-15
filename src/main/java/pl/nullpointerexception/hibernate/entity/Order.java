package pl.nullpointerexception.hibernate.entity;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Set;
@NamedEntityGraph(
        name = "order-rows",
        attributeNodes = {
                @NamedAttributeNode("orderRows"),
                @NamedAttributeNode("customer")
        },subgraphs = @NamedSubgraph(name = "orderRows", attributeNodes = @NamedAttributeNode("product"))


)
@Entity
@Table(name = "\"order\"")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;
    private LocalDateTime created;
    private BigDecimal total;
    @OneToMany
    @JoinColumn(name = "oreder_id")
    private Set<OrderRow> orderRows;

    public LocalDateTime getCreated() {
        return created;
    }

    public void setCreated(LocalDateTime created) {
        this.created = created;
    }

    public BigDecimal getTotal() {
        return total;
    }

    public void setTotal(BigDecimal total) {
        this.total = total;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
