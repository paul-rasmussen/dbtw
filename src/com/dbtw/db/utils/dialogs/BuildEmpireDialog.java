package com.dbtw.db.utils.dialogs;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.HashMap;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.filechooser.FileNameExtensionFilter;

import com.dbtw.models.SchemaModel;
import com.dbtw.writers.EmpireDBClassWriter;
import com.dbtw.writers.TableAdminClassWriter;

import com.dbtw.widgets.LogFile;
import com.dbtw.widgets.UserPrefs;
import javax.swing.JCheckBox;

/**This class presents the opportunity to the user to provide values for the variables
 * required to perform this task.
 * 
 * @author prasmuss
 *
 */
public class BuildEmpireDialog extends JFrame {
  //Static variables
  //Constants
  private final String WHOAMI = "BuildEmpireDialog";  //This value is used for logging/debugging
  private final String TITLE = "EmpireDB Generator";  //This value is used for the dialogs title bar
  private final int WIDTH = 450;                      //This value represents the dialogs width
  private final int HEIGHT = 220;                     //This value represents the dialogs height
  private final int LABEL_WIDTH = 150;                //This value represents the width of label objects
  private final int TEXT_WIDTH = 100;                 //This value represents the default width of text and value objects
  private final int TEXT_HT = 25;                     //This value represents the default height for all standard gui objects
  private final int SPACING = 5;                      //This value represents the default spacing between gui objects
  //Private variables
  private int indent = 0;                                     //This value is not currently used
  private JLabel lblSrcSchema = new JLabel("Source Schema"); 
  private JTextField txtSrcSchema = new JTextField();
  private JLabel lblDest = new JLabel("Destination Dir");
  private JTextField txtDest = new JTextField();
  private JButton btnDest = new JButton();
  private JLabel lblPkg = new JLabel("Package");
  private JTextField txtPkg = new JTextField();
  private JLabel lblClassName = new JLabel("Class Name");
  private JTextField txtClass = new JTextField();
  private JCheckBox chkIncludeSysViews = new JCheckBox("Include Sys views class");
  private JButton btnSubmit = new JButton("Submit");

  //Public variables

  //Constructors
  public BuildEmpireDialog() {
    init();
  }

  //Static methods
  //Public methods
  //Private methods
  /**This method provides the initialization of the dialog
   * 
   */
  private void init() {
    String errm = "";  //This variable is used to 1) document program flow/intent and 2) provide information for debugging
    try {
      errm = "Initializing the dialog frame";
      setDefaultCloseOperation(DISPOSE_ON_CLOSE);
      getContentPane().setBackground((Color) UserPrefs.getInstance().getParameter(UserPrefs.THEME_COLOR));
      getContentPane().setLayout(null);
      setTitle(TITLE);
      setSize(450, 256);
      Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
      int x = (int) ((dimension.getWidth() - getWidth()) / 2);
      int y = (int) ((dimension.getHeight() - getHeight()) / 2);
      setLocation(x, y);
      setAlwaysOnTop(true);
      getRootPane().setDefaultButton(btnSubmit);

      errm = "Setting up dialog gui components";
      lblSrcSchema.setSize(LABEL_WIDTH, TEXT_HT);
      lblSrcSchema.setLocation(SPACING, SPACING);
      lblSrcSchema.setForeground((Color) UserPrefs.getInstance().getParameter(UserPrefs.FONT_COLOR));
      lblSrcSchema.setHorizontalAlignment(JLabel.RIGHT);
      
      txtSrcSchema.setSize(TEXT_WIDTH, TEXT_HT);
      txtSrcSchema.setLocation(lblSrcSchema.getX() + lblSrcSchema.getWidth() + SPACING, lblSrcSchema.getY());
      
      lblDest.setSize(LABEL_WIDTH, TEXT_HT);
      lblDest.setLocation(lblSrcSchema.getX(), lblSrcSchema.getY() + lblSrcSchema.getHeight() + SPACING);
      lblDest.setForeground((Color) UserPrefs.getInstance().getParameter(UserPrefs.FONT_COLOR));
      lblDest.setHorizontalAlignment(JLabel.RIGHT);
      
      txtDest.setSize((2*TEXT_WIDTH), TEXT_HT);
      txtDest.setLocation(lblDest.getX() + lblDest.getWidth() + SPACING, lblDest.getY());
      txtDest.setText((String) UserPrefs.getInstance().getParameter(UserPrefs.OUTPUT_DIR));
      if (((Integer) UserPrefs.getInstance().getParameter(UserPrefs.ENVIRONMENT)) == UserPrefs.LINUX) {
        txtDest.setText(System.getenv("HOME"));
      }
      if (((Integer) UserPrefs.getInstance().getParameter(UserPrefs.ENVIRONMENT)) == UserPrefs.WINDOWS) {
        txtDest.setText(System.getenv("USERPROFILE"));
      }
      
      btnDest.setSize(TEXT_HT, TEXT_HT);
      btnDest.setLocation(txtDest.getX() + txtDest.getWidth() + SPACING, txtDest.getY());
      btnDest.setActionCommand("GetDestFile");
      btnDest.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent e) {
          if (e.getActionCommand().equals("GetDestFile")) {
            submitDestAction();
          }
        }
      });

      lblPkg.setSize(LABEL_WIDTH, TEXT_HT);
      lblPkg.setLocation(lblDest.getX(), lblDest.getY() + lblDest.getHeight() + SPACING);
      lblPkg.setForeground((Color) UserPrefs.getInstance().getParameter(UserPrefs.FONT_COLOR));
      lblPkg.setHorizontalAlignment(JLabel.RIGHT);
      
      txtPkg.setSize(TEXT_WIDTH, TEXT_HT);
      txtPkg.setLocation(lblPkg.getX() + lblPkg.getWidth() + SPACING, lblPkg.getY());
      txtPkg.setText("com.dbtw");
      
      lblClassName.setSize(LABEL_WIDTH, TEXT_HT);
      lblClassName.setLocation(lblPkg.getX(), lblPkg.getY() + lblPkg.getHeight() + SPACING);
      lblClassName.setForeground((Color) UserPrefs.getInstance().getParameter(UserPrefs.FONT_COLOR));
      lblClassName.setHorizontalAlignment(JLabel.RIGHT);
      
      txtClass.setSize(TEXT_WIDTH, TEXT_HT);
      txtClass.setLocation(lblClassName.getX() + lblClassName.getWidth() + SPACING, lblClassName.getY());
      txtClass.setText("EmpireDB");
      
      chkIncludeSysViews.setBounds(125, 137, 187, 23);

      btnSubmit.setSize(TEXT_WIDTH, TEXT_HT);
      btnSubmit.setLocation(173, 182);
      btnSubmit.setActionCommand("buildEmpireDb");
      btnSubmit.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent e) {
          if (e.getActionCommand().equals("buildEmpireDb")) {
            submitAction();
          }
        }
      });
      
      errm = "Adding gui components to dialog";
      getContentPane().add(lblSrcSchema);
      getContentPane().add(txtSrcSchema);
      getContentPane().add(lblDest);
      getContentPane().add(txtDest);
      getContentPane().add(btnDest);
      getContentPane().add(lblPkg);
      getContentPane().add(txtPkg);
      getContentPane().add(lblClassName);
      getContentPane().add(txtClass);
      getContentPane().add(chkIncludeSysViews);
      getContentPane().add(btnSubmit);
      
    }
    catch (Exception e) {
      logError("init", errm, e);
    }
  }
  
  /**This method provides the action to perform when the submit button is pressed.
   * 
   */
  private void submitAction() {
    File out = new File(txtDest.getText(), (txtClass.getText() + ".java"));
    this.setCursor(new Cursor(Cursor.WAIT_CURSOR));
    EmpireDBClassWriter writer = new EmpireDBClassWriter(txtPkg.getText(), txtClass.getText(), txtSrcSchema.getText().toUpperCase(), out);
    if (!writer.writeFile()) {
      JOptionPane.showMessageDialog(new JFrame(), "There was an error writing the EmpireDB Java class file for " + txtPkg.getText() + "." + txtClass.getText(), "Generator Error", JOptionPane.OK_OPTION);
    }
    else {
      HashMap<String, String> params = new HashMap<String, String>();
      String path = txtDest.getText() + File.pathSeparator + "admin";
      params.put(TableAdminClassWriter.FILE_PATH, path);
      String pkg = txtPkg.getText().substring(0, txtPkg.getText().lastIndexOf(".")) + ".admin";
      params.put(TableAdminClassWriter.PACKAGE, pkg);
      TableAdminClassWriter adminwriter = new TableAdminClassWriter(params, new SchemaModel(txtSrcSchema.getText().toUpperCase()), txtClass.getText());
      adminwriter.write();
    }
    if (chkIncludeSysViews.isSelected()) {
        buildSysViews();
    }
    this.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
    this.dispose();
  }
  
  /**This method provides the action to perform when the new destination button is pressed.
   * 
   */
  private void submitDestAction() {
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
      logError("submitDestAction", errm, e);
    }
  }

  private void buildSysViews() {
      BuildOracleAdminEmpireDialog dialog = new BuildOracleAdminEmpireDialog();
      dialog.setVisible(true);
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
