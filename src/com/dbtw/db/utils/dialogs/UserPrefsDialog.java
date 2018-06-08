package com.dbtw.db.utils.dialogs;

import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.JButton;
import javax.swing.JFrame;

public class UserPrefsDialog extends JFrame {
  //Static variables
  //Constants
  private final String WHOAMI="UserPrefsDialog";
  //Private variables
  private int screenWidth = 550;
  private int screenHeight = 350;

  private JButton btnSave = new JButton("Save");
  //Public variables
  
  //Constructors
  public UserPrefsDialog() {
    init();
  }
  
  //Static methods
  //Public methods
  //Private methods
  private void init() {
    setSize(screenWidth, screenHeight);
    Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
    int x = (int) ((dimension.getWidth() - getWidth()) / 2);
    int y = (int) ((dimension.getHeight() - getHeight()) / 2);
    setLocation(x, y);

    setLayout(null);
    setTitle("Preference Settings");

    setVisible(true);
  }
  
}
