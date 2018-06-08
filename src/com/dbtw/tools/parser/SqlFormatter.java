package com.dbtw.tools.parser;

import com.dbtw.widgets.LogFile;
import com.dbtw.widgets.StringWidget;

public class SqlFormatter {
  //Static variables
  //Constants
  private final String WHOAMI = "SqlFormatter";
  private final int STD_INDENT = 7;
  private final int EXT_INDENT = 9;

  //Public variables
  //Protected variables
  //Private variables
  private String[] keywords = {"WITH","SELECT","FROM","WHERE","ORDER","GROUP","HAVING"};
  private int indent = 0;
  private int layer = 0;
  

  //Constructors
  public SqlFormatter() {
    init();
  }

  //Static methods
  public static String formatSql(String sql) {
    SqlFormatter sf = new SqlFormatter();
    return sf.format(sql);
  }

  //Public methods
  
  //Protected methods
  //Private methods
  private void init() {
    
  }
  
  private String format(String sql) {
    String txt = "";
    int start = 0;
    String delimiter = " ";
    String tdelimiter = ",";
    while (start < sql.length()) {
      String token = StringWidget.getToken(sql, delimiter, tdelimiter);
      if (isKeyword(token)) {
        txt += StringWidget.lpad(token, getIndent(token));
      }
      else {
        txt += " " + token;
      }
    }
    return txt;
  }

  private boolean isLayer(String word) {
    boolean answer = false;
    if (word.substring(1, 6).toUpperCase().equals("SELECT")) {
      answer = true;
    }
    return answer;
  }
  
  private boolean isKeyword(String word) {
    boolean answer = false;
    for (int i = 0; i < keywords.length; i++) {
      if (word.toUpperCase().equals(keywords[i])) {
        answer = true;
      }
    }
    return answer;
  }
  
  private int getIndent(String word) {
    int indent = 0;
    String txt = word.toUpperCase();
    if (isKeyword(word)) {
      if ((txt.equals("SELECT")) || (txt.equals("FROM")) || (txt.equals("WHERE")) || (txt.equals("HAVING"))) {
        indent = STD_INDENT;
      }
      else {
        indent =  EXT_INDENT;
      }
    }
    return indent;
  }
  
}
