package com.destaxa.api.controller.impl;

import com.destaxa.api.controller.doc.IAuthorizationController;
import com.destaxa.api.dto.request.AuthorizationRequest;
import com.destaxa.api.dto.response.ContaResponse;
import com.destaxa.converter.AuthorizationConverter;
import com.destaxa.service.AuthorizationService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/destaxa")
@AllArgsConstructor
@CrossOrigin("*")
@Slf4j
public class AuthorizationController  implements IAuthorizationController {

    private final AuthorizationService authorizationService;

    private final AuthorizationConverter converter;

    @Override
    public ResponseEntity<ContaResponse> cadastrar(String xIdentifier, AuthorizationRequest authorizationRequest) {
        log.info("Iniciando a authorização da transação: {}", authorizationRequest);
        authorizationService.authorizar(converter.toModel(authorizationRequest));
        log.info("Authorização realizada com sucesso!");
        return null;
    }
}
