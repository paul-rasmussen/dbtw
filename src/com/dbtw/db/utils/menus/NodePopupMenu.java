package com.dbtw.db.utils.menus;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JPopupMenu;

import com.dbtw.models.DbNode;
import com.dbtw.writers.QueryWriter;

public class NodePopupMenu extends JPopupMenu {
  //Static variables
  //Constants
  private final int WIDTH = 150;
  private final int HEIGHT = 150;
  //Private variables
  private DbNode node = null;
  private JMenu print = new JMenu("Print");
  private JMenuItem html = new JMenuItem("Print HTML");
  private JMenuItem plain = new JMenuItem("Print");
  //Public variables

  //Constructors
  public NodePopupMenu(DbNode node, int left, int top) {
    super();
    this.node = node;
    init(left, top);
  }

  //Static methods
  //Public methods
  //Private methods
  private void init(int left, int top) {
    setLocation(left, top);
    setSize(WIDTH, HEIGHT);
    
    plain.setActionCommand("printPlain");
    plain.addActionListener(new ActionListener() {

      @Override
      public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals("printPlain")) {
          printPlainAction();
        }
        setVisible(false);
      }
      
    });
    
    
    html.setActionCommand("printHTML");
    html.addActionListener(new ActionListener() {

      @Override
      public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals("printHTML")) {
          printHtmlAction();
        }
        setVisible(false);
      }
      
    });
    
    add(plain);
    add(html);
    setVisible(true);
  }
  
  private void printHtmlAction() {
    QueryWriter writer = new QueryWriter(QueryWriter.HTML);
    writer.writeNode(node);
    writer.closeFile();
  }
  
  private void printPlainAction() {
    QueryWriter writer = new QueryWriter(QueryWriter.PLAINTEXT);
    writer.writeNode(node);
  }
  
}
