package InventoryService.InventoryService;

import InventoryService.InventoryService.entities.Product;
import InventoryService.InventoryService.repository.ProductRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class InventoryServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(InventoryServiceApplication.class, args);
	}

	@Bean
	CommandLineRunner start(ProductRepository productRepository){
		return args -> {
			productRepository.save(new Product(null,"Computer",900));
			productRepository.save(new Product(null,"Printer",9000));
			productRepository.save(new Product(null,"MacBook",1800));
		};
	}
}
