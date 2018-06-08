package com.dbtw.widgets;

import java.io.File;
import java.io.PrintWriter;

import com.dbtw.enumerations.OperatingSystems;

public class DebugLogger {
  //Static variables
  private static DebugLogger logger;
  //Constants
  //Private variables
  private String filename = "UnknownDebug.log";
  private PrintWriter log;
  private int indent = 0; 
  private int increment = 2;
  //Public variables

  //Constructors
  private DebugLogger() {
    init();
  }

  //Static methods
  public static DebugLogger getInstance() {
    if (logger == null) {
      logger = new DebugLogger();
    }
    return logger;
  }

  public static void logMsg(String msg) {
    DebugLogger.getInstance().log(msg);
  }
  
  public static void logMsg(String className, String methodName, String msg) {
    String hdr = className + "." + methodName;
    DebugLogger log = DebugLogger.getInstance();
    log.logHeader(hdr);
    log.log(msg);
  }
  
  public static void indentPlus() {
    DebugLogger.getInstance().increment();
  }
  
  public static void indentMinus() {
    DebugLogger.getInstance().decrement();
  }
  
  //Public methods
  public void logHeader(String msg) {
    log(msg);
    increment();
  }
  
  public void logFooter(String msg) {
    decrement();
    log(msg);
  }
  
  public void log(String msg) {
    try {
      log.println(lpad(msg));
      log.flush();
    }
    catch (Exception e) {
      e.printStackTrace(System.out);
    }
  }
  
  public void setIndentIncrement(int size) {
    if (size >= 0) {
      increment = size;
    }
  }
  
  public void increment() {
    indent += increment;
  }
  
  public void decrement() {
    indent -= increment;
  }
  
  //Private methods
  private void init() {
    try {
      OperatingSystems env = (OperatingSystems) UserPrefs.getInstance().getParameter("OperatingSystem");
      String path = "";
      filename = ((String) UserPrefs.getInstance().getParameter("AppName")) + "_debug.log";
      switch (env) {
        case LINUX: {
          path = System.getenv("HOME");
          break;
        }
        case WINDOWS7: {
          path = System.getenv("USERPROFILE");
          break;
        }
        case WINDOWS8: {
          path = System.getenv("USERPROFILE");
          break;
        }
        case WINDOWS10: {
          path = System.getenv("USERPROFILE");
          break;
        }
      }
      log = new PrintWriter(new File(path, filename));
    }
    catch (Exception e) {
      e.printStackTrace(System.out);
    }
  }
  
  private String lpad(String txt) {
    String text = "";
    for (int i = 0; i < indent; i++) {
      text += " ";
    }
    text += txt;
    return text;
  }
}
