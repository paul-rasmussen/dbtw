package com.dbtw.models;

import java.util.Iterator;
import java.util.Vector;

import com.dbtw.widgets.DebugLogger;
import com.dbtw.widgets.LogFile;
import com.dbtw.widgets.UserPrefs;

public class ParsedRow {
  //Constants
  //Private variables
  //Protected variables
  protected Vector<Object> items = new Vector<Object>();
  
  //Public variables

  //Constructors
  public ParsedRow() {
    init();
  }

  //Static methods
  //Public methods
  public void addItem(Object obj) {
    items.add(obj);
  }
  
  public Object getItem(int index) {
    return items.elementAt(index);
  }
  
  public int getItemCount() {
    return items.size();
  }
  
  public void addItems(Vector<Object> itemset) {
    items.addAll(itemset);
  }
  
  public String toString() {
    String txt = "{";
    for (Iterator<Object> i = items.iterator(); i.hasNext(); ) {
      txt += i.next().toString();
    }
    txt += "}";
    return txt;
  }
  
  //Protected methods
  //Private methods
  private void init() {
  }
}
