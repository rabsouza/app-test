package br.com.teste.appteste.mock;

import com.google.common.collect.Lists;

import java.util.List;

import br.com.teste.appteste.domain.Message;

/**
 * Created by rabsouza on 20/06/16.
 */

public class MockMessage {

    private MockMessage() {
    }

    private static String toContact = "Rafael Batista<rabsouza@gmail.com>";

    private static String[] fromContacts = {
            "Jack Dorsey",
            "David Koch",
            "Charles Koch",
            "Michael Bloomberg",
            "Larry Ellison",
            "Mark Zuckerberg",
            "Jeff Bezos",
            "Carlos Slim",
            "Warren Buffett",
            "Amâncio Ortega",
            "Bill Gates",
            "Gilvan De Pinho"
    };

    private static String[] urlsPhoto = {
            null,
            "http://i2.wp.com/top10mais.org/wp-content/uploads/2013/01/David-koch.jpg?w=200",
            null,
            "http://i0.wp.com/top10mais.org/wp-content/uploads/2015/04/Michael-Bloomberg-entre-os-homens-mais-ricos-do-mundo.jpg?resize=200%2C200",
            "http://i1.wp.com/top10mais.org/wp-content/uploads/2011/12/5-10-homens-mais-ricos-do-mundo-2012-e1326944771653.jpg?resize=200%2C200",
            "http://i1.wp.com/top10mais.org/wp-content/uploads/2015/04/Mark-Zuckerberg-entre-os-homens-mais-ricos-do-mundo.jpg?resize=200%2C200",
            null,
            null,
            null,
            null,
            "http://i1.wp.com/top10mais.org/wp-content/uploads/2011/12/2-top-10-homens-mais-ricos-do-mundo-2012-e1326944730866.jpg?resize=200%2C200",
            "https://pbs.twimg.com/profile_images/730817442000306176/ygd0tRyj.jpg"
    };

    public static List<Message> createDataMock() {
        List<Message> messages = Lists.newArrayList();

        for (int i = 0; i < 10; i++) {
            messages.add(createNewMessage());
        }

        return messages;
    }

    private static Message createNewMessage() {
        int index = (int) Math.round(fromContacts.length * Math.random());

        return new Message().id(System.currentTimeMillis())
                .toContact(toContact)
                .urlPhoto(urlsPhoto[index])
                .fromContact(fromContacts[index]);
    }


}
