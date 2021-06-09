package com.pik.onlineshop.customer;

import org.springframework.data.neo4j.repository.Neo4jRepository;


interface CustomerRepository extends Neo4jRepository<Customer, String> {
}

