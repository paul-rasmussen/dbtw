package com.dbtw.models;

import javax.swing.tree.DefaultMutableTreeNode;

import com.dbtw.widgets.UserPrefs;


/**This class provides a database structure specific implementation of DefaultMutableTreeNode.
 * 
 * It's purpose is to be the main node type for nodes that represent database objects when building
 * a tree model that represents a databases internals.
 * 
 * It does not necessarily implement anything new except for the name, which can be different
 * from the data presented by the node.
 * 
 * @author prasmuss
 *
 */
public class DbNode extends DefaultMutableTreeNode {
  //Static variables
  //Constants
  //Private variables
  /**This is a string value that can represent any value for the node. It allows storing a value
   * not associated with the displayed text.
   */
  private String name = "";
  //Public variables

  //Constructors
  public DbNode() {
    super((String) UserPrefs.getInstance().getParameter("DBName"));
    init("Unknown");
  }
  
  public DbNode(String name) {
    super(name);
    init(name);
  }

  //Static methods
  //Public methods
  /**Standard setter */
  public void setName(String name) {
    this.name = name;
  }
  
  /**Standard getter */
  public String getName() {
    return name;
  }
  
  /**Duplicates getClass.getName functionality */
  public String getNodeType() {
    return "DbNode";
  }
  
  @Override
  public String toString() {
    return name;
  }
  
  //Private methods
  private void init(String name) {
    this.name = name;
  }
}
