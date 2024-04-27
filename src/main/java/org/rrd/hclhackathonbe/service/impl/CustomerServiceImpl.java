package org.rrd.hclhackathonbe.service.impl;

import org.apache.velocity.exception.ResourceNotFoundException;
import org.rrd.hclhackathonbe.dao.CustomerRepository;
import org.rrd.hclhackathonbe.domain.Customer;
import org.rrd.hclhackathonbe.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    private final CustomerRepository customerRepository;

    public CustomerServiceImpl(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @Override
    public Customer getCustomerById(String customerId) {
        return customerRepository.findById(Long.valueOf(customerId))
                .orElseThrow(() -> new ResourceNotFoundException("Customer not found with id: " + customerId));
    }

    @Override
    public List<Customer> getAllCustomers() {
        return customerRepository.findAll();
    }

    @Override
    public Customer createCustomer(Customer customer) {
        // Implement validation or other business logic if necessary
        return customerRepository.save(customer);
    }

    @Override
    public Customer updateCustomer(String customerId, Customer customer) {
        Customer existingCustomer = getCustomerById(customerId);
        // Update existingCustomer with customer data
        // Implement validation or other business logic if necessary
        return customerRepository.save(existingCustomer);
    }

    @Override
    public void deleteCustomer(String customerId) {
        Customer existingCustomer = getCustomerById(customerId);
        customerRepository.delete(existingCustomer);
    }

}
