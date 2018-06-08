package com.dbtw.tools.parser;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Vector;

import com.dbtw.models.DbNode;
import com.dbtw.models.QueryNode;
import com.dbtw.tools.database.OracleTokens;

import com.dbtw.widgets.DebugLogger;

public class SqlParser2 {
  //Static variables
  //Constants
  private final int SELECT = 1;
  private final int FROM = 2;
  private final int WHERE = 3;
  private final int GROUP_BY = 4;
  private final int ORDER_BY = 5;
  private final int WITH = 6;
  //Private variables
  private int level = 0;
  private HashMap<Integer, QueryNode> queries = new HashMap<Integer, QueryNode>();
  private int section = 0;
  private boolean endOfSection = false;
  private Vector<Object[]> selectParts = new Vector<Object[]>();
  private Vector<Object[]> fromParts = new Vector<Object[]>();
  private Vector<Object[]> whereParts = new Vector<Object[]>();
  private Vector<Object[]> groupParts = new Vector<Object[]>();
  private Vector<Object[]> orderParts = new Vector<Object[]>();
  private String[] followsSelect = {"FROM"};
  private String[] followsFrom = {"WHERE", "GROUP", "ORDER", "MINUS", "INTERSECT"};
  private String[] followsWhere = {"GROUP", "ORDER", "MINUS", "INTERSECT"};
  private String[] followsGroup = {"ORDER", "MINUS", "INTERSECT"};
  
  //Public variables

  //Constructors
  public SqlParser2() {
    init();
  }

  //Static methods
  //Public methods
  public void parseSql(String sql) {
    parse(sql);
  }
  
  public Vector<Object[]> getSelectParts() {
    return selectParts;
  }
  
  public Vector<Object[]> getFromParts() {
    return fromParts;
  }
  
  public Vector<Object[]> getWhereParts() {
    return whereParts;
  }
  
  public Vector<Object[]> getGroupParts() {
    return groupParts;
  }
  
  public Vector<Object[]> getOrderParts() {
    return orderParts;
  }
  
  public void debugStructure() {
    logStructures();
  }
  
  //Private methods
  private void init() {
  }

  private void parse(String sql) {
    try {
      String token = "";
      int start = 0;
      int end = 0;
      while (start < sql.length()) {
        token = nextToken(sql.substring(start));
        if (token.equalsIgnoreCase("WITH")) {
          section = WITH;
          start += 5;
          if (sql.toUpperCase().indexOf(") SELECT") > 0) {
            end = sql.toUpperCase().indexOf(") SELECT", start);
          }
          else {
            end = sql.toUpperCase().indexOf(")SELECT", start);
          }
          token = sql.substring(start, end);
        }
        if ((section == WITH) && ((token.toUpperCase().indexOf(") SELECT") > 0) || (token.toUpperCase().indexOf(")SELECT") > 0))) {
          if (token.toUpperCase().indexOf(") SELECT") > 0) {
            end = token.toUpperCase().indexOf(") SELECT");
          }
          else {
            end = token.toUpperCase().indexOf(")SELECT");
          }
          token = token.substring(0,  end);
          endOfSection = true;
        }
        if (token.equalsIgnoreCase("SELECT")) {
          section = SELECT;
          start += 7;
          token = nextToken(sql.substring(start));
        }
        if ((section == SELECT) && (token.toUpperCase().indexOf("FROM") > 0)) {
          token = token.substring(0, token.toUpperCase().indexOf("FROM")-1);
          endOfSection = true;
        }
        if (token.equalsIgnoreCase("FROM")) {
          section = FROM;
          start += 5;
          token = nextToken(sql.substring(start));
        }
        if ((section >= FROM) && (token.toUpperCase().indexOf("WHERE") > 0)) {
          token = token.substring(0, token.toUpperCase().indexOf("WHERE")-1);
          endOfSection = true;
        }
        if (token.equalsIgnoreCase("WHERE")) {
          section = WHERE;
          start += 6;
          token = nextToken(sql.substring(start));
        }
        if ((section >= FROM) && (token.toUpperCase().indexOf("GROUP") > 0)) {
          token = token.substring(0, token.toUpperCase().indexOf("GROUP")-1);
          endOfSection = true;
        }
        if (token.equalsIgnoreCase("GROUP")) {
          section = GROUP_BY;
          start += 9;
          token = nextToken(sql.substring(start));
        }
        if ((section >= FROM) && (token.toUpperCase().indexOf("ORDER") > 0)) {
          token = token.substring(0, token.toUpperCase().indexOf("ORDER")-1);
          endOfSection = true;
        }
        if (token.equalsIgnoreCase("ORDER")) {
          section = ORDER_BY;
          start += 9;
          token = nextToken(sql.substring(start));
        }
        switch (section) {
          case (SELECT): {
            selectParts.add(parseSelect(token.trim()));
            break;
          }
          case (FROM): {
            fromParts.add(parseFrom(token.trim()));
            break;
          }
          case (WHERE): {
            parseWhere(token.trim());
            break;
          }
          case (GROUP_BY): {
            groupParts.add(parseGroup(token.trim()));
            break;
          }
          case (ORDER_BY): {
            orderParts.add(parseOrder(token.trim()));
            break;
          }
          case (WITH): {
            fromParts.add(parseWith(token.trim()));
            endOfSection = true;
            break;
          }
        }
        if (endOfSection) {
          section = 0;
          endOfSection = false;
        }
        start += token.length() + 1;
      }
    }
    catch (Exception e) {
      e.printStackTrace(System.out);
    }
    logStructures();
  }
  
  private Object[] parseWith(String sql) {
    DebugLogger.indentPlus();
    Object[] parts = {"","",""};
    try {
      DebugLogger.logMsg("parseWith\n");
      DebugLogger.logMsg("Received: '" + sql + "'\n");
      int start = 0;
      int end = sql.indexOf("(");
      int queryStart = 0;
      int queryEnd = 0;
      int asIndex = sql.toUpperCase().indexOf("AS");
      
      if (end > asIndex) {
        //there is no parameter list
        end = asIndex;
      }
      parts[2] = sql.substring(start, end).trim();
      DebugLogger.logMsg("Alias: '" + parts[2] + "'\n");
      start = sql.indexOf("(", end) + 1;
      String token = "";
      if ((start > -1) && (end > -1)) {
        token = sql.substring(start);
      }
      else {
        token = sql.substring(0);
      }
      DebugLogger.logMsg("Pulled: '" + token + "'\n");
      SqlParser2 parser = new SqlParser2();
      parser.parse(token);
      parser.debugStructure();
      parts[1] = parser;
    }
    catch (Exception e) {
      e.printStackTrace(System.out);
    }
    DebugLogger.indentMinus();
    return parts;
  }
  
  private Object[] parseSelect(String sql) {
    Object[] parts = {"","",""};
    try {
      int oparen = sql.indexOf("(");
      if (oparen > 0) {
        //This has a function in it
        String f = sql.substring(0, oparen);
        if (OracleTokens.isDbFunct(f)) {
          parts[1] = sql.trim();
        }
      }
      else {
        if (sql.indexOf(".") > -1) {
          parts[0] = sql.substring(0, sql.indexOf(".")).trim();
          if (sql.indexOf(" ") > 0) {
            parts[1] = sql.substring(sql.indexOf(".")+1, sql.indexOf(" ")).trim();
            parts[2] = sql.substring(sql.indexOf(" ")+1).trim();
          }
          else {
            parts[1] = sql.substring(sql.indexOf(".")+1).trim();
          }
        }
        else {
          parts[1] = sql.trim();
        }
      }
    }
    catch (Exception e) {
      e.printStackTrace(System.out);
    }
    return parts;
  }

  private Object[] parseFrom(String sql) {
    Object[] parts = {"","",""};
    try {
      if (sql.indexOf("(") > -1) {
        SqlParser2 parser = new SqlParser2();
        parser.parse(sql.substring(sql.indexOf("(") + 1, sql.lastIndexOf(")")));
        parts[1] = parser;
        int astart = sql.indexOf(" ", sql.lastIndexOf(")"));
        if (astart > -1) {
          parts[2] = sql.substring(astart + 1).trim();
        }
      }
      else {
        if (sql.indexOf(".") > -1) {
          parts[0] = sql.substring(0, sql.indexOf(".")).trim();
          if (sql.indexOf(" ") > -1) {
            parts[1] = sql.substring(sql.indexOf(".")+1, sql.indexOf(" ")).trim();
            parts[2] = sql.substring(sql.indexOf(" ")+1).trim();
          }
          else {
            parts[1] = sql.substring(sql.indexOf(".")+1).trim();
          }
        }
        else {
          parts[1] = sql.trim();
        }
      }
    }
    catch (Exception e) {
      e.printStackTrace(System.out);
    }
    return parts;
  }
  
  private void parseWhere(String sql) {
    try {
      whereParts = new Vector<Object[]>();
      String token = "";
      int start = 0;
      int interval = 0;
      int end = 0;
      int andIndex = sql.toUpperCase().indexOf("AND");
      int orIndex = sql.toUpperCase().indexOf("OR");
      if ((andIndex > -1) || (orIndex > -1)) {
        if ((andIndex < orIndex) && (andIndex > -1)) {
          end = andIndex;
          interval = (end - start) + 4;
        }
        if ((orIndex < andIndex) && (orIndex > -1)) {
          end = orIndex;
          interval = (end - start) + 3;
        }
        while (end < sql.length()) {
          whereParts.add(parseFilter(sql.substring(start, end)));
          //More than one filter
          start += interval;
          end = sql.length() + 1;
          andIndex = sql.toUpperCase().indexOf("AND", end);
          orIndex = sql.toUpperCase().indexOf("OR", end);
          if ((andIndex < orIndex) && (andIndex > -1)) {
            end = andIndex;
            interval = (end - start) + 4;
          }
          if ((orIndex < andIndex) && (orIndex > -1)) {
            end = orIndex;
            interval = (end - start) + 3;
          }
        }
      }
      else {
        parseFilter(sql);
      }
    }
    catch (Exception e) {
      e.printStackTrace(System.out);
    }
  }

  private Object[] parseFilter(String sql) {
    Object[] parts = {"","","","",""};
    try {
      int period = 0;
      String op = OracleTokens.hasDbOperator(sql);
      if (op.length() > 0) {
        int opStart = sql.indexOf(op);
        int opEnd =opStart + op.length();
        if (opStart > 0) {
          String left = sql.substring(0, opStart);
          if (left.indexOf("SELECT") > -1) {
            SqlParser2 parser = new SqlParser2();
            parser.parse(left);
            parts[1] = parser;
          }
          else {
            period = left.indexOf(".");
            if (period > -1) {
              parts[0] = left.substring(0, period).trim();
              parts[1] = left.substring(period + 1).trim();
            }
            else {
              parts[1] = left.trim();
            }
          }
        }
        if (opEnd > 0) {
          String right = sql.substring(opEnd);
          if (right.indexOf("SELECT") > -1) {
            SqlParser2 parser = new SqlParser2();
            parser.parse(right);
            parts[1] = parser;
          }
          else {
            period = right.indexOf(".");
            if (period > -1) {
              parts[3] = right.substring(0, period).trim();
              parts[4] = right.substring(period + 1).trim();
            }
            else {
              parts[4] = right.trim();
            }
          }
        }
      
        parts[2] = op;
      }
      else {
        parts[0] = sql;
      }
    }
    catch (Exception e) {
      e.printStackTrace(System.out);
    }
    return parts;
  }
  
  private Object[] parseGroup(String sql) {
    Object[] parts = {"",""};
    try {
      int period = sql.indexOf(".");
      if (period > -1) {
        parts[0] = sql.substring(0, period);
        parts[1] = sql.substring(period + 1);
      }
      else {
        parts[1] = sql;
      }
    }
    catch (Exception e) {
      e.printStackTrace(System.out);
    }
    return parts;
  }
  
  private Object[] parseOrder(String sql) {
    Object[] parts = {"",""};
    try {
      int period = sql.indexOf(".");
      if (period > -1) {
        parts[0] = sql.substring(0, period);
        parts[1] = sql.substring(period + 1);
      }
      else {
        parts[1] = sql;
      }
    }
    catch (Exception e) {
      e.printStackTrace(System.out);
    }
    return parts;
  }
  
  private String nextToken(String txt) {
    String token = "";
    boolean safe = false;
    try {
      int start = 0;
      String element = txt.substring(start,start + 1);
      if (element.equals("(")) {
        safe = true;
      }
      while (((start + 1) < txt.length()) && ((!isSeparator(element)) || (safe))) {
        token += element;
        start++;
        element = txt.substring(start, start + 1);
        if (element.equals("(")) {
          safe = true;
        }
        if (element.equals(")")) {
          safe = false;
        }
      }
      if (!isSeparator(element)) {
        token += element;
      }
    }
    catch (Exception e) {
      e.printStackTrace(System.out);
    }
    return token;
  }
  
  private boolean isFunction(String token) {
    boolean result = false;
    if (token.indexOf("(") > 0) {
      String f = token.substring(0, token.indexOf("("));
      result = OracleTokens.isDbFunct(f);
    }
    return result;
  }
  
  private boolean isDelimiter(String item) {
    boolean result = false;
    if (item.equals("(")) {
      result = true;
    }
    if (item.equals(")")) {
      result = true;
    }
    return result;
  }
  
  private boolean isSeparator(String item) {
    boolean result = false;
    if (item.equals(",")) {
      result = true;
    }
    if (item.equals(";")) {
      result = true;
    }
    if (section == 0) {
      if (item.equals(" ")) {
        result = true;
      }
    }
    return result;
  }
  
  private int separatorIndex(String txt) {
    int delim = 0;
    delim = txt.indexOf(",");
    if (section == 0) {
      if (txt.indexOf(" ") < delim) {
        delim = txt.indexOf(" ");
      }
    }
    if (txt.indexOf(";") < delim) {
      delim = txt.indexOf(";");
    }
    return delim;
  }
  
  private boolean in(String element, String[] set) {
    boolean result = false;
    for (int i = 0; i < set.length; i++) {
      if (element.equalsIgnoreCase(set[i])) {
        result = true;
      }
    }
    return result;
  }
  
  private void logStructures() {
    DebugLogger.logMsg("######################################################################################\n");
    DebugLogger.indentPlus();
    try {
      DebugLogger.logMsg("SELECT -------------------------------------------------------------\n");
      for (Iterator<Object[]> sitems = selectParts.iterator(); sitems.hasNext(); ) {
        Object[] parts = sitems.next();
        DebugLogger.logMsg("Table Alias: " + parts[0] + "\n");
        DebugLogger.logMsg("Column: " + parts[1] + "\n");
        DebugLogger.logMsg("Alias: " + parts[2] + "\n");
      }
      DebugLogger.logMsg("\n\nFROM ---------------------------------------------------------------\n");
      for (Iterator<Object[]> fitems = fromParts.iterator(); fitems.hasNext(); ) {
        Object[] parts = fitems.next();
        if (parts[1].getClass().getSimpleName().equals("SqlParser2")) {
          SqlParser2 p2 = (SqlParser2) parts[1];
          p2.debugStructure();
          DebugLogger.logMsg("Alias: " + parts[2] + "\n");
        }
        else {
          DebugLogger.logMsg("Schema: " + parts[0] + "\n");
          DebugLogger.logMsg("Table: " + parts[1] + "\n");
        }
        DebugLogger.logMsg("Alias: " + parts[2] + "\n");
      }
      DebugLogger.logMsg("\n\nWHERE -------------------------------------------------------------\n");
      for (Iterator<Object[]> witems = whereParts.iterator(); witems.hasNext(); ) {
        Object[] parts = witems.next();
        DebugLogger.logMsg("Left Alias: " + parts[0] + "\n");
        DebugLogger.logMsg("Left Item: " + parts[1] + "\n");
        DebugLogger.logMsg("Operator: " + parts[2] + "\n");
        DebugLogger.logMsg("Right Alias: " + parts[3] + "\n");
        DebugLogger.logMsg("Right Item: " + parts[4] + "\n");
      }
      DebugLogger.logMsg("\n\nGROUP ----------------------------------------------------------------\n");
      for (Iterator<Object[]> gitems = groupParts.iterator(); gitems.hasNext(); ) {
        Object[] parts = gitems.next();
        DebugLogger.logMsg("Alias: " + parts[0] + "\n");
        DebugLogger.logMsg("Column: " + parts[1] + "\n");
      }
      DebugLogger.logMsg("\n\nORDER -----------------------------------------------------------------\n");
      for (Iterator<Object[]> oitems = orderParts.iterator(); oitems.hasNext(); ) {
        Object[] parts = oitems.next();
        DebugLogger.logMsg("Alias: " + parts[0] + "\n");
        DebugLogger.logMsg("Column: " + parts[1] + "\n");
      }
    }
    catch (Exception e) {
      e.printStackTrace(System.out);
    }
    DebugLogger.indentMinus();
  }
}
