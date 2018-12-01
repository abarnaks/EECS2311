package enamel;

import java.io.File;

public class ScenEvents {

//need toString methods for all the objects
//	public Object getCellsBtns() {
//		return CellsButtons.class;
//	}

	public class Cells {
		int cells;
		
		public Cells(int cells) {
			this.cells = cells;
		}
		
		public int getCells() {
			return cells;
		}
		
		public void setCells(int editCells) {
			this.cells = editCells;
		}

		@Override 
		public String toString() {
			return "Number of cells: " + getCells();
		}
		
		public String toFile() {
			return "Cell " + getCells();
		}
	}
	
	public class Buttons {
		int buttons;
		
		public Buttons(int btns) {
			this.buttons = btns;
		}
		
		public int getBtns() {
			return buttons;
		}
		
		public void setBtns(int editBtns) {
			this.buttons = editBtns;
		}

		@Override 
		public String toString() {
			return "Number of buttons: " + getBtns();
		}
		
		public String toFile() {
			return "Button " + getBtns();
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
		
		public String toFile() {
			return getStrToRead() + "\n";
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
		
		public String toFile() {
			return "/~pause:" + getPauseTime() + "\n";
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
		
		public String toFile() {
			return "/~disp-string:" + getStrToDisp() + "\n";
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
		
		public String toFile() {
			return "/~repeat\n" + getStrRep() + "\n/~endrepeat \n";
		}

		@Override
		public int compareTo(SentenceToRepeat o) {
			// TODO Auto-generated method stub
			return 0;
		}
	}
	
	public class InsertRepeatButton implements Comparable<InsertRepeatButton> {
		
		int repBtnInd;
		public InsertRepeatButton(int n) {
			this.repBtnInd = n;
		}
		
		public int getRepBtnInd() {
			return repBtnInd;
		}
		
		public void setRepBtnInd(int en) {
			this.repBtnInd = en;
		}
		
		@Override 
		public String toString() {
			return "Set button number " + (getRepBtnInd() + 1) + " to repeat the section under repeat above";
		}
		
		public String toFile() {
			return "/~repeat-button:" + getRepBtnInd() + "\n";
		}
		
		@Override
		public int compareTo(InsertRepeatButton arg0) {
			
			// TODO Auto-generated method stub
			return 0;
		}
	}
	
	public class UserInput {
		@Override
		public String toString() {
			return "Wait for response from user";
		}
		
		public String toFile() {
			return "/~user-input";
		}
	}
	
	//pick a button within the range of buttons entered and set it to skip to the skip header
	public class SetSkipButton {
		//maybe try a combo box
		int numSkipButton;
		String skipTo;
		public SetSkipButton (int ind, String s) {
			this.numSkipButton = ind;
			this.skipTo = s;
		}
		
		public int getSkipBtn() {
			return numSkipButton;
		}
		
		public void setSkipBtn(int i) {
			this.numSkipButton = i;
		}
		
		public String getSkipTo() {
			return skipTo;
		}
		
		public void setSkipTo(String es) {
			this.skipTo = es;
		}
		
		@Override
		public String toString() {
			return "Press button " + (getSkipBtn() + 1) + " to skip to " + getSkipTo();
		}
		
		public String toFile() {
			return "/~skip-button:" + getSkipBtn() + " " + getSkipTo() + "\n";
		}
		
	}
	//before that, ask user to add heading before each "question"
	public class SkipHeader {
		String header;
		public SkipHeader (String h) {
			this.header = h;
		}
		
		public String getHeader() {
			return header;
		}
		
		public void setHeader(String eh) {
			this.header = eh;
		}
		
		@Override
		public String toString() {
			return "Section title: " + getHeader();
		}
		
		public String toFile() {
			return "/~" + getHeader() + "\n";
		}
		
	}
	
	// so far, only have it to insert existing sound file
	public class InsertSound {
		String audioFile;
		public InsertSound(String sfName) {
			this.audioFile = sfName;
		}
		
		public String getFile() {
			return audioFile;
		}
		
		@Override
		public String toString() {
			return "Play Sound: " + audioFile;
		}
		
		public String toFile() {
			return "/~sound:" + getFile() + "\n";
		}
	}
	
	// is this enough
	public class ResetButtons {
		@Override
		public String toString() {
			return "Reset all buttons";
		}
		
		public String toFile() {
			return "/~reset-buttons";
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
	
	//make combo box
	public class OneCellClear {
		int indCell;
		public OneCellClear(int index) {
			this.indCell = index;
		}
		
		public int getIndCell() {
			return indCell;
		}
		
		public void setIndCell(int ind) {
			this.indCell = ind;
		}
		
		@Override
		public String toString() {
			return "Clear cell number: " + (getIndCell() + 1);
		}
		
		public String toFile() {
			return "/~disp-clear-cell:" + getIndCell() + "\n";
		}
	}
	
	public class SetCharToCell {
		int indCell;
		String character;
		
		public SetCharToCell(int index, String c) {
			this.indCell = index - 1;
			this.character = c;
		}
		
		public int getIndCell() {
			return indCell + 1;
		}
		
		public void setIndCell(int ind) {
			this.indCell = ind - 1;
		}
		
		public String getChar() {
			return character;
		}
		
		public void setChar(String ec) {
			this.character = ec;
		}
		
		@Override
		public String toString() {
			return "Set cell number " + getIndCell() + "to character" + getChar();
		}
		
		public String toFile() {
			return "/~disp-cell-char:" + getIndCell() + " " + getChar() + "\n";
		}
	}
	
	//binary sequence to set the cell pin
	public class SetCellPins {
		int cellNum;
		String seq;
		
		public SetCellPins(int i, String s) {
			this.cellNum = i;
			this.seq = s;
		}
		
		public int getCellNum() {
			return cellNum;
		}
		
		public void setCellNum(int ei) {
			this.cellNum = ei;
		}
		
		public String getSeq() {
			return seq;
		}
		
		public void setSeq(String si) {
			this.seq = si;
		}
		
		@Override
		public String toString() {
			return "Set cell number " + getCellNum() + "to sequence " + getSeq();
		}
		
		public String toFile() {
			return "/~disp-cell-pins:" + getCellNum() + " " + getSeq() + "\n";
		}
	}
	
	public class RaiseOneCellPin {
		int cellInd;
		String pinInd;
		
		public RaiseOneCellPin(int c, String p) {
			this.cellInd = c;
			this.pinInd = p;
		}
		
		public int getCellIndex() {
			return cellInd;
		}
		
		public String getPinIndex() {
			return pinInd;
		}
		
		public void setCellIndex(int n) {
			this.cellInd = n;
		}
		
		public void setPinIndex(String n) {
			this.pinInd = n;
		}
		
		@Override
		public String toString() {
			return "Raise pin number " + getPinIndex() + "in Cell number " + (getCellIndex() + 1);
		}
		
		public String toFile() {
			return "/~disp-cell-raise:" + getCellIndex() + " " + getPinIndex() + "\n";
		}
	}
	
	public class LowerOneCellPin {
		int cellInd;
		String pinInd;
		
		public LowerOneCellPin(int c, String p) {
			this.cellInd = c;
			this.pinInd = p;
		}
		
		public int getCellIndex() {
			return cellInd;
		}
		
		public String getPinIndex() {
			return pinInd;
		}
		
		public void setCellIndex(int n) {
			this.cellInd = n;
		}
		
		public void setPinIndex(String n) {
			this.pinInd = n;
		}
		
		@Override
		public String toString() {
			return "Lower pin number " + getPinIndex() + "in Cell number " + getCellIndex();
		}
		
		public String toFile() {
			return "/~disp-cell-lower:" + getCellIndex() + " " + getPinIndex() + "\n";
		}
	}
}
