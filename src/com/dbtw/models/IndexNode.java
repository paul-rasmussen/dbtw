package com.dbtw.models;

import javax.swing.tree.DefaultMutableTreeNode;


/**This class is intended to represent an index object in a database.
 * 
 * @author prasmuss
 *
 */
public class IndexNode extends DbNode {
  //Static variables
  //Constants
  //Private variables
  //Public variables

  //Constructors
  public IndexNode() {
    super();
    init();
  }
  
  public IndexNode(String name) {
    super(name);
    init();
  }

  //Static methods
  //Public methods
  @Override
  public String getNodeType() {
    return "IndexNode";
  }
  
  //Private methods
  private void init() {  
  }
}
