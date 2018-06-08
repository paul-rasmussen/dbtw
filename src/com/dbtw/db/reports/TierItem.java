package com.dbtw.db.reports;

import java.util.Vector;

public class TierItem {
  //private variables
	private String label = new String();
	private Vector<TierItem> parents = new Vector<TierItem>();
	private Vector<TierItem> children = new Vector<TierItem>();
	//public variables
	//static variables
	
	//constructors
	public TierItem() {
	}
	
	public TierItem(String label) {
		this.label = label;
	}
	
	//static methods
	//public methods
	public void setLabel(String label) {
		this.label = label;
	}
	
	public String getLabel() {
		return label;
	}
	
	public void addParent(TierItem parent) {
		parents.add(parent);
	}
	
	public TierItem getParent(int index) {
		return parents.elementAt(index);
	}
	
	public int getParentCount() {
		return parents.size();
	}
	
	public void addChild(TierItem child) {
		children.add(child);
	}
	
	public TierItem getChild(int index) {
		return children.elementAt(index);
	}
	
	public int getChildCount() {
		return children.size();
	}
	
	//private methods
}
