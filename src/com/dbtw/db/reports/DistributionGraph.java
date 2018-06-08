package com.dbtw.db.reports;

import java.util.Vector;

import javax.swing.JPanel;

class DistributionGraph extends JPanel {
	//private variables
	private static final long serialVersionUID = 1L;
	private Vector<TierItem> tables;
	
	//public variables
	//static variables
	
	//Constructors
	public DistributionGraph() {
	}
	
	public DistributionGraph(Vector<TierItem> tables) {
		this.tables = tables;
	}
	
	//static methods
	//public methods
	//private methods
}
