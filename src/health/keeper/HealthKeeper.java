/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package health.keeper;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.Window;
import java.util.ArrayList;
import java.util.List;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.UIManager;

/**
 *
 * @author arifu
 */
public class HealthKeeper extends javax.swing.JFrame {

    /**
     * Creates new form HealthKeeper
     */
    private User user;
    
    DataSync dataSync = new DataSync();
    
    
    //sensitive fields ... make it private
    private static Doctor currentDoc;
    private static boolean signedInAsUser;
    private static boolean authenticated=false; //this must be private
    
    
    
    public HealthKeeper(){  
        
        
        initComponents();
        
        //adjust positions of windows
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        Dimension d = new Dimension(screenSize.height/2,screenSize.height/3);
        this.setSize(d);
        this.jDialogNewDoctor.setSize(d);
        this.jDialogNewUser.setSize(d);
        this.jDialogSignIn.setSize(d);
            centreWindow(this);
        centreWindow(this.jDialogNewDoctor);
        centreWindow(this.jDialogNewUser);
        centreWindow(this.jDialogSignIn);
        
        user = dataSync.getUser();
        //checks if user has already sign up or not
        if (user == null) {
            newUser();
        }
        else{
            welcome();
        }
        this.setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("icon-healthkeeper.png")));
        
        
        

        

    }
    
    
    public void signInDone(){
        this.jDialogNewUser.setVisible(false);
        this.jDialogNewDoctor.setVisible(false);
        this.jDialogSignIn.setVisible(false);
        start();
    }

    
    public void newUser(){
        
        this.jDialogNewUser.setVisible(true);
        this.jDialogNewUser.setAlwaysOnTop(true);
        this.jDialogNewDoctor.setVisible(false);
        this.jDialogNewDoctor.setAlwaysOnTop(false);
        this.jDialogSignIn.setVisible(false);
        this.jDialogSignIn.setAlwaysOnTop(false);
    }
    public void newDoctor(){
        
        this.jDialogNewUser.setVisible(false);
        this.jDialogNewUser.setAlwaysOnTop(false);
        this.jDialogSignIn.setVisible(false);
        this.jDialogSignIn.setAlwaysOnTop(false);
        this.jDialogNewDoctor.setVisible(true);
        this.jDialogNewDoctor.setAlwaysOnTop(true);
    }
    public void welcome(){
        chooseSignIn();
        this.jLabelIconSignIn.setIcon(new ImageIcon(getClass().getResource("icon-healthkeeper.png")));
        this.jLabelIconSignIn.setText("");
        this.setVisible(false);
        this.jDialogNewUser.setVisible(false);
        this.jDialogNewUser.setAlwaysOnTop(false);
        this.jDialogNewDoctor.setVisible(false);
        this.jDialogNewDoctor.setAlwaysOnTop(false);
        this.jDialogSignIn.setVisible(true);
        this.jDialogSignIn.setAlwaysOnTop(true);
    }

    //call this method to -display the data after sign in / refresh
    public void start() {

        this.setVisible(true);
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        Dimension d = new Dimension(screenSize.width*65/100,screenSize.height*7/10);
        this.setSize(d);
        
        
        centreWindow(this);
        this.jTabbedPane1.addTab("General  ", new GeneralHealthPanel(user));
        this.jTabbedPane1.addTab("Tests/Reports  ", new TestReportsPanel(user));
        this.jTabbedPane1.addTab("Medicines  ", new MedicinesPanel(user));

        this.jTabbedPane1.setIconAt(2, new ImageIcon(getClass().getResource("icon-medicine-small.png")));
        this.jTabbedPane1.setIconAt(1, new ImageIcon(getClass().getResource("icon-testreports-small.png")));
        this.jTabbedPane1.setIconAt(0, new ImageIcon(getClass().getResource("icon-info-small.png")));
        
    }
    
    public static void centreWindow(Window frame) {
        Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
        int x = (int) ((dimension.getWidth() - frame.getWidth()) / 2);
        int y = (int) ((dimension.getHeight() - frame.getHeight()) / 2);
        frame.setLocation(x, y);
    }
    
    public boolean validateString(String a){
        if(a==null){
            return false;
        }
        return true;
    }
    public boolean validateInt(String a){
        if(a==null){
            return false;
        }
        try{
            Integer.parseInt(a);
        }
        catch(NumberFormatException e){
            return false;
        }
        return true;
    }
    
    
    public static Doctor getCurrentDoctor(){
        return currentDoc;
    }
    public static boolean isAuthenticated(){
        return authenticated;
    }
    public static boolean isUser(){
        return signedInAsUser;
    }
    
    
    
    
    
    
    

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jDialogSignIn = new javax.swing.JDialog();
        jComboBoxSignInPossiblities = new javax.swing.JComboBox<>();
        jLabel12 = new javax.swing.JLabel();
        jButtonCloseSignIn = new javax.swing.JButton();
        jButtonSignIn = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        jLabelIconSignIn = new javax.swing.JLabel();
        jTextFieldPin = new javax.swing.JPasswordField();
        jLabelSignInErr = new javax.swing.JLabel();
        jDialogNewUser = new javax.swing.JDialog();
        jLabel15 = new javax.swing.JLabel();
        jTextFieldUserName1 = new javax.swing.JTextField();
        jTextFieldUserAge1 = new javax.swing.JTextField();
        jLabel16 = new javax.swing.JLabel();
        jTextFieldUserPin1 = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jComboBoxUserSex1 = new javax.swing.JComboBox<>();
        jLabel17 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTextPaneUserInfo1 = new javax.swing.JTextPane();
        jButtonUserDone1 = new javax.swing.JButton();
        jLabelNewUserErr = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jButtonCloseUserSignUp = new javax.swing.JButton();
        jDialogNewDoctor = new javax.swing.JDialog();
        jLabel1 = new javax.swing.JLabel();
        jButtonNewDoctor = new javax.swing.JButton();
        jLabelDoctorErr = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jTextFieldDoctorName = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jTextFieldDoctorHospital = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jTextFieldDoctorPin = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextPaneDoctorInfo = new javax.swing.JTextPane();
        jButtonClose = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jTabbedPane1 = new javax.swing.JTabbedPane();

        jDialogSignIn.setLocationByPlatform(true);
        jDialogSignIn.setMinimumSize(new java.awt.Dimension(400, 300));
        jDialogSignIn.setUndecorated(true);

        jComboBoxSignInPossiblities.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel12.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel12.setText("New Doctor?");
        jLabel12.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel12MouseClicked(evt);
            }
        });

        jButtonCloseSignIn.setText("Close");
        jButtonCloseSignIn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonCloseSignInActionPerformed(evt);
            }
        });

        jButtonSignIn.setText("Sign In");
        jButtonSignIn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonSignInActionPerformed(evt);
            }
        });

        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel7.setText("Health Keeper - Sign in to view the patients data");

        jLabelIconSignIn.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelIconSignIn.setText("--");

        jTextFieldPin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldPinActionPerformed(evt);
            }
        });

        jLabelSignInErr.setForeground(new java.awt.Color(255, 51, 51));

        javax.swing.GroupLayout jDialogSignInLayout = new javax.swing.GroupLayout(jDialogSignIn.getContentPane());
        jDialogSignIn.getContentPane().setLayout(jDialogSignInLayout);
        jDialogSignInLayout.setHorizontalGroup(
            jDialogSignInLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jDialogSignInLayout.createSequentialGroup()
                .addGroup(jDialogSignInLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel7, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 500, Short.MAX_VALUE)
                    .addGroup(jDialogSignInLayout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jDialogSignInLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jDialogSignInLayout.createSequentialGroup()
                                .addComponent(jLabel12)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabelSignInErr)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButtonCloseSignIn)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButtonSignIn))
                            .addComponent(jComboBoxSignInPossiblities, 0, 284, Short.MAX_VALUE)
                            .addComponent(jTextFieldPin))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jDialogSignInLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabelIconSignIn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jDialogSignInLayout.setVerticalGroup(
            jDialogSignInLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jDialogSignInLayout.createSequentialGroup()
                .addContainerGap(59, Short.MAX_VALUE)
                .addComponent(jLabelIconSignIn)
                .addGap(18, 18, 18)
                .addComponent(jLabel7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jTextFieldPin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jComboBoxSignInPossiblities, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jDialogSignInLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonSignIn)
                    .addComponent(jButtonCloseSignIn)
                    .addComponent(jLabel12)
                    .addComponent(jLabelSignInErr))
                .addContainerGap(122, Short.MAX_VALUE))
        );

        jDialogNewUser.setLocationByPlatform(true);
        jDialogNewUser.setMinimumSize(new java.awt.Dimension(400, 300));
        jDialogNewUser.setUndecorated(true);

        jLabel15.setText("Name: ");

        jLabel16.setText("Age: ");

        jLabel13.setText("Pin: ");

        jLabel14.setText("Sex: ");

        jComboBoxUserSex1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Male", "Female", "Other" }));

        jLabel17.setText("Additional Info: ");

        jScrollPane3.setViewportView(jTextPaneUserInfo1);

        jButtonUserDone1.setText("Done");
        jButtonUserDone1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonUserDone1ActionPerformed(evt);
            }
        });

        jLabelNewUserErr.setForeground(new java.awt.Color(255, 0, 0));
        jLabelNewUserErr.setText("jLabel6");

        jLabel6.setFont(new java.awt.Font("Trebuchet MS", 0, 24)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(102, 102, 102));
        jLabel6.setText("New User");

        jButtonCloseUserSignUp.setText("Close");
        jButtonCloseUserSignUp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonCloseUserSignUpActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jDialogNewUserLayout = new javax.swing.GroupLayout(jDialogNewUser.getContentPane());
        jDialogNewUser.getContentPane().setLayout(jDialogNewUserLayout);
        jDialogNewUserLayout.setHorizontalGroup(
            jDialogNewUserLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jDialogNewUserLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jDialogNewUserLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jDialogNewUserLayout.createSequentialGroup()
                        .addComponent(jLabel17)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jDialogNewUserLayout.createSequentialGroup()
                        .addComponent(jButtonCloseUserSignUp)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabelNewUserErr)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButtonUserDone1))
                    .addComponent(jScrollPane3)
                    .addGroup(jDialogNewUserLayout.createSequentialGroup()
                        .addGroup(jDialogNewUserLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel14)
                            .addComponent(jLabel13))
                        .addGap(27, 27, 27)
                        .addGroup(jDialogNewUserLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jTextFieldUserPin1)
                            .addComponent(jComboBoxUserSex1, 0, 328, Short.MAX_VALUE)))
                    .addGroup(jDialogNewUserLayout.createSequentialGroup()
                        .addGroup(jDialogNewUserLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel15)
                            .addComponent(jLabel16))
                        .addGap(18, 18, 18)
                        .addGroup(jDialogNewUserLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jTextFieldUserName1)
                            .addComponent(jTextFieldUserAge1)))
                    .addGroup(jDialogNewUserLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jLabel6)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jDialogNewUserLayout.setVerticalGroup(
            jDialogNewUserLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jDialogNewUserLayout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jDialogNewUserLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel15)
                    .addComponent(jTextFieldUserName1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jDialogNewUserLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel16)
                    .addComponent(jTextFieldUserAge1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jDialogNewUserLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel14)
                    .addComponent(jComboBoxUserSex1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jDialogNewUserLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jTextFieldUserPin1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel13))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel17)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 85, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jDialogNewUserLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonUserDone1)
                    .addComponent(jLabelNewUserErr)
                    .addComponent(jButtonCloseUserSignUp))
                .addContainerGap())
        );

        jDialogNewDoctor.setAlwaysOnTop(true);
        jDialogNewDoctor.setBackground(new java.awt.Color(255, 255, 255));
        jDialogNewDoctor.setUndecorated(true);

        jLabel1.setFont(new java.awt.Font("Trebuchet MS", 0, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(102, 102, 102));
        jLabel1.setText("New Doctor");

        jButtonNewDoctor.setText("Done");
        jButtonNewDoctor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonNewDoctorActionPerformed(evt);
            }
        });

        jLabelDoctorErr.setForeground(new java.awt.Color(255, 0, 0));
        jLabelDoctorErr.setText("jLabel2");

        jLabel2.setText("Name: ");

        jLabel3.setText("Hospital: ");

        jLabel4.setText("Pin: ");

        jLabel5.setText("Additional Info: ");

        jScrollPane1.setViewportView(jTextPaneDoctorInfo);

        jButtonClose.setText("Close");
        jButtonClose.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonCloseActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jDialogNewDoctorLayout = new javax.swing.GroupLayout(jDialogNewDoctor.getContentPane());
        jDialogNewDoctor.getContentPane().setLayout(jDialogNewDoctorLayout);
        jDialogNewDoctorLayout.setHorizontalGroup(
            jDialogNewDoctorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jDialogNewDoctorLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jDialogNewDoctorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jDialogNewDoctorLayout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jDialogNewDoctorLayout.createSequentialGroup()
                        .addComponent(jButtonClose)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 226, Short.MAX_VALUE)
                        .addComponent(jLabelDoctorErr)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButtonNewDoctor))
                    .addGroup(jDialogNewDoctorLayout.createSequentialGroup()
                        .addGroup(jDialogNewDoctorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4)
                            .addComponent(jLabel2))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jDialogNewDoctorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jTextFieldDoctorName)
                            .addComponent(jTextFieldDoctorHospital)
                            .addComponent(jTextFieldDoctorPin)))
                    .addComponent(jScrollPane1)
                    .addGroup(jDialogNewDoctorLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jLabel1)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jDialogNewDoctorLayout.setVerticalGroup(
            jDialogNewDoctorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jDialogNewDoctorLayout.createSequentialGroup()
                .addGap(38, 38, 38)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jDialogNewDoctorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jTextFieldDoctorName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jDialogNewDoctorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jTextFieldDoctorHospital, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jDialogNewDoctorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jTextFieldDoctorPin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 89, Short.MAX_VALUE)
                .addGap(1, 1, 1)
                .addGroup(jDialogNewDoctorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonNewDoctor)
                    .addComponent(jLabelDoctorErr)
                    .addComponent(jButtonClose))
                .addContainerGap())
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Health Keeper");
        setBackground(new java.awt.Color(153, 255, 102));
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosed(java.awt.event.WindowEvent evt) {
                formWindowClosed(evt);
            }
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jTabbedPane1.setBackground(new java.awt.Color(255, 255, 255));
        jTabbedPane1.setForeground(new java.awt.Color(153, 204, 255));
        jTabbedPane1.setTabLayoutPolicy(javax.swing.JTabbedPane.SCROLL_TAB_LAYOUT);
        jTabbedPane1.setFont(new java.awt.Font("Microsoft JhengHei UI", 0, 14)); // NOI18N

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 439, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 260, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowClosed(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosed

    }//GEN-LAST:event_formWindowClosed

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        int confirmed = JOptionPane.showConfirmDialog(null,
                "Overwrite changes in the file?", "Save changes?",
                JOptionPane.YES_NO_OPTION);

        if (confirmed == JOptionPane.YES_OPTION) {
            dataSync.saveUser(user);
        }
    }//GEN-LAST:event_formWindowClosing

    private void jButtonSignInActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonSignInActionPerformed
        signIn();
    }//GEN-LAST:event_jButtonSignInActionPerformed

    //SIgnin method implementation
    public void signIn() {
        
        String s = this.jComboBoxSignInPossiblities.getSelectedItem().toString();
        System.out.println(s);
        if (s == "User") {
            this.authenticateUser();
            
        } else if (s == "New Doctor") {
            this.newDoctor();
            
        } else if (s != null && (s.length() > 0)) {
            Doctor temp = null;
            for (int i = 0; i < user.doctors.size(); i++) {
                if (user.doctors.get(i).getName() == s) {
                    temp = user.doctors.get(i);
                }
            }

            this.authenticateDoctor(temp);
        }
        
    }

    
    //let user choose among previous accounts
    public void chooseSignIn() {

        String possibilities[] = new String[user.doctors.size() + 2];
        possibilities[0] = "User";
        possibilities[1] = "New Doctor";
        for (int i = 0; i < user.doctors.size(); i++) {
            possibilities[i + 2] = user.doctors.get(i).getName();
        }

        this.jComboBoxSignInPossiblities.setModel(new DefaultComboBoxModel(possibilities));

        
    }
    
    //once we know which doc is trying to signin
    public boolean authenticateDoctor(Doctor doc){
        int pin=0;
        try{
            pin = Integer.parseInt(this.jTextFieldPin.getText());
        }
        catch(Exception e){
            this.jLabelSignInErr.setText("invalid");
        }
        
        if(pin==doc.getPin()){
            signedInAsUser=false;
            currentDoc=doc;
            authenticated=true;
            this.signInDone();
            return true;
        }
        this.jLabelSignInErr.setText("invalid");
        return false;
    }
    
    //there's only one user
    public boolean authenticateUser(){
        int pin=0;
        try{
            pin = Integer.parseInt(this.jTextFieldPin.getText());
        }
        catch(Exception e){
            this.jLabelSignInErr.setText("invalid");
            return false;
        }
        System.out.println(pin +" "+ user.pin);
        if(pin==user.pin){
            signedInAsUser=true;
            authenticated=true;
            this.signInDone();
            return true;
        }
        return false;
    }
    
    private void jLabel12MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel12MouseClicked
        newDoctor();
    }//GEN-LAST:event_jLabel12MouseClicked

    private void jButtonUserDone1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonUserDone1ActionPerformed
                this.jLabelNewUserErr.setText("");
        String name="",sex="",info="";
        int age=0, pin=0;

        try{
            name = this.jTextFieldUserName1.getText();
            String sAge = this.jTextFieldUserAge1.getText();
            age = Integer.parseInt(sAge);
            sex = this.jComboBoxUserSex1.getSelectedItem().toString();
            String sPin = this.jTextFieldUserPin1.getText();
            pin  =Integer.parseInt(sPin);
            info = this.jTextPaneUserInfo1.getText();
        }
        catch(Exception e){
            this.jLabelNewUserErr.setText("invalid");
            
            return;
        }

        user = new User(name,age,sex,pin,info);
        authenticated=true;
        currentDoc=null;
        this.signInDone();

    }//GEN-LAST:event_jButtonUserDone1ActionPerformed

    private void jButtonNewDoctorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonNewDoctorActionPerformed
       this.jLabelDoctorErr.setText("");
        String name="",hospital="",info="";
        int age=0, pin=0;

        try{
            name = this.jTextFieldDoctorName.getText();
            String sPin = this.jTextFieldDoctorPin.getText();
            hospital = this.jTextFieldDoctorHospital.getText();
            pin  =Integer.parseInt(sPin);
            info = this.jTextPaneDoctorInfo.getText();
        }
        catch(Exception e){
            this.jLabelDoctorErr.setText("invalid");
            return;
        }
        Doctor temp = new Doctor(name,hospital,info,pin);
        user.doctors.add(temp);
        authenticated=true;
        currentDoc=temp;
        this.signInDone();
    }//GEN-LAST:event_jButtonNewDoctorActionPerformed

    private void jButtonCloseSignInActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCloseSignInActionPerformed
        System.exit(0);
    }//GEN-LAST:event_jButtonCloseSignInActionPerformed

    private void jButtonCloseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCloseActionPerformed
        System.exit(0);
    }//GEN-LAST:event_jButtonCloseActionPerformed

    private void jButtonCloseUserSignUpActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCloseUserSignUpActionPerformed
        System.exit(0);
    }//GEN-LAST:event_jButtonCloseUserSignUpActionPerformed

    private void jTextFieldPinActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldPinActionPerformed
        signIn();
    }//GEN-LAST:event_jTextFieldPinActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
            
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(HealthKeeper.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(HealthKeeper.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(HealthKeeper.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(HealthKeeper.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new HealthKeeper().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonClose;
    private javax.swing.JButton jButtonCloseSignIn;
    private javax.swing.JButton jButtonCloseUserSignUp;
    private javax.swing.JButton jButtonNewDoctor;
    private javax.swing.JButton jButtonSignIn;
    private javax.swing.JButton jButtonUserDone1;
    private javax.swing.JComboBox<String> jComboBoxSignInPossiblities;
    private javax.swing.JComboBox<String> jComboBoxUserSex1;
    private javax.swing.JDialog jDialogNewDoctor;
    private javax.swing.JDialog jDialogNewUser;
    private javax.swing.JDialog jDialogSignIn;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabelDoctorErr;
    private javax.swing.JLabel jLabelIconSignIn;
    private javax.swing.JLabel jLabelNewUserErr;
    private javax.swing.JLabel jLabelSignInErr;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTextField jTextFieldDoctorHospital;
    private javax.swing.JTextField jTextFieldDoctorName;
    private javax.swing.JTextField jTextFieldDoctorPin;
    private javax.swing.JPasswordField jTextFieldPin;
    private javax.swing.JTextField jTextFieldUserAge1;
    private javax.swing.JTextField jTextFieldUserName1;
    private javax.swing.JTextField jTextFieldUserPin1;
    private javax.swing.JTextPane jTextPaneDoctorInfo;
    private javax.swing.JTextPane jTextPaneUserInfo1;
    // End of variables declaration//GEN-END:variables
}
