package com.bridgeLabz.utility;

import java.io.IOException;
import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;

/**
 * This class contains JSON utility functionality like => convertJavaToJson, =>
 * convertJsonToJava
 * 
 * @author Durgasankar Mishra
 * @created 2019-11-30
 * @version 11.0.5
 * @version 1.9.13 (JSON)
 */
public class UtilJson {

	private static ObjectMapper mapper;
	/**
	 * object will created only one time.
	 */
	static {
		mapper = new ObjectMapper();
	}

	/**
	 * takes the object of the class as input parameter and converts it into JSON
	 * file and returns String value as per JSON format by reading the values.
	 * 
	 * @param object as input parameter
	 * @return String value.
	 * @throws JsonGenerationException
	 * @throws JsonMappingException
	 * @throws IOException
	 * @created 2019-11-30
	 */
	public static String convertJavaToJson(Object object) {
		String jsonResult = "";
		try {
			jsonResult = mapper.writeValueAsString(object);
		} catch (JsonGenerationException e) {
			System.out.println("Exception occured while converting java object to json " + e.getMessage());
		} catch (JsonMappingException e) {
			System.out.println("Exception occured while converting java object to json " + e.getMessage());
		} catch (IOException e) {
			System.out.println("Exception occured while converting java object to json " + e.getMessage());
		}
		return jsonResult;
	}

	/**
	 * This method takes parameter as JSON String and class name as input parameter
	 * and returns generic type output after reading JSON file.
	 * 
	 * @param <G>
	 * @param jsonString as input parameter.
	 * @param cls        takes parameter as className.class
	 * @return generic<G> type data.
	 * @throws JsonGenerationException
	 * @throws JsonMappingException
	 * @throws IOException
	 * @created 2019-11-30
	 */
	public static <G> G convertJsonToJava(String jsonString, Class<G> cls) {
		G result = null;
		try {
			result = mapper.readValue(jsonString, cls);
		} catch (JsonParseException e) {
			System.out.println("Exception while converting json object to java " + e.getMessage());
		} catch (JsonMappingException e) {
			System.out.println("Exception while converting json object to java " + e.getMessage());
		} catch (IOException e) {
			System.out.println("Exception while converting json object to java " + e.getMessage());
		}
		return result;
	}

}