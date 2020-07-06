package com.lucassouza;

import com.lucassouza.customer.Customer;
import com.lucassouza.customer.CustomerBuilder;
import com.lucassouza.customer.CustomerFilter;

import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class Application {

    private static final CustomerBuilder customerBuilder = new CustomerBuilder();
    private static final CustomerFilter customerFilter = new CustomerFilter();

    public static void main(String[] args) {
        try {
            URL resource = Application.class.getClassLoader().getResource("customers.txt");
            List<String> allLines = Files.readAllLines(Paths.get(resource.toURI()));

            List<Customer> customers = customerBuilder.buildFromList(allLines);

            customerFilter.getCustomersNearDublin(customers)
                    .forEach(System.out::println);

//            for(String line: allLines) {
//                System.out.println(line);
//            }

        } catch (IOException | URISyntaxException e) {
            e.printStackTrace();
        }
    }

}