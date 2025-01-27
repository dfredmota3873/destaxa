package com.destaxa.service;

import com.destaxa.api.dto.response.AuthorizationResponse;
import com.destaxa.model.Authorization;
import com.destaxa.repository.AuthorizationRepository;
import lombok.RequiredArgsConstructor;
import org.jpos.iso.ISOException;
import org.jpos.iso.ISOMsg;
import org.jpos.iso.packager.GenericPackager;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.Socket;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

@Service
@RequiredArgsConstructor
public class AuthorizationService {

    private final AuthorizationRepository authorizationRepository;

    DateTimeFormatter DATEFORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd");

    private Socket socket;
    private DataOutputStream out;
    private Scanner in;

    @Transactional
    public AuthorizationResponse authorizar(Authorization authorization) throws ISOException, IOException {

        Authorization authorizationModel = authorizationRepository.save(authorization);

        // mandar a requisição pro serverSocket

        InputStream inputStream = AuthorizationService.class.getResourceAsStream("/fields.xml");
        GenericPackager packager = new GenericPackager(inputStream);

        ISOMsg isoMsg = new ISOMsg();
        isoMsg.setPackager(packager);

        // set header
        isoMsg.setHeader("ISO1987".getBytes());

        isoMsg.set(0, "");
        isoMsg.set(1, "");
        isoMsg.set(2, authorization.getCardNumber());
        isoMsg.set(3, "");
        isoMsg.set(4, authorization.getValue().toEngineeringString());
        isoMsg.set(7, LocalDate.now().toString());
        isoMsg.set(11, "");
        isoMsg.set(12, "");
        isoMsg.set(13, "");
        isoMsg.set(14, "");
        isoMsg.set(22, "");
        isoMsg.set(42, "");
        isoMsg.set(48, "");
        isoMsg.set(67, "");

        sendAuthorizationToServer(isoMsg.pack());

        return null;
    }


    private void sendAuthorizationToServer(byte[] msg) throws IOException {
        out.write(msg);
        socket.close();
        out.close();
        in.close();
    }

}




