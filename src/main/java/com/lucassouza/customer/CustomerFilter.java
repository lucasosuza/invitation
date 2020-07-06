package com.lucassouza.customer;

import com.lucassouza.distance.DistanceCalculator;

import java.util.List;
import java.util.stream.Collectors;

public class CustomerFilter {

    public List<Customer> getCustomersNearDublin(List<Customer> customers) {
        return customers.stream()
                .filter(
                        customer -> DistanceCalculator.lessThan100Km(customer.distance))
                .sorted()
                .collect(Collectors.toList());
    }
}
