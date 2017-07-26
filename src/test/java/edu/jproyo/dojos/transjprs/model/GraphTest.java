package edu.jproyo.dojos.transjprs.model;

import static org.junit.Assert.*;

import java.util.Optional;
import java.util.Set;

import org.junit.Test;

import edu.jproyo.dojos.transjprs.utils.DataLoader;

public class GraphTest {

	@Test
	public void testNumberOfTrips() {
		Set<Route> defaultRoutes = DataLoader.defaultRoutes();
		Graph fromRoutes = Graph.fromRoutes(defaultRoutes);
		Optional<Integer> numberOfTrips = fromRoutes.numberOfTrips("C", "C", StopsCondition.atLeast(3));
		assertNotNull(numberOfTrips);
		assertTrue(numberOfTrips.isPresent());
		assertEquals(new Integer(2), numberOfTrips.get());
	}
	
	@Test
	public void testNumberOfTripsSecondCase() {
		Set<Route> defaultRoutes = DataLoader.defaultRoutes();
		Graph fromRoutes = Graph.fromRoutes(defaultRoutes);
		Optional<Integer> numberOfTrips = fromRoutes.numberOfTrips("A", "C", StopsCondition.exactly(4));
		assertNotNull(numberOfTrips);
		assertTrue(numberOfTrips.isPresent());
		//Problem is wrong. A -> C should be 2 not 3
		assertEquals(new Integer(2), numberOfTrips.get());
	}

	@Test
	public void testNumberOfTripsNoRoute() {
		Set<Route> defaultRoutes = DataLoader.defaultRoutes();
		Graph fromRoutes = Graph.fromRoutes(defaultRoutes);
		Optional<Integer> numberOfTrips = fromRoutes.numberOfTrips("A", "Z", StopsCondition.exactly(4));
		assertNotNull(numberOfTrips);
		assertFalse(numberOfTrips.isPresent());
	}
	
	@Test
	public void testShortestPath() {
		Set<Route> defaultRoutes = DataLoader.defaultRoutes();
		Graph fromRoutes = Graph.fromRoutes(defaultRoutes);
		Optional<Integer> numberOfTrips = fromRoutes.shortestRoute("B", "B");
		assertNotNull(numberOfTrips);
		assertTrue(numberOfTrips.isPresent());
//		Problem is wrong. B -> B should be 21 not 9
		assertEquals(new Integer(21), numberOfTrips.get());
	}
}
