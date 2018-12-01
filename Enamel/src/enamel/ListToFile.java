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
				String curr = le.getElementAt(i);
				if(curr.startsWith("Button")) {
					bw.write(curr);
					bw.write(System.lineSeparator());
					bw.write(System.lineSeparator());	
				} else if (curr.startsWith("/~repeat")) {
					String l1 = curr.substring(0, 7);
					bw.write(l1);
					bw.write(System.lineSeparator());
					
					String l2 = curr.substring(8);
					int end = l2.indexOf("/~endrepeat");
					String keyline = l2.substring(0, end - 1);
					bw.write(keyline);
					bw.write(System.lineSeparator());
					
					String l3 = curr.substring(end);
					bw.write(l3);
					bw.write(System.lineSeparator());
				} else {
				
					bw.write(curr);
					bw.write(System.lineSeparator());
				}
			}
			
			bw.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
