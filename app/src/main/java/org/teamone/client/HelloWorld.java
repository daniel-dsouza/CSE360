package org.teamone.client;

import org.teamone.coe.MessageService;

/**
 * @author Petri Kainulainen
 */
public class HelloWorld {

    //private static final Logger LOGGER = Logger.getLogger(HelloWorld.class);

    public static void main(String[] args) {
        MessageService messageService = new MessageService();

        String message = messageService.getMessage();
        System.out.println(message);
        //LOGGER.info("Received message: " + message);
    }
}
