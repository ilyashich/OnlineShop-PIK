package com.pik.onlineshop.customer;

import com.pik.onlineshop.product.Product;
import com.pik.onlineshop.user.User;
import org.springframework.data.repository.query.Param;
import org.springframework.data.neo4j.repository.query.Query;
import org.springframework.data.neo4j.repository.Neo4jRepository;

import java.util.List;

public interface CustomerRepository extends Neo4jRepository<Customer, String> {
    @Query("MERGE (customer:Customer {login: $login})\n" +
            "MERGE (customer)-[:CURRENT]->(basket:Basket)\n" +
            "ON CREATE\n" +
            "   SET basket.id = id(basket)")
    void addCustomer(@Param("login") String login);
}

