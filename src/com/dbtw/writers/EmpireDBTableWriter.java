package com.dbtw.writers;

import java.util.Iterator;

import com.dbtw.models.ColumnModel;
import com.dbtw.models.TableModel;

import com.dbtw.widgets.LogFile;
import com.dbtw.widgets.StringWidget;

/**This class creates strings representing EmpireDB table class for the provided table
 * defined in the table model.
 * 
 * @author prasmuss
 *
 */
public class EmpireDBTableWriter {
	//Static variables
	//Constants
  private final String WHOAMI = "EmpireDBTableWriter";  //This value is used for logging/debugging.
	//Private variables
  private TableModel table;           //The table model provided
  private EmpireDBColumnWriter cwtr;  //A column model writer created to get the column model strings 
	//Public variables

	//Constructors
  /**Main constructor
   * 
   * @param table  The table model of the table to use
   */
	public EmpireDBTableWriter(TableModel table) {
		init(table);
	}

	//Static methods
	//Public methods
	/**A public wrapper for the method that writes the table class
	 * 
	 * @return String represents the EmpireDB class table definition class text
	 */
	public String getTableDefinition() {
		return writeTableDefinition();
	}
	
	/**A public wrapper for the method that writes the table class constructor
	 * 
	 * @return String represents the EmpireDB class constructor
	 */
	public String getTableConstructor() {
	  return writeTableConstructor();
	}
	
	/**A public wrapper for the method that writes the variable rows in the parent
	 * EmpireDB class.
	 * 
	 * @return  String represents the variable declaration of this table in the parent
	 */
	public String getTableVariable() {
	  return tableVariable();
	}
	
	//Private methods
	/**This method initializes the class
	 * 
	 * @param table  TableModel  representation of the table being represented
	 */
	private void init(TableModel table) {
	  String errm = "Assigning the table model to a local variable";
	  try {
	    this.table = table;
	    errm = "Creating the column writer for the column model";
	    cwtr = new EmpireDBColumnWriter(table.getColumns());
    }
    catch (Exception e) {
      logError("init", errm, e);
    }
	}
	
	/**This method writes the EmpireDB table class
	 * 
	 * @return  String text of the class
	 */
	private String writeTableDefinition() {
	  String txt = "  public static class " + StringWidget.getCamelCase(table.getName()) + " extends DBTable {\n";
	  txt += declareColumns();
	  txt += "\n";
	  txt += writeTableConstructor();
	  txt += "  }\n";
		return txt;
	}
	
	/**This method writes the constructor the the EmpireDB table class
	 * 
	 * @return  String text for the class constructor
	 */
	private String writeTableConstructor() {
	  String txt = "    public " + StringWidget.getCamelCase(table.getName()) + "(DBDatabase db) {\n";
	  txt += "      super(\"" + table.getName() + "\", db);\n";
	  txt += defineColumns();
	  txt += "    }\n";
	  return txt;
	}
	
	/**This method writes the column declarations for the EmpireDB table class
	 * 
	 * @return  String text for the class declarations
	 */
	private String declareColumns() {
	  String txt = "";
	  for (Iterator<ColumnModel> c = table.getColumns().iterator(); c.hasNext(); ) {
	    ColumnModel column = c.next();
	    txt += "    " + cwtr.getColumnDeclaration(column.getName(), EmpireDBColumnWriter.TABLE_COLUMN) + "\n";
	  }
	  return txt;
	}
	
	/**This method writes the column definitions for the EmpireDB table class
	 * 
	 * @return  String text for the EmpireDB column definitions for this class
	 */
	private String defineColumns() {
	  String txt = "";
    for (Iterator<ColumnModel> c = table.getColumns().iterator(); c.hasNext(); ) {
      ColumnModel column = c.next();
      txt += "      " + cwtr.getColumnDef(column.getName(), EmpireDBColumnWriter.TABLE_COLUMN) + "\n"; 
    }
	  return txt;
	}
	
	/**This method writes the table variable assignment for the parent EmpireDB class
	 * 
	 * @return  String text for the table variable assignment
	 */
	private String tableVariable() {
	  String txt = "";
	  txt = "public final " + StringWidget.getCamelCase(table.getName()) + " " + table.getName() + " = new " + StringWidget.getCamelCase(table.getName()) + "(this);";
	  return txt;
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
