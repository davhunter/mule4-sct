package com.deloitte.sct.datadrivers;

import java.util.ArrayList;
import java.util.List;

import com.deloitte.sct.datamodel.Movie;
import com.deloitte.sct.datamodel.TestRun;

/**
 * Used to generate data, for use in the program. Some of these methods would
 * normally be performed by selecting data from a DB (or similar activities),
 * while others simply provide data to drive the tester. This would class would
 * go away if the original developer could think of a way to generate this
 * hard-coded data in DataWeave.
 * 
 * @author davhunter
 *
 */
public class DataGenerator {

	/**
	 * Hard-coded rating to use for all movies
	 */
	private static final String MOVIE_RATING = "R";

	/**
	 * Hard-coded duration to use for all movies
	 */
	private static final String MOVIE_DURATION = "1h30m";

	/**
	 * Hard-coded name to use for all movies
	 */
	private static final String MOVIE_NAME = "The Matrix";

	/**
	 * Returns a list of objects.
	 * 
	 * @param numRecords Number of objects to be created in the list
	 * @return List of objects
	 */
	static public List<Movie> generateMovies(int numRecords) {
		List<Movie> movies = new ArrayList<Movie>();
		for (int i = 0; i < numRecords; i++) {
			movies.add(new Movie(MOVIE_NAME, MOVIE_DURATION, MOVIE_RATING));
		}

		return movies;
	}

	/**
	 * Generates a set of objects (number specified by <code>numIterations</code>)
	 * that can be used by the test driver; it simply iterates over each of these
	 * objects to call the test API.
	 * 
	 * @param numIterations Number of iterations of the test that should be run --
	 *                      in other words, the number of objects that shoudl be
	 *                      returned in the list
	 * @param numRecords    Number of records to use in the test. Not used by the
	 *                      test driver, but used in the test API
	 * @param testType      One of the pre-defined tests to perform (string
	 *                      concatenation, StringBuffer, DTL, ...)
	 * @return List of {@link com.deloitte.sct.datamodel.TestRun TestRun} objects
	 */
	static public List<TestRun> generateTestRuns(int numIterations, int numRecords, String testType) {
		List<TestRun> tests = new ArrayList<TestRun>();

		for (int i = 0; i < numIterations; i++) {
			tests.add(new TestRun(numRecords, testType));
		}

		return tests;
	}
}
