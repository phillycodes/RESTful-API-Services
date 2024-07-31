package com.restapi.mysql.repository;

import com.restapi.mysql.model.Product;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository // Spring managed component for data access . This will be used to access data from an underlying database table
public interface ProductRepository extends CrudRepository<Product, Long> { // CRUDRepo expose create, read, update, delete operations
                                                                          //  for the Product entity with a Long primary key
    // Because of Spring Data. You do not have to express the implementation yourself
    // You can utilize findByID(), findAll(), save(), saveAll(), delete(), deleteAll(), existsById() and MORE!
}
