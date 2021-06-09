package com.pik.onlineshop.product;

import com.pik.onlineshop.basket.Basket;
import org.springframework.data.neo4j.core.schema.Id;
import org.springframework.data.neo4j.core.schema.Node;
import org.springframework.data.neo4j.core.schema.Relationship;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Node
public class Product {
    @Id
    private final String name;
    private final String category;

    @Relationship(type = "IN", direction = Relationship.Direction.OUTGOING)
    private Set<Basket> baskets = new HashSet<>();

    public Product(String name, String category) {
        this.name = name;
        this.category = category;
    }

    public String getName() {
        return name;
    }

    public String getCategory() {
        return category;
    }

//    Commented to avoid infinite loop between products and baskets
//    public Set<Basket> getBaskets() {
//        return baskets;
//    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return Objects.equals(name, product.name) && Objects.equals(category, product.category) && Objects.equals(baskets, product.baskets);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, category, baskets);
    }
}

