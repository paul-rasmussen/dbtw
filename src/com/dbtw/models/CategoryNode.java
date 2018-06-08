package com.dbtw.models;

import java.util.Date;
import java.util.HashMap;

import javax.swing.tree.DefaultMutableTreeNode;

import com.dbtw.widgets.DebugLogger;
import com.dbtw.widgets.LogFile;
import com.dbtw.widgets.UserPrefs;

public class CategoryNode extends DefaultMutableTreeNode {
  //Constants
  private final String WHOAMI = "CategoryNode";
  //Public variables
  //Protected variables
  protected HashMap<String, Object> columns = new HashMap<String, Object>();
  //Private variables

  //Constructors
  public CategoryNode() {
    init();
  }

  //Static methods
  //Public methods
  public void setColumn(String name, Object value) {
    columns.put(name, value);
  }
  
  public Object getColumn(String name) {
    return columns.get(name);
  }
  
  //Protected methods
  //Private methods
  private void init() {
  }

  private void logError(String method, String msg, Exception e) {
    LogFile log = LogFile.getInstance();
    log.writeLabel(WHOAMI, method);
    log.writeMsg(msg);
    log.writeDump(e);
    e.printStackTrace(System.out);
  }

  private void debugLog(String msg, boolean indent, boolean outdent) {
    DebugLogger log = DebugLogger.getInstance();
    if (indent) {
      log.increment();;
    }
    log.logMsg(msg);
    if (outdent) {
      log.decrement();;
    }
  }
}
