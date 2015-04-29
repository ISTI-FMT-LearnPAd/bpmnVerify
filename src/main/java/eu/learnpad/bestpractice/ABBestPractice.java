package eu.learnpad.bestpractice;

import java.util.ArrayList;
import java.util.Collection;

import javax.json.Json;
import javax.json.JsonArray;
import javax.json.JsonArrayBuilder;
import javax.json.JsonObject;
import javax.json.JsonObjectBuilder;

import models.graphbased.directed.bpmn.BPMNDiagram;
import models.graphbased.directed.bpmn.BPMNNode;

public abstract class ABBestPractice implements BestPractice {

	protected  Collection<BPMNNode> elements;

	ABBestPractice(BPMNDiagram diagram){
		super();
		elements = new ArrayList<BPMNNode>();
		findBadPractice(diagram);
	}


	public Collection<BPMNNode> getElements() {
		return elements;
	}

	protected abstract void findBadPractice(BPMNDiagram diagram);


	public boolean getStatus() {

		return elements.size()>0?true:false;
	}

	public String toString(){
		String ret = "ID: "+getid()+" \n\r"
				+"Name: "+getName()+" \n\r"
				+"Description: "+getDescription()+" \n\r"
				+"Status: "+getStatus()+" \n\r";
		if(getStatus()){
			ret+="Suggestion: "+getSuggestion()+" \n\r";
		}
		ret+="Element: "+getElements()+" \n\r";
		return ret;
	}
	
	public JsonObject getJsonBestPractice() {

		JsonObjectBuilder val = Json.createObjectBuilder()
				.add("name", getName());
	
		val.add("id",getid())
		.add("description", getDescription())
		.add("status", getStatus())
		.add("Suggestion",getSuggestion());
		
		JsonArrayBuilder collevalelem = Json.createArrayBuilder();
		for(BPMNNode e : getElements()){
		JsonObjectBuilder valElem = Json.createObjectBuilder()
				.add("name", e.getLabel());
				valElem.add("id", e.getId().toString());
				collevalelem.add(valElem);
		}
		val.add("Element", collevalelem);
		JsonObject value = val.build();

		return value;

	}

}
