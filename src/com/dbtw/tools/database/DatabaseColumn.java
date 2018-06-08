package com.dbtw.tools.database;

public class DatabaseColumn {
  //Static variables
  //Constants
  //Private variables
  private String name;
  private String type;
  private int size;
  //Public variables

  //Constructors
  public DatabaseColumn(String name) {
    init(name, 0);
  }

  public DatabaseColumn(String name, int size) {
    init(name, size);
  }
  //Static methods
  public static DatabaseColumn getInstance(String type, String name, int size) {
    if (type.equalsIgnoreCase("CHAR")) {
      return new DatabaseVarcharColumn(name, size);
    }
    if (type.equalsIgnoreCase("NCHAR")) {
      return new DatabaseVarcharColumn(name, size);
    }
    if (type.equalsIgnoreCase("VARCHAR")) {
      return new DatabaseVarcharColumn(name, size);
    }
    if (type.equalsIgnoreCase("NVARCHAR2")) {
      return new DatabaseVarcharColumn(name, size);
    }
    if (type.equalsIgnoreCase("VARCHAR2")) {
      return new DatabaseVarcharColumn(name, size);
    }
    if (type.equalsIgnoreCase("CLOB")) {
      return new DatabaseVarcharColumn(name, size);
    }
    if (type.equalsIgnoreCase("NCLOB")) {
      return new DatabaseVarcharColumn(name, size);
    }
    if (type.equalsIgnoreCase("NUMBER")) {
      return new DatabaseNumberColumn(name, size);
    }
    if (type.equalsIgnoreCase("FLOAT")) {
      return new DatabaseNumberColumn(name, size);
    }
    if (type.equalsIgnoreCase("BINARY_FLOAT")) {
      return new DatabaseNumberColumn(name, size);
    }
    if (type.equalsIgnoreCase("BINARY_DOUBLE")) {
      return new DatabaseNumberColumn(name, size);
    }

    return null;
  }
  
  //Public methods
  public void setName(String name) {
    this.name = name;
  }
  
  public String getName() {
    return name;
  }
  
  public void setType(String name) {
    type = name;
  }
  
  public String getType() {
    return type;
  }
  
  public void setSize(int size) {
    this.size = size;
  }
  
  public int getSize() {
    return size;
  }
  
  public String classType() {
    return "DatabaseColumn";
  }
  
  //Private methods
  private void init(String name, int size) {
    this.name = name;
    this.size = size;
  }
}
