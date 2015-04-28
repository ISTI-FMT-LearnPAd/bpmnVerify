package eu.learnpad.bestpractice;

import java.util.ArrayList;
import java.util.Collection;

import models.graphbased.directed.bpmn.BPMNNode;

public abstract class ABBestPractice implements BestPractice {

	protected  boolean status = false;
	protected  Collection<BPMNNode> element;

	ABBestPractice(){
		super();
		element = new ArrayList<BPMNNode>();
	}
	
	
	public Collection<BPMNNode> getElements() {
		return element;
	}
	
	

	
	public boolean getStatus() {

		return status;
	}

	public String toString(){
		return "Name: "+getName()+" "
				+"Description: "+getDescription()+" "
				+"Status: "+getStatus()+" "
				+"Element: "+getElements();
	}

}
