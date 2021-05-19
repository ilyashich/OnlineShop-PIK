package com.pik.onlineshop.product;

import org.neo4j.driver.Driver;
import org.neo4j.driver.Session;
import org.neo4j.driver.SessionConfig;
import org.neo4j.driver.Value;
import org.neo4j.driver.types.TypeSystem;
import org.springframework.data.neo4j.core.DatabaseSelectionProvider;
import org.springframework.data.neo4j.core.Neo4jClient;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Michael Hunger
 * @author Mark Angrish
 * @author Jennifer Reif
 * @author Michael J. Simons
 */
@Service
public class ProductService {

    private final ProductRepository productRepository;

    private final Neo4jClient neo4jClient;

    private final Driver driver;

    private final DatabaseSelectionProvider databaseSelectionProvider;

    ProductService(ProductRepository productRepository,
                   Neo4jClient neo4jClient,
                   Driver driver,
                   DatabaseSelectionProvider databaseSelectionProvider) {

        this.productRepository = productRepository;
        this.neo4jClient = neo4jClient;
        this.driver = driver;
        this.databaseSelectionProvider = databaseSelectionProvider;
    }

    private Session sessionFor(String database) {
        if (database == null) {
            return driver.session();
        }
        return driver.session(SessionConfig.forDatabase(database));
    }

    private String database() {
        return databaseSelectionProvider.getDatabaseSelection().getValue();
    }

    public List<Product> getAllProducts() {
        return this.productRepository.findall();
    }
}