package com.prueba.altia.mapper;

import com.prueba.altia.domain.Product;
import com.prueba.altia.model.ProductResponse;
import com.prueba.altia.repository.entities.ProductEntity;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

/**
 * Class to mapping object Product Response
 */
@Mapper(componentModel = "spring", unmappedSourcePolicy = ReportingPolicy.WARN)
public interface ProductResponseMapper {

    /**
     * Mapping to ProductResponse
     *
     * @param entity object entity
     * @return ProductResponse entity
     */
    ProductResponse toApi(Product entity);
}
