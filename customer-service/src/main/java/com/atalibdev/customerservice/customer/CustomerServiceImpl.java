package com.atalibdev.customerservice.customer;

import com.atalibdev.customerservice.exception.CustomerNotFoundException;
import com.atalibdev.customerservice.exception.DuplicationResourceException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CustomerServiceImpl implements CustomerService {

    private final CustomerRepository customerRepository;

    public CustomerServiceImpl(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @Override
    public Customer registerCustomer(Customer customer) throws DuplicationResourceException {
        Optional<Customer> existingCustomer = customerRepository
                .findByEmail(customer.getEmail());
        if (existingCustomer.isPresent())
            throw new DuplicationResourceException(
                    "Customer with the given email: [%s] taken".formatted(customer.getEmail())
            );
        return customerRepository.save(customer);
    }

    @Override
    public List<Customer> customers() {
        return customerRepository.findAll();
    }

    @Override
    public Customer findCustomer(Long customerId) throws CustomerNotFoundException {
        return customerRepository.findById(customerId)
                .orElseThrow(() -> new CustomerNotFoundException(
                        "Customer with the given id: [%s] not found.".formatted(customerId)
                ));
    }
}
