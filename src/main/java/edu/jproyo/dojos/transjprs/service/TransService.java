package edu.jproyo.dojos.transjprs.service;

import java.util.Set;

import edu.jproyo.dojos.transjprs.model.Graph;
import edu.jproyo.dojos.transjprs.model.Route;
import edu.jproyo.dojos.transjprs.model.RoutePath;
import edu.jproyo.dojos.transjprs.model.StopsCondition;

/**
 * The Class TransService.
 */
public class TransService {

	/** The routes. */
	private Graph graph;
	
	/** The result. */
	private StateResult result = new StateResult();

	
	/**
	 * Sets the graph.
	 *
	 * @param graph the new graph
	 */
	public void setGraph(Graph graph) {
		this.graph = graph;
	}
	
	/**
	 * Gets the graph.
	 *
	 * @return the graph
	 */
	public Graph getGraph() {
		return graph;
	}
	

	/**
	 * Calculate distance.
	 *
	 * @param route the route
	 * @return the trans service
	 */
	public TransService calculateDistance(RoutePath route) {
		String resultMessage = route.getSegments().flatMap(s -> graph.distanceTo(s)).map(Object::toString).orElse(StateResult.NO_SUCH_ROUTE);
		result.add(resultMessage);
		return this;
	}

	/**
	 * Number of trips.
	 *
	 * @param start the start
	 * @param finish the finish
	 * @param condition the condition
	 * @return the trans service
	 */
	public TransService numberOfTrips(String start, String finish, StopsCondition condition) {
		Integer number = graph.numberOfTrips(start, finish, condition);
		result.add(number.toString());
		return this;
	}

	/**
	 * Shortest route length.
	 *
	 * @param route the route
	 * @return the trans service
	 */
	public TransService shortestRouteLength(String start, String finish) {
		String number = graph.shortestRoute(start, finish).map(Object::toString).orElse(StateResult.NO_SUCH_ROUTE);
		result.add(number);
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
	public TransService numberOfRoutes(String start, String finish, StopsCondition distanceLess) {
		return this;
	}
	
	/**
	 * Validate.
	 */
	public void validate() {
		if(graph == null) throw new IllegalStateException("No Routes Provided");
		graph.validate();
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
		 * @param routes the default rules
		 * @return the builder
		 */
		public Builder withRoutes(Set<Route> routes) {			
			this.target.graph = Graph.fromRoutes(routes);
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
		return this.result;
	}


}
