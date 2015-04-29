package eu.learnpad.bestpractice.factory;

import java.util.ArrayList;
import java.util.Collection;

import javax.json.Json;
import javax.json.JsonObject;
import javax.json.JsonObjectBuilder;

import eu.learnpad.bestpractice.*;
import models.graphbased.directed.bpmn.BPMNDiagram;


public class BestPracticeFactory {

	private BPMNDiagram diagram;
	private Collection<BestPractice> BPcollection;

	public BestPracticeFactory(BPMNDiagram graph){
		diagram = graph;
		BPcollection = new ArrayList<BestPractice>();
		BPcollection.add(new Explicit_Splits(diagram));
		BPcollection.add(new Explicit_Joins(diagram));
		BPcollection.add(new OneStartEvent(diagram));
		BPcollection.add(new OneEndEvent(diagram));
		BPcollection.add(new OneStartEventSubProcess(diagram));

	}

	public JsonObject toJSON(){

		JsonObjectBuilder val = Json.createObjectBuilder();
		for(BestPractice bp: BPcollection){
			val.add("best_practice"+bp.getid(), bp.getJsonBestPractice());
		}
		JsonObject result =  val.build();
		return result;
	}



	@Override
	public String toString() {
		String ret = "BestPracticeFactory: \n\r";
		int index=0;
		for(BestPractice bp: BPcollection){
			ret+=++index+") ";
			ret+=bp.toString();
			ret+="\n\r-------------------------------------\n\r"; 
		}
		return ret;
	}


}
