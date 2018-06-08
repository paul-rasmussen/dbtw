package com.dbtw.tools.sql;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.Enumeration;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.TreeMap;
import java.util.Vector;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import com.dbtw.tools.database.DatabaseColumn;
import com.dbtw.tools.database.DatabaseTable;

public class SqlParser {
  //Static variables
  //Constants
  //Private variables
  private TreeMap<DatabaseTable, String> tables = new TreeMap<DatabaseTable, String>();
  private String select = "";
  private String from = "";
  private String where = "";
  private String group = "";
  private String orderby = "";
  private String hint = "";
  //Public variables

  //Constructors
  public SqlParser() {
    init();
  }

  //Static methods
  //Public methods
  public void parse(String sql) {
    splitSql(sql);
    findTables();
    findColumns();
  }
  
  public TreeMap<DatabaseTable, String> getTables() {
    return tables;
  }
  
  public boolean isSingleFile(File src) {
    String sql = "";
    sql = loadFile(src);
    return isSingleFile(sql);
  }
  
  public String parseFile(File src) {
    String sql = "";
    sql = loadFile(src);
    if (isSingleFile(sql)) {
      parse(sql);
    }
    return sql;
  }
  
  public String parseSelect(String sql) {
    splitSql(sql);
    return select;
  }
  
  public String parseFrom(String sql) {
    splitSql(sql);
    return from;
  }
  
  public String parseWhere(String sql) {
    splitSql(sql);
    return where;
  }
  
  public String parseGroup(String sql) {
    splitSql(sql);
    return group;
  }
  
  public String parseOrder(String sql) {
    splitSql(sql);
    return orderby;
  }
  
  public String parseTables(String sql) {
    splitSql(sql);
    findTables();
    String tlist = "";
    for (Iterator<DatabaseTable> i = tables.keySet().iterator(); i.hasNext(); ) {
      DatabaseTable t = i.next();
      if (tlist.length() > 0) {
        tlist += "," + t.getSchema() + "." + t.getName();
      }
      else {
        tlist = t.getSchema() + "." + t.getName();
      }
    }
    return tlist;
  }
  
  public String parseColumns(String sql) {
    splitSql(sql);
    findTables();
    findColumns();
    String tlist = "";
    boolean first = true;
    for (Iterator<DatabaseTable> i = tables.keySet().iterator(); i.hasNext(); ) {
      DatabaseTable t = i.next();
      if (tlist.length() > 0) {
        tlist += "," + t.getSchema() + "." + t.getName();
      }
      else {
        tlist = t.getSchema() + "." + t.getName();
      }
      tlist += "(";
      first = true;
      for (Iterator<DatabaseColumn> c = t.getColumns().iterator(); c.hasNext(); ) {
        DatabaseColumn col = c.next();
        if (!first) {
          tlist += ",";
        }
        tlist += col.getName();
        first = false;
      }
      tlist += ")";
    }
    return tlist;
  }
  
  //Private methods
  private void init() {
  }
  
  private void splitSql(String sql) {
    snipSelect(sql);
    snipFrom(sql);
    snipWhere(sql);
    snipGroupBy(sql);
    snipOrder(sql);
  }
  
  private void snipSelect(String sql) {
    try {
      int start = sql.toUpperCase().indexOf("SELECT") + 7;
      int end = sql.toUpperCase().indexOf("FROM") - 1;
      select = sql.substring(start, end).trim();
    }
    catch (Exception e) {
      e.printStackTrace(System.out);
    }
  }
  
  private void snipFrom(String sql) {
    try {
      int end = 0;
      int start = sql.toUpperCase().indexOf("FROM") + 5;
      if (sql.toUpperCase().indexOf("WHERE") >= 0) {
        end = sql.toUpperCase().indexOf("WHERE")-1;
      }
      else {
        if (sql.toUpperCase().indexOf("GROUP") >= 0) {
          end = sql.toUpperCase().indexOf("GROUP") -1;
        }
        else {
          if (sql.toUpperCase().indexOf("ORDER") >= 0) {
            end = sql.toUpperCase().indexOf("ORDER") -1;
          }
          else {
            end = sql.length();
          }
        }
      }
      from = sql.substring(start, end).trim();
    }
    catch (Exception e) {
      e.printStackTrace(System.out);
    }
  }
  
  private void snipWhere(String sql) {
    try {
      int end = 0;
      int start = 0;
      if (sql.toUpperCase().indexOf("WHERE") >= 0) {
        start = sql.toUpperCase().indexOf("WHERE") + 6;
        if (sql.toUpperCase().indexOf("GROUP") >= 0) {
          end = sql.toUpperCase().indexOf("GROUP") -1;
        }
        else {
          if (sql.toUpperCase().indexOf("ORDER") >= 0) {
            end = sql.toUpperCase().indexOf("ORDER") -1;
          }
          else {
            end = sql.length();
          }
        }
        where = sql.substring(start, end).trim();
      }
    }
    catch (Exception e) {
      e.printStackTrace(System.out);
    }
  }
  
  private void snipGroupBy(String sql) {
    try {
      int end = 0;
      int start = 0;
      if (sql.toUpperCase().indexOf("GROUP BY") > 0) {
        start = sql.toUpperCase().indexOf("GROUP BY") + 9;
        if (sql.toUpperCase().indexOf("ORDER BY") >= 0) {
          end = sql.toUpperCase().indexOf("ORDER BY") -1;
        }
        else {
          end = sql.length();
        }
        group = sql.substring(start, end).trim();
      }
    }
    catch (Exception e) {
      e.printStackTrace(System.out);
    }
  }
  
  private void snipOrder(String sql) {
    try {
      int end = 0;
      int start = 0;
      if (sql.toUpperCase().indexOf("ORDER BY") >= 0) {
        start = sql.toUpperCase().indexOf("ORDER BY") + 9;
        orderby = sql.substring(start).trim();
      }
    }
    catch (Exception e) {
      e.printStackTrace(System.out);
    }
  }
  
  private void findTables() {
    int start = 0;
    int end = 0;
    String schema = "";
    String src = "";
    String alias = "";
    try {
      while (start < from.length()) {
        end = from.indexOf(",", start);
        if (end > start) {
          src = from.substring(start, end);
        }
        else {
          end = from.length() + 1;
          src = from.substring(start);
        }
        src = src.trim();
//        System.out.println("Source: " + src);
        if (src.indexOf(" ") > 0) {
          alias = src.substring((src.indexOf(" ") + 1));
          src = src.substring(0, src.indexOf(" "));
//          System.out.println("    Alias: " + alias);
//          System.out.println("    Source: " + src);
        }
        if (src.indexOf(".") > 0) {
          schema = src.substring(0, src.indexOf("."));
          src = src.substring(src.indexOf(".") + 1);
//          System.out.println("    Schema: " + schema);
//          System.out.println("    Source: " + src);
        }
        DatabaseTable table = new DatabaseTable(schema, src);
//        System.out.println("Adding " + table.getSchema() + "." + table.getName() + "(" + alias + ")");
        tables.put(table, alias);
        schema = "";
        src = "";
        alias = "";
        start = end + 1;
//        System.out.println("  Start is now " + start);
      }
    }
    catch (Exception e) {
      e.printStackTrace(System.out);
    }
  }
  
  private void findColumns() {
    int start = 0;
    int end = 0;
    String tableAlias = "";
    String col = "";
    try {
      while (start < select.length()) {
        end = select.indexOf(",", start);
        if (end > start) {
          col = select.substring(start, end);
        }
        else {
          end = select.length() + 1;
          col = select.substring(start);
        }
        col = col.trim();
        if (col.indexOf(" ") > 0) {
          col = col.substring(0, col.indexOf(" ") + 1).trim();
        }
        if (col.indexOf(".") > 0) {
          tableAlias = col.substring(0, col.indexOf(".")).trim();
          col = col.substring(col.indexOf(".") + 1).trim();
          if (tables.containsValue(tableAlias)) {
            DatabaseColumn c = new DatabaseColumn(col);
            for (Iterator<DatabaseTable> i = tables.keySet().iterator(); i.hasNext(); ) {
              DatabaseTable t = i.next();
              if (tables.get(t).equals(tableAlias)) {
                t.addColumn(c);
              }
            }
          }
          else {
            JOptionPane.showMessageDialog(new JFrame(), "There is a missing alias for a column.\n" + tableAlias + "." + col, "SQL ERROR", JOptionPane.OK_OPTION);
            end = from.length() + 1;
          }
        }
        start = end + 1;
      }
    }
    catch (Exception e) {
      e.printStackTrace(System.out);
    }
  }
  
  private boolean isSingleFile(String sql) {
    boolean result = true;
    int start = sql.indexOf(";");
    if ((start > 0) && (sql.toLowerCase().indexOf("select", start) >= 0)) {
      result = false;
    }
    return result;
  }
  
  private String loadFile(File src) {
    String txt = "";
    String tst = "";
    try {
      boolean first = true;
      BufferedReader rdr = new BufferedReader(new FileReader(src));
      while (rdr.ready()) {
        tst = rdr.readLine().trim();
        if (first) {
          txt = tst;
          first = false;
        }
        else {
          txt += " " + tst;
        }
      }
      rdr.close();
    }
    catch (Exception e) {
      e.printStackTrace(System.out);
    }
    return txt;
  }
}
