package br.com.teste.appteste.service;

import android.util.Log;

import java.util.List;

import br.com.teste.appteste.domain.Message;
import br.com.teste.appteste.mock.MockMessage;

/**
 * Created by rabsouza on 20/06/16.
 */

public class MessageService {

    private static final String TAG = MessageService.class.getSimpleName();

    public List<Message> findMessagesByContact(String toContact) {
        Log.i(TAG, String.format(
                "findMessagesByContact: Find messages by contact: %s!", toContact));

        return MockMessage.createDataMock();
    }
}
