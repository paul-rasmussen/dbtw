package com.dbtw.tools.parser.junit;

import static org.junit.Assert.*;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Vector;

import org.junit.Test;

import com.dbtw.models.ParsedRow;
import com.dbtw.tools.parser.DelimitedParser;
import com.dbtw.widgets.DebugLogger;
import com.dbtw.widgets.LogFile;
import com.dbtw.widgets.UserPrefs;

public class DelimitedParserTest {
  //Constants
  //Private variables
  private String dateMask1 = "MM/dd/yy";
  private String dateMask2 = "MM/dd/yy HH:mm:ss";
  private Vector<ParsedRow> answer1 = new Vector<ParsedRow>();
  //Public variables

  //Constructors
  public DelimitedParserTest() {
    init();
  }

  //Static methods
  //Public methods
  @Test
  public void testColHeaderBoolean() {
    DelimitedParser dp = new DelimitedParser("\t");
    assertEquals(dp.hasColumnHeaders(), true);
  }
  
  @Test
  public void testHeaderDelimiter() {
    DelimitedParser dp = new DelimitedParser("\t");
    assertEquals(dp.getHeaderDelimiter(),".");
  }
  
  @Test
  public void testDataDelimiter() {
    DelimitedParser dp = new DelimitedParser("\t");
    assertEquals(dp.getDataDelimiter(),"\t");
  }
  
  @Test
  public void testHasHeaders() {
    DelimitedParser dp = new DelimitedParser("\t");
    assertEquals(dp.hasHeaders(),false);
  }

  @Test
  public void testDateFormat() {
    DelimitedParser dp = new DelimitedParser(",");
    dp.setDateFormat("MM/dd/yyyy HH:mm:ss");
    assertEquals(dp.getDateFormat(), "MM/dd/yyyy HH:mm:ss");
  }
  
  @Test
  public void testTabDelimitedFile() {
    DelimitedParser dp = new DelimitedParser("\t");
    dp.parseFile(new File("D:\\SourceCode\\Test\\Files\\TabDelimitedTest1.txt"));
    Vector<ParsedRow> rows = dp.getData();
    assertEquals(rows.get(4).getItem(3), answer1.get(4).getItem(3));
  }
  
  //Private methods
  private void init() {
    SimpleDateFormat df = new SimpleDateFormat(dateMask1);
    ParsedRow row = new ParsedRow();
    try {
      row.addItem("Draw"); 
      row.addItem("Date"); 
      row.addItem("WB1"); 
      row.addItem("WB2"); 
      row.addItem("WB3"); 
      row.addItem("WB4"); 
      row.addItem("WB5"); 
      row.addItem("PB"); 
      row.addItem("PP");
      answer1.addElement(row);
      
      row = new ParsedRow();
      row.addItem(df.parse("05/11/2016"));
      row.addItem(new Integer(69));
      row.addItem(new Integer(32));
      row.addItem(new Integer(52));
      row.addItem(new Integer(66));
      row.addItem(new Integer(20));
      row.addItem(new Integer(23));
      row.addItem(new Integer(3));
      answer1.addElement(row);
      
      
      row = new ParsedRow();
      row.addItem(df.parse("05/07/2016")); 
      row.addItem(new Integer(25)); 
      row.addItem(new Integer(66)); 
      row.addItem(new Integer(44)); 
      row.addItem(new Integer(5)); 
      row.addItem(new Integer(26)); 
      row.addItem(new Integer(9)); 
      row.addItem(new Integer(2));
      answer1.addElement(row);
  
      row = new ParsedRow();
      row.addItem(df.parse("05/04/2016")); 
      row.addItem(new Integer(47));
      row.addItem(new Integer(69));
      row.addItem(new Integer(30));
      row.addItem(new Integer(66));
      row.addItem(new Integer(57));
      row.addItem(new Integer(03));
      row.addItem(new Integer(3));
      answer1.addElement(row);
  
      row = new ParsedRow();
      row.addItem(df.parse("04/30/2016"));
      row.addItem(new Integer(32));
      row.addItem(new Integer(16));
      row.addItem(new Integer(03));
      row.addItem(new Integer(34));
      row.addItem(new Integer(12));
      row.addItem(new Integer(14));
      row.addItem(new Integer(3));
      answer1.addElement(row);
  
      row = new ParsedRow();
      row.addItem(df.parse("04/27/2016"));
      row.addItem(new Integer(25));
      row.addItem(new Integer(39));
      row.addItem(new Integer(64));
      row.addItem(new Integer(02));
      row.addItem(new Integer(33));
      row.addItem(new Integer(17));
      row.addItem(new Integer(2));
      answer1.addElement(row);
      
      row = new ParsedRow();
      row.addItem(df.parse("04/23/2016"));
      row.addItem(new Integer(46));
      row.addItem(new Integer(62));
      row.addItem(new Integer(59));
      row.addItem(new Integer(35));
      row.addItem(new Integer(19));
      row.addItem(new Integer(13));
      row.addItem(new Integer(5));
      answer1.addElement(row);
      
      row = new ParsedRow();
      row.addItem(df.parse("04/20/2016"));
      row.addItem(new Integer(62));
      row.addItem(new Integer(30));
      row.addItem(new Integer(12));
      row.addItem(new Integer(25));
      row.addItem(new Integer(52));
      row.addItem(new Integer(8));
      row.addItem(new Integer(3));
      answer1.addElement(row);
      
      row = new ParsedRow();
      row.addItem(df.parse("04/16/2016"));
      row.addItem(new Integer(32));
      row.addItem(new Integer(03));
      row.addItem(new Integer(25));
      row.addItem(new Integer(51));
      row.addItem(new Integer(18));
      row.addItem(new Integer(03));
      row.addItem(new Integer(2));
      answer1.addElement(row);
      
      row = new ParsedRow();
      row.addItem(df.parse("04/13/2016"));
      row.addItem(new Integer(30));
      row.addItem(new Integer(35));
      row.addItem(new Integer(38));
      row.addItem(new Integer(33));
      row.addItem(new Integer(64));
      row.addItem(new Integer(22));
      row.addItem(new Integer(3));
      answer1.addElement(row);
      
      row = new ParsedRow();
      row.addItem(df.parse("04/09/2016"));
      row.addItem(new Integer(14));
      row.addItem(new Integer(23));
      row.addItem(new Integer(41));
      row.addItem(new Integer(61));
      row.addItem(new Integer(22));
      row.addItem(new Integer(9));
      row.addItem(new Integer(3));
      answer1.addElement(row);
      
      row = new ParsedRow();
      row.addItem(df.parse("04/06/2016"));
      row.addItem(new Integer(65));
      row.addItem(new Integer(28));
      row.addItem(new Integer(49));
      row.addItem(new Integer(60));
      row.addItem(new Integer(4));
      row.addItem(new Integer(25));
      row.addItem(new Integer(2));
      answer1.addElement(row);
      
      row = new ParsedRow();
      row.addItem(df.parse("04/02/2016"));
      row.addItem(new Integer(9));
      row.addItem(new Integer(61));
      row.addItem(new Integer(28));
      row.addItem(new Integer(40));
      row.addItem(new Integer(30));
      row.addItem(new Integer(3));
      row.addItem(new Integer(2));
      answer1.addElement(row);
      
      row = new ParsedRow();
      row.addItem(df.parse("03/30/2016"));
      row.addItem(new Integer(55));
      row.addItem(new Integer(24));
      row.addItem(new Integer(63));
      row.addItem(new Integer(53));
      row.addItem(new Integer(44));
      row.addItem(new Integer(19));
      row.addItem(new Integer(2));
      answer1.addElement(row);
      
      row = new ParsedRow();
      row.addItem(df.parse("03/26/2016"));
      row.addItem(new Integer(23));
      row.addItem(new Integer(42));
      row.addItem(new Integer(68));
      row.addItem(new Integer(52));
      row.addItem(new Integer(11));
      row.addItem(new Integer(6));
      row.addItem(new Integer(3));
      answer1.addElement(row);
      
      row = new ParsedRow();
      row.addItem(df.parse("03/23/2016"));
      row.addItem(new Integer(22));
      row.addItem(new Integer(15));
      row.addItem(new Integer(49));
      row.addItem(new Integer(5));
      row.addItem(new Integer(8));
      row.addItem(new Integer(25));
      row.addItem(new Integer(3));
      answer1.addElement(row);
      
      row = new ParsedRow();
      row.addItem(df.parse("03/19/2016"));
      row.addItem(new Integer(11));
      row.addItem(new Integer(60));
      row.addItem(new Integer(23));
      row.addItem(new Integer(54));
      row.addItem(new Integer(43));
      row.addItem(new Integer(3));
      row.addItem(new Integer(3));
      answer1.addElement(row);
      
      row = new ParsedRow();
      row.addItem(df.parse("03/16/2016"));
      row.addItem(new Integer(46));
      row.addItem(new Integer(50));
      row.addItem(new Integer(12));
      row.addItem(new Integer(13));
      row.addItem(new Integer(10));
      row.addItem(new Integer(21));
      row.addItem(new Integer(3));
      answer1.addElement(row);
      
      row = new ParsedRow();
      row.addItem(df.parse("03/12/2016"));
      row.addItem(new Integer(28));
      row.addItem(new Integer(11));
      row.addItem(new Integer(50));
      row.addItem(new Integer(57));
      row.addItem(new Integer(62));
      row.addItem(new Integer(23));
      row.addItem(new Integer(2));
      answer1.addElement(row);
      
      row = new ParsedRow();
      row.addItem(df.parse("03/09/2016"));
      row.addItem(new Integer(32));
      row.addItem(new Integer(34));
      row.addItem(new Integer(14));
      row.addItem(new Integer(23));
      row.addItem(new Integer(68));
      row.addItem(new Integer(3));
      row.addItem(new Integer(3));
      answer1.addElement(row);
      
      row = new ParsedRow();
      row.addItem(df.parse("03/05/2016"));
      row.addItem(new Integer(3));
      row.addItem(new Integer(34));
      row.addItem(new Integer(27));
      row.addItem(new Integer(59));
      row.addItem(new Integer(69));
      row.addItem(new Integer(19));
      row.addItem(new Integer(2));
      answer1.addElement(row);
    }
    catch (Exception e) {
      LogFile.getInstance().writeDump(e);
    }
  }

}
