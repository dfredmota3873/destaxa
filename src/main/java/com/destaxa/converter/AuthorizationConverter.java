package com.destaxa.converter;

import com.destaxa.api.dto.request.AuthorizationRequest;
import com.destaxa.model.Authorization;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class AuthorizationConverter {

    public Authorization toModel(AuthorizationRequest request){

        return Authorization.builder()
                .externalId(request.getExternalId())
                .cardNumber(request.getCardNumber())
                .cvv(request.getCvv())
                .expMoth(request.getExpMonth())
                .expYear(request.getExpYear())
                .holderName(request.getHolderName())
                .value(request.getValue())
                .build();

    }

    public ContaResponse toResponse(Conta conta){

        return ContaResponse.builder()
                .id(conta.getId())
                .dataPagamento(conta.getDataPagamento())
                .dataVencimento(conta.getDataVencimento())
                .descricao(conta.getDescricao())
                .valor(conta.getValor())
                .situacao(conta.getSituacao().getDescricao())
                .build();
    }

    public List<ContaResponse> ToListResponse(List<Conta> listEntity){
        return listEntity.stream().map(this::toResponse).toList();
    }
}
