package com.pik.onlineshop.customer;

import org.springframework.data.annotation.Id;
import org.springframework.data.neo4j.core.schema.Node;

import java.util.Objects;

@Node
public class Customer {
    @Id
    private final String login;
    private final String name;

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