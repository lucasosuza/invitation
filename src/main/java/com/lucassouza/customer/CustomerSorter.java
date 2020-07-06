package com.lucassouza.customer;

import java.util.Collections;
import java.util.List;

public class CustomerSorter {

    List<Customer> customers;

    public CustomerSorter(List<Customer> customers) {
        this.customers = customers;
    }

    public List<Customer> getCustomersSorted() {
        Collections.sort(customers);
        return customers;
    }

}
