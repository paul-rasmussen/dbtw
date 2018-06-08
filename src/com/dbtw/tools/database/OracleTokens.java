package com.dbtw.tools.database;

public class OracleTokens extends DbTokens {
  //Static variables
  //Constants
  //Private variables
  //Public variables

  //Constructors
  public OracleTokens() {
    super();
    init();
  }

  //Static methods
  public static boolean isDbKey(String token) {
    OracleTokens dt = new OracleTokens();
    return dt.isDbKeyword(token);
  }

  public static String hasDbOperator(String token) {
    OracleTokens dt = new OracleTokens();
    return dt.hasWhereOperator(token);
  }
  
  public static boolean isDbSeparator(String item) {
    OracleTokens dt = new OracleTokens();
    return dt.isDbNameSeparator(item);
  }
  
  public static boolean isDbFunct(String token) {
    OracleTokens dt = new OracleTokens();
    return dt.isDbFunction(token);
  }
  
  //Public methods
  @Override
  public boolean isDbKeyword(String token) {
    return isKeyword(token);
  }
  
  @Override
  public String hasDbWhereOperator(String token) {
    return hasWhereOperator(token);
  }
  
  @Override
  public boolean isDbNameSeparator(String item) {
    return isNameSeparator(item);
  }
  
  public boolean isDbFunction(String token) {
    return isFunction(token);
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

  private boolean isFunction(String item) {
    boolean result = false;
    if (item.equalsIgnoreCase("ABS")) {
      result = true;
    }
    if (item.equalsIgnoreCase("ACOS")) {
      result = true;
    }
    if (item.equalsIgnoreCase("ASIN")) {
      result = true;
    }
    if (item.equalsIgnoreCase("ATAN")) {
      result = true;
    }
    if (item.equalsIgnoreCase("ATAN2")) {
      result = true;
    }
    if (item.equalsIgnoreCase("BITAND")) {
      result = true;
    }
    if (item.equalsIgnoreCase("CEIL")) {
      result = true;
    }
    if (item.equalsIgnoreCase("COS")) {
      result = true;
    }
    if (item.equalsIgnoreCase("COSH")) {
      result = true;
    }
    if (item.equalsIgnoreCase("EXP")) {
      result = true;
    }
    if (item.equalsIgnoreCase("FLOOR")) {
      result = true;
    }
    if (item.equalsIgnoreCase("LN")) {
      result = true;
    }
    if (item.equalsIgnoreCase("LOG")) {
      result = true;
    }
    if (item.equalsIgnoreCase("MOD")) {
      result = true;
    }
    if (item.equalsIgnoreCase("NANVL")) {
      result = true;
    }
    if (item.equalsIgnoreCase("POWER")) {
      result = true;
    }
    if (item.equalsIgnoreCase("REMAINDER")) {
      result = true;
    }
    if (item.equalsIgnoreCase("ROUND")) {
      result = true;
    }
    if (item.equalsIgnoreCase("SIGN")) {
      result = true;
    }
    if (item.equalsIgnoreCase("SIN")) {
      result = true;
    }
    if (item.equalsIgnoreCase("SINH")) {
      result = true;
    }
    if (item.equalsIgnoreCase("SQRT")) {
      result = true;
    }
    if (item.equalsIgnoreCase("TAN")) {
      result = true;
    }
    if (item.equalsIgnoreCase("TANH")) {
      result = true;
    }
    if (item.equalsIgnoreCase("TRUNC")) {
      result = true;
    }
    if (item.equalsIgnoreCase("WIDTH_BUCKET")) {
      result = true;
    }
    if (item.equalsIgnoreCase("CHR")) {
      result = true;
    }
    if (item.equalsIgnoreCase("CONCAT")) {
      result = true;
    }
    if (item.equalsIgnoreCase("INITCAP")) {
      result = true;
    }
    if (item.equalsIgnoreCase("LOWER")) {
      result = true;
    }
    if (item.equalsIgnoreCase("LPAD")) {
      result = true;
    }
    if (item.equalsIgnoreCase("LTRIM")) {
      result = true;
    }
    if (item.equalsIgnoreCase("NCHR")) {
      result = true;
    }
    if (item.equalsIgnoreCase("NLS_INITCAP")) {
      result = true;
    }
    if (item.equalsIgnoreCase("NLS_LOWER")) {
      result = true;
    }
    if (item.equalsIgnoreCase("NLS_UPPER")) {
      result = true;
    }
    if (item.equalsIgnoreCase("NLSSORT")) {
      result = true;
    }
    if (item.equalsIgnoreCase("REGEXP_REPLACE")) {
      result = true;
    }
    if (item.equalsIgnoreCase("REGEXP_SUBSTR")) {
      result = true;
    }
    if (item.equalsIgnoreCase("REPLACE")) {
      result = true;
    }
    if (item.equalsIgnoreCase("RPAD")) {
      result = true;
    }
    if (item.equalsIgnoreCase("RTRIM")) {
      result = true;
    }
    if (item.equalsIgnoreCase("SOUNDEX")) {
      result = true;
    }
    if (item.equalsIgnoreCase("SUBSTR")) {
      result = true;
    }
    if (item.equalsIgnoreCase("TRANSLATE")) {
      result = true;
    }
    if (item.equalsIgnoreCase("TRIM")) {
      result = true;
    }
    if (item.equalsIgnoreCase("UPPER")) {
      result = true;
    }
    if (item.equalsIgnoreCase("ASCII")) {
      result = true;
    }
    if (item.equalsIgnoreCase("INSTR")) {
      result = true;
    }
    if (item.equalsIgnoreCase("LENGTH")) {
      result = true;
    }
    if (item.equalsIgnoreCase("REGEXP_COUNT")) {
      result = true;
    }
    if (item.equalsIgnoreCase("REGEXP_INSTR")) {
      result = true;
    }
    if (item.equalsIgnoreCase("ADD_MONTHS")) {
      result = true;
    }
    if (item.equalsIgnoreCase("EXTRACT")) {
      result = true;
    }
    if (item.equalsIgnoreCase("FROM_TX")) {
      result = true;
    }
    if (item.equalsIgnoreCase("LAST_DAY")) {
      result = true;
    }
    if (item.equalsIgnoreCase("MONTHS_BETWEEN")) {
      result = true;
    }
    if (item.equalsIgnoreCase("NEW_TIME")) {
      result = true;
    }
    if (item.equalsIgnoreCase("NEXT_DAY")) {
      result = true;
    }
    if (item.equalsIgnoreCase("NUMTODSINTERVAL")) {
      result = true;
    }
    if (item.equalsIgnoreCase("NUMTOYMINTERVAL")) {
      result = true;
    }
    if (item.equalsIgnoreCase("ORA_DST_AFFECTED")) {
      result = true;
    }
    if (item.equalsIgnoreCase("ORA_DST_CONVERT")) {
      result = true;
    }
    if (item.equalsIgnoreCase("ORA_DST_ERROR")) {
      result = true;
    }
    if (item.equalsIgnoreCase("SYS_EXTRACT_UTC")) {
      result = true;
    }
    if (item.equalsIgnoreCase("TO_CHAR")) {
      result = true;
    }
    if (item.equalsIgnoreCase("TO_DSINTERVAL")) {
      result = true;
    }
    if (item.equalsIgnoreCase("TO_TIMESTAMP")) {
      result = true;
    }
    if (item.equalsIgnoreCase("TO_TIMESTAMP_TZ")) {
      result = true;
    }
    if (item.equalsIgnoreCase("TO_YMINTERVAL")) {
      result = true;
    }
    if (item.equalsIgnoreCase("TZ_OFFSET")) {
      result = true;
    }
    if (item.equalsIgnoreCase("GREATEST")) {
      result = true;
    }
    if (item.equalsIgnoreCase("LEAST")) {
      result = true;
    }
    if (item.equalsIgnoreCase("ASCIISTR")) {
      result = true;
    }
    if (item.equalsIgnoreCase("BIN_TO_NUM")) {
      result = true;
    }
    if (item.equalsIgnoreCase("CAST")) {
      result = true;
    }
    if (item.equalsIgnoreCase("CHARTOROWID")) {
      result = true;
    }
    if (item.equalsIgnoreCase("COMPOSE")) {
      result = true;
    }
    if (item.equalsIgnoreCase("CONVERT")) {
      result = true;
    }
    if (item.equalsIgnoreCase("DECOMPOSE")) {
      result = true;
    }
    if (item.equalsIgnoreCase("HEXTORAW")) {
      result = true;
    }
    if (item.equalsIgnoreCase("NUMTODSINTERVAL")) {
      result = true;
    }
    if (item.equalsIgnoreCase("NUMTOYMINTERVAL")) {
      result = true;
    }
    if (item.equalsIgnoreCase("RAWTOHEX")) {
      result = true;
    }
    if (item.equalsIgnoreCase("RAWTONHEX")) {
      result = true;
    }
    if (item.equalsIgnoreCase("ROWIDTOCHAR")) {
      result = true;
    }
    if (item.equalsIgnoreCase("ROWIDTONCHAR")) {
      result = true;
    }
    if (item.equalsIgnoreCase("SCN_TO_TIMESTAMP")) {
      result = true;
    }
    if (item.equalsIgnoreCase("TIMESTAMP_TO_SCN")) {
      result = true;
    }
    if (item.equalsIgnoreCase("TO_BINARY_DOUBLE")) {
      result = true;
    }
    if (item.equalsIgnoreCase("TO_BINARY_FLOAT")) {
      result = true;
    }
    if (item.equalsIgnoreCase("TO_BLOB")) {
      result = true;
    }
    if (item.equalsIgnoreCase("TO_CLOB")) {
      result = true;
    }
    if (item.equalsIgnoreCase("TO_DATE")) {
      result = true;
    }
    if (item.equalsIgnoreCase("TO_DSINTERVAL")) {
      result = true;
    }
    if (item.equalsIgnoreCase("TO_LOB")) {
      result = true;
    }
    if (item.equalsIgnoreCase("TO_MULTI_BYTE")) {
      result = true;
    }
    if (item.equalsIgnoreCase("TO_NCHAR")) {
      result = true;
    }
    if (item.equalsIgnoreCase("TO_NCLOB")) {
      result = true;
    }
    if (item.equalsIgnoreCase("TO_NUMBER")) {
      result = true;
    }
    if (item.equalsIgnoreCase("TO_SINGLE_BYTE")) {
      result = true;
    }
    if (item.equalsIgnoreCase("TREAT")) {
      result = true;
    }
    if (item.equalsIgnoreCase("UNISTR")) {
      result = true;
    }
    if (item.equalsIgnoreCase("BFILENAME")) {
      result = true;
    }
    if (item.equalsIgnoreCase("EMPTY_BLOB")) {
      result = true;
    }
    if (item.equalsIgnoreCase("EMPTY_CLOB")) {
      result = true;
    }
    if (item.equalsIgnoreCase("CARDINALITY")) {
      result = true;
    }
    if (item.equalsIgnoreCase("COLLECT")) {
      result = true;
    }
    if (item.equalsIgnoreCase("POWERMULTISET")) {
      result = true;
    }
    if (item.equalsIgnoreCase("POWERMULTISET_BY_CARDINALITY")) {
      result = true;
    }
    if (item.equalsIgnoreCase("SET")) {
      result = true;
    }
    if (item.equalsIgnoreCase("SYS_CONNECT_BY_PATH")) {
      result = true;
    }
    if (item.equalsIgnoreCase("CLUSTER_DETAILS")) {
      result = true;
    }
    if (item.equalsIgnoreCase("CLUSTER_DISTANCE")) {
      result = true;
    }
    if (item.equalsIgnoreCase("CLUSTER_ID")) {
      result = true;
    }
    if (item.equalsIgnoreCase("CLUSTER_PROBABILITY")) {
      result = true;
    }
    if (item.equalsIgnoreCase("CLUSTER_SET")) {
      result = true;
    }
    if (item.equalsIgnoreCase("FEATURE_DETAILS")) {
      result = true;
    }
    if (item.equalsIgnoreCase("FEATURE_ID")) {
      result = true;
    }
    if (item.equalsIgnoreCase("FEATURE_SET")) {
      result = true;
    }
    if (item.equalsIgnoreCase("FEATURE_VALUE")) {
      result = true;
    }
    if (item.equalsIgnoreCase("PREDICTION")) {
      result = true;
    }
    if (item.equalsIgnoreCase("PREDICTION_BOUNDS")) {
      result = true;
    }
    if (item.equalsIgnoreCase("PREDICTION_COST")) {
      result = true;
    }
    if (item.equalsIgnoreCase("PREDICTION_DETAILS")) {
      result = true;
    }
    if (item.equalsIgnoreCase("PREDICTION_PROBABILITY")) {
      result = true;
    }
    if (item.equalsIgnoreCase("PREDICTION_SET")) {
      result = true;
    }
    if (item.equalsIgnoreCase("DECODE")) {
      result = true;
    }
    if (item.equalsIgnoreCase("DUMP")) {
      result = true;
    }
    if (item.equalsIgnoreCase("ORA_HASH")) {
      result = true;
    }
    if (item.equalsIgnoreCase("STANDARD_HASH")) {
      result = true;
    }
    if (item.equalsIgnoreCase("VSIZE")) {
      result = true;
    }
    if (item.equalsIgnoreCase("COALESCE")) {
      result = true;
    }
    if (item.equalsIgnoreCase("LNNVL")) {
      result = true;
    }
    if (item.equalsIgnoreCase("NANVL")) {
      result = true;
    }
    if (item.equalsIgnoreCase("NULLIF")) {
      result = true;
    }
    if (item.equalsIgnoreCase("NVL")) {
      result = true;
    }
    if (item.equalsIgnoreCase("NVL2")) {
      result = true;
    }
    if (item.equalsIgnoreCase("")) {
      result = true;
    }
    if (item.equalsIgnoreCase("")) {
      result = true;
    }
    if (item.equalsIgnoreCase("")) {
      result = true;
    }
    if (item.equalsIgnoreCase("")) {
      result = true;
    }
    if (item.equalsIgnoreCase("")) {
      result = true;
    }
    if (item.equalsIgnoreCase("")) {
      result = true;
    }
    if (item.equalsIgnoreCase("")) {
      result = true;
    }
    if (item.equalsIgnoreCase("")) {
      result = true;
    }
    if (item.equalsIgnoreCase("")) {
      result = true;
    }
    if (item.equalsIgnoreCase("")) {
      result = true;
    }
    if (item.equalsIgnoreCase("")) {
      result = true;
    }
    if (item.equalsIgnoreCase("")) {
      result = true;
    }
    if (item.equalsIgnoreCase("")) {
      result = true;
    }
    if (item.equalsIgnoreCase("")) {
      result = true;
    }
    if (item.equalsIgnoreCase("")) {
      result = true;
    }
    if (item.equalsIgnoreCase("")) {
      result = true;
    }
    if (item.equalsIgnoreCase("")) {
      result = true;
    }
    if (item.equalsIgnoreCase("")) {
      result = true;
    }
    if (item.equalsIgnoreCase("")) {
      result = true;
    }
    if (item.equalsIgnoreCase("")) {
      result = true;
    }
    if (item.equalsIgnoreCase("")) {
      result = true;
    }
    if (item.equalsIgnoreCase("")) {
      result = true;
    }
    if (item.equalsIgnoreCase("")) {
      result = true;
    }
    if (item.equalsIgnoreCase("")) {
      result = true;
    }
    if (item.equalsIgnoreCase("")) {
      result = true;
    }
    if (item.equalsIgnoreCase("")) {
      result = true;
    }
    if (item.equalsIgnoreCase("")) {
      result = true;
    }
    if (item.equalsIgnoreCase("")) {
      result = true;
    }
    if (item.equalsIgnoreCase("")) {
      result = true;
    }
    if (item.equalsIgnoreCase("")) {
      result = true;
    }
    if (item.equalsIgnoreCase("")) {
      result = true;
    }
    if (item.equalsIgnoreCase("")) {
      result = true;
    }
    if (item.equalsIgnoreCase("")) {
      result = true;
    }
    if (item.equalsIgnoreCase("")) {
      result = true;
    }
    if (item.equalsIgnoreCase("")) {
      result = true;
    }
    if (item.equalsIgnoreCase("")) {
      result = true;
    }
    if (item.equalsIgnoreCase("")) {
      result = true;
    }
    if (item.equalsIgnoreCase("")) {
      result = true;
    }
    if (item.equalsIgnoreCase("")) {
      result = true;
    }
    if (item.equalsIgnoreCase("")) {
      result = true;
    }
    if (item.equalsIgnoreCase("")) {
      result = true;
    }
    return result;
  }
}
