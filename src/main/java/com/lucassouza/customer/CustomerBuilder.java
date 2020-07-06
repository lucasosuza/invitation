package com.lucassouza.customer;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.lucassouza.distance.DistanceCalculator;

import java.util.ArrayList;
import java.util.List;

public class CustomerBuilder {

    private final ObjectMapper mapper;
    private final DistanceCalculator distanceCalculator;

    public CustomerBuilder() {
        this.mapper = new ObjectMapper();
        this.distanceCalculator = new DistanceCalculator();
    }

    public Customer build(String json) throws JsonProcessingException {
        Customer customer = mapper.readValue(json, Customer.class);
        customer.distance = distanceCalculator.toDublin(customer.latitude, customer.longitude);

        return customer;
    }

    public List<Customer> buildFromList(List<String> listOfJsons) throws JsonProcessingException {
        List<Customer> customers = new ArrayList<>();

        for (String line : listOfJsons) {
            customers.add(this.build(line));
        }

        return customers;
    }
}
