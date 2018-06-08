package com.dbtw.writers;

import java.util.Iterator;

import org.apache.empire.db.DBCommandExpr;

import com.dbtw.models.ColumnModel;
import com.dbtw.models.ViewModel;

import com.dbtw.widgets.DebugLogger;
import com.dbtw.widgets.LogFile;
import com.dbtw.widgets.StringWidget;
import com.dbtw.widgets.LogFile;

;

public class EmpireDBViewWriter {
    // Static variables
    // Constants
    private final String WHOAMI = "EmpireDBViewWriter";
    private ViewModel view; // The view model provided
    private EmpireDBColumnWriter cwtr; // A column model writer created to get
                                       // the column model strings

    // Public variables
    // Protected variables
    // Private variables

    // Constructors
    public EmpireDBViewWriter(ViewModel view) {
        init(view);
    }

    // Static methods
    // Public methods
    /**
     * A public wrapper for the method that writes the view class
     * 
     * @return String represents the EmpireDB class view definition class text
     */
    public String getViewDefinition() {
        return writeViewDefinition();
    }

    /**
     * A public wrapper for the method that writes the view class constructor
     * 
     * @return String represents the EmpireDB class constructor
     */
    public String getViewConstructor() {
        return writeViewConstructor();
    }

    /**
     * A public wrapper for the method that writes the variable rows in the
     * parent EmpireDB class.
     * 
     * @return String represents the variable declaration of this table in the
     *         parent
     */
    public String getViewVariable() {
        return viewVariable();
    }

    // Private methods
    /**
     * This method initializes the class
     * 
     * @param view
     *            viewModel representation of the view being represented
     */
    private void init(ViewModel srcview) {
        String errm = "Assigning the view model to a local variable";
        try {
            view = srcview;
            errm = "Creating the column writer for the column model";
            cwtr = new EmpireDBColumnWriter(view.getColumns());
        }
        catch (Exception e) {
            logError("init", errm, e);
        }
    }

    /**
     * This method writes the EmpireDB view class
     * 
     * @return String text of the class
     */
    private String writeViewDefinition() {
        String txt = "  public static class " + StringWidget.getCamelCase(view.getName()) + " extends DBView {\n";
        txt += declareColumns();
        txt += "\n";
        txt += writeViewConstructor();
        txt += "  }\n";
        return txt;
    }

    /**
     * This method writes the constructor the the EmpireDB view class
     * 
     * @return String text for the class constructor
     */
    private String writeViewConstructor() {
        String txt = "    public " + StringWidget.getCamelCase(view.getName()) + "(DBDatabase db) {\n";
        txt += "      super(\"" + view.getName() + "\", db);\n";
        txt += defineColumns();
        txt += "    }\n\n";
        txt += writeViewCommand();
        return txt;
    }

    private String writeViewCommand() {
        String txt = "    @Override\n";
        txt += "    public DBCommandExpr createCommand() {\n";
        txt += "      return null;\n";
        txt += "    }\n";
        return txt;
    }

    /**
     * This method writes the column declarations for the EmpireDB view class
     * 
     * @return String text for the class declarations
     */
    private String declareColumns() {
        String txt = "";
        for (Iterator<ColumnModel> c = view.getColumns().iterator(); c.hasNext();) {
            ColumnModel column = c.next();
            txt += "    " + cwtr.getColumnDeclaration(column.getName(), EmpireDBColumnWriter.VIEW_COLUMN) + "\n";
        }
        return txt;
    }

    /**
     * This method writes the column definitions for the EmpireDB view class
     * 
     * @return String text for the EmpireDB column definitions for this class
     */
    private String defineColumns() {
        String txt = "";
        for (Iterator<ColumnModel> c = view.getColumns().iterator(); c.hasNext();) {
            ColumnModel column = c.next();
            txt += "      " + cwtr.getColumnDef(column.getName(), EmpireDBColumnWriter.VIEW_COLUMN) + "\n";
        }
        return txt;
    }

    /**
     * This method writes the view variable assignment for the parent EmpireDB
     * class
     * 
     * @return String text for the table variable assignment
     */
    private String viewVariable() {
        String txt = "";
        txt = "public final " + StringWidget.getCamelCase(view.getName()) + " " + view.getName() + " = new "
                + StringWidget.getCamelCase(view.getName()) + "(this);";
        return txt;
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

}
