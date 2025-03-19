package com.siemens.springboottraining.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "Address_Id")
    private long addressNumber;

    @Column(name = "Door_No", nullable = false, length = 4)
    private String doorNumber;

    @Column(name = "Street_Name", nullable = false, length = 150)
    private String street;

    @Column(name = "City", nullable = false, length = 150)
    private String city;

    @Column(name = "State", nullable = false, length = 150)
    private String state;

    @Column(name = "ZipCode", nullable = false, length = 10)
    private String zip;

    @Column(name = "Contry", nullable = false, length = 150)
    private String country;

    @ManyToOne(fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    @JoinColumn(foreignKey = @ForeignKey(name = "Customer_Id"),
            name = "Customer_Id_FK")
    private Customer customer;
}
