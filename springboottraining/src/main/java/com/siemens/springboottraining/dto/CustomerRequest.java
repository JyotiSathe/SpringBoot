package com.siemens.springboottraining.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CustomerRequest {
    protected long customerId;

    protected FullNameRequest fullName;

    protected String contactNumber;

    @NotNull(message = "email cannot be null")
    @Email(message = "Not according to pattern")
    protected String email;

    @NotNull(message = "password cannot be null")
    @Pattern(regexp = "^(?=.*\\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[a-zA-Z]).{8,}$", message = "Password format not matching")
    protected String password;
}
