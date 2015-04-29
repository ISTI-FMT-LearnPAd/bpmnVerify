package eu.learnpad.bestpractice.factory;

import java.util.ArrayList;
import java.util.Collection;

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
