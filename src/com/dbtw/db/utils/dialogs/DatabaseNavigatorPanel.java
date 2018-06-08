package com.dbtw.db.utils.dialogs;

import java.awt.BorderLayout;
import java.awt.Cursor;
import java.awt.Dimension;
import java.util.Iterator;
import java.util.Vector;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.JTree;
import javax.swing.event.TreeExpansionEvent;
import javax.swing.event.TreeSelectionEvent;
import javax.swing.event.TreeSelectionListener;
import javax.swing.event.TreeWillExpandListener;
import javax.swing.tree.ExpandVetoException;
import javax.swing.tree.TreePath;
import javax.swing.tree.TreeSelectionModel;

import com.dbtw.tools.database.DatabaseColumn;
import com.dbtw.tools.database.DatabaseTable;
import com.dbtw.tools.database.OracleDatabase;
import com.dbtw.models.ColumnNode;
import com.dbtw.models.DbNode;
import com.dbtw.models.DbTreeModel;
import com.dbtw.models.SchemaNode;
import com.dbtw.models.TableNode;

import com.dbtw.widgets.UserPrefs;

public class DatabaseNavigatorPanel extends JPanel {
  //Static variables
  //Constants
  //Private variables
  private JFrame parent;
  private int screen_width = 100;
  private int screen_height = 100;
  private int divider = 50;
  private JSplitPane sp = new JSplitPane();
  private JTree tree = new JTree();
  private JPanel rightPanel = new JPanel();
  private JScrollPane left = new JScrollPane();
  private JScrollPane right = new JScrollPane();
  private DbNode root = new DbNode("DB");
  private DbTreeModel tm;
  //Public variables

  //Constructors
  public DatabaseNavigatorPanel(JFrame parent) {
    this.parent = parent;
    init();
  }

  //Static methods
  //Public methods
  //Private methods
  private void init() {
    screen_width = parent.getContentPane().getWidth();
    screen_height = parent.getContentPane().getHeight() - 3;
    divider = 2*(screen_width/3);
    
    setSize(screen_width, screen_height);
/*
    Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
    int x = (int) ((dimension.getWidth() - getWidth()) / 2);
    int y = (int) ((dimension.getHeight() - getHeight()) / 2);
    setLocation(x, y);
*/    
   
    setLayout(new BorderLayout());
    setLocation(0,22);
    setCursor(new Cursor(Cursor.WAIT_CURSOR));

    left.setMinimumSize(new Dimension(divider, screen_height));
    right.setMinimumSize(new Dimension((screen_width/3), screen_height));
    
    root = new DbNode(UserPrefs.getInstance().getParameter(UserPrefs.DB_NAME).toString());
    tm = new DbTreeModel(root, OracleDatabase.getInstance().getSchemaList());
    tree = new JTree(tm);
    tree.getSelectionModel().setSelectionMode(TreeSelectionModel.SINGLE_TREE_SELECTION);
    tree.setShowsRootHandles(true);
    addNodeListeners();
    
    left = new JScrollPane(tree);
    right = new JScrollPane(rightPanel);
    
    sp = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, left, right);
    sp.setDividerLocation(divider);
    sp.setDividerSize(5);
    add(sp);
    parent.setContentPane(this);
    setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
  }
  
  private void addNodeListeners() {
    tree.addTreeSelectionListener(new TreeSelectionListener() {

      @Override
      public void valueChanged(TreeSelectionEvent e) {
        tree.setCursor(new Cursor(Cursor.WAIT_CURSOR));
        DbNode node = (DbNode) tree.getSelectionPath().getLastPathComponent();
        String nodeType = node.getNodeType();
        if (nodeType.equals("SchemaNode")) {
          Vector<TableNode> tables = DatabaseTable.getTableList(node.toString());
          for (Iterator<TableNode> i = tables.iterator(); i.hasNext(); ) {
            TableNode tnode = i.next();
            node.add(tnode);
          }
        }
        if (nodeType.equals("TableNode")) {
          SchemaNode snode = (SchemaNode) node.getParent();
          DatabaseTable table = DatabaseTable.loadTable(snode.getName(), node.getName());
          Vector<DatabaseColumn> columns = table.getColumns();
          for (Iterator<DatabaseColumn> i = columns.iterator(); i.hasNext(); ) {
            DatabaseColumn col = i.next();
            ColumnNode cnode = new ColumnNode(col.getName());
            cnode.setDataType(col.getType());
            cnode.setSize(col.getSize());
            node.add(cnode);
          }
        }
        tree.scrollPathToVisible(new TreePath(node.getFirstLeaf().getPath()));
        tree.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
      }
    });
    
    tree.addTreeWillExpandListener(new TreeWillExpandListener() {

      @Override
      public void treeWillExpand(TreeExpansionEvent event) throws ExpandVetoException {
      }

      @Override
      public void treeWillCollapse(TreeExpansionEvent event)
          throws ExpandVetoException {
        // TODO Auto-generated method stub
        
      }
      
    });
  }
  
}
