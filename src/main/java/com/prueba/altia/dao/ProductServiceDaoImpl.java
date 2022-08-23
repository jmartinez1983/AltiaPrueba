package com.prueba.altia.dao;

import com.prueba.altia.domain.Product;
import com.prueba.altia.mapper.ProductMapper;
import com.prueba.altia.repository.ProductRepository;
import com.prueba.altia.repository.entities.ProductEntity;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * Product service Dao
 */
@Slf4j
@Component
@AllArgsConstructor
public class ProductServiceDaoImpl implements ProductServiceDao{

    /**
     * DateTime formatter
     */
    private static final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

    /**
     * Product repository
     */
    private ProductRepository productRepository;

    /**
     * Product mapper
     */
    private ProductMapper mapper;

    /**
     * Obtain product from table products
     *
     * @param brandId - Brand Id
     * @param productId - Product Id
     * @param applicationDate - Application date
     * @return
     */
    @Override
    public Product getProductsBy(String brandId, String productId, String applicationDate) {
        LocalDateTime dateTime = LocalDateTime.parse(applicationDate, formatter);
        ProductEntity entity = productRepository.findByBrandIdAndProductIdAndDate(brandId,productId, dateTime);
        log.info(String.format("Product response id: %s", entity.getId()));
        return mapper.toDomain(entity);
    }
}
