package com.pik.onlineshop.basket;

import com.pik.onlineshop.customer.Customer;
import com.pik.onlineshop.product.Product;
import org.springframework.data.annotation.Id;
import org.springframework.data.neo4j.core.schema.Node;
import org.springframework.data.neo4j.core.schema.Relationship;

import java.time.ZonedDateTime;
import java.util.List;

@Node
public class Basket {
    @Id
    private final Integer id;
    private final ZonedDateTime date;
    @Relationship(type = "IN", direction = Relationship.Direction.INCOMING)
    private List<Product> products;

    public Basket(Integer id, ZonedDateTime date, List<Product> products) {
        this.id = id;
        this.date = date;
        this.products = products;
    }

    public Integer getId() {
        return id;
    }

    public ZonedDateTime getDate() {
        return date;
    }

    public List<Product> getProducts() {
        return products;
    }

}
