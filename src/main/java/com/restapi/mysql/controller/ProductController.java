package com.restapi.mysql.controller;

import java.util.List;

import com.restapi.mysql.exception.ProductNotFoundException;
import com.restapi.mysql.model.Product;
import com.restapi.mysql.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping("/products")
    public List<Product> getAllProducts() {

        return productService.getAllProducts();
    }

    @GetMapping("/products/{pId}")
    public Product getProduct(@PathVariable("pId") Long id) {

        return productService.getProduct(id).orElseThrow(()-> new ProductNotFoundException(id));
    }

    @PostMapping("/products")
    public void addProduct(@RequestBody Product product) {
        productService.addProduct(product);
    }

    @PutMapping("products/{pId}")
    public void updateProduct(@RequestBody Product product, @PathVariable("pId") Long id) {

        productService.updateProduct(id, product);
    }

    @DeleteMapping("/products/{pId}")
    public void deleteProduct(@PathVariable("pId")  Long id) {
        productService.deleteProduct(id);
    }
}