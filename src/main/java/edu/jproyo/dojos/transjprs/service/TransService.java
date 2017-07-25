package edu.jproyo.dojos.transjprs.service;

import java.util.Set;

import edu.jproyo.dojos.transjprs.model.Distance;
import edu.jproyo.dojos.transjprs.model.FinishPoint;
import edu.jproyo.dojos.transjprs.model.Route;
import edu.jproyo.dojos.transjprs.model.StartPoint;
import edu.jproyo.dojos.transjprs.model.Stops;

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
	

	public TransService calculateDistance(Route route) {
		return this;
	}

	public TransService numberOfTrips(StartPoint start, FinishPoint finish, Stops atLeast) {
		return null;
	}

	public TransService shortestRouteLength(Route route) {
		return null;
	}

	public TransService numberOfRoutes(StartPoint start, FinishPoint finish, Distance distance) {
		return null;
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

	public StateResult collect() {
		// TODO Auto-generated method stub
		return null;
	}


}
