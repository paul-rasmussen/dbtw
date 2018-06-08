package com.dbtw.tools.database;

public class DatabaseView implements Comparable{
  //Static variables
  //Constants
  //Private variables
  private String schema = "";
  private String name = "";
  private String def = "";
  //Public variables

  //Constructors
  public DatabaseView(String schemaname, String viewname) {
    init(schemaname, viewname);
  }

  //Static methods
  //Public methods
  @Override
  public int compareTo(Object o) {
    int result = 0;
    int result1 = 0;
    int result2 = 0;
    DatabaseTable t = (DatabaseTable) o;
    result1 = this.schema.compareTo(t.getSchema());
    result2 = this.name.compareTo(t.getName());
    if (result1 == 0) {
      result = result2;
    }
    else {
      result = result1;
    }
    return result;
  }
  
  public void setSchema(String schema) {
    this.schema = schema;
  }
  
  public String getSchema() {
    return schema;
  }
  
  public void setName(String name) {
    this.name = name;
  }
  
  public String getName() {
    return name;
  }
  
  public void setDefinition(String def) {
    this.def = def;
  }
  
  public String getDefinition() {
    return def;
  }
  
  //Private methods
  private void init(String schemaname, String viewname) {
    schema = schemaname;
    name = viewname;
  }
}
