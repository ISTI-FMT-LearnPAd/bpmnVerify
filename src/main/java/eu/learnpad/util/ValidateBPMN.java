package eu.learnpad.util;

import java.io.File;

public class ValidateBPMN {
	
	private boolean valid=false;
	public ValidateBPMN(File file){
		
		validate(file);
	}
	private void validate(File file) {
		

	}

	public boolean isValid(){
		return valid;
	}

}
