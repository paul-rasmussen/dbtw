package com.dbtw.widgets;

public class PhoneWidget {
	//Static variables
	//Constants
	public static final int US_FORMAT1 = 0;
  public static final int US_FORMAT2 = 1;
  public static final int US_FORMAT3 = 2;
	public static final int INTL_FORMAT = 3;
	//Private variables
	private int format_code = US_FORMAT1;
	private int countryCode;
	private int areaCode;
	private int exchange;
	private int subscriber;
	
	//Public variables

	//Constructors
	public PhoneWidget() {
	}

	//Static methods
	//Public methods
	public void setNumber(String number) {
		countryCode = 1;
		parse(number);
	}
	
	public void setNumber(int countryCode, String number) {
		this.countryCode = countryCode;
		parse(number);
	}
	
	//Private methods
	private String format() {
	  String txt = "";
	  switch (format_code) {
	    case (US_FORMAT1): {
	      txt += "(" + areaCode + ") " + exchange + "-" + subscriber;
	      break;
	    }
      case (US_FORMAT2): {
        txt += areaCode + "-" + exchange + "-" + subscriber;
        break;
      }
      case (US_FORMAT3): {
        txt += areaCode + "." + exchange + "." + subscriber;
        break;
      }
	    case (INTL_FORMAT): {
	      break;
	    }
	  }
	  return txt;
	}
	
	private void parse(String number) {
	  if (countryCode == 1) {
  	  if (number.length() == 14) {
  	    areaCode = Integer.parseInt(number.substring(1, 3));
  	    exchange = Integer.parseInt(number.substring(6, 8));
  	    subscriber = Integer.parseInt(number.substring(10));
  	  }
      if (number.length() == 13) {
        areaCode = Integer.parseInt(number.substring(1, 3));
        exchange = Integer.parseInt(number.substring(5, 7));
        subscriber = Integer.parseInt(number.substring(9));
      }
      if (number.length() == 12) {
        areaCode = Integer.parseInt(number.substring(0, 2));
        exchange = Integer.parseInt(number.substring(4, 6));
        subscriber = Integer.parseInt(number.substring(8));
      }
      if (number.length() == 10) {
        areaCode = Integer.parseInt(number.substring(0, 2));
        exchange = Integer.parseInt(number.substring(3, 5));
        subscriber = Integer.parseInt(number.substring(6));
      }
      if (number.length() == 8) {
        areaCode = 0;
        exchange = Integer.parseInt(number.substring(0, 2));
        subscriber = Integer.parseInt(number.substring(4));
      }
  	  if (number.length() == 7) {
        areaCode = 0;
        exchange = Integer.parseInt(number.substring(0, 2));
        subscriber = Integer.parseInt(number.substring(3));
  	  }
	  }
	}
}
