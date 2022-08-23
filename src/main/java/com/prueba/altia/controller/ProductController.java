package com.prueba.altia.controller;

import com.prueba.altia.api.ProductsApi;
import com.prueba.altia.domain.Product;
import com.prueba.altia.mapper.ProductResponseMapper;
import com.prueba.altia.model.ProductResponse;
import com.prueba.altia.service.ProductService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

/**
 * Product Controller. Operations for products
 */
@Slf4j
@RestController
@AllArgsConstructor
public class ProductController implements ProductsApi {

    /**
     * Product Service
     */
    @Autowired
    private ProductService productService;

    /**
     * Product mapper
     */
    @Autowired
    private ProductResponseMapper mapper;

    /**
     * Endpoint to find products
     *
     * @param applicationDate Application date (yyyy-MM-dd HH:mm:ss) (required)
     * @param productId Product indentifier (required)
     * @param brandId Brand identifier requiered (required)
     * @return
     */
    @Override
    public ResponseEntity<ProductResponse> getProducts(String applicationDate, String productId, String brandId) {
        log.info("Start getProducts endpoint");
        Product product = productService.getProduct(brandId, productId, applicationDate);
        return new ResponseEntity<>(mapper.toApi(product), HttpStatus.OK);
    }
}

