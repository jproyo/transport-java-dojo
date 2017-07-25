package edu.jproyo.dojos.transjprs.service;

import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

import edu.jproyo.dojos.transjprs.model.Point;
import edu.jproyo.dojos.transjprs.model.Route;
import edu.jproyo.dojos.transjprs.model.RoutePath;
import edu.jproyo.dojos.transjprs.model.StopsCondition;

/**
 * The Class TransService.
 */
public class TransService {

	/** The routes. */
	private Set<Route> routes;
	
	/** The result. */
	private StateResult result = new StateResult();

	/**
	 * Sets the routes.
	 *
	 * @param routes the new routes
	 */
	public void setRoutes(Set<Route> routes) {
		this.routes = routes;
	}
	
	/**
	 * Gets the routes.
	 *
	 * @return the routes
	 */
	public Set<Route> getRoutes() {
		return routes;
	}
	

	/**
	 * Calculate distance.
	 *
	 * @param route the route
	 * @return the trans service
	 */
	public TransService calculateDistance(RoutePath route) {
		String resultMessage = route.getSegments()
				.flatMap(s ->
					Optional.ofNullable(routes.stream()
					.filter(r -> s.contains(r))
					.collect(Collectors.summingInt(Route::getWeight)).intValue())
				).map(Object::toString).orElse(StateResult.NO_SUCH_ROUTE);
		result.add(resultMessage);
		return this;
	}

	/**
	 * Number of trips.
	 *
	 * @param start the start
	 * @param finish the finish
	 * @param atLeast the at least
	 * @return the trans service
	 */
	public TransService numberOfTrips(Point start, Point finish, StopsCondition atLeast) {
		return this;
	}

	/**
	 * Shortest route length.
	 *
	 * @param route the route
	 * @return the trans service
	 */
	public TransService shortestRouteLength(RoutePath route) {
		return this;
	}

	/**
	 * Number of routes.
	 *
	 * @param start the start
	 * @param finish the finish
	 * @param distanceLess the distance less
	 * @return the trans service
	 */
	public TransService numberOfRoutes(Point start, Point finish, StopsCondition distanceLess) {
		return this;
	}
	
	public void validate() {
		if(routes == null || routes.isEmpty()) throw new IllegalStateException("No Routes Provided");
	}

	/**
	 * Creates the.
	 *
	 * @return the builder
	 */
	public static Builder create() {
		return new Builder();
	}
	
	/**
	 * The Class Builder.
	 */
	public static class Builder {
		
		/** The target. */
		private TransService target = new TransService();

		/**
		 * With routes.
		 *
		 * @param defaultRules the default rules
		 * @return the builder
		 */
		public Builder withRoutes(Set<Route> defaultRules) {
			this.target.routes = defaultRules;
			return this;
		}

		/**
		 * Builds the.
		 *
		 * @return the trans service
		 */
		public TransService build() {
			this.target.validate();
			return this.target;
		}
		
		
	}

	/**
	 * Collect.
	 *
	 * @return the state result
	 */
	public StateResult collect() {
		// TODO Auto-generated method stub
		return null;
	}


}
