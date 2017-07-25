package edu.jproyo.dojos.transjprs.service;

import java.util.Set;

import edu.jproyo.dojos.transjprs.model.Point;
import edu.jproyo.dojos.transjprs.model.Route;
import edu.jproyo.dojos.transjprs.model.StopsCondition;

/**
 * The Class TransService.
 */
public class TransService {

	/** The routes. */
	public Set<Route> routes;

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
	public TransService calculateDistance(Route route) {
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
	public TransService shortestRouteLength(Route route) {
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
