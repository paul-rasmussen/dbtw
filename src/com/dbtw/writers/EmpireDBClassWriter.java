package com.dbtw.writers;

import java.io.File;
import java.io.PrintWriter;
import java.util.Iterator;
import java.util.Vector;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import org.apache.empire.db.oracle.DBDatabaseDriverOracle;

import com.dbtw.tools.database.OracleDatabase;
import com.dbtw.models.SchemaModel;
import com.dbtw.models.TableModel;
import com.dbtw.models.ViewModel;

import com.dbtw.widgets.LogFile;
import com.dbtw.widgets.UserPrefs;

/**This class manages the writing of the EmpireDB class that will represent the desired schema.
 * 
 * This class only generates the tables. Views must currently be added manually.
 * 
 * @author Paul Rasmussen, DatabasesThatWork.com
 *
 */
public class EmpireDBClassWriter {
  //Static variables
  //Constants
  private final String WHOAMI = "EmpireDBClassWriter";  //This variable is used for logging/debugging
  //Private variables
  private int indent = 0;           //This value is not currently used
  private PrintWriter out;          //This value represents the output file
  private String classname = "";    //This value represents the name of the class being created
  private SchemaModel schema;       //This value represents the name of the schema being used
  private String pkg = "";          //This value represents the desired package name
  //Public variables

  //Constructors
  /**Main constructor
   * 
   * @param pkg         A string representing the desired package name for the created class
   * @param classname   A string representing the desired class name for the created class
   * @param srcschema   A string representing the database schema to use as the source for the class
   * @param dest        A File object representing the output file
   */
  public EmpireDBClassWriter(String pkg, String classname, String srcschema, File dest) {
    init(pkg, classname, srcschema, dest);
  }
  
  //Static methods
  //Public methods
  /**This method is a public wrapper for calling the private method that will actually build the
   * output file.
   * 
   * @return  boolean, true if successful
   */
  public boolean writeFile() {
    return buildFile();
  }
  
  //Private methods
  /**This method initializes the class, and writes the header information and standard imports.
   * The import list for this class should not require additions.
   * 
   * @param pkg         A string representing the name of the package
   * @param classname   A string representing the name of the class to be built
   * @param src         A string representing the source schema the class will be built from.
   * @param dest        A file object representing the output file for the class
   */
  private void init(String pkg, String classname, String src, File dest) {
    String errm = "Initializing";
    try {
      this.classname = classname;
      this.pkg = pkg;
      errm = "Assigning output file to local variable";
      out = new PrintWriter(dest);
      errm = "Getting the schema model for the desired schema";
      this.schema = new SchemaModel(src);
    }
    catch (Exception e) {
      logError("init", errm, e);
    }
  }

  /**This method writes the contents of the output file.
   * 
   * @return  boolean, true if successful
   */
	private boolean buildFile() {
	  String errm = "Writing to the file";
	  boolean result = false;
	  try {
	    errm = "Writing header information to file";
	    out.println("package " + pkg + ";\n");
      out.println("");
      out.println("import javax.swing.JFrame;");
      out.println("import javax.swing.JOptionPane;");
      out.println("");
      out.println("import org.apache.empire.data.DataType;");
      out.println("import org.apache.empire.db.DBCommandExpr;");
      out.println("import org.apache.empire.db.DBDatabase;");
      out.println("import org.apache.empire.db.DBTable;");
      out.println("import org.apache.empire.db.DBTableColumn;");
      out.println("import org.apache.empire.db.DBView;");
      out.println("import org.apache.empire.db.oracle.DBDatabaseDriverOracle;");
      out.println("");
      out.println("import dbtw.widgets.UserPrefs;");
      out.println("");
      out.flush();
      out.println("public class " + classname + " extends DBDatabase {");
      out.println("");
      out.println("  private static " + classname + " instance = null;");
      out.println("");
      out.flush();
      errm = "Writing table definitions";
      out.println("  //Table definitions for " + schema.getSchemaTableList().size() + " tables");
      for (Iterator<String> t = schema.getSchemaTableList().iterator(); t.hasNext(); ) {
        String tablename = t.next();
        errm = "Writing table definition for " + tablename;
        TableModel table = schema.getSchemaTable(tablename);
        EmpireDBTableWriter twriter = new EmpireDBTableWriter(table);
        out.println(twriter.getTableDefinition());
        out.flush();
      }
      
      errm = "Writing view definitions";
      for (Iterator<String> v = schema.getSchemaViewList().iterator(); v.hasNext(); ) {
          String viewname = v.next();
          errm = "Writing view definition for " + viewname;
          ViewModel view = schema.getSchemaView(viewname);
          EmpireDBViewWriter vwriter = new EmpireDBViewWriter(view);
          out.println(vwriter.getViewDefinition());
          out.flush();
      }
      
      errm = "Assigning table variables in constructor";
      for (Iterator<String> t = schema.getSchemaTableList().iterator(); t.hasNext(); ) {
        String tablename = t.next();
        errm = "Assigning value to variable for " + tablename + " in constructor";
        TableModel table = schema.getSchemaTable(tablename);
        EmpireDBTableWriter twriter = new EmpireDBTableWriter(table);
        out.println("  " + twriter.getTableVariable());
        out.flush();
      }
      
      errm = "Assigning view variables in constructor";
      for (Iterator<String> v = schema.getSchemaViewList().iterator(); v.hasNext(); ) {
          String viewname = v.next();
          errm = "Assigning value to variable for " + viewname + " in constructor";
          ViewModel view = schema.getSchemaView(viewname);
          EmpireDBViewWriter vwriter = new EmpireDBViewWriter(view);
          out.println("  " + vwriter.getViewVariable());
          out.flush();
      }
      
      out.println("");
      out.flush();
      errm = "Writing constructor";
      out.println("");
      out.println("  public " + classname + "() {");
      out.println("    super();");
      out.println("  }");
      out.flush();
      errm = "Writing getInstance method";
      out.println("  public static " + classname + " getInstance() {");
      out.println("    try {");
      out.println("      if (instance == null) {");
      out.println("        instance = new " + classname + "();");
      out.println("       instance.open(new DBDatabaseDriverOracle(), UserPrefs.getInstance().getConnection());");
      out.println("      }");
      out.println("    }");
      out.println("    catch (Exception e) {");
      out.println("      JOptionPane.showMessageDialog(new JFrame(), \"Problem opening database for use\", \"Application Error\", JOptionPane.OK_OPTION);");
      out.println("      e.printStackTrace(System.out);");
      out.println("    }");
      out.println("    return instance;");
      out.println("  }");
      out.println("");
      out.println("}");
      out.flush();
      result = true;
    }
    catch (Exception e) {
      result = false;
      logError("buildFile", errm, e);
    }
    return result;
  }
	
  private boolean writeTableDefs() {
    boolean result = false;
    String errm = "";
    try {
      for (Iterator<String> t = schema.getSchemaTableList().iterator(); t.hasNext(); ) {
        TableModel table = schema.getSchemaTable(t.next());
        EmpireDBTableWriter tblw = new EmpireDBTableWriter(table);
        out.println(tblw.getTableConstructor());
      }
      result = true;
    }
    catch (Exception e) {
      logError("writeTableDefs", errm, e);
    }
    return result;
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
