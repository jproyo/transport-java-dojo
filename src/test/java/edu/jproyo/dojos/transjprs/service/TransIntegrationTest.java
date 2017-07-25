package edu.jproyo.dojos.transjprs.service;

import static org.junit.Assert.assertNotNull;

import java.util.Set;

import org.junit.Test;

import edu.jproyo.dojos.transjprs.model.Point;
import edu.jproyo.dojos.transjprs.model.Route;
import edu.jproyo.dojos.transjprs.model.StopsCondition;

public class TransIntegrationTest {

	@Test
	public void testInputOutputSuccessfully() {
		StateResult result = TransService.create()
										.withRoutes(defaultRoutes())
										.build()
				.calculateDistance(Route.as("A","B","C"))
				.calculateDistance(Route.as("A","D"))
				.calculateDistance(Route.as("A","D","C"))
				.calculateDistance(Route.as("A","E","B","C","D"))
				.calculateDistance(Route.as("A","E","D"))
				.numberOfTrips(Point.start("C"), Point.finish("C"), StopsCondition.atLeast(3))
				.numberOfTrips(Point.start("A"), Point.finish("C"), StopsCondition.exactly(4))
				.shortestRouteLength(Route.as("A", "C"))
				.shortestRouteLength(Route.as("B", "B"))
				.numberOfRoutes(Point.start("C"), Point.finish("C"), StopsCondition.distanceLess(30))
				.collect();
		assertNotNull(result);
	}

	private Set<Route> defaultRoutes() {
		// TODO Auto-generated method stub
		return null;
	}

}
