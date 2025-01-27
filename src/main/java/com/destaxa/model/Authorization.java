package com.destaxa.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.math.BigDecimal;
import java.util.UUID;

@Entity
@Data
@Builder
@AllArgsConstructor
@RequiredArgsConstructor
@Table(name = "authorization" , schema = "destaxa")
public class Authorization {

     @Id
     @GeneratedValue(strategy = GenerationType.AUTO)
     private UUID id;
     private String externalId;
     private BigDecimal value;
     private String cardNumber;
     private Integer installments;
     private String cvv;
     private Integer expMoth;
     private Integer expYear;
     private String holderName;
}
