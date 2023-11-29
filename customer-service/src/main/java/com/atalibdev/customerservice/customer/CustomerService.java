package com.atalibdev.customerservice.customer;

import java.util.List;

public interface CustomerService {
    Customer registerCustomer(Customer customer);
    List<Customer> customers();
}
