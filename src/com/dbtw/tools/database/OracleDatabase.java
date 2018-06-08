package com.dbtw.tools.database;

import java.sql.Connection;
import java.util.HashMap;
import java.util.Vector;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import org.apache.empire.data.DataType;
import org.apache.empire.db.DBCommandExpr;
import org.apache.empire.db.DBDatabase;
import org.apache.empire.db.DBReader;
import org.apache.empire.db.DBView;
import org.apache.empire.db.oracle.DBCommandOracle;
import org.apache.empire.db.oracle.DBDatabaseDriverOracle;

import com.dbtw.models.TableModel;

import com.dbtw.widgets.LogFile;
import com.dbtw.widgets.UserPrefs;

public class OracleDatabase extends DBDatabase {
	//Static variables
  private static OracleDatabase instance = null;
	//Constants
	//Private variables
  private final String WHOAMI = "ColumnModel";
	//Public variables
	public static class AllTabColumns extends DBView {
		public DBViewColumn OWNER;
		public DBViewColumn TABLE_NAME;
		public DBViewColumn COLUMN_NAME;
		public DBViewColumn DATA_TYPE;
		public DBViewColumn DATA_LENGTH;
		public DBViewColumn DATA_PRECISION;
		public DBViewColumn DATA_SCALE;
		public DBViewColumn DEFAULT;
		public DBViewColumn NULLABLE;

		public AllTabColumns(DBDatabase db) {
			super("ALL_TAB_COLUMNS", db);

			OWNER = addColumn("OWNER", DataType.TEXT);
			TABLE_NAME = addColumn("TABLE_NAME", DataType.TEXT);
			COLUMN_NAME = addColumn("COLUMN_NAME", DataType.TEXT);
			DATA_TYPE = addColumn("DATA_TYPE", DataType.TEXT);
			DATA_LENGTH = addColumn("DATA_LENGTH", DataType.TEXT);
			DATA_PRECISION = addColumn("DATA_PRECISION", DataType.TEXT);
			DATA_SCALE = addColumn("DATA_SCALE", DataType.TEXT);
			DEFAULT = addColumn("DEFAULT", DataType.TEXT);
			NULLABLE = addColumn("NULLABLE", DataType.TEXT);
		}

		@Override
		public DBCommandExpr createCommand() {
			return null;
		}
		
	}
	
	public static class DbaTabColumns extends DBView {
    public DBViewColumn OWNER;
    public DBViewColumn TABLE_NAME;
    public DBViewColumn COLUMN_NAME;
    public DBViewColumn DATA_TYPE;
    public DBViewColumn DATA_LENGTH;
    public DBViewColumn DATA_PRECISION;
    public DBViewColumn DATA_SCALE;
    public DBViewColumn DATA_DEFAULT;
    public DBViewColumn NULLABLE;

    public DbaTabColumns(DBDatabase db) {
      super("DBA_TAB_COLUMNS", db);

      OWNER = addColumn("OWNER", DataType.TEXT);
      TABLE_NAME = addColumn("TABLE_NAME", DataType.TEXT);
      COLUMN_NAME = addColumn("COLUMN_NAME", DataType.TEXT);
      DATA_TYPE = addColumn("DATA_TYPE", DataType.TEXT);
      DATA_LENGTH = addColumn("DATA_LENGTH", DataType.TEXT);
      DATA_PRECISION = addColumn("DATA_PRECISION", DataType.TEXT);
      DATA_SCALE = addColumn("DATA_SCALE", DataType.TEXT);
      DATA_DEFAULT = addColumn("DATA_DEFAULT", DataType.TEXT);
      NULLABLE = addColumn("NULLABLE", DataType.TEXT);
    }

    @Override
    public DBCommandExpr createCommand() {
      return null;
    }
    
	}
	
	public static class AllViews extends DBView {
	  public DBViewColumn OWNER;
	  public DBViewColumn VIEW_NAME;
	  public DBViewColumn TEXT_LENGTH;
	  public DBViewColumn TEXT;
	  
	  public AllViews(DBDatabase db) {
	    super("ALL_VIEWS", db);
	    
	    OWNER = addColumn("OWNER", DataType.TEXT);
	    VIEW_NAME = addColumn("VIEW_NAME", DataType.TEXT);
	    TEXT_LENGTH = addColumn("TEXT_LENGTH", DataType.INTEGER);
	    TEXT = addColumn("TEXT", DataType.TEXT);
	  }
	  
	  @Override
	  public DBCommandExpr createCommand() {
	    return null;
	  }
	}
	
	public static class AllIndexes extends DBView {
    public DBViewColumn OWNER;
    public DBViewColumn INDEX_NAME;
    public DBViewColumn INDEX_TYPE;
    public DBViewColumn TABLE_OWNER;
    public DBViewColumn TABLE_NAME;
    public DBViewColumn TABLE_TYPE;
    public DBViewColumn UNIQUENESS;
    public DBViewColumn JOIN_INDEX;
    public DBViewColumn SAMPLE_SIZE;
    public DBViewColumn LAST_ANALYZED;
	  
	  public AllIndexes(DBDatabase db) {
	    super("ALL_INDEXES", db);

	    OWNER = addColumn("OWNER", DataType.TEXT);
	    INDEX_NAME = addColumn("INDEX_NAME", DataType.TEXT);
	    INDEX_TYPE = addColumn("INDEX_TYPE", DataType.TEXT);
	    TABLE_OWNER = addColumn("TABLE_OWNER", DataType.TEXT);
	    TABLE_NAME = addColumn("TABLE_NAME", DataType.TEXT);
	    TABLE_TYPE = addColumn("TABLE_TYPE", DataType.TEXT);
	    UNIQUENESS = addColumn("UNIQUENESS", DataType.TEXT);
	    JOIN_INDEX = addColumn("JOIN_INDEX", DataType.TEXT);
	    SAMPLE_SIZE = addColumn("SAMPLE_SIZE", DataType.INTEGER);
	    LAST_ANALYZED = addColumn("LAST_ANALYZED", DataType.DATETIME);
	  }
	  
    @Override
    public DBCommandExpr createCommand() {
      return null;
    }
	}
	
	public static class AllIndColumns extends DBView {
    public DBViewColumn INDEX_OWNER;
    public DBViewColumn INDEX_NAME;
    public DBViewColumn TABLE_OWNER;
    public DBViewColumn TABLE_NAME;
    public DBViewColumn COLUMN_NAME;
    public DBViewColumn COLUMN_POSITION;
    public DBViewColumn DESCEND;
	  
	  public AllIndColumns(DBDatabase db) {
	    super("ALL_IND_COLUMNS", db);
	    
	    INDEX_OWNER = addColumn("INDEX_OWNER", DataType.TEXT);
	    INDEX_NAME = addColumn("INDEX_NAME", DataType.TEXT);
	    TABLE_OWNER = addColumn("TABLE_OWNER", DataType.TEXT);
	    TABLE_NAME = addColumn("TABLE_NAME", DataType.TEXT);
	    COLUMN_NAME = addColumn("COLUMN_NAME", DataType.TEXT);
	    COLUMN_POSITION = addColumn("COLUMN_POSITION", DataType.INTEGER);
	    DESCEND = addColumn("DESCEND", DataType.TEXT);
	  }
	  
    @Override
    public DBCommandExpr createCommand() {
      return null;
    }
	}
	
	public static class DbaTables extends DBView {
	  public DBViewColumn OWNER;
	  public DBViewColumn TABLE_NAME;
	  public DBViewColumn TABLESPACE_NAME;
	  public DBViewColumn STATUS;
	  
	  public DbaTables(DBDatabase db) {
	    super("DBA_TABLES", db);
	    
	    OWNER = addColumn("OWNER", DataType.TEXT);
	    TABLE_NAME = addColumn("TABLE_NAME", DataType.TEXT);
	    TABLESPACE_NAME = addColumn("TABLESPACE_NAME", DataType.TEXT);
	    STATUS = addColumn("STATUS", DataType.TEXT);
	  }

    @Override
    public DBCommandExpr createCommand() {
      return null;
    }
  }
	
	
	public static class DbaViews extends DBView {
	  public DBViewColumn OWNER;
	  public DBViewColumn VIEW_NAME;
	  public DBViewColumn TEXT;
	  public DBViewColumn VIEW_TYPE;
	  
	  public DbaViews (DBDatabase db) {
	    super("DBA_VIEWS", db);
	    
	    OWNER = addColumn("OWNER", DataType.TEXT);
	    VIEW_NAME = addColumn("VIEW_NAME", DataType.TEXT);
	    TEXT = addColumn("TEXT", DataType.TEXT);
	    VIEW_TYPE = addColumn("VIEW_TYPE", DataType.TEXT);
	  }

    @Override
    public DBCommandExpr createCommand() {
      return null;
    }
	}
	
	public static class DbaConstraints extends DBView {
	  public DBViewColumn OWNER;
	  public DBViewColumn CONSTRAINT_NAME;
	  public DBViewColumn CONSTRAINT_TYPE;
	  public DBViewColumn TABLE_NAME;
	  public DBViewColumn R_OWNER;
	  public DBViewColumn R_CONSTRAINT_NAME;
	  
	  public DbaConstraints (DBDatabase db) {
	    super("DBA_CONSTRAINTS", db);
	    
	    OWNER = addColumn("OWNER", DataType.TEXT);
	    CONSTRAINT_NAME = addColumn("CONSTRAINT_NAME", DataType.TEXT);
	    CONSTRAINT_TYPE = addColumn("CONSTRAINT_TYPE", DataType.TEXT);
	    TABLE_NAME = addColumn("TABLE_NAME", DataType.TEXT);
	    R_OWNER = addColumn("R_OWNER", DataType.TEXT);
	    R_CONSTRAINT_NAME = addColumn("R_CONSTRAINT_NAME", DataType.TEXT);
	  }
	  
    @Override
    public DBCommandExpr createCommand() {
      return null;
    }	  
	}
	
	public static class DbaConsColumns extends DBView {
	  public DBViewColumn OWNER;
	  public DBViewColumn CONSTRAINT_NAME;
	  public DBViewColumn TABLE_NAME;
	  public DBViewColumn COLUMN_NAME;
	  public DBViewColumn POSITION;
	  
	  public DbaConsColumns (DBDatabase db) {
	    super("DBA_CONS_COLUMNS", db);
	    
	    OWNER = addColumn("OWNER", DataType.TEXT);
	    CONSTRAINT_NAME = addColumn("CONSTRAINT_NAME", DataType.TEXT);
	    TABLE_NAME = addColumn("TABLE_NAME", DataType.TEXT);
	    COLUMN_NAME = addColumn("COLUMN_NAME", DataType.TEXT);
	    POSITION = addColumn("POSITION", DataType.TEXT);
	  }

    @Override
    public DBCommandExpr createCommand() {
      return null;
    }
  }
	
	public final AllTabColumns ALL_TAB_COLUMNS = new AllTabColumns(this);
	public final DbaTabColumns DBA_TAB_COLUMNS = new DbaTabColumns(this);
	public final AllViews ALL_VIEWS = new AllViews(this);
	public final AllIndexes ALL_INDEXES = new AllIndexes(this);
	public final AllIndColumns ALL_IND_COLUMNS = new AllIndColumns(this);
	public final DbaTables DBA_TABLES = new DbaTables(this);
	public final DbaViews DBA_VIEWS = new DbaViews(this);
	public final DbaConstraints DBA_CONSTRAINTS = new DbaConstraints(this);
	public final DbaConsColumns DBA_CONS_COLUMNS = new DbaConsColumns(this);

	//Constructors
	private OracleDatabase() {
	  super();
	}

	//Static methods
	public static OracleDatabase getInstance() {
	  try {
  	  if (instance == null) {
  	    instance = new OracleDatabase();
  	    instance.open(new DBDatabaseDriverOracle(), (Connection) UserPrefs.getInstance().getParameter("JDBCConnection"));
  	  }
	  }
	  catch (Exception e) {
	    JOptionPane.showMessageDialog(new JFrame(), "Problem opening database for use", "Application Error", JOptionPane.OK_OPTION);
	    e.printStackTrace(System.out);
	  }
	  return instance;
	}
	
	//Public methods
	public TableModel getReferencedTable(String schemaname, String tablename, String columnname) {
	  String errm = "";
    try {
      DBCommandOracle cmd = new DBCommandOracle(this);
      cmd.select(this.DBA_CONSTRAINTS.R_OWNER);
      cmd.select(this.DBA_CONSTRAINTS.R_CONSTRAINT_NAME);
      cmd.join(this.DBA_CONSTRAINTS.OWNER, this.DBA_CONS_COLUMNS.OWNER);
      cmd.join(this.DBA_CONSTRAINTS.CONSTRAINT_NAME, this.DBA_CONS_COLUMNS.CONSTRAINT_NAME);
      cmd.where(this.DBA_CONS_COLUMNS.OWNER.is(schemaname));
      cmd.where(this.DBA_CONS_COLUMNS.TABLE_NAME.is(tablename));
      cmd.where(this.DBA_CONS_COLUMNS.COLUMN_NAME.is(columnname));
      cmd.where(this.DBA_CONSTRAINTS.CONSTRAINT_TYPE.is("R"));
      DBReader rdr = new DBReader();
      rdr.open(cmd, (Connection) UserPrefs.getInstance().getParameter("JDBCConnection"));
      rdr.moveNext();
      String owner = rdr.getString(0);
      String cons = rdr.getString(1);
      rdr.close();
      cmd.clear();
      
      cmd.select(this.DBA_CONSTRAINTS.OWNER);
      cmd.select(this.DBA_CONSTRAINTS.TABLE_NAME);
      cmd.where(this.DBA_CONSTRAINTS.OWNER.is(owner));
      cmd.where(this.DBA_CONSTRAINTS.CONSTRAINT_NAME.is(cons));
      rdr = new DBReader();
      rdr.open(cmd, (Connection) UserPrefs.getInstance().getParameter("JDBCConnection"));
      rdr.moveNext();
      owner = rdr.getString(0);
      String table = rdr.getString(1);
      rdr.close();
      cmd.clear();
      return new TableModel(owner, table);
    }
    catch (Exception e) {
      logError("getReferencedTable", errm, e);
    }
    return null;
	}
	
	public Vector<String> getSchemaList() {
	  String errm = "";
    Vector<String> list = new Vector<String>();
    try {
      DBCommandOracle cmd = new DBCommandOracle(this);
      cmd.selectDistinct();
      cmd.select(this.DBA_TABLES.OWNER);
      cmd.where(this.DBA_TABLES.OWNER.notIn(UserPrefs.getInstance().getParameter(UserPrefs.ORACLE_SCHEMAS)));
      DBReader rdr = new DBReader();
      rdr.open(cmd, (Connection) UserPrefs.getInstance().getParameter("JDBCConnection"));
      while (rdr.moveNext()) {
        list.add(rdr.getString(0));
      }
      rdr.close();
      cmd.clear();
    }
    catch (Exception e) {
      logError("getSchemaList", errm, e);
    }
    return list;
	}
	
	public int getTableCount(String schema) {
	  String errm = "";
	  int cnt = 0;
    try {
      DBCommandOracle cmd = new DBCommandOracle(this);
      cmd.select(this.DBA_TABLES.count());
      cmd.where(this.DBA_TABLES.OWNER.is(schema));
      DBReader rdr = new DBReader();
      rdr.open(cmd, (Connection) UserPrefs.getInstance().getParameter("JDBCConnection"));
      while (rdr.moveNext()) {
        cnt = rdr.getInt(0);
      }
      rdr.close();
      cmd.clear();
    }
    catch (Exception e) {
      logError("getTableCount", errm, e);
    }
    return cnt;
	}
	
	//Private methods
  private void logError(String method, String msg, Exception e) {
    LogFile log = LogFile.getInstance();
    log.writeLabel(WHOAMI, method);
    log.writeMsg(msg);
    log.writeDump(e);
    e.printStackTrace(System.out);
  }
}
