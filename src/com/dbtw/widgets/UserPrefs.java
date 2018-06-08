package com.dbtw.widgets;

import java.io.Serializable;
import java.util.Hashtable;
import java.util.Set;

/**
 *  This is a class to track user preferences for the application that runs as a Singleton, hence it is only used when
 *  necessary.
 *  
 *  This class will be serialized, so any variables that are not serializable, such as Connection, are not persisted.
 *  
 *  Copyright (C) 2014  DatabasesThatWork.com
 *
 *  This program is free software: you can redistribute it and/or modify
 *  it under the terms of the GNU Affero General Public License as
 *  published by the Free Software Foundation, either version 3 of the
 *  License, or (at your option) any later version.
 *
 *  This program is distributed in the hope that it will be useful,
 *  but WITHOUT ANY WARRANTY; without even the implied warranty of
 *  MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *  GNU Affero General Public License for more details.
 *  <http://www.gnu.org/licenses/>
 *  
 */
public class UserPrefs implements Serializable {
  private static final long serialVersionUID = 1L;
  //Static variables
  /** The Singleton instance of the class. */
	private static UserPrefs instance = null;
	//Constants
	
  //Private variables
	/** Array of Oracle system schemas to exclude from user based queries */
	protected Hashtable<String, Object> properties = new Hashtable<String, Object>();
	protected boolean isDebug = true;
	
	//Public variables

	//Constructors
  /** Default constructor */
	protected UserPrefs() {
	  init();
	}

	//Static methods
	public static UserPrefs getInstance() {
		if (instance == null) {
			instance = new UserPrefs();
		}
		return instance;
	}
	
	//Public methods
	public void setParameter(String name, Object value) {
	  properties.put(name, value);
	}
	
	public Object getParameter(String name) {
	  return properties.get(name);
	}
	
	public Set<String> getParameterKeys() {
	  return properties.keySet();
	}
	
	public void isDebug(boolean state) {
	  isDebug = state;
	}
	
	public boolean isDebug() {

	  return isDebug;
	}
	
	//Private methods
	private void init() {
	}
	
}
