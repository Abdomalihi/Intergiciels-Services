package com.Billingservice.Billingservice;

import com.Billingservice.Billingservice.model.Bill;
import com.Billingservice.Billingservice.model.Customer;
import com.Billingservice.Billingservice.model.Product;
import com.Billingservice.Billingservice.model.ProductItem;
import com.Billingservice.Billingservice.repository.BillRepository;
import com.Billingservice.Billingservice.repository.ProductItemRepository;
import com.Billingservice.Billingservice.service.CustomerService;
import com.Billingservice.Billingservice.service.InventoryService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;
import org.springframework.hateoas.PagedModel;

import java.util.Date;

@SpringBootApplication
@EnableFeignClients
public class BillingServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(BillingServiceApplication.class, args);
	}

	@Bean
	CommandLineRunner start(BillRepository billRepository, ProductItemRepository productItemRepository, CustomerService customerService , InventoryService inventoryService, RepositoryRestConfiguration config){
		config.exposeIdsFor(Bill.class);
		Customer c1 = customerService.findCustomerById(1L);
		System.out.println("****************************");
		System.out.println("ID = " + c1.getId());
		System.out.println("Name = " + c1.getName());
		System.out.println("Email  = " + c1.getEmail());
		System.out.println("****************************");

		return args ->{
			Bill bill1 = billRepository.save(new Bill(null, new Date(),c1.getId(),null,null));
			PagedModel<Product> products = inventoryService.findAll();
			products.getContent().forEach(
					p->{
						productItemRepository.save(new ProductItem(null,p.getId(),p.getPrice(),30,null,bill1));
					}
			);
			/**
			Product p1 = inventoryService.findProductById(1L);
			System.out.println("****************************");
			System.out.println("ID = " + p1.getId());
			System.out.println("Name = " + p1.getName());
			System.out.println("Price  = " + p1.getPrice());
			System.out.println("****************************");
			productItemRepository.save(new ProductItem(null,p1.getId(),p1.getPrice(),30,bill1));
			Product p2 = inventoryService.findProductById(2L);
			productItemRepository.save(new ProductItem(null,p2.getId(),p2.getPrice(),30,bill1));
			Product p3 = inventoryService.findProductById(3L);
			productItemRepository.save(new ProductItem(null,p3.getId(),p3.getPrice(),30,bill1));
			**/
		};
	}
}
