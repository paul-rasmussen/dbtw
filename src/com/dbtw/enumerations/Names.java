package com.dbtw.enumerations;

public enum Names {
  APP_NAME("AppName"),
  CONNECTION("Connection"),
  DB("Database"),
  DB_TYPE("DB_Type"),
  ENVIRONMENT("Environment"),
  GAME("Game"),
  JDBC_CONNECTION("JDBC_Connection"),
  OUTPUT_DIR("OutputDirectory"),
  SCHEMA("Schema"),
  TNS_NAME("TNSNames"),
  USER("User");
  
  private String description;
  
  Names(String desc) {
    description = desc;
  }
  
  public String getDescription() {
    return description;
  }
}
