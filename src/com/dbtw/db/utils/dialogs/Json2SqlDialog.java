package com.dbtw.db.utils.dialogs;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.plaf.metal.MetalIconFactory;

import com.dbtw.models.DbModelBuilder;
import com.dbtw.models.OltpModelBuilder;
import com.dbtw.tools.parser.DbDefCsvParser;
import com.dbtw.tools.parser.SourceColumnsParser;
import com.dbtw.writers.SqlCreateTableWriter;

import com.dbtw.widgets.LogFile;
import com.dbtw.widgets.UserPrefs;

public class Json2SqlDialog extends JFrame {
  //Static variables
  //Constants
  private final String WHOAMI = "Json2SqlDialog";
  private final int LABEL_WIDTH = 150;
  private final int TEXT_WIDTH = 150;
  private final int TEXT_HT = 25;
  private final int RB_WIDTH = 125;
  private final int SPACING = 5;
  private final int SCREEN_WIDTH = 425;
  private final int SCREEN_HT = 250;
  private final int SOURCE_FILE = 0;
  private final int DEST_FILE = 1;
  private final int DEF_FILE = 2;
  private final int OLTP = 0;
  private final int WAREHOUSE = 1;
  private final String TITLE = "JSON to SQL Conversion";
  //Private variables
  private int indent = 0;
  private ButtonGroup bgType = new ButtonGroup();
  private JLabel lblType = new JLabel("Script Type");
  private JRadioButton rbOLTP = new JRadioButton("OLTP");
  private JRadioButton rbWarehouse = new JRadioButton("Warehouse");
  private JLabel lblSource = new JLabel("Source File");
  private JTextField txtSource = new JTextField();
  private JButton btnSource = new JButton();
  private JLabel lblDest = new JLabel("Destination File");
  private JTextField txtDest = new JTextField();
  private JButton btnDest = new JButton();
  private JLabel lblDef = new JLabel("DB Definition File");
  private JTextField txtDef = new JTextField();
  private JButton btnDef = new JButton();
  private JLabel lblSchema = new JLabel("Schema");
  private JTextField txtSchema = new JTextField();
  private JButton btnSubmit = new JButton("Submit");
  //Public variables

  //Constructors
  public Json2SqlDialog() {
    init();
  }

  //Static methods
  //Public methods
  //Private methods
  private void init() {
    String errm = "";
    try {
      setDefaultCloseOperation(DISPOSE_ON_CLOSE);
      getContentPane().setBackground((Color) UserPrefs.getInstance().getParameter(UserPrefs.THEME_COLOR));
      getContentPane().setLayout(null);
      setTitle(TITLE);
      setSize(SCREEN_WIDTH, SCREEN_HT);
      Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
      int x = (int) ((dimension.getWidth() - getWidth()) / 2);
      int y = (int) ((dimension.getHeight() - getHeight()) / 2);
      setLocation(x, y);

      lblType.setSize(LABEL_WIDTH, TEXT_HT);
      lblType.setLocation(SPACING, SPACING);
      lblType.setHorizontalAlignment(JLabel.RIGHT);
      lblType.setForeground((Color) UserPrefs.getInstance().getParameter(UserPrefs.FONT_COLOR));
      bgType.add(rbOLTP);
      bgType.add(rbWarehouse);
      rbOLTP.setSize(RB_WIDTH, TEXT_HT);
      rbOLTP.setLocation(lblType.getX() + lblType.getWidth() + SPACING, lblType.getY());
      rbOLTP.setBackground((Color) UserPrefs.getInstance().getParameter(UserPrefs.THEME_COLOR));
      rbOLTP.setForeground((Color) UserPrefs.getInstance().getParameter(UserPrefs.FONT_COLOR));
      rbOLTP.setSelected(true);
      rbWarehouse.setSize(RB_WIDTH, TEXT_HT);
      rbWarehouse.setLocation(rbOLTP.getX() + rbOLTP.getWidth() + SPACING, rbOLTP.getY());
      rbWarehouse.setBackground((Color) UserPrefs.getInstance().getParameter(UserPrefs.THEME_COLOR));
      rbWarehouse.setForeground((Color) UserPrefs.getInstance().getParameter(UserPrefs.FONT_COLOR));
      
      lblSource.setSize(LABEL_WIDTH, TEXT_HT);
      lblSource.setLocation(lblType.getX(), lblType.getY() + lblType.getHeight() + SPACING);
      lblSource.setForeground((Color) UserPrefs.getInstance().getParameter(UserPrefs.FONT_COLOR));
      lblSource.setHorizontalAlignment(JLabel.RIGHT);
      txtSource.setSize(TEXT_WIDTH, TEXT_HT);
      txtSource.setLocation(lblSource.getX() + lblSource.getWidth() + SPACING, lblSource.getY());
      btnSource.setSize(TEXT_HT, TEXT_HT);
      btnSource.setLocation(txtSource.getX() + txtSource.getWidth() + SPACING, txtSource.getY());
      btnSource.setIcon(new MetalIconFactory.FolderIcon16());
      btnSource.setActionCommand("SourceFolder");
      btnSource.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent e) {
          if (e.getActionCommand().equals("SourceFolder")) {
            txtSource.setText(getFile(SOURCE_FILE));
          }
        }
      });
      
      lblDest.setSize(LABEL_WIDTH, TEXT_HT);
      lblDest.setLocation(lblSource.getX(), lblSource.getY() + lblSource.getHeight() + SPACING);
      lblDest.setForeground((Color) UserPrefs.getInstance().getParameter(UserPrefs.FONT_COLOR));
      lblDest.setHorizontalAlignment(JLabel.RIGHT);
      txtDest.setSize(TEXT_WIDTH, TEXT_HT);
      txtDest.setLocation(lblDest.getX() + lblDest.getWidth() + SPACING, lblDest.getY());
      btnDest.setSize(TEXT_HT, TEXT_HT);
      btnDest.setLocation(txtDest.getX() + txtDest.getWidth() + SPACING, txtDest.getY());
      btnDest.setIcon(new MetalIconFactory.FolderIcon16());
      btnDest.setActionCommand("TargetFolder");
      btnDest.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent e) {
          if (e.getActionCommand().equals("TargetFolder")) {
            txtDest.setText(getFile(DEST_FILE));
          }
        }
      });
      
      lblDef.setSize(LABEL_WIDTH, TEXT_HT);
      lblDef.setLocation(lblDest.getX(), lblDest.getY() + lblDest.getHeight() + SPACING);
      lblDef.setForeground((Color) UserPrefs.getInstance().getParameter(UserPrefs.FONT_COLOR));
      lblDef.setHorizontalAlignment(JLabel.RIGHT);
      txtDef.setSize(TEXT_WIDTH, TEXT_HT);
      txtDef.setLocation(lblDef.getX() + lblDef.getWidth() + SPACING, lblDef.getY());
      btnDef.setSize(TEXT_HT, TEXT_HT);
      btnDef.setLocation(txtDef.getX() + txtDef.getWidth() + SPACING, txtDef.getY());
      btnDef.setIcon(new MetalIconFactory.FolderIcon16());
      btnDef.setActionCommand("DefinitionFolder");
      btnDef.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent e) {
          if (e.getActionCommand().equals("DefinitionFolder")) {
            txtDef.setText(getFile(DEF_FILE));
          }
        }
      });
      
      lblSchema.setSize(LABEL_WIDTH, TEXT_HT);
      lblSchema.setLocation(lblDef.getX(), lblDef.getY() + lblDef.getHeight() + SPACING);
      lblSchema.setForeground((Color) UserPrefs.getInstance().getParameter(UserPrefs.FONT_COLOR));
      lblSchema.setHorizontalAlignment(JLabel.RIGHT);
      txtSchema.setSize(TEXT_WIDTH, TEXT_HT);
      txtSchema.setLocation(lblSchema.getX() + lblSchema.getWidth() + SPACING, lblSchema.getY());
      
      btnSubmit.setSize(LABEL_WIDTH, TEXT_HT);
      btnSubmit.setLocation(((SCREEN_WIDTH/2) - (btnSubmit.getWidth()/2)), (SCREEN_HT - (3*btnSubmit.getHeight()) - SPACING));
      btnSubmit.setActionCommand("SubmitConversion");
      btnSubmit.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent e) {
          if (e.getActionCommand().equals("SubmitConversion")) {
            convert();
          }
        }
      });
      
      getContentPane().add(lblType);
      getContentPane().add(rbOLTP);
      getContentPane().add(rbWarehouse);
      getContentPane().add(lblSource);
      getContentPane().add(txtSource);
      getContentPane().add(btnSource);
      getContentPane().add(lblDest);
      getContentPane().add(txtDest);
      getContentPane().add(btnDest);
      getContentPane().add(lblDef);
      getContentPane().add(txtDef);
      getContentPane().add(btnDef);
      getContentPane().add(lblSchema);
      getContentPane().add(txtSchema);
      getContentPane().add(btnSubmit);
      getRootPane().setDefaultButton(btnSubmit);
      
    }
    catch (Exception e) {
      logError("init", errm, e);
    }
  }

  private String getFile(int filetype) {
    FileNameExtensionFilter filter = new FileNameExtensionFilter("all files","*");
    switch (filetype) {
      case (SOURCE_FILE): {
        filter = new FileNameExtensionFilter("JSON Files","json","js");
        break;
      }
      case (DEST_FILE): {
        filter = new FileNameExtensionFilter("SQL files","sql");
        break;
      }
      case (DEF_FILE): {
        filter = new FileNameExtensionFilter("CSV files","csv");
        break;
      }
    }
    JFileChooser fc = new JFileChooser();
    fc.setFileFilter(filter);
    int result = fc.showOpenDialog(this);
    if (result == JFileChooser.APPROVE_OPTION) {
      return fc.getSelectedFile().getPath();
    }
    return null;
  }
  
  private void convert() {
    this.setCursor(new Cursor(Cursor.WAIT_CURSOR));
    String errm = "";
    try {
      File def = new File(txtDef.getText());
      DbDefCsvParser csv = new DbDefCsvParser(def);
      DbModelBuilder builder = null;
      
      SourceColumnsParser json = new SourceColumnsParser(new File(txtSource.getText()));
      if (rbOLTP.isSelected()) {
        builder = new OltpModelBuilder();
        builder.buildFromJSON(json, csv, txtSchema.getText());
      }
      if (rbWarehouse.isSelected()) {
      }
      File dest = new File(txtDest.getText());
      SqlCreateTableWriter writer = new SqlCreateTableWriter(dest, builder.getModel());
      writer.write();
    }
    catch (Exception e) {
      logError("convert", errm, e);
    }
    this.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
    this.setVisible(false);
    this.dispose();
  }
  
  private void logError(String method, String msg, Exception e) {
    LogFile log = LogFile.getInstance();
    log.writeLabel(WHOAMI, method);
    log.writeMsg(msg);
    log.writeDump(e);
    e.printStackTrace(System.out);
  }
}
