package com.dbtw.tools.database;

public class DatabaseNumberColumn extends DatabaseColumn{
  //Static variables
  //Constants
  //Private variables
  private int precision;
  private int distincts;
  //Public variables

  //Constructors
  public DatabaseNumberColumn(String name, int size) {
    super(name, size);
    init(0);
  }

  public DatabaseNumberColumn(String name, int size, int precision) {
    super(name, size);
    init(precision);
  }

  //Static methods
  //Public methods
  public void setPrecision(int precision) {
    this.precision = precision;
  }
  
  public int getPrecision() {
    return precision;
  }
  
  public void setDistinctCount(int count) {
    distincts = count;
  }
  
  public int getDistinctCount() {
    return distincts;
  }
  
  @Override
  public String classType() {
    return "DatabaseNumberColumn";
  }
   
  //Private methods
  private void init(int precision) {
    this.precision = precision;
  }
}
