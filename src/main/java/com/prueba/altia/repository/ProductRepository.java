package com.prueba.altia.repository;

import com.prueba.altia.repository.entities.ProductEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDateTime;

/**
 * Repository product class
 */
public interface ProductRepository extends JpaRepository<ProductEntity, Long> {

    /**
     * Method to access table products and find ProductEntity
     *
     * @param brandId Brand identifier
     * @param productid Product identifier
     * @param applicationDate Application date
     * @return ProductEntity
     */
    @Query(value = "SELECT TOP 1 * FROM Products WHERE BRAND_ID = ?1 AND PRODUCT_ID = ?2  AND " +
            "START_DATE <= ?3 AND END_DATE >= ?3 ORDER BY priority DESC", nativeQuery = true)
    ProductEntity findByBrandIdAndProductIdAndDate(String brandId, String productid, LocalDateTime applicationDate);

}
