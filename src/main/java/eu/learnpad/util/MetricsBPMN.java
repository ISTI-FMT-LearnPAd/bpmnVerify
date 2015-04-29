package eu.learnpad.util;

import models.graphbased.directed.bpmn.BPMNDiagram;
import models.graphbased.directed.bpmn.elements.Event;
import models.graphbased.directed.bpmn.elements.Event.EventType;

public class MetricsBPMN {

	private BPMNDiagram diagram;
	private int numStartEvent=0;
	private int numInteEvent=0;
	private int numEndEvent=0;

	public MetricsBPMN(BPMNDiagram graph) {
		diagram = graph;
		CountEvent();
	}

	public int NumberOfActivity(){	
		return diagram.getActivities().size();
	}

	public int NumbersOfGateways(){	
		return diagram.getActivities().size();
	}
	public int NumbersOfStartEvents(){	

		return numStartEvent;
	}

	private void CountEvent(){
		for(Event e: diagram.getEvents()){
			if (e.getEventType().equals(EventType.START)){
				numStartEvent++;
			}else{
				if (e.getEventType().equals(EventType.END)){
					numEndEvent++;
				}else{
					if (e.getEventType().equals(EventType.INTERMEDIATE)){
						numInteEvent++;
					}
				}
			}
		}
	}


	public int NumbersOfEndEvents(){	
		return numEndEvent;
	}

	public int NumbersOfIntermediateEvents(){	
		return numInteEvent;
	}
	
	public int NumbersOfPools(){	
		return diagram.getPools().size();
	}
	
	public int NumbersOfLanes(){	
		return diagram.getLanes(null).size();
	}

	@Override
	public String toString() {
		return "MetricsBPMN [diagram=" + diagram + ", \n\rNumberOfActivity="
				+ NumberOfActivity() + ", \n\rNumbersOfGateways="
				+ NumbersOfGateways() + ", \n\rNumbersOfStartEvents="
				+ NumbersOfStartEvents() + ", \n\rNumbersOfEndEvents="
				+ NumbersOfEndEvents() + ", \n\rNumbersOfIntermediateEvents="+ NumbersOfIntermediateEvents() 
				+ ", \n\rNumbersOfLanes="+ NumbersOfLanes() 
				+ ", \n\rNumbersOfPools="+ NumbersOfPools() + "]";
	}
	
	

}
