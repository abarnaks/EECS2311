package enamel;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import javax.swing.DefaultListModel;

import enamel.ScenEvents.*;

public class Translator {

	public static DefaultListModel<Object> temp = new DefaultListModel<Object>();
	
	private static final ScenEvents se = new ScenEvents();
	public static DefaultListModel<Object> converted = new DefaultListModel<Object>();
	
	public static void readScenario(File filename) throws IOException {
		try {
			BufferedReader read = new BufferedReader(new FileReader(filename));
			String line = read.readLine();
			while (line != null) {
				temp.addElement(line);
//				//go to next line
//				line = read.readLine();				
				//assign(line);	
				
				line = read.readLine();
			}
			read.close();
	
			printList();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		for (int i = 0; i <temp.getSize(); i++) {
			String str = (String) temp.getElementAt(i);
			System.out.println(str);
			//assign(str);
		}
	}
	
	public static void assign(String currLine) {
		
		if (currLine.startsWith("Cell")) {
			String[] c = currLine.split(" ");
			Cells cl = se.new Cells(Integer.parseInt(c[1]));
			converted.addElement(cl);
		} else if (currLine.startsWith("Button")) {
			String[] b = currLine.split(" ");
			Buttons bt = se.new Buttons(Integer.parseInt(b[1]));
		} else if (currLine.startsWith("/~pause:")) {
			String[] s = currLine.split(" ");
			Pause p = se.new Pause(Integer.parseInt(s[1]));
			converted.addElement(p);
		} else if (currLine.startsWith("/~skip-button:")) {
			String[] i = currLine.split(" ");
//			SetSkipButton ssb = se.new SetSkipButton(Integer.parseInt(i[1]), i[2]);
//			converted.addElement(ssb);
		} else if (currLine.startsWith("/~disp-string:")) {
			String[] spl = currLine.split(" ", 1);	//may have to be more than once
			DisplaySentence as = se.new DisplaySentence(spl[1]);
			converted.addElement(as);
		} else if (currLine.startsWith("/~repeat")) {
			//how to read repeat sentence
			
		} else if (currLine.startsWith("/~repeat-button:")) {
			String[] rb = currLine.split(" ");
			InsertRepeatButton rbe = se.new InsertRepeatButton(Integer.parseInt(rb[1]));
			converted.addElement(rbe);
		} else if (currLine.startsWith("/~user-input")) {
			UserInput us = se.new UserInput();
			converted.addElement(us);
		} else if (currLine.startsWith("/~sound:")) {
			String[] snd = currLine.split(" ");
			InsertSound sound = se.new InsertSound(snd[2]);
			converted.addElement(sound);
		} else if (currLine.startsWith("/~reset-buttons")) {
			ResetButtons rs = se.new ResetButtons();
			converted.addElement(rs);
		} else if (currLine.startsWith("/~disp-clearAll")) {
			ClearAllCells us = se.new ClearAllCells();
			converted.addElement(us);
		} else if (currLine.startsWith("/~disp-cell-clear:")) {
			String[] o = currLine.split(" ");
			OneCellClear oc = se.new OneCellClear(Integer.parseInt(o[1]));
			converted.addElement(oc);
		} else if (currLine.startsWith("/~disp-cell-pins:")) {
			String[] ppp = currLine.split(" ");
			//SetCellPins cp = se.new SetCellPins(Integer.parseInt(ppp[1]),ppp[2]);
			System.out.print(ppp);
		//	converted.addElement(cp);
		} else if (currLine.startsWith("/~disp-cell-char:")) {
			String[] cChar = currLine.split(" ");
			//SetCharToCell cc = se.new SetCharToCell(Integer.parseInt(cChar[1]), cChar[2]);
			//converted.addElement(cc);
		} else if (currLine.startsWith("/~disp-cell-raise:")) {
			String[] rr = currLine.split(" ");
			//RaiseOneCellPin rcp = se.new RaiseOneCellPin(Integer.parseInt(rr[1]), rr[2]);
			//converted.addElement(rcp);
		} else if (currLine.startsWith("/~disp-cell-lower:")) {
			String[] ll = currLine.split(" ");
			//LowerOneCellPin lcp = se.new LowerOneCellPin(Integer.parseInt(ll[1]), ll[2]);
			//converted.addElement(lcp);
		} else if (currLine.startsWith("/~")) {	//section header
			String[] h = currLine.split(" ");
			//SkipHeader sh = se.new SkipHeader(h[1]);
			//converted.addElement(sh);
		} else { //no keyphrases - just read and store line
			//Add a Sentence object
			String[] str = currLine.split(" ", 1);
			AddASentence ads = se.new AddASentence(str[0]);
			converted.addElement(ads);
		}
	}
	
	public static void printList() {
		for (int i = 0; i < converted.size(); i++) {
			String curr = converted.getElementAt(i).toString();
			System.out.print(curr);
		}
	}
}
