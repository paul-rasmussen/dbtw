package com.dbtw.widgets;

import java.util.HashMap;

import com.dbtw.widgets.LogFile;

public class CountryWidget {
  //Static variables
  public static final String ABBREV = "abbrev";
  public static final String ISSO2 = "isso2";
  public static final String ISSO3 = "isso3";
  public static final String PHONE = "phonecode";
  public static final String DHS = "dhs";
  public static final String DOS = "dept of state";
  public static final String TRADE = "trade";
  //Constants
  private final String WHOAMI = "CountryWidget";
  //Private variables
  private int indent = 0;
  private String name = "";
  private HashMap<String, String> attribs = new HashMap<String, String>();
  //Public variables

  //Constructors
  public CountryWidget(String name) {
    init(name);
  }

  //Static methods
  //Public methods
  public String getName() {
    return name;
  }
  
  public void setAttributes(HashMap<String, String> attributes) {
    attribs = attributes;
  }
  
  public void setAttribute(String name, String value) {
    setAttrib(name, value);
  }
  
  public String getAttribute(String name) {
    return getAttrib(name);
  }

  //Private methods
  private void init(String name) {
    String errm = "";
    try {
      this.name = name;
    }
    catch (Exception e) {
      logError("init", errm, e);
    }
  }
  
  private boolean load() {
    boolean result = false;
    String errm = "";
    try {
    }
    catch (Exception e) {
      logError(WHOAMI + ".load", errm, e);
    }
    return result;
  }

  private void setAttrib(String name, String value) {
    if (attribs.containsKey(name)) {
      attribs.remove(name);
      attribs.put(name,  value);
    }
    else {
      if (isValidKey(name)) {
        attribs.put(name, value);
      }
    }
  }
  
  private String getAttrib(String name) {
    if (attribs.containsKey(name)) {
      return attribs.get(name);
    }
    return null;
  }
  
  private boolean isValidKey(String name) {
    boolean result = false;
    if (name.equals(ABBREV)) {
      result = true;
    }
    if (name.equals(ISSO2)) {
      result = true;
    }
    if (name.equals(ISSO3)) {
      result = true;
    }
    if (name.equals(PHONE)) {
      result = true;
    }
    if (name.equals(DHS)) {
      result = true;
    }
    if (name.equals(DOS)) {
      result = true;
    }
    if (name.equals(TRADE)) {
      result = true;
    }
    return result;
  }
  
  private void logError(String method, String msg, Exception e) {
    LogFile log = LogFile.getInstance();
    log.writeLabel(WHOAMI, method);
    log.writeMsg(msg);
    log.writeDump(e);
    e.printStackTrace(System.out);
  }
}
