package com.dbtw.tools.parser;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.text.DateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Set;
import java.util.Vector;

public class ParseDelimitedStringFile {
  //Constants
  //Static variables
  //Private variables
  //Protected variables
  protected String delimiter = ",";
  protected Vector<Vector<String>> dataset = new Vector<Vector<String>>();
  //Public variables
  
  //Constructors
  
  //Static methods
  //Public methods
  public void parse(File filename) {
    parseFile(filename);
  }
  
  public Vector<Vector<String>> getData() {
    return dataset;
  }
  
  public void setDelimiter(String newDelim) {
    delimiter = newDelim;
  }
  
  public Vector<String> getRow(int index) {
    return dataset.elementAt(index);
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
      Vector<String> data = new Vector<String>();
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
