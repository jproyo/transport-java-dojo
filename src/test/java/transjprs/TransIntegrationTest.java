package transjprs;

import static org.junit.Assert.*;

import org.junit.Test;

public class TransIntegrationTest {

	@Test
	public void testInputOutputSuccessfully() {
		StateResult result = TransService.create()
			.calculateDistance(Route.as("A","B","C"))
			.calculateDistance(Route.as("A","D"))
			.calculateDistance(Route.as("A","D","C"))
			.calculateDistance(Route.as("A","E","B","C","D"))
			.calculateDistance(Route.as("A","E","D"))
			.numberOfTrips(StartPoint.as("C"), FinishPoint.as("C"), Stops.atLeast(3))
			.numberOfTrips(StartPoint.as("A"), FinishPoint.as("C"), Stops.exactly(4))
			.shortestRouteLength("A", "C")
			.shortestRouteLength("B", "B")
			.numberOfRoutes(StartPoint.as("C"), FinishPoint.as("C"), Distance.less(30))
			.collect();
		assertNotNull(result);
	}

}
