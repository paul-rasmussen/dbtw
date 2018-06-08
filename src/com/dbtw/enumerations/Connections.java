package com.dbtw.enumerations;

public enum Connections {
  JDBC("JavaDBConnection"),
  ODBC("ODBCDBConnection"),
  FILE("FileIO");
  
  private String description;
  
  Connections(String desc) {
    description = desc;
  }
  
  public String getDescription() {
    return description;
  }
}
