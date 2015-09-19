package org.teamone.coe;

import org.teamone.coe.MessageService;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * @author Petri Kainulainen
 */
public class MessageServiceTest {

    private MessageService messageService;

    @Before
    public void setUp() {
        messageService = new MessageService();
    }

    @Test
    public void getMessage_ShouldReturnMessage() {
        assertEquals("1Hello World!", messageService.getMessage());
    }
}