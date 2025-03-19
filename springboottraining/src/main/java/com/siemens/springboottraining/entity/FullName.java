package com.siemens.springboottraining.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Embeddable
public class FullName {

    @Column(name = "First_Name", nullable = false, length = 50)
    protected String firstName;
    @Column(name = "Middle_Name", nullable = true, length = 50)
    protected String middleName;
    @Column(name = "Last_Name", nullable = false, length = 50)
    protected String lastName;
}
