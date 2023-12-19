package com.atalibdev.customerservice.customer;

import com.atalibdev.customerservice.exception.CustomerNotFoundException;
import com.atalibdev.customerservice.exception.DuplicationResourceException;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/customers")
@RequiredArgsConstructor
public class CustomerController {

    private final CustomerService customerService;

    @GetMapping
    public ResponseEntity<List<Customer>> fetchCustomers() {
        List<Customer> customerList =
                customerService.customers();
        return new ResponseEntity<>(customerList, HttpStatus.OK);
    }

    @GetMapping("/{customerId}")
    public ResponseEntity<Customer> getSingleCustomer(@PathVariable("customerId") Long customerId) throws CustomerNotFoundException {
        Customer customer = customerService.findCustomer(customerId);
        return new ResponseEntity<>(customer, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Customer> registerCustomer(@RequestBody Customer customer) throws DuplicationResourceException {
        Customer register = customerService.registerCustomer(customer);
        return new ResponseEntity<>(register, HttpStatus.CREATED);
    }
}
