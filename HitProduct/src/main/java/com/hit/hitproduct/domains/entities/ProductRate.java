package com.hit.hitproduct.domains.entities;

import com.hit.hitproduct.applications.commons.ERate;
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
@Table(name = "product_rates")
public class ProductRate extends AbstractAuditingEntity {

    @Enumerated(EnumType.STRING)
    private ERate value;

    @ManyToOne(cascade = CascadeType.MERGE, fetch = FetchType.EAGER)
    @JoinColumn(name = "id_product")
    private Product product;

    @ManyToOne(cascade = CascadeType.MERGE, fetch = FetchType.EAGER)
    @JoinColumn(name = "id_user")
    private User user;

    @OneToOne(mappedBy = "productRate")
    private Comment comment;
}
