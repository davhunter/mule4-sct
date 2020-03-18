package com.deloitte.sct.transformers;

import java.util.List;

import com.deloitte.sct.datamodel.Movie;
import com.deloitte.sct.datamodel.ShowTime;
import com.deloitte.sct.datamodel.TransformationResult;

/**
 * Contains (static) methods for testing a variety of different modes of
 * transformations:
 * 
 * <ul>
 * <li>String Concatenation: raw concatenation of strings using + and +=</li>
 * <li>The concat() method: Same as the previous, but using the String.concat()
 * method instead of + and +=</li>
 * <li>StringBuffer and StringBuilder: Building the string using these two Java
 * stream-based approaches</li>
 * </ul>
 * 
 * @author davhunter
 *
 */
public class JavaTransformers {

	private static final String SHOWTIME_CLOSE = "</showtime>";
	private static final String VIP_AVAILABLE_CLOSE = "</vipAvailable>";
	private static final String VIP_AVAILABLE_OPEN = "<vipAvailable>";
	private static final String THEATRE_NAME_CLOSE = "</theatreName>";
	private static final String THEATRE_NAME_OPEN = "<theatreName>";
	private static final String START_TIME_CLOSE = "</startTime>";
	private static final String START_TIME_OPEN = "<startTime>";
	private static final String SHOWTIME_OPEN = "<showtime>";
	private static final String RATING_CLOSE = "</rating>";
	private static final String RATING_OPEN = "<rating>";
	private static final String DURATION_CLOSE = "</duration>";
	private static final String DURATION_OPEN = "<duration>";
	private static final String NAME_CLOSE = "</name>";
	private static final String NAME_OPEN = "<name>";
	private static final String MOVIE_CLOSE = "</movie>";
	private static final String MOVIE_OPEN = "<movie>";
	private static final String ROOT_CLOSE = "</movies>";
	private static final String ROOT_OPEN = "<movies>";
	
	private static final String SHOWTIMES_OPEN = "<showtimes>";
	private static final String SHOWTIMES_CLOSE = "</showtimes>";

	/**
	 * Uses straightforward string concatenation to build the XML
	 * 
	 * @param movies List of movies to be transformed
	 * @return A {@link com.deloitte.sct.datamodel.TransformationResult
	 *         TransformationResult} object the XML, and time taken for the
	 *         transformation
	 */
	static public TransformationResult stringConcatenationTransformer(List<Movie> movies) {
		long startTime = System.nanoTime();

		String xmlString = ROOT_OPEN;

		for (Movie m : movies) {
			xmlString += MOVIE_OPEN;
			xmlString += NAME_OPEN + m.getName() + NAME_CLOSE;
			xmlString += DURATION_OPEN + m.getDuration() + DURATION_CLOSE;
			xmlString += RATING_OPEN + m.getRating() + RATING_CLOSE;
			xmlString += SHOWTIMES_OPEN;
			for(ShowTime st : m.getShowtimes()) {
				xmlString += SHOWTIME_OPEN;
				xmlString += START_TIME_OPEN + st.getStartTime() + START_TIME_CLOSE;
				xmlString += THEATRE_NAME_OPEN + st.getTheatreName() + THEATRE_NAME_CLOSE;
				xmlString += VIP_AVAILABLE_OPEN + st.isVipAvailable() + VIP_AVAILABLE_CLOSE;
				xmlString += SHOWTIME_CLOSE;
			}
			xmlString += SHOWTIMES_CLOSE;
			xmlString += MOVIE_CLOSE;
		}

		xmlString += ROOT_CLOSE;

		long endTime = System.nanoTime();

		TransformationResult result = new TransformationResult();
		result.setXmlResult(xmlString);
		result.setTimeInNanos(endTime - startTime);
		result.setTimeInMillis((endTime - startTime) / 1000000);

		return result;
	}

	/**
	 * Uses the String.concat() method to build the string
	 * 
	 * @param movies List of movies to be transformed
	 * @return A {@link com.deloitte.sct.datamodel.TransformationResult
	 *         TransformationResult} object the XML, and time taken for the
	 *         transformation
	 */
	static public TransformationResult concatMethodTransformer(List<Movie> movies) {
		long startTime = System.nanoTime();

		String xmlString = ROOT_OPEN;

		for (Movie m : movies) {
			xmlString = xmlString.concat(MOVIE_OPEN);
			xmlString = xmlString.concat(NAME_OPEN + m.getName() + NAME_CLOSE);
			xmlString = xmlString.concat(DURATION_OPEN + m.getDuration() + DURATION_CLOSE);
			xmlString = xmlString.concat(RATING_OPEN + m.getRating() + RATING_CLOSE);
			xmlString = xmlString.concat(SHOWTIMES_OPEN);
			for(ShowTime st : m.getShowtimes()) {
				xmlString = xmlString.concat(SHOWTIME_OPEN);
				xmlString = xmlString.concat(START_TIME_OPEN + st.getStartTime() + START_TIME_CLOSE);
				xmlString = xmlString.concat(THEATRE_NAME_OPEN + st.getTheatreName() + THEATRE_NAME_CLOSE);
				xmlString = xmlString.concat(VIP_AVAILABLE_OPEN + st.isVipAvailable() + VIP_AVAILABLE_CLOSE);
				xmlString = xmlString.concat(SHOWTIME_CLOSE);
			}
			xmlString = xmlString.concat(SHOWTIMES_CLOSE);
			xmlString = xmlString.concat(MOVIE_CLOSE);
		}

		xmlString = xmlString.concat(ROOT_CLOSE);

		long endTime = System.nanoTime();

		TransformationResult result = new TransformationResult();
		result.setXmlResult(xmlString);
		result.setTimeInNanos(endTime - startTime);
		result.setTimeInMillis((endTime - startTime) / 1000000);

		return result;
	}

	/**
	 * Uses the Java StringBuilder to build the string
	 * 
	 * @param movies List of movies to be transformed
	 * @return A {@link com.deloitte.sct.datamodel.TransformationResult
	 *         TransformationResult} object the XML, and time taken for the
	 *         transformation
	 */
	static public TransformationResult stringBuilderTransformer(List<Movie> movies) {
		long startTime = System.nanoTime();

		StringBuilder xmlString = new StringBuilder();

		xmlString.append(ROOT_OPEN);

		for (Movie m : movies) {
			xmlString.append(MOVIE_OPEN);
			xmlString.append(NAME_OPEN);
			xmlString.append(m.getName());
			xmlString.append(NAME_CLOSE);
			xmlString.append(DURATION_OPEN);
			xmlString.append(m.getDuration());
			xmlString.append(DURATION_CLOSE);
			xmlString.append(RATING_OPEN);
			xmlString.append(m.getRating());
			xmlString.append(RATING_CLOSE);
			xmlString.append(SHOWTIMES_OPEN);
			for(ShowTime st : m.getShowtimes()) {
				xmlString.append(SHOWTIME_OPEN);
				xmlString.append(START_TIME_OPEN);
				xmlString.append(st.getStartTime());
				xmlString.append(START_TIME_CLOSE);
				xmlString.append(THEATRE_NAME_OPEN);
				xmlString.append(st.getTheatreName());
				xmlString.append(THEATRE_NAME_CLOSE);
				xmlString.append(VIP_AVAILABLE_OPEN);
				xmlString.append(st.isVipAvailable());
				xmlString.append(VIP_AVAILABLE_CLOSE);
				xmlString.append(SHOWTIME_CLOSE);
			}
			xmlString.append(SHOWTIMES_CLOSE);
			xmlString.append(MOVIE_CLOSE);
		}

		xmlString.append(ROOT_CLOSE);

		long endTime = System.nanoTime();

		TransformationResult result = new TransformationResult();
		result.setXmlResult(xmlString.toString());
		result.setTimeInNanos(endTime - startTime);
		result.setTimeInMillis((endTime - startTime) / 1000000);

		return result;
	}

	/**
	 * Uses the Java StringBuffer to build the string
	 * 
	 * @param movies List of movies to be transformed
	 * @return A {@link com.deloitte.sct.datamodel.TransformationResult
	 *         TransformationResult} object the XML, and time taken for the
	 *         transformation
	 */
	static public TransformationResult stringBufferTransformer(List<Movie> movies) {
		long startTime = System.nanoTime();

		StringBuffer xmlString = new StringBuffer();

		xmlString.append(ROOT_OPEN);

		for (Movie m : movies) {
			xmlString.append(MOVIE_OPEN);
			xmlString.append(NAME_OPEN);
			xmlString.append(m.getName());
			xmlString.append(NAME_CLOSE);
			xmlString.append(DURATION_OPEN);
			xmlString.append(m.getDuration());
			xmlString.append(DURATION_CLOSE);
			xmlString.append(RATING_OPEN);
			xmlString.append(m.getRating());
			xmlString.append(RATING_CLOSE);
			xmlString.append(SHOWTIMES_OPEN);
			for(ShowTime st : m.getShowtimes()) {
				xmlString.append(SHOWTIME_OPEN);
				xmlString.append(START_TIME_OPEN);
				xmlString.append(st.getStartTime());
				xmlString.append(START_TIME_CLOSE);
				xmlString.append(THEATRE_NAME_OPEN);
				xmlString.append(st.getTheatreName());
				xmlString.append(THEATRE_NAME_CLOSE);
				xmlString.append(VIP_AVAILABLE_OPEN);
				xmlString.append(st.isVipAvailable());
				xmlString.append(VIP_AVAILABLE_CLOSE);
				xmlString.append(SHOWTIME_CLOSE);
			}
			xmlString.append(SHOWTIMES_CLOSE);
			xmlString.append(MOVIE_CLOSE);
		}

		xmlString.append(ROOT_CLOSE);

		long endTime = System.nanoTime();

		TransformationResult result = new TransformationResult();
		result.setXmlResult(xmlString.toString());
		result.setTimeInNanos(endTime - startTime);
		result.setTimeInMillis((endTime - startTime) / 1000000);

		return result;
	}
}
