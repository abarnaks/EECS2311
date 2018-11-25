package enamel;

import javax.swing.DefaultListModel;

public class ListToFile {

	DefaultListModel<String> convertToFile;
	
	public ListToFile() {
		this.convertToFile = new DefaultListModel<String>();
	}
	
	public DefaultListModel<String> getListToFile() {
		return convertToFile;
	}
	
	public void writeToFile() {
		
	}
}
