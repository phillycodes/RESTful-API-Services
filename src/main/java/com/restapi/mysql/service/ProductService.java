package com.restapi.mysql.service;

import com.restapi.mysql.model.Product;
import com.restapi.mysql.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cache.annotation.Caching;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    /* Make sure you specify your caching annotations in a layer that is common to all of your clients. Like a service layer
     * If response is present in the cache it is returned directly, the code is not executed
     * on the first run or after the cache is cleared, the code in method will be executed and the response will be cached in the products cache */
    @Cacheable("products")
    public List<Product> getAllProducts() {
        List<Product> products = new ArrayList<>();
        try {
            Thread.sleep(3000); // makes the normal execution run for at least 3 seconds
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        productRepository.findAll().forEach(products::add);

        return products;
    }

    /* Specify a key to store the response, p0 means the first input argument to this method, which is the ID of the product
     * The response will be stored in the cache keyed by the ID of the product,
     * Key helps distinguish between the products like 4 and 7 */
    @Cacheable(value = "product", key = "#p0")
    public Optional<Product> getProduct(Long id) {
        try {
            Thread.sleep(3000); // makes the normal execution run for at least 3 seconds
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        return productRepository.findById(id);
    }

    /* This will ensure that when we add a product, the cache with the name products
     * is cleared to allow the new list of products to be visible the
     * next time products are retrieved
     */
    @CacheEvict(value = "products", allEntries = true)
    public void addProduct(Product product){
        try {
            Thread.sleep(3000); // makes the normal execution run for at least 3 seconds
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        productRepository.save(product);
    }

    /*
    * This custom cache Evict Annotation allows for both caches to be evicted once the method has been called.
    * Doing so
     */
    @Caching(evict = {
            @CacheEvict(value="product", key="#p0"),
            @CacheEvict(value="products", allEntries=true)})
    public void updateProduct(Long id, Product product) {
        try {

            Thread.sleep(3000);

        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        if (productRepository.findById(id).get() != null) {
            productRepository.save(product);
        }
    }

    @Caching(evict = {
            @CacheEvict(value = "product", key="#p0"),
            @CacheEvict(value = "products", allEntries = true)})
    public void deleteProduct(Long id) {
        try {
            Thread.sleep(3000); // makes the normal execution run for at least 3 seconds
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        productRepository.deleteById(id);
    }
}
