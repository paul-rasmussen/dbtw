package com.dbtw.enumerations.db;

public enum Views {
  STRUCTURE(""),
  HEIRARCHY(""),
  TUNING("");
  
  private String description;
  
  Views(String desc) {
    description = desc;
  }
  
  public String getDescription() {
    return description;
  }
}
