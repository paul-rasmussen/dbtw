package com.dbtw.widgets;

import com.dbtw.widgets.LogFile;

public class AddressWidget {
  //Static variables
  public static final int US = 0;
  //Constants
  private final String WHOAMI = "AddressWidget";
  //Private variables
  private int indent = 0;
  private String number = "";
  private String street = "";
  private String line2 = "";
  private String line3 = "";
  private String city = "";
  private String state = "";
  private CountryWidget country;
  private PostalCodeWidget zip;
  //Public variables

  //Constructors
  public AddressWidget() {
  }

  public AddressWidget(String line1, String line2, String line3, String city, String state, String country, String zip) {
    init(line1, line2, line3, city, state, country, zip);
  }
  
  //Static methods
  //Public methods
  public String getAddress(int format) {
    return formatAddress(format);
  }
  
  public String getStreetNumber() {
    return number;
  }
  
  public String getStreet() {
    return street;
  }
  
  public String getLine2() {
    return line2;
  }
  
  public String getLine3() {
    return line3;
  }
  
  public String getCity() {
    return city;
  }
  
  public String getState() {
    return state;
  }
  
  public String getCountry() {
    return country.getName();
  }
  
  public String getPostalCode() {
    return zip.getCode();
  }
  
  //Private methods
  private void init(String line1, String line2, String line3, String city, String state, String country, String zip) {
    String errm = "";
    try {
      this.street = line1;
      this.line2 = line2;
      this.line3 = line3;
      this.city = city;
      this.state = state;
      this.country = new CountryWidget(country);
      this.zip = new PostalCodeWidget(zip);
    }
    catch (Exception e) {
      logError("init", errm, e);
    }
  }

  private String formatAddress(int format) {
    String txt = "";
    switch (format) {
      case US: {
        txt += number + " " + street + "\n";
        if (!line2.isEmpty()) {
          txt += line2 + "\n";
        }
        if (!line3.isEmpty()) {
          txt += line3 + "\n";
        }
        txt += city + ", " + state + "  " + zip.getCode();
        break;
      }
      default:
        break;
    }
    return txt;
  }
  
  private void logError(String method, String msg, Exception e) {
    LogFile log = LogFile.getInstance();
    log.writeLabel(WHOAMI, method);
    log.writeMsg(msg);
    log.writeDump(e);
    e.printStackTrace(System.out);
  }
}
