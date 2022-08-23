package com.prueba.altia.mapper;

import com.prueba.altia.domain.Product;
import com.prueba.altia.repository.entities.ProductEntity;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

/**
 * Class to mapping object Product
 */
@Mapper(componentModel = "spring", unmappedSourcePolicy = ReportingPolicy.WARN)
public interface ProductMapper {

    /**
     * Mapping from entity to domain
     *
     * @param entity Entity object
     * @return product
     */
    Product toDomain(ProductEntity entity);
}
