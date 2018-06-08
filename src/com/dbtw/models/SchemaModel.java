package com.dbtw.models;

import java.sql.Connection;
import java.util.HashMap;
import java.util.Vector;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import org.apache.empire.db.DBReader;
import org.apache.empire.db.oracle.DBCommandOracle;

import com.dbtw.tools.database.OracleDatabase;

import com.dbtw.widgets.LogFile;
import com.dbtw.widgets.UserPrefs;

public class SchemaModel {
  //Static variables
  //Constants
  private final String WHOAMI = "SchemaModel";
  //Private variables
  private int indent = 0;
  private String name = "";
  private Vector<TableModel> tables = new Vector<TableModel>();
  private Vector<ViewModel> views = new Vector<ViewModel>();
  //Public variables

  //Constructors
  public SchemaModel(String schemaName) {
    init(schemaName);
  }

  //Static methods
  //Public methods
  public String getName() {
    return name;
  }
  
  public void addSchemaTable(TableModel table) {
    addTable(table);
  }
  
  public TableModel getSchemaTable(String tableName) {
    return getTable(tableName);
  }
  
  public Vector<String> getSchemaTableList() {
    return getTableList();
  }
  
  public void addSchemaView(ViewModel view) {
    addView(view);
  }
  
  public ViewModel getSchemaView(String viewName) {
    return getView(viewName);
  }
  
  public Vector<String> getSchemaViewList() {
    return getViewList();
  }
  
  //Private methods
  private void init(String schemaName) {
    String errm = "";
    try {
      name = schemaName;
      loadTables();
      loadViews();
    }
    catch (Exception e) {
      logError("init", errm, e);
    }
  }

  private void loadTables() {
    String errm = "";
    try {
      OracleDatabase db = OracleDatabase.getInstance();
      DBCommandOracle cmd = new DBCommandOracle(db);
      cmd.select(db.DBA_TABLES.TABLE_NAME);
      cmd.where(db.DBA_TABLES.OWNER.is(name));
      DBReader rdr = new DBReader();
      rdr.open(cmd, (Connection) UserPrefs.getInstance().getParameter("JDBCConnection"));
      while (rdr.moveNext()) {
        TableModel table = new TableModel(name, rdr.getString(0));
        tables.add(table);
      }
      rdr.close();
      cmd.clear();
    }
    catch (Exception e) {
      logError("loadTables", errm, e);
    }
  }
  
  private void loadViews() {
      String errm = "";
      try {
        OracleDatabase db = OracleDatabase.getInstance();
        DBCommandOracle cmd = new DBCommandOracle(db);
        cmd.select(db.DBA_VIEWS.VIEW_NAME);
        cmd.where(db.DBA_VIEWS.OWNER.is(name));
        DBReader rdr = new DBReader();
        rdr.open(cmd, (Connection) UserPrefs.getInstance().getParameter("JDBCConnection"));
        while (rdr.moveNext()) {
          ViewModel view = new ViewModel(name, rdr.getString(0));
          views.add(view);
        }
        rdr.close();
        cmd.clear();
      }
      catch (Exception e) {
        logError("loadViews", errm, e);
      }
  }
  
  private void addTable(TableModel table) {
    tables.add(table);
  }
  
  private Vector<String> getTableList() {
    Vector<String> tabList = new Vector<String>();
    for (int i = 0; i < tables.size(); i++) {
      tabList.add(tables.elementAt(i).getName());
    }
    return tabList;
  }
  
  private TableModel getTable(String name) {
    String errm = "";
    try {
      for (int t = 0; t < tables.size(); t++) {
        if (tables.elementAt(t).getName().equals(name)) {
          return tables.elementAt(t);
        }
      }
    }
    catch (Exception e) {
      logError("getTable", errm, e);
    }
    return null;
  }
  
  private void addView(ViewModel view) {
    views.add(view);
  }
  
  private Vector<String> getViewList() {
    Vector<String> vlist = new Vector<String>();
    for (int i = 0; i < views.size(); i++) {
      vlist.add(views.elementAt(i).getName());
    }
    return vlist;
  }
  
  private ViewModel getView(String name) {
    String errm = "";
    try {
      for (int v = 0; v < views.size(); v++) {
        if (views.elementAt(v).getName().equals(name)) {
          return views.elementAt(v);
        }
      }
    }
    catch (Exception e) {
      logError("getView", errm, e);
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
