package entity.product;

import entity.BaseEntity;
import lombok.Getter;
import lombok.Setter;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import javax.validation.constraints.Digits;
import java.math.BigDecimal;

@Getter
@Setter
@Entity
@Table(name = "product_variant")
public class ProductVariant extends BaseEntity {

    @ManyToOne
    public Product product;

    @Column(nullable = false)
    private String language;

//    @Column(nullable = false)
//    private Integer year;

    @Column(nullable = false)
    @Digits(integer = 6, fraction = 2)
    private BigDecimal price;
}
