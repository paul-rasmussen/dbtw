package com.dbtw.tools.parser;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.Vector;

import com.dbtw.models.HeaderSet;
import com.dbtw.models.ParsedRow;
import com.dbtw.widgets.DebugLogger;
import com.dbtw.widgets.LogFile;
import com.dbtw.widgets.UserPrefs;

public class DelimitedParser {
  //Constants
  //Private variables
  //Protected variables
  protected boolean hasColHeaders = true;
  protected boolean hasHeaders = false;
  protected String headerDelim = ".";
  protected boolean headerTrailingDelim = false;
  protected String dataDelim = ",";
  protected String dateFormat = "MM/dd/yy";
  protected SimpleDateFormat formatter = new SimpleDateFormat(dateFormat);
  protected Vector<HeaderSet> hdata = new Vector<HeaderSet>();
  protected Vector<ParsedRow> data = new Vector<ParsedRow>();
  
  //Public variables

  //Constructors
  public DelimitedParser(String data) {
    init(data, null, null, false);
  }
  
  public DelimitedParser(String data, String date) {
    init(data, date, null, false);
  }

  public DelimitedParser(String data, String date, String header) {
    init(data, date, header, false);
  }
  
  public DelimitedParser(String data, String date, String header, boolean trailing) {
    init(data, date, header, trailing);
  }

  //Static methods
  //Public methods
  public boolean hasColumnHeaders() {
    return hasColHeaders;
  }
  
  public void hasColumnHeaders(boolean hasColHdr) {
    hasColHeaders = hasColHdr;
  }
  
  public boolean hasHeaders() {
    return hasHeaders;
  }

  public void hasHeaders(boolean hasHeaders) {
    this.hasHeaders = hasHeaders;
  }

  public String getHeaderDelimiter() {
    return headerDelim;
  }

  public void setHeaderDelimiter(String headerDelim) {
    this.headerDelim = headerDelim;
  }

  public boolean hasHeaderTrailingDelimiter() {
    return headerTrailingDelim;
  }

  public void setHeaderTrailingDelimiter(boolean headerTrailingDelim) {
    this.headerTrailingDelim = headerTrailingDelim;
  }

  public String getDataDelimiter() {
    return dataDelim;
  }

  public void setDataDelimiter(String dataDelim) {
    this.dataDelim = dataDelim;
  }

  public String getDateFormat() {
    return dateFormat;
  }

  public void setDateFormat(String dateFormat) {
    this.dateFormat = dateFormat;
  }
  
  public void parseFile(File source) {
    parse(source);
  }
  
  public Vector<HeaderSet> getSections() {
    return hdata;
  }
  
  public Vector<ParsedRow> getData() {
    return data;
  }

  //Protected methods
  protected void init(String dDelim, String dtFmt, String hdr, boolean trailing) {
    dataDelim = dDelim;
    if ((dtFmt != null) && (dtFmt.length() > 0)) {
      dateFormat = dtFmt;
      formatter = new SimpleDateFormat(dateFormat);
    }
    if ((hdr != null) && (hdr.length() > 0)) {
      headerDelim = hdr;
      hasHeaders = true;
    }
    headerTrailingDelim = trailing;
  }

  protected void parse(File source) {
    boolean first = true;
    String header = "";
    Vector<String> lines = new Vector<String>();
    try {
      BufferedReader src = new BufferedReader(new FileReader(source));
      while (src.ready()) {
        lines.addElement(src.readLine().trim());
      }
      for (Iterator<String> i = lines.iterator(); i.hasNext(); ) {
        String line = i.next().trim();
        if (hasHeaders) {
          if (isHeader(line)) {
            if (!first) {
              HeaderSet hdr = new HeaderSet(header, data);
              hdata.addElement(hdr);
              data = new Vector<ParsedRow>();
            }
            header = extractHeader(line);
          }
          else {
            data.addElement(parseLine(line));
          }
        }
        else {
          data.addElement(parseLine(line));
        }
      }
    }
    catch (Exception e) {
      LogFile.getInstance().writeDump(e);
    }
    if (UserPrefs.getInstance().isDebug()) {
      if (hasHeaders) {
        LogFile.getInstance().writeMsg(hdata.toString());
      }
      else {
        LogFile.getInstance().writeMsg(data.toString());
      }
    }
  }
  
  protected boolean isHeader(String value) {
    if (value.startsWith(headerDelim)) {
      return true;
    }
    return false;
  }
  
  protected String extractHeader(String value) {
    String hdr = "";
    hdr = value.substring(value.indexOf(headerDelim), value.lastIndexOf(headerDelim));
    return hdr;
  }

  protected ParsedRow parseLine(String value) {
    ParsedRow items = new ParsedRow();
    try {
      String[] tokens = value.split(dataDelim);
      for (int i = 0; i < tokens.length; i++) {
        String token = tokens[i].trim();
        if (isDate(token)) {
          items.addItem(formatter.parse(token));
        }
        else {
          if (isInteger(token)) {
            items.addItem(new Integer(token));
          }
          else {
            if (isDouble(token)) {
              items.addItem(new Double(token));
            }
            else {
              items.addItem(token);
            }
          }
        }
      }
    }
    catch (Exception e) {
      LogFile.getInstance().writeDump(e);
    }
    return items;
  }
  
  protected boolean isDate(String token) {
    boolean result = true;
    try {
      Date date = formatter.parse(token);
    }
    catch (Exception e) {
      result = false;
    }
    return result;
  }
  protected boolean isInteger(String token) {
    boolean result = true;
    try {
      Integer value = Integer.parseInt(token);
    }
    catch (Exception e) {
      result = false;
    }
    return result;
  }

  protected boolean isDouble(String token) {
    boolean result = true;
    try {
      Double value = Double.parseDouble(token);
    }
    catch (Exception e) {
      result = false;
    }
    return result;
  }

  //Private methods

}
