package com.dbtw.tools.parser;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.json.simple.parser.ContainerFactory;
import org.json.simple.parser.JSONParser;

import com.dbtw.widgets.DebugLogger;
import com.dbtw.widgets.LogFile;
import com.dbtw.widgets.StringWidget;

public class JsonParser {
  //Static variables
  //Constants
  private final String WHOAMI = "JsonParser";
  //Private variables
  private int indent = 0;
  protected Map data;
  protected HashMap<String, HashMap<String, HashMap<String, String>>> struct = new HashMap<String, HashMap<String, HashMap<String, String>>>(); 
  //Public variables

  //Constructors
  public JsonParser(File src) {
    init(src);
  }

  //Static methods
  //Public methods
  public HashMap<String, HashMap<String, HashMap<String, String>>> getData() {
    return struct;
  }
  
  //Private methods
  private void init(File src) {
    String errm = "Initializing JsonParser";
    try {
      errm = "Creating a container factory";
      ContainerFactory containerFactory = new ContainerFactory() {
        public List creatArrayContainer() {
          return new LinkedList();
        }
        
        public Map createObjectContainer() {
          return new LinkedHashMap();
        }
      };
      
      errm = "Creating an instance of JSONParser";
      JSONParser parser = new JSONParser();
      errm = "Parsing " + src.getName() + " using the container factory";
      data = (Map) parser.parse(readFile(src), containerFactory);
    }
    catch (Exception e) {
      logError("init", errm, e);
    }
    errm = "Leaving init";
  }

  private void loadData() {
    String errm = "";
    try {
      
    }
    catch (Exception e) {
      logError("loadData", errm, e);
    }
  }
  
  private String readFile(File src) {
    String errm = "Reading file";
    String txt = "";
    try {
      errm = "Opening buffered reader for " + src.getName();
      BufferedReader rdr = new BufferedReader(new FileReader(src));
      while (rdr.ready()) {
        txt += rdr.readLine().replace("\n", "");
      }
      rdr.close();
    }
    catch (Exception e) {
      logError("readFile", errm, e);
    }
    errm = "Returning text";
    return txt;
  }
  
  private void debugData() {
    DebugLogger.logMsg("---------------------------------------");
    DebugLogger.logMsg("JsonParser.debugData()");
    String msg = "Data in JsonParser:";
    DebugLogger.logMsg(msg);
    msg = "";
    for (Iterator<String> t = struct.keySet().iterator(); t.hasNext(); ) {
      String table = t.next();
      HashMap<String, HashMap<String, String>> col = struct.get(table);
      for (Iterator<String> c = col.keySet().iterator(); c.hasNext(); ) {
        String column = c.next();
        msg = StringWidget.lpad(table, 15) + StringWidget.lpad(column, 15);
        HashMap<String, String> def = col.get(column);
        for (Iterator<String> d = def.keySet().iterator(); d.hasNext(); ) {
          String key = d.next();
          msg += StringWidget.lpad(def.get(key), 15);
        }
        DebugLogger.logMsg(msg);
      }
    }
    DebugLogger.logMsg("---------------------------------------");
  }
  
  private void logError(String method, String msg, Exception e) {
    LogFile log = LogFile.getInstance();
    log.writeLabel(WHOAMI, method);
    log.writeMsg(msg);
    log.writeDump(e);
    e.printStackTrace(System.out);
  }
}
