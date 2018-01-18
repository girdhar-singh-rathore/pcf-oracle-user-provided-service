package com.tech.repository;
import org.springframework.data.repository.CrudRepository;

import com.tech.domain.Customer;
public interface CustomerRepository extends CrudRepository<Customer, Long> {
}