package com.dbtw.tools.sql;

import static org.junit.Assert.*;

import java.io.File;

import org.junit.Test;

import com.dbtw.tools.parser.SqlParser;

public class UtilsSqlTestCase {
  //Static variables
  //Constants
  //Private variables
  String testSql = "select a.username, b.text,c.parsed, c.executed EXE from prasmussen.sql_users a, prasmussen.sql_capture b, prasmussen.sql_use c where c.user_id = a.id and c.capture_id = b.id group by a.username order by a.username";
  String select = "a.username, b.text,c.parsed, c.executed EXE";
  String from = "prasmussen.sql_users a, prasmussen.sql_capture b, prasmussen.sql_use c";
  String where = "c.user_id = a.id and c.capture_id = b.id";
  String group = "a.username";
  String order = "a.username";
  String tables = "prasmussen.sql_capture,prasmussen.sql_use,prasmussen.sql_users";
  String columns = "prasmussen.sql_capture(text),prasmussen.sql_use(parsed,executed),prasmussen.sql_users(username)";
  String testfile = "/media/prasmuss/CODE/testsql.sql";
  File tfile = new File(testfile);
  String fsql = testSql;
  //Public variables

  //Constructors

  //Static methods
  //Public methods
  @Test
  public void testParseFile() {
    SqlParser sp = new SqlParser();
    assertEquals("SqlParser Test parseFile():", fsql, sp.parseFile(tfile));
  }
  
  @Test
  public void testParseSelect() {
    SqlParser sp = new SqlParser();
    assertEquals("SqlParser Test parseSelect():", select, sp.parseSelect(testSql));
  }

  @Test
  public void testParseFrom() {
    SqlParser sp = new SqlParser();
    assertEquals("SqlParser Test parseFrom():", from, sp.parseFrom(testSql));
  }

  @Test
  public void testParseWhere() {
    SqlParser sp = new SqlParser();
    assertEquals("SqlParser Test parseWhere():", where, sp.parseWhere(testSql));
  }

  @Test
  public void testParseGroup() {
    SqlParser sp = new SqlParser();
    assertEquals("SqlParser Test parseGroup():", group, sp.parseGroup(testSql));
  }

  @Test
  public void testParseOrder() {
    SqlParser sp = new SqlParser();
    assertEquals("SqlParser Test parseOrder():", order, sp.parseOrder(testSql));
  }

  @Test
  public void testParseTables() {
    SqlParser sp = new SqlParser();
    assertEquals("SqlParser Test parseTables():", tables, sp.parseTables(testSql));
  }

  @Test
  public void testParseColumns() {
    SqlParser sp = new SqlParser();
    assertEquals("SqlParser Test parseColumns():", columns, sp.parseColumns(testSql));
  }

  //Private methods
}
