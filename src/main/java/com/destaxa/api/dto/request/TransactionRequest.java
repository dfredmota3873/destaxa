package com.destaxa.api.dto.request;


import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class TransactionRequest {

    private String codigo;
    private String numeroCartao;
    private String codigoProcessamento;
    private BigDecimal valorTransacao;
    private LocalDateTime dataTransacao;
    private String nsu;
    private String horaTransacao;
    private String dataLocalTransacao;
    private String dataVencimentoCartao;
    private String modoEntrada;
    private String codigoEstabelecimento;
    private Integer numeroDeParcelas;

}
