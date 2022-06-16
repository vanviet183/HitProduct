package com.hit.hitproduct.domains.entities;

import com.hit.hitproduct.domains.entities.base.AbstractAuditingEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.Nationalized;

import javax.persistence.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "product_colors", uniqueConstraints = @UniqueConstraint(columnNames = {"id_product", "slug"}))
public class ProductColor extends AbstractAuditingEntity {

    @Nationalized
    private String color;

    private String slug;

    private Integer currentNumber;

    @ManyToOne(cascade = CascadeType.MERGE, fetch = FetchType.EAGER)
    @JoinColumn(name = "id_product")
    private Product product;
}
