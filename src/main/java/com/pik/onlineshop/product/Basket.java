package com.pik.onlineshop.product;

import org.springframework.data.annotation.Id;
import org.springframework.data.neo4j.core.schema.Node;

@Node
public class Basket {
    @Id
    private final Integer id;

    public Basket(Integer id) {
        this.id = id;
    }
}
