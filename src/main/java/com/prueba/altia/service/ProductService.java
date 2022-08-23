package com.prueba.altia.service;

import com.prueba.altia.domain.Product;

/**
 * Interface with product operations
 */
public interface ProductService {

    /**
     * Obtain product from table products
     *
     * @param brandId Brand identifier
     * @param productId Product identifier
     * @param applicationDate Application date
     * @return product
     */
    Product getProduct(String brandId, String productId, String applicationDate);
}
