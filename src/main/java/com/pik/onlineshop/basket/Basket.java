package com.pik.onlineshop.basket;

import org.springframework.data.annotation.Id;
import org.springframework.data.neo4j.core.schema.Node;

import java.time.ZonedDateTime;

@Node
public class Basket {
    @Id
    private final Integer id;
    private final ZonedDateTime date;

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
}
