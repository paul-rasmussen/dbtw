package com.dbtw.writers;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Vector;

import com.dbtw.models.ColumnModel;
import com.dbtw.models.TableModel;

import com.dbtw.widgets.DebugLogger;
import com.dbtw.widgets.LogFile;
import com.dbtw.widgets.StringWidget;

public class EmpireDBColumnWriter {
  //Static variables
  public static final int TABLE_COLUMN = 0;
  public static final int VIEW_COLUMN = 1;
  //Constants
  private final String WHOAMI = "EmpireDBColumnWriter";
  //Private variables
  private int indent = 0;
  private Vector<ColumnModel> columns = new Vector<ColumnModel>();
  //Public variables

  //Constructors
  public EmpireDBColumnWriter(Vector<ColumnModel> columns) {
    init(columns);
  }

  //Static methods
  //Public methods
  public Vector<String> getKeys() {
    Vector<String> clist = new Vector<String>();
    for (Iterator<ColumnModel> c = columns.iterator(); c.hasNext(); ) {
      clist.add(c.next().getName());
    }
    return clist;
  }
  
  public String getColumnDeclaration(String colName, int colType) {
    return writeColDeclare(colName, colType);
  }
  
  public String getColumnDef(String colName, int colType) {
    return writeColDef(colName, colType);
  }
  
  //Private methods
  private void init(Vector<ColumnModel> colList) {
    String errm = "";
    try {
      columns = colList;
    }
    catch (Exception e) {
      logError("init", errm, e);
    }
  }

	private String writeColDeclare(String name, int colType) {
	    String val = "";
	    switch(colType) {
	        case 0: {
	            val = "public DBTableColumn " + name.toUpperCase().replaceAll("#", "_NO") + ";";
	            break;
	        }
	        case 1: {
	            val = "public DBViewColumn " + name.toUpperCase().replaceAll("#", "_NO") + ";";
	            break;
	        }
	    }
	    return val;
	}
	
	private String writeColDef(String name, int colType) {
	  DebugLogger log = DebugLogger.getInstance();
	  log.logHeader("EmpireDBColumnWriter.writeColDef");
	  log.logMsg("    ColumnType: " + colType);
	  String line = "";
	  for (Iterator<ColumnModel> c = columns.iterator(); c.hasNext(); ) {
	    ColumnModel column = c.next();
	    if (column.getName().equals(name)) {
	      log.logMsg("    Received: " + StringWidget.rpad(name, 20) + StringWidget.lpad(column.getColumnAttribute(ColumnModel.DATA_TYPE),15));
  	    switch (colType) {
	        case 0: {
            line = name.toUpperCase().replaceAll("#", "_NO") + " = addColumn(\"";
            if (name.toUpperCase().equals("ID")) {
              line += name.toUpperCase() + "\", DataType.AUTOINC, 0, true, \"" + name + "seq\");";
            }
            else {
              line += name.toUpperCase() + "\", DataType." + decodeDataType(column.getColumnAttribute(ColumnModel.DATA_TYPE));
              if (!(decodeDataType(column.getColumnAttribute(ColumnModel.DATA_TYPE)).equals("DATE")) && !(decodeDataType(column.getColumnAttribute(ColumnModel.DATA_TYPE)).equals("DATETIME"))) {
                  line += ", " + column.getColumnAttribute(ColumnModel.LENGTH);
              }
              else {
                  line += ", 0";
              }
              if (column.getColumnAttribute(ColumnModel.NULLABLE).equalsIgnoreCase("N")) {
                line += ", true);";
              }
              else {
                  line +=  ", false);";
              }
            }
            break;
	        }
          case 1: {
            if (!column.getColumnAttribute(ColumnModel.DATA_TYPE).equalsIgnoreCase("ANYDATA")) {
              line = name.toUpperCase().replaceAll("#",  "_NO") + " = addColumn(\"" + name.toUpperCase() + "\", DataType." + decodeDataType(column.getColumnAttribute(ColumnModel.DATA_TYPE));
              line += ");";
            }
            break;
          }
  	    }
	    }
	  }
	  log.logFooter("    Returned: " + line);
    return line;
	}
	
	private String decodeDataType(String type) {
		String line = "VARCHAR2";
		if ((type.equalsIgnoreCase("VARCHAR2")) || (type.equalsIgnoreCase("VARCHAR")) || (type.equalsIgnoreCase("CHAR")) || (type.equalsIgnoreCase("LONG"))) {
			line = "TEXT";
		}
		if ((type.equalsIgnoreCase("NUMBER")) || (type.equalsIgnoreCase("INTEGER"))) {
			line = "INTEGER";
		}
		if (type.equalsIgnoreCase("DOUBLE")) {
			line = "DECIMAL";
		}
		if (type.equalsIgnoreCase("DATE")) {
			line = "DATE";
		}
		if (type.startsWith("TIMESTAMP")) {
			line = "DATETIME";
		}
    if (type.equalsIgnoreCase("CLOB")) {
      line = "CLOB";
    }
    if ((type.equalsIgnoreCase("BLOB")) || (type.equalsIgnoreCase("RAW"))) {
      line = "BLOB";
    }
		return line;
	}

  private void logError(String method, String msg, Exception e) {
    LogFile log = LogFile.getInstance();
    log.writeLabel(WHOAMI, method);
    log.writeMsg(msg);
    log.writeDump(e);
    e.printStackTrace(System.out);
  }
}
