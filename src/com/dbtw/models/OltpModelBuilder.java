package com.dbtw.models;

import java.util.HashMap;
import java.util.Iterator;

import com.dbtw.tools.parser.DbDefCsvParser;
import com.dbtw.tools.parser.JsonParser;
import com.dbtw.tools.parser.SourceColumnsParser;
import com.dbtw.writers.SqlCreateTableWriter;

import com.dbtw.widgets.DebugLogger;
import com.dbtw.widgets.LogFile;
import com.dbtw.widgets.StringWidget;

public class OltpModelBuilder implements DbModelBuilder {
  //Static variables
  //Constants
  private final String WHOAMI = "OltpModelBuilder";
  //Private variables
  private int indent = 0;
  private HashMap<String, HashMap<String, HashMap<String, HashMap<String, String>>>> struct = new HashMap<String, HashMap<String, HashMap<String, HashMap<String, String>>>>();
  private String schemaname = null;
  //Public variables

  //Constructors
  public OltpModelBuilder() {
    init();
  }

  //Static methods
  //Public methods
  @Override
  public HashMap<String, HashMap<String, HashMap<String, HashMap<String, String>>>> getModel() {
    return struct;
  }

  @Override
  public boolean buildFromJSON(JsonParser json, DbDefCsvParser csv, String schema) {
    this.schemaname = schema;
    return buildFromJSON(json, csv);
  }
  
  @Override
  public boolean buildFromJSON(JsonParser json, DbDefCsvParser csv) {
    boolean result = false;
    String errm = "";
    try {
      struct = new HashMap<String, HashMap<String, HashMap<String, HashMap<String, String>>>>();
      HashMap<String, HashMap<String, HashMap<String, String>>> jdata = json.getData();
      HashMap<String, HashMap<String, HashMap<String, String>>> tables = new HashMap<String, HashMap<String, HashMap<String, String>>>(); 
      for (Iterator<String> s = jdata.keySet().iterator(); s.hasNext(); ) {
        String schema = s.next();
        HashMap<String, HashMap<String, String>> tdata = jdata.get(schema);
        if (schemaname == null) {
          tables = new HashMap<String, HashMap<String, HashMap<String, String>>>(); 
        }
        for (Iterator<String> t = tdata.keySet().iterator(); t.hasNext(); ) {
          String table = t.next();
          HashMap<String, String> cdata = tdata.get(table);
          HashMap<String, HashMap<String, String>> columns = new HashMap<String, HashMap<String, String>>();
          for (Iterator<String> c = cdata.keySet().iterator(); c.hasNext(); ) {
            String column = c.next();
            HashMap<String, String> def = getColumnDef(schema, table, column, csv);
            columns.put(column, def);
          }
          tables.put(table, columns);
        }
        if (schemaname == null) {
          struct.put(schema, tables);
        }
      }
      if (schemaname != null) {
        struct.put(schemaname, tables);
      }
      result = true;
    }
    catch (Exception e) {
      logError("buildFromJSON", errm, e);
    }
    return result;
  }
  
  //Private methods
  private void init() {
    String errm = "";
    try {
    }
    catch (Exception e) {
      logError("init", errm, e);
    }
  }

  private HashMap<String, String> getColumnDef(String schema, String tablename, String colname, DbDefCsvParser csv) {
    HashMap<String, String> params = new HashMap<String, String>();
    String errm = "";
    try {
      if (csv.columnExists(tablename, colname)) {
        params = csv.getColumnDef(tablename, colname);
      }
    }
    catch (Exception e) {
      logError("getColumnDef", errm, e);
    }
    return params;
  }
  
  private void debugData() {
    DebugLogger.logMsg("---------------------------------------");
    DebugLogger.logMsg("OltpModelBuilder.debugData()");
    String msg = "Data in OltpModelBuilder:";
    DebugLogger.logMsg(msg);
    msg = "";
    for (Iterator<String> s = struct.keySet().iterator(); s.hasNext(); ) {
      String schema = s.next();
      DebugLogger.logMsg(StringWidget.lpad(schema, 15));
      HashMap<String, HashMap<String, HashMap<String, String>>> tables = struct.get(schema);
      for (Iterator<String> t = tables.keySet().iterator(); t.hasNext(); ) {
        String table = t.next();
        DebugLogger.logMsg(StringWidget.lpad(table, 25));
        HashMap<String, HashMap<String, String>> columns = tables.get(table);
        for (Iterator<String> c = tables.keySet().iterator(); c.hasNext(); ) {
          String column = c.next();
          msg = column;
          HashMap<String, String> coldef = columns.get(column);
          for (Iterator<String> d = coldef.keySet().iterator(); d.hasNext(); ) {
            String key = d.next();
            msg += "(" + key.trim() + ":" + coldef.get(key).trim() + ")";
          }
          DebugLogger.logMsg(StringWidget.lpad(msg, 45));
        }
      }
    }
    DebugLogger.logMsg("---------------------------------------");
  }

  private void logError(String method, String msg, Exception e) {
    LogFile log = LogFile.getInstance();
    log.writeLabel(WHOAMI, method);
    log.writeMsg(msg);
    log.writeDump(e);
    e.printStackTrace(System.out);
  }

}
