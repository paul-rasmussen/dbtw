package com.dbtw.writers;

import java.io.File;
import java.io.PrintWriter;
import java.util.Iterator;
import java.util.Vector;

import org.apache.empire.db.DBReader;
import org.apache.empire.db.oracle.DBCommandOracle;

import com.dbtw.models.SchemaModel;
import com.dbtw.models.TableModel;
import com.dbtw.models.ViewModel;
import com.dbtw.tools.database.OracleDatabase;

import com.dbtw.widgets.LogFile;
import com.dbtw.widgets.StringWidget;
import com.dbtw.widgets.UserPrefs;

public class EmpireDBViewClassWriter {
    // Static variables
    // Constants
    private final String WHOAMI = "EmpireDBViewClassWriter";
    private int indent = 0; // This value is not currently used
    private PrintWriter out; // This value represents the output file
    private String classname = ""; // This value represents the name of the
                                   // class being created
    private String schema = "sys"; // This value represents the name of the
                                   // schema being used
    private String pkg = ""; // This value represents the desired package name
    private Vector<ViewModel> views = new Vector<ViewModel>();

    // Public variables
    // Protected variables
    // Private variables

    // Constructors
    public EmpireDBViewClassWriter(String pkg, String classname, String srcschema, Vector<String> views, File dest) {
        init(pkg, classname, srcschema, views, dest);
    }

    // Static methods
    // Public methods
    /**
     * This method is a public wrapper for calling the private method that will
     * actually build the output file.
     * 
     * @return boolean, true if successful
     */
    public boolean writeFile() {
        return buildFile();
    }

    // Protected methods
    // Private methods
    /**
     * This method initializes the class, and writes the header information and
     * standard imports. The import list for this class should not require
     * additions.
     * 
     * @param pkg
     *            A string representing the name of the package
     * @param classname
     *            A string representing the name of the class to be built
     * @param src
     *            A string representing the source schema the class will be
     *            built from.
     * @param dest
     *            A file object representing the output file for the class
     */
    private void init(String pkg, String classname, String src, Vector<String> views, File dest) {
        String errm = "Initializing";
        try {
            this.classname = classname;
            this.pkg = pkg;
            errm = "Assigning output file to local variable";
            out = new PrintWriter(dest);
            errm = "Getting the schema model for the desired schema";
            loadViews(src, views);
        }
        catch (Exception e) {
            logError("init", errm, e);
        }
    }

    private void loadViews(String schema, Vector<String> viewList) {
        String errm = "Loading views for " + schema;
        try {
            for (Iterator<String> v = viewList.iterator(); v.hasNext();) {
                String name = v.next();
                errm = "Loading " + schema + "." + name;
                ViewModel view = new ViewModel(schema, name);
                views.add(view);
            }
        }
        catch (Exception e) {
            logError("loadViews", errm, e);
        }
    }

    /**
     * This method writes the contents of the output file.
     * 
     * @return boolean, true if successful
     */
    private boolean buildFile() {
        String errm = "Writing to the file";
        boolean result = true;
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
            errm = "Writing view definitions";
            out.println("  //View definitions for " + views.size() + " views");
            for (Iterator<ViewModel> v = views.iterator(); v.hasNext();) {
                ViewModel view = v.next();
                String viewname = view.getName();
                errm = "Writing view definition for " + viewname;
                EmpireDBViewWriter vwriter = new EmpireDBViewWriter(view);
                out.println(vwriter.getViewDefinition());
                out.flush();
            }
            errm = "Assigning variables in constructor";
            for (Iterator<ViewModel> v = views.iterator(); v.hasNext();) {
                ViewModel view = v.next();
                String viewname = view.getName();
                errm = "Assigning value to variable for " + viewname + " in constructor";
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

    /**
     * This method provides a standard way of logging errors.
     * 
     * @param method
     *            A string representing the name of the method in which the
     *            error occurred.
     * @param msg
     *            A string providing information about the code process that
     *            caused the error.
     * @param e
     *            An exception object representing the error.
     */
    private void logError(String method, String msg, Exception e) {
        LogFile log = LogFile.getInstance();
        log.writeLabel(WHOAMI, method);
        log.writeMsg(msg);
        log.writeDump(e);
        e.printStackTrace(System.out);
    }
    
    private void debug() {
      LogFile log = LogFile.getInstance();
      log.writeMsg("EmpireDBViewClassWriter - Debug Data");
      for (int i = 0; i < views.size(); i++) {
        ViewModel m = views.get(i);
        log.writeMsg(StringWidget.lpad(m.getName(), 25));
      }
    }
}
