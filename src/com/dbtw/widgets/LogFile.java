package com.dbtw.widgets;

import java.io.File;
import java.io.PrintWriter;

import com.dbtw.enumerations.OperatingSystems;
import com.dbtw.widgets.LogFile;

/**
 *  This is a generic logger that runs as a Singleton, hence it is only used when
 *  necessary.
 *  
 *  Copyright (C) 2014  DatabasesThatWork.com
 *
 *  This program is free software: you can redistribute it and/or modify
 *  it under the terms of the GNU Affero General Public License as
 *  published by the Free Software Foundation, either version 3 of the
 *  License, or (at your option) any later version.
 *
 *  This program is distributed in the hope that it will be useful,
 *  but WITHOUT ANY WARRANTY; without even the implied warranty of
 *  MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *  GNU Affero General Public License for more details.
 *  <http://www.gnu.org/licenses/>
 *  
 */
public class LogFile {
  //Static variables
  /** The Singleton instance of the class. */
  private static LogFile instance = null;
  //Constants
  /** Used for logging/debugging to identify the source class of an entry */
  private final String WHOAMI = "LogFile";
  //Private variables
  /**
   * The log file to which the entries will be written. Location is defined
   * by the UserPrefs class. The filename is <application name>.log.
   */
  private File log;
  private PrintWriter out;
  //Public variables

  //Constructors
  /** Default constructor */
  private LogFile() {
    init();
  }

  //Static methods
  /**
   * Returns the current instance of the class. If no instance exists,
   * one is created.
   * 
   * @return an instance of the class
   */
  public static LogFile getInstance() {
    if (instance == null) {
      instance = new LogFile();
    }
    return instance;
  }
  
  //Public methods
  /**
   * Writes the entries label, which identifies the class and method that
   * are the source of the entry.
   * 
   * @param myclass  name of the calling class
   * @param method   name of the calling method in that class
   */
  public void writeLabel(String myclass, String method) {
    out.println(myclass + "." + method);
    out.flush();
  }
  
  /**
   * Writes the entry message provided by the developer.
   * 
   * @param message  context specific message provided for detail
   */
  public void writeMsg(String message) {
    out.println(message);
    out.flush();
  }
  
  /**
   * Writes the stack trace output of the exception provided.
   * 
   * @param e  exception that caused the entry
   */
  public void writeDump(Exception e) {
    e.printStackTrace(out);
    out.flush();
  }
  
  //Private methods
  /**
   * This method initializes the class for use.
   * 
   * In this case, it prepares the file for writing.
   */
  private void init() {
    String errm = "";
    try {
      String filename = ((String) UserPrefs.getInstance().getParameter("AppName")) + ".log";
      log = new File(getPath((OperatingSystems) UserPrefs.getInstance().getParameter(")S")), filename);
      out = new PrintWriter(log);
    }
    catch (Exception e) {
      e.printStackTrace(System.out);
    }
  }
  
  /**
   * Determines the default output path to use based on the applications User Preferences.
   * 
   * @param env users environment established when application was started
   * @return  platform specific path
   * 
   * @see dbtw.widgets.UserPrefs
   */
  private String getPath(OperatingSystems env) {
    String path = "";
    try {
      switch (env) {
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
        case LINUX: {
          path = System.getenv("HOME");
          break;
        }
      }
    }
    catch (Exception e) {
      e.printStackTrace(System.out);
    }
    return path;
  }

}
