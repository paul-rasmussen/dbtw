package com.dbtw.models;

import javax.swing.tree.DefaultMutableTreeNode;

public class QueryNode extends DbNode {
  //Static variables
  //Constants
  //Private variables
  //Public variables

  //Constructors
  public QueryNode() {
    super();
    init();
  }
  
  public QueryNode(String name) {
    super(name);
    init();
  }

  //Static methods
  //Public methods
  @Override
  public String getNodeType() {
    return "QueryNode";
  }
  
  //Private methods
  private void init() {  
  }
}
