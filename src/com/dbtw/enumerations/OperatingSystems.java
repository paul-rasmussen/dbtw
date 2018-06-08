package com.dbtw.enumerations;

public enum OperatingSystems {
  LINUX("Linux"),
  WINDOWS7("Windows7"),
  WINDOWS8("Windows8"),
  WINDOWS10("Windows10"),
  WINDOWS2010("WindowsServer2010"),
  WINDOWS2012("WindowsServer2012"),
  WINDOWS2016("WindowsServer2016"),
  UNIX("Unix");
  
  private String description;
  
  OperatingSystems(String desc) {
    description = desc;
  }
  
  public String getDescription() {
    return description;
  }
}
