package com.dbtw.widgets;

public class StringWidget {
	//Static variables
	//Constants
	//Private variables
	//Public variables

	//Constructors
	public StringWidget() {
	}

	//Static methods
	public static String lpad(String txt, int size) {
		StringWidget me = new StringWidget();
		return me.leftpad(txt, size);
	}
	
	public static String rpad(String txt, int size) {
		StringWidget me = new StringWidget();
		return me.rightpad(txt, size);
	}
	
	public static String clean(String txt) {
		StringWidget me = new StringWidget();
		return me.cleanString(txt);
	}
	
	public static String ltrim(String txt, int size) {
		StringWidget me = new StringWidget();
		return me.lefttrim(txt, size);
	}
	
	public static String rtrim(String txt, int size) {
		StringWidget me = new StringWidget();
		return me.righttrim(txt, size);
	}
	
	public static String indent(String txt, int size) {
	  StringWidget me = new StringWidget();
	  return me.indentString(txt, size);
	}
	
	public static String treeIndent(String txt, int size, int indentSize) {
    StringWidget me = new StringWidget();
	  return me.treeIndentString(txt, size, indentSize);
	}
	
	public static String getCamelCase(String txt) {
	  StringWidget me = new StringWidget();
	  return me.camelCase(txt);
	}
	
  public static String getSplitWords(String txt) {
    StringWidget me = new StringWidget();
    return me.splitWords(txt);
  }
  
	public static String getToken(String txt, String delimiter, String textDelimiter) {
    StringWidget me = new StringWidget();
	  return me.nextToken(txt, delimiter, textDelimiter);
	}
	
	//Public methods
	//Private methods
	private String cleanString(String src) {
		String tgt = "";
		for (int i = 0; i < src.length(); i++) {
			if (Character.getType(src.charAt(i)) == Character.LETTER_NUMBER) {
				tgt += src.charAt(i);
			}
		}
		return tgt;
	}
	
	private String leftpad(String src, int size) {
		String tgt = "";
		if (src.length() < size) {
			for (int i = 0; i < (size-src.length()); i++) {
				tgt += " ";
			}
			tgt += src;
		}
		else {
			tgt = src.substring(0, size);
		}
		return tgt;
	}
	
	private String rightpad(String src, int size) {
		String tgt = "";
		if (src.length() < size) {
			tgt += src;
			for (int i = 0; i < (size-src.length()); i++) {
				tgt += " ";
			}
		}
		else {
			tgt = src.substring(0, size);
		}
		return tgt;
	}
	
	private String lefttrim(String src, int size) {
		int start = src.length() - size;
		return src.substring(start);
	}
	
	private String righttrim(String src, int size) {
		return src.substring(0, (size - 1));
	}
	
	private String indentString(String src, int size) {
	  String txt = "";
	  for (int i = 0; i < size; i++) {
	    txt += " ";
	  }
	  txt += src;
	  return txt;
	}

	private String treeIndentString(String src, int size, int indentSize) {
	  String txt = "";
	  for (int i = 0; i < size; i++) {
	    if ((i > indentSize) && (i/indentSize == 0)) {
	      txt += new String(new char[]{124});
	    }
	    else {
	      txt += " ";
	    }
	  }
	  txt += src;
	  return txt;
	}
	
	private String camelCase(String src) {
	  String txt = "";
	  String token = "";
	  String lsrc = src.toLowerCase();
	  while (lsrc.indexOf("_") != -1) {
	    token = lsrc.substring(0, lsrc.indexOf("_"));
	    txt += token.substring(0, 1).toUpperCase();
	    txt += token.substring(1);
	    lsrc = lsrc.substring(lsrc.indexOf("_") + 1);
	  }
    txt += lsrc.substring(0, 1).toUpperCase();
    txt += lsrc.substring(1);
	  return txt;
	}
	
	private String splitWords(String src) {
    String txt = "";
    String token = "";
    String lsrc = src.toLowerCase();
    while (lsrc.indexOf("_") != -1) {
      token = lsrc.substring(0, lsrc.indexOf("_"));
      txt += token.substring(0, 1).toUpperCase();
      txt += token.substring(1) + " ";
      lsrc = lsrc.substring(lsrc.indexOf("_") + 1);
    }
    txt += lsrc.substring(0, 1).toUpperCase();
    txt += lsrc.substring(1);
    return txt.trim();
	}
	
	private String nextToken(String src, String delimiter, String txtDelimiter) {
	  String txt = "";
	  if ((txtDelimiter != null) && (src.substring(0, src.indexOf(delimiter)).contains(txtDelimiter))) {
	    String subt = "";
	    
	    boolean keep = false;
	    int index = src.indexOf(txtDelimiter);
	    while (src.substring(index, index + 1) != txtDelimiter) {
	      txt += src.substring(index, index + 1);
	      index++;
	    }
	  }
	  else {
	    txt = src.substring(0, src.indexOf(delimiter));
	  }
	  return txt;
	}
}
