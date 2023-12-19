package com.atalibdev.customerservice.customer;

import com.atalibdev.customerservice.exception.CustomerNotFoundException;
import com.atalibdev.customerservice.exception.DuplicationResource;

import java.util.List;

public interface CustomerService {
    Customer registerCustomer(Customer customer) throws DuplicationResource;
    List<Customer> customers();
    Customer findCustomer(Long customerId) throws CustomerNotFoundException;
}
