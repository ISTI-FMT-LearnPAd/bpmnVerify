

import java.io.IOException;
import java.util.HashMap;
import java.util.List;

import org.eclipse.bpmn2.Definitions;
import org.eclipse.bpmn2.FlowElement;
import org.eclipse.bpmn2.RootElement;
import org.eclipse.bpmn2.SequenceFlow;
import org.eclipse.bpmn2.MessageFlow;
import org.eclipse.bpmn2.di.BPMNDiagram;
import org.eclipse.bpmn2.impl.MessageFlowImpl;
import org.eclipse.bpmn2.impl.SequenceFlowImpl;
import org.eclipse.bpmn2.util.Bpmn2ResourceFactoryImpl;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.impl.BasicEObjectImpl;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.xmi.XMLResource;


public class MyBPMN2ModelReader {
	public void ReadThisModel(String theBPMNFile) throws IOException {
		URI uri = URI.createFileURI(theBPMNFile);
		//URI uri = URI.createURI("SampleProcess.bpmn");
		Bpmn2ResourceFactoryImpl resFactory = new Bpmn2ResourceFactoryImpl();
		Resource resource = resFactory.createResource(uri);
		BPMNDiagram vv;
		
		// We need this option because all object references in the file are "by ID"
		// instead of the document reference "URI#fragment" form.
		HashMap<Object, Object> options = new HashMap<Object, Object>();
		options.put(XMLResource.OPTION_DEFER_IDREF_RESOLUTION, true);
		
		// Load the resource
		resource.load(options);
		
		// This is the root element of the XML document
		Definitions d = getDefinitions(resource);

		// Print all elements contained in all Processes found
		List<RootElement> rootElements = d.getRootElements();

		for (RootElement rootElement : rootElements) {


			if (rootElement instanceof org.eclipse.bpmn2.Collaboration) {
				org.eclipse.bpmn2.Collaboration bpmn2Collaboration = (org.eclipse.bpmn2.Collaboration) rootElement;
				System.out.format("Found a Collaboration: %s\n", bpmn2Collaboration.getName());
				System.out.println("Collaboration: name = " + bpmn2Collaboration.getName() +
						" ID = " + bpmn2Collaboration.getId() + "\n");
			} else
				if (rootElement instanceof org.eclipse.bpmn2.Participant) {
					org.eclipse.bpmn2.Participant bpmn2Participant = (org.eclipse.bpmn2.Participant) rootElement;
					System.out.format("Found a Participant: %s\n", bpmn2Participant.getName());
					System.out.println("Participant = " + bpmn2Participant.getId());
					org.eclipse.bpmn2.Process procRef = bpmn2Participant.getProcessRef(); // The getId() call to this ProcessRef does not return a Procee Id
					String pRefId = ""; //NullpointerException is because of this line.
					//I have written the following code to understand how I can use eGet function that takes EStructuralFeature, but I need a way to specify the correct EStructuralFeature to access the processRef of Participant. This code results in exception.

				} else
					if (rootElement instanceof org.eclipse.bpmn2.Resource) {
						org.eclipse.bpmn2.Resource bpmn2Resource = (org.eclipse.bpmn2.Resource) rootElement;
						System.out.format("Found a resource: %s\n", bpmn2Resource.getName());
					} else if (rootElement instanceof org.eclipse.bpmn2.Process) {
						org.eclipse.bpmn2.Process process = (org.eclipse.bpmn2.Process) rootElement;
						System.out.format("Found a process: %s\n", process.getName());
						for (FlowElement fe : process.getFlowElements()) {
							if (fe instanceof MessageFlowImpl) {
								MessageFlow mf = ((MessageFlow) fe);
								System.out.println("Message flow found.");
							}
							if (fe instanceof SequenceFlowImpl) {
								SequenceFlow sf = ((SequenceFlow) fe);
								if (sf != null) {
									String source = "";
									String target = "";
									if (sf.getSourceRef() != null)
										source = sf.getSourceRef().getId();
									if (sf.getTargetRef() != null)
										target = sf.getTargetRef().getId();
									System.out.println("Sequence Flow: " + source + " -> " + target);
								}
							}
							else {
								System.out.println(fe.eClass().getName()+": name="+fe.getName()+" ID="+fe.getId());
							}
						}

					}

		}
	}
	
	private static Definitions getDefinitions(Resource resource) {
		if (resource!=null && !resource.getContents().isEmpty() && !((EObject) resource.getContents().get(0)).eContents().isEmpty()) {
			// Search for a Definitions object in this Resource
			for (Object e : resource.getContents()) {
				for (Object o : ((EObject) e).eContents()) {
					if (o instanceof Definitions)
						return (Definitions) o;
				}
			}
		}
		return null;
	}
}
