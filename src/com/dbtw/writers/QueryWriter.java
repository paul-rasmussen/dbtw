package com.dbtw.writers;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.util.Enumeration;

import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.tree.TreeNode;

import com.dbtw.models.DbNode;

import com.dbtw.widgets.StringWidget;

public class QueryWriter {
  //Static variables
  public static final int PLAINTEXT = 0;
  public static final int HTML = 1;
  //Constants
  //Private variables
  private int mode = 0;
  private BufferedWriter out = null;
  private int indent = 0;
  private int indentSize = 2;
  //Public variables

  //Constructors
  public QueryWriter(int mode) {
    BufferedWriter file = null;
    try {
      JFileChooser choose = new JFileChooser();
      choose.setDialogTitle("Output File");
      choose.setDialogType(JFileChooser.SAVE_DIALOG);
      int sel = choose.showOpenDialog(new JFrame());
      if (sel == JFileChooser.APPROVE_OPTION) {
        file = new BufferedWriter(new FileWriter(choose.getSelectedFile()));
        init(mode, file);
      }
      else {
        return;
      }
    }
    catch (Exception e) {
      e.printStackTrace(System.out);
    }
  }

  public QueryWriter(int mode, BufferedWriter file) {
    init(mode, file);
  }
  
  //Static methods
  //Public methods
  public void setIndentSize(int size) {
    indentSize = size;
  }
  
  public int getIndentSize() {
    return indentSize;
  }
  
  public void writeNode(DbNode node) {
    switch (mode) {
      case (PLAINTEXT): {
        writePlainNode("", node);
        break;
      }
      case (HTML): {
        writeHtmlNode(node);
        break;
      }
    }
  }
  
  public void closeFile() {
    writeClose();
  }
  
  //Private methods
  private void init(int mode, BufferedWriter file) {
    if ((mode >= PLAINTEXT) && (mode <= HTML)) {
      this.mode = mode;
    }
    else {
      mode = 0;
    }
    out = file;
    switch (mode){
      case(PLAINTEXT): {
        break;
      }
      case (HTML): {
        writeHtmlHeader();
        break;
      }
    }
  }
  
  private void writeElement(String txt) {
    try {
      out.write(txt);
      out.flush();
    }
    catch (Exception e) {
      e.printStackTrace(System.out);
    }
  }

  private void writeHtmlHeader() {
    try {
      String txt = "<!DOCTYPE html>\n<HTML>\n  <HEAD>";
      txt += "  <HEAD>\n";
      txt += "  <BODY>\n";
      txt += "  </BODY>\n</HTML>";
      out.write(txt);
      out.flush();
    }
    catch (Exception e) {
      e.printStackTrace(System.out);
    }
  }
  
  private void writeClose() {
    try {
      String txt = "  </BODY>\n</HTML>";
      out.write(txt);
      out.flush();
    }
    catch (Exception e) {
      e.printStackTrace(System.out);
    }
  }

  private void writeHtmlNode(DbNode node) {
    try {
      indent += indentSize;
      writeElement(StringWidget.indent("<UL>\n", indent + indentSize));
      String txt = StringWidget.indent("<LI>" + node.getName() + "(" + node.getChildCount() + ")\n", indent + (2*indentSize));
      out.write(txt);
      if (node.getChildCount() > 0) {
        Enumeration<TreeNode> nodes = node.children();
        while (nodes.hasMoreElements()) {
          DbNode tnode = (DbNode) nodes.nextElement();
          writeHtmlNode(tnode);
        }
      }
      writeElement(StringWidget.indent("</UL>\n", indent + indentSize));
      indent -= indentSize;
    }
    catch (Exception e) {
      e.printStackTrace(System.out);
    }
  }
  
  private void writePlainNode(String prefix, DbNode node) {
    try {
      indent += indentSize;
      String txt = node.getName() + "(" + node.getChildCount() + ")\n";
      if (prefix.length() > 0) {
        txt = StringWidget.treeIndent(prefix + " " + txt, indent + (2*indentSize), indentSize);
      }
      else {
        txt = StringWidget.treeIndent(txt, indent + (2*indentSize), indentSize);
      }
      out.write(txt);
      if (node.getChildCount() > 0) {
        Enumeration<TreeNode> nodes = node.children();
        while (nodes.hasMoreElements()) {
          DbNode tnode = (DbNode) nodes.nextElement();
          if (nodes.hasMoreElements()) {
            writePlainNode(new String(new char[]{124}), tnode);
          }
          else {
            writePlainNode(new String(new char[]{45}), tnode);
          }
        }
      }
      out.flush();
      indent -= indentSize;
    }
    catch (Exception e) {
      e.printStackTrace(System.out);
    }
  }
  
}
