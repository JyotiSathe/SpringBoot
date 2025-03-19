package com.siemens.springboottraining.entity;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.SuperBuilder;

@Data
@Setter
@SuperBuilder
@EqualsAndHashCode(callSuper = false)
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="Customer_Id")
    protected long customerId;

    @Embedded
    protected FullName fullName;

    @Column(name = "Contact_No")
    protected String contactNumber;

    @Column(name = "Email", nullable = false)
    protected String email;

    @Column(name = "Password", nullable = false, length = 10)
    protected String password;
}
