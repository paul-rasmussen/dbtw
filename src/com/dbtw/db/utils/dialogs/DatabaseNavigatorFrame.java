package com.dbtw.db.utils.dialogs;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.JFrame;

import com.dbtw.db.utils.dialogs.DatabaseNavigatorPanel;

import com.dbtw.widgets.UserPrefs;

public class DatabaseNavigatorFrame extends JFrame {
  //Static variables
  //Constants
  private final String TITLE = "Database Navigator";
  private final int SCREEN_WIDTH = 900;
  private final int SCREEN_HEIGHT = 750;
  //Private variables
  //Public variables

  //Constructors
  public DatabaseNavigatorFrame() {
    init();
  }

  //Static methods
  //Public methods
  //Private methods
  private void init() {
    setDefaultCloseOperation(DISPOSE_ON_CLOSE);
    getContentPane().setBackground((Color) UserPrefs.getInstance().getParameter(UserPrefs.THEME_COLOR));
    getContentPane().setLayout(null);
    setTitle(TITLE);
    setSize(SCREEN_WIDTH, SCREEN_HEIGHT);
    Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
    int x = (int) ((dimension.getWidth() - getWidth()) / 2);
    int y = (int) ((dimension.getHeight() - getHeight()) / 2);
    setLocation(x, y);

    DatabaseNavigatorPanel dbPanel = new DatabaseNavigatorPanel(this);
    this.setContentPane(dbPanel);
  }
  
}
