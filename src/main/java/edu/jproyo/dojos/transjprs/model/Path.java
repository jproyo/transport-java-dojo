package edu.jproyo.dojos.transjprs.model;

import java.util.LinkedList;
import java.util.stream.Collectors;

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
		boolean equals = true;
		for (int i = 0; i < this.path.size() && equals; i++) {
			equals = this.path.get(i).equals(other.path.get(i));
		}
		return equals;
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((path == null) ? 0 : path.stream().map(Object::hashCode).collect(Collectors.summingInt(Integer::intValue)));
		return result;
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
	 * Size.
	 *
	 * @return the integer
	 */
	public Integer size(){
		return this.path.size();
	}

	/**
	 * Gets the first.
	 *
	 * @return the first
	 */
	public Route getFirst() {
		return this.path.getFirst();
	}

}
