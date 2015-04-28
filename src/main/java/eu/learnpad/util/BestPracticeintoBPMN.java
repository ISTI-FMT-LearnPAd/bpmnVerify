package eu.learnpad.util;

import eu.learnpad.bestpractice.BestPractice;
import eu.learnpad.bestpractice.Explicit_Splits;
import models.graphbased.directed.bpmn.BPMNDiagram;
import models.graphbased.directed.bpmn.BPMNDiagramImpl;
import models.graphbased.directed.bpmn.elements.Activity;
import models.graphbased.directed.bpmn.elements.Event;
import models.graphbased.directed.bpmn.elements.Gateway;
import models.graphbased.directed.bpmn.elements.SubProcess;

public class BestPracticeintoBPMN {

	private BPMNDiagram diagram;

	public BestPracticeintoBPMN(BPMNDiagramImpl graph){
		diagram = graph;	
	}



	public BestPractice ExSplit(){
		BestPractice es = new  Explicit_Splits();
		for(Activity a :diagram.getActivities()){
			if(a.getGraph().getInEdges(a).size()>1 || a.getGraph().getOutEdges(a).size()>1){
				es.getElements().add(a);
			}
		}
		for(Event a :diagram.getEvents()){
			if(a.getGraph().getInEdges(a).size()>1 || a.getGraph().getOutEdges(a).size()>1){
				es.getElements().add(a);
			}
		}
		for(SubProcess a :diagram.getSubProcesses()){
			if(a.getGraph().getInEdges(a).size()>1 || a.getGraph().getOutEdges(a).size()>1){
				es.getElements().add(a);
			}
		}

		for(Gateway g : diagram.getGateways()){
			int in = g.getGraph().getInEdges(g).size();
			int out =	g.getGraph().getOutEdges(g).size();
			if(!((in==1 && out >1 )||(in >1 && out ==1))){
				es.getElements().add(g);
			}
		}


		return es;
	}
}
