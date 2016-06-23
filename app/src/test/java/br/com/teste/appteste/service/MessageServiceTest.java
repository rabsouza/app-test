package br.com.teste.appteste.service;

import android.util.Log;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import java.util.ArrayList;
import java.util.List;

import br.com.teste.appteste.domain.Message;
import br.com.teste.appteste.mock.MockMessage;

import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;
import static org.powermock.api.mockito.PowerMockito.mockStatic;

@RunWith(PowerMockRunner.class)
@PrepareForTest({
        Log.class,
        MockMessage.class
})
public class MessageServiceTest {

    @InjectMocks
    private MessageService messageService;

    @Before
    public void setup() {
        mockStatic(Log.class);
        mockStatic(MockMessage.class);
    }

    @Test
    public void shouldReturnEmptyMessagesWhenfindMessagesWithContactNull() {
        List<Message> actions = messageService.findMessagesByContact(null);
        assertThat(actions, is(hasSize(0)));
    }

    @Test
    public void shouldReturnEmptyMessagesWhenfindMessagesWithContactEmpty() {
        List<Message> actions = messageService.findMessagesByContact(null);
        assertThat(actions, is(hasSize(0)));
    }

    @Test
    public void shouldReturnEmptyMessagesWhenfindMessagesWithContactInvalid() {
        List<Message> menus = new ArrayList<>();
        PowerMockito.when(MockMessage.createDataMock()).thenReturn(menus);

        List<Message> actions = messageService.findMessagesByContact("abc");
        assertThat(actions, is(hasSize(0)));
    }

    @Test
    public void shouldReturnMessagesWhenfindMessagesWithContactVaLid() {
        List<Message> menus = new ArrayList<>();
        menus.add(new Message());
        PowerMockito.when(MockMessage.createDataMock()).thenReturn(menus);

        List<Message> actions = messageService.findMessagesByContact("abc");
        assertThat(actions, is(hasSize(1)));
    }

}