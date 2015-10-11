package org.teamone.core;

import org.junit.Before;
import org.junit.Test;
import org.teamone.core.users.Patient;

public class MessageServiceTest {

    private Patient messageService;

    @Before
    public void setUp() {
        messageService = new Patient();
    }

    @Test
    public void getMessage_ShouldReturnMessage() {

    }
}