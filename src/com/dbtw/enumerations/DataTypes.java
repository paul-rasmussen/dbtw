package com.dbtw.enumerations;

public enum DataTypes {
  JSON(""),
  XML("");
  
  private String description;
  
  DataTypes(String desc) {
    description = desc;
  }
  
  public String getDescription() {
    return description;
  }
}
