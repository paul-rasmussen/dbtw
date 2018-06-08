package com.dbtw.tools.database;

import java.util.Iterator;
import java.util.Vector;

public class DatabaseIndex {
  //Static variables
  public static final int PRIMARY = 0;
  public static final int UNIQUE = 1;
  public static final int OTHER = 2;
  //Constants
  //Private variables
  private String schema;
  private String name;
  private DatabaseTable table;
  private Vector<String> columns = new Vector<String>();
  private int indexType;
  //Public variables

  //Constructors
  public DatabaseIndex(String schema, DatabaseTable table, String name) {
    init(schema, table, name);
  }

  //Static methods
  //Public methods
  public void setName(String name) {
    this.name = name;
  }
  
  public String getName() {
    return name;
  }
  
  public void addColumn(DatabaseColumn col) {
    if (table.getColumns().contains(col)) {
      columns.add(col.getName());
    }
  }
  
  public DatabaseColumn getColumn(int index) {
    if (table.getColumnCount() < index) {
      return table.getColumn(index);
    }
    return null;
  }
  
  public Vector<DatabaseColumn> getColumns() {
    return table.getColumns();
  }
  
  public int getColumnCount() {
    return columns.size();
  }
  
  public Iterator<DatabaseColumn> columnIterator() {
    return table.columnIterator();
  }
  
  public void setType(int indexType) {
    this.indexType = indexType;
  }
  
  public int getType() {
    return indexType;
  }
  
  //Private methods
  private void init(String schema, DatabaseTable table, String name) {
    this.name = name;
    this.schema = schema;
    this.table = table;
  }
}
