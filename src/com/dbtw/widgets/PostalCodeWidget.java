package com.dbtw.widgets;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Vector;

import com.dbtw.widgets.LogFile;

public class PostalCodeWidget {
  //Static variables
  //Constants
  private final String WHOAMI = "PostalCodeWidget";
  //Private variables
  private int indent = 0;
  private Vector<HashMap<String, String>> code = new Vector<HashMap<String,String>>();
  
  //Public variables

  //Constructors
  public PostalCodeWidget(String code) {
    init(code);
  }

  //Static methods
  //Public methods
  public void setCode(String newCode) {
    parseCode(newCode);
  }
  
  public String getCode() {
    return assembleCode();
  }
  
  
  //Private methods
  private void init(String code) {
    String errm = "";
    try {
      this.code = new Vector<HashMap<String,String>>();
      parseCode(code);
    }
    catch (Exception e) {
      logError("init", errm, e);
    }
  }
  
  private void parseCode(String code) {
	  String errm = "";
    try {
      int space = code.indexOf(" ");
      int dash = code.indexOf("-");
      while ((space != -1) || (dash != -1)) {
        HashMap<String, String> parts = new HashMap<String, String>();
        if (space < dash) {
          parts.put("part", code.substring(0, space));
          parts.put("suffix", " ");
        }
        else {
          parts.put("part", code.substring(0, dash));
          parts.put("suffix", "-");
        }
        this.code.add(parts);
        space = code.indexOf(" ");
        dash = code.indexOf("-");
      }
      HashMap<String, String> parts = new HashMap<String, String>();
      parts.put("part", code.substring(0, dash));
      parts.put("suffix", "-");
      this.code.add(parts);
    }
    catch (Exception e) {
      logError("parseCode", errm, e);
    }
  }

  private String assembleCode() {
    String txt = "";
    for (Iterator<HashMap<String, String>> i = code.iterator(); i.hasNext(); ) {
      HashMap<String, String> piece = i.next();
      txt += piece.get("suffix");
      txt += piece.get("part");
    }
    return txt;
  }
  
  private void logError(String method, String msg, Exception e) {
    LogFile log = LogFile.getInstance();
    log.writeLabel(WHOAMI, method);
    log.writeMsg(msg);
    log.writeDump(e);
    e.printStackTrace(System.out);
  }
}

