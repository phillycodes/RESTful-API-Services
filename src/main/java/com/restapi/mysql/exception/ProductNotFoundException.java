package com.restapi.mysql.exception;

public class ProductNotFoundException extends RuntimeException {
    private static final long serialVersionUID = 1L;

    public ProductNotFoundException(Long id) {
        super("The product with ID: " + id + " cannot be found!");
    }
}
