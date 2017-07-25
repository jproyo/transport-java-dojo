package edu.jproyo.dojos.transjprs.service;

import static org.junit.Assert.*;

import java.util.Set;

import org.junit.Test;

import edu.jproyo.dojos.transjprs.model.Distance;
import edu.jproyo.dojos.transjprs.model.FinishPoint;
import edu.jproyo.dojos.transjprs.model.Route;
import edu.jproyo.dojos.transjprs.model.StartPoint;
import edu.jproyo.dojos.transjprs.model.Stops;
import edu.jproyo.dojos.transjprs.service.TransService;

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
				.numberOfTrips(StartPoint.as("C"), FinishPoint.as("C"), Stops.atLeast(3))
				.numberOfTrips(StartPoint.as("A"), FinishPoint.as("C"), Stops.exactly(4))
				.shortestRouteLength(Route.as("A", "C"))
				.shortestRouteLength(Route.as("B", "B"))
				.numberOfRoutes(StartPoint.as("C"), FinishPoint.as("C"), Distance.less(30))
				.collect();
		assertNotNull(result);
	}

	private Set<Route> defaultRoutes() {
		// TODO Auto-generated method stub
		return null;
	}

}
