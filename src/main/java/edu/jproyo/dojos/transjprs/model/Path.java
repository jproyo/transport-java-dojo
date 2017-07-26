package edu.jproyo.dojos.transjprs.model;

import java.util.LinkedList;

/**
 * The Class Path.
 */
public class Path {
	
	/** The path. */
	private LinkedList<Route> path = new LinkedList<>();

	/**
	 * Gets the path.
	 *
	 * @return the path
	 */
	public LinkedList<Route> getPath() {
		return path;
	}

	/**
	 * Sets the path.
	 *
	 * @param path the new path
	 */
	public void setPath(LinkedList<Route> path) {
		this.path = path;
	}

	
	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if(this == obj) return true;
		if(!(obj instanceof Path)) return false;
		Path other = (Path)obj;
		return this.path.stream().allMatch(elem -> other.path.contains(elem));
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return this.path.toString();
	}

	/**
	 * Adds the.
	 *
	 * @param start the start
	 */
	public void add(Route start) {
		this.path.add(start);
	}

	/**
	 * Checks if is last to equal.
	 *
	 * @param from the from
	 * @return true, if is last to equal
	 */
	public boolean isLastToEqual(String from) {
		return this.path.getLast().getTo().equals(from);
	}

	/**
	 * Make new.
	 *
	 * @return the path
	 */
	public Path makeNew() {
		Path path = new Path();
		path.getPath().addAll(this.path);
		return path;
	}

	/**
	 * Removes the last.
	 */
	public void removeLast() {
		this.path.removeLast();
	}

	/**
	 * Contains.
	 *
	 * @param route the route
	 * @return true, if successful
	 */
	public boolean contains(Route route) {
		return this.path.contains(route);
	}

	/**
	 * Finish with.
	 *
	 * @param finish the finish
	 * @param condition the condition
	 * @return true, if successful
	 */
	public boolean finishWith(String finish, StopsCondition condition) {
		int count = 0;
		boolean found = false;
		for (Route route : path) {
			count++;
			if(route.getTo().equals(finish)){
				if(condition.applyCondition(count)){
					found = true;
					break;
				}
			}
		}
		return condition.applyCondition(count) && found;
	}

}
