package com.dbtw.writers;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.io.File;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Vector;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import com.dbtw.models.ColumnModel;
import com.dbtw.models.SchemaModel;
import com.dbtw.models.TableModel;

import com.dbtw.widgets.DebugLogger;
import com.dbtw.widgets.LogFile;
import com.dbtw.widgets.StringWidget;
import com.dbtw.widgets.UserPrefs;

public class TableAdminClassWriter {
  //Static variables
  public static final String FILE_PATH = "path";
  public static final String PACKAGE = "pkg";
  //Constants
  private final String WHOAMI = "TableAdminClassWriter";
  //Private variables
  private int indent = 0;
  private HashMap<String, String> params = new HashMap<String, String>();
  private PrintWriter out;
  private Vector<HashMap<String, String>> elements = new Vector<HashMap<String, String>>();
  private SchemaModel schema = null;
  private String dbClassName = "";
  //Public variables

  //Constructors
  public TableAdminClassWriter(HashMap<String, String> params, SchemaModel schema, String empireName) {
    this.schema = schema;
    dbClassName = empireName;
    init(params);
  }

  //Static methods
  //Public methods
  public void write() {
    if (!writeTables()) {
      JOptionPane.showMessageDialog(new JFrame(), "Could not write file", "Data Access Error", JOptionPane.OK_OPTION);
    }
  }
  
  //Private methods
  private void init(HashMap<String, String> paramlist) {
    String errm = "";
    try {
      params = paramlist;
    }
    catch (Exception e) {
      logError("init", errm, e);
    }
  }
  
  private boolean openFile(String classname) {
    boolean result = false;
    String errm = "";
    String filename = classname + ".java";
    try {
      errm = "Opening " + params.get(FILE_PATH) + "\\" + filename;
      File ftest = new File(params.get(FILE_PATH));
      if (ftest.exists()) {
          out = new PrintWriter(new File(params.get(FILE_PATH), filename));
          result = true;
      }
    }
    catch (Exception e) {
      logError("openFile", errm, e);
    }
    return result;
  }
  
  private boolean writeTables() {
    boolean result = true;
    String errm = "";
    try {
      debugData();
      for (Iterator<String> t = schema.getSchemaTableList().iterator(); t.hasNext(); ) {
        TableModel table = schema.getSchemaTable(t.next());
        writeTable(table);
      }
    }
    catch (Exception e) {
      result = false;
      logError("writeTables", errm, e);
    }
    return result;
  }
  
  private void writeTable(TableModel table) {
    String errm = "";
    String classname = StringWidget.getCamelCase(table.getName()) + "AdminDialog";
    try {
      if (openFile(classname)) {
        writeHeader();
        writeClassDeclaration(classname);
        idVariables(table);
        writeVariables(classname);
        writeConstructor(classname);
        writeInit();
        writeCloseClass();
        out.close();
      }
      else {
        JOptionPane.showMessageDialog(new JFrame(), "Could not write file", "File System Error", JOptionPane.OK_OPTION);
      }

    }
    catch (Exception e) {
      logError("writeTable", errm, e);
    }
  }
  
  private void writeHeader() {
    String errm = "";
    try {
      out.println(params.get(PACKAGE));
      out.println("");
      out.println("import javax.swing.JFrame;");
      out.println("import java.awt.Cursor;");
      out.println("import java.awt.Dimension;");
      out.println("import java.awt.Toolkit;");
      out.println("import java.awt.event.ActionEvent;");
      out.println("import java.awt.event.ActionListener;");
      out.println("import java.io.File;");
      out.println("");
      out.println("import javax.swing.JButton;");
      out.println("import javax.swing.JComboBox;");
      out.println("import javax.swing.JFileChooser;");
      out.println("import javax.swing.JFrame;");
      out.println("import javax.swing.JLabel;");
      out.println("import javax.swing.JOptionPane;");
      out.println("import javax.swing.JPasswordField;");
      out.println("import javax.swing.JTextField;");
      out.println("import javax.swing.filechooser.FileNameExtensionFilter;");
      out.println("");
      out.println("import dbtw.widgets.LogFile;");
      out.println("import dbtw.widgets.UserPrefs;");
      out.println("import " + params.get("package")+ "." + dbClassName);
    }
    catch (Exception e) {
      logError("writeImports", errm, e);
    }
  }

  private void writeClassDeclaration(String name) {
    String errm = "";
    try {
      out.println("public class " + StringWidget.getCamelCase(name) + " {");
    }
    catch (Exception e) {
      logError("writeClassDeclaration", errm, e);
    }
  }
  
  private void writeCloseClass() {
    String errm = "";
    try {
      out.println("  private void logError(String method, String msg, Exception e) {");
      out.println("    LogFile log = LogFile.getInstance();");
      out.println("    log.writeLabel(WHOAMI, method);");
      out.println("    log.writeMsg(msg)");
      out.println("    log.writeDump(e)");
      out.println("    e.printStackTracke(System.out);");
      out.println("  }");
      out.println("}");
    }
    catch (Exception e) {
      logError("writeCloseClass", errm, e);
    }
  }
  
  private void idVariables(TableModel table) {
    String errm = "";
    try {
      HashMap<String,String> plabel = new HashMap<String, String> ();
      for (Iterator<ColumnModel> c = table.getColumns().iterator(); c.hasNext(); ) {
        ColumnModel column = c.next();
        HashMap<String,String> label = new HashMap<String, String> ();
        label.put("type", "JLabel");
        label.put("name", "lbl" + StringWidget.getCamelCase(column.getName()));
        if (elements.size() == 0) {
          label.put("x", "SPACING");
          label.put("y", "SPACING");
          label.put("width", "LABEL_WIDTH");
          label.put("height", "TEXT_HT");
        }
        else {
          label.put("x", "SPACING");
          label.put("y", "SPACING");
          label.put("width", "LABEL_WIDTH");
          label.put("height", "TEXT_HT");
        }
        elements.add(label);
        HashMap<String,String> editor = new HashMap<String, String> ();
        if ((column.getName().length() > 4) && (column.getName().substring(column.getName().length()-4).equalsIgnoreCase("_ID"))) {
          editor.put("type",  "JComboBox");
          editor.put("name", "cbo" + StringWidget.getCamelCase(column.getName()));
        }
        else {
          editor.put("type", "JTextField");
          editor.put("name", "txt" + StringWidget.getCamelCase(column.getName()));
        }
        editor.put("x", label.get("name") + ".getX() + " + label.get("name") + ".getWidth() + SPACING");
        editor.put("y", label.get("name") + ".getY()");
        label.put("width", "TEXT_WIDTH");
        label.put("height",  "TEXT_HT");
        plabel = label;
      }
    }
    catch (Exception e) {
      logError("idVariables", errm, e);
    }
  }
  
  private void writeVariables(String classname) {
    String errm = "";
    try {
      out.println("  private final String WHOAMI = \"" + StringWidget.getCamelCase(classname) + "\";");
      out.println("  private int indent = 0;");
      for (Iterator<HashMap<String, String>> e = elements.iterator(); e.hasNext(); ) {
        HashMap<String, String> element = e.next();
        String txt = "  private " + element.get("type") + " " + element.get("name") + " = new " + element.get("type");
        txt += "();";
        out.println(txt);
      }
    }
    catch (Exception e) {
      logError("writeVariables", errm, e);
    }
  }
  
  private void writeConstructor(String classname) {
    String errm = "";
    try {
      out.println("  public " + StringWidget.getCamelCase(classname) + "() {");
      out.println("    init();");
      out.println("  }");
    }
    catch (Exception e) {
      logError("writeConstructor", errm, e);
    }
  }
  
  private void writeInit() {
    String errm = "";
    try {
      out.println("  private void init() {");
      out.println("    try {");
      out.println("      setDefaultCloseOperation(DISPOSE_ON_CLOSE);");
      out.println("      getContentPane().setBackground(UserPrefs.getInstance().getColor());");
      out.println("      getContentPane().setLayout(null);");
      out.println("      setTitle(TITLE);");
      out.println("      setSize(WIDTH, HEIGHT);");
      out.println("      Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();");
      out.println("      int x = (int) ((dimension.getWidth() - getWidth()) / 2);");
      out.println("      int y = (int) ((dimension.getHeight() - getHeight()) / 2);");
      out.println("      setLocation(x, y);");
      out.println("      getRootPane().setDefaultButton(btnSubmit);");
      out.println("");
      out.println("    }");
      out.println("    catch (Exception e) {");
      out.println("      logError(\"init\", errm, e);");
      out.println("    }");
      out.println("  }");
    }
    catch (Exception e) {
      logError("writeInit", errm, e);
    }
  }
  
  private void debugData() {
    for (Iterator<String> p = params.keySet().iterator(); p.hasNext(); ) {
      String param = p.next();
      DebugLogger.logMsg(param + ": " + params.get(param));
    }
    DebugLogger.logMsg("Schema: "+ schema.getName());
    DebugLogger.logMsg("Class Name: " + dbClassName);
    for (Iterator<HashMap<String, String>> i = elements.iterator(); i.hasNext(); ) {
      HashMap<String, String> element = i.next();
      for (Iterator<String> keys = element.keySet().iterator(); keys.hasNext(); ) {
        String key = keys.next();
        DebugLogger.logMsg(key + ": " + element.get(key));
      }
    }
    for (Iterator<String> t = schema.getSchemaTableList().iterator(); t.hasNext(); ) {
      String tablename = t.next();
      TableModel table = schema.getSchemaTable(tablename);
      DebugLogger.logMsg(StringWidget.lpad(table.getName(), 20));
      for (Iterator<ColumnModel> c = table.getColumns().iterator(); c.hasNext(); ) {
        ColumnModel column = c.next();
        DebugLogger.logMsg(StringWidget.indent(column.getName(), 20));
      }
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
