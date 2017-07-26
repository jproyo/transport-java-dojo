package edu.jproyo.dojos.transjprs.model;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.Set;

import org.junit.Test;

import edu.jproyo.dojos.transjprs.utils.DataLoader;

public class GraphTest {

	@Test
	public void testNumberOfTrips() {
		Set<Route> defaultRoutes = DataLoader.defaultRoutes();
		Graph fromRoutes = Graph.fromRoutes(defaultRoutes);
		Integer numberOfTrips = fromRoutes.numberOfTrips("C", "C", StopsCondition.atLeast(3));
		assertNotNull(numberOfTrips);
		assertEquals(new Integer(2), numberOfTrips);
	}
	
	@Test
	public void testNumberOfTripsSecondCase() {
		Set<Route> defaultRoutes = DataLoader.defaultRoutes();
		Graph fromRoutes = Graph.fromRoutes(defaultRoutes);
		Integer numberOfTrips = fromRoutes.numberOfTrips("A", "C", StopsCondition.exactly(4));
		assertNotNull(numberOfTrips);
		assertEquals(new Integer(3), numberOfTrips);
	}

}
