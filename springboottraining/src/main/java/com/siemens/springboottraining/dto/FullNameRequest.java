package com.siemens.springboottraining.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class FullNameRequest {

    protected String firstName;
    protected String middleName;
    protected String lastName;
}
