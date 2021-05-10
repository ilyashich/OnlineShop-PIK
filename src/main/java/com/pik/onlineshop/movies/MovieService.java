package com.pik.onlineshop.movies;

import org.neo4j.driver.*;
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
public class MovieService {

	private final MovieRepository movieRepository;

	private final Neo4jClient neo4jClient;

	private final Driver driver;

	private final DatabaseSelectionProvider databaseSelectionProvider;

	MovieService(MovieRepository movieRepository,
				 Neo4jClient neo4jClient,
				 Driver driver,
				 DatabaseSelectionProvider databaseSelectionProvider) {

		this.movieRepository = movieRepository;
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

	public String test() {
		List<Record> records;
		try (Session session = sessionFor(database())) {
			String result;
			records = session.readTransaction(tx -> tx.run(
					"MATCH (n:Movie) RETURN n.title"
			).list());
			for (Record record : records) {
				return record.toString();
				//System.out.println(record.toString());
			}
		}
		return "test";
	}
}
