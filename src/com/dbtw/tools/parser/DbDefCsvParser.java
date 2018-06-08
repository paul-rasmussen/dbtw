package com.dbtw.tools.parser;

import java.io.File;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;
import java.util.Vector;

import com.dbtw.widgets.CsvParser;
import com.dbtw.widgets.DebugLogger;
import com.dbtw.widgets.LogFile;
import com.dbtw.widgets.StringWidget;

public class DbDefCsvParser {
  //Static variables
  public static final String WHOAMI = "DbDefCsvParser";
  public static final String DATA_TYPE = "datatype";
  public static final String LEN = "length";
  public static final String PRECISION = "prec";
  public static final String SCALE = "scale";
  public static final String NULLABLE = "nullable";
  public static final String DEFAULT_VAL = "default";
  //Constants
  //Private variables
  private int indent = 0;
  private HashMap<String, HashMap<String, HashMap<String, String>>> defs = new HashMap<String, HashMap<String, HashMap<String, String>>>(); 
  //Public variables

  //Constructors
  public DbDefCsvParser(File src) {
    init(src);
  }

  //Static methods
  //Public methods
  public boolean tableExists(String tablename) {
    return defs.containsKey(tablename.trim());
  }
  
  public boolean columnExists(String tablename, String colname) {
    if (tableExists(tablename)) {
      return defs.get(tablename).containsKey(colname.trim());
    }
    return false;
  }
    
  public HashMap<String, HashMap<String, String>> getColumns(String tablename) {
    if (tableExists(tablename)) {
      return defs.get(tablename);
    }
    return null;
  }
  
  public HashMap<String, String> getColumnDef(String tablename, String colname) {
    if (tableExists(tablename)) {
      if (columnExists(tablename, colname)) {
        return defs.get(tablename).get(colname);
      }
    }
    return null;
  }
  
  public Set<String> getTableList() {
    return defs.keySet();
  }
  
  public Set<String> getColumnList(String tablename) {
    if (defs.containsKey(tablename)) {
      return defs.get(tablename).keySet();
    }
    return null;
  }
  
  //Private methods
  private void init(File src) {
    String errm = "";
    try {
      CsvParser parse = new CsvParser(src);
      loadDefs(parse.getRows());
    }
    catch (Exception e) {
      logError("init", errm, e);
    }
  }
  
  private void loadDefs(Vector<HashMap<String, String>> src) {
    String errm = "";
    String msg = "";
    try {
      String tablename = null;
      HashMap<String, HashMap<String, String>> columns = new HashMap<String, HashMap<String, String>>();
      for (Iterator<HashMap<String, String>> i = src.iterator(); i.hasNext(); ) {
        HashMap<String, String> row = i.next();
        if (!row.get("TABLE_NAME").equalsIgnoreCase(tablename)) {
          defs.put(tablename, columns);
          columns = new HashMap<String, HashMap<String, String>>();
          tablename = row.get("TABLE_NAME");
        }
        HashMap<String, String> details = new HashMap<String, String>();
        details.put(DATA_TYPE, row.get("DATA_TYPE"));
        details.put(NULLABLE, row.get("NULLABLE"));
        details.put(LEN, row.get("DATA_LENGTH"));
        details.put(PRECISION, row.get("DATA_PRECISION"));
        details.put(SCALE, row.get("DATA_SCALE"));
        details.put(DEFAULT_VAL, row.get("DATA_DEFAULT"));
        columns.put(row.get("COLUMN_NAME"), details);
      }
    }
    catch (Exception e) {
      logError("loadDefs", errm, e);
    }
  }
  
  private void debugData() {
    DebugLogger.logMsg("---------------------------------------");
    DebugLogger.logMsg("DbDefCsvParser.debugData()");
    String msg = "Data in DbDefCsvParser:";
    DebugLogger.logMsg(msg);
    msg = "";
    for (Iterator<String> t = defs.keySet().iterator(); t.hasNext(); ) {
      String table = t.next();
      for (Iterator<String> c = defs.get(table).keySet().iterator(); c.hasNext(); ) {
        String column = c.next();
        msg = StringWidget.lpad(table, 15) + StringWidget.lpad(column, 15);
        HashMap<String, String> coldef = defs.get(table).get(column);
        if (coldef.get(DATA_TYPE) != null) {
          msg += StringWidget.lpad(coldef.get(DATA_TYPE), 15);
        }
        else {
          msg += StringWidget.lpad(" ", 15);
        }
        if (coldef.get(NULLABLE) != null) {
          msg += StringWidget.lpad(coldef.get(NULLABLE), 15);
        }
        else {
          msg += StringWidget.lpad(" ", 15);
        }
        if (coldef.get(LEN) != null) {
          msg += StringWidget.lpad(coldef.get(LEN), 15);
        }
        else {
          msg += StringWidget.lpad(" ", 15);
        }
        DebugLogger.logMsg(msg);
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
