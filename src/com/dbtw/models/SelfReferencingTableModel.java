package com.dbtw.models;

import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;

import org.apache.empire.db.DBTable;

import com.dbtw.widgets.DebugLogger;
import com.dbtw.widgets.LogFile;
import com.dbtw.widgets.UserPrefs;

public class SelfReferencingTableModel extends DefaultTreeModel {
  //Constants
  //Public variables
  //Protected variables
  //Private variables

  //Constructors
  public SelfReferencingTableModel(DBTable table, String startingName, DefaultMutableTreeNode root) {
    super(root);
    init();
  }

  //Static methods
  //Public methods
  //Protected methods
  //Private methods
  private void init() {
    
  }
}
