package com.pik.onlineshop.product;

import org.springframework.data.neo4j.repository.query.Query;
import org.springframework.data.neo4j.repository.Neo4jRepository;

import java.util.List;

interface ProductRepository extends Neo4jRepository<Product, String> {

    @Query("MATCH (product:Product) RETURN product")
    List<Product> findall();
}
