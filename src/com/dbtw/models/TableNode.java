package com.dbtw.models;

import javax.swing.tree.DefaultMutableTreeNode;

public class TableNode extends DbNode {
  //Static variables
  //Constants
  //Private variables
  //Public variables

  //Constructors
  public TableNode() {
    super();
    init();
  }
  
  public TableNode(String name) {
    super(name);
    init();
  }

  //Static methods
  //Public methods
  @Override
  public String getNodeType() {
    return "TableNode";
  }
  
  //Private methods
  private void init() {  
  }
}
