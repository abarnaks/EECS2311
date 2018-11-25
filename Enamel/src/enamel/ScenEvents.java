package enamel;

import java.io.File;

public class ScenEvents {

//need toString methods for all the objects
	public class CellsButtons implements Comparable<CellsButtons> {
		
		public String getKeyword() {
			return "CellsButtons";
		}
		
		int cells;
		int buttons;
		public CellsButtons(int cells, int buttons) {
			this.cells = cells;
			this.buttons = buttons;
		}
		
		public int getCells() {
			return cells;
		}
		
		public void setCells(int editCells) {
			this.cells = editCells;
		}
		
		public int getBtns() {
			return buttons;
		}
		
		public void setBtns(int editBtns) {
			this.buttons = editBtns;
		}

		@Override
		public String toString() {
			return "<html> Number of cells: " + getCells() + "<br/> Number of buttons: " + getBtns();
		}
		
		public String toFile() {
			return "Cell " + getCells() + "\n Button " + getBtns() + "\n\n";
		}
		
		@Override
		public int compareTo(CellsButtons arg0) {
			// TODO Auto-generated method stub
			return 0;
		}
	}
	
	public class AddASentence implements Comparable<AddASentence> {
		String strToRead;
		public AddASentence(String str) {
			this.strToRead = str;
		}
		
		public String getStrToRead() {
			return strToRead;
		}
		
		public void setStrToRead(String editStr) {
			this.strToRead = editStr;
		}
		
		@Override 
		public String toString() {
			return "Read: " + getStrToRead();
		}

		@Override
		public int compareTo(AddASentence o) {
			// TODO Auto-generated method stub
			return 0;
		}
		
		
	}
	
	public class Pause implements Comparable<Pause> {
		public String getKeyword() {
			return "Pause";
		}
		
		int pauseTime;
		public Pause(int pauseTime) {
			this.pauseTime = pauseTime;
		}
		
		public int getPauseTime() {
			return pauseTime;
		}

		public void setPauseTime(int editPause) {
			this.pauseTime = editPause;
		}
		
		@Override 
		public String toString() {
			return "Pause for: " + getPauseTime();
		}
		
		@Override
		public int compareTo(Pause o) {
			// TODO Auto-generated method stub
			return 0;
		}
	}
	
	public class DisplaySentence implements Comparable<DisplaySentence> {
		public String getKeyword() {
			return "Display";
		}
		
		String strToDisp;
		public DisplaySentence(String str) {
			this.strToDisp = str;
		}
		
		public String getStrToDisp() {
			return strToDisp;
		}
		
		public void setStrToDisp(String editStr) {
			this.strToDisp = editStr;
		}
		
		@Override
		public String toString() {
			return "Display: " + getStrToDisp();
		}

		@Override
		public int compareTo(DisplaySentence o) {
			// TODO Auto-generated method stub
			return 0;
		}
	}
	
	public class SentenceToRepeat implements Comparable<SentenceToRepeat> {
		public String getKeyword() {
			return "SentenceRepeat";
		}
		
		String strRep;
		public SentenceToRepeat(String str) {
			this.strRep = str;
		}
		
		public String getStrRep() {
			return strRep;
		}
		
		public void setStrRep(String editStr) {
			this.strRep = editStr;
		}
		
		@Override
		public String toString() {
			return "Line to repeat: " + getStrRep();
		}

		@Override
		public int compareTo(SentenceToRepeat o) {
			// TODO Auto-generated method stub
			return 0;
		}
	}
	
	public class InsertRepeatButton implements Comparable<InsertRepeatButton> {
		public String getKeyword() {
			return "RepeatButton";
		}
		
		String repBtnText;
		public InsertRepeatButton(String str) {
			this.repBtnText = str;
		}
		
		public String getRepBtnText() {
			return repBtnText;
		}
		
		public void setRepBtnText(String editText) {
			this.repBtnText = editText;
		}
		
		@Override 
		public String toString() {
			return "Name for the repeat button: " + getRepBtnText();
		}
		
		@Override
		public int compareTo(InsertRepeatButton arg0) {
			
			// TODO Auto-generated method stub
			return 0;
		}
	}
	
	public class SetSkipButton {
		
		int numSkipButtons;
		public SetSkipButton (int num) {
			this.numSkipButtons =num;
		}
		
		
	}
	//before that, ask user to add heading before each "question"
	public class ButtonToSkip {
		
	}
	
	public class InsertSound {
		File audioFile;
		public InsertSound(File sf) {
			this.audioFile = sf;
		}
		
		public File getFile() {
			return audioFile;
		}
		
		@Override
		public String toString() {
			return "Play Sound: " + audioFile.getName();
		}
	}
	
	// is this enough
	public class ResetButtons {
		@Override
		public String toString() {
			return "Reset all buttons";
		}
		
		public String toFile() {
			return "/~reset-buttons\n";
		}
	}
	
	public class ClearAllCells {
		
		@Override
		public String toString() {
			return "Clear All Cells";
		}
		
		public String toFile() {
			return "/~disp-clearAll\n";
		}
	}
	
	public class OneCellClear {
		int indCell;
		public OneCellClear(int index) {
			this.indCell = index - 1;
		}
		
		public int getIndCell() {
			return indCell + 1;
		}
		
		public void setIndCell(int ind) {
			this.indCell = ind - 1;
		}
		
		@Override
		public String toString() {
			return "Clear cell number: " + getIndCell();
		}
	}
	
	public class SetCharToCell {
		int indCell;
		char character;
		
		public SetCharToCell(int index, char c) {
			this.indCell = index - 1;
			this.character = c;
		}
		
		public int getIndCell() {
			return indCell + 1;
		}
		
		public void setIndCell(int ind) {
			this.indCell = ind - 1;
		}
		
		public char getChar() {
			return character;
		}
		
		public void setChar(char ec) {
			this.character = ec;
		}
		
		@Override
		public String toString() {
			return "Set cell number " + getIndCell() + "to character" + getChar();
		}
	}
	
	public class RaiseOneCellPin {
		
	}
	
	public class LowerOneCellPin {
		
	}
}
