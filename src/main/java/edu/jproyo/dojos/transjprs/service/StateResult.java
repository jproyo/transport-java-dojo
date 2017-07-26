package edu.jproyo.dojos.transjprs.service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * The Class StateResult.
 */
public class StateResult {

	/** The Constant NO_SUCH_ROUTE. */
	public static final String NO_SUCH_ROUTE = "NO SUCH ROUTE";

	/** The results. */
	private List<String> results = new ArrayList<>();
	

	/**
	 * Adds the.
	 *
	 * @param result the result
	 */
	public void add(String result) {
		this.results.add(result);
	}
	
	/**
	 * Gets the results.
	 *
	 * @return the results
	 */
	public List<String> getResults() {
		return results;
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return results.stream().collect(Collectors.joining("\n"));
	}

}
