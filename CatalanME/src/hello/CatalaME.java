/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package hello;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Enumeration;
import javax.microedition.io.Connector;
import javax.microedition.io.HttpConnection;
import javax.microedition.io.file.FileConnection;
import javax.microedition.io.file.FileSystemRegistry;
import javax.microedition.midlet.*;
import javax.microedition.lcdui.*;
import javax.microedition.media.Manager;
import javax.microedition.media.MediaException;
import javax.microedition.media.Player;
import javax.microedition.media.control.VolumeControl;
import org.netbeans.microedition.lcdui.SimpleTableModel;
import org.netbeans.microedition.lcdui.SplashScreen;
import org.netbeans.microedition.lcdui.TableItem;
import org.netbeans.microedition.lcdui.WaitScreen;
import org.netbeans.microedition.lcdui.laf.ColorSchema;
import org.netbeans.microedition.lcdui.pda.FileBrowser;
import org.netbeans.microedition.util.SimpleCancellableTask;

/**
 * @author Administrator
 */
public class CatalaME extends MIDlet implements CommandListener, ItemCommandListener {

    private boolean midletPaused = false;

    //<editor-fold defaultstate="collapsed" desc=" Generated Fields ">//GEN-BEGIN:|fields|0|
    private java.util.Hashtable __previousDisplayables = new java.util.Hashtable();
    private Command exitCommand;
    private Command okCommand;
    private Command cancelCommand;
    private Command itemCommand;
    private Command backCommand1;
    private Command backCommand;
    private Command backCommand3;
    private Command okCommand4;
    private Command backCommand4;
    private Command backCommand2;
    private Command backCommand6;
    private Command okCommand6;
    private Command okCommand5;
    private Command backCommand5;
    private Command okCommand8;
    private Command backCommand9;
    private Command okCommand7;
    private Command backCommand7;
    private Command backCommand8;
    private Command okCommand11;
    private Command backCommand11;
    private Command okCommand9;
    private Command backCommand14;
    private Command okCommand14;
    private Command backCommand13;
    private Command okCommand13;
    private Command backCommand12;
    private Command okCommand12;
    private Command okCommand17;
    private Command backCommand16;
    private Command okCommand15;
    private Command backCommand15;
    private Command backCommand19;
    private Command okCommand19;
    private Command backCommand18;
    private Command okCommand18;
    private Command backCommand17;
    private Command backCommand20;
    private Command okCommand20;
    private Command backCommand21;
    private Command okCommand21;
    private Command okCommand22;
    private Command itemCommand2;
    private Command itemCommand1;
    private Command itemCommand3;
    private Command itemCommand4;
    private Command itemCommand5;
    private Command itemCommand6;
    private Command itemCommand7;
    private Command itemCommand8;
    private Command itemCommand9;
    private Command itemCommand10;
    private Command itemCommand11;
    private Command itemCommand12;
    private Command itemCommand13;
    private Command itemCommand14;
    private Command itemCommand15;
    private Command itemCommand16;
    private Command itemCommand17;
    private Command itemCommand18;
    private Command itemCommand19;
    private Command itemCommand20;
    private Command itemCommand21;
    private Command itemCommand22;
    private Command itemCommand23;
    private Command itemCommand24;
    private Command itemCommand25;
    private Command itemCommand26;
    private Command itemCommand27;
    private Command itemCommand28;
    private Command helpCommand;
    private Command okCommand1;
    private Form form;
    private TableItem tableItem;
    private Spacer spacer;
    private SplashScreen splashScreen;
    private Alert alert;
    private Form salutacions2;
    private TableItem tableItem2;
    private Form alabast1;
    private TableItem tableItem1;
    private Form negacions5;
    private TableItem tableItem5;
    private Form preguntesusuals3;
    private TableItem tableItem3;
    private Form afirmacions4;
    private TableItem tableItem4;
    private Form exclamacions7;
    private TableItem tableItem7;
    private Form qualitats8;
    private TableItem tableItem8;
    private Form dubtes6;
    private TableItem tableItem6;
    private Form numerals10;
    private TableItem tableItem10;
    private Form expressions11;
    private TableItem tableItem11;
    private Form colors9;
    private TableItem tableItem9;
    private Form temps14;
    private TableItem tableItem14;
    private Form aniversaris13;
    private TableItem tableItem13;
    private Form dias12;
    private TableItem tableItem12;
    private Form avisos15;
    private TableItem tableItem15;
    private Form oferta16;
    private TableItem tableItem16;
    private Form transports19;
    private TableItem tableItem19;
    private Form localitzacions18;
    private TableItem tableItem18;
    private Form feina17;
    private TableItem tableItem17;
    private Form festes21;
    private TableItem tableItem21;
    private Form familia20;
    private TableItem tableItem20;
    private Form about;
    private ImageItem imageItem;
    private StringItem stringItem;
    private SimpleTableModel tableModel;
    private Image image1;
    private Font font1;
    private SimpleTableModel tableModel2;
    private SimpleTableModel tableModel1;
    private SimpleTableModel tableModel3;
    private SimpleTableModel tableModel4;
    private SimpleTableModel tableModel5;
    private SimpleTableModel tableModel6;
    private SimpleTableModel tableModel7;
    private SimpleTableModel tableModel8;
    private SimpleTableModel tableModel9;
    private SimpleTableModel tableModel10;
    private SimpleTableModel tableModel11;
    private SimpleTableModel tableModel12;
    private SimpleTableModel tableModel13;
    private SimpleTableModel tableModel14;
    private SimpleTableModel tableModel15;
    private SimpleTableModel tableModel16;
    private SimpleTableModel tableModel17;
    private SimpleTableModel tableModel18;
    private SimpleTableModel tableModel19;
    private SimpleTableModel tableModel20;
    private SimpleTableModel tableModel21;
    private Image image2;
    //</editor-fold>//GEN-END:|fields|0|

    private InputStream urlToStream(String url) throws IOException {
        // Open connection to the http url...
        HttpConnection connection = (HttpConnection) Connector.open(url);
        DataInputStream dataIn = connection.openDataInputStream();
        byte[] buffer = new byte[1000];
        int read = -1;
        // Read the content from url.
        ByteArrayOutputStream byteout = new ByteArrayOutputStream();
        while ((read = dataIn.read(buffer)) >= 0) {
            byteout.write(buffer, 0, read);
        }
        dataIn.close();
        // Fill InputStream to return with content read from the URL.
        ByteArrayInputStream byteIn = new ByteArrayInputStream(byteout.toByteArray());
        return byteIn;

    }

    /**
     * Displays an error message in Alert.
     * 
     * @param message
     *            String as message to display.
     */
    public void alertError(String message) {
        Alert alert = new Alert("Error", message, null, AlertType.ERROR);
        Display display = Display.getDisplay(this);
        Displayable current = display.getCurrent();
        if (!(current instanceof Alert)) {
            // This next call can't be done when current is an Alert
            display.setCurrent(alert, current);
        }
    }

    protected String getFileListAsString(String path) {
        String strFileList = "";
        try {
            FileConnection fc = (FileConnection) Connector.open(path, Connector.READ);
            Enumeration filelist = fc.list("*", true); //also hidden files are shown

            String filename;
            while (filelist.hasMoreElements()) {
                filename = (String) filelist.nextElement();
                fc = (FileConnection) Connector.open(path + filename, Connector.READ);
                if (fc.isDirectory()) {
                    long size = fc.directorySize(false);
                    strFileList += (filename + " - " + Integer.toString((int) size) + "B\n");
                //form.append(filename + " - " + Integer.toString((int) size) + "B\n");
                } else {
                    long size = fc.fileSize();
                    strFileList += (filename + " - " + Integer.toString((int) size) + "B\n");
                //form.append(filename + " - " + Integer.toString((int) size) + "B\n");
                }
            }
            fc.close();
        } catch (IOException ioe) {
            System.out.println("IOException: " + ioe.getMessage());
        } catch (SecurityException se) {
            System.out.println("SecurityException: " + se.getMessage());
        }


        return strFileList;
    }

    protected void getFileList(String path) {
        try {
            FileConnection fc = (FileConnection) Connector.open(path, Connector.READ);
            Enumeration filelist = fc.list("*", true); //also hidden files are shown

            String filename;
            while (filelist.hasMoreElements()) {
                filename = (String) filelist.nextElement();
                fc = (FileConnection) Connector.open(path + filename, Connector.READ);
                if (fc.isDirectory()) {
                    long size = fc.directorySize(false);
                    form.append(filename + " - " + Integer.toString((int) size) + "B\n");
                } else {
                    long size = fc.fileSize();
                    form.append(filename + " - " + Integer.toString((int) size) + "B\n");
                }
            }
            fc.close();
        } catch (IOException ioe) {
            System.out.println("IOException: " + ioe.getMessage());
        } catch (SecurityException se) {
            System.out.println("SecurityException: " + se.getMessage());
        }
    }

    public String createRootList() {
        String roots = "Roots:\n";
        Enumeration drives = FileSystemRegistry.listRoots();
        while (drives.hasMoreElements()) {
            String driveString = drives.nextElement().toString();
            roots += driveString + "\n";
        }
        return roots;
    }

    /**
     * The CatalaME constructor.
     */
    public CatalaME() {

        playEmbebdedFile("benvingut.mp3");
    //getAlabast1().setTitle(getFileListAsString("file:///e:/"));
    //getFileList("file:///e:/");
    //getAlabast1().setTitle(System.getProperty("microedition.io.file.FileConnection.version"));

    //alertError(System.getProperty("fileconn.dir.memorycard.name"));
    //alertError(createRootList());
    //playMusic();

//        String url = System.getProperty("file.separator");
//        getAlabast1().setTitle(url);
//        try {
//
////            FileConnection fc = (FileConnection) Connector.open("file:///e:/test.mp3");
////            getAlabast1().setTitle(fc.getPath() + " " + fc.getURL() + " " + fc.getName());
//            InputStream is = urlToStream("file:///e:/Mis Cosas/2gb/test.mp3");
//            //InputStream is = getClass().getResourceAsStream("file:///test.mp3");
//            Player player = Manager.createPlayer(is, "audio/mpeg");
//            
//            player.realize();
//
//            getAlabast1().setTitle(url);
//            // get volume control for player and set volume to max
//            VolumeControl vc = (VolumeControl) player.getControl("VolumeControl");
//            if (vc != null) {
//                vc.setLevel(100);
//            }
//            player.prefetch();
//            player.start();
//        } catch (Exception e) {
//            getAlabast1().setTitle(e.getMessage());
//        }
//

    }

    //<editor-fold defaultstate="collapsed" desc=" Generated Methods ">//GEN-BEGIN:|methods|0|
    /**
     * Switches a display to previous displayable of the current displayable.
     * The <code>display</code> instance is obtain from the <code>getDisplay</code> method.
     */
    private void switchToPreviousDisplayable() {
        Displayable __currentDisplayable = getDisplay().getCurrent();
        if (__currentDisplayable != null) {
            Displayable __nextDisplayable = (Displayable) __previousDisplayables.get(__currentDisplayable);
            if (__nextDisplayable != null) {
                switchDisplayable(null, __nextDisplayable);
            }
        }
    }
    //</editor-fold>//GEN-END:|methods|0|

    //<editor-fold defaultstate="collapsed" desc=" Generated Method: initialize ">//GEN-BEGIN:|0-initialize|0|0-preInitialize
    /**
     * Initilizes the application.
     * It is called only once when the MIDlet is started. The method is called before the <code>startMIDlet</code> method.
     */
    private void initialize() {//GEN-END:|0-initialize|0|0-preInitialize
        // write pre-initialize user code here
//GEN-LINE:|0-initialize|1|0-postInitialize
        // write post-initialize user code here
    }//GEN-BEGIN:|0-initialize|2|
    //</editor-fold>//GEN-END:|0-initialize|2|

    //<editor-fold defaultstate="collapsed" desc=" Generated Method: startMIDlet ">//GEN-BEGIN:|3-startMIDlet|0|3-preAction
    /**
     * Performs an action assigned to the Mobile Device - MIDlet Started point.
     */
    public void startMIDlet() {//GEN-END:|3-startMIDlet|0|3-preAction
        // write pre-action user code here
        switchDisplayable(null, getSplashScreen());//GEN-LINE:|3-startMIDlet|1|3-postAction
    // write post-action user code here
    }//GEN-BEGIN:|3-startMIDlet|2|
    //</editor-fold>//GEN-END:|3-startMIDlet|2|

    //<editor-fold defaultstate="collapsed" desc=" Generated Method: resumeMIDlet ">//GEN-BEGIN:|4-resumeMIDlet|0|4-preAction
    /**
     * Performs an action assigned to the Mobile Device - MIDlet Resumed point.
     */
    public void resumeMIDlet() {//GEN-END:|4-resumeMIDlet|0|4-preAction
        // write pre-action user code here
//GEN-LINE:|4-resumeMIDlet|1|4-postAction
        // write post-action user code here
    }//GEN-BEGIN:|4-resumeMIDlet|2|
    //</editor-fold>//GEN-END:|4-resumeMIDlet|2|

    //<editor-fold defaultstate="collapsed" desc=" Generated Method: switchDisplayable ">//GEN-BEGIN:|5-switchDisplayable|0|5-preSwitch
    /**
     * Switches a current displayable in a display. The <code>display</code> instance is taken from <code>getDisplay</code> method. This method is used by all actions in the design for switching displayable.
     * @param alert the Alert which is temporarily set to the display; if <code>null</code>, then <code>nextDisplayable</code> is set immediately
     * @param nextDisplayable the Displayable to be set
     */
    public void switchDisplayable(Alert alert, Displayable nextDisplayable) {//GEN-END:|5-switchDisplayable|0|5-preSwitch
        // write pre-switch user code here
        Display display = getDisplay();//GEN-BEGIN:|5-switchDisplayable|1|5-postSwitch
        Displayable __currentDisplayable = display.getCurrent();
        if (__currentDisplayable != null  &&  nextDisplayable != null) {
            __previousDisplayables.put(nextDisplayable, __currentDisplayable);
        }
        if (alert == null) {
            display.setCurrent(nextDisplayable);
        } else {
            display.setCurrent(alert, nextDisplayable);
        }//GEN-END:|5-switchDisplayable|1|5-postSwitch
    // write post-switch user code here
    }//GEN-BEGIN:|5-switchDisplayable|2|
    //</editor-fold>//GEN-END:|5-switchDisplayable|2|

    //<editor-fold defaultstate="collapsed" desc=" Generated Method: commandAction for Displayables ">//GEN-BEGIN:|7-commandAction|0|7-preCommandAction
    /**
     * Called by a system to indicated that a command has been invoked on a particular displayable.
     * @param command the Command that was invoked
     * @param displayable the Displayable where the command was invoked
     */
    public void commandAction(Command command, Displayable displayable) {//GEN-END:|7-commandAction|0|7-preCommandAction
        // write pre-action user code here
        if (displayable == about) {//GEN-BEGIN:|7-commandAction|1|439-preAction
            if (command == itemCommand27) {//GEN-END:|7-commandAction|1|439-preAction
                // write pre-action user code here
                switchToPreviousDisplayable();//GEN-LINE:|7-commandAction|2|439-postAction
                // write post-action user code here
            } else if (command == itemCommand28) {//GEN-LINE:|7-commandAction|3|442-preAction
                // write pre-action user code here
//GEN-LINE:|7-commandAction|4|442-postAction
                // write post-action user code here
            }//GEN-BEGIN:|7-commandAction|5|155-preAction
        } else if (displayable == afirmacions4) {
            if (command == backCommand3) {//GEN-END:|7-commandAction|5|155-preAction
                // write pre-action user code here
                switchToPreviousDisplayable();//GEN-LINE:|7-commandAction|6|155-postAction
            // write post-action user code here
            } else if (command == itemCommand4) {//GEN-LINE:|7-commandAction|7|323-preAction
                // write pre-action user code here
                playChapter4();//GEN-LINE:|7-commandAction|8|323-postAction
            // write post-action user code here
            }//GEN-BEGIN:|7-commandAction|9|136-preAction
        } else if (displayable == alabast1) {
            if (command == backCommand) {//GEN-END:|7-commandAction|9|136-preAction
                // write pre-action user code here
                switchToPreviousDisplayable();//GEN-LINE:|7-commandAction|10|136-postAction
            // write post-action user code here
            } else if (command == itemCommand1) {//GEN-LINE:|7-commandAction|11|297-preAction
                // write pre-action user code here
                playChapter1();//GEN-LINE:|7-commandAction|12|297-postAction
            // write post-action user code here
            }//GEN-BEGIN:|7-commandAction|13|67-preAction
        } else if (displayable == alert) {
            if (command == cancelCommand) {//GEN-END:|7-commandAction|13|67-preAction
                // write pre-action user code here
                switchToPreviousDisplayable();//GEN-LINE:|7-commandAction|14|67-postAction
            // write post-action user code here
            } else if (command == okCommand) {//GEN-LINE:|7-commandAction|15|65-preAction
                // write pre-action user code here
                exitMIDlet();//GEN-LINE:|7-commandAction|16|65-postAction
            // write post-action user code here
            }//GEN-BEGIN:|7-commandAction|17|203-preAction
        } else if (displayable == aniversaris13) {
            if (command == backCommand11) {//GEN-END:|7-commandAction|17|203-preAction
                // write pre-action user code here
                switchToPreviousDisplayable();//GEN-LINE:|7-commandAction|18|203-postAction
            // write post-action user code here
            } else if (command == itemCommand13) {//GEN-LINE:|7-commandAction|19|377-preAction
                // write pre-action user code here
                playChapter13();//GEN-LINE:|7-commandAction|20|377-postAction
                // write post-action user code here
            }//GEN-BEGIN:|7-commandAction|21|217-preAction
        } else if (displayable == avisos15) {
            if (command == backCommand13) {//GEN-END:|7-commandAction|21|217-preAction
                // write pre-action user code here
                switchToPreviousDisplayable();//GEN-LINE:|7-commandAction|22|217-postAction
            // write post-action user code here
            }//GEN-BEGIN:|7-commandAction|23|183-preAction
        } else if (displayable == colors9) {
            if (command == backCommand8) {//GEN-END:|7-commandAction|23|183-preAction
                // write pre-action user code here
                switchToPreviousDisplayable();//GEN-LINE:|7-commandAction|24|183-postAction
            // write post-action user code here
            } else if (command == itemCommand9) {//GEN-LINE:|7-commandAction|25|350-preAction
                // write pre-action user code here
                playChapter9();//GEN-LINE:|7-commandAction|26|350-postAction
            // write post-action user code here
            }//GEN-BEGIN:|7-commandAction|27|255-preAction
        } else if (displayable == dias12) {
            if (command == backCommand19) {//GEN-END:|7-commandAction|27|255-preAction
                // write pre-action user code here
                switchToPreviousDisplayable();//GEN-LINE:|7-commandAction|28|255-postAction
            // write post-action user code here
            } else if (command == itemCommand12) {//GEN-LINE:|7-commandAction|29|370-preAction
                // write pre-action user code here
                playChapter12();//GEN-LINE:|7-commandAction|30|370-postAction
                // write post-action user code here
            }//GEN-BEGIN:|7-commandAction|31|165-preAction
        } else if (displayable == dubtes6) {
            if (command == backCommand5) {//GEN-END:|7-commandAction|31|165-preAction
                // write pre-action user code here
                switchToPreviousDisplayable();//GEN-LINE:|7-commandAction|32|165-postAction
            // write post-action user code here
            } else if (command == itemCommand6) {//GEN-LINE:|7-commandAction|33|335-preAction
                // write pre-action user code here
                playChapter6();//GEN-LINE:|7-commandAction|34|335-postAction
            // write post-action user code here
            }//GEN-BEGIN:|7-commandAction|35|171-preAction
        } else if (displayable == exclamacions7) {
            if (command == backCommand6) {//GEN-END:|7-commandAction|35|171-preAction
                // write pre-action user code here
                switchToPreviousDisplayable();//GEN-LINE:|7-commandAction|36|171-postAction
            // write post-action user code here
            } else if (command == itemCommand7) {//GEN-LINE:|7-commandAction|37|338-preAction
                // write pre-action user code here
                playChapter7();//GEN-LINE:|7-commandAction|38|338-postAction
            // write post-action user code here
            }//GEN-BEGIN:|7-commandAction|39|191-preAction
        } else if (displayable == expressions11) {
            if (command == backCommand9) {//GEN-END:|7-commandAction|39|191-preAction
                // write pre-action user code here
                switchToPreviousDisplayable();//GEN-LINE:|7-commandAction|40|191-postAction
            // write post-action user code here
            }//GEN-BEGIN:|7-commandAction|41|247-preAction
        } else if (displayable == familia20) {
            if (command == backCommand18) {//GEN-END:|7-commandAction|41|247-preAction
                // write pre-action user code here
                switchToPreviousDisplayable();//GEN-LINE:|7-commandAction|42|247-postAction
            // write post-action user code here
            } else if (command == itemCommand24) {//GEN-LINE:|7-commandAction|43|424-preAction
                // write pre-action user code here
                playChapter20();//GEN-LINE:|7-commandAction|44|424-postAction
                // write post-action user code here
            }//GEN-BEGIN:|7-commandAction|45|227-preAction
        } else if (displayable == feina17) {
            if (command == backCommand15) {//GEN-END:|7-commandAction|45|227-preAction
                // write pre-action user code here
                switchToPreviousDisplayable();//GEN-LINE:|7-commandAction|46|227-postAction
            // write post-action user code here
            } else if (command == itemCommand20) {//GEN-LINE:|7-commandAction|47|406-preAction
                // write pre-action user code here
                playChapter17();//GEN-LINE:|7-commandAction|48|406-postAction
                // write post-action user code here
            }//GEN-BEGIN:|7-commandAction|49|264-preAction
        } else if (displayable == festes21) {
            if (command == backCommand21) {//GEN-END:|7-commandAction|49|264-preAction
                // write pre-action user code here
                switchToPreviousDisplayable();//GEN-LINE:|7-commandAction|50|264-postAction
            // write post-action user code here
            } else if (command == itemCommand25) {//GEN-LINE:|7-commandAction|51|430-preAction
                // write pre-action user code here
                playChapter21();//GEN-LINE:|7-commandAction|52|430-postAction
                // write post-action user code here
            }//GEN-BEGIN:|7-commandAction|53|19-preAction
        } else if (displayable == form) {
            if (command == exitCommand) {//GEN-END:|7-commandAction|53|19-preAction
                // write pre-action user code here
                switchDisplayable(null, getAlert());//GEN-LINE:|7-commandAction|54|19-postAction
            // write post-action user code here
            }//GEN-BEGIN:|7-commandAction|55|235-preAction
        } else if (displayable == localitzacions18) {
            if (command == backCommand16) {//GEN-END:|7-commandAction|55|235-preAction
                // write pre-action user code here
                switchToPreviousDisplayable();//GEN-LINE:|7-commandAction|56|235-postAction
            // write post-action user code here
            } else if (command == itemCommand22) {//GEN-LINE:|7-commandAction|57|412-preAction
                // write pre-action user code here
                playChapter18();//GEN-LINE:|7-commandAction|58|412-postAction
                // write post-action user code here
            }//GEN-BEGIN:|7-commandAction|59|160-preAction
        } else if (displayable == negacions5) {
            if (command == backCommand4) {//GEN-END:|7-commandAction|59|160-preAction
                // write pre-action user code here
                switchToPreviousDisplayable();//GEN-LINE:|7-commandAction|60|160-postAction
            // write post-action user code here
            } else if (command == itemCommand5) {//GEN-LINE:|7-commandAction|61|329-preAction
                // write pre-action user code here
                playChapter5();//GEN-LINE:|7-commandAction|62|329-postAction
            // write post-action user code here
            }//GEN-BEGIN:|7-commandAction|63|259-preAction
        } else if (displayable == numerals10) {
            if (command == backCommand20) {//GEN-END:|7-commandAction|63|259-preAction
                // write pre-action user code here
                switchToPreviousDisplayable();//GEN-LINE:|7-commandAction|64|259-postAction
            // write post-action user code here
            } else if (command == itemCommand10) {//GEN-LINE:|7-commandAction|65|356-preAction
                // write pre-action user code here
                playChapter10();//GEN-LINE:|7-commandAction|66|356-postAction
            // write post-action user code here
            }//GEN-BEGIN:|7-commandAction|67|221-preAction
        } else if (displayable == oferta16) {
            if (command == backCommand14) {//GEN-END:|7-commandAction|67|221-preAction
                // write pre-action user code here
                switchToPreviousDisplayable();//GEN-LINE:|7-commandAction|68|221-postAction
            // write post-action user code here
            }//GEN-BEGIN:|7-commandAction|69|150-preAction
        } else if (displayable == preguntesusuals3) {
            if (command == backCommand2) {//GEN-END:|7-commandAction|69|150-preAction
                // write pre-action user code here
                switchToPreviousDisplayable();//GEN-LINE:|7-commandAction|70|150-postAction
            // write post-action user code here
            } else if (command == itemCommand3) {//GEN-LINE:|7-commandAction|71|315-preAction
                // write pre-action user code here
                playChapter3();//GEN-LINE:|7-commandAction|72|315-postAction
            // write post-action user code here
            }//GEN-BEGIN:|7-commandAction|73|178-preAction
        } else if (displayable == qualitats8) {
            if (command == backCommand7) {//GEN-END:|7-commandAction|73|178-preAction
                // write pre-action user code here
                switchToPreviousDisplayable();//GEN-LINE:|7-commandAction|74|178-postAction
            // write post-action user code here
            } else if (command == itemCommand8) {//GEN-LINE:|7-commandAction|75|344-preAction
                // write pre-action user code here
                playChapter8();//GEN-LINE:|7-commandAction|76|344-postAction
            // write post-action user code here
            }//GEN-BEGIN:|7-commandAction|77|142-preAction
        } else if (displayable == salutacions2) {
            if (command == backCommand1) {//GEN-END:|7-commandAction|77|142-preAction
                // write pre-action user code here
                switchToPreviousDisplayable();//GEN-LINE:|7-commandAction|78|142-postAction
            // write post-action user code here
            } else if (command == itemCommand2) {//GEN-LINE:|7-commandAction|79|308-preAction
                // write pre-action user code here
                playChapter2();//GEN-LINE:|7-commandAction|80|308-postAction
            // write post-action user code here
            }//GEN-BEGIN:|7-commandAction|81|24-preAction
        } else if (displayable == splashScreen) {
            if (command == SplashScreen.DISMISS_COMMAND) {//GEN-END:|7-commandAction|81|24-preAction
                // write pre-action user code here
                switchDisplayable(null, getForm());//GEN-LINE:|7-commandAction|82|24-postAction
            // write post-action user code here
            }//GEN-BEGIN:|7-commandAction|83|209-preAction
        } else if (displayable == temps14) {
            if (command == backCommand12) {//GEN-END:|7-commandAction|83|209-preAction
                // write pre-action user code here
                switchToPreviousDisplayable();//GEN-LINE:|7-commandAction|84|209-postAction
            // write post-action user code here
            } else if (command == itemCommand14) {//GEN-LINE:|7-commandAction|85|383-preAction
                // write pre-action user code here
                playChapter14();//GEN-LINE:|7-commandAction|86|383-postAction
                // write post-action user code here
            }//GEN-BEGIN:|7-commandAction|87|241-preAction
        } else if (displayable == transports19) {
            if (command == backCommand17) {//GEN-END:|7-commandAction|87|241-preAction
                // write pre-action user code here
                switchToPreviousDisplayable();//GEN-LINE:|7-commandAction|88|241-postAction
            // write post-action user code here
            } else if (command == itemCommand23) {//GEN-LINE:|7-commandAction|89|420-preAction
                // write pre-action user code here
                playChapter19();//GEN-LINE:|7-commandAction|90|420-postAction
                // write post-action user code here
            }//GEN-BEGIN:|7-commandAction|91|7-postCommandAction
        }//GEN-END:|7-commandAction|91|7-postCommandAction
    // write post-action user code here
    }//GEN-BEGIN:|7-commandAction|92|
    //</editor-fold>//GEN-END:|7-commandAction|92|






    //<editor-fold defaultstate="collapsed" desc=" Generated Getter: exitCommand ">//GEN-BEGIN:|18-getter|0|18-preInit
    /**
     * Returns an initiliazed instance of exitCommand component.
     * @return the initialized component instance
     */
    public Command getExitCommand() {
        if (exitCommand == null) {//GEN-END:|18-getter|0|18-preInit
            // write pre-init user code here
            exitCommand = new Command("Salir", Command.EXIT, 0);//GEN-LINE:|18-getter|1|18-postInit
        // write post-init user code here
        }//GEN-BEGIN:|18-getter|2|
        return exitCommand;
    }
    //</editor-fold>//GEN-END:|18-getter|2|

    //<editor-fold defaultstate="collapsed" desc=" Generated Getter: form ">//GEN-BEGIN:|14-getter|0|14-preInit
    /**
     * Returns an initiliazed instance of form component.
     * @return the initialized component instance
     */
    public Form getForm() {
        if (form == null) {//GEN-END:|14-getter|0|14-preInit
            // write pre-init user code here
            form = new Form("Catal\u00E0 Mobile Edition", new Item[] { getTableItem(), getSpacer() });//GEN-BEGIN:|14-getter|1|14-postInit
            form.addCommand(getExitCommand());
            form.setCommandListener(this);//GEN-END:|14-getter|1|14-postInit
        // write post-init user code here
        }//GEN-BEGIN:|14-getter|2|
        return form;
    }
    //</editor-fold>//GEN-END:|14-getter|2|

    //<editor-fold defaultstate="collapsed" desc=" Generated Getter: splashScreen ">//GEN-BEGIN:|22-getter|0|22-preInit
    /**
     * Returns an initiliazed instance of splashScreen component.
     * @return the initialized component instance
     */
    public SplashScreen getSplashScreen() {
        if (splashScreen == null) {//GEN-END:|22-getter|0|22-preInit
            // write pre-init user code here
            splashScreen = new SplashScreen(getDisplay());//GEN-BEGIN:|22-getter|1|22-postInit
            splashScreen.setTitle("Bienvenido a Catal\u00E0 ME");
            splashScreen.setCommandListener(this);
            splashScreen.setFullScreenMode(true);
            splashScreen.setImage(getImage1());
            splashScreen.setText("Presione una tecla...");//GEN-END:|22-getter|1|22-postInit
        // write post-init user code here
        }//GEN-BEGIN:|22-getter|2|
        return splashScreen;
    }
    //</editor-fold>//GEN-END:|22-getter|2|

    //<editor-fold defaultstate="collapsed" desc=" Generated Getter: tableItem ">//GEN-BEGIN:|31-getter|0|31-preInit
    /**
     * Returns an initiliazed instance of tableItem component.
     * @return the initialized component instance
     */
    public TableItem getTableItem() {
        if (tableItem == null) {//GEN-END:|31-getter|0|31-preInit
            // write pre-init user code here
            tableItem = new TableItem(getDisplay(), "Comunicaci\u00F3n b\u00E1sica en lengua catalana");//GEN-BEGIN:|31-getter|1|31-postInit
            tableItem.setPreferredSize(240, -1);
            tableItem.addCommand(getItemCommand());
            tableItem.setItemCommandListener(this);
            tableItem.setDefaultCommand(getItemCommand());
            tableItem.setLayout(ImageItem.LAYOUT_DEFAULT | Item.LAYOUT_TOP | Item.LAYOUT_BOTTOM | Item.LAYOUT_VCENTER | Item.LAYOUT_SHRINK | Item.LAYOUT_VEXPAND | Item.LAYOUT_2);
            tableItem.setModel(getTableModel());
            tableItem.setBorders(false);
            tableItem.setValuesFont(getFont1());//GEN-END:|31-getter|1|31-postInit
        // write post-init user code here
        }//GEN-BEGIN:|31-getter|2|
        return tableItem;
    }
    //</editor-fold>//GEN-END:|31-getter|2|

    //<editor-fold defaultstate="collapsed" desc=" Generated Getter: tableModel ">//GEN-BEGIN:|32-getter|0|32-preInit
    /**
     * Returns an initiliazed instance of tableModel component.
     * @return the initialized component instance
     */
    public SimpleTableModel getTableModel() {
        if (tableModel == null) {//GEN-END:|32-getter|0|32-preInit
            // write pre-init user code here
            tableModel = new SimpleTableModel(new java.lang.String[][] {//GEN-BEGIN:|32-getter|1|32-postInit
                new java.lang.String[] { "A L\u2019ABAST ", "A SU ALCANCE ", "1" },
                new java.lang.String[] { "SALUTACIONS I F\u00D3RMULES DE CORTESIA ", "SALUDOS Y F\u00D3RMULAS DE CORTES\u00CDA ", "2" },
                new java.lang.String[] { "PREGUNTES USUALS", "PREGUNTAS USUALES ", "3" },
                new java.lang.String[] { "AFIRMACIONS ", "AFIRMACIONES", "4" },
                new java.lang.String[] { "NEGACIONS ", "NEGACIONES ", "5" },
                new java.lang.String[] { "DUBTES", "DUDAS ", "6" },
                new java.lang.String[] { "EXCLAMACIONS I EXPRESSIONS DIVERSES ", "EXCLAMACIONES Y EXPRESIONES DIVERSAS ", "7" },
                new java.lang.String[] { "QUALITATS, ESTATS, PREFER\u00C8NCIES ", "CUALIDADES, ESTADOS, PREFERENCIAS ", "8" },
                new java.lang.String[] { "COLORS ", "COLORES ", "9" },
                new java.lang.String[] { "NUMERALS ", "NUMERALES ", "10" },
                new java.lang.String[] { "EXPRESSIONS TEMPORALS ", "EXPRESIONES TEMPORALES ", "11" },
                new java.lang.String[] { "DIES, MESOS, ESTACIONS, PUNTS CARDINALS ", "D\u00CDAS, MESES, ESTACIONES, PUNTOS CARDINALES ", "12" },
                new java.lang.String[] { "EDAT, ANIVERSARIS ", "EDAD, ANIVERSARIOS ", "13" },
                new java.lang.String[] { "TEMPS ", "TIEMPO ", "14" },
                new java.lang.String[] { "AVISOS I CARTELLS PUBLICITARIS ", "AVISOS Y CARTELES PUBLICITARIOS ", "15" },
                new java.lang.String[] { "OFERTA I DEMANDA ", "OFERTA Y DEMANDA ", "16" },
                new java.lang.String[] { "FEINA, ESTUDIS, PROFESSIONS ", "TRABAJO, ESTUDIOS, PROFESIONES ", "17" },
                new java.lang.String[] { "LOCALITZACIONS ", "LOCALIZACIONES ", "18" },
                new java.lang.String[] { "TRANSPORTS", "TRANSPORTES ", "19" },
                new java.lang.String[] { "FAM\u00CDLIA, ESTAT CIVIL I HABITATGE ", "FAMILIA, ESTADO CIVIL Y VIVIENDA ", "20" },
                new java.lang.String[] { "FESTES I FELICITACIONS ", "FIESTAS Y FELICITACIONES ", "21" }}, new java.lang.String[] { "Catal\u00E0", "Espa\u00F1ol", "Cap\u00EDtulo" });//GEN-END:|32-getter|1|32-postInit
        // write post-init user code here
        }//GEN-BEGIN:|32-getter|2|
        return tableModel;
    }
    //</editor-fold>//GEN-END:|32-getter|2|

    //<editor-fold defaultstate="collapsed" desc=" Generated Getter: image1 ">//GEN-BEGIN:|54-getter|0|54-preInit
    /**
     * Returns an initiliazed instance of image1 component.
     * @return the initialized component instance
     */
    public Image getImage1() {
        if (image1 == null) {//GEN-END:|54-getter|0|54-preInit
            // write pre-init user code here
            try {//GEN-BEGIN:|54-getter|1|54-@java.io.IOException
                image1 = Image.createImage("/CatalaME.png");
            } catch (java.io.IOException e) {//GEN-END:|54-getter|1|54-@java.io.IOException
                e.printStackTrace();
            }//GEN-LINE:|54-getter|2|54-postInit
        // write post-init user code here
        }//GEN-BEGIN:|54-getter|3|
        return image1;
    }
    //</editor-fold>//GEN-END:|54-getter|3|

    //<editor-fold defaultstate="collapsed" desc=" Generated Getter: okCommand ">//GEN-BEGIN:|64-getter|0|64-preInit
    /**
     * Returns an initiliazed instance of okCommand component.
     * @return the initialized component instance
     */
    public Command getOkCommand() {
        if (okCommand == null) {//GEN-END:|64-getter|0|64-preInit
            // write pre-init user code here
            okCommand = new Command("Ok", Command.EXIT, 0);//GEN-LINE:|64-getter|1|64-postInit
        // write post-init user code here
        }//GEN-BEGIN:|64-getter|2|
        return okCommand;
    }
    //</editor-fold>//GEN-END:|64-getter|2|

    //<editor-fold defaultstate="collapsed" desc=" Generated Getter: cancelCommand ">//GEN-BEGIN:|66-getter|0|66-preInit
    /**
     * Returns an initiliazed instance of cancelCommand component.
     * @return the initialized component instance
     */
    public Command getCancelCommand() {
        if (cancelCommand == null) {//GEN-END:|66-getter|0|66-preInit
            // write pre-init user code here
            cancelCommand = new Command("Cancel", Command.CANCEL, 0);//GEN-LINE:|66-getter|1|66-postInit
        // write post-init user code here
        }//GEN-BEGIN:|66-getter|2|
        return cancelCommand;
    }
    //</editor-fold>//GEN-END:|66-getter|2|

    //<editor-fold defaultstate="collapsed" desc=" Generated Getter: alert ">//GEN-BEGIN:|63-getter|0|63-preInit
    /**
     * Returns an initiliazed instance of alert component.
     * @return the initialized component instance
     */
    public Alert getAlert() {
        if (alert == null) {//GEN-END:|63-getter|0|63-preInit
            // write pre-init user code here
            alert = new Alert("Cerrar Catal\u00E0ME", "\u00A1Se cerrar\u00E1 Catal\u00E1ME!\n\u00BFDesea continuar con esta acci\u00F3n?", null, AlertType.WARNING);//GEN-BEGIN:|63-getter|1|63-postInit
            alert.addCommand(getOkCommand());
            alert.addCommand(getCancelCommand());
            alert.setCommandListener(this);
            alert.setTimeout(Alert.FOREVER);//GEN-END:|63-getter|1|63-postInit
        // write post-init user code here
        }//GEN-BEGIN:|63-getter|2|
        return alert;
    }
    //</editor-fold>//GEN-END:|63-getter|2|

    //<editor-fold defaultstate="collapsed" desc=" Generated Method: commandAction for Items ">//GEN-BEGIN:|17-itemCommandAction|0|17-preItemCommandAction
    /**
     * Called by a system to indicated that a command has been invoked on a particular item.
     * @param command the Command that was invoked
     * @param displayable the Item where the command was invoked
     */
    public void commandAction(Command command, Item item) {//GEN-END:|17-itemCommandAction|0|17-preItemCommandAction
        // write pre-action user code here
        if (item == tableItem) {//GEN-BEGIN:|17-itemCommandAction|1|77-preAction
            if (command == itemCommand) {//GEN-END:|17-itemCommandAction|1|77-preAction
                // write pre-action user code here
                method();//GEN-LINE:|17-itemCommandAction|2|77-postAction
            // write post-action user code here
            }//GEN-BEGIN:|17-itemCommandAction|3|364-preAction
        } else if (item == tableItem11) {
            if (command == itemCommand11) {//GEN-END:|17-itemCommandAction|3|364-preAction
                // write pre-action user code here
                playChapter11();//GEN-LINE:|17-itemCommandAction|4|364-postAction
            // write post-action user code here
            }//GEN-BEGIN:|17-itemCommandAction|5|390-preAction
        } else if (item == tableItem15) {
            if (command == itemCommand16) {//GEN-END:|17-itemCommandAction|5|390-preAction
                // write pre-action user code here
                playChapter15();//GEN-LINE:|17-itemCommandAction|6|390-postAction
                // write post-action user code here
            }//GEN-BEGIN:|17-itemCommandAction|7|396-preAction
        } else if (item == tableItem16) {
            if (command == itemCommand17) {//GEN-END:|17-itemCommandAction|7|396-preAction
                // write pre-action user code here
                playChapter16();//GEN-LINE:|17-itemCommandAction|8|396-postAction
                // write post-action user code here
            }//GEN-BEGIN:|17-itemCommandAction|9|17-postItemCommandAction
        }//GEN-END:|17-itemCommandAction|9|17-postItemCommandAction
    // write post-action user code here
    }//GEN-BEGIN:|17-itemCommandAction|10|
    //</editor-fold>//GEN-END:|17-itemCommandAction|10|


    //<editor-fold defaultstate="collapsed" desc=" Generated Getter: itemCommand ">//GEN-BEGIN:|76-getter|0|76-preInit
    /**
     * Returns an initiliazed instance of itemCommand component.
     * @return the initialized component instance
     */
    public Command getItemCommand() {
        if (itemCommand == null) {//GEN-END:|76-getter|0|76-preInit
            // write pre-init user code here
            itemCommand = new Command("IR", Command.ITEM, 0);//GEN-LINE:|76-getter|1|76-postInit
        // write post-init user code here
        }//GEN-BEGIN:|76-getter|2|
        return itemCommand;
    }
    //</editor-fold>//GEN-END:|76-getter|2|

    //<editor-fold defaultstate="collapsed" desc=" Generated Getter: font1 ">//GEN-BEGIN:|110-getter|0|110-preInit
    /**
     * Returns an initiliazed instance of font1 component.
     * @return the initialized component instance
     */
    public Font getFont1() {
        if (font1 == null) {//GEN-END:|110-getter|0|110-preInit
            // write pre-init user code here
            font1 = Font.getFont(Font.FACE_SYSTEM, Font.STYLE_PLAIN, Font.SIZE_SMALL);//GEN-LINE:|110-getter|1|110-postInit
        // write post-init user code here
        }//GEN-BEGIN:|110-getter|2|
        return font1;
    }
    //</editor-fold>//GEN-END:|110-getter|2|

    //<editor-fold defaultstate="collapsed" desc=" Generated Method: method ">//GEN-BEGIN:|111-switch|0|111-preSwitch
    /**
     * Performs an action assigned to the method switch-point.
     */
    public void method() {//GEN-END:|111-switch|0|111-preSwitch
        // enter pre-switch user code here
        switch (getMainTableRow()) {//GEN-BEGIN:|111-switch|1|112-preAction
            case 0://GEN-END:|111-switch|1|112-preAction
                // write pre-action user code here
                switchDisplayable(null, getAlabast1());//GEN-LINE:|111-switch|2|112-postAction
                // write post-action user code here
                break;//GEN-BEGIN:|111-switch|3|113-preAction
            case 1://GEN-END:|111-switch|3|113-preAction
                // write pre-action user code here
                switchDisplayable(null, getSalutacions2());//GEN-LINE:|111-switch|4|113-postAction
                // write post-action user code here
                break;//GEN-BEGIN:|111-switch|5|114-preAction
            case 2://GEN-END:|111-switch|5|114-preAction
                // write pre-action user code here
                switchDisplayable(null, getPreguntesusuals3());//GEN-LINE:|111-switch|6|114-postAction
                // write post-action user code here
                break;//GEN-BEGIN:|111-switch|7|115-preAction
            case 3://GEN-END:|111-switch|7|115-preAction
                // write pre-action user code here
                switchDisplayable(null, getAfirmacions4());//GEN-LINE:|111-switch|8|115-postAction
                // write post-action user code here
                break;//GEN-BEGIN:|111-switch|9|116-preAction
            case 4://GEN-END:|111-switch|9|116-preAction
                // write pre-action user code here
                switchDisplayable(null, getNegacions5());//GEN-LINE:|111-switch|10|116-postAction
                // write post-action user code here
                break;//GEN-BEGIN:|111-switch|11|117-preAction
            case 5://GEN-END:|111-switch|11|117-preAction
                // write pre-action user code here
                switchDisplayable(null, getDubtes6());//GEN-LINE:|111-switch|12|117-postAction
                // write post-action user code here
                break;//GEN-BEGIN:|111-switch|13|118-preAction
            case 6://GEN-END:|111-switch|13|118-preAction
                // write pre-action user code here
                switchDisplayable(null, getExclamacions7());//GEN-LINE:|111-switch|14|118-postAction
                // write post-action user code here
                break;//GEN-BEGIN:|111-switch|15|119-preAction
            case 7://GEN-END:|111-switch|15|119-preAction
                // write pre-action user code here
                switchDisplayable(null, getQualitats8());//GEN-LINE:|111-switch|16|119-postAction
                // write post-action user code here
                break;//GEN-BEGIN:|111-switch|17|120-preAction
            case 8://GEN-END:|111-switch|17|120-preAction
                // write pre-action user code here
                switchDisplayable(null, getColors9());//GEN-LINE:|111-switch|18|120-postAction
                // write post-action user code here
                break;//GEN-BEGIN:|111-switch|19|121-preAction
            case 9://GEN-END:|111-switch|19|121-preAction
                // write pre-action user code here
                switchDisplayable(null, getNumerals10());//GEN-LINE:|111-switch|20|121-postAction
                // write post-action user code here
                break;//GEN-BEGIN:|111-switch|21|122-preAction
            case 10://GEN-END:|111-switch|21|122-preAction
                // write pre-action user code here
                switchDisplayable(null, getExpressions11());//GEN-LINE:|111-switch|22|122-postAction
                // write post-action user code here
                break;//GEN-BEGIN:|111-switch|23|123-preAction
            case 11://GEN-END:|111-switch|23|123-preAction
                // write pre-action user code here
                switchDisplayable(null, getDias12());//GEN-LINE:|111-switch|24|123-postAction
                // write post-action user code here
                break;//GEN-BEGIN:|111-switch|25|124-preAction
            case 12://GEN-END:|111-switch|25|124-preAction
                // write pre-action user code here
                switchDisplayable(null, getAniversaris13());//GEN-LINE:|111-switch|26|124-postAction
                // write post-action user code here
                break;//GEN-BEGIN:|111-switch|27|125-preAction
            case 13://GEN-END:|111-switch|27|125-preAction
                // write pre-action user code here
                switchDisplayable(null, getTemps14());//GEN-LINE:|111-switch|28|125-postAction
                // write post-action user code here
                break;//GEN-BEGIN:|111-switch|29|126-preAction
            case 14://GEN-END:|111-switch|29|126-preAction
                // write pre-action user code here
                switchDisplayable(null, getAvisos15());//GEN-LINE:|111-switch|30|126-postAction
                // write post-action user code here
                break;//GEN-BEGIN:|111-switch|31|127-preAction
            case 15://GEN-END:|111-switch|31|127-preAction
                // write pre-action user code here
                switchDisplayable(null, getOferta16());//GEN-LINE:|111-switch|32|127-postAction
                // write post-action user code here
                break;//GEN-BEGIN:|111-switch|33|128-preAction
            case 16://GEN-END:|111-switch|33|128-preAction
                // write pre-action user code here
                switchDisplayable(null, getFeina17());//GEN-LINE:|111-switch|34|128-postAction
                // write post-action user code here
                break;//GEN-BEGIN:|111-switch|35|129-preAction
            case 17://GEN-END:|111-switch|35|129-preAction
                // write pre-action user code here
                switchDisplayable(null, getLocalitzacions18());//GEN-LINE:|111-switch|36|129-postAction
                // write post-action user code here
                break;//GEN-BEGIN:|111-switch|37|130-preAction
            case 18://GEN-END:|111-switch|37|130-preAction
                // write pre-action user code here
                switchDisplayable(null, getTransports19());//GEN-LINE:|111-switch|38|130-postAction
                // write post-action user code here
                break;//GEN-BEGIN:|111-switch|39|131-preAction
            case 19://GEN-END:|111-switch|39|131-preAction
                // write pre-action user code here
                switchDisplayable(null, getFamilia20());//GEN-LINE:|111-switch|40|131-postAction
                // write post-action user code here
                break;//GEN-BEGIN:|111-switch|41|132-preAction
            case 20://GEN-END:|111-switch|41|132-preAction
                // write pre-action user code here
                switchDisplayable(null, getFestes21());//GEN-LINE:|111-switch|42|132-postAction
                // write post-action user code here
                break;//GEN-BEGIN:|111-switch|43|111-postSwitch
        }//GEN-END:|111-switch|43|111-postSwitch
    // enter post-switch user code here
    }//GEN-BEGIN:|111-switch|44|
    //</editor-fold>//GEN-END:|111-switch|44|

    //<editor-fold defaultstate="collapsed" desc=" Generated Getter: backCommand ">//GEN-BEGIN:|135-getter|0|135-preInit
    /**
     * Returns an initiliazed instance of backCommand component.
     * @return the initialized component instance
     */
    public Command getBackCommand() {
        if (backCommand == null) {//GEN-END:|135-getter|0|135-preInit
            // write pre-init user code here
            backCommand = new Command("Back", Command.BACK, 0);//GEN-LINE:|135-getter|1|135-postInit
        // write post-init user code here
        }//GEN-BEGIN:|135-getter|2|
        return backCommand;
    }
    //</editor-fold>//GEN-END:|135-getter|2|

    //<editor-fold defaultstate="collapsed" desc=" Generated Getter: alabast1 ">//GEN-BEGIN:|134-getter|0|134-preInit
    /**
     * Returns an initiliazed instance of alabast1 component.
     * @return the initialized component instance
     */
    public Form getAlabast1() {
        if (alabast1 == null) {//GEN-END:|134-getter|0|134-preInit
            // write pre-init user code here
            alabast1 = new Form("A L\u2019ABAST  - A SU ALCANCE", new Item[] { getTableItem1() });//GEN-BEGIN:|134-getter|1|134-postInit
            alabast1.addCommand(getBackCommand());
            alabast1.addCommand(getItemCommand1());
            alabast1.setCommandListener(this);//GEN-END:|134-getter|1|134-postInit
        // write post-init user code here
        }//GEN-BEGIN:|134-getter|2|
        return alabast1;
    }
    //</editor-fold>//GEN-END:|134-getter|2|

    //<editor-fold defaultstate="collapsed" desc=" Generated Getter: backCommand1 ">//GEN-BEGIN:|141-getter|0|141-preInit
    /**
     * Returns an initiliazed instance of backCommand1 component.
     * @return the initialized component instance
     */
    public Command getBackCommand1() {
        if (backCommand1 == null) {//GEN-END:|141-getter|0|141-preInit
            // write pre-init user code here
            backCommand1 = new Command("Back", Command.BACK, 0);//GEN-LINE:|141-getter|1|141-postInit
        // write post-init user code here
        }//GEN-BEGIN:|141-getter|2|
        return backCommand1;
    }
    //</editor-fold>//GEN-END:|141-getter|2|

    //<editor-fold defaultstate="collapsed" desc=" Generated Getter: salutacions2 ">//GEN-BEGIN:|140-getter|0|140-preInit
    /**
     * Returns an initiliazed instance of salutacions2 component.
     * @return the initialized component instance
     */
    public Form getSalutacions2() {
        if (salutacions2 == null) {//GEN-END:|140-getter|0|140-preInit
            // write pre-init user code here
            salutacions2 = new Form("SALUTACIONS I F\u00D3RMULES DE CORTESIA  -  SALUDOS Y F\u00D3RMULAS DE CORTES\u00CDA", new Item[] { getTableItem2() });//GEN-BEGIN:|140-getter|1|140-postInit
            salutacions2.addCommand(getBackCommand1());
            salutacions2.addCommand(getItemCommand2());
            salutacions2.setCommandListener(this);//GEN-END:|140-getter|1|140-postInit
        // write post-init user code here
        }//GEN-BEGIN:|140-getter|2|
        return salutacions2;
    }
    //</editor-fold>//GEN-END:|140-getter|2|

    //<editor-fold defaultstate="collapsed" desc=" Generated Getter: backCommand2 ">//GEN-BEGIN:|149-getter|0|149-preInit
    /**
     * Returns an initiliazed instance of backCommand2 component.
     * @return the initialized component instance
     */
    public Command getBackCommand2() {
        if (backCommand2 == null) {//GEN-END:|149-getter|0|149-preInit
            // write pre-init user code here
            backCommand2 = new Command("Back", Command.BACK, 0);//GEN-LINE:|149-getter|1|149-postInit
        // write post-init user code here
        }//GEN-BEGIN:|149-getter|2|
        return backCommand2;
    }
    //</editor-fold>//GEN-END:|149-getter|2|

    //<editor-fold defaultstate="collapsed" desc=" Generated Getter: preguntesusuals3 ">//GEN-BEGIN:|146-getter|0|146-preInit
    /**
     * Returns an initiliazed instance of preguntesusuals3 component.
     * @return the initialized component instance
     */
    public Form getPreguntesusuals3() {
        if (preguntesusuals3 == null) {//GEN-END:|146-getter|0|146-preInit
            // write pre-init user code here
            preguntesusuals3 = new Form("PREGUNTES USUALS - PREGUNTAS USUALES", new Item[] { getTableItem3() });//GEN-BEGIN:|146-getter|1|146-postInit
            preguntesusuals3.addCommand(getBackCommand2());
            preguntesusuals3.addCommand(getItemCommand3());
            preguntesusuals3.setCommandListener(this);//GEN-END:|146-getter|1|146-postInit
        // write post-init user code here
        }//GEN-BEGIN:|146-getter|2|
        return preguntesusuals3;
    }
    //</editor-fold>//GEN-END:|146-getter|2|

    //<editor-fold defaultstate="collapsed" desc=" Generated Getter: afirmacions4 ">//GEN-BEGIN:|147-getter|0|147-preInit
    /**
     * Returns an initiliazed instance of afirmacions4 component.
     * @return the initialized component instance
     */
    public Form getAfirmacions4() {
        if (afirmacions4 == null) {//GEN-END:|147-getter|0|147-preInit
            // write pre-init user code here
            afirmacions4 = new Form("AFIRMACIONS - AFIRMACIONES", new Item[] { getTableItem4() });//GEN-BEGIN:|147-getter|1|147-postInit
            afirmacions4.addCommand(getBackCommand3());
            afirmacions4.addCommand(getItemCommand4());
            afirmacions4.setCommandListener(this);//GEN-END:|147-getter|1|147-postInit
        // write post-init user code here
        }//GEN-BEGIN:|147-getter|2|
        return afirmacions4;
    }
    //</editor-fold>//GEN-END:|147-getter|2|

    //<editor-fold defaultstate="collapsed" desc=" Generated Getter: backCommand3 ">//GEN-BEGIN:|154-getter|0|154-preInit
    /**
     * Returns an initiliazed instance of backCommand3 component.
     * @return the initialized component instance
     */
    public Command getBackCommand3() {
        if (backCommand3 == null) {//GEN-END:|154-getter|0|154-preInit
            // write pre-init user code here
            backCommand3 = new Command("Back", Command.BACK, 0);//GEN-LINE:|154-getter|1|154-postInit
        // write post-init user code here
        }//GEN-BEGIN:|154-getter|2|
        return backCommand3;
    }
    //</editor-fold>//GEN-END:|154-getter|2|

    //<editor-fold defaultstate="collapsed" desc=" Generated Getter: okCommand4 ">//GEN-BEGIN:|156-getter|0|156-preInit
    /**
     * Returns an initiliazed instance of okCommand4 component.
     * @return the initialized component instance
     */
    public Command getOkCommand4() {
        if (okCommand4 == null) {//GEN-END:|156-getter|0|156-preInit
            // write pre-init user code here
            okCommand4 = new Command("Ok", Command.OK, 0);//GEN-LINE:|156-getter|1|156-postInit
        // write post-init user code here
        }//GEN-BEGIN:|156-getter|2|
        return okCommand4;
    }
    //</editor-fold>//GEN-END:|156-getter|2|

    //<editor-fold defaultstate="collapsed" desc=" Generated Getter: backCommand4 ">//GEN-BEGIN:|159-getter|0|159-preInit
    /**
     * Returns an initiliazed instance of backCommand4 component.
     * @return the initialized component instance
     */
    public Command getBackCommand4() {
        if (backCommand4 == null) {//GEN-END:|159-getter|0|159-preInit
            // write pre-init user code here
            backCommand4 = new Command("Back", Command.BACK, 0);//GEN-LINE:|159-getter|1|159-postInit
        // write post-init user code here
        }//GEN-BEGIN:|159-getter|2|
        return backCommand4;
    }
    //</editor-fold>//GEN-END:|159-getter|2|

    //<editor-fold defaultstate="collapsed" desc=" Generated Getter: negacions5 ">//GEN-BEGIN:|158-getter|0|158-preInit
    /**
     * Returns an initiliazed instance of negacions5 component.
     * @return the initialized component instance
     */
    public Form getNegacions5() {
        if (negacions5 == null) {//GEN-END:|158-getter|0|158-preInit
            // write pre-init user code here
            negacions5 = new Form("NEGACIONS - NEGACIONES", new Item[] { getTableItem5() });//GEN-BEGIN:|158-getter|1|158-postInit
            negacions5.addCommand(getBackCommand4());
            negacions5.addCommand(getItemCommand5());
            negacions5.setCommandListener(this);//GEN-END:|158-getter|1|158-postInit
        // write post-init user code here
        }//GEN-BEGIN:|158-getter|2|
        return negacions5;
    }
    //</editor-fold>//GEN-END:|158-getter|2|

    //<editor-fold defaultstate="collapsed" desc=" Generated Getter: backCommand5 ">//GEN-BEGIN:|164-getter|0|164-preInit
    /**
     * Returns an initiliazed instance of backCommand5 component.
     * @return the initialized component instance
     */
    public Command getBackCommand5() {
        if (backCommand5 == null) {//GEN-END:|164-getter|0|164-preInit
            // write pre-init user code here
            backCommand5 = new Command("Back", Command.BACK, 0);//GEN-LINE:|164-getter|1|164-postInit
        // write post-init user code here
        }//GEN-BEGIN:|164-getter|2|
        return backCommand5;
    }
    //</editor-fold>//GEN-END:|164-getter|2|

    //<editor-fold defaultstate="collapsed" desc=" Generated Getter: okCommand5 ">//GEN-BEGIN:|166-getter|0|166-preInit
    /**
     * Returns an initiliazed instance of okCommand5 component.
     * @return the initialized component instance
     */
    public Command getOkCommand5() {
        if (okCommand5 == null) {//GEN-END:|166-getter|0|166-preInit
            // write pre-init user code here
            okCommand5 = new Command("Ok", Command.OK, 0);//GEN-LINE:|166-getter|1|166-postInit
        // write post-init user code here
        }//GEN-BEGIN:|166-getter|2|
        return okCommand5;
    }
    //</editor-fold>//GEN-END:|166-getter|2|

    //<editor-fold defaultstate="collapsed" desc=" Generated Getter: backCommand6 ">//GEN-BEGIN:|170-getter|0|170-preInit
    /**
     * Returns an initiliazed instance of backCommand6 component.
     * @return the initialized component instance
     */
    public Command getBackCommand6() {
        if (backCommand6 == null) {//GEN-END:|170-getter|0|170-preInit
            // write pre-init user code here
            backCommand6 = new Command("Back", Command.BACK, 0);//GEN-LINE:|170-getter|1|170-postInit
        // write post-init user code here
        }//GEN-BEGIN:|170-getter|2|
        return backCommand6;
    }
    //</editor-fold>//GEN-END:|170-getter|2|

    //<editor-fold defaultstate="collapsed" desc=" Generated Getter: okCommand6 ">//GEN-BEGIN:|172-getter|0|172-preInit
    /**
     * Returns an initiliazed instance of okCommand6 component.
     * @return the initialized component instance
     */
    public Command getOkCommand6() {
        if (okCommand6 == null) {//GEN-END:|172-getter|0|172-preInit
            // write pre-init user code here
            okCommand6 = new Command("Ok", Command.OK, 0);//GEN-LINE:|172-getter|1|172-postInit
        // write post-init user code here
        }//GEN-BEGIN:|172-getter|2|
        return okCommand6;
    }
    //</editor-fold>//GEN-END:|172-getter|2|

    //<editor-fold defaultstate="collapsed" desc=" Generated Getter: dubtes6 ">//GEN-BEGIN:|163-getter|0|163-preInit
    /**
     * Returns an initiliazed instance of dubtes6 component.
     * @return the initialized component instance
     */
    public Form getDubtes6() {
        if (dubtes6 == null) {//GEN-END:|163-getter|0|163-preInit
            // write pre-init user code here
            dubtes6 = new Form("DUBTES - DUDAS", new Item[] { getTableItem6() });//GEN-BEGIN:|163-getter|1|163-postInit
            dubtes6.addCommand(getBackCommand5());
            dubtes6.addCommand(getItemCommand6());
            dubtes6.setCommandListener(this);//GEN-END:|163-getter|1|163-postInit
        // write post-init user code here
        }//GEN-BEGIN:|163-getter|2|
        return dubtes6;
    }
    //</editor-fold>//GEN-END:|163-getter|2|

    //<editor-fold defaultstate="collapsed" desc=" Generated Getter: exclamacions7 ">//GEN-BEGIN:|169-getter|0|169-preInit
    /**
     * Returns an initiliazed instance of exclamacions7 component.
     * @return the initialized component instance
     */
    public Form getExclamacions7() {
        if (exclamacions7 == null) {//GEN-END:|169-getter|0|169-preInit
            // write pre-init user code here
            exclamacions7 = new Form("EXCLAMACIONS I EXPRESSIONS DIVERSES - EXCLAMACIONES Y EXPRESIONES DIVERSAS", new Item[] { getTableItem7() });//GEN-BEGIN:|169-getter|1|169-postInit
            exclamacions7.addCommand(getBackCommand6());
            exclamacions7.addCommand(getItemCommand7());
            exclamacions7.setCommandListener(this);//GEN-END:|169-getter|1|169-postInit
        // write post-init user code here
        }//GEN-BEGIN:|169-getter|2|
        return exclamacions7;
    }
    //</editor-fold>//GEN-END:|169-getter|2|

    //<editor-fold defaultstate="collapsed" desc=" Generated Getter: qualitats8 ">//GEN-BEGIN:|175-getter|0|175-preInit
    /**
     * Returns an initiliazed instance of qualitats8 component.
     * @return the initialized component instance
     */
    public Form getQualitats8() {
        if (qualitats8 == null) {//GEN-END:|175-getter|0|175-preInit
            // write pre-init user code here
            qualitats8 = new Form("QUALITATS, ESTATS, PREFER\u00C8NCIES - CUALIDADES, ESTADOS , PREFERENCIAS", new Item[] { getTableItem8() });//GEN-BEGIN:|175-getter|1|175-postInit
            qualitats8.addCommand(getBackCommand7());
            qualitats8.addCommand(getItemCommand8());
            qualitats8.setCommandListener(this);//GEN-END:|175-getter|1|175-postInit
        // write post-init user code here
        }//GEN-BEGIN:|175-getter|2|
        return qualitats8;
    }
    //</editor-fold>//GEN-END:|175-getter|2|

    //<editor-fold defaultstate="collapsed" desc=" Generated Getter: backCommand7 ">//GEN-BEGIN:|177-getter|0|177-preInit
    /**
     * Returns an initiliazed instance of backCommand7 component.
     * @return the initialized component instance
     */
    public Command getBackCommand7() {
        if (backCommand7 == null) {//GEN-END:|177-getter|0|177-preInit
            // write pre-init user code here
            backCommand7 = new Command("Back", Command.BACK, 0);//GEN-LINE:|177-getter|1|177-postInit
        // write post-init user code here
        }//GEN-BEGIN:|177-getter|2|
        return backCommand7;
    }
    //</editor-fold>//GEN-END:|177-getter|2|

    //<editor-fold defaultstate="collapsed" desc=" Generated Getter: okCommand7 ">//GEN-BEGIN:|179-getter|0|179-preInit
    /**
     * Returns an initiliazed instance of okCommand7 component.
     * @return the initialized component instance
     */
    public Command getOkCommand7() {
        if (okCommand7 == null) {//GEN-END:|179-getter|0|179-preInit
            // write pre-init user code here
            okCommand7 = new Command("Ok", Command.OK, 0);//GEN-LINE:|179-getter|1|179-postInit
        // write post-init user code here
        }//GEN-BEGIN:|179-getter|2|
        return okCommand7;
    }
    //</editor-fold>//GEN-END:|179-getter|2|

    //<editor-fold defaultstate="collapsed" desc=" Generated Getter: backCommand8 ">//GEN-BEGIN:|182-getter|0|182-preInit
    /**
     * Returns an initiliazed instance of backCommand8 component.
     * @return the initialized component instance
     */
    public Command getBackCommand8() {
        if (backCommand8 == null) {//GEN-END:|182-getter|0|182-preInit
            // write pre-init user code here
            backCommand8 = new Command("Back", Command.BACK, 0);//GEN-LINE:|182-getter|1|182-postInit
        // write post-init user code here
        }//GEN-BEGIN:|182-getter|2|
        return backCommand8;
    }
    //</editor-fold>//GEN-END:|182-getter|2|

    //<editor-fold defaultstate="collapsed" desc=" Generated Getter: okCommand8 ">//GEN-BEGIN:|184-getter|0|184-preInit
    /**
     * Returns an initiliazed instance of okCommand8 component.
     * @return the initialized component instance
     */
    public Command getOkCommand8() {
        if (okCommand8 == null) {//GEN-END:|184-getter|0|184-preInit
            // write pre-init user code here
            okCommand8 = new Command("Ok", Command.OK, 0);//GEN-LINE:|184-getter|1|184-postInit
        // write post-init user code here
        }//GEN-BEGIN:|184-getter|2|
        return okCommand8;
    }
    //</editor-fold>//GEN-END:|184-getter|2|

    //<editor-fold defaultstate="collapsed" desc=" Generated Getter: colors9 ">//GEN-BEGIN:|181-getter|0|181-preInit
    /**
     * Returns an initiliazed instance of colors9 component.
     * @return the initialized component instance
     */
    public Form getColors9() {
        if (colors9 == null) {//GEN-END:|181-getter|0|181-preInit
            // write pre-init user code here
            colors9 = new Form("COLORS - COLORES", new Item[] { getTableItem9() });//GEN-BEGIN:|181-getter|1|181-postInit
            colors9.addCommand(getBackCommand8());
            colors9.addCommand(getItemCommand9());
            colors9.setCommandListener(this);//GEN-END:|181-getter|1|181-postInit
        // write post-init user code here
        }//GEN-BEGIN:|181-getter|2|
        return colors9;
    }
    //</editor-fold>//GEN-END:|181-getter|2|

    //<editor-fold defaultstate="collapsed" desc=" Generated Getter: numerals10 ">//GEN-BEGIN:|187-getter|0|187-preInit
    /**
     * Returns an initiliazed instance of numerals10 component.
     * @return the initialized component instance
     */
    public Form getNumerals10() {
        if (numerals10 == null) {//GEN-END:|187-getter|0|187-preInit
            // write pre-init user code here
            numerals10 = new Form("NUMERALS - NUMEROS", new Item[] { getTableItem10() });//GEN-BEGIN:|187-getter|1|187-postInit
            numerals10.addCommand(getBackCommand20());
            numerals10.addCommand(getItemCommand10());
            numerals10.setCommandListener(this);//GEN-END:|187-getter|1|187-postInit
        // write post-init user code here
        }//GEN-BEGIN:|187-getter|2|
        return numerals10;
    }
    //</editor-fold>//GEN-END:|187-getter|2|

    //<editor-fold defaultstate="collapsed" desc=" Generated Getter: backCommand9 ">//GEN-BEGIN:|190-getter|0|190-preInit
    /**
     * Returns an initiliazed instance of backCommand9 component.
     * @return the initialized component instance
     */
    public Command getBackCommand9() {
        if (backCommand9 == null) {//GEN-END:|190-getter|0|190-preInit
            // write pre-init user code here
            backCommand9 = new Command("Back", Command.BACK, 0);//GEN-LINE:|190-getter|1|190-postInit
        // write post-init user code here
        }//GEN-BEGIN:|190-getter|2|
        return backCommand9;
    }
    //</editor-fold>//GEN-END:|190-getter|2|

    //<editor-fold defaultstate="collapsed" desc=" Generated Getter: okCommand9 ">//GEN-BEGIN:|192-getter|0|192-preInit
    /**
     * Returns an initiliazed instance of okCommand9 component.
     * @return the initialized component instance
     */
    public Command getOkCommand9() {
        if (okCommand9 == null) {//GEN-END:|192-getter|0|192-preInit
            // write pre-init user code here
            okCommand9 = new Command("Ok", Command.OK, 0);//GEN-LINE:|192-getter|1|192-postInit
        // write post-init user code here
        }//GEN-BEGIN:|192-getter|2|
        return okCommand9;
    }
    //</editor-fold>//GEN-END:|192-getter|2|

    //<editor-fold defaultstate="collapsed" desc=" Generated Getter: expressions11 ">//GEN-BEGIN:|189-getter|0|189-preInit
    /**
     * Returns an initiliazed instance of expressions11 component.
     * @return the initialized component instance
     */
    public Form getExpressions11() {
        if (expressions11 == null) {//GEN-END:|189-getter|0|189-preInit
            // write pre-init user code here
            expressions11 = new Form("EXPRESSIONS TEMPORALS  - EXPRESIONES TEMPORALES ", new Item[] { getTableItem11() });//GEN-BEGIN:|189-getter|1|189-postInit
            expressions11.addCommand(getBackCommand9());
            expressions11.setCommandListener(this);//GEN-END:|189-getter|1|189-postInit
        // write post-init user code here
        }//GEN-BEGIN:|189-getter|2|
        return expressions11;
    }
    //</editor-fold>//GEN-END:|189-getter|2|

    //<editor-fold defaultstate="collapsed" desc=" Generated Getter: dias12 ">//GEN-BEGIN:|195-getter|0|195-preInit
    /**
     * Returns an initiliazed instance of dias12 component.
     * @return the initialized component instance
     */
    public Form getDias12() {
        if (dias12 == null) {//GEN-END:|195-getter|0|195-preInit
            // write pre-init user code here
            dias12 = new Form("DIES, MESOS,ESTACIONS,PUNTS CARDINALS - DIAS, MESES,ESTACIONES,PUNTOS CARDINALES", new Item[] { getTableItem12() });//GEN-BEGIN:|195-getter|1|195-postInit
            dias12.addCommand(getBackCommand19());
            dias12.addCommand(getItemCommand12());
            dias12.setCommandListener(this);//GEN-END:|195-getter|1|195-postInit
        // write post-init user code here
        }//GEN-BEGIN:|195-getter|2|
        return dias12;
    }
    //</editor-fold>//GEN-END:|195-getter|2|

    //<editor-fold defaultstate="collapsed" desc=" Generated Getter: aniversaris13 ">//GEN-BEGIN:|197-getter|0|197-preInit
    /**
     * Returns an initiliazed instance of aniversaris13 component.
     * @return the initialized component instance
     */
    public Form getAniversaris13() {
        if (aniversaris13 == null) {//GEN-END:|197-getter|0|197-preInit
            // write pre-init user code here
            aniversaris13 = new Form("EDAT, ANIVERSARIS - EDAD, ANIVERSARIOS", new Item[] { getTableItem13() });//GEN-BEGIN:|197-getter|1|197-postInit
            aniversaris13.addCommand(getBackCommand11());
            aniversaris13.addCommand(getItemCommand13());
            aniversaris13.setCommandListener(this);//GEN-END:|197-getter|1|197-postInit
        // write post-init user code here
        }//GEN-BEGIN:|197-getter|2|
        return aniversaris13;
    }
    //</editor-fold>//GEN-END:|197-getter|2|

    //<editor-fold defaultstate="collapsed" desc=" Generated Getter: backCommand11 ">//GEN-BEGIN:|202-getter|0|202-preInit
    /**
     * Returns an initiliazed instance of backCommand11 component.
     * @return the initialized component instance
     */
    public Command getBackCommand11() {
        if (backCommand11 == null) {//GEN-END:|202-getter|0|202-preInit
            // write pre-init user code here
            backCommand11 = new Command("Back", Command.BACK, 0);//GEN-LINE:|202-getter|1|202-postInit
        // write post-init user code here
        }//GEN-BEGIN:|202-getter|2|
        return backCommand11;
    }
    //</editor-fold>//GEN-END:|202-getter|2|

    //<editor-fold defaultstate="collapsed" desc=" Generated Getter: okCommand11 ">//GEN-BEGIN:|204-getter|0|204-preInit
    /**
     * Returns an initiliazed instance of okCommand11 component.
     * @return the initialized component instance
     */
    public Command getOkCommand11() {
        if (okCommand11 == null) {//GEN-END:|204-getter|0|204-preInit
            // write pre-init user code here
            okCommand11 = new Command("Ok", Command.OK, 0);//GEN-LINE:|204-getter|1|204-postInit
        // write post-init user code here
        }//GEN-BEGIN:|204-getter|2|
        return okCommand11;
    }
    //</editor-fold>//GEN-END:|204-getter|2|

    //<editor-fold defaultstate="collapsed" desc=" Generated Getter: backCommand12 ">//GEN-BEGIN:|208-getter|0|208-preInit
    /**
     * Returns an initiliazed instance of backCommand12 component.
     * @return the initialized component instance
     */
    public Command getBackCommand12() {
        if (backCommand12 == null) {//GEN-END:|208-getter|0|208-preInit
            // write pre-init user code here
            backCommand12 = new Command("Back", Command.BACK, 0);//GEN-LINE:|208-getter|1|208-postInit
        // write post-init user code here
        }//GEN-BEGIN:|208-getter|2|
        return backCommand12;
    }
    //</editor-fold>//GEN-END:|208-getter|2|

    //<editor-fold defaultstate="collapsed" desc=" Generated Getter: okCommand12 ">//GEN-BEGIN:|210-getter|0|210-preInit
    /**
     * Returns an initiliazed instance of okCommand12 component.
     * @return the initialized component instance
     */
    public Command getOkCommand12() {
        if (okCommand12 == null) {//GEN-END:|210-getter|0|210-preInit
            // write pre-init user code here
            okCommand12 = new Command("Ok", Command.OK, 0);//GEN-LINE:|210-getter|1|210-postInit
        // write post-init user code here
        }//GEN-BEGIN:|210-getter|2|
        return okCommand12;
    }
    //</editor-fold>//GEN-END:|210-getter|2|

    //<editor-fold defaultstate="collapsed" desc=" Generated Getter: temps14 ">//GEN-BEGIN:|207-getter|0|207-preInit
    /**
     * Returns an initiliazed instance of temps14 component.
     * @return the initialized component instance
     */
    public Form getTemps14() {
        if (temps14 == null) {//GEN-END:|207-getter|0|207-preInit
            // write pre-init user code here
            temps14 = new Form("TEMPS - TIEMPO", new Item[] { getTableItem14() });//GEN-BEGIN:|207-getter|1|207-postInit
            temps14.addCommand(getBackCommand12());
            temps14.addCommand(getItemCommand14());
            temps14.setCommandListener(this);//GEN-END:|207-getter|1|207-postInit
        // write post-init user code here
        }//GEN-BEGIN:|207-getter|2|
        return temps14;
    }
    //</editor-fold>//GEN-END:|207-getter|2|

    //<editor-fold defaultstate="collapsed" desc=" Generated Getter: avisos15 ">//GEN-BEGIN:|213-getter|0|213-preInit
    /**
     * Returns an initiliazed instance of avisos15 component.
     * @return the initialized component instance
     */
    public Form getAvisos15() {
        if (avisos15 == null) {//GEN-END:|213-getter|0|213-preInit
            // write pre-init user code here
            avisos15 = new Form("AVISOS I CARTELLS PLUBLICITARIS - AVISOS Y CARTELES PUBLICITARIOS", new Item[] { getTableItem15() });//GEN-BEGIN:|213-getter|1|213-postInit
            avisos15.addCommand(getBackCommand13());
            avisos15.setCommandListener(this);//GEN-END:|213-getter|1|213-postInit
        // write post-init user code here
        }//GEN-BEGIN:|213-getter|2|
        return avisos15;
    }
    //</editor-fold>//GEN-END:|213-getter|2|

    //<editor-fold defaultstate="collapsed" desc=" Generated Getter: backCommand13 ">//GEN-BEGIN:|216-getter|0|216-preInit
    /**
     * Returns an initiliazed instance of backCommand13 component.
     * @return the initialized component instance
     */
    public Command getBackCommand13() {
        if (backCommand13 == null) {//GEN-END:|216-getter|0|216-preInit
            // write pre-init user code here
            backCommand13 = new Command("Back", Command.BACK, 0);//GEN-LINE:|216-getter|1|216-postInit
        // write post-init user code here
        }//GEN-BEGIN:|216-getter|2|
        return backCommand13;
    }
    //</editor-fold>//GEN-END:|216-getter|2|

    //<editor-fold defaultstate="collapsed" desc=" Generated Getter: okCommand13 ">//GEN-BEGIN:|218-getter|0|218-preInit
    /**
     * Returns an initiliazed instance of okCommand13 component.
     * @return the initialized component instance
     */
    public Command getOkCommand13() {
        if (okCommand13 == null) {//GEN-END:|218-getter|0|218-preInit
            // write pre-init user code here
            okCommand13 = new Command("Ok", Command.OK, 0);//GEN-LINE:|218-getter|1|218-postInit
        // write post-init user code here
        }//GEN-BEGIN:|218-getter|2|
        return okCommand13;
    }
    //</editor-fold>//GEN-END:|218-getter|2|

    //<editor-fold defaultstate="collapsed" desc=" Generated Getter: backCommand14 ">//GEN-BEGIN:|220-getter|0|220-preInit
    /**
     * Returns an initiliazed instance of backCommand14 component.
     * @return the initialized component instance
     */
    public Command getBackCommand14() {
        if (backCommand14 == null) {//GEN-END:|220-getter|0|220-preInit
            // write pre-init user code here
            backCommand14 = new Command("Back", Command.BACK, 0);//GEN-LINE:|220-getter|1|220-postInit
        // write post-init user code here
        }//GEN-BEGIN:|220-getter|2|
        return backCommand14;
    }
    //</editor-fold>//GEN-END:|220-getter|2|

    //<editor-fold defaultstate="collapsed" desc=" Generated Getter: okCommand14 ">//GEN-BEGIN:|222-getter|0|222-preInit
    /**
     * Returns an initiliazed instance of okCommand14 component.
     * @return the initialized component instance
     */
    public Command getOkCommand14() {
        if (okCommand14 == null) {//GEN-END:|222-getter|0|222-preInit
            // write pre-init user code here
            okCommand14 = new Command("Ok", Command.OK, 0);//GEN-LINE:|222-getter|1|222-postInit
        // write post-init user code here
        }//GEN-BEGIN:|222-getter|2|
        return okCommand14;
    }
    //</editor-fold>//GEN-END:|222-getter|2|

    //<editor-fold defaultstate="collapsed" desc=" Generated Getter: oferta16 ">//GEN-BEGIN:|215-getter|0|215-preInit
    /**
     * Returns an initiliazed instance of oferta16 component.
     * @return the initialized component instance
     */
    public Form getOferta16() {
        if (oferta16 == null) {//GEN-END:|215-getter|0|215-preInit
            // write pre-init user code here
            oferta16 = new Form("OFERTA I DEMANDA - OFERTA Y DEMANDA", new Item[] { getTableItem16() });//GEN-BEGIN:|215-getter|1|215-postInit
            oferta16.addCommand(getBackCommand14());
            oferta16.setCommandListener(this);//GEN-END:|215-getter|1|215-postInit
        // write post-init user code here
        }//GEN-BEGIN:|215-getter|2|
        return oferta16;
    }
    //</editor-fold>//GEN-END:|215-getter|2|

    //<editor-fold defaultstate="collapsed" desc=" Generated Getter: backCommand15 ">//GEN-BEGIN:|226-getter|0|226-preInit
    /**
     * Returns an initiliazed instance of backCommand15 component.
     * @return the initialized component instance
     */
    public Command getBackCommand15() {
        if (backCommand15 == null) {//GEN-END:|226-getter|0|226-preInit
            // write pre-init user code here
            backCommand15 = new Command("Back", Command.BACK, 0);//GEN-LINE:|226-getter|1|226-postInit
        // write post-init user code here
        }//GEN-BEGIN:|226-getter|2|
        return backCommand15;
    }
    //</editor-fold>//GEN-END:|226-getter|2|

    //<editor-fold defaultstate="collapsed" desc=" Generated Getter: okCommand15 ">//GEN-BEGIN:|228-getter|0|228-preInit
    /**
     * Returns an initiliazed instance of okCommand15 component.
     * @return the initialized component instance
     */
    public Command getOkCommand15() {
        if (okCommand15 == null) {//GEN-END:|228-getter|0|228-preInit
            // write pre-init user code here
            okCommand15 = new Command("Ok", Command.OK, 0);//GEN-LINE:|228-getter|1|228-postInit
        // write post-init user code here
        }//GEN-BEGIN:|228-getter|2|
        return okCommand15;
    }
    //</editor-fold>//GEN-END:|228-getter|2|

    //<editor-fold defaultstate="collapsed" desc=" Generated Getter: backCommand16 ">//GEN-BEGIN:|234-getter|0|234-preInit
    /**
     * Returns an initiliazed instance of backCommand16 component.
     * @return the initialized component instance
     */
    public Command getBackCommand16() {
        if (backCommand16 == null) {//GEN-END:|234-getter|0|234-preInit
            // write pre-init user code here
            backCommand16 = new Command("Back", Command.BACK, 0);//GEN-LINE:|234-getter|1|234-postInit
        // write post-init user code here
        }//GEN-BEGIN:|234-getter|2|
        return backCommand16;
    }
    //</editor-fold>//GEN-END:|234-getter|2|

    //<editor-fold defaultstate="collapsed" desc=" Generated Getter: okCommand17 ">//GEN-BEGIN:|236-getter|0|236-preInit
    /**
     * Returns an initiliazed instance of okCommand17 component.
     * @return the initialized component instance
     */
    public Command getOkCommand17() {
        if (okCommand17 == null) {//GEN-END:|236-getter|0|236-preInit
            // write pre-init user code here
            okCommand17 = new Command("Ok", Command.OK, 0);//GEN-LINE:|236-getter|1|236-postInit
        // write post-init user code here
        }//GEN-BEGIN:|236-getter|2|
        return okCommand17;
    }
    //</editor-fold>//GEN-END:|236-getter|2|

    //<editor-fold defaultstate="collapsed" desc=" Generated Getter: feina17 ">//GEN-BEGIN:|225-getter|0|225-preInit
    /**
     * Returns an initiliazed instance of feina17 component.
     * @return the initialized component instance
     */
    public Form getFeina17() {
        if (feina17 == null) {//GEN-END:|225-getter|0|225-preInit
            // write pre-init user code here
            feina17 = new Form("FEINA, ESTUDIS, PROFESSIONS - TRABAJO, ESTUDIOS, PROFESIONES", new Item[] { getTableItem17() });//GEN-BEGIN:|225-getter|1|225-postInit
            feina17.addCommand(getBackCommand15());
            feina17.addCommand(getItemCommand20());
            feina17.setCommandListener(this);//GEN-END:|225-getter|1|225-postInit
        // write post-init user code here
        }//GEN-BEGIN:|225-getter|2|
        return feina17;
    }
    //</editor-fold>//GEN-END:|225-getter|2|

    //<editor-fold defaultstate="collapsed" desc=" Generated Getter: localitzacions18 ">//GEN-BEGIN:|231-getter|0|231-preInit
    /**
     * Returns an initiliazed instance of localitzacions18 component.
     * @return the initialized component instance
     */
    public Form getLocalitzacions18() {
        if (localitzacions18 == null) {//GEN-END:|231-getter|0|231-preInit
            // write pre-init user code here
            localitzacions18 = new Form("LOCALITZACIONS - LOCALIZACIONES", new Item[] { getTableItem18() });//GEN-BEGIN:|231-getter|1|231-postInit
            localitzacions18.addCommand(getBackCommand16());
            localitzacions18.addCommand(getItemCommand22());
            localitzacions18.setCommandListener(this);//GEN-END:|231-getter|1|231-postInit
        // write post-init user code here
        }//GEN-BEGIN:|231-getter|2|
        return localitzacions18;
    }
    //</editor-fold>//GEN-END:|231-getter|2|

    //<editor-fold defaultstate="collapsed" desc=" Generated Getter: backCommand17 ">//GEN-BEGIN:|240-getter|0|240-preInit
    /**
     * Returns an initiliazed instance of backCommand17 component.
     * @return the initialized component instance
     */
    public Command getBackCommand17() {
        if (backCommand17 == null) {//GEN-END:|240-getter|0|240-preInit
            // write pre-init user code here
            backCommand17 = new Command("Back", Command.BACK, 0);//GEN-LINE:|240-getter|1|240-postInit
        // write post-init user code here
        }//GEN-BEGIN:|240-getter|2|
        return backCommand17;
    }
    //</editor-fold>//GEN-END:|240-getter|2|

    //<editor-fold defaultstate="collapsed" desc=" Generated Getter: okCommand18 ">//GEN-BEGIN:|242-getter|0|242-preInit
    /**
     * Returns an initiliazed instance of okCommand18 component.
     * @return the initialized component instance
     */
    public Command getOkCommand18() {
        if (okCommand18 == null) {//GEN-END:|242-getter|0|242-preInit
            // write pre-init user code here
            okCommand18 = new Command("Ok", Command.OK, 0);//GEN-LINE:|242-getter|1|242-postInit
        // write post-init user code here
        }//GEN-BEGIN:|242-getter|2|
        return okCommand18;
    }
    //</editor-fold>//GEN-END:|242-getter|2|

    //<editor-fold defaultstate="collapsed" desc=" Generated Getter: transports19 ">//GEN-BEGIN:|239-getter|0|239-preInit
    /**
     * Returns an initiliazed instance of transports19 component.
     * @return the initialized component instance
     */
    public Form getTransports19() {
        if (transports19 == null) {//GEN-END:|239-getter|0|239-preInit
            // write pre-init user code here
            transports19 = new Form("TRANSPORTS - TRANSPORTES", new Item[] { getTableItem19() });//GEN-BEGIN:|239-getter|1|239-postInit
            transports19.addCommand(getBackCommand17());
            transports19.addCommand(getItemCommand23());
            transports19.setCommandListener(this);//GEN-END:|239-getter|1|239-postInit
        // write post-init user code here
        }//GEN-BEGIN:|239-getter|2|
        return transports19;
    }
    //</editor-fold>//GEN-END:|239-getter|2|

    //<editor-fold defaultstate="collapsed" desc=" Generated Getter: familia20 ">//GEN-BEGIN:|245-getter|0|245-preInit
    /**
     * Returns an initiliazed instance of familia20 component.
     * @return the initialized component instance
     */
    public Form getFamilia20() {
        if (familia20 == null) {//GEN-END:|245-getter|0|245-preInit
            // write pre-init user code here
            familia20 = new Form("FAM\u00CCLIA, ESTAT CIVIL I HABITATGE - FAMILIA, ESTADO CIVIL Y VIVIENDA", new Item[] { getTableItem20() });//GEN-BEGIN:|245-getter|1|245-postInit
            familia20.addCommand(getBackCommand18());
            familia20.addCommand(getItemCommand24());
            familia20.setCommandListener(this);//GEN-END:|245-getter|1|245-postInit
        // write post-init user code here
        }//GEN-BEGIN:|245-getter|2|
        return familia20;
    }
    //</editor-fold>//GEN-END:|245-getter|2|

    //<editor-fold defaultstate="collapsed" desc=" Generated Getter: backCommand18 ">//GEN-BEGIN:|246-getter|0|246-preInit
    /**
     * Returns an initiliazed instance of backCommand18 component.
     * @return the initialized component instance
     */
    public Command getBackCommand18() {
        if (backCommand18 == null) {//GEN-END:|246-getter|0|246-preInit
            // write pre-init user code here
            backCommand18 = new Command("Back", Command.BACK, 0);//GEN-LINE:|246-getter|1|246-postInit
        // write post-init user code here
        }//GEN-BEGIN:|246-getter|2|
        return backCommand18;
    }
    //</editor-fold>//GEN-END:|246-getter|2|

    //<editor-fold defaultstate="collapsed" desc=" Generated Getter: okCommand19 ">//GEN-BEGIN:|248-getter|0|248-preInit
    /**
     * Returns an initiliazed instance of okCommand19 component.
     * @return the initialized component instance
     */
    public Command getOkCommand19() {
        if (okCommand19 == null) {//GEN-END:|248-getter|0|248-preInit
            // write pre-init user code here
            okCommand19 = new Command("Ok", Command.OK, 0);//GEN-LINE:|248-getter|1|248-postInit
        // write post-init user code here
        }//GEN-BEGIN:|248-getter|2|
        return okCommand19;
    }
    //</editor-fold>//GEN-END:|248-getter|2|

    //<editor-fold defaultstate="collapsed" desc=" Generated Getter: festes21 ">//GEN-BEGIN:|251-getter|0|251-preInit
    /**
     * Returns an initiliazed instance of festes21 component.
     * @return the initialized component instance
     */
    public Form getFestes21() {
        if (festes21 == null) {//GEN-END:|251-getter|0|251-preInit
            // write pre-init user code here
            festes21 = new Form("FESTES I FELICITACIONS - FIESTAS Y FELICITACIONES", new Item[] { getTableItem21() });//GEN-BEGIN:|251-getter|1|251-postInit
            festes21.addCommand(getBackCommand21());
            festes21.addCommand(getItemCommand25());
            festes21.setCommandListener(this);//GEN-END:|251-getter|1|251-postInit
        // write post-init user code here
        }//GEN-BEGIN:|251-getter|2|
        return festes21;
    }
    //</editor-fold>//GEN-END:|251-getter|2|

    //<editor-fold defaultstate="collapsed" desc=" Generated Getter: backCommand19 ">//GEN-BEGIN:|254-getter|0|254-preInit
    /**
     * Returns an initiliazed instance of backCommand19 component.
     * @return the initialized component instance
     */
    public Command getBackCommand19() {
        if (backCommand19 == null) {//GEN-END:|254-getter|0|254-preInit
            // write pre-init user code here
            backCommand19 = new Command("Back", Command.BACK, 0);//GEN-LINE:|254-getter|1|254-postInit
        // write post-init user code here
        }//GEN-BEGIN:|254-getter|2|
        return backCommand19;
    }
    //</editor-fold>//GEN-END:|254-getter|2|

    //<editor-fold defaultstate="collapsed" desc=" Generated Getter: okCommand20 ">//GEN-BEGIN:|256-getter|0|256-preInit
    /**
     * Returns an initiliazed instance of okCommand20 component.
     * @return the initialized component instance
     */
    public Command getOkCommand20() {
        if (okCommand20 == null) {//GEN-END:|256-getter|0|256-preInit
            // write pre-init user code here
            okCommand20 = new Command("Ok", Command.OK, 0);//GEN-LINE:|256-getter|1|256-postInit
        // write post-init user code here
        }//GEN-BEGIN:|256-getter|2|
        return okCommand20;
    }
    //</editor-fold>//GEN-END:|256-getter|2|

    //<editor-fold defaultstate="collapsed" desc=" Generated Getter: backCommand20 ">//GEN-BEGIN:|258-getter|0|258-preInit
    /**
     * Returns an initiliazed instance of backCommand20 component.
     * @return the initialized component instance
     */
    public Command getBackCommand20() {
        if (backCommand20 == null) {//GEN-END:|258-getter|0|258-preInit
            // write pre-init user code here
            backCommand20 = new Command("Back", Command.BACK, 0);//GEN-LINE:|258-getter|1|258-postInit
        // write post-init user code here
        }//GEN-BEGIN:|258-getter|2|
        return backCommand20;
    }
    //</editor-fold>//GEN-END:|258-getter|2|

    //<editor-fold defaultstate="collapsed" desc=" Generated Getter: okCommand21 ">//GEN-BEGIN:|260-getter|0|260-preInit
    /**
     * Returns an initiliazed instance of okCommand21 component.
     * @return the initialized component instance
     */
    public Command getOkCommand21() {
        if (okCommand21 == null) {//GEN-END:|260-getter|0|260-preInit
            // write pre-init user code here
            okCommand21 = new Command("Ok", Command.OK, 0);//GEN-LINE:|260-getter|1|260-postInit
        // write post-init user code here
        }//GEN-BEGIN:|260-getter|2|
        return okCommand21;
    }
    //</editor-fold>//GEN-END:|260-getter|2|

    //<editor-fold defaultstate="collapsed" desc=" Generated Getter: backCommand21 ">//GEN-BEGIN:|263-getter|0|263-preInit
    /**
     * Returns an initiliazed instance of backCommand21 component.
     * @return the initialized component instance
     */
    public Command getBackCommand21() {
        if (backCommand21 == null) {//GEN-END:|263-getter|0|263-preInit
            // write pre-init user code here
            backCommand21 = new Command("Back", Command.BACK, 0);//GEN-LINE:|263-getter|1|263-postInit
        // write post-init user code here
        }//GEN-BEGIN:|263-getter|2|
        return backCommand21;
    }
    //</editor-fold>//GEN-END:|263-getter|2|

    //<editor-fold defaultstate="collapsed" desc=" Generated Getter: okCommand22 ">//GEN-BEGIN:|265-getter|0|265-preInit
    /**
     * Returns an initiliazed instance of okCommand22 component.
     * @return the initialized component instance
     */
    public Command getOkCommand22() {
        if (okCommand22 == null) {//GEN-END:|265-getter|0|265-preInit
            // write pre-init user code here
            okCommand22 = new Command("Ok", Command.OK, 0);//GEN-LINE:|265-getter|1|265-postInit
        // write post-init user code here
        }//GEN-BEGIN:|265-getter|2|
        return okCommand22;
    }
    //</editor-fold>//GEN-END:|265-getter|2|

    //<editor-fold defaultstate="collapsed" desc=" Generated Getter: tableItem1 ">//GEN-BEGIN:|288-getter|0|288-preInit
    /**
     * Returns an initiliazed instance of tableItem1 component.
     * @return the initialized component instance
     */
    public TableItem getTableItem1() {
        if (tableItem1 == null) {//GEN-END:|288-getter|0|288-preInit
            // write pre-init user code here
            tableItem1 = new TableItem(getDisplay(), "");//GEN-BEGIN:|288-getter|1|288-postInit
            tableItem1.setModel(getTableModel1());//GEN-END:|288-getter|1|288-postInit
        // write post-init user code here
        }//GEN-BEGIN:|288-getter|2|
        return tableItem1;
    }
    //</editor-fold>//GEN-END:|288-getter|2|

    //<editor-fold defaultstate="collapsed" desc=" Generated Getter: tableModel1 ">//GEN-BEGIN:|289-getter|0|289-preInit
    /**
     * Returns an initiliazed instance of tableModel1 component.
     * @return the initialized component instance
     */
    public SimpleTableModel getTableModel1() {
        if (tableModel1 == null) {//GEN-END:|289-getter|0|289-preInit
            // write pre-init user code here
            tableModel1 = new SimpleTableModel(new java.lang.String[][] {//GEN-BEGIN:|289-getter|1|289-postInit
                new java.lang.String[] { "A Mallorca diuen... ", "En Mallorca se dice...", "b01-01" },
                new java.lang.String[] { "En catal\u00E0 es diu... ", "En catal\u00E1n se dice...", "b01-02" },
                new java.lang.String[] { "Com ho diuen a Menorca...?", "\u00BFC\u00F3mo se dice en Menorca\u2026?", "b01-03" },
                new java.lang.String[] { "Com es diu en catal\u00E0...? ", "\u00BFC\u00F3mo se dice en catal\u00E1n\u2026?", "b01-04" },
                new java.lang.String[] { "Saps com ho diuen a Eivissa...? ", "\u00BFSabes c\u00F3mo se dice en Ibiza?", "b01-05" },
                new java.lang.String[] { "Saps com es diu en catal\u00E0...? ", "\u00BFSabes c\u00F3mo se dice en catal\u00E1n\u2026?", "b01-06" },
                new java.lang.String[] { "A Formentera diuen...", "En Formentera se dice...", "b01-07" }}, new java.lang.String[] { "Catal\u00E1", "Espa\u00F1ol", "FILE" });//GEN-END:|289-getter|1|289-postInit
        // write post-init user code here
        }//GEN-BEGIN:|289-getter|2|
        return tableModel1;
    }
    //</editor-fold>//GEN-END:|289-getter|2|

    /**
     * Performs an action assigned to the s1 switch-point.
     */
//    public void s1() {
//        switch (getChapter1Item()) {
//            case 0:
//                playMP3("1 A su alcance/b01-01.mp3");
//                break;
//            case 1:
//                playMP3("1 A su alcance/b01-02.mp3");
//                break;
//            case 2:
//                playMP3("1 A su alcance/b01-03.mp3");
//
//                break;
//            case 3:
//                playMP3("1 A su alcance/b01-04.mp3");
//
//                break;
//            case 4:
//                playMP3("1 A su alcance/b01-05.mp3");
//                break;
//            case 5:
//                playMP3("1 A su alcance/b01-06.mp3");
//                break;
//            case 6:
//                playMP3("1 A su alcance/b01-07.mp3");
//                break;
//        }
//    }

    //<editor-fold defaultstate="collapsed" desc=" Generated Getter: itemCommand1 ">//GEN-BEGIN:|296-getter|0|296-preInit
    /**
     * Returns an initiliazed instance of itemCommand1 component.
     * @return the initialized component instance
     */
    public Command getItemCommand1() {
        if (itemCommand1 == null) {//GEN-END:|296-getter|0|296-preInit
            // write pre-init user code here
            itemCommand1 = new Command("Escuchar", Command.ITEM, 0);//GEN-LINE:|296-getter|1|296-postInit
        // write post-init user code here
        }//GEN-BEGIN:|296-getter|2|
        return itemCommand1;
    }
    //</editor-fold>//GEN-END:|296-getter|2|


    // enter pre-switch user code here
    //<editor-fold defaultstate="collapsed" desc=" Generated Getter: tableItem2 ">//GEN-BEGIN:|305-getter|0|305-preInit
    /**
     * Returns an initiliazed instance of tableItem2 component.
     * @return the initialized component instance
     */
    public TableItem getTableItem2() {
        if (tableItem2 == null) {//GEN-END:|305-getter|0|305-preInit
            // write pre-init user code here
            tableItem2 = new TableItem(getDisplay(), "");//GEN-BEGIN:|305-getter|1|305-postInit
            tableItem2.setModel(getTableModel2());//GEN-END:|305-getter|1|305-postInit
        // write post-init user code here
        }//GEN-BEGIN:|305-getter|2|
        return tableItem2;
    }
    //</editor-fold>//GEN-END:|305-getter|2|

    //<editor-fold defaultstate="collapsed" desc=" Generated Getter: tableModel2 ">//GEN-BEGIN:|306-getter|0|306-preInit
    /**
     * Returns an initiliazed instance of tableModel2 component.
     * @return the initialized component instance
     */
    public SimpleTableModel getTableModel2() {
        if (tableModel2 == null) {//GEN-END:|306-getter|0|306-preInit
            // write pre-init user code here
            tableModel2 = new SimpleTableModel(new java.lang.String[][] {//GEN-BEGIN:|306-getter|1|306-postInit
                new java.lang.String[] { "1.  Hola. Bon dia. Bon vespre. Bona nit.  ", "Hola. Buenos d\u00EDas. Buenas noches. ", "b02-01" },
                new java.lang.String[] { "2. Ad\u00E9u. A reveure. Que vagi b\u00E9.  ", "Adi\u00F3s. Hasta luego. Que vaya bien. ", "b02-02" },
                new java.lang.String[] { "3. Fins aviat. Fins m\u00E9s tard. Fins dem\u00E0.  ", "Hasta pronto. Hasta m\u00E1s tarde. Hasta ma\u00F1ana. ", "b02-03" },
                new java.lang.String[] { "4. Gr\u00E0cies. | Moltes gr\u00E0cies. De res.  ", "Gracias. | Muchas gracias. De nada. ", "b02-04" },
                new java.lang.String[] { "5. Perdoni. Disculpi. Em sap greu.  ", "Perdone. Disculpe. Lo siento. ", "b02-05" },
                new java.lang.String[] { "6. Molt de gust. Tant de gust.  ", "Mucho gusto. Tanto gusto. ", "b02-06" },
                new java.lang.String[] { "7. Amb molt de gust.  ", "Con mucho gusto. ", "b02-07" },
                new java.lang.String[] { "8. Que vagi de gust. Bon profit.  ", "Que aproveche. Buen provecho. ", "b02-08" },
                new java.lang.String[] { "9. Diverteix-te. Que t\u2019ho passis b\u00E9.  ", "Divi\u00E9rtete. Que te lo pases bien. ", "b02-09" },
                new java.lang.String[] { "10. Benvingut.  ", "Bienvenido. ", "b02-10" },
                new java.lang.String[] { "11. Un moment, per favor. Una altra vegada, per favor. M\u00E9s a poc a poc, per favor.  ", "Un momento, por favor. Otra vez, por favor. M\u00E1s despacio, por favor. ", "b02-10 " }}, new java.lang.String[] { "Catal\u00E0", "Espa\u00F1ol", "FILE" });//GEN-END:|306-getter|1|306-postInit
        // write post-init user code here
        }//GEN-BEGIN:|306-getter|2|
        return tableModel2;
    }
    //</editor-fold>//GEN-END:|306-getter|2|

    //<editor-fold defaultstate="collapsed" desc=" Generated Getter: itemCommand2 ">//GEN-BEGIN:|307-getter|0|307-preInit
    /**
     * Returns an initiliazed instance of itemCommand2 component.
     * @return the initialized component instance
     */
    public Command getItemCommand2() {
        if (itemCommand2 == null) {//GEN-END:|307-getter|0|307-preInit
            // write pre-init user code here
            itemCommand2 = new Command("Escuchar", Command.ITEM, 0);//GEN-LINE:|307-getter|1|307-postInit
        // write post-init user code here
        }//GEN-BEGIN:|307-getter|2|
        return itemCommand2;
    }
    //</editor-fold>//GEN-END:|307-getter|2|

    //<editor-fold defaultstate="collapsed" desc=" Generated Getter: tableItem3 ">//GEN-BEGIN:|311-getter|0|311-preInit
    /**
     * Returns an initiliazed instance of tableItem3 component.
     * @return the initialized component instance
     */
    public TableItem getTableItem3() {
        if (tableItem3 == null) {//GEN-END:|311-getter|0|311-preInit
            // write pre-init user code here
            tableItem3 = new TableItem(getDisplay(), "");//GEN-BEGIN:|311-getter|1|311-postInit
            tableItem3.setModel(getTableModel3());//GEN-END:|311-getter|1|311-postInit
        // write post-init user code here
        }//GEN-BEGIN:|311-getter|2|
        return tableItem3;
    }
    //</editor-fold>//GEN-END:|311-getter|2|

    //<editor-fold defaultstate="collapsed" desc=" Generated Getter: tableModel3 ">//GEN-BEGIN:|312-getter|0|312-preInit
    /**
     * Returns an initiliazed instance of tableModel3 component.
     * @return the initialized component instance
     */
    public SimpleTableModel getTableModel3() {
        if (tableModel3 == null) {//GEN-END:|312-getter|0|312-preInit
            // write pre-init user code here
            tableModel3 = new SimpleTableModel(new java.lang.String[][] {//GEN-BEGIN:|312-getter|1|312-postInit
                new java.lang.String[] { "1. - Com va? | Com est\u00E0? - B\u00E9, gr\u00E0cies.  ", "\u00BFC\u00F3mo va? | \u00BFC\u00F3mo est\u00E1? - Bien, gracias. ", "b03-01" },
                new java.lang.String[] { "2. - Qu\u00E8 li passa? No es troba b\u00E9?  ", "\u00BFQu\u00E9 le pasa? \u00BFNo se encuentra bien? ", "b03-02" },
                new java.lang.String[] { "3. - Qu\u00E8 nom? - Nom Isabel. - Com es diu? - Em dic Pere.  ", "\u00BFC\u00F3mo se llama? - Me llamo Isabel. - \u00BFCu\u00E1l es su nombre? - Mi nombre es Pere. ", "b03-03" },
                new java.lang.String[] { "4. - Qui \u00E9s vost\u00E8? - Som la senyora Vidal.  ", "\u00BFQui\u00E9n es usted? - Soy la se\u00F1ora Vidal. ", "b03-04" },
                new java.lang.String[] { "5. - Qu\u00E8 \u00E9s aix\u00F2? - \u00C9s un regal.  ", "\u00BFQu\u00E9 es esto? - es un regalo. ", "b03-05" },
                new java.lang.String[] { "6. - D\u2019on \u00E9s vost\u00E8? - Som d\u2019Alemanya. | Som de Su\u00EFssa. | Som d\u2019\u00C0ustria.  ", "\u00BFDe d\u00F3nde es usted? - Soy de Alemania. | Soy de Suiza. | Soy de Austria. ", "b03-06" },
                new java.lang.String[] { "7. - D\u2019on \u00E9s vost\u00E8? - Som d\u2019Anglaterra. | Som d\u2019Irlanda. | Som d\u2019Austr\u00E0lia.  ", "\u00BFDe d\u00F3nde es usted? - Soy de Inglaterra. | Soy de Irlanda. | Soy de Australia. ", "b03-07" },
                new java.lang.String[] { "8. - D\u2019on \u00E9s vost\u00E8? - Som de Fran\u00E7a. | Som de B\u00E8lgica. | Som d\'Alg\u00E8ria.  ", "\u00BFDe d\u00F3nde es usted? - Soy de Francia. | Soy de B\u00E9lgica. | Soy de Argelia. ", "b03-08" },
                new java.lang.String[] { "9. - D\u2019on \u00E9s vost\u00E8? - Som de les Can\u00E0ries. | Som de l\u2019Equador. | Som de Xile.  ", "\u00BFDe d\u00F3nde es usted? - Soy de Canarias. | Soy de Ecuador. | Soy de Chile. ", "b03-09" },
                new java.lang.String[] { "10. - \u00C9s mallorqu\u00ED? - No, som alemany. | Som su\u00EDs. | Som austr\u00EDac. - \u00C9s mallorquina? - No, som alemanya. | Som su\u00EFssa. | Som austr\u00EDaca.  ", "\u00BFEs mallorqu\u00EDn? - No, soy alem\u00E1n. | Soy suizo. | Soy austr\u00EDaco. - \u00BFEs mallorquina? - No, soy alemana. | Soy suiza. | Soy austr\u00EDaca. ", "b03-10" },
                new java.lang.String[] { "11. - \u00C9s menorqu\u00ED? - No, som angl\u00E8s. | Som irland\u00E8s. | Som australi\u00E0. - \u00C9s menorquina? - No, som anglesa. | Som irlandesa. | Som australiana.  ", "\u00BFEs menorqu\u00EDn? - No, soy ingl\u00E9s. | Soy irland\u00E9s. | Soy australiano. - \u00BFEs menorquina? - No, soy inglesa. | Soy irlandesa. | Soy australiana. ", "b03-11" },
                new java.lang.String[] { "12. - \u00C9s eivissenc? - No, som franc\u00E8s. | Som belga. | Som algeri\u00E0. - \u00C9s eivissenca? - No, som francesa. | Som belga. | Som algeriana.  ", "\u00BFEs ibicenco? - No, soy franc\u00E9s. | Soy belga. | Soy argelino. - \u00BFEs ibicenca? - No, soy francesa. | Soy belga. | Soy argelina. ", "b03-12" },
                new java.lang.String[] { "13. - \u00C9s formenterer? - No, som canari. | Som equatori\u00E0. | Som xil\u00E8. - \u00C9s formenterera? - No, som can\u00E0ria. | Som equatoriana. | Som xilena.  ", "\u00BFEs formenterense? - No, soy canario. | Soy ecuatoriano. | Soy chileno. - \u00BFEs formenterense? - No, soy canaria. | Soy ecuatoriana. | Soy chilena. ", "b03-13" },
                new java.lang.String[] { "14. - On viu? - Visc a la ciutat. | Visc en un poble. | Visc a fora vila.  ", "\u00BFD\u00F3nde vive? - Vivo en la ciudad. | Vivo en un pueblo. | Vivo en el campo. ", "b03-14" },
                new java.lang.String[] { "15. - A quin carrer viu? - Visc al carrer Nou. | Visc a la pla\u00E7a Major.  ", "\u00BFEn qu\u00E9 calle vive? - Vivo en la calle Nueva. | Vivo en la plaza Mayor. ", "b03-15" },
                new java.lang.String[] { "16. - Parla catal\u00E0? - S\u00ED, un poc. | No gaire.  ", "\u00BFHabla catal\u00E1n? - S\u00ED, un poco. | No mucho. ", "b03-16" },
                new java.lang.String[] { "17. M\u2019ent\u00E9n? Qu\u00E8 vol dir aix\u00F2?  ", "\u00BFMe entiende? \u00BFQu\u00E9 quiere decir esto? ", "b03-17" },
                new java.lang.String[] { "18. Com? Com diu?  ", "\u00BFC\u00F3mo? \u00BFQu\u00E9 dice? ", "b03-18" },
                new java.lang.String[] { "19. Qu\u00E8 diu? Qu\u00E8 vol?  ", "\u00BFQu\u00E9 dice? \u00BFQu\u00E9 quiere? ", "b03-19" },
                new java.lang.String[] { "20. On va? D\u2019on ve?  ", "\u00BFD\u00F3nde va? \u00BFDe d\u00F3nde viene? ", "b03-20" },
                new java.lang.String[] { "21. N\u2019est\u00E0 segur? De veres?  ", "\u00BFEst\u00E1 seguro? \u00BFDe verdad? ", "b03-21" },
                new java.lang.String[] { "22. Quan? Des de quan? Fins quan?  ", "\u00BFCu\u00E1ndo? \u00BFDesde cu\u00E1ndo? \u00BFHasta cu\u00E1ndo? ", "b03-22" },
                new java.lang.String[] { "23. Digui? Amb qui parl? De part de qui?  ", "\u00BFDiga? \u00BFCon qui\u00E9n hablo? \u00BFDe parte de qui\u00E9n? ", "b03-23" },
                new java.lang.String[] { "24. Hi ha cap dubte? Entesos?  ", "\u00BFHay alguna duda? \u00BFDe acuerdo? ", "b03-24" },
                new java.lang.String[] { "25. -T\u2019agrada? - S\u00ED, molt. | No, gens.  ", "\u00BFTe gusta? - S\u00ED, mucho. | No, nada. ", "b03-25" },
                new java.lang.String[] { "26. Que puc fumar? Que hi puc aparcar, aqu\u00ED?  ", "\u00BFSe puede fumar? \u00BFSe puede aparcar? ", "b03-26" }}, new java.lang.String[] { "Catal\u00E1", "Espa\u00F1ol", "FILE" });//GEN-END:|312-getter|1|312-postInit
        // write post-init user code here
        }//GEN-BEGIN:|312-getter|2|
        return tableModel3;
    }
    //</editor-fold>//GEN-END:|312-getter|2|

    //<editor-fold defaultstate="collapsed" desc=" Generated Getter: itemCommand3 ">//GEN-BEGIN:|314-getter|0|314-preInit
    /**
     * Returns an initiliazed instance of itemCommand3 component.
     * @return the initialized component instance
     */
    public Command getItemCommand3() {
        if (itemCommand3 == null) {//GEN-END:|314-getter|0|314-preInit
            // write pre-init user code here
            itemCommand3 = new Command("Escuchar", Command.ITEM, 0);//GEN-LINE:|314-getter|1|314-postInit
        // write post-init user code here
        }//GEN-BEGIN:|314-getter|2|
        return itemCommand3;
    }
    //</editor-fold>//GEN-END:|314-getter|2|

    //<editor-fold defaultstate="collapsed" desc=" Generated Getter: tableItem4 ">//GEN-BEGIN:|317-getter|0|317-preInit
    /**
     * Returns an initiliazed instance of tableItem4 component.
     * @return the initialized component instance
     */
    public TableItem getTableItem4() {
        if (tableItem4 == null) {//GEN-END:|317-getter|0|317-preInit
            // write pre-init user code here
            tableItem4 = new TableItem(getDisplay(), "");//GEN-BEGIN:|317-getter|1|317-postInit
            tableItem4.setItemCommandListener(this);
            tableItem4.setModel(getTableModel4());//GEN-END:|317-getter|1|317-postInit
        // write post-init user code here
        }//GEN-BEGIN:|317-getter|2|
        return tableItem4;
    }
    //</editor-fold>//GEN-END:|317-getter|2|

    //<editor-fold defaultstate="collapsed" desc=" Generated Getter: tableModel4 ">//GEN-BEGIN:|320-getter|0|320-preInit
    /**
     * Returns an initiliazed instance of tableModel4 component.
     * @return the initialized component instance
     */
    public SimpleTableModel getTableModel4() {
        if (tableModel4 == null) {//GEN-END:|320-getter|0|320-preInit
            // write pre-init user code here
            tableModel4 = new SimpleTableModel(new java.lang.String[][] {//GEN-BEGIN:|320-getter|1|320-postInit
                new java.lang.String[] { "1. S\u00ED. D\u2018acord. Em sembla b\u00E9.  ", "S\u00ED. De acuerdo. Me parece bien. ", "b04-01 " },
                new java.lang.String[] { "2. \u00C9s ver. Exacte.  ", "Es verdad. Exacto. ", "b04-02 " },
                new java.lang.String[] { "3. Com vulgui. Ho entenc.  ", "Como quiera. Lo entiendo. ", "b04-03" },
                new java.lang.String[] { "4. T\u00E9 ra\u00F3. \u00C9s clar. Naturalment.  ", "Tiene raz\u00F3n. Claro. Naturalmente. ", "b04-04" },
                new java.lang.String[] { "5. M\u00E9s o menys. Crec que s\u00ED.  ", "M\u00E1s o menos. Creo que s\u00ED. ", "b04-05" }}, new java.lang.String[] { "Catal\u00E1", "Espa\u00F1ol", "FILE" });//GEN-END:|320-getter|1|320-postInit
        // write post-init user code here
        }//GEN-BEGIN:|320-getter|2|
        return tableModel4;
    }
    //</editor-fold>//GEN-END:|320-getter|2|

    //<editor-fold defaultstate="collapsed" desc=" Generated Getter: itemCommand4 ">//GEN-BEGIN:|322-getter|0|322-preInit
    /**
     * Returns an initiliazed instance of itemCommand4 component.
     * @return the initialized component instance
     */
    public Command getItemCommand4() {
        if (itemCommand4 == null) {//GEN-END:|322-getter|0|322-preInit
            // write pre-init user code here
            itemCommand4 = new Command("Escuchar", Command.ITEM, 0);//GEN-LINE:|322-getter|1|322-postInit
        // write post-init user code here
        }//GEN-BEGIN:|322-getter|2|
        return itemCommand4;
    }
    //</editor-fold>//GEN-END:|322-getter|2|

    //<editor-fold defaultstate="collapsed" desc=" Generated Getter: tableItem5 ">//GEN-BEGIN:|325-getter|0|325-preInit
    /**
     * Returns an initiliazed instance of tableItem5 component.
     * @return the initialized component instance
     */
    public TableItem getTableItem5() {
        if (tableItem5 == null) {//GEN-END:|325-getter|0|325-preInit
            // write pre-init user code here
            tableItem5 = new TableItem(getDisplay(), "");//GEN-BEGIN:|325-getter|1|325-postInit
            tableItem5.setModel(getTableModel5());//GEN-END:|325-getter|1|325-postInit
        // write post-init user code here
        }//GEN-BEGIN:|325-getter|2|
        return tableItem5;
    }
    //</editor-fold>//GEN-END:|325-getter|2|

    //<editor-fold defaultstate="collapsed" desc=" Generated Getter: tableModel5 ">//GEN-BEGIN:|326-getter|0|326-preInit
    /**
     * Returns an initiliazed instance of tableModel5 component.
     * @return the initialized component instance
     */
    public SimpleTableModel getTableModel5() {
        if (tableModel5 == null) {//GEN-END:|326-getter|0|326-preInit
            // write pre-init user code here
            tableModel5 = new SimpleTableModel(new java.lang.String[][] {//GEN-BEGIN:|326-getter|1|326-postInit
                new java.lang.String[] { "1. No, em sap greu. No, s\u2019ha equivocat.  ", "No, lo siento. No, se ha equivocado. ", "b05-01 " },
                new java.lang.String[] { "2. De cap manera. Mai de la vida.  ", "De ninguna manera. Jam\u00E1s en la vida. ", "b05-02" },
                new java.lang.String[] { "3. Ni parlar-ne. Aix\u00F2 \u00E9s impossible.  ", "Ni hablar. Eso es imposible. ", "b05-03" },
                new java.lang.String[] { "4. Prou! Ja n\u2019hi ha prou!  ", "\u00A1Basta! \u00A1Ya basta! ", "b05-04" }}, new java.lang.String[] { "Catal\u00E0", "Espa\u00F1ol", "FILE" });//GEN-END:|326-getter|1|326-postInit
        // write post-init user code here
        }//GEN-BEGIN:|326-getter|2|
        return tableModel5;
    }
    //</editor-fold>//GEN-END:|326-getter|2|

    //<editor-fold defaultstate="collapsed" desc=" Generated Getter: itemCommand5 ">//GEN-BEGIN:|328-getter|0|328-preInit
    /**
     * Returns an initiliazed instance of itemCommand5 component.
     * @return the initialized component instance
     */
    public Command getItemCommand5() {
        if (itemCommand5 == null) {//GEN-END:|328-getter|0|328-preInit
            // write pre-init user code here
            itemCommand5 = new Command("Escuchar", Command.ITEM, 0);//GEN-LINE:|328-getter|1|328-postInit
        // write post-init user code here
        }//GEN-BEGIN:|328-getter|2|
        return itemCommand5;
    }
    //</editor-fold>//GEN-END:|328-getter|2|

    //<editor-fold defaultstate="collapsed" desc=" Generated Getter: tableItem6 ">//GEN-BEGIN:|331-getter|0|331-preInit
    /**
     * Returns an initiliazed instance of tableItem6 component.
     * @return the initialized component instance
     */
    public TableItem getTableItem6() {
        if (tableItem6 == null) {//GEN-END:|331-getter|0|331-preInit
            // write pre-init user code here
            tableItem6 = new TableItem(getDisplay(), "");//GEN-BEGIN:|331-getter|1|331-postInit
            tableItem6.setModel(getTableModel6());//GEN-END:|331-getter|1|331-postInit
        // write post-init user code here
        }//GEN-BEGIN:|331-getter|2|
        return tableItem6;
    }
    //</editor-fold>//GEN-END:|331-getter|2|

    //<editor-fold defaultstate="collapsed" desc=" Generated Getter: tableModel6 ">//GEN-BEGIN:|332-getter|0|332-preInit
    /**
     * Returns an initiliazed instance of tableModel6 component.
     * @return the initialized component instance
     */
    public SimpleTableModel getTableModel6() {
        if (tableModel6 == null) {//GEN-END:|332-getter|0|332-preInit
            // write pre-init user code here
            tableModel6 = new SimpleTableModel(new java.lang.String[][] {//GEN-BEGIN:|332-getter|1|332-postInit
                new java.lang.String[] { "1. Per ventura. Tal vegada. Potser s\u00ED.  ", "Quiz\u00E1s. Tal vez. Puede que s\u00ED. ", "b06-01 " },
                new java.lang.String[] { "2. Dep\u00E8n.  ", "Depende. ", "b06-02" },
                new java.lang.String[] { "3. No ho s\u00E9. No ho crec.  ", "No lo s\u00E9. No lo creo. ", "b06-03" }}, new java.lang.String[] { "Catal\u00E0", "Espa\u00F1ol", "FILE" });//GEN-END:|332-getter|1|332-postInit
        // write post-init user code here
        }//GEN-BEGIN:|332-getter|2|
        return tableModel6;
    }
    //</editor-fold>//GEN-END:|332-getter|2|

    //<editor-fold defaultstate="collapsed" desc=" Generated Getter: itemCommand6 ">//GEN-BEGIN:|334-getter|0|334-preInit
    /**
     * Returns an initiliazed instance of itemCommand6 component.
     * @return the initialized component instance
     */
    public Command getItemCommand6() {
        if (itemCommand6 == null) {//GEN-END:|334-getter|0|334-preInit
            // write pre-init user code here
            itemCommand6 = new Command("Escuchar", Command.ITEM, 0);//GEN-LINE:|334-getter|1|334-postInit
        // write post-init user code here
        }//GEN-BEGIN:|334-getter|2|
        return itemCommand6;
    }
    //</editor-fold>//GEN-END:|334-getter|2|

    //<editor-fold defaultstate="collapsed" desc=" Generated Getter: itemCommand7 ">//GEN-BEGIN:|337-getter|0|337-preInit
    /**
     * Returns an initiliazed instance of itemCommand7 component.
     * @return the initialized component instance
     */
    public Command getItemCommand7() {
        if (itemCommand7 == null) {//GEN-END:|337-getter|0|337-preInit
            // write pre-init user code here
            itemCommand7 = new Command("Item", Command.ITEM, 0);//GEN-LINE:|337-getter|1|337-postInit
        // write post-init user code here
        }//GEN-BEGIN:|337-getter|2|
        return itemCommand7;
    }
    //</editor-fold>//GEN-END:|337-getter|2|

    //<editor-fold defaultstate="collapsed" desc=" Generated Getter: tableItem7 ">//GEN-BEGIN:|339-getter|0|339-preInit
    /**
     * Returns an initiliazed instance of tableItem7 component.
     * @return the initialized component instance
     */
    public TableItem getTableItem7() {
        if (tableItem7 == null) {//GEN-END:|339-getter|0|339-preInit
            // write pre-init user code here
            tableItem7 = new TableItem(getDisplay(), "");//GEN-BEGIN:|339-getter|1|339-postInit
            tableItem7.setModel(getTableModel7());//GEN-END:|339-getter|1|339-postInit
        // write post-init user code here
        }//GEN-BEGIN:|339-getter|2|
        return tableItem7;
    }
    //</editor-fold>//GEN-END:|339-getter|2|

    //<editor-fold defaultstate="collapsed" desc=" Generated Getter: tableModel7 ">//GEN-BEGIN:|340-getter|0|340-preInit
    /**
     * Returns an initiliazed instance of tableModel7 component.
     * @return the initialized component instance
     */
    public SimpleTableModel getTableModel7() {
        if (tableModel7 == null) {//GEN-END:|340-getter|0|340-preInit
            // write pre-init user code here
            tableModel7 = new SimpleTableModel(new java.lang.String[][] {//GEN-BEGIN:|340-getter|1|340-postInit
                new java.lang.String[] { "1. D\u2019acord. Estam d\u2018acord.  ", "De acuerdo. Estamos de acuerdo. ", "b07-01 " },
                new java.lang.String[] { "2. B\u00E9. Molt b\u00E9. Que b\u00E9!  ", "Bien. Muy bien. \u00A1Qu\u00E9 bien! ", "b07-02" },
                new java.lang.String[] { "3. Tot va b\u00E9.  ", "Todo va bien. ", "b07-03" },
                new java.lang.String[] { "4. Malament. Que malament!  ", "Mal. \u00A1Qu\u00E9 mal! ", "b07-04" },
                new java.lang.String[] { "5. Un poc millor.  ", "Un poco mejor. ", "b07-05" },
                new java.lang.String[] { "6. Quina ll\u00E0stima! Quina r\u00E0bia!  ", "\u00A1Qu\u00E9 l\u00E1stima! \u00A1Qu\u00E9 rabia! ", "b07-06" },
                new java.lang.String[] { "7. Quina sort! Quina mala sort!  ", "\u00A1Qu\u00E9 suerte! \u00A1Qu\u00E9 mala suerte! ", "b07-07" },
                new java.lang.String[] { "8. Quin doi! Quina vergonya!  ", "\u00A1Qu\u00E9 tonter\u00EDa! \u00A1Qu\u00E9 verg\u00FCenza! ", "b07-08" },
                new java.lang.String[] { "9. \u00C9s curi\u00F3s. \u00C9s estrany. \u00C9s rid\u00EDcul.  ", "Es curioso. Es extra\u00F1o. Es rid\u00EDculo. ", "b07-09" },
                new java.lang.String[] { "10. Que guapa! / Que polida! Que simp\u00E0tic!  ", "\u00A1Qu\u00E9 guapa! \u00A1Qu\u00E9 simp\u00E1tico! ", "b07-10" },
                new java.lang.String[] { "11. Que lleig! Que \u00E9s d\u2019horrorosa!  ", "\u00A1Qu\u00E9 feo! \u00A1Qu\u00E9 horrorosa! ", "b07-11" },
                new java.lang.String[] { "12. Que trist! Que divertida!  ", "\u00A1Qu\u00E9 triste! \u00A1Qu\u00E9 divertida! ", "b07-12" },
                new java.lang.String[] { "13. Meravell\u00F3s! Fant\u00E0stic!  ", "\u00A1Maravilloso! \u00A1Fant\u00E1stico! ", "b07-13" },
                new java.lang.String[] { "14. Bona sort. Molta sort.  ", "Buena suerte. Mala suerte. ", "b07-14" },
                new java.lang.String[] { "15. \u00C9s igual. No hi fa res.  ", "Es igual. No pasa nada. ", "b07-15" },
                new java.lang.String[] { "16. Ja est\u00E0 llest.  ", "Ya est\u00E1 listo. ", "b07-16" },
                new java.lang.String[] { "17. Per sort. Per desgr\u00E0cia.  ", "Por suerte. Por desgracia. ", "b07-17" },
                new java.lang.String[] { "18. Tant de bo!  ", "\u00A1Ojal\u00E1! ", "b07-18" }}, new java.lang.String[] { "Catal\u00E0", "Espa\u00F1ol", "FILE" });//GEN-END:|340-getter|1|340-postInit
        // write post-init user code here
        }//GEN-BEGIN:|340-getter|2|
        return tableModel7;
    }
    //</editor-fold>//GEN-END:|340-getter|2|

    //<editor-fold defaultstate="collapsed" desc=" Generated Getter: itemCommand8 ">//GEN-BEGIN:|343-getter|0|343-preInit
    /**
     * Returns an initiliazed instance of itemCommand8 component.
     * @return the initialized component instance
     */
    public Command getItemCommand8() {
        if (itemCommand8 == null) {//GEN-END:|343-getter|0|343-preInit
            // write pre-init user code here
            itemCommand8 = new Command("Escuchar", Command.ITEM, 0);//GEN-LINE:|343-getter|1|343-postInit
        // write post-init user code here
        }//GEN-BEGIN:|343-getter|2|
        return itemCommand8;
    }
    //</editor-fold>//GEN-END:|343-getter|2|

    //<editor-fold defaultstate="collapsed" desc=" Generated Getter: tableItem8 ">//GEN-BEGIN:|345-getter|0|345-preInit
    /**
     * Returns an initiliazed instance of tableItem8 component.
     * @return the initialized component instance
     */
    public TableItem getTableItem8() {
        if (tableItem8 == null) {//GEN-END:|345-getter|0|345-preInit
            // write pre-init user code here
            tableItem8 = new TableItem(getDisplay(), "");//GEN-BEGIN:|345-getter|1|345-postInit
            tableItem8.setModel(getTableModel8());//GEN-END:|345-getter|1|345-postInit
        // write post-init user code here
        }//GEN-BEGIN:|345-getter|2|
        return tableItem8;
    }
    //</editor-fold>//GEN-END:|345-getter|2|

    //<editor-fold defaultstate="collapsed" desc=" Generated Getter: tableModel8 ">//GEN-BEGIN:|346-getter|0|346-preInit
    /**
     * Returns an initiliazed instance of tableModel8 component.
     * @return the initialized component instance
     */
    public SimpleTableModel getTableModel8() {
        if (tableModel8 == null) {//GEN-END:|346-getter|0|346-preInit
            // write pre-init user code here
            tableModel8 = new SimpleTableModel(new java.lang.String[][] {//GEN-BEGIN:|346-getter|1|346-postInit
                new java.lang.String[] { "1. Som alt. Som m\u00E9s alt. Som el m\u00E9s alt. Som alta. Som m\u00E9s alta. Som la m\u00E9s alta.  ", "Soy alto. Soy m\u00E1s alto. Soy el m\u00E1s alto. Soy alta. Soy m\u00E1s alta. Soy la m\u00E1s alta. ", "b08-01 " },
                new java.lang.String[] { "2. Estic b\u00E9. / Em trob b\u00E9. Estic molt b\u00E9. / Em trob molt b\u00E9. No estic gaire b\u00E9. / No em trob gaire b\u00E9.  ", "Estoy bien. / Me encuentro bien. Estoy muy bien. / Me encuentro muy bien. No estoy muy bien. / No me encuentro muy bien. ", "b08-02" },
                new java.lang.String[] { "3. Tenc gana. Tenc set. Tenc molta gana. Tenc molta set.  ", "Tengo hambre. Tengo sed. Tengo mucha hambre. Tengo mucha sed. ", "b08-03" },
                new java.lang.String[] { "4. Tenc fred. Tenc calor. Tenc molt de fred. Tenc molta calor.  ", "Tengo fr\u00EDo. Tengo calor. Tengo mucho fr\u00EDo. Tengo mucho calor. ", "b08-04" },
                new java.lang.String[] { "5. Tenc por. Tenc molta por. Aix\u00F2 em fa por. Aix\u00F2 em fa molta de por.  ", "Tengo miedo. Tengo mucho miedo. Esto me da miedo. Esto me da mucho miedo. ", "b08-05" },
                new java.lang.String[] { "6. \u00C9s f\u00E0cil. Sembla f\u00E0cil. \u00C9s dif\u00EDcil. Sembla dif\u00EDcil.  ", "Es f\u00E1cil. Parece f\u00E1cil. Es dif\u00EDcil. Parece dif\u00EDcil. ", "b08-06" },
                new java.lang.String[] { "7. Em fa mal el coll. Em fan mal les cames.  ", "Me duele el cuello. Me duelen las piernas. ", "b08-07" },
                new java.lang.String[] { "8. Tenc mal de cap. Tenc febre.  ", "Me duele la cabeza. Tengo fiebre. ", "b08-08" },
                new java.lang.String[] { "9. Necessit ajuda. Necessit un metge. Necessit una ambul\u00E0ncia.  ", "Necesito ayuda. Necesito un m\u00E9dico. Necesito una ambulancia. ", "b08-09" },
                new java.lang.String[] { "10. Tenc ganes de passejar. M\u2019agradaria passejar.  ", "Tengo ganas de pasear. Me gustar\u00EDa pasear. ", "b08-10" },
                new java.lang.String[] { "11. M\u2019estim m\u00E9s anar al cinema.  ", "Prefiero ir al cine. ", "b08-11" },
                new java.lang.String[] { "12. M\u2019agrada llegir. M\u2019agrada aquesta ciutat.  ", "Me gusta leer. Me gusta esta ciudad. ", "b08-12" },
                new java.lang.String[] { "13. Em fa ganes. Em fa il\u00FAlusi\u00F3. Em fa gr\u00E0cia.  ", "Me apetece. Me hace ilusi\u00F3n. Me hace gracia. ", "b08-13" },
                new java.lang.String[] { "14. Em costa molt. Em duu molta feina.  ", "Me cuesta mucho. Me cuesta mucho trabajo. ", "b08-14" }}, new java.lang.String[] { "Catal\u00E0", "Espa\u00F1ol", "FILE" });//GEN-END:|346-getter|1|346-postInit
        // write post-init user code here
        }//GEN-BEGIN:|346-getter|2|
        return tableModel8;
    }
    //</editor-fold>//GEN-END:|346-getter|2|

    //<editor-fold defaultstate="collapsed" desc=" Generated Getter: itemCommand9 ">//GEN-BEGIN:|349-getter|0|349-preInit
    /**
     * Returns an initiliazed instance of itemCommand9 component.
     * @return the initialized component instance
     */
    public Command getItemCommand9() {
        if (itemCommand9 == null) {//GEN-END:|349-getter|0|349-preInit
            // write pre-init user code here
            itemCommand9 = new Command("Escuchar", Command.ITEM, 0);//GEN-LINE:|349-getter|1|349-postInit
        // write post-init user code here
        }//GEN-BEGIN:|349-getter|2|
        return itemCommand9;
    }
    //</editor-fold>//GEN-END:|349-getter|2|

    //<editor-fold defaultstate="collapsed" desc=" Generated Getter: tableItem9 ">//GEN-BEGIN:|351-getter|0|351-preInit
    /**
     * Returns an initiliazed instance of tableItem9 component.
     * @return the initialized component instance
     */
    public TableItem getTableItem9() {
        if (tableItem9 == null) {//GEN-END:|351-getter|0|351-preInit
            // write pre-init user code here
            tableItem9 = new TableItem(getDisplay(), "");//GEN-BEGIN:|351-getter|1|351-postInit
            tableItem9.setModel(getTableModel9());//GEN-END:|351-getter|1|351-postInit
        // write post-init user code here
        }//GEN-BEGIN:|351-getter|2|
        return tableItem9;
    }
    //</editor-fold>//GEN-END:|351-getter|2|

    //<editor-fold defaultstate="collapsed" desc=" Generated Getter: tableModel9 ">//GEN-BEGIN:|352-getter|0|352-preInit
    /**
     * Returns an initiliazed instance of tableModel9 component.
     * @return the initialized component instance
     */
    public SimpleTableModel getTableModel9() {
        if (tableModel9 == null) {//GEN-END:|352-getter|0|352-preInit
            // write pre-init user code here
            tableModel9 = new SimpleTableModel(new java.lang.String[][] {//GEN-BEGIN:|352-getter|1|352-postInit
                new java.lang.String[] { "1. Blanc, beix, groc, carabassa, verd, blau, lila, vermell, grana, marr\u00F3, gris, negre.  ", "Blanco, beige, amarillo, naranja, verde, azul, lila, rojo, grana, marr\u00F3n, gris, negro. ", "b09-01 " },
                new java.lang.String[] { "2. - De quin color \u00E9s? - \u00C9s de color blanc. / \u00C9s blanc. | \u00C9s de color blau. / \u00C9s blau.  ", "\u00BFDe qu\u00E9 color es? - Es de color blanco. / Es blanco. | Es de color azul. / Es azul. ", "b09-02" },
                new java.lang.String[] { "3. M\u2019agrada aquest color. No m\u2019agrada gens aquest color.  ", "Me gusta este color. No me gusta nada este color. ", "b09-03" },
                new java.lang.String[] { "4. \u00C9s massa clar. No \u00E9s gaire fosc.  ", "Es demasiado claro. No es muy oscuro. ", "b09-04" }}, new java.lang.String[] { "Catal\u00E0", "Espa\u00F1ol", "FILE" });//GEN-END:|352-getter|1|352-postInit
        // write post-init user code here
        }//GEN-BEGIN:|352-getter|2|
        return tableModel9;
    }
    //</editor-fold>//GEN-END:|352-getter|2|

    //<editor-fold defaultstate="collapsed" desc=" Generated Getter: itemCommand10 ">//GEN-BEGIN:|355-getter|0|355-preInit
    /**
     * Returns an initiliazed instance of itemCommand10 component.
     * @return the initialized component instance
     */
    public Command getItemCommand10() {
        if (itemCommand10 == null) {//GEN-END:|355-getter|0|355-preInit
            // write pre-init user code here
            itemCommand10 = new Command("Escuchar", Command.ITEM, 0);//GEN-LINE:|355-getter|1|355-postInit
        // write post-init user code here
        }//GEN-BEGIN:|355-getter|2|
        return itemCommand10;
    }
    //</editor-fold>//GEN-END:|355-getter|2|

    //<editor-fold defaultstate="collapsed" desc=" Generated Getter: tableItem10 ">//GEN-BEGIN:|357-getter|0|357-preInit
    /**
     * Returns an initiliazed instance of tableItem10 component.
     * @return the initialized component instance
     */
    public TableItem getTableItem10() {
        if (tableItem10 == null) {//GEN-END:|357-getter|0|357-preInit
            // write pre-init user code here
            tableItem10 = new TableItem(getDisplay(), "");//GEN-BEGIN:|357-getter|1|357-postInit
            tableItem10.setModel(getTableModel10());//GEN-END:|357-getter|1|357-postInit
        // write post-init user code here
        }//GEN-BEGIN:|357-getter|2|
        return tableItem10;
    }
    //</editor-fold>//GEN-END:|357-getter|2|

    //<editor-fold defaultstate="collapsed" desc=" Generated Getter: tableModel10 ">//GEN-BEGIN:|358-getter|0|358-preInit
    /**
     * Returns an initiliazed instance of tableModel10 component.
     * @return the initialized component instance
     */
    public SimpleTableModel getTableModel10() {
        if (tableModel10 == null) {//GEN-END:|358-getter|0|358-preInit
            // write pre-init user code here
            tableModel10 = new SimpleTableModel(new java.lang.String[][] {//GEN-BEGIN:|358-getter|1|358-postInit
                new java.lang.String[] { "1. U / un / una, dos / dues, tres, quatre, cinc, sis, set, vuit, nou, deu.  ", "Un / uno / una, dos, tres, cuatro, cinco, seis, siete, ocho, nueve, diez. ", "b10-01 " },
                new java.lang.String[] { "2. Onze, dotze, tretze, catorze, quinze, setze, desset/disset, devuit/divuit, denou/dinou, vint.  ", "Once, doce, trece, catorce, quince, diecis\u00E9is, diecisiete, dieciocho, diecinueve, veinte. ", "b10-02" },
                new java.lang.String[] { "3. Trenta, quaranta, cinquanta, seixanta, setanta, vuitanta, noranta, cent, mil.  ", "Treinta, cuarenta, cincuenta, sesenta, setenta, ochenta, noventa, cien, mil. ", "b10-03" },
                new java.lang.String[] { "4. Mig / mitja, un quart, dos quarts, una dotzena.  ", "Medio / media, un cuarto, dos cuartos, una docena. ", "b10-04" }}, new java.lang.String[] { "Catal\u00E1", "Espa\u00F1ol", "FILE" });//GEN-END:|358-getter|1|358-postInit
        // write post-init user code here
        }//GEN-BEGIN:|358-getter|2|
        return tableModel10;
    }
    //</editor-fold>//GEN-END:|358-getter|2|

    //<editor-fold defaultstate="collapsed" desc=" Generated Getter: tableItem11 ">//GEN-BEGIN:|361-getter|0|361-preInit
    /**
     * Returns an initiliazed instance of tableItem11 component.
     * @return the initialized component instance
     */
    public TableItem getTableItem11() {
        if (tableItem11 == null) {//GEN-END:|361-getter|0|361-preInit
            // write pre-init user code here
            tableItem11 = new TableItem(getDisplay(), "");//GEN-BEGIN:|361-getter|1|361-postInit
            tableItem11.addCommand(getItemCommand11());
            tableItem11.setItemCommandListener(this);
            tableItem11.setModel(getTableModel11());//GEN-END:|361-getter|1|361-postInit
        // write post-init user code here
        }//GEN-BEGIN:|361-getter|2|
        return tableItem11;
    }
    //</editor-fold>//GEN-END:|361-getter|2|

    //<editor-fold defaultstate="collapsed" desc=" Generated Getter: tableModel11 ">//GEN-BEGIN:|362-getter|0|362-preInit
    /**
     * Returns an initiliazed instance of tableModel11 component.
     * @return the initialized component instance
     */
    public SimpleTableModel getTableModel11() {
        if (tableModel11 == null) {//GEN-END:|362-getter|0|362-preInit
            // write pre-init user code here
            tableModel11 = new SimpleTableModel(new java.lang.String[][] {//GEN-BEGIN:|362-getter|1|362-postInit
                new java.lang.String[] { "1. - Quina hora \u00E9s, per favor? - S\u00F3n les quatre i quart.  ", "\u00BFQue hora es, por favor? - Son las cuatro y cuarto. ", "b11-01" },
                new java.lang.String[] { "2. Avui. Dem\u00E0. Ahir. Passat dem\u00E0 / Dem\u00E0 passat. Desp\u00FAs-ahir.  ", "Hoy. Ma\u00F1ana. Ayer. Pasado ma\u00F1ana. Anteayer. ", "b11-02" },
                new java.lang.String[] { "3. - Quin dia \u00E9s avui? - Avui \u00E9s dimecres, 6 de setembre de 2000.  ", "\u00BFQu\u00E9 d\u00EDa es hoy? - Hoy es mi\u00E9rcoles, 6 de septiembre del 2000. ", "b11-03" },
                new java.lang.String[] { "4. Mat\u00ED / Demat\u00ED. Migdia. Horabaixa / Tarda. Vespre. Nit. Matinada.  ", "Ma\u00F1ana. Mediod\u00EDa. Tarde. Noche. Madrugada. ", "b11-04" },
                new java.lang.String[] { "5. Les classes s\u00F3n al vespre. Ell arriba al mat\u00ED.  ", "Las clases son por la noche. \u00C9l llega por la ma\u00F1ana. ", "b11-05" },
                new java.lang.String[] { "6. \u00C9s de dia. \u00C9s de nit. Es fa fosc.  ", "Es de d\u00EDa. Es de noche. Oscurece. ", "b11-06" },
                new java.lang.String[] { "7. El dinar se serveix a les dues. El sopar \u00E9s a les vuit i mitja.  ", "La comida se sirve a las dos. La cena es a las ocho y media. ", "b11-07" },
                new java.lang.String[] { "8. - Quin temps dura? - Cinc hores.  ", "\u00BFCu\u00E1nto tiempo dura? - Cinco horas. ", "b11-08" },
                new java.lang.String[] { "9. - Quin temps falta? - Tres setmanes.  ", "\u00BFCu\u00E1nto tiempo falta? - Tres semanas. ", "b11-09" },
                new java.lang.String[] { "10. - Quin temps estar\u00E0 a tornar? - Devers una hora.  ", "\u00BFCu\u00E1nto tiempo tardar\u00E1 en volver? - Aproximadamente una hora. ", "b11-10" },
                new java.lang.String[] { "11. Fa tres setmanes. Des de fa set setmanes.  ", "Hace tres semanas. Desde hace siete semanas. ", "b11-11" },
                new java.lang.String[] { "12. Abans de dues hores. Despr\u00E9s de quatre dies.  ", "Antes de dos horas. Despu\u00E9s de cuatro d\u00EDas. ", "b11-12" },
                new java.lang.String[] { "13. A les nou i quart. Devers les set i vint.  ", "A las nueve y cuarto. Sobre las siete y veinte. ", "b11-13" },
                new java.lang.String[] { "14. Tenc molt de temps. Tenc poc temps. No tenc temps.  ", "Tengo mucho tiempo. Tengo poco tiempo. No tengo tiempo. ", "b11-14" }}, new java.lang.String[] { "Catal\u00E0", "Espa\u00F1ol", "FILE" });//GEN-END:|362-getter|1|362-postInit
        // write post-init user code here
        }//GEN-BEGIN:|362-getter|2|
        return tableModel11;
    }
    //</editor-fold>//GEN-END:|362-getter|2|

    //<editor-fold defaultstate="collapsed" desc=" Generated Getter: itemCommand11 ">//GEN-BEGIN:|363-getter|0|363-preInit
    /**
     * Returns an initiliazed instance of itemCommand11 component.
     * @return the initialized component instance
     */
    public Command getItemCommand11() {
        if (itemCommand11 == null) {//GEN-END:|363-getter|0|363-preInit
            // write pre-init user code here
            itemCommand11 = new Command("Escuchar", Command.ITEM, 0);//GEN-LINE:|363-getter|1|363-postInit
        // write post-init user code here
        }//GEN-BEGIN:|363-getter|2|
        return itemCommand11;
    }
    //</editor-fold>//GEN-END:|363-getter|2|

    //<editor-fold defaultstate="collapsed" desc=" Generated Getter: itemCommand12 ">//GEN-BEGIN:|369-getter|0|369-preInit
    /**
     * Returns an initiliazed instance of itemCommand12 component.
     * @return the initialized component instance
     */
    public Command getItemCommand12() {
        if (itemCommand12 == null) {//GEN-END:|369-getter|0|369-preInit
            // write pre-init user code here
            itemCommand12 = new Command("Escuchar", Command.ITEM, 0);//GEN-LINE:|369-getter|1|369-postInit
        // write post-init user code here
        }//GEN-BEGIN:|369-getter|2|
        return itemCommand12;
    }
    //</editor-fold>//GEN-END:|369-getter|2|

    //<editor-fold defaultstate="collapsed" desc=" Generated Getter: tableItem12 ">//GEN-BEGIN:|367-getter|0|367-preInit
    /**
     * Returns an initiliazed instance of tableItem12 component.
     * @return the initialized component instance
     */
    public TableItem getTableItem12() {
        if (tableItem12 == null) {//GEN-END:|367-getter|0|367-preInit
            // write pre-init user code here
            tableItem12 = new TableItem(getDisplay(), "");//GEN-BEGIN:|367-getter|1|367-postInit
            tableItem12.setModel(getTableModel12());//GEN-END:|367-getter|1|367-postInit
        // write post-init user code here
        }//GEN-BEGIN:|367-getter|2|
        return tableItem12;
    }
    //</editor-fold>//GEN-END:|367-getter|2|

    //<editor-fold defaultstate="collapsed" desc=" Generated Getter: tableModel12 ">//GEN-BEGIN:|368-getter|0|368-preInit
    /**
     * Returns an initiliazed instance of tableModel12 component.
     * @return the initialized component instance
     */
    public SimpleTableModel getTableModel12() {
        if (tableModel12 == null) {//GEN-END:|368-getter|0|368-preInit
            // write pre-init user code here
            tableModel12 = new SimpleTableModel(new java.lang.String[][] {//GEN-BEGIN:|368-getter|1|368-postInit
                new java.lang.String[] { "1. Dilluns, dimarts, dimecres, dijous, divendres, dissabte, diumenge.  ", "Lunes, martes, mi\u00E9rcoles, jueves, viernes, s\u00E1bado, domingo. ", "b12-01 " },
                new java.lang.String[] { "2. Gener, febrer, mar\u00E7, abril, maig, juny, juliol, agost, setembre, octubre, novembre, desembre.  ", "Enero, febrero, marzo, abril, mayo, junio, julio, agosto, septiembre, octubre, noviembre, diciembre. ", "b12-02" },
                new java.lang.String[] { "3. Primavera, estiu, tardor, hivern.  ", "Primavera, verano, oto\u00F1o, invierno. ", "b12-03" },
                new java.lang.String[] { "4. Nord, sud, est, oest.  ", "Norte, sur, este, oeste. ", "b12-04" },
                new java.lang.String[] { "5. Els dimarts hi ha mercat. Dimecres vaig a Barcelona.  ", "Los martes hay mercado. El mi\u00E9rcoles voy a Barcelona. ", "b12-05" },
                new java.lang.String[] { "6. El curs comen\u00E7a pel febrer. Es casen pel mar\u00E7.  ", "El curso empieza en enero. Se casan en marzo. ", "b12-06" },
                new java.lang.String[] { "7. Som a la primavera. A l\u2019estiu fa calor.  ", "Estamos en primavera. En verano hace calor. ", "b12-07" },
                new java.lang.String[] { "8. Pollen\u00E7a \u00E9s al nord. Santany\u00ED \u00E9s al sud.  ", "Pollen\u00E7a est\u00E1 en el norte. Santany\u00ED est\u00E1 en el sur. ", "b12-08" }}, new java.lang.String[] { "Catal\u00E0", "Espa\u00F1ol", "FILE" });//GEN-END:|368-getter|1|368-postInit
        // write post-init user code here
        }//GEN-BEGIN:|368-getter|2|
        return tableModel12;
    }
    //</editor-fold>//GEN-END:|368-getter|2|

    //<editor-fold defaultstate="collapsed" desc=" Generated Getter: tableItem13 ">//GEN-BEGIN:|373-getter|0|373-preInit
    /**
     * Returns an initiliazed instance of tableItem13 component.
     * @return the initialized component instance
     */
    public TableItem getTableItem13() {
        if (tableItem13 == null) {//GEN-END:|373-getter|0|373-preInit
            // write pre-init user code here
            tableItem13 = new TableItem(getDisplay(), "");//GEN-BEGIN:|373-getter|1|373-postInit
            tableItem13.setModel(getTableModel13());//GEN-END:|373-getter|1|373-postInit
            // write post-init user code here
        }//GEN-BEGIN:|373-getter|2|
        return tableItem13;
    }
    //</editor-fold>//GEN-END:|373-getter|2|

    //<editor-fold defaultstate="collapsed" desc=" Generated Getter: tableModel13 ">//GEN-BEGIN:|374-getter|0|374-preInit
    /**
     * Returns an initiliazed instance of tableModel13 component.
     * @return the initialized component instance
     */
    public SimpleTableModel getTableModel13() {
        if (tableModel13 == null) {//GEN-END:|374-getter|0|374-preInit
            // write pre-init user code here
            tableModel13 = new SimpleTableModel(new java.lang.String[][] {//GEN-BEGIN:|374-getter|1|374-postInit
                new java.lang.String[] { "1. - Quants d\u2019anys t\u00E9? | Quants d\u2019anys tens? - Tenc 34 anys.  ", "\u00BFCu\u00E1ntos a\u00F1os tiene? |\u00BFCu\u00E1ntos a\u00F1os tienes? - Tengo 34 a\u00F1os. ", "b13-01" },
                new java.lang.String[] { "2. - Quan fas els anys? - D\u2019aqu\u00ED a un mes.  ", "\u00BFCu\u00E1ndo cumples a\u00F1os? - Dentro de un mes. ", "b13-02" },
                new java.lang.String[] { "3. Vaig n\u00E9ixer a Manacor el dia 2 de mar\u00E7 de 1962.  ", "Nac\u00ED en Manacor el d\u00EDa 2 de marzo de 1962. ", "b13-03" }}, new java.lang.String[] { "Catal\u00E0", "Espa\u00F1ol", "FILE" });//GEN-END:|374-getter|1|374-postInit
            // write post-init user code here
        }//GEN-BEGIN:|374-getter|2|
        return tableModel13;
    }
    //</editor-fold>//GEN-END:|374-getter|2|

    //<editor-fold defaultstate="collapsed" desc=" Generated Getter: itemCommand13 ">//GEN-BEGIN:|376-getter|0|376-preInit
    /**
     * Returns an initiliazed instance of itemCommand13 component.
     * @return the initialized component instance
     */
    public Command getItemCommand13() {
        if (itemCommand13 == null) {//GEN-END:|376-getter|0|376-preInit
            // write pre-init user code here
            itemCommand13 = new Command("Escuchar", Command.ITEM, 0);//GEN-LINE:|376-getter|1|376-postInit
            // write post-init user code here
        }//GEN-BEGIN:|376-getter|2|
        return itemCommand13;
    }
    //</editor-fold>//GEN-END:|376-getter|2|

    //<editor-fold defaultstate="collapsed" desc=" Generated Getter: tableItem14 ">//GEN-BEGIN:|379-getter|0|379-preInit
    /**
     * Returns an initiliazed instance of tableItem14 component.
     * @return the initialized component instance
     */
    public TableItem getTableItem14() {
        if (tableItem14 == null) {//GEN-END:|379-getter|0|379-preInit
            // write pre-init user code here
            tableItem14 = new TableItem(getDisplay(), "");//GEN-BEGIN:|379-getter|1|379-postInit
            tableItem14.setModel(getTableModel14());//GEN-END:|379-getter|1|379-postInit
            // write post-init user code here
        }//GEN-BEGIN:|379-getter|2|
        return tableItem14;
    }
    //</editor-fold>//GEN-END:|379-getter|2|

    //<editor-fold defaultstate="collapsed" desc=" Generated Getter: tableModel14 ">//GEN-BEGIN:|380-getter|0|380-preInit
    /**
     * Returns an initiliazed instance of tableModel14 component.
     * @return the initialized component instance
     */
    public SimpleTableModel getTableModel14() {
        if (tableModel14 == null) {//GEN-END:|380-getter|0|380-preInit
            // write pre-init user code here
            tableModel14 = new SimpleTableModel(new java.lang.String[][] {//GEN-BEGIN:|380-getter|1|380-postInit
                new java.lang.String[] { "1. - Quin temps fa avui? - Avui fa bon dia. | Avui fa mal dia.  ", "\u00BFQu\u00E9 tiempo hace hoy? - Hoy hace un buen d\u00EDa. | Hoy hace un mal d\u00EDa. ", "b14-01" },
                new java.lang.String[] { "2. Fa fred. Fa calor. Fa molt de fred. Fa molta calor.  ", "Hace fr\u00EDo. Hace calor. Hace mucho fr\u00EDo. Hace mucho calor. ", "b14-02" },
                new java.lang.String[] { "3. Plou. Neva. Fa sol.  ", "Llueve. Nieva. Hace sol. ", "b14-03" },
                new java.lang.String[] { "4. Est\u00E0 tapat. Est\u00E0 ennigulat. Est\u00E0 estirat.  ", "Est\u00E1 nublado. Est\u00E1 despejado. ", "b14-04" },
                new java.lang.String[] { "5. Fa vent. Fa trons i llamps.  ", "Hace viento. Truena y relampaguea. ", "b14-05" },
                new java.lang.String[] { "6. Hi ha boira. Hi ha humitat. Fa un temps molt sec.  ", "Hay niebla. Hay humedad. Hace un tiempo muy seco. ", "b14-06" }}, new java.lang.String[] { "Catal\u00E0", "Espa\u00F1ol", "FILE" });//GEN-END:|380-getter|1|380-postInit
            // write post-init user code here
        }//GEN-BEGIN:|380-getter|2|
        return tableModel14;
    }
    //</editor-fold>//GEN-END:|380-getter|2|

    //<editor-fold defaultstate="collapsed" desc=" Generated Getter: itemCommand14 ">//GEN-BEGIN:|382-getter|0|382-preInit
    /**
     * Returns an initiliazed instance of itemCommand14 component.
     * @return the initialized component instance
     */
    public Command getItemCommand14() {
        if (itemCommand14 == null) {//GEN-END:|382-getter|0|382-preInit
            // write pre-init user code here
            itemCommand14 = new Command("Escuchar", Command.ITEM, 0);//GEN-LINE:|382-getter|1|382-postInit
            // write post-init user code here
        }//GEN-BEGIN:|382-getter|2|
        return itemCommand14;
    }
    //</editor-fold>//GEN-END:|382-getter|2|

    //<editor-fold defaultstate="collapsed" desc=" Generated Getter: itemCommand15 ">//GEN-BEGIN:|387-getter|0|387-preInit
    /**
     * Returns an initiliazed instance of itemCommand15 component.
     * @return the initialized component instance
     */
    public Command getItemCommand15() {
        if (itemCommand15 == null) {//GEN-END:|387-getter|0|387-preInit
            // write pre-init user code here
            itemCommand15 = new Command("Item", Command.ITEM, 0);//GEN-LINE:|387-getter|1|387-postInit
            // write post-init user code here
        }//GEN-BEGIN:|387-getter|2|
        return itemCommand15;
    }
    //</editor-fold>//GEN-END:|387-getter|2|

    //<editor-fold defaultstate="collapsed" desc=" Generated Getter: itemCommand16 ">//GEN-BEGIN:|389-getter|0|389-preInit
    /**
     * Returns an initiliazed instance of itemCommand16 component.
     * @return the initialized component instance
     */
    public Command getItemCommand16() {
        if (itemCommand16 == null) {//GEN-END:|389-getter|0|389-preInit
            // write pre-init user code here
            itemCommand16 = new Command("Escuchar", Command.ITEM, 0);//GEN-LINE:|389-getter|1|389-postInit
            // write post-init user code here
        }//GEN-BEGIN:|389-getter|2|
        return itemCommand16;
    }
    //</editor-fold>//GEN-END:|389-getter|2|

    //<editor-fold defaultstate="collapsed" desc=" Generated Getter: tableItem15 ">//GEN-BEGIN:|385-getter|0|385-preInit
    /**
     * Returns an initiliazed instance of tableItem15 component.
     * @return the initialized component instance
     */
    public TableItem getTableItem15() {
        if (tableItem15 == null) {//GEN-END:|385-getter|0|385-preInit
            // write pre-init user code here
            tableItem15 = new TableItem(getDisplay(), "");//GEN-BEGIN:|385-getter|1|385-postInit
            tableItem15.addCommand(getItemCommand16());
            tableItem15.setItemCommandListener(this);
            tableItem15.setModel(getTableModel15());//GEN-END:|385-getter|1|385-postInit
            // write post-init user code here
        }//GEN-BEGIN:|385-getter|2|
        return tableItem15;
    }
    //</editor-fold>//GEN-END:|385-getter|2|

    //<editor-fold defaultstate="collapsed" desc=" Generated Getter: tableModel15 ">//GEN-BEGIN:|386-getter|0|386-preInit
    /**
     * Returns an initiliazed instance of tableModel15 component.
     * @return the initialized component instance
     */
    public SimpleTableModel getTableModel15() {
        if (tableModel15 == null) {//GEN-END:|386-getter|0|386-preInit
            // write pre-init user code here
            tableModel15 = new SimpleTableModel(new java.lang.String[][] {//GEN-BEGIN:|386-getter|1|386-postInit
                new java.lang.String[] { "1. Alerta! Anau amb compte!  ", "\u00A1Cuidado! \u00A1Id con cuidado! ", "b15-01" },
                new java.lang.String[] { "2. Atenci\u00F3! Perill.  ", "Atenci\u00F3n. Peligro. ", "b15-02" },
                new java.lang.String[] { "3. Tancat. Tancat del 7 al 15 de juliol.  ", "Cerrado. Cerrado del 7 al 15 de julio. ", "b15-03" },
                new java.lang.String[] { "4. Obert. Obert de les 10 del mat\u00ED a les 7 de l\u2019horabaixa.  ", "Abierto. Abierto de las 10 de la ma\u00F1ana a las 7 de la tarde. ", "b15-04" },
                new java.lang.String[] { "5. Tancau la porta, per favor.  ", "Cierren la puerta, por favor. ", "b15-05" },
                new java.lang.String[] { "6. Deixau passar.  ", "Dejen pasar. ", "b15-06" },
                new java.lang.String[] { "7. No fumeu.  ", "Prohibido fumar. ", "b15-07" },
                new java.lang.String[] { "8. Entrada. Sortida.  ", "Entrada. Salida. ", "b15-08" },
                new java.lang.String[] { "9. Lliure. Ocupat. Privat.  ", "Libre. Ocupado. Privado. ", "b15-09" },
                new java.lang.String[] { "10. Pis en venda. Casa per llogar.  ", "Piso en venta. Casa en alquiler. ", "b15-10" },
                new java.lang.String[] { "11. Rebaixes. Preus rebaixats. Ofertes. Descomptes.  ", "Rebajas. Precios rebajados. Ofertas. Descuentos. ", "b15-11" },
                new java.lang.String[] { "12. Aprofitau l\u2019aigua.  ", "Aproveche el agua. ", "b15-12" },
                new java.lang.String[] { "13. Silenci, per favor.  ", "Silencio, por favor. ", "b15-13" }}, new java.lang.String[] { "Catal\u00E0", "Espa\u00F1ol", "FILE" });//GEN-END:|386-getter|1|386-postInit
            // write post-init user code here
        }//GEN-BEGIN:|386-getter|2|
        return tableModel15;
    }
    //</editor-fold>//GEN-END:|386-getter|2|

    //<editor-fold defaultstate="collapsed" desc=" Generated Getter: itemCommand17 ">//GEN-BEGIN:|395-getter|0|395-preInit
    /**
     * Returns an initiliazed instance of itemCommand17 component.
     * @return the initialized component instance
     */
    public Command getItemCommand17() {
        if (itemCommand17 == null) {//GEN-END:|395-getter|0|395-preInit
            // write pre-init user code here
            itemCommand17 = new Command("Escuchar", Command.ITEM, 0);//GEN-LINE:|395-getter|1|395-postInit
            // write post-init user code here
        }//GEN-BEGIN:|395-getter|2|
        return itemCommand17;
    }
    //</editor-fold>//GEN-END:|395-getter|2|

    //<editor-fold defaultstate="collapsed" desc=" Generated Getter: tableItem16 ">//GEN-BEGIN:|393-getter|0|393-preInit
    /**
     * Returns an initiliazed instance of tableItem16 component.
     * @return the initialized component instance
     */
    public TableItem getTableItem16() {
        if (tableItem16 == null) {//GEN-END:|393-getter|0|393-preInit
            // write pre-init user code here
            tableItem16 = new TableItem(getDisplay(), "");//GEN-BEGIN:|393-getter|1|393-postInit
            tableItem16.addCommand(getItemCommand17());
            tableItem16.setItemCommandListener(this);
            tableItem16.setModel(getTableModel16());//GEN-END:|393-getter|1|393-postInit
            // write post-init user code here
        }//GEN-BEGIN:|393-getter|2|
        return tableItem16;
    }
    //</editor-fold>//GEN-END:|393-getter|2|

    //<editor-fold defaultstate="collapsed" desc=" Generated Getter: tableModel16 ">//GEN-BEGIN:|394-getter|0|394-preInit
    /**
     * Returns an initiliazed instance of tableModel16 component.
     * @return the initialized component instance
     */
    public SimpleTableModel getTableModel16() {
        if (tableModel16 == null) {//GEN-END:|394-getter|0|394-preInit
            // write pre-init user code here
            tableModel16 = new SimpleTableModel(new java.lang.String[][] {//GEN-BEGIN:|394-getter|1|394-postInit
                new java.lang.String[] { "1. - Qu\u00E8 volia? - Voldria telefonar.  ", "\u00BFQu\u00E9 desea? - Quisiera llamar por tel\u00E9fono. ", "b16-01 " },
                new java.lang.String[] { "2. - Qu\u00E8 vol prendre? - Vull prendre una cervesa.  ", "\u00BFQu\u00E9 quiere tomar? - Quiero tomar una cerveza. ", "b16-02" },
                new java.lang.String[] { "3. - Qu\u00E8 val aix\u00F2? - Val tres mil pessetes.  ", "\u00BFQu\u00E9 vale esto? - vale Tres mil pesetas. ", "b16-03" },
                new java.lang.String[] { "4. - Qu\u00E8 li dec? - S\u00F3n sis-centes pessetes.  ", "\u00BFQu\u00E9 le debo? - Son seiscientas pesetas. ", "b16-04" },
                new java.lang.String[] { "5. El compte, per favor.  ", "La cuenta, por favor. ", "b16-05" },
                new java.lang.String[] { "6. \u00C9s car. \u00C9s molt car. \u00C9s massa car.  ", "Es caro. Es muy caro. Es demasiado caro. ", "b16-06" },
                new java.lang.String[] { "7. \u00C9s barat. \u00C9s molt barat. \u00C9s massa barat.  ", "Es barato. Es muy barato. Es demasiado barato. ", "b16-07" },
                new java.lang.String[] { "8. Que teniu pa? Que teniu el diari d\u2019avui?  ", "\u00BFTiene pan? \u00BFTiene el peri\u00F3dico de hoy? ", "b16-08" },
                new java.lang.String[] { "9. Hi ha molta gent. Hi ha poca gent.  ", "Hay mucha gente. Hay poca gente. ", "b16-09" },
                new java.lang.String[] { "10. No hi ha ning\u00FA. No hi ha res.  ", "No hay nadie. No hay nada. ", "b16-10" },
                new java.lang.String[] { "11. Hi ha moltes coses. Hi ha poques coses.  ", "Hay muchas cosas. Hay pocas cosas. ", "b16-11" }}, new java.lang.String[] { "Catal\u00E0", "Espa\u00F1ol", "FILE" });//GEN-END:|394-getter|1|394-postInit
            // write post-init user code here
        }//GEN-BEGIN:|394-getter|2|
        return tableModel16;
    }
    //</editor-fold>//GEN-END:|394-getter|2|

    //<editor-fold defaultstate="collapsed" desc=" Generated Getter: itemCommand18 ">//GEN-BEGIN:|401-getter|0|401-preInit
    /**
     * Returns an initiliazed instance of itemCommand18 component.
     * @return the initialized component instance
     */
    public Command getItemCommand18() {
        if (itemCommand18 == null) {//GEN-END:|401-getter|0|401-preInit
            // write pre-init user code here
            itemCommand18 = new Command("Item", Command.ITEM, 0);//GEN-LINE:|401-getter|1|401-postInit
            // write post-init user code here
        }//GEN-BEGIN:|401-getter|2|
        return itemCommand18;
    }
    //</editor-fold>//GEN-END:|401-getter|2|

    //<editor-fold defaultstate="collapsed" desc=" Generated Getter: itemCommand19 ">//GEN-BEGIN:|403-getter|0|403-preInit
    /**
     * Returns an initiliazed instance of itemCommand19 component.
     * @return the initialized component instance
     */
    public Command getItemCommand19() {
        if (itemCommand19 == null) {//GEN-END:|403-getter|0|403-preInit
            // write pre-init user code here
            itemCommand19 = new Command("Item", Command.ITEM, 0);//GEN-LINE:|403-getter|1|403-postInit
            // write post-init user code here
        }//GEN-BEGIN:|403-getter|2|
        return itemCommand19;
    }
    //</editor-fold>//GEN-END:|403-getter|2|

    //<editor-fold defaultstate="collapsed" desc=" Generated Getter: itemCommand20 ">//GEN-BEGIN:|405-getter|0|405-preInit
    /**
     * Returns an initiliazed instance of itemCommand20 component.
     * @return the initialized component instance
     */
    public Command getItemCommand20() {
        if (itemCommand20 == null) {//GEN-END:|405-getter|0|405-preInit
            // write pre-init user code here
            itemCommand20 = new Command("Item", Command.ITEM, 0);//GEN-LINE:|405-getter|1|405-postInit
            // write post-init user code here
        }//GEN-BEGIN:|405-getter|2|
        return itemCommand20;
    }
    //</editor-fold>//GEN-END:|405-getter|2|

    //<editor-fold defaultstate="collapsed" desc=" Generated Getter: tableItem17 ">//GEN-BEGIN:|399-getter|0|399-preInit
    /**
     * Returns an initiliazed instance of tableItem17 component.
     * @return the initialized component instance
     */
    public TableItem getTableItem17() {
        if (tableItem17 == null) {//GEN-END:|399-getter|0|399-preInit
            // write pre-init user code here
            tableItem17 = new TableItem(getDisplay(), "");//GEN-BEGIN:|399-getter|1|399-postInit
            tableItem17.setItemCommandListener(this);
            tableItem17.setModel(getTableModel17());//GEN-END:|399-getter|1|399-postInit
            // write post-init user code here
        }//GEN-BEGIN:|399-getter|2|
        return tableItem17;
    }
    //</editor-fold>//GEN-END:|399-getter|2|

    //<editor-fold defaultstate="collapsed" desc=" Generated Getter: tableModel17 ">//GEN-BEGIN:|400-getter|0|400-preInit
    /**
     * Returns an initiliazed instance of tableModel17 component.
     * @return the initialized component instance
     */
    public SimpleTableModel getTableModel17() {
        if (tableModel17 == null) {//GEN-END:|400-getter|0|400-preInit
            // write pre-init user code here
            tableModel17 = new SimpleTableModel(new java.lang.String[][] {//GEN-BEGIN:|400-getter|1|400-postInit
                new java.lang.String[] { "1. Avui \u00E9s dia feiner. Avui \u00E9s dia festiu.  ", "Hoy es d\u00EDa laborable. Hoy es d\u00EDa festivo. ", "b17-01 " },
                new java.lang.String[] { "2. Faig vacances. Vaig a fer feina.  ", "Tengo vacaciones. Voy a trabajar. ", "b17-02" },
                new java.lang.String[] { "3. Faig feina de perruquer. Faig feina de perruquera. Faig feina de cambrer. Faig feina de cambrera.  ", "Trabajo como peluquero. Trabajo como peluquera. Trabajo como camarero. Trabajo como camarera. ", "b17-03" },
                new java.lang.String[] { "4. No tenc feina. Estic a l\u2019atur.  ", "No tengo trabajo. Estoy en el paro. ", "b17-04" },
                new java.lang.String[] { "5. Cerc feina. Necessit una feina.  ", "Busco trabajo. Necesito un trabajo. ", "b17-05" },
                new java.lang.String[] { "6. Som comerciant. Som professor. Som professora. Som pag\u00E8s. Som pagesa.  ", "Soy comerciante. Soy profesor. Soy profesora. Soy campesino. Soy campesina. ", "b17-06" },
                new java.lang.String[] { "7. Estudii catal\u00E0. Estudii franc\u00E8s. Estudii espanyol. Estudii alemany. Estudii angl\u00E8s.  ", "Estudio catal\u00E1n. Estudio franc\u00E9s. Estudio espa\u00F1ol. Estudio alem\u00E1n. Estudio ingl\u00E9s. ", "b17-07" },
                new java.lang.String[] { "8. Estudii matem\u00E0tiques. Estudii psicologia. Estudii qu\u00EDmica. Estudii filologia. Estudii dret.  ", "Estudio matem\u00E1ticas. Estudio psicolog\u00EDa. Estudio qu\u00EDmica. Estudio filolog\u00EDa. Estudio derecho. ", "b17-08" },
                new java.lang.String[] { "9. Saps nedar? Saps cuinar? Saps parlar catal\u00E0?  ", "\u00BFSabes nadar? \u00BFSabes cocinar? \u00BFSabes hablar catal\u00E1n? ", "b17-09" }}, new java.lang.String[] { "Catal\u00E0", "Espa\u00F1ol", "FILE" });//GEN-END:|400-getter|1|400-postInit
            // write post-init user code here
        }//GEN-BEGIN:|400-getter|2|
        return tableModel17;
    }
    //</editor-fold>//GEN-END:|400-getter|2|

    //<editor-fold defaultstate="collapsed" desc=" Generated Getter: itemCommand21 ">//GEN-BEGIN:|409-getter|0|409-preInit
    /**
     * Returns an initiliazed instance of itemCommand21 component.
     * @return the initialized component instance
     */
    public Command getItemCommand21() {
        if (itemCommand21 == null) {//GEN-END:|409-getter|0|409-preInit
            // write pre-init user code here
            itemCommand21 = new Command("Item", Command.ITEM, 0);//GEN-LINE:|409-getter|1|409-postInit
            // write post-init user code here
        }//GEN-BEGIN:|409-getter|2|
        return itemCommand21;
    }
    //</editor-fold>//GEN-END:|409-getter|2|

    //<editor-fold defaultstate="collapsed" desc=" Generated Getter: itemCommand22 ">//GEN-BEGIN:|411-getter|0|411-preInit
    /**
     * Returns an initiliazed instance of itemCommand22 component.
     * @return the initialized component instance
     */
    public Command getItemCommand22() {
        if (itemCommand22 == null) {//GEN-END:|411-getter|0|411-preInit
            // write pre-init user code here
            itemCommand22 = new Command("Escuchar", Command.ITEM, 0);//GEN-LINE:|411-getter|1|411-postInit
            // write post-init user code here
        }//GEN-BEGIN:|411-getter|2|
        return itemCommand22;
    }
    //</editor-fold>//GEN-END:|411-getter|2|

    //<editor-fold defaultstate="collapsed" desc=" Generated Getter: tableItem18 ">//GEN-BEGIN:|413-getter|0|413-preInit
    /**
     * Returns an initiliazed instance of tableItem18 component.
     * @return the initialized component instance
     */
    public TableItem getTableItem18() {
        if (tableItem18 == null) {//GEN-END:|413-getter|0|413-preInit
            // write pre-init user code here
            tableItem18 = new TableItem(getDisplay(), "");//GEN-BEGIN:|413-getter|1|413-postInit
            tableItem18.setModel(getTableModel18());//GEN-END:|413-getter|1|413-postInit
            // write post-init user code here
        }//GEN-BEGIN:|413-getter|2|
        return tableItem18;
    }
    //</editor-fold>//GEN-END:|413-getter|2|

    //<editor-fold defaultstate="collapsed" desc=" Generated Getter: tableModel18 ">//GEN-BEGIN:|414-getter|0|414-preInit
    /**
     * Returns an initiliazed instance of tableModel18 component.
     * @return the initialized component instance
     */
    public SimpleTableModel getTableModel18() {
        if (tableModel18 == null) {//GEN-END:|414-getter|0|414-preInit
            // write pre-init user code here
            tableModel18 = new SimpleTableModel(new java.lang.String[][] {//GEN-BEGIN:|414-getter|1|414-postInit
                new java.lang.String[] { "1. - On \u00E9s l\u2019estaci\u00F3 d\u2019autobusos? - A prop, molt a prop. | Lluny, molt lluny.  ", "\u00BFD\u00F3nde est\u00E1 la estaci\u00F3n de autobuses? - Cerca, muy cerca. | Lejos, muy lejos. ", "b18-01 " },
                new java.lang.String[] { "2. - On \u00E9s la biblioteca? - A la dreta. | A l\u2019esquerra. | Al fons. | Tot dret.  ", "\u00BFD\u00F3nde est\u00E1 la biblioteca? - A la derecha. | A la izquierda. | Al fondo. | Todo derecho. ", "b18-02" },
                new java.lang.String[] { "3. Vaig al banc. Vaig a l\u2019escola. Vaig a ca nostra.  ", "Voy al banco. Voy a la escuela. Voy a casa. ", "b18-03" },
                new java.lang.String[] { "4. V\u00E9nc de l\u2019hospital. V\u00E9nc de la farm\u00E0cia. V\u00E9nc de ca nostra.  ", "Vengo del hospital. Vengo de la farmacia. Vengo de casa. ", "b18-04" },
                new java.lang.String[] { "5. Som al carrer. Som a cal metge. Som a ca nostra.  ", "Estoy en la calle. Estoy en la consulta del m\u00E9dico. Estoy en casa. ", "b18-05" }}, new java.lang.String[] { "Catal\u00E0", "Espa\u00F1ol", "FILE" });//GEN-END:|414-getter|1|414-postInit
            // write post-init user code here
        }//GEN-BEGIN:|414-getter|2|
        return tableModel18;
    }
    //</editor-fold>//GEN-END:|414-getter|2|

    //<editor-fold defaultstate="collapsed" desc=" Generated Getter: itemCommand23 ">//GEN-BEGIN:|419-getter|0|419-preInit
    /**
     * Returns an initiliazed instance of itemCommand23 component.
     * @return the initialized component instance
     */
    public Command getItemCommand23() {
        if (itemCommand23 == null) {//GEN-END:|419-getter|0|419-preInit
            // write pre-init user code here
            itemCommand23 = new Command("Escuchar", Command.ITEM, 0);//GEN-LINE:|419-getter|1|419-postInit
            // write post-init user code here
        }//GEN-BEGIN:|419-getter|2|
        return itemCommand23;
    }
    //</editor-fold>//GEN-END:|419-getter|2|

    //<editor-fold defaultstate="collapsed" desc=" Generated Getter: tableItem19 ">//GEN-BEGIN:|417-getter|0|417-preInit
    /**
     * Returns an initiliazed instance of tableItem19 component.
     * @return the initialized component instance
     */
    public TableItem getTableItem19() {
        if (tableItem19 == null) {//GEN-END:|417-getter|0|417-preInit
            // write pre-init user code here
            tableItem19 = new TableItem(getDisplay(), "");//GEN-BEGIN:|417-getter|1|417-postInit
            tableItem19.setModel(getTableModel19());//GEN-END:|417-getter|1|417-postInit
            // write post-init user code here
        }//GEN-BEGIN:|417-getter|2|
        return tableItem19;
    }
    //</editor-fold>//GEN-END:|417-getter|2|

    //<editor-fold defaultstate="collapsed" desc=" Generated Getter: tableModel19 ">//GEN-BEGIN:|418-getter|0|418-preInit
    /**
     * Returns an initiliazed instance of tableModel19 component.
     * @return the initialized component instance
     */
    public SimpleTableModel getTableModel19() {
        if (tableModel19 == null) {//GEN-END:|418-getter|0|418-preInit
            // write pre-init user code here
            tableModel19 = new SimpleTableModel(new java.lang.String[][] {//GEN-BEGIN:|418-getter|1|418-postInit
                new java.lang.String[] { "1. Anar a peu. Anar amb bicicleta. Anar amb moto. Anar amb cotxe. Anar amb tren. Anar amb autob\u00FAs. Anar amb avi\u00F3. Anar amb barca. Anar amb vaixell.   ", "Ir a pie. Ir en bicicleta. Ir en moto. Ir en coche. Ir en tren. Ir en autob\u00FAs. Ir en avi\u00F3n. Ir en barca. Ir en barco. ", "b19-01", "" },
                new java.lang.String[] { "2. Agafar la bicicleta. Agafar la moto. Agafar el cotxe. Agafar el tren. Agafar l\u2019autob\u00FAs. Agafar l\u2019avi\u00F3. Agafar la barca. Agafar el vaixell.  ", "Coger la bicicleta. Coger la moto. Coger el coche. Coger el tren. Coger el autob\u00FAs. Coger el avi\u00F3n. Coger la barca. Coger el barco. ", "b19-02", "" }}, new java.lang.String[] { "Catal\u00E0", "Espa\u00F1ol", "FILE" });//GEN-END:|418-getter|1|418-postInit
            // write post-init user code here
        }//GEN-BEGIN:|418-getter|2|
        return tableModel19;
    }
    //</editor-fold>//GEN-END:|418-getter|2|

    //<editor-fold defaultstate="collapsed" desc=" Generated Getter: itemCommand24 ">//GEN-BEGIN:|423-getter|0|423-preInit
    /**
     * Returns an initiliazed instance of itemCommand24 component.
     * @return the initialized component instance
     */
    public Command getItemCommand24() {
        if (itemCommand24 == null) {//GEN-END:|423-getter|0|423-preInit
            // write pre-init user code here
            itemCommand24 = new Command("Escuchar", Command.ITEM, 0);//GEN-LINE:|423-getter|1|423-postInit
            // write post-init user code here
        }//GEN-BEGIN:|423-getter|2|
        return itemCommand24;
    }
    //</editor-fold>//GEN-END:|423-getter|2|

    //<editor-fold defaultstate="collapsed" desc=" Generated Getter: tableItem20 ">//GEN-BEGIN:|425-getter|0|425-preInit
    /**
     * Returns an initiliazed instance of tableItem20 component.
     * @return the initialized component instance
     */
    public TableItem getTableItem20() {
        if (tableItem20 == null) {//GEN-END:|425-getter|0|425-preInit
            // write pre-init user code here
            tableItem20 = new TableItem(getDisplay(), "");//GEN-BEGIN:|425-getter|1|425-postInit
            tableItem20.setModel(getTableModel20());//GEN-END:|425-getter|1|425-postInit
            // write post-init user code here
        }//GEN-BEGIN:|425-getter|2|
        return tableItem20;
    }
    //</editor-fold>//GEN-END:|425-getter|2|

    //<editor-fold defaultstate="collapsed" desc=" Generated Getter: tableModel20 ">//GEN-BEGIN:|426-getter|0|426-preInit
    /**
     * Returns an initiliazed instance of tableModel20 component.
     * @return the initialized component instance
     */
    public SimpleTableModel getTableModel20() {
        if (tableModel20 == null) {//GEN-END:|426-getter|0|426-preInit
            // write pre-init user code here
            tableModel20 = new SimpleTableModel(new java.lang.String[][] {//GEN-BEGIN:|426-getter|1|426-postInit
                new java.lang.String[] { "1. Pare, mare, fill, filla, germ\u00E0, germana.  ", "Padre, madre, hijo, hija, hermano, hermana. ", "b20-01" },
                new java.lang.String[] { "2. Padr\u00ED /avi, padrina /\u00E0via, n\u00E9t, n\u00E9ta.  ", "Abuelo, abuela, nieto, nieta. ", "b20-02" },
                new java.lang.String[] { "3. Esp\u00F2s / home, esposa / dona, company, companya.  ", "Esposo / marido, esposa / mujer, compa\u00F1ero, compa\u00F1era. ", "b20-03" },
                new java.lang.String[] { "4. Cos\u00ED, cosina, oncle, tia, nebot, neboda.  ", "Primo, prima, t\u00EDo, t\u00EDa, sobrino, sobrina. ", "b20-04" },
                new java.lang.String[] { "5. Cunyat, cunyada, gendre, nora.  ", "Cu\u00F1ado, cu\u00F1ada, yerno, nuera. ", "b20-05" },
                new java.lang.String[] { "6. Som casat. Som fadr\u00ED. Som divorciat. Som vidu. Som casada. Som fadrina. Som divorciada. Som v\u00EDdua.  ", "Estoy casado. Soy soltero. Estoy divorciado. Soy viudo. Estoy casada. Soy soltera. Estoy divorciada. Soy viuda. ", "b20-06" },
                new java.lang.String[] { "7. Tenc tres fills. Tenc cinc n\u00E9ts.  ", "Tengo tres hijos. Tengo cinco nietos. ", "b20-07" },
                new java.lang.String[] { "8. A ca nostra som quatre germans.  ", "En casa somos cuatro hermanos. ", "b20-08" },
                new java.lang.String[] { "9. Visc a cals padrins. Visc tot sol. Visc tota sola.  ", "Vivo en casa de los abuelos. Vivo solo. Vivo sola. ", "b20-09" },
                new java.lang.String[] { "10. Visc en un pis. Visc en una casa amb jard\u00ED.  ", "Vivo en un piso. Vivo en una casa con un jard\u00EDn. ", "b20-10" }}, new java.lang.String[] { "Catal\u00E0", "Espa\u00F1ol", "FILE" });//GEN-END:|426-getter|1|426-postInit
            // write post-init user code here
        }//GEN-BEGIN:|426-getter|2|
        return tableModel20;
    }
    //</editor-fold>//GEN-END:|426-getter|2|

    //<editor-fold defaultstate="collapsed" desc=" Generated Getter: itemCommand25 ">//GEN-BEGIN:|429-getter|0|429-preInit
    /**
     * Returns an initiliazed instance of itemCommand25 component.
     * @return the initialized component instance
     */
    public Command getItemCommand25() {
        if (itemCommand25 == null) {//GEN-END:|429-getter|0|429-preInit
            // write pre-init user code here
            itemCommand25 = new Command("Escuchar", Command.ITEM, 0);//GEN-LINE:|429-getter|1|429-postInit
            // write post-init user code here
        }//GEN-BEGIN:|429-getter|2|
        return itemCommand25;
    }
    //</editor-fold>//GEN-END:|429-getter|2|

    //<editor-fold defaultstate="collapsed" desc=" Generated Getter: tableItem21 ">//GEN-BEGIN:|431-getter|0|431-preInit
    /**
     * Returns an initiliazed instance of tableItem21 component.
     * @return the initialized component instance
     */
    public TableItem getTableItem21() {
        if (tableItem21 == null) {//GEN-END:|431-getter|0|431-preInit
            // write pre-init user code here
            tableItem21 = new TableItem(getDisplay(), "");//GEN-BEGIN:|431-getter|1|431-postInit
            tableItem21.setModel(getTableModel21());//GEN-END:|431-getter|1|431-postInit
            // write post-init user code here
        }//GEN-BEGIN:|431-getter|2|
        return tableItem21;
    }
    //</editor-fold>//GEN-END:|431-getter|2|

    //<editor-fold defaultstate="collapsed" desc=" Generated Getter: tableModel21 ">//GEN-BEGIN:|432-getter|0|432-preInit
    /**
     * Returns an initiliazed instance of tableModel21 component.
     * @return the initialized component instance
     */
    public SimpleTableModel getTableModel21() {
        if (tableModel21 == null) {//GEN-END:|432-getter|0|432-preInit
            // write pre-init user code here
            tableModel21 = new SimpleTableModel(new java.lang.String[][] {//GEN-BEGIN:|432-getter|1|432-postInit
                new java.lang.String[] { "1. Nadal. Cap d\u2019Any. Els Reis d\u2019Orient.  ", "Navidad. Fin de A\u00F1o. Los Reyes de Oriente. ", "b21-01 " },
                new java.lang.String[] { "2. Carnaval. Quaresma. Pasqua.  ", "Carnaval. Cuaresma. Pascua. ", "b21-02" },
                new java.lang.String[] { "3. Vacances d\u2019estiu. Vacances de Nadal. Vacances de Pasqua.  ", "Vacaciones de verano. Vacaciones de Navidad. Vacaciones de Pascua. ", "b21-03" },
                new java.lang.String[] { "4. Bon Nadal i feli\u00E7 Any Nou.  ", "Feliz Navidad y feliz A\u00F1o Nuevo. ", "b21-04" },
                new java.lang.String[] { "5. Bones festes. Bon viatge. Bones vacances.  ", "Felices fiestas. Buen viaje. Felices vacaciones. ", "b21-05" },
                new java.lang.String[] { "6. Enhorabona. Salut!  ", "Enhorabuena. \u00A1Salud! ", "b21-06" },
                new java.lang.String[] { "7. Molts d\u2019anys. Moltes felicitats.  ", "Felicidades. Muchas felicidades. ", "b21-07" }}, new java.lang.String[] { "Catal\u00E0", "Espa\u00F1ol", "FILE" });//GEN-END:|432-getter|1|432-postInit
            // write post-init user code here
        }//GEN-BEGIN:|432-getter|2|
        return tableModel21;
    }
    //</editor-fold>//GEN-END:|432-getter|2|

    //<editor-fold defaultstate="collapsed" desc=" Generated Getter: itemCommand26 ">//GEN-BEGIN:|435-getter|0|435-preInit
    /**
     * Returns an initiliazed instance of itemCommand26 component.
     * @return the initialized component instance
     */
    public Command getItemCommand26() {
        if (itemCommand26 == null) {//GEN-END:|435-getter|0|435-preInit
            // write pre-init user code here
            itemCommand26 = new Command("Acerca de...", Command.ITEM, 0);//GEN-LINE:|435-getter|1|435-postInit
            // write post-init user code here
        }//GEN-BEGIN:|435-getter|2|
        return itemCommand26;
    }
    //</editor-fold>//GEN-END:|435-getter|2|

    //<editor-fold defaultstate="collapsed" desc=" Generated Getter: itemCommand27 ">//GEN-BEGIN:|438-getter|0|438-preInit
    /**
     * Returns an initiliazed instance of itemCommand27 component.
     * @return the initialized component instance
     */
    public Command getItemCommand27() {
        if (itemCommand27 == null) {//GEN-END:|438-getter|0|438-preInit
            // write pre-init user code here
            itemCommand27 = new Command("Atras", Command.ITEM, 0);//GEN-LINE:|438-getter|1|438-postInit
            // write post-init user code here
        }//GEN-BEGIN:|438-getter|2|
        return itemCommand27;
    }
    //</editor-fold>//GEN-END:|438-getter|2|

    //<editor-fold defaultstate="collapsed" desc=" Generated Getter: itemCommand28 ">//GEN-BEGIN:|441-getter|0|441-preInit
    /**
     * Returns an initiliazed instance of itemCommand28 component.
     * @return the initialized component instance
     */
    public Command getItemCommand28() {
        if (itemCommand28 == null) {//GEN-END:|441-getter|0|441-preInit
            // write pre-init user code here
            itemCommand28 = new Command("Contactar", Command.ITEM, 0);//GEN-LINE:|441-getter|1|441-postInit
            // write post-init user code here
        }//GEN-BEGIN:|441-getter|2|
        return itemCommand28;
    }
    //</editor-fold>//GEN-END:|441-getter|2|

    //<editor-fold defaultstate="collapsed" desc=" Generated Getter: about ">//GEN-BEGIN:|437-getter|0|437-preInit
    /**
     * Returns an initiliazed instance of about component.
     * @return the initialized component instance
     */
    public Form getAbout() {
        if (about == null) {//GEN-END:|437-getter|0|437-preInit
            // write pre-init user code here
            about = new Form("Acerca de...", new Item[] { getImageItem(), getStringItem() });//GEN-BEGIN:|437-getter|1|437-postInit
            about.addCommand(getItemCommand27());
            about.addCommand(getItemCommand28());
            about.setCommandListener(this);//GEN-END:|437-getter|1|437-postInit
            // write post-init user code here
        }//GEN-BEGIN:|437-getter|2|
        return about;
    }
    //</editor-fold>//GEN-END:|437-getter|2|

    //<editor-fold defaultstate="collapsed" desc=" Generated Getter: imageItem ">//GEN-BEGIN:|443-getter|0|443-preInit
    /**
     * Returns an initiliazed instance of imageItem component.
     * @return the initialized component instance
     */
    public ImageItem getImageItem() {
        if (imageItem == null) {//GEN-END:|443-getter|0|443-preInit
            // write pre-init user code here
            imageItem = new ImageItem("Yeradis P. Barbosa Marrero", getImage2(), ImageItem.LAYOUT_CENTER | Item.LAYOUT_TOP | Item.LAYOUT_BOTTOM | Item.LAYOUT_VCENTER | Item.LAYOUT_2, "<Missing Image>", Item.PLAIN);//GEN-LINE:|443-getter|1|443-postInit
            // write post-init user code here
        }//GEN-BEGIN:|443-getter|2|
        return imageItem;
    }
    //</editor-fold>//GEN-END:|443-getter|2|

    //<editor-fold defaultstate="collapsed" desc=" Generated Getter: image2 ">//GEN-BEGIN:|444-getter|0|444-preInit
    /**
     * Returns an initiliazed instance of image2 component.
     * @return the initialized component instance
     */
    public Image getImage2() {
        if (image2 == null) {//GEN-END:|444-getter|0|444-preInit
            // write pre-init user code here
            try {//GEN-BEGIN:|444-getter|1|444-@java.io.IOException
                image2 = Image.createImage("/yo.jpg");
            } catch (java.io.IOException e) {//GEN-END:|444-getter|1|444-@java.io.IOException
                e.printStackTrace();
            }//GEN-LINE:|444-getter|2|444-postInit
            // write post-init user code here
        }//GEN-BEGIN:|444-getter|3|
        return image2;
    }
    //</editor-fold>//GEN-END:|444-getter|3|

    //<editor-fold defaultstate="collapsed" desc=" Generated Getter: stringItem ">//GEN-BEGIN:|445-getter|0|445-preInit
    /**
     * Returns an initiliazed instance of stringItem component.
     * @return the initialized component instance
     */
    public StringItem getStringItem() {
        if (stringItem == null) {//GEN-END:|445-getter|0|445-preInit
            // write pre-init user code here
            stringItem = new StringItem("", "Objetivos: Dado que mi lengua materna no es el Catal\u00E1n y soy programador de sistemas de software, me propuse aprender el lenguaje catal\u00E1n de una manera facil y con la informacion siempre disponible, y que mejor manera de tener la informacion a mano que llevarla en el bolsillo. \nEste programilla no es mas que la recopilacion de frases simples y sencillas del catalan,  agrupadas en categorias.\n\nE-mail de contacto: yeradis@gmail.com\n\nNacido en Cuba viviendo actualmente en Barcelona, Espa\u00F1a. ");//GEN-LINE:|445-getter|1|445-postInit
            // write post-init user code here
        }//GEN-BEGIN:|445-getter|2|
        return stringItem;
    }
    //</editor-fold>//GEN-END:|445-getter|2|

    //<editor-fold defaultstate="collapsed" desc=" Generated Getter: helpCommand ">//GEN-BEGIN:|447-getter|0|447-preInit
    /**
     * Returns an initiliazed instance of helpCommand component.
     * @return the initialized component instance
     */
    public Command getHelpCommand() {
        if (helpCommand == null) {//GEN-END:|447-getter|0|447-preInit
            // write pre-init user code here
            helpCommand = new Command("Info", Command.HELP, 0);//GEN-LINE:|447-getter|1|447-postInit
            // write post-init user code here
        }//GEN-BEGIN:|447-getter|2|
        return helpCommand;
    }
    //</editor-fold>//GEN-END:|447-getter|2|

    //<editor-fold defaultstate="collapsed" desc=" Generated Getter: okCommand1 ">//GEN-BEGIN:|450-getter|0|450-preInit
    /**
     * Returns an initiliazed instance of okCommand1 component.
     * @return the initialized component instance
     */
    public Command getOkCommand1() {
        if (okCommand1 == null) {//GEN-END:|450-getter|0|450-preInit
            // write pre-init user code here
            okCommand1 = new Command("Info", Command.OK, 0);//GEN-LINE:|450-getter|1|450-postInit
            // write post-init user code here
        }//GEN-BEGIN:|450-getter|2|
        return okCommand1;
    }
    //</editor-fold>//GEN-END:|450-getter|2|

    //<editor-fold defaultstate="collapsed" desc=" Generated Getter: spacer ">//GEN-BEGIN:|453-getter|0|453-preInit
    /**
     * Returns an initiliazed instance of spacer component.
     * @return the initialized component instance
     */
    public Spacer getSpacer() {
        if (spacer == null) {//GEN-END:|453-getter|0|453-preInit
            // write pre-init user code here
            spacer = new Spacer(16, 1);//GEN-LINE:|453-getter|1|453-postInit
            // write post-init user code here
        }//GEN-BEGIN:|453-getter|2|
        return spacer;
    }
    //</editor-fold>//GEN-END:|453-getter|2|

    public int getChapter1Item() {
        
        return tableItem1.getSelectedCellRow();
    }

    public void playMusic() {
        try {
            InputStream is = getClass().getResourceAsStream("/sound/sound.mp3");
            Player player = Manager.createPlayer(is, "audio/mpeg");

            player.realize();
            // get volume control for player and set volume to max
            VolumeControl vc = (VolumeControl) player.getControl("VolumeControl");
            if (vc != null) {
                vc.setLevel(100);
            }
            player.prefetch();
            player.start();
        } catch (Exception e) {
        }

//        try {
//            InputStream input = getClass().getResourceAsStream("sound/sound.mp3");
//
//            Player player = Manager.createPlayer(input, "audio/mpeg");
//
//            player.realize();
//            player.prefetch();
//        } catch (IOException ex) {
//            ex.printStackTrace();
//        } catch (MediaException ex) {
//            ex.printStackTrace();
//        }
    }

    public int getMainTableRow() {
        return tableItem.getSelectedCellRow();
    }

    public void playChapter1() {
        playFile("file:///e:/Program Files/Lengua catalana/1 A su alcance/" + (String) tableModel1.getValue(2, tableItem1.getSelectedCellRow()) + ".mp3");
    }

    public void playChapter2() {
        String file2play = (String) tableModel2.getValue(2, tableItem2.getSelectedCellRow());
        playFile("file:///e:/Program Files/Lengua catalana/2 Saludos y formulas de cortesia/" + file2play.trim() + ".mp3");
    }

    public void playChapter3() {
        String file2play = (String) tableModel3.getValue(2, tableItem3.getSelectedCellRow());
        playFile("file:///e:/Program Files/Lengua catalana/3 Preguntas usuales/" + file2play.trim() + ".mp3");
    }

    public void playChapter4() {
        String file2play = (String) tableModel4.getValue(2, tableItem4.getSelectedCellRow());
        playFile("file:///e:/Program Files/Lengua catalana/4 Afirmaciones/" + file2play.trim() + ".mp3");
    }

    public void playChapter5() {
        String file2play = (String) tableModel5.getValue(2, tableItem5.getSelectedCellRow());
        playFile("file:///e:/Program Files/Lengua catalana/5 Negaciones/" + file2play.trim() + ".mp3");
    }

    public void playChapter6() {
        String file2play = (String) tableModel6.getValue(2, tableItem6.getSelectedCellRow());
        playFile("file:///e:/Program Files/Lengua catalana/6 Dudas/" + file2play.trim() + ".mp3");
    }

    public void playChapter7() {
        String file2play = (String) tableModel7.getValue(2, tableItem7.getSelectedCellRow());
        playFile("file:///e:/Program Files/Lengua catalana/7 Exclamaciones y expresiones diversas/" + file2play.trim() + ".mp3");
    }

    public void playChapter8() {
        String file2play = (String) tableModel8.getValue(2, tableItem8.getSelectedCellRow());
        playFile("file:///e:/Program Files/Lengua catalana/8 Cualidades estados preferencias/" + file2play.trim() + ".mp3");
    }

    public void playChapter9() {
        String file2play = (String) tableModel9.getValue(2, tableItem9.getSelectedCellRow());
        playFile("file:///e:/Program Files/Lengua catalana/9 Colores/" + file2play.trim() + ".mp3");
    }

    public void playChapter10() {
        String file2play = (String) tableModel10.getValue(2, tableItem10.getSelectedCellRow());
        playFile("file:///e:/Program Files/Lengua catalana/10 Numeros/" + file2play.trim() + ".mp3");
    }

    public void playChapter11() {
        String file2play = (String) tableModel11.getValue(2, tableItem11.getSelectedCellRow());
        playFile("file:///e:/Program Files/Lengua catalana/11 Expresiones temporales/" + file2play.trim() + ".mp3");
    }

    public void playChapter12() {
        String file2play = (String) tableModel12.getValue(2, tableItem12.getSelectedCellRow());
        playFile("file:///e:/Program Files/Lengua catalana/12 Dias meses estaciones puntos cardinales/" + file2play.trim() + ".mp3");
    }
    public void playChapter13() {
        String file2play = (String) tableModel13.getValue(2, tableItem13.getSelectedCellRow());
        playFile("file:///e:/Program Files/Lengua catalana/13 Edad aniversarios/" + file2play.trim() + ".mp3");
    }
    public void playChapter14() {
        String file2play = (String) tableModel14.getValue(2, tableItem14.getSelectedCellRow());
        playFile("file:///e:/Program Files/Lengua catalana/14 Tiempo/" + file2play.trim() + ".mp3");
    }

    public void playChapter15() {
        String file2play = (String) tableModel15.getValue(2, tableItem15.getSelectedCellRow());
        playFile("file:///e:/Program Files/Lengua catalana/15 Avisos y carteles publicitarios/" + file2play.trim() + ".mp3");
    }
    public void playChapter16() {
        String file2play = (String) tableModel16.getValue(2, tableItem16.getSelectedCellRow());
        playFile("file:///e:/Program Files/Lengua catalana/16 Oferta y demanda/" + file2play.trim() + ".mp3");
    }
    public void playChapter17() {
        String file2play = (String) tableModel17.getValue(2, tableItem17.getSelectedCellRow());
        playFile("file:///e:/Program Files/Lengua catalana/17 Trabajo estudios profesiones/" + file2play.trim() + ".mp3");
    }
        public void playChapter18() {
        String file2play = (String) tableModel18.getValue(2, tableItem18.getSelectedCellRow());
        playFile("file:///e:/Program Files/Lengua catalana/18 Localizaciones/" + file2play.trim() + ".mp3");
    }

        public void playChapter19() {
        String file2play = (String) tableModel19.getValue(2, tableItem19.getSelectedCellRow());
        playFile("file:///e:/Program Files/Lengua catalana/19 Transportes/" + file2play.trim() + ".mp3");
    }
        public void playChapter20() {
        String file2play = (String) tableModel20.getValue(2, tableItem20.getSelectedCellRow());
        playFile("file:///e:/Program Files/Lengua catalana/20 Familia estado civil y vivienda/" + file2play.trim() + ".mp3");
    }
        
        public void playChapter21() {
        String file2play = (String) tableModel21.getValue(2, tableItem21.getSelectedCellRow());
        playFile("file:///e:/Program Files/Lengua catalana/21 Fiesta felicitaciones/" + file2play.trim() + ".mp3");
    }
        
    public String getItemLabel() {
        return (String) tableModel.getValue(tableItem.getSelectedCellColumn(), tableItem.getSelectedCellRow());
    }

    public void playFile(String file) {
        try {
            FileConnection fc = (FileConnection) Connector.open(file, Connector.READ);
            InputStream is = fc.openInputStream();
            Player player = Manager.createPlayer(is, "audio/mpeg");

            player.realize();
            // get volume control for player and set volume to max
            VolumeControl vc = (VolumeControl) player.getControl("VolumeControl");
            if (vc != null) {
                vc.setLevel(100);
            }
            player.prefetch();
            player.start();
        } catch (Exception e) {
        }

    }

    public void playEmbebdedFile(String file) {
        try {
            InputStream is = getClass().getResourceAsStream("/sound/" + file);
            Player player = Manager.createPlayer(is, "audio/mpeg");

            player.realize();
            // get volume control for player and set volume to max
            VolumeControl vc = (VolumeControl) player.getControl("VolumeControl");
            if (vc != null) {
                vc.setLevel(100);
            }
            player.prefetch();
            player.start();
        } catch (Exception e) {
        }

    }

    /**
     * Returns a display instance.
     * @return the display instance.
     */
    public Display getDisplay() {
        return Display.getDisplay(this);
    }

    /**
     * Exits MIDlet.
     */
    public void exitMIDlet() {
        switchDisplayable(null, null);
        destroyApp(true);
        notifyDestroyed();

    }

    /**
     * Called when MIDlet is started.
     * Checks whether the MIDlet have been already started and initialize/starts or resumes the MIDlet.
     */
    public void startApp() {
        if (midletPaused) {
            resumeMIDlet();
        } else {
            initialize();
            startMIDlet();

        }




        midletPaused = false;
    }

    /**
     * Called when MIDlet is paused.
     */
    public void pauseApp() {
        midletPaused = true;
    }

    /**
     * Called to signal the MIDlet to terminate.
     * @param unconditional if true, then the MIDlet has to be unconditionally terminated and all resources has to be released.
     */
    public void destroyApp(boolean unconditional) {
    }
}
