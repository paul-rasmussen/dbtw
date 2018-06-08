package com.dbtw.widgets;

import java.util.Set;

public interface UserPrefsInterface {
  public void setParameter(String name, Object value);
  public Object getParameter(String name);
  public Set<String> getParameterList();
}
