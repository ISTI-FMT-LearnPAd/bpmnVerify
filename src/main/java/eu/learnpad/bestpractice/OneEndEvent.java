package eu.learnpad.bestpractice;

import java.util.ArrayList;
import java.util.Collection;

import models.graphbased.directed.bpmn.BPMNDiagram;
import models.graphbased.directed.bpmn.elements.Event;
import models.graphbased.directed.bpmn.elements.Event.EventType;

public class OneEndEvent extends ABBestPractice{

	public OneEndEvent(BPMNDiagram diagram) {
		super(diagram);
		
	}

	public int getid() {
		
		return 4;
	}

	public String getDescription() {
		
		return "This rule guarantees that a process stays clear and comprehensive. There is one exact end of a process and it should be defined. If a process has more than one end event, misinterpretations can occur.";
	}

	public String getName() {
		
		return "OneEndEvent";
	}
	
	public  void findBadPractice(BPMNDiagram diagram){
		
		Collection<Event> tmpEvents = new ArrayList<Event>();
		for(Event e : diagram.getEvents()){
			if(e.getEventType()==EventType.END && e.getParentSubProcess()==null){
				tmpEvents.add(e);
			}
		}
		if(tmpEvents.size()>1){
			elements.addAll(tmpEvents);
		}
	}

}
