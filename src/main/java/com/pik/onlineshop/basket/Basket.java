package com.pik.onlineshop.basket;

import com.pik.onlineshop.customer.Customer;
import com.pik.onlineshop.product.Product;
import org.springframework.data.annotation.Id;
import org.springframework.data.neo4j.core.schema.Node;
import org.springframework.data.neo4j.core.schema.Relationship;

import java.time.ZonedDateTime;
import java.util.HashSet;
import java.util.Set;

@Node
public class Basket {
    @Id
    private final Integer id;
    private final ZonedDateTime date;

    @Relationship(type = "IN", direction = Relationship.Direction.INCOMING)
    private Set<Product> products = new HashSet<>();

    @Relationship(type = "CURRENT", direction = Relationship.Direction.INCOMING)
    private Customer customerCurrent;

    @Relationship(type = "BOUGHT", direction = Relationship.Direction.INCOMING)
    private Customer customerBought;

    public Basket(Integer id, ZonedDateTime date) {
        this.id = id;
        this.date = date;
    }

    public Integer getId() {
        return id;
    }

    public ZonedDateTime getDate() {
        return date;
    }

    public Set<Product> getProducts() {
        return products;
    }

//    Commented to avoid infinite loop between customers and baskets
//    public Customer getCustomer() {
//        if (customerBought == null)
//            return customerCurrent;
//        return customerBought;
//    }
}
