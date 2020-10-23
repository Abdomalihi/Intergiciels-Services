package com.Billingservice.Billingservice.repository;

import com.Billingservice.Billingservice.model.ProductItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface ProductItemRepository extends
        JpaRepository<ProductItem,Long> {
}
