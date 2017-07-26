package edu.jproyo.dojos.transjprs.model;

import java.util.AbstractMap;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * The Class Graph.
 */
public class Graph {
	
	/** The routes. */
	private Map<String, Set<Route>> routes = new HashMap<>();
	
	/** The raw routes. */
	private Set<Route> rawRoutes = new HashSet<>();
	
	/**
	 * Gets the raw routes.
	 *
	 * @return the raw routes
	 */
	public Set<Route> getRawRoutes() {
		return rawRoutes;
	}
	
	/**
	 * Sets the raw routes.
	 *
	 * @param rawRoutes the new raw routes
	 */
	public void setRawRoutes(Set<Route> rawRoutes) {
		this.rawRoutes = rawRoutes;
	}

	/**
	 * Gets the routes.
	 *
	 * @return the routes
	 */
	public Map<String, Set<Route>> getRoutes() {
		return routes;
	}

	/**
	 * Sets the routes.
	 *
	 * @param routes the routes
	 */
	public void setRoutes(Map<String, Set<Route>> routes) {
		this.routes = routes;
	}

	/**
	 * Validate.
	 */
	public void validate() {
		if(routes == null || routes.isEmpty()) throw new RuntimeException("Routes must have a list one segment");
	}

	/**
	 * From routes.
	 *
	 * @param routes the routes
	 * @return the graph
	 */
	public static Graph fromRoutes(Set<Route> routes) {
		Graph graph = new Graph();
		graph.rawRoutes  = routes;
		graph.routes = Optional.ofNullable(routes).map(rs -> rs.stream().collect(Collectors.groupingBy(Route::getFrom, Collectors.toSet()))).orElse(new HashMap<>());
		return graph;
	}

	/**
	 * Distance to.
	 *
	 * @param segments the segments
	 * @return the optional
	 */
	public Optional<Integer> distanceTo(Set<Route> segments) {
		if(getRawRoutes().containsAll(segments)){
			return Optional.ofNullable(segments.stream()
					.map(seg -> new AbstractMap.SimpleEntry<Route,Set<Route>>(seg, routes.get(seg.getFrom())))
					.flatMap(e -> e.getValue().stream().filter(r -> r.equals(e.getKey())))
					.collect(Collectors.summingInt(Route::getWeight)).intValue());
		}else{
			return Optional.empty();
		}
	}

}
