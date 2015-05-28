import java.io.File;
import java.io.FileInputStream;
import java.util.Collection;
import java.util.Collections;

import javax.swing.JFileChooser;
import javax.swing.JFrame;



import org.eclipse.emf.common.util.URI;

import eu.learnpad.bestpractice.factory.BestPracticeFactory;
import eu.learnpad.util.MetricsBPMN;




public class main {

	public static void main(String[] args) {

		/*if(args.length<0 || args[0]==null){
			System.out.println("Non del file non trovato");
		}else{*/
			try {

				JFileChooser fc = new JFileChooser();
				fc.setDialogType(JFileChooser.OPEN_DIALOG);		
				fc.setFileSelectionMode(JFileChooser.FILES_ONLY);

				int returnVal = fc.showOpenDialog(new JFrame("Load File"));

				if (returnVal == JFileChooser.APPROVE_OPTION) {
					File file = fc.getSelectedFile();

					
					String f =  file.toURI().toURL().toExternalForm();
					URI uri = URI.createFileURI(file.getAbsolutePath());
					System.out.println(uri);
					
					
					MyBPMN2ModelReader myReader = new MyBPMN2ModelReader();
					myReader.ReadThisModel(file.getAbsolutePath());
				
				}
				
			}catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
//	}

}
