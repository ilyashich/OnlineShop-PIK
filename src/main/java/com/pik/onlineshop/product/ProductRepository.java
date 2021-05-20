package com.pik.onlineshop.product;

import org.springframework.data.neo4j.repository.query.Query;
import org.springframework.data.repository.Repository;

import java.util.List;

interface ProductRepository extends Repository<Product, String> {

    @Query("MATCH (product:Product) RETURN product")
    List<Product> findall();
}
