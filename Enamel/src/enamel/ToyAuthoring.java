package enamel;

import java.io.File;

import javax.swing.JFileChooser;

public class ToyAuthoring {

	private static String lastPlayDir = null;
	
    public static void main(String[] args) {
    	Thread starterCodeThread = new Thread("Starter Code Thread") {
    		public void run() {
    			ScenarioParser s = new ScenarioParser(true);
    			
    			if(lastPlayDir != null) {
    				JFileChooser fc = new JFileChooser(lastPlayDir);
    				int status = fc.showOpenDialog(null);
    				
    				if (status == JFileChooser.APPROVE_OPTION) {
    					File selFile = fc.getSelectedFile();
    					lastPlayDir = selFile.getParent();
    					s.setScenarioFile(selFile.getAbsolutePath());
    				} else if (status == JFileChooser.CANCEL_OPTION) {
    					HomePage.main(null);
    					 s = new ScenarioParser(false);
    				}
    			} else if (lastPlayDir == null) {
    				JFileChooser fc = new JFileChooser();
    				int status = fc.showOpenDialog(null);
    				
    				if (status == JFileChooser.APPROVE_OPTION) {
    					File selFile = fc.getSelectedFile();
    					lastPlayDir = selFile.getParent();
    					s.setScenarioFile(selFile.getAbsolutePath());
    				} else if (status == JFileChooser.CANCEL_OPTION) {
    					HomePage.main(null);
    					 s = new ScenarioParser(false);
    				}
    			}
    		}
    	};
    	starterCodeThread.start();
    }
}