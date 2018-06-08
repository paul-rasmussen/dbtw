package com.dbtw.tools.database;

public class DatabaseVarcharColumn extends DatabaseColumn{
  //Static variables
  //Constants
  //Private variables
  private int distincts;
  //Public variables

  //Constructors
  public DatabaseVarcharColumn(String name, int size) {
    super(name, size);
  }

  //Static methods
  //Public methods
  public void setDistinctCount(int count) {
    distincts = count;
  }
  
  public int getDistinctCount() {
    return distincts;
  }
  
  @Override
  public String classType() {
    return "DatabaseVarcharColumn";
  }
   
  //Private methods
}
