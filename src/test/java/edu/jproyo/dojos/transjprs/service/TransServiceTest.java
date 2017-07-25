package edu.jproyo.dojos.transjprs.service;

import static org.junit.Assert.*;

import org.junit.Test;

import edu.jproyo.dojos.transjprs.model.RoutePath;
import edu.jproyo.dojos.transjprs.utils.DataLoader;

public class TransServiceTest {

	@Test
	public void testCalculateDistanceNoRoute() {
		StateResult result = TransService.create()
				.withRoutes(DataLoader.defaultRoutes())
				.build()
				.calculateDistance(RoutePath.as("A","E","D"))
				.collect();
		assertNotNull(result);
		assertEquals(StateResult.NO_SUCH_ROUTE, result.toString()); 
	}

	@Test
	public void testCalculateDistanceSomeRoute() {
		StateResult result = TransService.create()
				.withRoutes(DataLoader.defaultRoutes())
				.build()
				.calculateDistance(RoutePath.as("A","B","C"))
				.collect();
		assertNotNull(result);
		assertEquals("9", result.toString()); 
	}
}
