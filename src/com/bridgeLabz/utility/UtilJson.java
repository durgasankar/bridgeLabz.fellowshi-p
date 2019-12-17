package com.bridgeLabz.utility;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.json.simple.JSONArray;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

/**
 * This class contains JSON utility functionality like => convertJavaToJson, =>
 * convertJsonToJava, => readDetails,=> readJsonArray, => writeDataToJsonArray
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
	public static String convertObjectToJson(Object object) {
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

	/**
	 * This function takes file path and jsonArray as input parameter and
	 * 
	 * @param path      as String input parameter
	 * @param jsonArray as input array parameter
	 * @created 2019-12-17
	 */
	public static void writeDataToJSONArray(String path, JSONArray jsonArray) {

		try (FileWriter fileWritter = new FileWriter(path)) {
			fileWritter.write(jsonArray.toJSONString());
		} catch (IOException e) {
			System.out.println(e.getMessage());

		}
	}

	/**
	 * takes file path as input parameter and read the data present in the file and
	 * convert to JSON array.
	 * 
	 * @param filePath as input parameter
	 * @return JSONArray
	 * @created 2019-12-17
	 */
	public static JSONArray readJSONArray(String filePath) {
		JSONArray jsonArray;
		try (FileReader fieReader = new FileReader(filePath)) {
			JSONParser jsonParser = new JSONParser();
			jsonArray = (JSONArray) jsonParser.parse(fieReader);
			return jsonArray;
		} catch (FileNotFoundException e) {

		} catch (IOException | ParseException e) {
		}
		return null;

	}
}
