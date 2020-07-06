package com.lucassouza;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.lucassouza.customer.Customer;
import com.lucassouza.customer.CustomerBuilder;
import com.lucassouza.customer.CustomerFilter;

import java.util.List;

public class InvitationService {

    private final CustomerBuilder customerBuilder;
    private final CustomerFilter customerFilter;

    public InvitationService() {
        this.customerBuilder = new CustomerBuilder();
        this.customerFilter = new CustomerFilter();
    }

    public List<Customer> getInvitations(List<String> allLines) throws JsonProcessingException {
        List<Customer> customers = customerBuilder.buildFromList(allLines);
        return customerFilter.getCustomersNearDublin(customers);
    }
}
