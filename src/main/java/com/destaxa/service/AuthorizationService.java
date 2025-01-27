package com.destaxa.service;

import com.destaxa.api.dto.response.TransactionResponse;
import com.destaxa.model.Authorization;
import com.destaxa.repository.AuthorizationRepository;
import com.destaxa.server.Server;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

import static java.lang.System.out;

@Service
@RequiredArgsConstructor
public class AuthorizationService {

    private final AuthorizationRepository authorizationRepository;

    private Socket socket;
    private DataOutputStream out;
    private Scanner in;

    @Transactional
    public TransactionResponse authorizar(Authorization authorization) {

      Authorization authorizationModel = authorizationRepository.save(authorization);

      // mandar a requisição pro rabbit mq






    }


    private void sendAuthorizationToServer() throws IOException {
        String line = "";
        while(!line.equals(Server.STOP_STRING)){
            line = in.nextLine();
            out.writeUTF(line);
        }

        close();
    }

    private void close() throws IOException {
        socket.close();
        out.close();
        in.close();
    }

}
