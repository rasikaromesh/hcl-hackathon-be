package org.rrd.hclhackathonbe.service;

import org.rrd.hclhackathonbe.domain.Customer;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public interface CustomerService {

    Customer getCustomerById(String customerId);
    List<Customer> getAllCustomers();
    Customer createCustomer(Customer customer);
    Customer updateCustomer(String customerId, Customer customer);
    void deleteCustomer(String customerId);
}
