package com.pik.onlineshop.product;

import org.springframework.data.repository.query.Param;
import org.springframework.data.neo4j.repository.query.Query;
import org.springframework.data.neo4j.repository.Neo4jRepository;

import java.util.List;

interface ProductRepository extends Neo4jRepository<Product, String> {
    @Query("MATCH (product:Product) WHERE product.category = $category RETURN product")
    List<Product> findInCategory(@Param("category") String category);

    @Query("MATCH (customer:Customer {name: $customerLogin})-[:CURRENT]->(basket:Basket)<--(commonProduct:Product)" +
            "   -[r]->(commonBasket:Basket)<-[:BOUGHT]-(:Customer)\n" +
            "MATCH (commonBasket)<--(recommendedProduct:Product)\n" +
            "WHERE NOT (recommendedProduct)-->()<--(customer)\n" +
            "WITH recommendedProduct, commonBasket, count(r) AS recommendationStrength\n" +
            "WITH DISTINCT recommendedProduct, MAX(recommendationStrength) AS recommendationStrength\n" +
            "RETURN recommendedProduct, recommendationStrength")
    List<Product> getRecommendations(@Param("customerLogin") String customerLogin);
}


