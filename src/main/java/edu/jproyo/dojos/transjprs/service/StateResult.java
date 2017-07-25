package edu.jproyo.dojos.transjprs.service;

import java.util.ArrayList;
import java.util.List;

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

}
