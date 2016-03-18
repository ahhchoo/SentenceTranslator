/*
 * !!!IMPORTANT!!!
 * Instruction: 
 * For every translate--(String input) function, input your Mashape key. 
 */
package application;

import java.util.StringTokenizer;
import org.json.JSONObject;

import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.JsonNode;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;

/**
 * SpeakingStyle class may be considered the Model class.
 * SpeakingStyle turns string input into the desired style. 
 * 
 * @author alisoncheu
 *
 */
public class SpeakingStyle {
	private static StringTokenizer st;
	private static String total ;
	public SpeakingStyle(){}
	
	/**
	 * Translates String input to Yoda phrase by calling the Yoda Speak API 
	 * at market.mashape.com. 
	 *
	 * Link: https://market.mashape.com/ismaelc/yoda-speak
	 * 
	 * @param input	String value to convert
	 * @return String value converted
	 * @throws UnirestException	
	 */
	public static String translateYoda(String input) throws UnirestException{
		setupTotal(input); 
		HttpResponse<String> response = Unirest.get("https://yoda.p.mashape.com/yoda?sentence="+total)
				.header("X-Mashape-Key", "INSERT-KEY-HERE")
				.header("Accept", "text/plain")
				.asString();
		
		return response.getBody(); 
	}
	
	/**
	 * Translates String input to Minion phrase by calling Minion Translator API.
	 * Calls getString() function to retrieve translated text as String. 
	 * 
	 * Link: https://market.mashape.com/orthosie/minion-translator
	 * 
	 * @param input String value to convert
	 * @return String value converted 
	 * @throws UnirestException
	 */
	public static String translateMinion(String input) throws UnirestException{
		setupTotal(input); 
		HttpResponse<JsonNode> response = Unirest.post("https://minion.p.mashape.com/minion.json?text=" + total)
				.header("X-Mashape-Key", "INSERT-KEY-HERE")
				.header("Content-Type", "application/x-www-form-urlencoded")
				.header("Accept", "application/json")
				.asJson();
		return getString(response.getBody().getObject()); 
	}
	
	/**
	 * Translates String input to Pirate phrase by calling Pirate Translator API
	 * Calls getString() function to retrieve translated text as String. 
	 * 
	 * Link: https://market.mashape.com/orthosie/pirate-translator
	 * 
	 * @param input String value to convert
	 * @return String value converted
	 * @throws UnirestException
	 */
	public static String translatePirate(String input) throws UnirestException{
		setupTotal(input); 
		HttpResponse<JsonNode> response = Unirest.post("https://piratespeak.p.mashape.com/pirate.json?text=" + total)
				.header("X-Mashape-Key", "INSERT-KEY-HERE")
				.header("Content-Type", "application/x-www-form-urlencoded")
				.asJson();
		
		return getString(response.getBody().getObject()); 
	}
	
	/**
	 * Translates String input to Valley Girl phrase by calling Valley Girl or Valspeak 
	 * Translator API. Calls getString() function to retrieve translated text as String. 
	 * 
	 * Link: https://market.mashape.com/orthosie/valley-girl-or-valspeak-translator
	 * 
	 * @param input String value to convert
	 * @return String value converted
	 * @throws UnirestException
	 */
	public static String translateValleyGirl(String input) throws UnirestException{
		setupTotal(input); 
		HttpResponse<JsonNode> response = Unirest.post("https://valspeak.p.mashape.com/valspeak.json?text=" + total)
				.header("X-Mashape-Key", "INSERT-KEY-HERE")
				.header("Content-Type", "application/x-www-form-urlencoded")
				.asJson();
		return getString(response.getBody().getObject()); 
		
	}
	
	/**
	 * Translates String input to LOLCat phrase by calling LOLCat Translator API.
	 * Calls getString() function to retrieve translated text as String. 
	 * 
	 * Link: https://market.mashape.com/orthosie/lolcat-translator
	 * 
	 * @param input String value to convert
	 * @return String value converted
	 * @throws UnirestException
	 */
	public static String translateLOLCat(String input) throws UnirestException{
		setupTotal(input); 
		HttpResponse<JsonNode> response = Unirest.get("https://lolcat.p.mashape.com/lolcat.json?text=" + total)
				.header("X-Mashape-Key", "INSERT-KEY-HERE")
				.asJson();
		return getString(response.getBody().getObject()); 
	}
	
	/**
	 * SetupTotal tokenizes the sentence into strings and concates a "+" sign
	 * between each word. Punctuations are added to the word prior to the punctuation.
	 *  
	 * @param input	String to be tokenized
	 */
	public static void setupTotal(String input){
		st = new StringTokenizer(input);
		total ="";
		
		while (st.hasMoreTokens()) {
			total += "+" + st.nextToken();
		}
		
	}
	
	/**
	 * Function that takes the JSONObject and extracts the correct string 
	 * which is within the translated object. 
	 * 
	 * @param node JSONObject to extract translation from 
	 * @return	Dictionary value of translated
	 */
	private static String getString(JSONObject node){
		
		return (String) ((JSONObject) node.get("contents")).get("translated"); 
	
	}
}