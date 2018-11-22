package enamel;

import java.util.LinkedList;

public class ScenObjectsList extends LinkedList<Object>{

	private LinkedList<Object> eventObj;
	
	private int size;
	
	public ScenObjectsList() {
		this.eventObj = new LinkedList<Object>();
		setSize(0);
	}
	
	public void add(int ind, Object event) {
		int index = ind;
		if (index > this.eventObj.size()) {
			eventObj.addLast(event);
			setSize(getSize() + 1);
			//update the index
		} else if (index == 0) {
			eventObj.addFirst(event);
			setSize(getSize() + 1);
			//update the index
		} else {
			eventObj.add(event);
			setSize(getSize() + 1);
			//update the index
		}
		
		for (int i = 0; i < eventObj.size(); i++) {
			System.out.println(eventObj.get(i));
		}
	}
	public void setSize(int s) {
		this.size = s;
	}
	
	public int getSize() {
		return this.size;
	}
	
	
}
