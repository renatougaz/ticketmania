package com.renato.ticketmania.api;


import org.junit.jupiter.api.Test;

import static java.util.Collections.emptyList;
import static org.junit.jupiter.api.Assertions.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class TicketControllerTests {

    @Autowired
    TicketController ticketController;

    @Test
    public void testController() {
        var result = ticketController.getAllTickets();
        assertEquals(emptyList(), result);
    }
}
