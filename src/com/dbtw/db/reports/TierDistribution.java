package com.dbtw.db.reports;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Enumeration;
import java.util.Vector;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class TierDistribution {
  //private variables
	private Connection conn;
	private String schema = new String();
	private Vector<TierItem> nodes = new Vector<TierItem>();
	//public variables
	//static variables
	
	//constructors
	public TierDistribution(Connection conn, String schema) {
		this.conn = conn;
		this.schema = schema;
		loadNodes();
	}
	
	//static methods
	//public methods
	//private methods
	private void loadNodes() {
		String errm = "";
		String sql = "select table_name from dba_tables where owner = '?'";
    PreparedStatement pstmt;
    ResultSet rst;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, schema);
			rst = pstmt.executeQuery();
			while (rst.next()) {
				nodes.add(new TierItem(rst.getString(1)));
			}
			Enumeration<TierItem> e = nodes.elements();
			while (e.hasMoreElements()) {
				TierItem it = e.nextElement();
				sql = "select c2.table_name from dba_constraints c1, dba_constraints c2 ";
        sql += "where c1.owner = '?' and c1.table_name = '?' and c1.constraint_type = '?'";
        sql += "and c2.owner = c1.r_owner and c2.constraint_name = c1.r_constraint_name";
        pstmt = conn.prepareStatement(sql);
        pstmt.setString(1,schema);
        pstmt.setString(2,it.getLabel());
        pstmt.setString(3, "R");
        rst = pstmt.executeQuery();
        while (rst.next()) {
        	for (int i = 0; i < nodes.size(); i++) {
        		if (nodes.elementAt(i).getLabel().equalsIgnoreCase(rst.getString(1))) {
        			TierItem ti = nodes.elementAt(i);
        			it.addParent(ti);
        			ti.addChild(it);
        		}
        	}
        }
			}
		}
		catch (Exception e ) {
			errm += "\n" + e.getMessage();
			JOptionPane.showMessageDialog(new JFrame(),"errm","Application Error - TierDistribution",JOptionPane.OK_OPTION);
		}
	}
}
