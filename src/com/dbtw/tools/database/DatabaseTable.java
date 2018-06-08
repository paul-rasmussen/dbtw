package com.dbtw.tools.database;

import java.sql.Connection;
import java.util.Iterator;
import java.util.Vector;

import org.apache.empire.db.DBCommand;
import org.apache.empire.db.DBReader;

import com.dbtw.models.SchemaNode;
import com.dbtw.models.TableNode;

import com.dbtw.widgets.UserPrefs;

public class DatabaseTable implements Comparable{
  //Static variables
  //Constants
  //Private variables
  private String schema;
  private String name;
  private int rows;
  private Vector<DatabaseColumn> columns = new Vector<DatabaseColumn>();
  private Vector<DatabaseIndex> indexes = new Vector<DatabaseIndex>();
  //Public variables

  //Constructors
  public DatabaseTable(String schema, String name) {
    init(schema, name);
  }

  //Static methods
  public static DatabaseTable loadTable(String schema, String name) {
    DatabaseTable table = new DatabaseTable(schema, name);
    table.loadTableStruct();
    return table;
  }
  
  public static Vector<TableNode> getTableList(String schema) {
    Vector<TableNode> tables = new Vector<TableNode>();
    try {
      OracleDatabase db = OracleDatabase.getInstance();
      DBCommand cmd = db.createCommand();
      cmd.select(db.ALL_TAB_COLUMNS.TABLE_NAME);
      cmd.selectDistinct();
      cmd.where(db.ALL_TAB_COLUMNS.OWNER.is(schema));
      DBReader rdr = new DBReader();
      rdr.open(cmd, (Connection) UserPrefs.getInstance().getParameter(UserPrefs.CONNECTION));
      while (rdr.moveNext()) {
        String name = rdr.getString(0);
        TableNode node = new TableNode(name);
        node.setName(name);
        tables.add(node);
      }
      rdr.close();
      cmd.clear();
    }
    catch (Exception e) {
      e.printStackTrace(System.out);
    }
    return tables;
  }
  
  //Public methods
  @Override
  public int compareTo(Object o) {
    int result = 0;
    int result1 = 0;
    int result2 = 0;
    DatabaseTable t = (DatabaseTable) o;
    result1 = this.schema.compareTo(t.getSchema());
    result2 = this.name.compareTo(t.getName());
    if (result1 == 0) {
      result = result2;
    }
    else {
      result = result1;
    }
    return result;
  }
  
  public void setSchema(String schema) {
    this.schema = schema;
  }
  
  public String getSchema() {
    return schema;
  }
  
  public void setName(String name) {
    this.name = name;
  }
  
  public String getName() {
    return name;
  }
  
  public void setRowCount(int count) {
    rows = count;
  }
  
  public int getRowCount() {
    return rows;
  }
  
  public void addColumn(DatabaseColumn col) {
    columns.add(col);
  }
  
  public DatabaseColumn getColumn(int index) {
    return columns.elementAt(index);
  }
  
  public Vector<DatabaseColumn> getColumns() {
    return columns;
  }
  
  public int getColumnCount() {
    return columns.size();
  }
  
  public Iterator<DatabaseColumn> columnIterator() {
    return columns.iterator();
  }
  
  public void addIndex(DatabaseIndex index) {
    indexes.add(index);
  }
  
  public DatabaseIndex getIndex(int index) {
    return indexes.elementAt(index);
  }
  
  public int getIndexCount() {
    return indexes.size();
  }
  
  public Iterator<DatabaseIndex> indexIterator() {
    return indexes.iterator();
  }
  
  public void loadTableStruct() {
    loadTable();
  }
  
  //Private methods
  private void init(String schema, String name) {
    this.schema = schema;
    this.name = name;
  }

  private void loadTable() {
    try {
      OracleDatabase db = OracleDatabase.getInstance();
      DBCommand cmd = db.createCommand();
      cmd.select(db.ALL_TAB_COLUMNS.COLUMN_NAME);
      cmd.select(db.ALL_TAB_COLUMNS.DATA_LENGTH);
      cmd.select(db.ALL_TAB_COLUMNS.DATA_PRECISION);
      cmd.select(db.ALL_TAB_COLUMNS.DATA_TYPE);
      cmd.where(db.ALL_TAB_COLUMNS.OWNER.is(schema));
      cmd.where(db.ALL_TAB_COLUMNS.TABLE_NAME.is(name));
      DBReader rdr = new DBReader();
      rdr.open(cmd, (Connection) UserPrefs.getInstance().getParameter(UserPrefs.CONNECTION));
      while (rdr.moveNext()) {
        String dtype = rdr.getString(db.ALL_TAB_COLUMNS.DATA_TYPE);
        String cname = rdr.getString(db.ALL_TAB_COLUMNS.COLUMN_NAME);
        int len = rdr.getInt(db.ALL_TAB_COLUMNS.DATA_LENGTH);
        DatabaseColumn col = DatabaseColumn.getInstance(dtype, cname, len);
        col.setType(dtype);
        if (col.classType().equalsIgnoreCase("DatabaseNumberColumn")) {
          ((DatabaseNumberColumn) col).setPrecision(rdr.getInt(db.ALL_TAB_COLUMNS.DATA_PRECISION));
        }
        columns.add(col);
      }
      rdr.close();
      cmd.clear();
    }
    catch (Exception e) {
      e.printStackTrace(System.out);
    }
  }
}
