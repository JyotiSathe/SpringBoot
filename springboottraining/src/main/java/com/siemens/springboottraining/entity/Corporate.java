package com.siemens.springboottraining.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.*;
import lombok.experimental.SuperBuilder;

@Data
@SuperBuilder
@EqualsAndHashCode(callSuper = false)
@NoArgsConstructor
@AllArgsConstructor
@ToString(callSuper = true)
@Entity
public class Corporate extends Customer {


    @Enumerated(EnumType.STRING)
    @Column(name = "CompanyType")
    private CompanyType companyType;
}
