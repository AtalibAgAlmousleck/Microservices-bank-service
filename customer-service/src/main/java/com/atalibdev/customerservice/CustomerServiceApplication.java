package com.atalibdev.customerservice;

import com.atalibdev.customerservice.customer.Customer;
import com.atalibdev.customerservice.customer.CustomerRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class CustomerServiceApplication {
    public static void main(String[] args) {
        SpringApplication.run(CustomerServiceApplication.class, args);
    }

    @Bean
    CommandLineRunner run(CustomerRepository customerRepository) {
        return args -> {
            List<Customer> customerList = List.of(
                    Customer.builder()
                            .firstName("Almousleck")
                            .lastName("Atalib Ag")
                            .email("almousleck@gmail.com")
                            .build(),
                    Customer.builder()
                            .firstName("Ousmane")
                            .lastName("Sangary")
                            .email("sangary.com")
                            .build()
            );
            customerRepository.saveAll(customerList);
        };
    }
}
