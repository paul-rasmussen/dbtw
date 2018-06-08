package com.dbtw.db.utils.dialogs;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.HashMap;
import java.util.Vector;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.filechooser.FileNameExtensionFilter;

import oracle.jdbc.pool.OracleDataSource;
import com.dbtw.widgets.UserPrefs;

public class OpenDatabase extends JFrame {
  //Static variables
  private static final long serialVersionUID = 1L;
  private static final int TNS = 0;
  private static final int LDAP = 1;
  private static final int SQLNET = 2;
  private static final int JDBC = 3;
  private static final int MYSQL = 4;
	//Constants
	private final int WIDTH = 550;
	private final int HEIGHT = 250;
	private final String TITLE = "Open Database";
	private final int TEXT_HT = 25;
	private final int LABEL_WIDTH = 100;
	private final int TEXT_WIDTH = 200;
	private final int SPACING = 5;
	//Private variables
	private JLabel lblHost = new JLabel("Host");
	private JLabel lDbName = new JLabel("Database");
	private JLabel lUsername = new JLabel("User Name");
	private JLabel lPassword = new JLabel("Password");
	private JRadioButton rbTns = new JRadioButton("TNSNames");
	private JRadioButton rbLdap = new JRadioButton("LDAP");
	private JRadioButton rbSQLNet = new JRadioButton("SQLNet");
	private JRadioButton rbJDBC = new JRadioButton("JDBC");
	private JRadioButton rbMySQL = new JRadioButton("MySQL");
	private ButtonGroup rbGroup1 = new ButtonGroup();
	private JComboBox<String> cboDbName = new JComboBox<String>();
	private JTextField txtHost = new JTextField();
	private JTextField txtDbName = new JTextField();
	private JTextField txtUsername = new JTextField();
	private JPasswordField txtPassword = new JPasswordField();
	private JButton btnConnect = new JButton();
	private Vector<String> databases = new Vector<String>();
	private HashMap<String, HashMap<String, String>> serverlist = new HashMap<String, HashMap<String, String>>();
	private Vector<String> ldaplist = new Vector<String>();
	private String ldapContext = "";
	private int connType = TNS;
	//Public variables

	//Constructors
	public OpenDatabase() {
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
		setSize(WIDTH, HEIGHT);
		Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
		int x = (int) ((dimension.getWidth() - getWidth()) / 2);
		int y = (int) ((dimension.getHeight() - getHeight()) / 2);
		setLocation(x, y);

		rbTns.setSize(LABEL_WIDTH, TEXT_HT);
		rbTns.setLocation(SPACING, SPACING);
		rbTns.setForeground((Color) UserPrefs.getInstance().getParameter(UserPrefs.FONT_COLOR));
		rbTns.setBackground((Color) UserPrefs.getInstance().getParameter(UserPrefs.THEME_COLOR));
		rbTns.setActionCommand("TNS");
		rbTns.addActionListener(new ActionListener() {
		  public void actionPerformed(ActionEvent e) {
		    if (e.getActionCommand().equals("TNS")) {
		      connType = TNS;
		      rbGroupAction();
		    }
		  }
		});
		rbLdap.setSize(rbTns.getSize());
		rbLdap.setLocation(rbTns.getX() + rbTns.getWidth() + SPACING, rbTns.getY());
		rbLdap.setForeground((Color) UserPrefs.getInstance().getParameter(UserPrefs.FONT_COLOR));
		rbLdap.setBackground((Color) UserPrefs.getInstance().getParameter(UserPrefs.THEME_COLOR));
		rbLdap.setActionCommand("LDAP");
		rbLdap.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals("LDAP")) {
          connType = LDAP;
          rbGroupAction();
        }
      }
    });
		rbSQLNet.setSize(rbTns.getSize());
		rbSQLNet.setLocation(rbLdap.getX() + rbLdap.getWidth() + SPACING, rbLdap.getY());
		rbSQLNet.setForeground((Color) UserPrefs.getInstance().getParameter(UserPrefs.FONT_COLOR));
		rbSQLNet.setBackground((Color) UserPrefs.getInstance().getParameter(UserPrefs.THEME_COLOR));
		rbSQLNet.setActionCommand("SQLNet");
		rbSQLNet.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals("SQLNet")) {
          connType = SQLNET;
          rbGroupAction();
        }
      }
    });
		rbJDBC.setSize(rbTns.getSize());
    rbJDBC.setLocation(rbSQLNet.getX() + rbSQLNet.getWidth() + SPACING, rbLdap.getY());
    rbJDBC.setForeground((Color) UserPrefs.getInstance().getParameter(UserPrefs.FONT_COLOR));
    rbJDBC.setBackground((Color) UserPrefs.getInstance().getParameter(UserPrefs.THEME_COLOR));
    rbJDBC.setActionCommand("JDBC");
    rbJDBC.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals("JDBC")) {
          connType = JDBC;
          rbGroupAction();
        }
      }
    });
		rbMySQL.setSize(rbTns.getSize());
		rbMySQL.setLocation(rbJDBC.getX() + rbJDBC.getWidth() + SPACING, rbLdap.getY());
		rbMySQL.setForeground((Color) UserPrefs.getInstance().getParameter(UserPrefs.FONT_COLOR));
		rbMySQL.setBackground((Color) UserPrefs.getInstance().getParameter(UserPrefs.THEME_COLOR));
		rbMySQL.setActionCommand("MYSQL");
    rbMySQL.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals("MYSQL")) {
          connType = MYSQL;
          rbGroupAction();
        }
      }
    });
    rbGroup1.add(rbTns);
		rbGroup1.add(rbLdap);
		rbGroup1.add(rbSQLNet);
		rbGroup1.add(rbJDBC);
		rbGroup1.add(rbMySQL);
		
		lblHost.setHorizontalAlignment(JLabel.RIGHT);
		lblHost.setForeground((Color) UserPrefs.getInstance().getParameter(UserPrefs.FONT_COLOR));
		lblHost.setSize(LABEL_WIDTH,TEXT_HT);
		lblHost.setLocation(rbTns.getX(), rbTns.getY() + rbTns.getHeight() + SPACING);
		lblHost.setVisible(false);
		
    txtHost.setSize(TEXT_WIDTH, TEXT_HT);
    txtHost.setLocation(lblHost.getX() + lblHost.getWidth() + SPACING, lblHost.getY());
		
		lDbName.setHorizontalAlignment(JLabel.RIGHT);
		lDbName.setForeground((Color) UserPrefs.getInstance().getParameter(UserPrefs.FONT_COLOR));
		lDbName.setSize(LABEL_WIDTH,TEXT_HT);
		lDbName.setLocation(lblHost.getX(), lblHost.getY() + lblHost.getHeight() + SPACING);
		
		cboDbName = new JComboBox<String>(databases);
		cboDbName.setSize(TEXT_WIDTH, TEXT_HT);
		cboDbName.setLocation(lDbName.getX() + lDbName.getWidth() + SPACING, lDbName.getY());
		
		txtDbName.setSize(cboDbName.getSize());
		txtDbName.setLocation(cboDbName.getLocation());
		
		lUsername.setText("User Name:");
		lUsername.setHorizontalAlignment(JLabel.RIGHT);
		lUsername.setForeground((Color) UserPrefs.getInstance().getParameter(UserPrefs.FONT_COLOR));
		lUsername.setSize(LABEL_WIDTH,TEXT_HT);
		lUsername.setLocation(lDbName.getX(), lDbName.getY() + lDbName.getHeight() + SPACING);
		
    txtUsername.setSize(TEXT_WIDTH,TEXT_HT);
    txtUsername.setLocation(lUsername.getX() + lUsername.getWidth() + SPACING, lUsername.getY());
    
		lPassword.setText("Password");
		lPassword.setHorizontalAlignment(JLabel.RIGHT);
		lPassword.setForeground((Color) UserPrefs.getInstance().getParameter(UserPrefs.FONT_COLOR));
		lPassword.setSize(LABEL_WIDTH,TEXT_HT);
		lPassword.setLocation(lDbName.getX(), lUsername.getY() + TEXT_HT + SPACING);
		
    txtPassword.setSize(TEXT_WIDTH,TEXT_HT);
    txtPassword.setLocation(lPassword.getX() + lUsername.getWidth() + SPACING, lPassword.getY());
    
		btnConnect.setText("Connect");
		btnConnect.setSize(150, TEXT_HT);
		btnConnect.setLocation(((WIDTH/2)-(btnConnect.getWidth()/2)),lPassword.getY() + TEXT_HT + (4 * SPACING));
		btnConnect.setActionCommand("ConnectDatabase");
		btnConnect.addActionListener(new ActionListener() {

      @Override
      public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equalsIgnoreCase("ConnectDatabase")) {
          connect();
        }
      }
		  
		});
		
		add(rbTns);
		add(rbLdap);
		add(rbSQLNet);
		add(rbJDBC);
		add(rbMySQL);
		add(lblHost);
		add(lDbName);
		add(cboDbName);
		add(lUsername);
		add(txtUsername);
		add(lPassword);
		add(txtPassword);
		add(btnConnect);

		getRootPane().setDefaultButton(btnConnect);
		setVisible(true);
		this.setAlwaysOnTop(true);
	}
	
	private void findDatabaseNames() {
	  File tns = new File((String) UserPrefs.getInstance().getParameter(UserPrefs.TNSNAMES));
	  try {
	    if (!tns.exists()) {
  	    JFileChooser choose = new JFileChooser();
  	    choose.setDialogTitle("TNSNames Directory");
  	    choose.setDialogType(JFileChooser.OPEN_DIALOG);
  	    choose.setFileFilter(new FileNameExtensionFilter("Oracle Config","ora"));
  	    choose.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
  	    int sel = choose.showOpenDialog(this);
  	    if (sel == JFileChooser.APPROVE_OPTION) {
  	      tns = choose.getSelectedFile();
  	    }
	    }
	    UserPrefs.getInstance().setParameter(UserPrefs.TNSNAMES, tns.getAbsolutePath());
	    File tnsn = new File(tns.getPath(), "tnsnames.ora");
	    if (tnsn.exists()) {
	      rbTns.setSelected(true);
	      loadDatabaseNames(tnsn);
        connType = TNS;
	    }
	    File ldap = new File(tns.getPath(), "ldap.ora");
	    if (ldap.exists()) {
	      rbLdap.setSelected(true);
	      loadLdapNames(ldap);
        connType = LDAP;
	    }
      rbGroupAction();
	  }
	  catch (Exception e) {
	    e.printStackTrace(System.out);
	  }
	}
	
	private void loadDatabaseNames(File source) {
	  String host = "";
	  String instance = "";
	  String port = "";
	  String svcname = "";
	  HashMap<String, String> conndesc = new HashMap<String, String>();
	  boolean first = true;
	  try {
	    BufferedReader rdr = new BufferedReader(new FileReader(source));
	    while (rdr.ready()) {
	      String line = rdr.readLine();
	      if (line.length() > 0) {
      	      if ((!line.substring(0,1).equals("#")) && (!line.substring(0,1).equals(" "))) {
      	        if (!first) {
      	          serverlist.put(instance, conndesc);
      	          host = "";
      	          conndesc = new HashMap<String, String>();
      	        }
      	        instance = line.substring(0, line.indexOf(" ="));
      	        databases.add(instance);
      	        first = false;
      	      }
      	      if (line.toLowerCase().indexOf("host") > 0) {
      	        int start = line.toLowerCase().indexOf("host") + 7;
      	        int end = line.indexOf(")", start);
      	        host = line.substring(start, end);
      	        conndesc.put("host", host);
      	      }
              if (line.toLowerCase().indexOf("port") > 0) {
                  int start = line.toLowerCase().indexOf("port") + 7;
                  int end = line.indexOf(")", start);
                  port = line.substring(start, end);
                  conndesc.put("port", port);
              }
              if (line.toLowerCase().indexOf("service_name") > 0) {
                  int start = line.toLowerCase().indexOf("service_name") + 15;
                  int end = line.indexOf(")", start);
                  svcname = line.substring(start, end);
                  conndesc.put("servicename", svcname);
              }
	      }
	    }
	    rdr.close();
      serverlist.put(instance, conndesc);
	  }
	  catch (Exception e) {
	    JOptionPane.showMessageDialog(new JFrame(), "Databases will be defined by network name.", "No Database File Selected", JOptionPane.OK_OPTION);
	    connType = JDBC;
	    rbGroupAction();
	    repaint();
	  }
	}
	
	private void loadLdapNames(File source) {
    String txt = "";
    boolean readList = false; 
    try {
      BufferedReader rdr = new BufferedReader(new FileReader(source));
      int start = 0;
      while (rdr.ready()) {
        String line = rdr.readLine().trim();
        if (line.length() > 0) {
          if (line.indexOf("DEFAULT_ADMIN_CONTEXT") > -1) {
            start = line.indexOf("\"") + 1;
            int stop = line.indexOf("\"", start);
            ldapContext = line.substring(start,  stop);
          }
          if ((line.indexOf("DIRECTORY_SERVERS") > -1)) {
            start = line.indexOf("(") + 1;
            line = line.substring(start);
            start = 0;
            readList = true;
          }
          if (readList) {
            int end = line.indexOf(")");
            if (end == -1) {
              txt += line.substring(start).trim();
            }
            else {
              readList = false;
              txt += line.substring(0, end).trim();
            }
          }
        }
      }
      rdr.close();
      start = 0;
      int end = txt.indexOf(",", start);
      while (end != -1) {
        int send = txt.indexOf(":", start);
        ldaplist.add(txt.substring(start, send));
        start = end + 1;
        end = txt.indexOf(",", start);
      }
      int send = txt.indexOf(":", start);
      ldaplist.add(txt.substring(start, send));
    }
    catch (Exception e) {
      e.printStackTrace(System.out);
    }
	}
	
	private void connect() {
	  String errm = "";
	  String db = "";
	  String user = txtUsername.getText();
	  String pwd = new String(txtPassword.getPassword());
	  String host = "";
	  String port = "";
	  String svc_name = "";
	  String url = "";
	  Connection conn;
	  
	  switch (connType) {
	    case (TNS): {
	      db = (String) cboDbName.getSelectedItem();
	      host = serverlist.get(db).get("host");
	      port = serverlist.get(db).get("port");
	      if (serverlist.get(db).containsKey("servicename")) {
	          svc_name = serverlist.get(db).get("servicename");
	      }
	      else {
	          svc_name = db;
	      }
	      url = "jdbc:oracle:thin:@//" + host + ":" + port + "/" + svc_name.toLowerCase();
	      break;
	    }
      case (LDAP): {
        host = txtDbName.getText();
        db = txtDbName.getText().toLowerCase();
        host = ldaplist.elementAt(0);
        url = "jdbc:oracle:thin:@ldap://" + host + "/" + db + ",cn=OracleContext," + ldapContext;
        break;
      }
      case (SQLNET): {
        break;
      }
      case (JDBC): {
        host = txtDbName.getText();
        db = txtDbName.getText().toLowerCase();
        url = "jdbc:oracle:thin:@ldap://" + host + "/" + db;
        break;
      }
      case (MYSQL): {
        host = txtHost.getText();
        db = txtDbName.getText().toLowerCase();
        url = "jdbc:mysql://" + host + "/" + db + "?user=" + user + "&password=" + pwd;
        break;
      }
	  }
	  try {
	    if (connType == MYSQL) {
	      conn = DriverManager.getConnection(url);
        UserPrefs.getInstance().setParameter(UserPrefs.DB_TYPE, UserPrefs.MYSQL);
	    }
	    else {
  	    OracleDataSource ods = new OracleDataSource();
  	    ods.setURL(url);
  	    ods.setServerName(host);
  //	    ods.setNetworkProtocol("tcp");
  	    ods.setDriverType("thin");
  	    ods.setUser(user);
  	    ods.setPassword(pwd);
  	    ods.setTNSEntryName(db); 
  	    ods.setDatabaseName(svc_name);
  	    url = ods.getURL();
  	    conn = ods.getConnection();
	    }
	    UserPrefs.getInstance().setParameter(UserPrefs.DB_NAME, db);
	    UserPrefs.getInstance().setParameter(UserPrefs.CONNECTION, conn);
	    setVisible(false);
	  }
	  catch (Exception e) {
	    String msg = "There was an issue connectiong to the database.\nPlease check your credentials and your CAPS key, and try again.\n";
	    msg += url + "\n";
	    msg += user + "\n";
	    msg += pwd + "\n";
	    msg += e.getMessage();
	    JOptionPane.showMessageDialog(new JFrame(), msg, "Connection Error", JOptionPane.OK_OPTION);
	    System.out.println(url);
	    e.printStackTrace(System.out);
	    cboDbName.requestFocus();
	    txtUsername.setText("");
	    txtPassword.setText("");
	  }
	}

	private void rbGroupAction() {
    remove(txtHost);
    remove(lblHost);
    lblHost.setVisible(false);
    txtHost.setVisible(false);
    txtHost.setFocusable(false);
    remove(txtDbName);
    txtDbName.setVisible(false);
    txtDbName.setFocusable(false);
    remove(cboDbName);
    cboDbName.setVisible(false);
    cboDbName.setFocusable(false);
	  switch (connType) {
	    case (TNS): {
	      add(cboDbName);
	      cboDbName.setVisible(true);
	      cboDbName.setFocusable(true);
	      break;
	    }
      case (LDAP): {
        add(txtDbName);
        txtDbName.setVisible(true);
        txtDbName.setFocusable(true);
        break;
      }
      case (SQLNET): {
        add(txtDbName);
        txtDbName.setVisible(true);
        txtDbName.setFocusable(true);
        break;
      }
      case (JDBC): {
        add(lblHost);
        add(txtHost);
        add(txtDbName);
        lblHost.setVisible(true);
        txtHost.setVisible(true);
        txtHost.setFocusable(true);
        txtDbName.setVisible(true);
        txtDbName.setFocusable(true);
        break;
      }
      case (MYSQL): {
        add(lblHost);
        add(txtHost);
        add(txtDbName);
        lblHost.setVisible(true);
        txtHost.setVisible(true);
        txtHost.setFocusable(true);
        txtDbName.setVisible(true);
        txtDbName.setFocusable(true);
        break;
      }
	  }
    repaint();
	}
}
