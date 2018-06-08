package com.dbtw.db.utils.dialogs;

import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.HashMap;
import java.util.Vector;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.ListModel;

import com.dbtw.models.SchemaModel;
import com.dbtw.writers.EmpireDBClassWriter;
import com.dbtw.writers.EmpireDBViewClassWriter;
import com.dbtw.writers.TableAdminClassWriter;

import com.dbtw.widgets.LogFile;
import com.dbtw.widgets.UserPrefs;

import javax.swing.JScrollPane;
import javax.swing.SwingConstants;

import java.awt.Color;

import javax.swing.JTextField;
import javax.swing.plaf.metal.MetalIconFactory;

public class BuildOracleAdminEmpireDialog extends JFrame {
    //Static variables
    //Constants
    private final String WHOAMI = "BuildOracleAdminEmpireDialog";
    private final String TITLE = "EmpireDB Generator for Oracle System Views";  //This value is used for the dialogs title bar
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
    private JLabel lblDestinationFile = new JLabel("Destination Dir");
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
    public BuildOracleAdminEmpireDialog() {
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
        views.addElement("DBA_ADDM_FINDINGS");
        views.addElement("DBA_ADDM_INSTANCES");
        views.addElement("DBA_ADDM_TASKS");
        views.addElement("DBA_ADVISOR_ACTIONS");
        views.addElement("DBA_ADVISOR_COMMANDS");
        views.addElement("DBA_ADVISOR_FINDINGS");
        views.addElement("DBA_ADVISOR_JOURNAL");
        views.addElement("DBA_ADVISOR_PARAMETERS");
        views.addElement("DBA_ADVISOR_RECOMMENDATIONS");
        views.addElement("DBA_ADVISOR_TASKS");
        views.addElement("DBA_ADVISOR_USAGE");
        views.addElement("DBA_BLOCKERS");
        views.addElement("DBA_CONS_COLUMNS");
        views.addElement("DBA_CONSTRAINTS");
        views.addElement("DBA_DATA_FILES");
        views.addElement("DBA_DDL_LOCKS");
        views.addElement("DBA_DIRECTORIES");
        views.addElement("DBA_DML_LOCKS");
        views.addElement("DBA_FREE_SPACE");
        views.addElement("DBA_HIGH_WATER_MARK_STATISTICS");
        views.addElement("DBA_HIST_ACTIVE_SESS_HISTORY");
        views.addElement("DBA_HIST_SESS_TIME_STATS");
        views.addElement("DBA_HIST_SQLBIND");
        views.addElement("DBA_IND_COLUMNS");
        views.addElement("DBA_INDEXES");
        views.addElement("DBA_JOBS");
        views.addElement("DBA_LOCK");
        views.addElement("DBA_OBJECTS");
        views.addElement("DBA_SOURCE");
        views.addElement("DBA_TAB_COL_STATISTICS");
        views.addElement("DBA_TAB_COLUMNS");
        views.addElement("DBA_TAB_HISTOGRAMS");
        views.addElement("DBA_TAB_PARTITIONS");
        views.addElement("DBA_TAB_STATISTICS");
        views.addElement("DBA_TABLES");
        views.addElement("DBA_TABLESPACES");
        views.addElement("DBA_TRIGGERS");
        views.addElement("DBA_USERS");
        views.addElement("V_$ACTIVE_SESSION_HISTORY");
        views.addElement("V_$FILESTAT");
        views.addElement("V_$GLOBAL_BLOCKED_LOCKS");
        views.addElement("V_$HANG_INFO");
        views.addElement("V_$IOSTAT_FILE");
        views.addElement("V_$IOSAT_NETWORK");
        views.addElement("V_$LOCK");
        views.addElement("V_$LOCK_TYPE");
        views.addElement("V_$LOCKED_OBJECT");
        views.addElement("V_$OSSTAT");
        views.addElement("V_$PARAMETER");
        views.addElement("V_$PGASTAT");
        views.addElement("V_$PROCESS");
        views.addElement("V_$RESOURCE");
        views.addElement("V_$RESOURCE_LIMIT");
        views.addElement("V_$SESS_IO");
        views.addElement("V_$SESSION");
        views.addElement("V_$SESSTAT");
        views.addElement("V_$SGA");
        views.addElement("V_$SGASTAT");
        views.addElement("V_$SQL");
        views.addElement("V_$SQL_BIND_DATA");
        views.addElement("V_$SQL_HINT");
        views.addElement("V_$SQL_JOIN_FILTER");
        views.addElement("V_$SQLSTATS");
        views.addElement("V_$SQLTEXT");
        views.addElement("V_$SYSSTAT");
        views.addElement("GV_$ACTIVE_SESSION_HISTORY");
        views.addElement("GV_$LOCK");
        views.addElement("GV_$LOCK_TYPE");
        views.addElement("GV_$LOCKED_OBJECT");
        views.addElement("GV_$SESSION");
        views.addElement("GV_$SESSION_BLOCKERS");
        views.addElement("GV_$SESSION_LONGOPS");
        views.addElement("GV_$SQL");
        views.addElement("GV_$SQL_BIND_CAPTURE");
        views.addElement("GV_$SESSION_LONGOPS");
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
      File out;
      String className = "";
      String schema = "";
        out = new File(txtDest.getText(), ("OracleDatabase.java"));
        className = "OracleDatabase";
        schema = "SYS";
      this.setCursor(new Cursor(Cursor.WAIT_CURSOR));
      Vector<String> viewlist = new Vector<String>();
      for (int i = 0; i < views.size(); i++) {
          viewlist.add(views.elementAt(i));
      }
      EmpireDBViewClassWriter writer = new EmpireDBViewClassWriter(txtPkg.getText(), className, schema, viewlist, out);
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
