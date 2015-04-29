package eu.learnpad.bestpractice;

import models.graphbased.directed.bpmn.BPMNDiagram;
import models.graphbased.directed.bpmn.elements.Activity;
import models.graphbased.directed.bpmn.elements.Event;
import models.graphbased.directed.bpmn.elements.SubProcess;

public class Explicit_Joins extends ABBestPractice {

	public Explicit_Joins(BPMNDiagram diagram) {
		super(diagram);
	}

	public int getid() {
		
		return 2;
	}

	public String getDescription() {
		
		return "Joins should be modeled explicitly using gateways. This is important for clarity and legibility of diagrams.";
	}

	public String getName() {
		
		return "Explicit_Joins";
	}
	
	public  void findBadPractice(BPMNDiagram diagram){
		
		for(Activity a :diagram.getActivities()){
			if(a.getGraph().getInEdges(a).size()>1){
				elements.add(a);
			}
		}
		for(Event a :diagram.getEvents()){
			if(a.getGraph().getInEdges(a).size()>1){
				elements.add(a);
			}
		}
		for(SubProcess a :diagram.getSubProcesses()){
			if(a.getGraph().getInEdges(a).size()>1){
				elements.add(a);
			}
		}
	}

	public String getSuggestion() {
		return "Add Gateway after ";
	}

}
