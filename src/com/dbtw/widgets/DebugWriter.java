package com.dbtw.widgets;

public class DebugWriter {
  private static DebugWriter instance = null;
  private StringBuilder output = new StringBuilder();
  
  
  private DebugWriter() {
  }
  
  public static DebugWriter getInstance() {
    if (instance == null) {
      instance = new DebugWriter();
    }
    return instance;
  }
  
  public void write(String text) {
    output.append(text);
    output.append("\n");
    System.out.print(output.toString());
  }
  
  public String getLog() {
    return output.toString();
  }
  
}
