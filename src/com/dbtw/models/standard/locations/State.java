package com.dbtw.models.standard.locations;

import com.dbtw.widgets.DebugLogger;
import com.dbtw.widgets.LogFile;
import com.dbtw.widgets.UserPrefs;

public class State {
  //Constants
  //Private variables
  private String name = "";
  private String abbrev = "";
  //Public variables

  //Constructors
  public State() {
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
  
  //Private methods
  private void init() {
  }
}
