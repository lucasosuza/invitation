package com.lucassouza.customer;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CustomerFilterTest {

    @Test
    void getCustomersNearDublin() {
        List<Customer> customers = new ArrayList<>();
        Customer customerA = new Customer();
        customerA.id = 2;
        customerA.distance = 20;

        Customer customerB = new Customer();
        customerB.id = 5;
        customerB.distance = 90;

        Customer customerC = new Customer();
        customerC.id = 1;
        customerC.distance = 200;

        customers.add(customerA);
        customers.add(customerB);
        customers.add(customerC);

        CustomerFilter filter = new CustomerFilter();
        List<Customer> customerFiltered = filter.getCustomersNearDublin(customers);

        assertEquals(2, customerFiltered.size());
        assertEquals(2, customerFiltered.get(0).id);
        assertEquals(5, customerFiltered.get(1).id);
    }
}