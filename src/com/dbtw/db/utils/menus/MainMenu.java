package com.dbtw.db.utils.menus;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;

import com.dbtw.db.utils.dialogs.BuildEmpireDialog;
import com.dbtw.db.utils.dialogs.BuildMySQLAdminEmpireDialog;
import com.dbtw.db.utils.dialogs.BuildOracleAdminEmpireDialog;
import com.dbtw.db.utils.dialogs.DatabaseNavigatorFrame;
import com.dbtw.db.utils.dialogs.DatabaseTypeDialog;
import com.dbtw.db.utils.dialogs.Json2SqlDialog;
import com.dbtw.db.utils.dialogs.SelectSchemaDialog;
import com.dbtw.db.utils.dialogs.SqlNavigatorPanel;

import com.dbtw.db.utils.dialogs.OpenDatabase;
import com.dbtw.db.utils.dialogs.UserPrefsDialog;

public class MainMenu extends JMenuBar {
    // Static variables
    // Constants
    private final int TABLE_SCRIPT = 0;
    private final int VIEW_SCRIPT = 1;
    private final int QUERY_SCRIPT = 2;
    // Private variables
    private SqlNavigatorPanel sqlNav = null;
    private JMenu file = new JMenu("File");
    private JMenuItem exit = new JMenuItem("Exit");
    private JMenuItem setTargetDirectory = new JMenuItem("Target Directory");
    private JMenuItem setUserPrefs = new JMenuItem("User Prefs");
    private JMenu database = new JMenu("Database");
    private JMenuItem openDatabase = new JMenuItem("Open Database");
    private JMenuItem selectSchema = new JMenuItem("Select Schema");
    private JMenuItem selectDBType = new JMenuItem("Database Type");
    private JMenuItem browseDB = new JMenuItem("Browse DB");
    private JMenu scripts = new JMenu("Scripts");
    private JMenu tableScripts = new JMenu("Table");
    private JMenuItem tableScriptsFile = new JMenuItem("From File");
    private JMenuItem tableScriptsText = new JMenuItem("From Text");
    private JMenu viewScripts = new JMenu("Views");
    private JMenuItem viewScriptsFile = new JMenuItem("From File");
    private JMenuItem viewScriptsText = new JMenuItem("From Text");
    private JMenu queryScripts = new JMenu("Queries");
    private JMenuItem queryScriptsFile = new JMenuItem("From File");
    private JMenuItem queryScriptsText = new JMenuItem("From Text");
    private JMenu conversions = new JMenu("Conversions");
    private JMenu fromFile = new JMenu("From Files");
    private JMenu fromDb = new JMenu("From DB");
    private JMenuItem json2sql = new JMenuItem("JSON to SQL");
    private JMenu generateCode = new JMenu("Generate Code");
    private JMenuItem toEmpire = new JMenuItem("EmpireDB");
    private JMenu dbSpecific = new JMenu("DB Specific");
    private JMenu dbOracle = new JMenu("Oracle");
    private JMenuItem sysViewsToEmpire = new JMenuItem("Generate Sys Views Class (Oracle)");
    private JMenuItem infoViewsToEmpire = new JMenuItem("Generate Information Views Class (MySQL)");
    private JMenu dbSqlServer = new JMenu("SQL Server");
    private JMenu dbMySql = new JMenu("MySQL");
    private JMenu dbAccess = new JMenu("MS Access");
    private JMenu dbPostgre = new JMenu("PostgreSQL");

    // Public variables

    // Constructors
    public MainMenu() {
        init();
    }

    // Static methods
    // Public methods
    // Private methods
    private void init() {
        exit.setActionCommand("exitApplication");
        exit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (e.getActionCommand().equals("exitApplication")) {
                    exitApp();
                }
            }
        });

        setTargetDirectory.setActionCommand("targetDirectory");
        setTargetDirectory.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (e.getActionCommand().equals("targetDirectory")) {
                    setTargetDirectoryAction();
                }
            }
        });

        setUserPrefs.setActionCommand("userPrefs");
        setUserPrefs.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (e.getActionCommand().equals("userPrefs")) {
                    setUserPrefsAction();
                }
            }
        });

        openDatabase.setActionCommand("openDatabase");
        openDatabase.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (e.getActionCommand().equals("openDatabase")) {
                    openDatabaseAction();
                }
            }
        });

        selectSchema.setActionCommand("selectSchema");
        selectSchema.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (e.getActionCommand().equals("selectSchema")) {
                    selectSchemaAction();
                }
            }
        });

        selectDBType.setActionCommand("dbType");
        selectDBType.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (e.getActionCommand().equals("dbType")) {
                    selectDBTypeAction();
                }
            }
        });

        browseDB.setActionCommand("browseDb");
        browseDB.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (e.getActionCommand().equals("browseDb")) {
                    browseDbAction();
                }
            }
        });

        tableScriptsFile.setActionCommand("tableScriptFile");
        tableScriptsFile.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (e.getActionCommand().equals("tableScriptFile")) {
                    viewScriptsFromFileAction(TABLE_SCRIPT);
                }
            }
        });

        tableScriptsText.setActionCommand("tableScriptText");
        tableScriptsText.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (e.getActionCommand().equals("tableScriptText")) {
                    viewScriptsFromTextAction(TABLE_SCRIPT);
                }
            }
        });

        viewScriptsFile.setActionCommand("viewScriptFile");
        viewScriptsFile.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (e.getActionCommand().equals("viewScriptFile")) {
                    viewScriptsFromFileAction(VIEW_SCRIPT);
                }
            }
        });

        viewScriptsText.setActionCommand("viewScriptText");
        viewScriptsText.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (e.getActionCommand().equals("viewScriptText")) {
                    viewScriptsFromTextAction(VIEW_SCRIPT);
                }
            }
        });

        queryScriptsFile.setActionCommand("queryScriptFile");
        queryScriptsFile.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (e.getActionCommand().equals("queryScriptFile")) {
                    viewScriptsFromFileAction(QUERY_SCRIPT);
                }
            }
        });

        queryScriptsText.setActionCommand("queryScriptText");
        queryScriptsText.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (e.getActionCommand().equals("queryScriptText")) {
                    viewScriptsFromTextAction(QUERY_SCRIPT);
                }
            }
        });

        json2sql.setActionCommand("JSON to SQL");
        json2sql.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (e.getActionCommand().equals("JSON to SQL")) {
                    jsonToSqlAction();
                }
            }
        });

        toEmpire.setActionCommand("GenerateEmpireDB");
        toEmpire.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (e.getActionCommand().equals("GenerateEmpireDB")) {
                    empireDBAction();
                }
            }
        });

        sysViewsToEmpire.setActionCommand("SystemViewsToEmpireDB");
        sysViewsToEmpire.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (e.getActionCommand().equals("SystemViewsToEmpireDB")) {
                    sysViewsToEmpireAction();
                }
            }
        });
        
        infoViewsToEmpire.setActionCommand("InfoViewsToEmpireDB");
        infoViewsToEmpire.addActionListener(new ActionListener() {
          public void actionPerformed(ActionEvent e) {
              if (e.getActionCommand().equals("InfoViewsToEmpireDB")) {
                 infoViewsToEmpireAction();
              }
          }
      });
        

        file.add(setTargetDirectory);
        file.add(setUserPrefs);
        file.add(exit);
        database.add(browseDB);
        database.add(openDatabase);
        database.add(selectSchema);
        database.add(selectDBType);
        tableScripts.add(tableScriptsFile);
        tableScripts.add(tableScriptsText);
        viewScripts.add(viewScriptsFile);
        viewScripts.add(viewScriptsText);
        queryScripts.add(queryScriptsFile);
        queryScripts.add(queryScriptsText);
        scripts.add(tableScripts);
        scripts.add(viewScripts);
        scripts.add(queryScripts);
        fromFile.add(json2sql);
        conversions.add(fromFile);
        conversions.add(fromDb);
        generateCode.add(toEmpire);
        dbSpecific.add(dbOracle);
        dbOracle.add(sysViewsToEmpire);
        dbSpecific.add(dbSqlServer);
        dbMySql.add(infoViewsToEmpire);
        dbSpecific.add(dbMySql);
        dbSpecific.add(dbAccess);
        dbSpecific.add(dbPostgre);
        add(file);
        add(database);
        add(scripts);
        add(conversions);
        add(generateCode);
        add(dbSpecific);
    }

    private void setTargetDirectoryAction() {
        JFileChooser fc = new JFileChooser();
        fc.setDialogType(JFileChooser.OPEN_DIALOG);
        fc.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
        File out = fc.getSelectedFile();

    }

    private void setUserPrefsAction() {
        UserPrefsDialog dialog = new UserPrefsDialog();
        dialog.setVisible(true);
    }

    private void openDatabaseAction() {
        OpenDatabase od = new OpenDatabase();
        od.setVisible(true);
    }

    private void selectSchemaAction() {
        SelectSchemaDialog sd = new SelectSchemaDialog();
        sd.setVisible(true);
    }

    private void selectDBTypeAction() {
        DatabaseTypeDialog dd = new DatabaseTypeDialog();
        dd.setVisible(true);
    }

    private void browseDbAction() {
        DatabaseNavigatorFrame dialog = new DatabaseNavigatorFrame();
        dialog.setVisible(true);
    }

    private void viewScriptsFromTextAction(int scriptType) {
        String sql = JOptionPane.showInputDialog(new JFrame(), "Please enter the sql");
        switch (scriptType) {
            case (TABLE_SCRIPT): {
                break;
            }
            case (VIEW_SCRIPT): {
                sqlNav = new SqlNavigatorPanel((JFrame) this.getParent().getParent().getParent(), sql);
                break;
            }
            case (QUERY_SCRIPT): {
                sqlNav = new SqlNavigatorPanel((JFrame) this.getParent().getParent().getParent(), sql);
                break;
            }
        }
    }

    private void viewScriptsFromFileAction(int scriptType) {
        File[] src = null;
        try {
            JFileChooser choose = new JFileChooser();
            choose.setDialogTitle("Query File");
            choose.setDialogType(JFileChooser.OPEN_DIALOG);
            choose.setMultiSelectionEnabled(true);
            choose.setFileFilter(new FileNameExtensionFilter("SQL File", "sql"));
            int sel = choose.showOpenDialog(this);
            if (sel == JFileChooser.APPROVE_OPTION) {
                src = choose.getSelectedFiles();
            }
            else {
                return;
            }
        }
        catch (Exception e) {
            e.printStackTrace(System.out);
        }
        switch (scriptType) {
            case (TABLE_SCRIPT): {
                break;
            }
            case (VIEW_SCRIPT): {
                sqlNav = new SqlNavigatorPanel((JFrame) this.getParent().getParent().getParent(), src);
                break;
            }
            case (QUERY_SCRIPT): {
                sqlNav = new SqlNavigatorPanel((JFrame) this.getParent().getParent().getParent(), src);
                break;
            }
        }
    }

    private void jsonToSqlAction() {
        Json2SqlDialog dialog = new Json2SqlDialog();
        dialog.setVisible(true);
    }

    private void empireDBAction() {
        BuildEmpireDialog dialog = new BuildEmpireDialog();
        dialog.setVisible(true);
    }

    private void sysViewsToEmpireAction() {
        BuildOracleAdminEmpireDialog dialog = new BuildOracleAdminEmpireDialog();
        dialog.setVisible(true);
    }
    
    private void infoViewsToEmpireAction() {
      BuildMySQLAdminEmpireDialog dialog = new BuildMySQLAdminEmpireDialog();
      dialog.setVisible(true);
    }

    private void exitApp() {
        System.exit(0);
    }

}
