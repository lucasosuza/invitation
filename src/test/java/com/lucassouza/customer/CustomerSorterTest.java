package com.lucassouza.customer;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CustomerSorterTest {

    @Test
    void shoudSorteASimpleCustomerList() {
        List<Customer> customers = new ArrayList<>();
        Customer customerA = new Customer();
        customerA.id = 2;

        Customer customerB = new Customer();
        customerB.id = 5;

        Customer customerC = new Customer();
        customerC.id = 1;

        customers.add(customerA);
        customers.add(customerB);
        customers.add(customerC);

        CustomerSorter sorter = new CustomerSorter(customers);
        List<Customer> customersSorted = sorter.getCustomersSorted();

        assertEquals(1, customersSorted.get(0).id);
        assertEquals(2, customersSorted.get(1).id);
        assertEquals(5, customersSorted.get(2).id);

    }
}