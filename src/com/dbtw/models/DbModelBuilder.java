package com.dbtw.models;

import java.util.HashMap;

import com.dbtw.tools.parser.DbDefCsvParser;
import com.dbtw.tools.parser.JsonParser;
import com.dbtw.tools.parser.SourceColumnsParser;

import com.dbtw.widgets.LogFile;

public interface DbModelBuilder {
  //Static variables
  //Constants
  //Private variables
  //Public variables

  //Constructors

  //Static methods
  //Public methods
  public HashMap<String,HashMap<String,HashMap<String,HashMap<String, String>>>> getModel();
  public boolean buildFromJSON(JsonParser json, DbDefCsvParser csv);
  public boolean buildFromJSON(JsonParser json, DbDefCsvParser csv, String schema);
  //Private methods
}
