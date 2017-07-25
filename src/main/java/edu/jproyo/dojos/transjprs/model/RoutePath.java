package edu.jproyo.dojos.transjprs.model;

import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.Optional;
import java.util.Set;

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

}
