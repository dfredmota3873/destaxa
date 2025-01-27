package com.destaxa.api.dto.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import java.math.BigDecimal;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class AuthorizationRequest {

    @JsonProperty(value = "external_id")
    private String externalId;
    private BigDecimal value;
    @JsonProperty(value = "card_number")
    private String cardNumber;
    private Integer installments;
    private String cvv;
    @JsonProperty(value = "exp_month")
    private Integer expMonth;
    @JsonProperty(value = "exp_year")
    private Integer expYear;
    @JsonProperty(value = "holder_name")
    private String holderName;

}
