package com.restapi.mysql;

import com.restapi.mysql.model.Product;
import com.restapi.mysql.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
/* Author: Philben Pierre
* Date: 07/31/2024
* Description: Springboot projected created connected to connect a Web UI (Thymeleaf) to a MySQL database.
* The Application can perform CRUD operations and store items within a cache. Springboot annotation to highlight: @CacheEvict, @Caching.
 */

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
