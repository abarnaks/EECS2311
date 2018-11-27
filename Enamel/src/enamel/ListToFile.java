package enamel;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.DefaultListModel;

public class ListToFile {

	DefaultListModel<String> convertToFile;
	String lastDirSave =null;
	
	public ListToFile() {
		this.convertToFile = new DefaultListModel<String>();
	}
	
	public DefaultListModel<String> getListToFile() {
		return convertToFile;
	}
	
	public String getLastDirSave() {
		return lastDirSave;
	}
	
	public void setLastDirSave(String s) {
		this.lastDirSave = s;
	}
	
	public void writeToFile(DefaultListModel<String> le, File pathName) {
		try {
			pathName.getName();
			BufferedWriter bw = new BufferedWriter(new FileWriter(pathName));
			int size = le.size();
			for (int i = 0; i < size; i++) {
				String curr = le.getElementAt(i).toString();
				bw.write(curr);
				bw.write("\n");
			}
			
			bw.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
