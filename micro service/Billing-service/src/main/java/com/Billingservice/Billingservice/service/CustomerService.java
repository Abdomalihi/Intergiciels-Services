package com.Billingservice.Billingservice.service;

import com.Billingservice.Billingservice.model.Customer;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name="CUSTOMER-SERVICE")
public interface CustomerService{
    @GetMapping("/customers/{id}?projection=fullCustomer")
    public Customer findCustomerById(@PathVariable(name="id") Long id);
}
