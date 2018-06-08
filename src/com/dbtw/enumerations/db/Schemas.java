package com.dbtw.enumerations.db;

public enum Schemas {
  LOGON("Logon"),
  ADMIN("Admin"),
  ANALYSIS("Analysis");
  
  private String description;
  
  Schemas(String desc) {
    description = desc;
  }
  
  public String getDescription() {
    return description;
  }
  
}
