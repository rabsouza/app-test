package br.com.teste.appteste.service;

import java.util.List;

import br.com.teste.appteste.domain.Message;
import br.com.teste.appteste.mock.MockMessage;

/**
 * Created by rabsouza on 20/06/16.
 */

public class MessageService {

    public List<Message> findAllMessageByContact(String toContact) {
        return MockMessage.createDataMock();
    }
}
