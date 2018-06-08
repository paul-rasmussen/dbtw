package com.dbtw.tools.parser;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.text.DateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Set;
import java.util.Vector;

public class ParseDelimitedDateFile extends ParseDelimitedFile {
  //Constants
  //Static variables
  //Private variables
  //Protected variables
  protected String delimiter = ",";
  protected HashMap<Date, Vector<Integer>> dataset = new HashMap<Date, Vector<Integer>>();
  //Public variables
  
  //Constructors
  
  //Static methods
  //Public methods
  public void parse(File filename) {
    parseFile(filename);
  }
  
  public HashMap<Date, Vector<Integer>> getData() {
    return dataset;
  }
  
  public int getCount() {
    return dataset.size();
  }
  
  public Vector<Integer> getRow(Date key) {
    return dataset.get(key);
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
      token = line.substring(0, line.indexOf(delimiter));
      Date date = DateFormat.getDateInstance(DateFormat.SHORT).parse(token);
      Vector<Integer> data = new Vector<Integer>();
      while (line.length() > 0) {
        token = line.substring(0, line.indexOf(delimiter));
        data.add(Integer.parseInt(token));
      }
      dataset.put(date, data);
    }
    catch (Exception e) {
      e.printStackTrace(System.out);
    }
  }
  
  //Private methods
}
