package com.dbtw.models;

import java.util.Iterator;
import java.util.Vector;

import javax.swing.tree.DefaultTreeModel;

import com.dbtw.widgets.LogFile;


/**This class is intended to be utilized to display database structures in a consistent fashion.
 * 
 * Top level nodes represent schemas, with various database objects (tables, indexes, views, etc)
 * represented by child nodes of those schema nodes.
 * 
 * @author prasmuss
 *
 */
public class DbTreeModel extends DefaultTreeModel {
  //Static variables
  //Constants
  private final String WHOAMI = "DbTreeModel";
  //Private variables
  private DbNode root;
  //Public variables

  //Constructors
  public DbTreeModel(DbNode root, Vector<String> schemalist) {
    super(root);
    this.root = root;
    init(schemalist);
  }

  //Static methods
  //Public methods
  public void addTable(SchemaNode parent, TableModel model) {
    addTableNode(parent, model);
  }
  
  public void addColumn(TableNode parent, ColumnModel model) {
    addColumnNode(parent, model);
  }
  //Private methods
  /**A method used to initialize the class using the root node and list of schema's provided */
  private void init(Vector<String> schemalist) {
    String errm = "";
    try {
      for (Iterator<String> t = schemalist.iterator(); t.hasNext(); ) {
        String schemaname = t.next();
        SchemaNode snode = new SchemaNode(schemaname);
        root.add(snode);
      }
    }
    catch (Exception e) {
      logError("init", errm, e);
    }
  }
  
  private void addTableNode(SchemaNode snode, TableModel table) {
    String errm = "";
    try {
      TableNode tnode = new TableNode(table.getName());
      snode.add(tnode);
      for (Iterator<ColumnModel> c = table.getColumns().iterator(); c.hasNext(); ) {
        addColumnNode(tnode, c.next());
      }
    }
    catch (Exception e) {
      logError("addTableNode", errm, e);
    }
  }
  
  private void addColumnNode(TableNode table, ColumnModel column) {
    String errm = "";
    try {
      ColumnNode cnode = new ColumnNode(column.getName());
      table.add(cnode);
      cnode.setDataType(column.getColumnAttribute(ColumnModel.DATA_TYPE));
      cnode.setSize(Integer.parseInt(column.getColumnAttribute(ColumnModel.LENGTH)));
    }
    catch (Exception e) {
      logError("addColumnNode", errm, e);
    }
  }

  private void logError(String method, String msg, Exception e) {
    LogFile log = LogFile.getInstance();
    log.writeLabel(WHOAMI, method);
    log.writeMsg(msg);
    log.writeDump(e);
    e.printStackTrace(System.out);
  }
}
