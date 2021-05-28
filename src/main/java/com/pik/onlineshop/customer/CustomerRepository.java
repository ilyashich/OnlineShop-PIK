package com.pik.onlineshop.customer;

import com.pik.onlineshop.product.Product;
import org.springframework.data.repository.query.Param;
import org.springframework.data.neo4j.repository.query.Query;
import org.springframework.data.neo4j.repository.Neo4jRepository;

import java.util.List;

interface CustomerRepository extends Neo4jRepository<Customer, String> {
}

