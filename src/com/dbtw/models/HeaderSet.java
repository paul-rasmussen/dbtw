package com.dbtw.models;

import java.util.Vector;

import com.dbtw.widgets.DebugLogger;
import com.dbtw.widgets.LogFile;
import com.dbtw.widgets.UserPrefs;

public class HeaderSet {
  //Constants
  //Private variables
  //Protected variables
  protected String name = "";
  protected Vector<ParsedRow> data = new Vector<ParsedRow>();
  
  //Public variables

  //Constructors
  public HeaderSet() {
  }
  
  public HeaderSet(String title) {
    init(title);
  }

  public HeaderSet(String title, Vector<ParsedRow> dataSet) {
    init(title, dataSet);
  }

  //Static methods
  //Public methods
  public void setName(String title) {
    name = title;
  }
  
  public String getName() {
    return name;
  }
  
  public ParsedRow getRow(int index) {
    return data.elementAt(index);
  }
  
  public int getRowCount() {
    return data.size();
  }
  
  public void addRow(ParsedRow row) {
    data.add(row);
  }
  
  public String toString() {
    String txt = "{";
    txt += "[[" + name + "][";
    txt += data.toString();
    txt += "]}";
    return txt;
  }
  
  //Protected methods
  //Private methods
  private void init(String title) {
    name = title;
  }
  
  private void init(String title, Vector<ParsedRow> dataSet) {
    name = title;
    data = dataSet;
  }
}
