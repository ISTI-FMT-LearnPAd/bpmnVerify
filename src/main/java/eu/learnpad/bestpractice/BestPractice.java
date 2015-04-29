package eu.learnpad.bestpractice;

import java.util.Collection;

import javax.json.JsonObject;


/**
 * @author isiu
 *
 */
public interface BestPractice {
	/**
	 * 
	 * @return "ID of BP"
	 */
	int getid();
	/**
	 * 
	 * @param <E>
	 * @return "BadElement"
	 */
	<E> Collection<E> getElements();
	
	/**
	 * 
	 * @return  "Description of BestPractice"
	 */
	String getDescription();
	
	/**
	 * 
	 * @return "Name of BestPractice"
	 */
	String getName();
	/**
	 * 
	 * @return Status of BP
	 */
	boolean getStatus();
	
	String getSuggestion();
	
	JsonObject getJsonBestPractice();
	
	String toString();
}
