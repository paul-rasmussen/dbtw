package com.dbtw.models;

import java.util.HashMap;
import java.util.Vector;

public class SelectModel {
  //Static variables
  //Constants
  //Private variables
  private String source = "";
  private HashMap<String, String> columns = new HashMap<String, String>();
  private Vector<String> hints = new Vector<String>();
  private boolean distinct = false;
  private boolean unique = false;
  private boolean all = false;
  //Public variables

  //Constructors
  public SelectModel(String sql) {
    init(sql);
  }

  //Static methods
  //Public methods
  //Private methods
  private void init(String sql) {
    source = sql;
  }
}
