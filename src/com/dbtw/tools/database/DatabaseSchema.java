package com.dbtw.tools.database;

import java.sql.Connection;
import java.util.TreeMap;
import java.util.Vector;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import org.apache.empire.db.DBCommand;
import org.apache.empire.db.DBReader;
import org.apache.empire.db.oracle.DBCommandOracle;
import org.apache.empire.db.oracle.DBDatabaseDriverOracle;

import com.dbtw.models.SchemaNode;

import com.dbtw.widgets.UserPrefs;

public class DatabaseSchema {
  //Static variables
  //Constants
  //Private variables
  private Connection conn;
  private String owner;
  private TreeMap<String,DatabaseTable> tables = new TreeMap<String,DatabaseTable>();
  //Public variables

  //Constructors
  public DatabaseSchema(String name) {
    init(name);
  }

  //Static methods
  public static DatabaseSchema loadSchema(String name) {
    DatabaseSchema schema = new DatabaseSchema(name);
    return schema;
  }
  
  public static Vector<SchemaNode> getSchemaList() {
    Vector<SchemaNode> schemas = new Vector<SchemaNode>();
    try {
      OracleDatabase db = OracleDatabase.getInstance();
      DBCommand cmd = db.createCommand();
      cmd.select(db.ALL_TAB_COLUMNS.OWNER);
      cmd.selectDistinct();
      DBReader rdr = new DBReader();
      rdr.open(cmd, (Connection) UserPrefs.getInstance().getParameter(UserPrefs.CONNECTION));
      while (rdr.moveNext()) {
        String name = rdr.getString(0);
        SchemaNode node = new SchemaNode(name);
        node.setName(name);
        schemas.add(node);
      }
      rdr.close();
      cmd.clear();
    }
    catch (Exception e) {
      e.printStackTrace(System.out);
    }
    return schemas;
  }
  
  //Public methods
  public void setName(String name) {
    owner = name;
  }
  
  public String getName() {
    return owner;
  }
  
  public void addTable(DatabaseTable table) {
    tables.put(table.getName(), table);
  }
  
  public DatabaseTable getTable(String tablename) {
    return tables.get(tablename);
  }
  
  public int getTableCount() {
    return tables.size();
  }

  //Private methods
  private void init(String owner) {
    try {
      this.owner = owner;
      this.conn = (Connection) UserPrefs.getInstance().getParameter(UserPrefs.CONNECTION);
    }
    catch (Exception e) {
      e.printStackTrace(System.out);
    }
  }
  
  private void alertNoAccess() {
    JOptionPane.showMessageDialog(new JFrame(), "You do not have access to this schema");
  }
  
  private boolean hasAccess(OracleDatabase db) {
    boolean result = false;
    try {
      DBCommandOracle cmd = new DBCommandOracle(db);
      cmd.select(db.ALL_TAB_COLUMNS.OWNER.count());
      cmd.where(db.ALL_TAB_COLUMNS.OWNER.is(owner.toUpperCase()));
      DBReader rdr = new DBReader();
      rdr.open(cmd, conn);
      rdr.moveNext();
      int cnt = rdr.getInt(0);
      rdr.close();
      cmd.clear();
      if (cnt > 0) {
        result = true;
      }
    }
    catch (Exception e) {
      e.printStackTrace(System.out);
      result = false;
    }
    return result;
  }
  
  private void loadSchema(OracleDatabase db) {
    String tablename = "";
    DatabaseTable table = new DatabaseTable("","");
    boolean first = true;
    try {
      DBCommandOracle cmd = new DBCommandOracle(db);
      cmd.select(db.ALL_TAB_COLUMNS.TABLE_NAME);
      cmd.select(db.ALL_TAB_COLUMNS.COLUMN_NAME);
      cmd.select(db.ALL_TAB_COLUMNS.DATA_TYPE);
      cmd.select(db.ALL_TAB_COLUMNS.DATA_LENGTH);
      cmd.select(db.ALL_TAB_COLUMNS.DATA_PRECISION);
      cmd.where(db.ALL_TAB_COLUMNS.OWNER.is(owner.toUpperCase()));
      DBReader rdr = new DBReader();
      while (rdr.moveNext()) {
        if ((!rdr.getString(db.ALL_TAB_COLUMNS.TABLE_NAME).equals(tablename)) && (!first)) {
          tables.put(table.getName(), table);
          //Create and add the table
          tablename = rdr.getString(db.ALL_TAB_COLUMNS.TABLE_NAME);
          table = new DatabaseTable(owner, tablename);
          first = false;
        }
        String columnname = rdr.getString(db.ALL_TAB_COLUMNS.COLUMN_NAME);
        String datatype = rdr.getString(db.ALL_TAB_COLUMNS.DATA_TYPE);
        int length = rdr.getInt(db.ALL_TAB_COLUMNS.DATA_LENGTH);
        int precision = rdr.getInt(db.ALL_TAB_COLUMNS.DATA_PRECISION);
        if ((datatype.equalsIgnoreCase("VARCHAR")) || (datatype.equalsIgnoreCase("VARCHAR2")) || (datatype.equalsIgnoreCase("CLOB"))) {
          DatabaseVarcharColumn col = new DatabaseVarcharColumn(columnname, length);
          table.addColumn(col);
        }
        if ((datatype.equalsIgnoreCase("NUMBER")) || (datatype.equalsIgnoreCase("INTEGER")) || (datatype.equalsIgnoreCase("DOUBLE"))) {
          DatabaseNumberColumn col = new DatabaseNumberColumn(columnname, length, precision);
          table.addColumn(col);
        }
      }
      rdr.close();
      cmd.clear();
    }
    catch (Exception e) {
      e.printStackTrace(System.out);
    }
  }
}
