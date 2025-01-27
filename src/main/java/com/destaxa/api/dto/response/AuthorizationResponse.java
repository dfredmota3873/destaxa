package com.destaxa.api.dto.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@Builder
public class AuthorizationResponse {

    @JsonProperty(value = "payment_id")
    private String paymentId;
    private BigDecimal value;
    @JsonProperty(value = "response_code")
    private String responseCode;
    @JsonProperty(value = "transaction_date")
    private LocalDate transactionDate;
    @JsonProperty(value = "transaction_hour")
    private String transactionHour;
    @JsonProperty(value = "authorization_code")
    private String authorizationCode;
}
