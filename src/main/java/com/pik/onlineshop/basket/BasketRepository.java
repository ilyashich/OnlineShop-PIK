package com.pik.onlineshop.basket;

import com.pik.onlineshop.customer.Customer;
import com.pik.onlineshop.product.Product;
import org.springframework.data.repository.query.Param;
import org.springframework.data.neo4j.repository.query.Query;
import org.springframework.data.neo4j.repository.Neo4jRepository;

import java.time.LocalDate;
import java.util.List;

interface BasketRepository extends Neo4jRepository<Basket, Integer> {
}
