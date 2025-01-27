package com.destaxa.api.controller.doc;

import com.destaxa.api.dto.request.AuthorizationRequest;
import com.destaxa.api.dto.response.ContaResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;

@Tag(name = "Api de Transações Destaxa")
public interface IAuthorizationController {

    @Operation(summary = "Realiza uma solicitação de autorização no server",
            description = "Realiza uma solicitação de autorização no server")
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "201",
                    description = "Caso a autorização seja realizada com sucesso!"
            )
    })
    @PostMapping(value = "/authorization",produces= MediaType.APPLICATION_JSON_VALUE,consumes=MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<ContaResponse> cadastrar(@RequestHeader(value = "x-identifier")String xIdentifier,
                                            @Valid @RequestBody AuthorizationRequest authorizationRequest);
}
