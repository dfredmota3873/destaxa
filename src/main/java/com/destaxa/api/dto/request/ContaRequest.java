package com.destaxa.api.dto.request;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ContaRequest {

    @NotNull(message = "Data de vencimento é obrigatória")
    private LocalDate dataVencimento;

    private LocalDate dataPagamento;

    @NotNull(message = "O valor da conta é obrigatório")
    private BigDecimal valor;

    @NotEmpty(message = "A descrição da conta é obrigatória")
    private String descricao;

    @NotNull(message = "A situação da conta é obrigatória")
    private String situacao;
}
