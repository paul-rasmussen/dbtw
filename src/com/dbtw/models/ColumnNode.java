package com.dbtw.models;

public class ColumnNode extends DbNode {
  //Static variables
  //Constants
  //Private variables
  private String dataType = "";
  private int size = 0;
  //Public variables

  //Constructors
  public ColumnNode() {
    super();
    init();
  }
  
  public ColumnNode(String name) {
    super(name);
    init();
  }

  //Static methods
  //Public methods
  @Override
  public String getNodeType() {
    return "ColumnNode";
  }
  
  public void setDataType(String type) {
    dataType = type;
  }
  
  public String getDataType() {
    return dataType;
  }
  
  public void setSize(int length) {
    size = length;
  }
  
  public int getSize() {
    return size;
  }
  
  @Override
  public String toString() {
    return getName() + " " + dataType + "(" + size + ")";
  }
  
  //Private methods
  private void init() {  
  }
}
