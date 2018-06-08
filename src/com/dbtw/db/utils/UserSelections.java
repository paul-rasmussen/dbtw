package com.dbtw.db.utils;

import java.io.File;
import java.sql.Connection;

public class UserSelections {
	//Static variables
	private static UserSelections instance = null;
	//Constants
	public static final int EMPIRE_SCHEMA = 0;
	public static final int ANALYSIS_SCHEMA = 1;
	//Private variables
	private File out;
	private String targetDir;
	private String schema;
	private String analschema;
	private Connection conn;
	
	//Public variables

	//Constructors
	private UserSelections() {
	}

	//Static methods
	public static UserSelections getInstance() {
		if (instance == null) {
			instance = new UserSelections();
		}
		return instance;
	}
	
	//Public methods
	public void setConnection(Connection connection) {
		conn = connection;
	}

	public Connection getConnection() {
		return conn;
	}
	
	public void setFile(File dest) {
		out = dest;
	}
	
	public File getFile() {
		return out;
	}
	
	public void setOutDir(String dir) {
		targetDir = dir;
	}
	
	public String getOutDir() {
		return targetDir;
	}
	
	public void setSchema(int schemaUse, String schemaname) {
		switch (schemaUse) {
			case (EMPIRE_SCHEMA): {
				schema = schemaname;
			}
			case (ANALYSIS_SCHEMA): {
				schema = analschema;
			}
		}
	}
	
	public String getSchema(int schemaUse) {
		String txt = "";
		switch (schemaUse) {
			case (EMPIRE_SCHEMA): {
				txt = schema;
			}
			case (ANALYSIS_SCHEMA): {
				txt = analschema;
			}
		}
		return txt;
	}
	
	//Private methods
}
