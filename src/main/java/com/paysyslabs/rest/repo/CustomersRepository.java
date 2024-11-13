package com.paysyslabs.rest.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.paysyslabs.rest.entity.Customers;

@Repository
public interface CustomersRepository extends JpaRepository<Customers, Long> {

	Customers findByIban(String iban);
}
