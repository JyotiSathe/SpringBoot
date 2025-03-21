package com.siemens.accountapi.model;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Data
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
@EqualsAndHashCode(callSuper = false)
public class Account {

    @Schema(hidden = true)
    protected long accountNumber;

    protected long runningTotal;

    @Schema(hidden = true)
    protected String openDate;
}
