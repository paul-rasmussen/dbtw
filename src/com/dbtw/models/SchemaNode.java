package com.dbtw.models;

import javax.swing.tree.DefaultMutableTreeNode;

public class SchemaNode extends DbNode {
  //Static variables
  //Constants
  //Private variables
  //Public variables

  //Constructors
  public SchemaNode() {
    super();
    init();
  }

  public SchemaNode(String name) {
    super(name);
    init();
  }
  
  //Static methods
  //Public methods
  @Override
  public String getNodeType() {
    return "SchemaNode";
  }
  
 //Private methods
  private void init() {  
  }
}
