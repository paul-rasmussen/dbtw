package com.dbtw.tools.parser;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.text.DateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Set;
import java.util.Vector;

public class ParseDelimitedFile {
  //Constants
  //Static variables
  //Private variables
  //Protected variables
  protected String delimiter = ",";
  protected Vector<Vector<Object>> dataset = new Vector<Vector<Object>>();
  //Public variables
  
  //Constructors
  
  //Static methods
  //Public methods
  public void parse(File filename) {
    parseFile(filename);
  }
  
  public void setDelimiter(String newDelim) {
    delimiter = newDelim;
  }
  
  public String getDelimiter() {
    return delimiter;
  }
  
  //Protected methods
  protected void parseFile(File filename) {
    try {
      BufferedReader file = new BufferedReader(new FileReader(filename));
      while (file.ready()) {
        parseLine(file.readLine());
      }
    }
    catch (Exception e) {
      e.printStackTrace(System.out);
    }
  }
  
  protected void parseLine(String line) {
    String token = "";
    try {
      Vector<Object> data = new Vector<Object>();
      while (line.length() > 0) {
        token = line.substring(0, line.indexOf(delimiter));
        data.add(token);
      }
      dataset.add(data);
    }
    catch (Exception e) {
      e.printStackTrace(System.out);
    }
  }
  
  //Private methods
}
