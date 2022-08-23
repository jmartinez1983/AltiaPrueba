package com.prueba.altia.dao;

import com.prueba.altia.domain.Product;

/**
 * Interface product service dao
 */
public interface ProductServiceDao {

    /**
     * Obtain Product from brandId, productId and applicationDate between start date and date order by priority
     *
     * @param brandId - Brand Id
     * @param productId - Product Id
     * @param applicationDate - Application date
     * @return : Product
     */
    Product getProductsBy(String brandId, String productId, String applicationDate);
}
