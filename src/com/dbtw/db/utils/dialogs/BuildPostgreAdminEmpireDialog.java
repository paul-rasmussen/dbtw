package com.dbtw.db.utils.dialogs;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.Vector;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.plaf.metal.MetalIconFactory;

import com.dbtw.widgets.DebugLogger;
import com.dbtw.widgets.LogFile;
import com.dbtw.widgets.UserPrefs;
import com.dbtw.writers.EmpireDBViewClassWriter;

public class BuildPostgreAdminEmpireDialog extends JFrame {
    //Static variables
    //Constants
    private final String WHOAMI = "BuildPostgreAdminEmpireDialog";
    private final String TITLE = "EmpireDB Generator for Postgre Information Views";  //This value is used for the dialogs title bar
    private final int WIDTH = 456;                      //This value represents the dialogs width
    private final int HEIGHT = 295;                     //This value represents the dialogs height
    private final int LABEL_WIDTH = 150;                //This value represents the width of label objects
    private final int TEXT_WIDTH = 100;                 //This value represents the default width of text and value objects
    private final int TEXT_HT = 25;                     //This value represents the default height for all standard gui objects
    private final int SPACING = 5;                      //This value represents the default spacing between gui objects

    //Public variables
    //Protected variables
    //Private variables
    private DefaultListModel<String> views = new DefaultListModel<String>();
    private JLabel lblDestinationFile = new JLabel("Destination File");
    private JLabel lblPackage = new JLabel("Package");
    private JButton btnFindFile = new JButton("");
    private JScrollPane scrollPane = new JScrollPane();
    private JList viewlist = new JList(views);
    private JButton btnSubmit = new JButton("Submit");
    private JButton btnAdd = new JButton("Add");
    private JButton btnRemove = new JButton("==>");
    private JTextField txtDest = new JTextField();
    private JTextField txtPkg = new JTextField();

    //Constructors
    public BuildPostgreAdminEmpireDialog() {
        init();
    }

    //Static methods
    //Public methods
    //Protected methods
    //Private methods
    private void init() {
        String errm = "";  //This variable is used to 1) document program flow/intent and 2) provide information for debugging
        try {
          errm = "Initializing the dialog frame";
          setDefaultCloseOperation(DISPOSE_ON_CLOSE);
          getContentPane().setBackground((Color) UserPrefs.getInstance().getParameter(UserPrefs.THEME_COLOR));
          getContentPane().setLayout(null);
          setTitle(TITLE);
          setSize(519, 360);
          Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
          int x = (int) ((dimension.getWidth() - getWidth()) / 2);
          int y = (int) ((dimension.getHeight() - getHeight()) / 2);
          setLocation(x, y);
          getRootPane().setDefaultButton(btnSubmit);
          loadDefaults();
          
          errm = "Setting up dialog gui components";
          scrollPane.setBounds(76, 64, 278, 199);
          
          lblDestinationFile.setForeground(Color.WHITE);
          lblDestinationFile.setHorizontalAlignment(SwingConstants.RIGHT);
          lblDestinationFile.setBounds(10, 11, 122, 14);
          
          txtDest.setBounds(136, 8, 278, 20);
          getContentPane().add(txtDest);
          txtDest.setColumns(10);
          
          btnFindFile.setBounds(417, 8, 23, 20);
          btnFindFile.setIcon(new MetalIconFactory.FolderIcon16());
          btnFindFile.setActionCommand("newFile");
          btnFindFile.addActionListener(new ActionListener() {
              public void actionPerformed(ActionEvent e) {
                  if (e.getActionCommand().equals("newFile")) {
                    newFileAction();
                  }
                }
          });

          lblPackage.setForeground(Color.WHITE);
          lblPackage.setHorizontalAlignment(SwingConstants.RIGHT);
          lblPackage.setBounds(20, 36, 112, 14);

          txtPkg.setBounds(136, 33, 244, 20);
          getContentPane().add(txtPkg);
          txtPkg.setColumns(10);
          
          btnRemove.setToolTipText("Remove a row");
          btnRemove.setBounds(377, 102, 63, 25);
          btnRemove.setActionCommand("removeView");
          btnRemove.addActionListener(new ActionListener() {
              public void actionPerformed(ActionEvent e) {
                  if (e.getActionCommand().equals("removeView")) {
                    removeAction();
                  }
                }
              });

          btnAdd.setToolTipText("Add a row");
          btnAdd.setBounds(377, 181, 63, 25);
          btnAdd.setActionCommand("addView");
          btnAdd.addActionListener(new ActionListener() {
              public void actionPerformed(ActionEvent e) {
                  if (e.getActionCommand().equals("addView")) {
                    addAction();
                  }
                }
              });

          btnSubmit.setSize(TEXT_WIDTH, TEXT_HT);
          btnSubmit.setLocation(217, 285);
          btnSubmit.setActionCommand("buildEmpireDb");
          btnSubmit.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
              if (e.getActionCommand().equals("buildEmpireDb")) {
                submitAction();
              }
            }
          });
          
          errm = "Adding gui components to dialog";
          getContentPane().add(lblDestinationFile);
          getContentPane().add(btnFindFile);
          getContentPane().add(lblPackage);
          getContentPane().add(btnSubmit);
          getContentPane().add(scrollPane);
          scrollPane.setViewportView(viewlist);
          getContentPane().add(btnRemove);
          getContentPane().add(btnAdd);
          validate();
        }
        catch (Exception e) {
          logError("init", errm, e);
        }
    }

    private void loadDefaults() {
        views.addElement("tables");
        views.addElement("columns");
        views.addElement("table_constraints");
        views.addElement("constraint_column_usage");
        views.addElement("constraint_table_usage");
        views.addElement("check_constraints");
        views.addElement("key_column_usage");
        views.addElement("referential_constraints");
        views.addElement("pg_database");
        views.addElement("pg_tablespace");
        views.addElement("pg_roles");
        views.addElement("pg_tables");
        views.addElement("pg_user");
    }
    
    private void addAction() {
        String newView = JOptionPane.showInputDialog(new JFrame(), "View Name To Add", "Add View to List", JOptionPane.OK_CANCEL_OPTION);
       views.addElement(newView);
       validate();
    }
    
    private void removeAction() {
        views.remove(viewlist.getSelectedIndex());
        validate();
    }
    
    /**This method provides the action to perform when the submit button is pressed.
     * 
     */
    private void submitAction() {
      File out = new File(txtDest.getText(), ("PostgreDatabase.java"));
      this.setCursor(new Cursor(Cursor.WAIT_CURSOR));
      Vector<String> viewlist = new Vector<String>();
      for (int i = 0; i < views.size(); i++) {
          viewlist.add(views.elementAt(i));
      }
      EmpireDBViewClassWriter writer = new EmpireDBViewClassWriter(txtPkg.getText(), "PostgreDatabase", "SYS", viewlist, out);
      if (!writer.writeFile()) {
        JOptionPane.showMessageDialog(new JFrame(), "There was an error writing the EmpireDB Java class file for " + txtPkg.getText() + "." + txtPkg.getText(), "Generator Error", JOptionPane.OK_OPTION);
      }
      this.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
      this.dispose();
    }
    
    private void newFileAction() {
        String errm = "";
        try {
          JFileChooser fc = new JFileChooser();
          fc.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
          int answer = fc.showOpenDialog(this);
          if (answer == JFileChooser.APPROVE_OPTION) {
            txtDest.setText(fc.getSelectedFile().getPath());
          }
        }
        catch (Exception e) {
          logError("newFileAction", errm, e);
        }
    }
    
    /**This method provides a standard way of logging errors.
     * 
     * @param method  A string representing the name of the method in which the error occurred.
     * @param msg     A string providing information about the code process that caused the error.
     * @param e       An exception object representing the error.
     */
    private void logError(String method, String msg, Exception e) {
      LogFile log = LogFile.getInstance();
      log.writeLabel(WHOAMI, method);
      log.writeMsg(msg);
      log.writeDump(e);
      e.printStackTrace(System.out);
    }
}
