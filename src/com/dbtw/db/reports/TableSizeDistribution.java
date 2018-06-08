package com.dbtw.db.reports;

import java.sql.Connection;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class TableSizeDistribution {
  //private variables
	private Connection conn;
  private String schema;
	//public variables
	//status variables
	
	//constructors
	public TableSizeDistribution(Connection conn, String schema) {
		this.conn = conn;
		this.schema = schema;
	}
	
	//static methods
	//public methods
	
	//private methods
	private boolean loadData() {
		boolean result = false;
		String sql = "";
		try {
			
		}
		catch (Exception e) {
			String msg = e.getMessage();
			String title = "Application Error - TableSizeDistribution";
			JOptionPane.showMessageDialog(new JFrame(), msg, title, JOptionPane.OK_OPTION);
		}
		return result;
	}
}
