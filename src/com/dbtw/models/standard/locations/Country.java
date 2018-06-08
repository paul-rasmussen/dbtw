package com.dbtw.models.standard.locations;

import com.dbtw.widgets.DebugLogger;
import com.dbtw.widgets.LogFile;
import com.dbtw.widgets.UserPrefs;

public class Country {
  //Constants
  //Private variables
  private String name = "";
  private String abbrev = "";
  private int code = 0;
  private String cia_page = "";
  
  //Public variables

  //Constructors
  public Country() {
    init();
  }

  //Static methods
  //Public methods
  public void setName(String name) {
    this.name = name;
  }
  
  public String getName() {
    return name;
  }
  
  public void setAbbreviation(String abbrev) {
    this.abbrev = abbrev;
  }
  
  public String getAbbreviation() {
    return abbrev;
  }
  
  public void setCountryCode(int code) {
    this.code = code;
  }
  
  public int getCountryCode() {
    return code;
  }
  
  public void setCIAPage(String url) {
    cia_page = url;
  }
  
  public String getCIAPage() {
    return cia_page;
  }
  
  //Private methods
  private void init() {
  }
}
