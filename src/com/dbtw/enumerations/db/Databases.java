package com.dbtw.enumerations.db;

public enum Databases {
  ACCESS("MSAccess"),
  MARIADB("MariaDB"),
  MYSQL("MySQL"),
  ORACLE("Oracle"),
  POSTGRES("PostgreSQL"),
  SQLSERVER("SQLServer");
  
  private String description;
  
  Databases(String desc) {
    description = desc;
  }
  
  public String getDescription() {
    return description;
  }
  
}
