package com.dbtw.widgets;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Vector;

import javax.swing.text.DateFormatter;

public class DateWidget {
	// Static variables
	// Constants
	public static final int ORACLE_FORMAT = 0;
	public static final int MYSQL_FORMAT = 1;
	public static final int US_FORMAT = 2;
	public static final int INTL_FORMAT = 3;
	// Private variables
	private Date date;
	private DateFormatter formatter;
	private DateFormat dfm;
	private boolean includeTime = false;

	// Public variables

	// Constructors
	public DateWidget() {
		init();
	}

	// Static methods
	// Public methods
	public String getFormattedDate(int format) {
		dfm = new SimpleDateFormat(dateFormat(format));
		return dateFormat(format);
	}
	
	public void setDate(String newDate) {
		try {
			date = dfm.parse(newDate);
		}
		catch (Exception e) {
			e.printStackTrace(System.out);
		}
	}
	
	// Private methods
	private void init() {
		date = new Date();
		formatter = new DateFormatter();
		dfm = DateFormat.getDateInstance();
	}

	private String dateFormat(int format) {
		String str = "";
		switch (format) {
			case (ORACLE_FORMAT): {
				if (includeTime) {
					str = "MM/DD/YYYY HH:MI:SS";
				} else {
					str = "MM/DD/YYYY";
				}
				break;
			}
			case (MYSQL_FORMAT): {
				if (includeTime) {
					str = "YYYY-DD-MM HH:MI:SS";
				} else {
					str = "YYYY-DD-MM";
				}
				break;
			}
			case (US_FORMAT): {
				if (includeTime) {
					str = "MM/DD/YYYY HH:MI:SS";
				} else {
					str = "MM/DD/YYYY";
				}
				break;
			}
			case (INTL_FORMAT): {
				if (includeTime) {
					str = "DD/MM/YYYY HH:MI:SS";
				} else {
					str = "DD/MM/YYYY";
				}
				break;
			}
		}
		return str;
	}
	

}
