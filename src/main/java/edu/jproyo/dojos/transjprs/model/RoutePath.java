package edu.jproyo.dojos.transjprs.model;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * The Class RoutePath.
 */
public class RoutePath {
	
	/** The route path. */
	private List<String> routePath = new LinkedList<>();

	/**
	 * Gets the route path.
	 *
	 * @return the route path
	 */
	public List<String> getRoutePath() {
		return routePath;
	}

	/**
	 * Sets the route path.
	 *
	 * @param routePath the new route path
	 */
	public void setRoutePath(List<String> routePath) {
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
		Arrays.stream(cities).forEach(path.routePath::add);
		return path;
	}

}
