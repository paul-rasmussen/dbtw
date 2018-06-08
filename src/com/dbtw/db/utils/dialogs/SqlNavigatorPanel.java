package com.dbtw.db.utils.dialogs;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.util.HashMap;
import java.util.Iterator;
import java.util.TreeMap;
import java.util.Vector;

import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.JTree;
import javax.swing.event.TreeExpansionEvent;
import javax.swing.event.TreeSelectionEvent;
import javax.swing.event.TreeSelectionListener;
import javax.swing.event.TreeWillExpandListener;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.ExpandVetoException;
import javax.swing.tree.TreePath;
import javax.swing.tree.TreeSelectionModel;

import com.dbtw.db.utils.menus.NodePopupMenu;

import com.dbtw.tools.database.DatabaseColumn;
import com.dbtw.tools.database.DatabaseSchema;
import com.dbtw.tools.database.DatabaseTable;
import com.dbtw.models.ColumnNode;
import com.dbtw.models.DbNode;
import com.dbtw.models.DbTreeModel;
import com.dbtw.models.QueryNode;
import com.dbtw.models.SchemaNode;
import com.dbtw.models.TableNode;
import com.dbtw.tools.parser.SqlParser;
import com.dbtw.tools.parser.SqlParser2;
import com.dbtw.writers.QueryWriter;

import com.dbtw.widgets.UserPrefs;

public class SqlNavigatorPanel extends JPanel {
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
  private DbNode root = new DbNode("SQL");
  private DbTreeModel tm;
  private HashMap<SqlParser, String> parsers = new HashMap<SqlParser, String>();
  //Public variables

  //Constructors
  public SqlNavigatorPanel(JFrame parent, String sql) {
    this.parent = parent;
    init(sql);
  }
  
  public SqlNavigatorPanel(JFrame parent, File[] src) {
    this.parent = parent;
    init(src);
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

    left.setMinimumSize(new Dimension(divider, screen_height));
    right.setMinimumSize(new Dimension((screen_width/3), screen_height));

    //TODO Change to QueryTreeModel
//    tm = new DbTreeModel(root);
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
  }
  
  private void init(String sql) {
    init();
    loadNodes(sql, JOptionPane.showInputDialog(new JFrame(), "Please enter a name for this query"));
    buildTree();
  }
  
  private void init(File[] src) {
    init();
    for (int i = 0; i < src.length; i++) {
      File f = src[i];
      loadFile(f);
    }
    buildTree();
  }
  
  private void loadFile(File src) {
    SqlParser parser = new SqlParser();
    SqlParser2 parser2 = new SqlParser2();
    if (parser.isSingleFile(src)) {
      parser.parseFile(src);
//      parser2.parseSql(parser.parseFile(src));
//      parsers.put(parser, src.getName());
    }
    else {
      loadNodes(parser.parseFile(src), src.getName());
    }
  }
  
  private void loadNodes(String sql, String name) {
    String[] parts = sql.split(";");
    for (int i = 0; i < parts.length; i++) {
      String txt = parts[i];
      SqlParser parser = new SqlParser();
      parser.parse(txt);
      parsers.put(parser, name + "(" + i + ")");
    }
  }
  
  private void buildTree() {
    //TODO Change to QueryTreeModel
//    tm = new DbTreeModel(root);
    tree.setModel(tm);
    tree.addMouseListener(new MouseListener() {

      @Override
      public void mouseClicked(MouseEvent e) {
        // TODO Auto-generated method stub
      }

      @Override
      public void mousePressed(MouseEvent e) {
        if (e.getButton() == MouseEvent.BUTTON3) {
          DbNode node = (DbNode) tree.getClosestPathForLocation(e.getX(), e.getY()).getLastPathComponent();
          int x = e.getXOnScreen();
          int y = e.getYOnScreen();
          NodePopupMenu pmenu = new NodePopupMenu(node, x, y);
        }
      }

      @Override
      public void mouseReleased(MouseEvent e) {
        // TODO Auto-generated method stub
      }

      @Override
      public void mouseEntered(MouseEvent e) {
        // TODO Auto-generated method stub
      }

      @Override
      public void mouseExited(MouseEvent e) {
        // TODO Auto-generated method stub
      }
      
    });
    buildNodes();
  }
  
  private void buildNodes() {
    for (Iterator<SqlParser> n = parsers.keySet().iterator(); n.hasNext(); ) {
      SqlParser parser = n.next();
      QueryNode base = new QueryNode(parsers.get(parser));
      TreeMap<DatabaseTable, String> tables = parser.getTables();
      for (Iterator<DatabaseTable> i = tables.keySet().iterator(); i.hasNext(); ) {
        DatabaseTable table = i.next();
        String name = table.getName();
        if (tables.get(table).length() > 0) {
          name += " (" + tables.get(table)+ ")"; 
        }
        TableNode node = new TableNode(name);
        for (Iterator<DatabaseColumn> cols = table.getColumns().iterator(); cols.hasNext(); ) {
          DatabaseColumn col = cols.next();
          ColumnNode cnode = new ColumnNode(col.getName());
          node.add(cnode);
        }
        base.add(node);
      }
      root.add(base);
    }
  }
  
  private void addNodeListeners() {
    tree.addTreeSelectionListener(new TreeSelectionListener() {

      @Override
      public void valueChanged(TreeSelectionEvent e) {
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
