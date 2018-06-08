package com.dbtw.enumerations.gui;

public enum Colors {
  FONT(""),
  BACKGROUND(""),
  TEXT_BACKGROUND(""),
  TEXT_FOREGROUND("");
  
  private String description;
  
  Colors(String desc) {
    description = desc;
  }
  
  public String getDescription() {
    return description;
  }
}
