package eu.learnpad.bestpractice;

import java.util.ArrayList;
import java.util.Collection;

import models.graphbased.directed.bpmn.BPMNDiagram;
import models.graphbased.directed.bpmn.elements.Event;
import models.graphbased.directed.bpmn.elements.Event.EventType;

public class OneStartEvent extends ABBestPractice{

	public OneStartEvent(BPMNDiagram diagram) {
		super(diagram);
		
	}

	public int getid() {
		
		return 3;
	}

	public String getDescription() {
		
		return "This rule guarantees that a process stays clear and comprehensive. There is one exact start of a process and it should be defined. If a process has more than one start event, misinterpretations can occur.";
	}

	public String getName() {
		
		return "OneStartEvent";
	}
	
	public  void findBadPractice(BPMNDiagram diagram){
		int numStart=0;
		Collection<Event> tmpEvents = new ArrayList<Event>();
		for(Event e : diagram.getEvents()){
			if(e.getEventType()==EventType.START){
				tmpEvents.add(e);
			}
		}
		if(tmpEvents.size()>1){
			elements.addAll(tmpEvents);
		}
	}

}
