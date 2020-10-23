package Inventory.Inventoryservice;

import Inventory.Inventoryservice.model.Product;
import Inventory.Inventoryservice.repository.ProductRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;

@SpringBootApplication
public class InventoryServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(InventoryServiceApplication.class, args);
	}

	@Bean
	CommandLineRunner start(ProductRepository productRepository, RepositoryRestConfiguration config) {
		return args -> {
			config.exposeIdsFor(Product.class);
			productRepository.save(new Product(null, "Computer Desk Top HP", 900));
			productRepository.save(new Product(null, "Printer Epson", 80));
			productRepository.save(new Product(null, "MacBook Pro Lap Top", 1800));
			productRepository.findAll().forEach(System.out::println);
		};
	}
}
