package eu.learnpad.util;

import models.graphbased.directed.bpmn.BPMNDiagram;

public class MetricsBPMN {

	BPMNDiagram diagram;
	
	public MetricsBPMN(BPMNDiagram graph) {
		diagram = graph;
	}
	
	public int NumberOfActivity(){	
		return diagram.getActivities().size();
	}
	
	public int NumberOfGateway(){	
		return diagram.getActivities().size();
	}

}
