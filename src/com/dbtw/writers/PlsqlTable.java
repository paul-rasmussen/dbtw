package com.dbtw.writers;

import java.sql.Connection;
import java.util.Iterator;
import java.util.TreeMap;

public class PlsqlTable {
	//Static variables
	//Constants
	//Private variables
  private Connection conn;
  private String sname;
  private String tname;
  private String hsql;
  private String bsql;
	//Public variables

	//Constructors
	public PlsqlTable(String schemaname, String tablename, Connection c) {
	  init(schemaname, tablename, c);
	}
	//Static methods
	//Public methods
	//Private methods
	private void init(String schemaname, String tablename, Connection c) {
	  conn = c;
	  sname = schemaname;
	  tname = tablename;
	}
	
	private void writePackageHeader() {
	  hsql = "create or replace package " + sname + "." + tname + "_API as";
	  bsql = "create or replace package body " + sname + "." + tname + "_API as";
	}
	
	private void writePackageFooter() {
	  hsql += "end " + tname + "_API;";
	  bsql += "end " + tname + "_API;";
	}
	
	private void writeBodyHeader(String cname) {
	  bsql += "  whoami varchar2(150);  --used to identify which function/procedure was the source of the error\n";
    bsql += "  debug boolean := false;  --used to turn debuggin on/off (change it here to run in debug)\n";
    bsql += "  logline number := 1;\n\n";
    bsql += "--Private functions/procedures";
    bsql += "  procedure write_to_log(msg varchar2) is\n";
    bsql += "  begin\n";
    bsql += "      DBMS_OUTPUT.PUT_LINE(logline || '   -----------------------------------------------------------------------------');\n";
    bsql += "      DBMS_OUTPUT.PUT_LINE(msg);\n";
    bsql += "      DBMS_OUTPUT.PUT_LINE(' ');\n";
    bsql += "      logline := logline + 1;\n";
    bsql += "  end;\n\n";
    bsql += "  function bool_to_string(val boolean) return varchar2 is\n";
    bsql += "      txt varchar2(5);\n";
    bsql += "    begin\n";
    bsql += "      if val then\n";
    bsql += "        txt := 'true';\n";
    bsql += "      else\n";
    bsql += "        txt := 'false';\n";
    bsql += "      end if;\n";
    bsql += "      return txt;\n";
    bsql += "    end bool_to_string;\n\n";
	}
	
	private void writeFindHeader(TreeMap<String, String> params, String returnType) {
    writeFindDeclaration(params, returnType);
	  hsql += ";\n";
	}
	
  private void writeLoadHeader(TreeMap<String, String> params, String returnType) {
    writeLoadDeclaration(params, returnType);
    hsql += ";\n";
  }
  
  private void writeMapHeader(TreeMap<String, String> params, String returnType) {
    writeMapDeclaration(params, returnType);
    hsql += ";\n";
  }
  
	private void writeFindBody(TreeMap<String, String> params, String returnType, TreeMap<String, String> cparams) {
	  writeFindDeclaration(params, returnType);
	  boolean first = true;
	  String psql = "";
    bsql += " is\n";
    bsql += "    cursor c_" + tname + " (";
    for (Iterator<String> p = cparams.keySet().iterator(); p.hasNext(); ) {
      String param = p.next();
      if (!first) {
        bsql += ", ";
        psql += "\n         and ";
      }
      bsql += "p" + param + " " + params.get(param);
      psql += param + " = p" + param;
      first = false;
    }
    bsql += ") is\n";
    bsql += "      select id\n";
    bsql += "        from " + sname + "." + tname + "\n";
    bsql += "       where " + psql + ";\n";
    bsql += "    o_id " + sname + "." + tname + ".id%TYPE := 0;\n";
    bsql += "  begin\n";
    bsql += "    open c_list(";
    first = true;
    for (Iterator<String> p = params.keySet().iterator(); p.hasNext(); ) {
      String param = p.next();
      if (!first) {
        bsql += ",";
      }
      bsql += param;
    }
    bsql += ");\n";
    bsql += "    loop\n";
    bsql += "      fetch c_list into o_id;\n";
    bsql += "      exit when c_list%NOTFOUND;\n";
    bsql += "    end loop;\n";
    bsql += "    close c_list;\n";
    bsql += "    return o_id;\n;";
    bsql += "  end find" + tname.toLowerCase() + "_id;\n\n";
	}
	
	private void writeLoadBody(TreeMap<String, String> params, String returnType, TreeMap<String, String> valMap) {
	  String bsql2 = "values (upper(''' || ";
	  boolean first = true;
	  writeLoadDeclaration(params, returnType);
    bsql += "    dsql varchar2(2000);\n";
    bsql += "  begin\n";
    bsql += "    dsql := 'insert into " + sname + "." + tname + "(";
    for (Iterator<String> c = valMap.keySet().iterator(); c.hasNext(); ) {
      String col = c.next();
      if (!first) {
        bsql += ",";
        bsql2 += ",";
      }
      bsql += col;
      bsql2 += "upper(''' || " + valMap.get(col) + " || ''')";
      first = false;
    }
    bsql += ") " + bsql2 + ");\n";
    bsql += "    execute immediate dsql;\n";
    bsql += "    execute immediate 'commit';\n";
    bsql += "  end load" + tname + ";";
	}

	private void writeMapBody(TreeMap<String, String> params, String returnType, TreeMap<String, String> valMap) {
	  writeMapDeclaration(params, returnType);
	  boolean first = true;
	  String bsql2 = "values(";
    bsql += "    dsql varchar2(2000);\n";
    bsql += "  begin\n";
    bsql += "    dsql := 'insert into " + sname + "." + tname + " (";
    for (Iterator<String> c = valMap.keySet().iterator(); c.hasNext(); ) {
      String col = c.next();
      if (!first) {
        bsql += ",";
        bsql2 += ",";
      }
      bsql += col;
      bsql2 += valMap.get(col);
      first = false;
    }
    bsql += ") " + bsql2 + ");\n";
    bsql += "    execute immediate dsql;\n";
    bsql += "    execute immediate 'commit';\n";
    bsql += "  end map" + tname + ";";
  }
	
	private void writeDeclaration(TreeMap<String, String> params, String returnType) {
    boolean first = true;
    for (Iterator<String> p = params.keySet().iterator(); p.hasNext(); ) {
      String n = p.next();
      if (!first) {
        bsql += ", ";
      }
      bsql += params.get(n) + " " + n;
    }
    bsql += ")";
    if (returnType.length() > 0) {
      bsql += " return " + returnType;
    }
	}
	
	private void writeName(String tname, String returnType) {
    if (returnType.length() > 0) {
      bsql += "  function " + tname.toLowerCase() + "_id(";
    }
    else {
      bsql += "  procedure " + tname.toLowerCase() + "_id(";
    }
	}
	
  private void writeMap(TreeMap<String, String> params, String returnType) {
    writeName("map" + tname, returnType);
    writeDeclaration(params, returnType);
  }
  
	private void writeFindDeclaration(TreeMap<String, String> params, String returnType) {
    writeName("find" + tname, returnType);
    writeDeclaration(params, returnType);
	}
	
	private void writeLoadDeclaration(TreeMap<String, String> params, String returnType) {
	  writeName("load" + tname, returnType);
	  writeDeclaration(params, returnType);
	}
	
  private void writeMapDeclaration(TreeMap<String, String> params, String returnType) {
    writeName("map" + tname, returnType);
    writeDeclaration(params, returnType);
  }
	
}
