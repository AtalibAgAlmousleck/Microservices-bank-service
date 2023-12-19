package com.atalibdev.customerservice.customer;

import com.atalibdev.customerservice.exception.CustomerNotFoundException;
import com.atalibdev.customerservice.exception.DuplicationResourceException;

import java.util.List;

public interface CustomerService {
    Customer registerCustomer(Customer customer) throws DuplicationResourceException;
    List<Customer> customers();
    Customer findCustomer(Long customerId) throws CustomerNotFoundException;
}
