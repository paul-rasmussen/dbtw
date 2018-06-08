package com.dbtw.widgets;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Vector;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import com.dbtw.widgets.LogFile;

public class CsvParser {
  //Static variables
  //Constants
  private final String WHOAMI = "CsvParser";
  private final boolean DEBUG = false;
  //Private variables
  private int indent = 0;
  private Vector<String> header = new Vector<String>();
  private Vector<HashMap<String, String>> data = new Vector<HashMap<String, String>>();
  //Public variables

  //Constructors
  public CsvParser(File src) {
    init(src);
  }

  //Static methods
  //Public methods
  public Vector<String> getHeaders() {
    return header;
  }
  
  public HashMap<String, String> getRow(int index) {
    return data.elementAt(index);
  }
  
  public Vector<HashMap<String, String>> getRows() {
    return data;
  }
  
  public int getRowCount() {
    return data.size();
  }
  
  public int getColumnCount() {
    return header.size();
  }
  
  public String getHeader(int index) {
    return header.elementAt(index);
  }
  
  public String pullToken(String txt, int index) {
    return getTokens(txt).elementAt(index);
  }
  
  //Private methods
  private void init(File src) {
    String errm = "";
    try {
      loadFile(src);
    }
    catch (Exception e) {
      logError("init", errm, e);
    }
  }

  private boolean loadFile(File src) {
    boolean result = false;
    String errm = "Start loadFile";
    int rows = 0;
    try {
      errm = "Creating buffered reader for " + src.getName();
      BufferedReader rdr = new BufferedReader(new FileReader(src));
      while (rdr.ready()) {
        errm = "Initilizing setup for new line";
        String line = rdr.readLine();
        errm = "Tokenizing " + line;
        Vector<String> tokens = getTokens(line);

        if (rows == 0) {
          errm = "Setting first row of tokens to header";
          header = tokens;
        }
        else {
          errm = "Adding row data";
          HashMap<String, String> row = new HashMap<String, String>();
          for (int i = 0; i < header.size(); i++) {
            errm = "Adding " + header.elementAt(i) + ", " + tokens.elementAt(i);
            row.put(header.elementAt(i), tokens.elementAt(i));
          }
          data.add(row);
        }
        rows++;
      }
      rdr.close();
      result = true;
    }
    catch (Exception e) {
      logError("loadFile", errm, e);
    }
    errm = "Exiting loadFile";
    return result;
  }
  
  private Vector<String> getTokens(String txt) {
    Vector<String> tokens = new Vector<String>();
    String errm = "Initializing getToken(\"" + txt + "\")";
    try {
      while (txt.length() > 0) {
        errm = "Fetching token from " + txt;
        String token = getToken(txt);
        if (token == null) {
          token = " ";
        }
        errm = "Adding " + token + " to token set";
        tokens.add(token);
        if (txt.indexOf(",") >= 0) {
          txt = txt.substring(txt.indexOf(",") + 1);
        }
        else {
          txt = "";
        }
      }
      while (tokens.size() < header.size()) {
        tokens.add("");
      }
    }
    catch (Exception e) {
      logError("getToken", errm, e);
    }
    errm = "Returning";
    return tokens;
  }
  
  private String getToken(String txt) {
    String errm = "";
    try {
      if (txt.indexOf(",") == -1) {
        return txt.trim();
      }
      else {
        return txt.substring(0, txt.indexOf(",")).trim();
      }
    }
    catch (Exception e) {
      logError("getToken", errm, e);
    }
    return null;
  }
  
  private void debugData() {
    DebugLogger.logMsg("---------------------------------------");
    DebugLogger.logMsg("CsvParser.debugData()");
    String msg = "";
    for (Iterator<String> h = header.iterator(); h.hasNext(); ) {
      msg += StringWidget.lpad(h.next(), 15);
    }
    DebugLogger.logMsg(msg);
    for (int i = 0; i < 10; i++) {
      msg = "";
      HashMap<String, String> row = data.elementAt(i);
      for (Iterator<String> k = header.iterator(); k.hasNext(); ) {
        msg += StringWidget.lpad(row.get(k.next()), 15);
      }
      DebugLogger.logMsg(msg);
    }
    DebugLogger.logMsg("---------------------------------------");
  }
  
  private void logError(String method, String msg, Exception e) {
    LogFile log = LogFile.getInstance();
    log.writeLabel(WHOAMI, method);
    log.writeMsg(msg);
    log.writeDump(e);
    e.printStackTrace(System.out);
  }
}
