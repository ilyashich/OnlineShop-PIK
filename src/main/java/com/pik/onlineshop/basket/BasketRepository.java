package com.pik.onlineshop.basket;

import com.pik.onlineshop.customer.Customer;
import com.pik.onlineshop.product.Product;
import org.springframework.data.repository.query.Param;
import org.springframework.data.neo4j.repository.query.Query;
import org.springframework.data.neo4j.repository.Neo4jRepository;

import java.time.LocalDate;
import java.util.List;

interface BasketRepository extends Neo4jRepository<Basket, Integer> {
    @Query("MATCH (customer:Customer)-[:CURRENT]->(basket:Basket) WHERE customer.login = $customerLogin RETURN basket")
    // TODO: Create basket if doesn't exist
    Basket showBasket(@Param("customerLogin") String customerLogin);

    @Query("MATCH (customer:Customer)-[:CURRENT]->(basket:Basket)\n" +
            "WHERE customer.login = $customerLogin\n" +
            "MATCH (product:Product)\n" +
            "WHERE product.name = $productName\n" +
            "WITH basket, product\n" +
            "CREATE (basket)<-[:IN {amount: 1}]-(product) \n" +
            "RETURN basket")
    Basket addProduct(@Param("customerLogin") String customerLogin, @Param("productName") String productName);

    @Query("MATCH (customer:Customer)-[:CURRENT]->(basket:Basket)\n" +
            "WHERE customer.login = $customerLogin\n" +
            "MATCH (product:Product)\n" +
            "WHERE product.name = $productName\n" +
            "WITH basket, product\n" +
            "MATCH (basket)<-[r:IN]-(product) \n" +
            "DELETE r\n" +
            "RETURN basket")
    Basket deleteProduct(@Param("customerLogin") String customerLogin, @Param("productName") String productName);
}

