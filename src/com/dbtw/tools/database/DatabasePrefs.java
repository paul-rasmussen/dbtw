package com.dbtw.tools.database;

import java.util.Vector;

import com.dbtw.widgets.UserPrefs;

public class DatabasePrefs extends UserPrefs {
  private static final long serialVersionUID = 4938672L;

  private static DatabasePrefs instance = null;
  private Vector<String> includedSchemas = new Vector<String>();
  private Vector<String> excludedSchemas = new Vector<String>();

  private DatabasePrefs() {
    init();
  }
  
  public static DatabasePrefs getInstance() {
    if (instance == null) {
      instance = new DatabasePrefs();
    }
    return instance;
  }
  
  public void addIncludedSchema(String name) {
    includedSchemas.add(name);
  }
  
  public int getIncludedSchemaCount() {
    return includedSchemas.size();
  }
  
  public String getIncludedSchema(int index) {
    return includedSchemas.elementAt(index);
  }
 
  public Vector<String> getIncludedSchemas() {
    return includedSchemas;
  }
  
  public void addExcludedSchema(String name) {
    excludedSchemas.add(name);
  }
  
  public int getExcludedSchemaCount() {
    return excludedSchemas.size();
  }
  
  public String getExcludedSchema(int index) {
    return excludedSchemas.elementAt(index);
  }
  
  public Vector<String> getExcludedSchemas() {
    return excludedSchemas;
  }
  
  private void init() {
  }
  
}
