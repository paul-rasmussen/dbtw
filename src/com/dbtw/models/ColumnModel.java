package com.dbtw.models;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Vector;

import com.dbtw.widgets.LogFile;
import com.dbtw.widgets.StringWidget;

public class ColumnModel {
  //Static variables
  public static final int DATA_TYPE = 0;
  public static final int LENGTH = 1;
  public static final int PRECISION = 2;
  public static final int SCALE = 3;
  public static final int DEFAULT = 4;
  public static final int NULLABLE = 5;
  //Constants
  private final String WHOAMI = "ColumnModel";
  private Vector<String> labels = new Vector<String>();
  //Private variables
  private int indent = 0;
  private String name = "";
  private String alias = "";
  private HashMap<String, String> attribs = new HashMap<String, String>();
  //Public variables

  //Constructors
  public ColumnModel() {
    init();
  }

  //Static methods
  //Public methods
  public void setName( String name) {
    this.name = name;
  }
  
  public String getName() {
    return name;
  }
  
  public void setAlias(String name) {
    alias = name;
  }
  
  public String getAlias() {
    return alias;
  }
  
  public String getColumnAttribute(int attrib) {
    return getAttrib(attrib);
  }
  
  public void setColumnAttribute(int attrib, String value) {
    setAttrib(attrib, value);
  }
  
  public int getLabelIndex(String label) {
    for (int i = 0; i < labels.size(); i++) {
      if (labels.elementAt(i).equals(label)) {
        return i;
      }
    }
    return -1;
  }
  
  public Vector<String> getAttribList() {
    return attribList();
  }

  @Override
  public String toString() {
    String txt = "";
    txt = name;
    if ((alias != null) && (alias.length() > 0)) {
      txt += " (" + alias + ")";
    }
    txt += ":" + attribs.get("dataType") + ":" + attribs.get("len");
    return txt;
  }
  
  //Private methods
  private void init() {
    String errm = "";
    try {
      attribs = new HashMap<String, String>();
      labels = new Vector<String>();
      labels.add("dataType");
      labels.add("len");
      labels.add("prec");
      labels.add("scale");
      labels.add("default");
      labels.add("null");
      labels.add("fk");
    }
    catch (Exception e) {
      logError("init", errm, e);
    }
  }

  private String getAttrib(int attrib) {
    String errm = "";
    try {
      if (attribs.containsKey(labels.elementAt(attrib))) {
        return attribs.get(labels.elementAt(attrib));
      }
    }
    catch (Exception e) {
      logError("getAttrib", errm, e);
    }
    return null;
  }
  
  private void setAttrib(int attrib, String value) {
    String errm = "";
    try {
      if ((DATA_TYPE <= attrib) && (attrib <= NULLABLE)) {
        if (attribs.containsKey(labels.elementAt(attrib))) {
          attribs.remove(labels.elementAt(attrib));
        }
        attribs.put(labels.elementAt(attrib), value);
      }
    }
    catch (Exception e) {
      logError("setAttrib", errm, e);
    }
  }
  
  private Vector<String> attribList() {
    Vector<String> alist = new Vector<String>();
    for (Iterator<String> a = attribs.keySet().iterator(); a.hasNext(); ) {
      alist.add(a.next());
    }
    return alist;
  }
  
  private void logError(String method, String msg, Exception e) {
    LogFile log = LogFile.getInstance();
    log.writeLabel(WHOAMI, method);
    log.writeMsg(msg);
    log.writeDump(e);
    e.printStackTrace(System.out);
  }
  
  private void debug() {
    LogFile.getInstance().writeMsg("ColumnModel - Debug Data");
    for (Iterator<String> keys = attribs.keySet().iterator(); keys.hasNext(); ) {
      String key = keys.next();
      LogFile.getInstance().writeMsg(StringWidget.lpad(key, 10) + StringWidget.lpad(attribs.get(key), 30));
    }
  }
}
