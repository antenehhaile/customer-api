package com.customer.api.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.solr.repository.Query;
import org.springframework.data.solr.repository.SolrCrudRepository;

import com.customer.api.models.Customer;

public interface CustomerRepository extends SolrCrudRepository<Customer, Integer> {
    Customer findCustomerById(String id);
    
    @Query("cname:*?0* OR cstreetAddress:*?0* OR cCity:*?0* OR cState:*?0* OR cCountry:*?0* cZipCode:*?0*")
    Page<Customer> findCustomerByQuery(String searchTerm, Pageable pageable);
}