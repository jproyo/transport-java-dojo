package edu.jproyo.dojos.transjprs.service;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;

import edu.jproyo.dojos.transjprs.model.Point;
import edu.jproyo.dojos.transjprs.model.RoutePath;
import edu.jproyo.dojos.transjprs.model.StopsCondition;
import edu.jproyo.dojos.transjprs.utils.DataLoader;

/**
 * The Class TransIntegrationTest.
 */
public class TransIntegrationTest {
	
	@Test(expected = IllegalStateException.class)
	public void testInputOutputFailNoRoutesProvided() {
		TransService.create().build();
	}

	@Test(expected = IllegalStateException.class)
	public void testInputOutputFailNoRoutesProvidedNullSet() {
		TransService.create().withRoutes(null).build();
	}

	/**
	 * Test input output successfully.
	 */
	@Test
	public void testInputOutputSuccessfully() {
		StateResult result = TransService.create()
										.withRoutes(DataLoader.defaultRoutes())
										.build()
				.calculateDistance(RoutePath.as("A","B","C"))
				.calculateDistance(RoutePath.as("A","D"))
				.calculateDistance(RoutePath.as("A","D","C"))
				.calculateDistance(RoutePath.as("A","E","B","C","D"))
				.calculateDistance(RoutePath.as("A","E","D"))
				.numberOfTrips("C", "C", StopsCondition.atLeast(3))
				.numberOfTrips(Point.start("A"), Point.finish("C"), StopsCondition.exactly(4))
				.shortestRouteLength(RoutePath.as("A", "C"))
				.shortestRouteLength(RoutePath.as("B", "B"))
				.numberOfRoutes(Point.start("C"), Point.finish("C"), StopsCondition.distanceLess(30))
				.collect();
		assertNotNull(result);
	}

}
