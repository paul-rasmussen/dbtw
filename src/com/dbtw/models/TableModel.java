package com.dbtw.models;

import java.sql.Connection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Vector;

import org.apache.empire.db.DBReader;
import org.apache.empire.db.oracle.DBCommandOracle;

import com.dbtw.tools.database.OracleDatabase;

import com.dbtw.widgets.LogFile;
import com.dbtw.widgets.UserPrefs;

public class TableModel {
  //Static variables
  //Constants
  private final String WHOAMI = "DatabaseModel";
  //Private variables
  private int indent = 0;
  private String name = "";
  private Vector<ColumnModel> columns = new Vector<ColumnModel>();
  //Public variables

  //Constructors
  public TableModel(String schemaname, String tableName) {
    init(schemaname, tableName);
  }

  //Static methods
  //Public methods
  public String getName() {
    return name;
  }
  
  public Vector<ColumnModel> getColumns() {
    return columns;
  }
  
  public void setColumn(String name, HashMap<String, String> details) {
    addColumn(name, details);
  }
  
  public void setColumnAtribute(String name, String attribute, String value) {
    addColumnDetail(name, attribute, value);
  }
  
  public String getColumnDetail(String column, String attribute) {
    return getDetail(column, attribute);
  }
  
  public Vector<String> getColumnList() {
    Vector<String> list = new Vector<String>();
    for (Iterator<ColumnModel> c = columns.iterator(); c.hasNext(); ) {
      list.add(c.next().getName());
    }
    return list;
  }
  
  public Vector<String> getColumnAttributesList(String name) {
    String errm = "";
    try {
      for (Iterator<ColumnModel> c = columns.iterator(); c.hasNext(); ) {
        ColumnModel column = c.next();
        if (column.getName().equals(name)) {
          return column.getAttribList();
        }
      }
    }
    catch (Exception e) {
      logError("getColumnAttributesList", errm, e);
    }
    return null;
  }
  
  //Private methods
  private void init(String schemaname, String tableName) {
    String errm = "";
    try {
      name = tableName;
      columns = new Vector<ColumnModel>();
      loadDef(schemaname);
    }
    catch (Exception e) {
      logError("init", errm, e);
    }
  }
  
  private void loadDef(String schemaname) {
    String errm = "";
    try {
      OracleDatabase db = OracleDatabase.getInstance();
      DBCommandOracle cmd = new DBCommandOracle(db);
      cmd.select(db.DBA_TAB_COLUMNS.COLUMN_NAME);
      cmd.select(db.DBA_TAB_COLUMNS.DATA_TYPE);
      cmd.select(db.DBA_TAB_COLUMNS.DATA_LENGTH);
      cmd.select(db.DBA_TAB_COLUMNS.DATA_PRECISION);
      cmd.select(db.DBA_TAB_COLUMNS.DATA_PRECISION);
      cmd.select(db.DBA_TAB_COLUMNS.DATA_SCALE);
      cmd.select(db.DBA_TAB_COLUMNS.DATA_DEFAULT);
      cmd.select(db.DBA_TAB_COLUMNS.NULLABLE);
      cmd.where(db.DBA_TAB_COLUMNS.OWNER.is(schemaname));
      cmd.where(db.DBA_TAB_COLUMNS.TABLE_NAME.is(name));
      DBReader rdr = new DBReader();
      rdr.open(cmd, (Connection) UserPrefs.getInstance().getParameter("JDBCConnection"));
      while (rdr.moveNext()) {
        ColumnModel col = new ColumnModel();
        col.setName(rdr.getString(0));
        col.setColumnAttribute(ColumnModel.DATA_TYPE, rdr.getString(1));
        col.setColumnAttribute(ColumnModel.LENGTH, rdr.getString(2));
        col.setColumnAttribute(ColumnModel.PRECISION, rdr.getString(3));
        col.setColumnAttribute(ColumnModel.SCALE, rdr.getString(4));
        col.setColumnAttribute(ColumnModel.DEFAULT, rdr.getString(5));
        col.setColumnAttribute(ColumnModel.NULLABLE, rdr.getString(6));
        columns.add(col);
      }
      rdr.close();
      cmd.clear();
    }
    catch (Exception e) {
      logError("loadDef", errm, e);
    }
  }
  
  private void addColumn(String name, HashMap<String, String> details) {
    String errm = "";
    boolean found = false;
    try {
      for (Iterator<ColumnModel> c = columns.iterator(); c.hasNext(); ){
        ColumnModel column = c.next();
        if (column.getName().equals(name)) {
          columns.remove(column);
        }
      }
      ColumnModel col = new ColumnModel();
      col.setName(name);
      for (Iterator<String> a = details.keySet().iterator(); a.hasNext(); ) {
        String key = a.next();
        if (col.getLabelIndex(key) > -1) {
          col.setColumnAttribute(col.getLabelIndex(key), details.get(key));
        }
      }
    }
    catch (Exception e) {
      logError("addColumn", errm, e);
    }
  }

  private void addColumnDetail(String name, String attribName, String value) {
    String errm = "";
    try {
      for (Iterator<ColumnModel> c = columns.iterator(); c.hasNext(); ) {
        ColumnModel column = c.next();
        if (column.getName().equals(name)) {
          if (column.getLabelIndex(attribName) > -1) {
            column.setColumnAttribute(column.getLabelIndex(attribName), value);
          }
        }
      }
    }
    catch (Exception e) {
      logError("addColumnDetail", errm, e);
    }
  }
  
  private String getDetail(String colName, String attrib) {
    String errm = "";
    try {
      for (Iterator<ColumnModel> c = columns.iterator(); c.hasNext(); ) {
        ColumnModel column = c.next();
        if (column.getName().equals(colName)) {
          return column.getColumnAttribute(column.getLabelIndex(attrib));
        }
      }
    }
    catch (Exception e) {
      logError("getDetail", errm, e);
    }
    return null;
  }
  
  private void logError(String method, String msg, Exception e) {
    LogFile log = LogFile.getInstance();
    log.writeLabel(WHOAMI, method);
    log.writeMsg(msg);
    log.writeDump(e);
    e.printStackTrace(System.out);
  }
}
