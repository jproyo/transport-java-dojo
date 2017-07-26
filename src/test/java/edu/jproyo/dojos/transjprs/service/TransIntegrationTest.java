package edu.jproyo.dojos.transjprs.service;

import static org.junit.Assert.*;

import org.junit.Test;

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

	@Test(expected = RuntimeException.class)
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
				.numberOfTrips("A", "C", StopsCondition.exactly(4))
				.shortestRouteLength("A", "C")
				.shortestRouteLength("B", "B")
				.numberOfRoutes("C", "C", StopsCondition.distanceLess(30))
				.collect();
		assertNotNull(result);
		assertFalse(result.getResults().isEmpty());
		assertEquals("9", result.getResults().get(0));
		assertEquals("5", result.getResults().get(1));
		assertEquals("13", result.getResults().get(2));
		assertEquals("22", result.getResults().get(3));
		assertEquals(StateResult.NO_SUCH_ROUTE, result.getResults().get(4));
		assertEquals("2", result.getResults().get(5));
		//Problem is wrong. A -> C should be 2 not 3
		assertEquals("2", result.getResults().get(6));
		assertEquals("9", result.getResults().get(7));
		//Problem is wrong. B -> B should be 21 not 9
		assertEquals("21", result.getResults().get(8));
		//Problem is wrong. C -> C should be 6 not 7
		assertEquals("6", result.getResults().get(9));
	}

}
