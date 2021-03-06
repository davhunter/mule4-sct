package com.deloitte.sct.datadrivers;

import java.util.ArrayList;
import java.util.List;

import com.deloitte.sct.datamodel.Movie;
import com.deloitte.sct.datamodel.ShowTime;
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
	 * Hard-coded start times for showtimes
	 */
	private static final String FIRST_START_TIME = "13:15";
	private static final String SECOND_START_TIME = "15:30";
	private static final String THIRD_START_TIME = "18:45";

	/**
	 * Hard-coded names of theatres for showtimes
	 */
	private static final String FIRST_THEATRE_NAME = "Cineplex Cinemas Scotiabank Theatre";
	private static final String SECOND_THEATRE_NAME = "Cineplex Cinemas Scotiabank Theatre";
	private static final String THIRD_THEATRE_NAME = "Cineplex Cinemas Scotiabank Theatre";

	/**
	 * Hard-coded values for "VIP available" for showtimes
	 */
	private static final boolean FIRST_VIP_AVAILABLE = true;
	private static final boolean SECOND_VIP_AVAILABLE = false;
	private static final boolean THIRD_VIP_AVAILABLE = true;

	/**
	 * Returns a list of objects.
	 * 
	 * @param numRecords Number of objects to be created in the list
	 * @return List of objects
	 */
	static public List<Movie> generateMovies(int numRecords) {
		List<Movie> movies = new ArrayList<Movie>();
		for (int i = 0; i < numRecords; i++) {
			movies.add(new Movie(MOVIE_NAME, MOVIE_DURATION, MOVIE_RATING, generateShowtimes()));
		}

		return movies;
	}

	/**
	 * Helper method for generating a few ShowTime objects
	 * 
	 * @return List of ShowTime objects
	 */
	static private List<ShowTime> generateShowtimes() {
		List<ShowTime> showtimes = new ArrayList<ShowTime>();

		showtimes.add(new ShowTime(FIRST_START_TIME, FIRST_THEATRE_NAME, FIRST_VIP_AVAILABLE));
		showtimes.add(new ShowTime(SECOND_START_TIME, SECOND_THEATRE_NAME, SECOND_VIP_AVAILABLE));
		showtimes.add(new ShowTime(THIRD_START_TIME, THIRD_THEATRE_NAME, THIRD_VIP_AVAILABLE));

		return showtimes;
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

	/**
	 * Returns the server's time (nanoseconds), in a more precise way than MuleSoft
	 * does with <code>now().nanoseconds</code>
	 * 
	 * @return Current server time in nanoseconds
	 */
	static public long getNanoTime() {
		return System.nanoTime();
	}
}
