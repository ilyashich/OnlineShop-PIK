package com.pik.onlineshop.customer;

import com.pik.onlineshop.basket.Basket;
import org.springframework.data.annotation.Id;
import org.springframework.data.neo4j.core.schema.Node;
import org.springframework.data.neo4j.core.schema.Relationship;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Node
public class Customer {
    @Id
    private final String login;
    private final String name;

    @Relationship(type = "CURRENT", direction = Relationship.Direction.OUTGOING)
    private Basket currentBasket;

    @Relationship(type = "BOUGHT", direction = Relationship.Direction.OUTGOING)
    private Set<Basket> boughtBaskets = new HashSet<>();

    public Customer(String login, String name) {
        this.login = login;
        this.name = name;
    }

    public String getLogin() {
        return login;
    }

    public String getName() {
        return name;
    }

    public Basket getCurrentBasket() {
        return currentBasket;
    }

    public Set<Basket> getBoughtBaskets() {
        return boughtBaskets;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Customer customer = (Customer) o;
        return Objects.equals(login, customer.login) && Objects.equals(name, customer.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(login, name);
    }
}