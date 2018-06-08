package com.dbtw.writers;

import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Iterator;

import com.dbtw.widgets.LogFile;

public class SqlCreateTableWriter {
  //Static variables
  public static final String SCHEMA = "schemaname";
  public static final String TABLE = "tablename";
  public static final String COLUMN = "columnname";
  public static final String DATATYPE = "datatype";
  public static final String LENGTH = "length";
  public static final String PRECISION = "precision";
  public static final String SCALE = "scale";
  public static final String NULL = "nullble";
  public static final String DEFAULT = "default";
  //Constants
  private final String WHOAMI = "SqlCreateTableWriter";
  //Private variables
  private int indent = 0;
  private PrintWriter out;
  private HashMap<String,HashMap<String,HashMap<String,HashMap<String, String>>>> data = new HashMap<String,HashMap<String,HashMap<String,HashMap<String, String>>>>();
  //Public variables

  //Constructors
  public SqlCreateTableWriter(File out, HashMap<String,HashMap<String,HashMap<String,HashMap<String, String>>>> data) {
    init(out);
    this.data = data;
  }

  //Static methods
  //Public methods
  public void write() {
    writeFile();
  }
  
  //Private methods
  private void init(File out) {
    String errm = "";
    try {
      this.out = new PrintWriter(out);
    }
    catch (Exception e) {
      logError("init", errm, e);
    }
  }

  private void writeFile() {
    String errm = "Writing data to output file";
    int col = 0;
    try {
      for (Iterator<String> s = data.keySet().iterator(); s.hasNext(); ) {
        String schema = s.next();
        HashMap<String,HashMap<String,HashMap<String, String>>> tdata = data.get(schema);
        for (Iterator<String> t = tdata.keySet().iterator(); t.hasNext(); ) {
          String table = t.next();
          String sql = "CREATE TABLE ";
          if ((schema != null) && (schema.length() > 0)) {
            sql += schema + ".";
          }
          if (tdata.keySet().size() == 0) {
            sql += "[No table keys found]";
          }
          sql += table + "(\n";
          HashMap<String,HashMap<String, String>> cdata = tdata.get(table);
          if (cdata.keySet().size() == 0) {
            sql += "[No column keys found]";
          }
          col = 0;
          for (Iterator<String> c = cdata.keySet().iterator(); c.hasNext(); ) {
            String column = c.next();
            if (col > 0) {
              sql += ",\n";
            }
            HashMap<String, String> params = cdata.get(column);
            sql += "    " + column;
            if (params.get(DATATYPE) != null) {
              sql += " " + params.get(DATATYPE);
            }
            if (params.get(LENGTH) != null) {
              sql += "(" + params.get(LENGTH) + ")";
            }
            if (params.get(NULL) != null) {
              sql += params.get(NULL);
            }
            if (params.get(DEFAULT) != null) {
              sql += " DEFAULT " + params.get(DEFAULT);
            }
            col++;
          }
          sql += "\n);\n/\n";
          if (tdata.keySet().size() > 0) {
            out.println(sql);
            out.flush();
          }
        }
      }
    }
    catch (Exception e) {
      logError("writeFile", errm, e);
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
