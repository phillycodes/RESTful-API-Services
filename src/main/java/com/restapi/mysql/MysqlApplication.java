package com.restapi.mysql;

import com.restapi.mysql.model.Product;
import com.restapi.mysql.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching // Must be added to enable the use of caching in the application.
public class MysqlApplication implements CommandLineRunner {

	@Autowired
	private ProductRepository productRepository;

	public static void main(String[] args) {
		SpringApplication.run(MysqlApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		productRepository.save(new Product("Television", "Electronics"));
		productRepository.save(new Product("Air Conditioner", "Electronics"));
		productRepository.save(new Product("Sofa", "Furniture"));
		productRepository.save(new Product("Cushions", "Home Essentials"));
		productRepository.save(new Product("Wardrobe", "Furniture"));
	}



}
