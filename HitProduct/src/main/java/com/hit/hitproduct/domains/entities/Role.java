package com.hit.hitproduct.domains.entities;

import com.hit.hitproduct.applications.commons.ERole;
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
@Table(name = "roles")
public class Role extends AbstractAuditingEntity {

    @Enumerated(EnumType.STRING)
    @Column(length = 20)
    private ERole name;

    private String description;
}
