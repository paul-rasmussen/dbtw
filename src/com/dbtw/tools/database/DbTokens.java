package com.dbtw.tools.database;

public class DbTokens {
  //Static variables
  //Constants
  //Private variables
  private String[] followsSelect = {"FROM"};
  private String[] followsFrom = {"WHERE", "GROUP", "ORDER", "MINUS", "INTERSECT"};
  private String[] followsWhere = {"GROUP", "ORDER", "MINUS", "INTERSECT"};
  private String[] followsGroup = {"ORDER", "MINUS", "INTERSECT"};
  //Public variables

  //Constructors
  public DbTokens() {
    init();
  }

  //Static methods
  public static boolean isDbKey(String token) {
    DbTokens dt = new DbTokens();
    return dt.isDbKeyword(token);
  }

  public static String hasDbOperator(String token) {
    DbTokens dt = new DbTokens();
    return dt.hasWhereOperator(token);
  }
  
  public static boolean isDbSeparator(String item) {
    DbTokens dt = new DbTokens();
    return dt.isDbNameSeparator(item);
  }
  
  //Public methods
  public boolean isDbKeyword(String token) {
    return isKeyword(token);
  }
  
  public String hasDbWhereOperator(String token) {
    return hasWhereOperator(token);
  }
  
  public boolean isDbNameSeparator(String item) {
    return isNameSeparator(item);
  }
  
  //Private methods
  private void init() {  
  }
  
  private boolean isKeyword(String token) {
    boolean result = false;
    if (token.equalsIgnoreCase("AFTER")) {
      result = true;
    }
    if (token.equalsIgnoreCase("AND")) {
      result = true;
    }
    if (token.equalsIgnoreCase("ANY")) {
      result = true;
    }
    if (token.equalsIgnoreCase("AS")) {
      result = true;
    }
    if (token.equalsIgnoreCase("ASC")) {
      result = true;
    }
    if (token.equalsIgnoreCase("CLASSIFIER")) {
      result = true;
    }
    if (token.equalsIgnoreCase("CONNECT")) {
      result = true;
    }
    if (token.equalsIgnoreCase("CROSS")) {
      result = true;
    }
    if (token.equalsIgnoreCase("CUBE")) {
      result = true;
    }
    if (token.equalsIgnoreCase("CYCLE")) {
      result = true;
    }
    if (token.equalsIgnoreCase("DESC")) {
      result = true;
    }
    if (token.equalsIgnoreCase("DIMENSION")) {
      result = true;
    }
    if (token.equalsIgnoreCase("DISTINCT")) {
      result = true;
    }
    if (token.equalsIgnoreCase("FETCH")) {
      result = true;
    }
    if (token.equalsIgnoreCase("FINAL")) {
      result = true;
    }
    if (token.equalsIgnoreCase("FOR")) {
      result = true;
    }
    if (token.equalsIgnoreCase("FROM")) {
      result = true;
    }
    if (token.equalsIgnoreCase("FULL")) {
      result = true;
    }
    if (token.equalsIgnoreCase("GROUP")) {
      result = true;
    }
    if (token.equalsIgnoreCase("GROUPING")) {
      result = true;
    }
    if (token.equalsIgnoreCase("HAVING")) {
      result = true;
    }
    if (token.equalsIgnoreCase("IN")) {
      result = true;
    }
    if (token.equalsIgnoreCase("INNER")) {
      result = true;
    }
    if (token.equalsIgnoreCase("INSERT")) {
      result = true;
    }
    if (token.equalsIgnoreCase("ITERATE")) {
      result = true;
    }
    if (token.equalsIgnoreCase("INTERSECT")) {
      result = true;
    }
    if (token.equalsIgnoreCase("LEFT")) {
      result = true;
    }
    if (token.equalsIgnoreCase("LIKE")) {
      result = true;
    }
    if (token.equalsIgnoreCase("MATCH_NUMBER")) {
      result = true;
    }
    if (token.equalsIgnoreCase("MATCH_RECOGNIZE")) {
      result = true;
    }
    if (token.equalsIgnoreCase("MEASURES")) {
      result = true;
    }
    if (token.equalsIgnoreCase("MINUS")) {
      result = true;
    }
    if (token.equalsIgnoreCase("MODEL")) {
      result = true;
    }
    if (token.equalsIgnoreCase("NATURAL")) {
      result = true;
    }
    if (token.equalsIgnoreCase("NEXT")) {
      result = true;
    }
    if (token.equalsIgnoreCase("NULLS")) {
      result = true;
    }
    if (token.equalsIgnoreCase("OFFSET")) {
      result = true;
    }
    if (token.equalsIgnoreCase("ONLY")) {
      result = true;
    }
    if (token.equalsIgnoreCase("ORDER")) {
      result = true;
    }
    if (token.equalsIgnoreCase("PARTITION")) {
      result = true;
    }
    if (token.equalsIgnoreCase("PIVOT")) {
      result = true;
    }
    if (token.equalsIgnoreCase("PREV")) {
      result = true;
    }
    if (token.equalsIgnoreCase("REFERENCE")) {
      result = true;
    }
    if (token.equalsIgnoreCase("RETURN")) {
      result = true;
    }
    if (token.equalsIgnoreCase("RIGHT")) {
      result = true;
    }
    if (token.equalsIgnoreCase("ROLLUP")) {
      result = true;
    }
    if (token.equalsIgnoreCase("RULES")) {
      result = true;
    }
    if (token.equalsIgnoreCase("RUNNING")) {
      result = true;
    }
    if (token.equalsIgnoreCase("SEARCH")) {
      result = true;
    }
    if (token.equalsIgnoreCase("SELECT")) {
      result = true;
    }
    if (token.equalsIgnoreCase("SET")) {
      result = true;
    }
    if (token.equalsIgnoreCase("START")) {
      result = true;
    }
    if (token.equalsIgnoreCase("SUBPARTITION")) {
      result = true;
    }
    if (token.equalsIgnoreCase("UNION")) {
      result = true;
    }
    if (token.equalsIgnoreCase("UNIQUE")) {
      result = true;
    }
    if (token.equalsIgnoreCase("UNPIVOT")) {
      result = true;
    }
    if (token.equalsIgnoreCase("UNTIL")) {
      result = true;
    }
    if (token.equalsIgnoreCase("UPDATE")) {
      result = true;
    }
    if (token.equalsIgnoreCase("USING")) {
      result = true;
    }
    if (token.equalsIgnoreCase("WHERE")) {
      result = true;
    }
    if (token.equalsIgnoreCase("WITH")) {
      result = true;
    }
    return result;
  }
  
  private String hasWhereOperator(String token) {
    String op = "";
    int loc = 0;
    loc = token.indexOf("=");
    if (loc > -1) {
      return "=";
    }
    loc = token.indexOf("<>");
    if (loc > -1) {
      return "<>";
    }
    loc = token.indexOf("<");
    if (loc > -1) {
      return "<";
    }
    loc = token.indexOf(">");
    if (loc > -1) {
      return "";
    }
    loc = token.indexOf("<=");
    if (loc > -1) {
      return "<=";
    }
    loc = token.indexOf(">=");
    if (loc > -1) {
      return ">=";
    }
    loc = token.toUpperCase().indexOf("LIKE");
    if (loc > -1) {
      return "LIKE";
    }
    loc = token.toUpperCase().indexOf("IN");
    if (loc > -1) {
      return "IN";
    }
    loc = token.toUpperCase().indexOf("BETWEEN");
    if (loc > -1) {
      return "BETWEEN";
    }
    loc = token.toUpperCase().indexOf("NOT");
    if (loc > -1) {
      return "NOT";
    }
    return op;
  }
  
  private boolean isNameSeparator(String item) {
    boolean result = false;
    if (item.equals(".")) {
      result = true;
    }
    return result;
  }
  
}
