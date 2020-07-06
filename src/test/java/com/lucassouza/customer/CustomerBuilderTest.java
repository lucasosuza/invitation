package com.lucassouza.customer;

import com.fasterxml.jackson.core.JsonProcessingException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class CustomerBuilderTest {

    // should return a new Customer
    // should call distance Calculator

    private CustomerBuilder customerBuilder;
    private String validJson;

    @BeforeEach
    void setUp() {
        customerBuilder = new CustomerBuilder();
    }

    @Test
    void shouldBuildACostumerFromValidJson() throws JsonProcessingException {
        validJson = "{\"latitude\": \"54.080556\", \"user_id\": 23, \"name\": \"Eoin Gallagher\", \"longitude\": \"-6.361944\"}";

        Customer customer = customerBuilder.build(validJson);
        assertNotNull(customer);
        assertEquals(23, customer.id);
        assertEquals("Eoin Gallagher", customer.name);
        assertEquals(54.080556, customer.latitude);
        assertEquals(-6.361944, customer.longitude);

        assertNotNull(customer.distance);
    }

    @Test
    void whenInvalidJson_shouldThrowJsonProcessingException() {
        assertThrows(JsonProcessingException.class, () -> {
            customerBuilder.build("{asdasd: asdasd");
        });
    }

    @Test
    void whenReceivingAList_shouldReturnAListOfCustomers() throws JsonProcessingException {
        List<String> listOfJsons = new ArrayList<>();
        listOfJsons.add("{\"latitude\": \"54.1225\", \"user_id\": 27, \"name\": \"Enid Gallagher\", \"longitude\": \"-8.143333\"}");
        listOfJsons.add("{\"latitude\": \"52.240382\", \"user_id\": 10, \"name\": \"Georgina Gallagher\", \"longitude\": \"-6.972413\"}");

        List<Customer> customers = customerBuilder.buildFromList(listOfJsons);

        assertNotNull(customers);
        assertEquals(2, customers.size());
    }

    @Test
    void whenInvalidJsonList_shouldThrowJsonProcessingException() {
        assertThrows(JsonProcessingException.class, () -> {
            List<String> listOfJsons = new ArrayList<>();
            listOfJsons.add("{\"latitude\": \"54.1225\", \"user_id\": 27, \"name\": \"Enid Gallagher\", \"longitude\": \"-");
            listOfJsons.add("{\"latitude");

            List<Customer> customers = customerBuilder.buildFromList(listOfJsons);
        });
    }
}