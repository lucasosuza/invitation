package com.lucassouza.customer;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CustomerTest {

    @Test
    void shouldReturnTheUserIdAndName() {
        Customer customer = new Customer();
        customer.name = "foo";
        customer.id = 2;

        String expected = "{\"user_id\": 2, \"name\": \"foo\"}";

        assertEquals(expected, customer.toString());
    }
}