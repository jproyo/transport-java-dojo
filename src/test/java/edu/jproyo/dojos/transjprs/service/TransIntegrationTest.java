package edu.jproyo.dojos.transjprs.service;

import static org.junit.Assert.assertNotNull;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;
import java.util.function.Supplier;

import org.junit.Test;

import edu.jproyo.dojos.transjprs.model.Point;
import edu.jproyo.dojos.transjprs.model.Route;
import edu.jproyo.dojos.transjprs.model.RoutePath;
import edu.jproyo.dojos.transjprs.model.StopsCondition;

/**
 * The Class TransIntegrationTest.
 */
public class TransIntegrationTest {

	/**
	 * Test input output successfully.
	 */
	@Test
	public void testInputOutputSuccessfully() {
		StateResult result = TransService.create()
										.withRoutes(defaultRoutes())
										.build()
				.calculateDistance(RoutePath.as("A","B","C"))
				.calculateDistance(RoutePath.as("A","D"))
				.calculateDistance(RoutePath.as("A","D","C"))
				.calculateDistance(RoutePath.as("A","E","B","C","D"))
				.calculateDistance(RoutePath.as("A","E","D"))
				.numberOfTrips(Point.start("C"), Point.finish("C"), StopsCondition.atLeast(3))
				.numberOfTrips(Point.start("A"), Point.finish("C"), StopsCondition.exactly(4))
				.shortestRouteLength(RoutePath.as("A", "C"))
				.shortestRouteLength(RoutePath.as("B", "B"))
				.numberOfRoutes(Point.start("C"), Point.finish("C"), StopsCondition.distanceLess(30))
				.collect();
		assertNotNull(result);
	}

	/**
	 * Default routes.
	 *
	 * @return the sets the
	 */
	private Set<Route> defaultRoutes() {
		Set<Route> routes = new HashSet<>();
		String routesUnparsed = "AB5,BC4,CD8,DC8,DE6,AD5,CE2,EB3,AE7";
		Arrays.stream(routesUnparsed.split(",")).forEach(c -> routes.add(Route.as(c).orElseThrow(() -> new RuntimeException("Error parsing value "+c))));
		return routes;
	}

}
