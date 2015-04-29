
package eu.learnpad.bestpractice;

import models.graphbased.directed.bpmn.BPMNDiagram;
import models.graphbased.directed.bpmn.elements.Activity;
import models.graphbased.directed.bpmn.elements.Event;
import models.graphbased.directed.bpmn.elements.SubProcess;





public class Explicit_Splits extends ABBestPractice {
	
	public Explicit_Splits(BPMNDiagram diagram){
		super(diagram);
	}
	

	public int getid() {
		return 1;
	}


	public String getDescription() {
		
		return "Splits should be joined explicit on gateways. This makes sure to get clarity and readability in a process";
	}

	public String getName() {
		
		return "Explicit_Splits";
	}


	
	public  void findBadPractice(BPMNDiagram diagram){
		for(Activity a :diagram.getActivities()){
			if(a.getGraph().getOutEdges(a).size()>1){
				elements.add(a);
			}
		}
		for(Event a :diagram.getEvents()){
			if(a.getGraph().getOutEdges(a).size()>1){
				elements.add(a);
			}
		}
		for(SubProcess a :diagram.getSubProcesses()){
			if(a.getGraph().getOutEdges(a).size()>1){
				elements.add(a);
			}
		}

		/*for(Gateway g : diagram.getGateways()){
			int in = g.getGraph().getInEdges(g).size();
			int out =	g.getGraph().getOutEdges(g).size();
			if(in==1 && out >2 ){
				es.getElements().add(g);
			}
		}*/


	}

	public String getSuggestion() {
		return "Add Gateway before ";
	}


}
