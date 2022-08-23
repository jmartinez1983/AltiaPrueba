package com.prueba.altia.service;

import com.prueba.altia.dao.ProductServiceDao;
import com.prueba.altia.domain.Product;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

/**
 * Product Service
 */
@Component
@AllArgsConstructor
public class ProductServiceImpl implements ProductService {

    /**
     * Product Service Dao
     */
    private ProductServiceDao productServiceDao;

    /**
     * Obtain product from table products
     *
     * @param brandId Brand identifier
     * @param productId Product identifier
     * @param applicationDate Application date
     * @return  product
     */
    @Override
    public Product getProduct(String brandId, String productId, String applicationDate) {
        return productServiceDao.getProductsBy(brandId,productId,applicationDate);
    }
}
