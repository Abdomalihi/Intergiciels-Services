package com.Billingservice.Billingservice.repository;

import com.Billingservice.Billingservice.model.Bill;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface BillRepository extends JpaRepository<Bill,Long> {}
