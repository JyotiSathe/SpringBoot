package com.siemens.springboottraining.entity;

import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Embeddable
public class FullName {
    protected String firstName;
    protected String middleName;
    protected String lastName;
}
