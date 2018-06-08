package com.dbtw.models;

import javax.swing.tree.DefaultMutableTreeNode;

public class ViewNode extends DbNode {
  //Static variables
  //Constants
  //Private variables
  //Public variables

  //Constructors
  public ViewNode() {
    super();
    init();
  }
  
  public ViewNode(String name) {
    super(name);
    init();
  }

  //Static methods
  //Public methods
  @Override
  public String getNodeType() {
    return "ViewNode";
  }
  
  //Private methods
  private void init() {  
  }
}
