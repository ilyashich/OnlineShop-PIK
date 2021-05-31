package com.pik.onlineshop.basket;

import com.pik.onlineshop.customer.Customer;
import com.pik.onlineshop.product.Product;
import org.springframework.data.repository.query.Param;
import org.springframework.data.neo4j.repository.query.Query;
import org.springframework.data.neo4j.repository.Neo4jRepository;

import java.time.LocalDate;
import java.util.List;

interface BasketRepository extends Neo4jRepository<Basket, Integer> {
    @Query("MATCH (:Customer)-[:CURRENT]->(basket:Basket)\n" +
            "OPTIONAL MATCH (basket)<-[r:IN]-(products:Product)\n" +
            "RETURN DISTINCT basket, collect(r), collect(products)")
    List<Basket> findAllCurrent();

    @Query("MATCH (:Customer)-[:BOUGHT]->(basket:Basket)\n" +
            "OPTIONAL MATCH (basket)<-[r:IN]-(products:Product)\n" +
            "RETURN DISTINCT basket, collect(r), collect(products)")
    List<Basket> findAllBought();

    @Query("MATCH (customer:Customer)\n" +
            "WHERE customer.login = $customerLogin\n" +
            "MERGE (customer)-[:CURRENT]->(basket:Basket)\n" +
            "ON CREATE\n" +
            "   SET basket.id = id(basket)\n" +
            "WITH basket\n" +
            "OPTIONAL MATCH (basket)<-[r:IN]-(product:Product)\n" +
            "RETURN basket, collect(r), collect(product) AS products")
    List<Basket> showBasket(@Param("customerLogin") String customerLogin);

    @Query("MATCH (customer:Customer)-[:CURRENT]->(basket:Basket)\n" +
            "WHERE customer.login = $customerLogin\n" +
            "MATCH (product:Product)\n" +
            "WHERE product.name = $productName\n" +
            "WITH basket, product\n" +
            "MERGE (basket)<-[r:IN]-(product)\n" +
            "ON CREATE\n" +
            "   SET r.amount = 1\n" +
            "ON MATCH\n" +
            "   SET r.amount = r.amount + 1\n" +
            "WITH basket\n" +
            "OPTIONAL MATCH (basket)<-[r:IN]-(product:Product)\n" +
            "RETURN basket, collect(r), collect(product) AS products")
    List<Basket> addProduct(@Param("customerLogin") String customerLogin, @Param("productName") String productName);

    @Query("MATCH (customer:Customer)-[:CURRENT]->(basket:Basket)\n" +
            "WHERE customer.login = $customerLogin\n" +
            "MATCH (product:Product)\n" +
            "WHERE product.name = $productName\n" +
            "WITH basket, product\n" +
            "MATCH (basket)<-[r:IN]-(product) \n" +
            "DELETE r\n" +
            "WITH basket\n" +
            "OPTIONAL MATCH (basket)<-[r:IN]-(product:Product)\n" +
            "RETURN basket, collect(r), collect(product) AS products")
    List<Basket> deleteProduct(@Param("customerLogin") String customerLogin, @Param("productName") String productName);

    @Query("MATCH (customer:Customer {login: $customerLogin})-[r:CURRENT]->(basket:Basket)<-[:IN]-(:Product)\n" +
            "CREATE (customer)-[r2:BOUGHT]->(basket)\n" +
            "SET basket.date = datetime()\n" +
            "CREATE (customer)-[:CURRENT]->(:Basket)\n" +
            "SET r2 = r\n" +
            "WITH r, basket\n" +
            "DELETE r\n" +
            "WITH basket\n" +
            "OPTIONAL MATCH (basket)<-[r:IN]-(product:Product)\n" +
            "RETURN basket, collect(r), collect(product) AS products")
    List<Basket> buyBasket(@Param("customerLogin") String customerLogin);
}

