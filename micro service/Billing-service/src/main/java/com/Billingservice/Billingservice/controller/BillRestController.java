package com.Billingservice.Billingservice.controller;

import com.Billingservice.Billingservice.model.Bill;
import com.Billingservice.Billingservice.repository.BillRepository;
import com.Billingservice.Billingservice.repository.ProductItemRepository;
import com.Billingservice.Billingservice.service.CustomerService;
import com.Billingservice.Billingservice.service.InventoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BillRestController {
    @Autowired
    private BillRepository billRepository;
    @Autowired
    private ProductItemRepository productItemRepository;
    @Autowired
    private CustomerService customerService;
    @Autowired
    private InventoryService inventoryService;

    @GetMapping("/fullBill/{id}")
    public Bill getBill(@PathVariable(name="id") Long id){
        Bill bill = billRepository.findById(id).get();
        bill.setCustomer(customerService.findCustomerById(bill.getCustomerID()));
        bill.getProductItems().forEach(p->{
            p.setProduct(inventoryService.findProductById(p.getProductID()));
        });

        return bill;
    }

}
