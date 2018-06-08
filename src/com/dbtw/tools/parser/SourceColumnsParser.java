package com.dbtw.tools.parser;

import java.io.File;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import com.dbtw.widgets.DebugLogger;
import com.dbtw.widgets.LogFile;
import com.dbtw.widgets.StringWidget;

public class SourceColumnsParser extends JsonParser {
  //Static variables
  //Constants
  private final String WHOAMI = "SourceColumnsParser";
  //Private variables
  //Public variables

  //Constructors
  public SourceColumnsParser(File srcCols) {
    super(srcCols); 
    init();
  }

  //Static methods
  //Public methods
  //Private methods
  private void init() {
    String errm = "Initializing SourceColumnParser";
    try {
      errm = "Fetching an iterator of the JSON data parser";
      Iterator iter = data.entrySet().iterator();
      errm = "Fetching the first entry (which should be 'Tables'";
      Map.Entry entry = (Map.Entry) iter.next();
      String tablename = "";
      String schemaname = "";
      
      errm = "Fetching the list of table maps (an array)";
      LinkedList list1 = (LinkedList) entry.getValue();
      errm = "Initializing the tables and columns HashMaps for use in the structure";
      HashMap<String, HashMap<String, String>> tables = new HashMap<String, HashMap<String, String>>();
      HashMap<String, String> cols = new HashMap<String, String>();
      
      errm = "Iterating through the table objects";
      for (int l1 = 0; l1 < list1.size(); l1++) {
        errm = "Fetching table " + l1 + " of " + list1.size();
        Map table = (Map) list1.get(l1);
        tablename = table.get("Name").toString();
        if (!table.get("Schema").equals(schemaname)) {
          errm = "Adding " + schemaname + " to structure";
          addTableSet(tables, schemaname);
          schemaname = table.get("Schema").toString();
          tables = new HashMap<String, HashMap<String, String>>();
        }
        
        errm = "Initilizing column collection";
        cols = new HashMap<String, String>();
        errm = "Fetching column data from JSON source";
        LinkedList list2 = (LinkedList) table.get("Columns");
        for (int l2 = 0; l2 < list2.size(); l2++) {
          errm = "Adding column " + l2 + " of " + list2.size();
          Map column = (Map) list2.get(l2);
          List source = (List) column.get("source");
          if (source.size() == 0) {
            cols.put((String) column.get("Name"), (String) column.get("Filter"));
          }
          else {
            Map srcCol = (Map) source.get(0);
            HashMap<String, String> newCol = new HashMap<String, String>();
            newCol.put((String) srcCol.get("column"), (String) column.get("Filter"));
            HashMap<String, HashMap<String, String>> newTable = new HashMap<String, HashMap<String, String>>();
            newTable.put((String) srcCol.get("table"), newCol);
            if (!addTableSet(newTable, (String) srcCol.get("schema"))) {
              JOptionPane.showMessageDialog(new JFrame(), "Could not add ", "Data Error", JOptionPane.OK_OPTION);
            }
          }
        }
        addColumnSet(cols, tables, tablename);
      }
    }
    catch (Exception e) {
      logError("init", errm, e);
    }
    errm = "Leaving init";
  }

  private boolean addColumnSet(HashMap<String, String> cols, HashMap<String, HashMap<String, String>> tables, String tablename) {
    boolean result = false;
    String errm = "";
    try {
      if (tables.containsKey(tablename)) {
        errm = "Table " + tablename + " already exists";
        HashMap<String, String> columns = tables.get(tablename);
        for (Iterator<String> c = cols.keySet().iterator(); c.hasNext(); ) {
          String colname = c.next();
          if (!columns.containsKey(colname)) {
            errm = "Adding " + colname + " to existing " + tablename;
            tables.get(tablename).put(colname, cols.get(colname));
          }
        }
      }
      else {
        errm = "Adding columns to table list for " + tablename;
        tables.put(tablename, cols);
      }
      result = true;
    }
    catch (Exception e) {
      logError("addColumSet", errm, e);
    }
    return result;
  }
  
  private boolean addTableSet(HashMap<String, HashMap<String, String>> tables, String schemaname) {
    boolean result = false;
    String errm = "Adding table list to schema";
    try {
      if (struct.containsKey(schemaname)) {
        errm = "Schema " + schemaname + " already exists";
        HashMap<String, HashMap<String, String>> tablelist = struct.get(schemaname);
        for (Iterator<String> i = tables.keySet().iterator(); i.hasNext(); ) {
          String tablename = i.next();
          if (struct.get(schemaname).containsKey(tablename)) {
            errm = "Table " + schemaname + "." + tablename + " already exists";
            HashMap<String, String> columns = tables.get(tablename);
            HashMap<String, String> collist = struct.get(schemaname).get(tablename);
            if (!addColumnSet(columns, struct.get(schemaname), tablename)) {
              JOptionPane.showMessageDialog(new JFrame(), "Unable to add table and columns to " + schemaname + "." + tablename, "Data Management Error", JOptionPane.OK_OPTION);
            }
          }
          else {
            errm = "Adding column list to existing " + schemaname + "." + tablename;
            struct.get(schemaname).put(tablename, tables.get(tablename));
          }
        }
      }
      else {
        errm = "Adding table list to " + schemaname + " structure";
        struct.put(schemaname, tables);
      }
      result = true;
    }
    catch (Exception e) {
      logError("addTableSet", errm, e);
    }
    return result;
  }
  
  private void debugData() {
    DebugLogger.logMsg("---------------------------------------");
    DebugLogger.logMsg("SourceColumnsParser.debugData()");
    String msg = "Data in SourceColumnsParserParser:";
    DebugLogger.logMsg(msg);
    msg = "";
    for (Iterator<String> t = struct.keySet().iterator(); t.hasNext(); ) {
      String table = t.next();
      HashMap<String, HashMap<String, String>> col = struct.get(table);
      for (Iterator<String> c = col.keySet().iterator(); c.hasNext(); ) {
        String column = c.next();
        msg = StringWidget.lpad(table, 15) + StringWidget.lpad(column, 15);
        DebugLogger.logMsg(msg);
        HashMap<String, String> def = col.get(column);
        for (Iterator<String> d = def.keySet().iterator(); d.hasNext(); ) {
          String key = d.next();
          if (def.get(key) != null) {
            key += "(" + def.get(key) + ")";
          }
          else {
            key += "()";
          }
          DebugLogger.logMsg(StringWidget.lpad(key, 35));
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
