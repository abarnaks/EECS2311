package enamel;

public class ScenEvents {

//need toString methods for all the objects
	public class CellsButtons implements Comparable<CellsButtons> {
		
		int cells;
		int buttons;
		public CellsButtons(int cells, int buttons) {
			this.cells = cells;
			this.buttons = buttons;
		}
		
		public int getCells() {
			return cells;
		}
		
		public int getBtns() {
			return buttons;
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

		@Override
		public int compareTo(AddASentence o) {
			// TODO Auto-generated method stub
			return 0;
		}
		
		
	}
	
	public class Pause implements Comparable<Pause> {
		int pauseTime;
		public Pause(int pauseTime) {
			this.pauseTime = pauseTime;
		}
		
		public int getPauseTime() {
			return pauseTime;
		}

		@Override
		public int compareTo(Pause o) {
			// TODO Auto-generated method stub
			return 0;
		}
	}
	
	public class DisplaySentence implements Comparable<DisplaySentence> {
		String strToDisp;
		public DisplaySentence(String str) {
			this.strToDisp = str;
		}
		
		public String getStrToDisp() {
			return strToDisp;
		}

		@Override
		public int compareTo(DisplaySentence o) {
			// TODO Auto-generated method stub
			return 0;
		}
	}
	
	public class SentenceToRepeat implements Comparable<SentenceToRepeat> {
		String strRep;
		public SentenceToRepeat(String str) {
			this.strRep = str;
		}
		
		public String getStrRep() {
			return strRep;
		}

		@Override
		public int compareTo(SentenceToRepeat o) {
			// TODO Auto-generated method stub
			return 0;
		}
	}
	
	//public class InsertRepeatButton implements Comparable
	
}
