package com.hit.hitproduct.domains.entities;

import com.hit.hitproduct.domains.entities.base.AbstractAuditingEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "product_sizes", uniqueConstraints = @UniqueConstraint(columnNames = {"id_product", "value"}))
public class ProductSize extends AbstractAuditingEntity {

    private Integer value;

    private Integer currentNumber;

    @ManyToOne(cascade = CascadeType.MERGE, fetch = FetchType.EAGER)
    @JoinColumn(name = "id_product")
    private Product product;
}
