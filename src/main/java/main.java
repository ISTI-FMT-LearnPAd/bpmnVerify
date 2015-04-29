import java.io.File;
import java.util.Collection;

import eu.learnpad.bestpractice.factory.BestPracticeFactory;
import eu.learnpad.util.MetricsBPMN;
import models.graphbased.directed.bpmn.BPMNDiagram;
import plugins.bpmn.Bpmn;



public class main {

	public static void main(String[] args) {

		if(args.length<0 || args[0]==null){
			System.out.println("Non del file non trovato");
		}else{
			try {


				File file = new File(args[0]);
				Bpmn bpmn = new Bpmn(file);

				Collection<BPMNDiagram> BPMNdiagrams = 	bpmn.BpmnextractDiagram();
				for(BPMNDiagram graph : BPMNdiagrams){
					System.out.println("Name of Diagrams: "+graph.getLabel());
					MetricsBPMN metrics = new MetricsBPMN(graph);
					BestPracticeFactory bpf = new BestPracticeFactory(graph);
					System.out.println(metrics);
					System.out.println("-----------------------------------------");
					System.out.println(bpf);
					System.out.println("-------------------JSON----------------------");
					System.out.println(bpf.toJSON().toString());
					

				}
			}catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

}
