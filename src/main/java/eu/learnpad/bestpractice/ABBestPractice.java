package eu.learnpad.bestpractice;

import java.util.ArrayList;
import java.util.Collection;

import models.graphbased.directed.bpmn.BPMNDiagram;
import models.graphbased.directed.bpmn.BPMNNode;

public abstract class ABBestPractice implements BestPractice {

	protected  Collection<BPMNNode> elements;

	ABBestPractice(BPMNDiagram diagram){
		super();
		elements = new ArrayList<BPMNNode>();
		findBadPractice(diagram);
	}
	
	
	public Collection<BPMNNode> getElements() {
		return elements;
	}
	
	protected abstract void findBadPractice(BPMNDiagram diagram);

	
	public boolean getStatus() {

		return elements.size()>0?true:false;
	}

	public String toString(){
		return "ID: "+getid()+" \n\r"
				+"Name: "+getName()+" \n\r"
				+"Description: "+getDescription()+" \n\r"
				+"Status: "+getStatus()+" \n\r"
				+"Element: "+getElements()+" \n\r";
	}

}
