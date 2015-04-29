package eu.learnpad.bestpractice;

import java.util.ArrayList;
import java.util.Collection;

import models.graphbased.directed.ContainableDirectedGraphElement;
import models.graphbased.directed.bpmn.BPMNDiagram;
import models.graphbased.directed.bpmn.elements.Event;
import models.graphbased.directed.bpmn.elements.Event.EventType;
import models.graphbased.directed.bpmn.elements.SubProcess;

public class OneStartEventSubProcess extends ABBestPractice{

	public OneStartEventSubProcess(BPMNDiagram diagram) {
		super(diagram);

	}

	public int getid() {

		return 5;
	}

	public String getDescription() {

		return "This rule guarantees that a subprocess stays clear and comprehensive. There is one exact start of a subprocess and it should be defined. If a subprocess has more than one start event, misinterpretations can occur.";
	}

	public String getName() {

		return "OneStartEventSubProcess";
	}

	public  void findBadPractice(BPMNDiagram diagram){
		Collection<Event> tmpEvents = new ArrayList<Event>();
		Collection<SubProcess> tmpsubs = diagram.getSubProcesses();
		for(SubProcess s : tmpsubs){
			for(ContainableDirectedGraphElement c :s.getChildren()){
				if(c instanceof Event){
					Event e = (Event)c;
					if(e.getEventType()==EventType.START){
						tmpEvents.add(e);
					}
				}
			}
			if(tmpEvents.size()>1){
				elements.addAll(tmpEvents);
			}
		}

	}

	public String getSuggestion() {
		return "Remove excessive Start Event ";
	}

}
