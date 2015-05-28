package eu.learnpad.util;



public class MetricsBPMN {

	
	private int numStartEvent=0;
	private int numInteEvent=0;
	private int numEndEvent=0;

	public MetricsBPMN() {
	
		CountEvent();
	}

	public int NumberOfActivity(){	
		return 0;
	}

	public int NumbersOfGateways(){	
		return 0;
	}
	public int NumbersOfStartEvents(){	

		return numStartEvent;
	}

	private void CountEvent(){
		/*for(Event e: diagram.getEvents()){
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
		}*/
	}


	public int NumbersOfEndEvents(){	
		return numEndEvent;
	}

	public int NumbersOfIntermediateEvents(){	
		return numInteEvent;
	}
	
	public int NumbersOfPools(){	
		return 0;
	}
	
	public int NumbersOfLanes(){	
		return 0;
	}

	@Override
	public String toString() {
		return "MetricsBPMN [diagram="  + ", \n\rNumberOfActivity="
				+ NumberOfActivity() + ", \n\rNumbersOfGateways="
				+ NumbersOfGateways() + ", \n\rNumbersOfStartEvents="
				+ NumbersOfStartEvents() + ", \n\rNumbersOfEndEvents="
				+ NumbersOfEndEvents() + ", \n\rNumbersOfIntermediateEvents="+ NumbersOfIntermediateEvents() 
				+ ", \n\rNumbersOfLanes="+ NumbersOfLanes() 
				+ ", \n\rNumbersOfPools="+ NumbersOfPools() + "]";
	}
	
	

}
