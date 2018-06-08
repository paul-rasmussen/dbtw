package com.dbtw.models;

import java.sql.Connection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Vector;

import org.apache.empire.db.DBReader;
import org.apache.empire.db.oracle.DBCommandOracle;

import com.dbtw.enumerations.OperatingSystems;
import com.dbtw.enumerations.db.Databases;
import com.dbtw.tools.database.OracleDatabase;

import com.dbtw.widgets.DebugLogger;
import com.dbtw.widgets.LogFile;
import com.dbtw.widgets.StringWidget;
import com.dbtw.widgets.UserPrefs;

public class ViewModel {
  //Static variables
  public static final String NAME = "name";
  public static final String SCHEMA = "schema";
  public static final String TABLE = "table";
  public static final String FILTER = "filter";
  //Constants
  private final String WHOAMI = "ViewModel";
  //Private variables
  private int indent = 0;
  private String name = "";
  private String schema = "";
  private Vector<ColumnModel> columns = new Vector<ColumnModel>();
  //Public variables

  //Constructors
  public ViewModel(String schema, String view) {
    init(schema, view);
  }

  //Static methods
  //Public methods
  public String getName() {
      return name;
  }
  
  public Vector<ColumnModel> getColumns() {
      return columns;
  }
  
  public String toString() {
    String txt = schema + "." + name + "\n";
    indent = 4;
    for (int i = 0; i < columns.size(); i++) {
      ColumnModel m = columns.get(i);
      txt += StringWidget.indent(m.toString(),indent) + "\n";
    }
    return txt;
  }
  
  //Private methods
  private void init(String schema, String viewname) {
    String errm = "";
    try {
      this.schema = schema;
      name = viewname;
      columns = new Vector<ColumnModel>();
      Databases db = (Databases) UserPrefs.getInstance().getParameter("DBType");
      switch (db) {
        case MYSQL: {
          break;
        }
        case ORACLE: {
          loadOracleDef();
          break;
        }
      }
    }
    catch (Exception e) {
      logError("init", errm, e);
    }
  }

  private void loadMySqlDef() {
    String errm = "Loading definition for " + schema + "." + name;
    try {
      
    }
    catch (Exception e) {
      logError("loadMySqlDef", errm, e);
    }
  }
  
  private void loadOracleDef() {
    String errm = "Loading definition for " + schema + "." + name;
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
        cmd.where(db.DBA_TAB_COLUMNS.OWNER.is(schema));
        cmd.where(db.DBA_TAB_COLUMNS.TABLE_NAME.is(name));
        errm = "Executing\n" + cmd.getSelect();
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
      logError("loadOracleDef", errm, e);
    }
  }
  
  private void parse(String name, String query) {
    String errm = "";
    try {
      HashMap<String, String> tables = new HashMap<String, String>();
      HashMap<String, String> talias = new HashMap<String, String>();
      HashMap<String, String> columns = new HashMap<String, String>();
      HashMap<String, String> calias = new HashMap<String, String>();
      
    }
    catch (Exception e) {
      logError("parse", errm, e);
    }
  }
  
  private String clipSelect(String query) {
    String errm = "";
    String txt = "";
    int start = 0;
    int stop = 0;
    try {
      start = query.indexOf("SELECT") + 7;
      stop = query.indexOf("FROM", start);
    }
    catch (Exception e) {
      logError("clipSelect", errm, e);
    }
    return txt;
  }
  
  private void logError(String method, String msg, Exception e) {
    LogFile log = LogFile.getInstance();
    log.writeLabel(WHOAMI, method);
    log.writeMsg(msg);
    log.writeDump(e);
    e.printStackTrace(System.out);
  }

  private void debug() {
    LogFile.getInstance().writeMsg("ViewModel Debugging Data");
    for (int i = 0; i < columns.size(); i++) {
      String msg = "";
      ColumnModel c = columns.get(i);
      msg += StringWidget.lpad(c.getName(), 20) + StringWidget.lpad(c.getColumnAttribute(ColumnModel.DATA_TYPE),20);
      msg += StringWidget.lpad(c.getColumnAttribute(ColumnModel.LENGTH), 10) + "\n";
      LogFile.getInstance().writeMsg(msg);
    }
  }
}
