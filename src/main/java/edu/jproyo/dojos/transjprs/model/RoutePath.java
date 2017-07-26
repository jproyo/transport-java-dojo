package edu.jproyo.dojos.transjprs.model;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * The Class RoutePath.
 */
public class RoutePath {
	
	/** The route path. */
	private LinkedList<String> routePath = new LinkedList<>();

	/**
	 * Gets the route path.
	 *
	 * @return the route path
	 */
	public LinkedList<String> getRoutePath() {
		return routePath;
	}

	/**
	 * Sets the route path.
	 *
	 * @param routePath the new route path
	 */
	public void setRoutePath(LinkedList<String> routePath) {
		this.routePath = routePath;
	}
	
	
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return this.routePath.stream().collect(Collectors.joining());
	}

	/**
	 * As.
	 *
	 * @param cities the cities
	 * @return the route path
	 */
	public static RoutePath as(String ...cities) {
		RoutePath path = new RoutePath();
		path.routePath.addAll(Arrays.asList(cities));
		return path;
	}

	/**
	 * Gets the segments.
	 *
	 * @return the segments
	 */
	public Optional<Set<Route>> getSegments() {
		if(routePath == null || routePath.isEmpty()) return Optional.empty();
		Iterator<String> iterator = routePath.iterator();
		Set<Route> routes = new LinkedHashSet<>();
		String first = iterator.next();
		while(iterator.hasNext()){
			String elem = iterator.next();
			routes.add(Route.as(first, elem, 0));
			first = elem;
		}
		return Optional.ofNullable(routes);
	}

	/**
	 * Gets the stops.
	 *
	 * @return the stops
	 */
	public Integer getStops() {
		return routePath.size() - 1;
	}
	
	/**
	 * All posible paths.
	 *
	 * @param routes the routes
	 * @return the list
	 */
	public static Map<Route, Set<Route>> allPosiblePaths(Set<Route> routes) {
		Map<Route, Set<Route>> newGroup = new HashMap<>();
		routes.forEach(r -> {
			Set<Route> routeLinked = new HashSet<>();
			routeLinked.add(r);
			newGroup.put(r, routeLinked);
		});
		newGroup.forEach((k,v) -> {
			Set<Route> routesWithoutKey = routes.stream().filter(r -> !r.equals(k)).collect(Collectors.toSet());
			v.addAll(collectAllRoutes(routesWithoutKey, k));
		});
		return newGroup;
	}


	private static Set<Route> collectAllRoutes(Set<Route> routesWithoutKey, Route key) {
		Set<Route> routes = new HashSet<>();
		routesWithoutKey.stream().filter(r -> r.getFrom().equals(key.getTo())).forEach(routes::add);
		Set<Set<Route>> collect = routes.stream().map(k -> collectAllRoutes(routesWithoutKey.stream().filter(r -> !r.equals(k)).collect(Collectors.toSet()), k)).collect(Collectors.toSet());
		collect.forEach(routes::addAll);
		return routes;
	}
	
}
