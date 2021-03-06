/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UserInterface.AppUsersProfile;

import Business.EcoSystem;
import Business.Employee.Employee;
import Business.Enterprise.Enterprise;
import Business.Network.Network;
import Business.Organization.Organization;
import Business.Organization.Organization.Type;
import Business.Profile.Profile;
import Business.UserAccount.UserAccount;
import com.alee.global.GlobalConstants;
import com.alee.laf.button.WebButton;
import com.alee.laf.filechooser.WebFileChooser;
import com.alee.utils.FileUtils;
import java.awt.Color;
import java.awt.event.KeyEvent;
import java.io.File;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 *
 * @author Zak
 */
public class NewAppUsersWorkAreaJPanel extends javax.swing.JPanel {

    private JPanel userProcessContainer;
    private EcoSystem business;
    private Enterprise enterprise;
    private WebButton showFrame;
    private WebFileChooser imageChooser = null;
    private File file = null;
    private String photoLink = null; //"H:\\MS Stuff\\NorthEastern Unversity\\Fall 2015\\AED Lab\\Project Finale\\No_image_available_svg.png";

    /**
     * Creates new form AppUsersWorkAreaJPanel
     */
    public NewAppUsersWorkAreaJPanel(JPanel upc, EcoSystem e, Enterprise en) {
        initComponents();
        userProcessContainer = upc;
        business = e;
        enterprise = en;
        populateUserTypeComboBox();
    }

    private void populateUserTypeComboBox() {
        userTypeJComboBox.removeAllItems();
        for (Type type : Organization.Type.values()) {
            if (!(type == Organization.Type.Admin)) {
                userTypeJComboBox.addItem(type);
            }
        }
    }

    public void restrictAlphabetinTxtFields(java.awt.event.KeyEvent evt) {
     char c = evt.getKeyChar();
     JTextField jt = (JTextField) evt.getSource();
     if (!((c >= 'A') && (c <= 'Z') || (c >= 'a') && (c <= 'z')
             || (c == KeyEvent.VK_BACK_SPACE)
             || (c == KeyEvent.VK_DELETE)
             || (c == KeyEvent.VK_SPACE))) {
         getToolkit().beep();
         jt.setText("");
         jt.setBackground(Color.red);
         evt.consume();

     } else {
         jt.setBackground(Color.white);
     }
 }
    
public void restrictNumericinTxtFields(java.awt.event.KeyEvent evt) {
     char c = evt.getKeyChar();
     JTextField jt = (JTextField) evt.getSource();
     if (!((c >= '0') && (c <= '9')
             || (c == KeyEvent.VK_BACK_SPACE)
             || (c == KeyEvent.VK_DELETE)
             || c == KeyEvent.VK_PERIOD)) {
         getToolkit().beep();
         jt.setText("");
         jt.setBackground(Color.yellow);
         evt.consume();

     } else {
         jt.setBackground(Color.white);
     }
 }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        createUserJButton = new javax.swing.JButton();
        jLabel11 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        lastNameJTextField = new javax.swing.JTextField();
        firstNameJTextField = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        genderJComboBox = new javax.swing.JComboBox();
        jPanel2 = new javax.swing.JPanel();
        nameJTextField = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        passwordJTextField = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        userTypeJComboBox = new javax.swing.JComboBox();
        btnFileExplorer = new com.alee.laf.button.WebButton();
        jLabel4 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        weightJTextField = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        heightJTextField = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        ageSpinner = new javax.swing.JSpinner();

        setPreferredSize(new java.awt.Dimension(1025, 682));

        createUserJButton.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N
        createUserJButton.setText("Create");
        createUserJButton.setPreferredSize(new java.awt.Dimension(200, 25));
        createUserJButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                createUserJButtonActionPerformed(evt);
            }
        });

        jLabel11.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel11.setText("Registration Form");

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 0, 11))); // NOI18N
        jPanel1.setPreferredSize(new java.awt.Dimension(460, 200));

        jLabel6.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N
        jLabel6.setText("Last Name");
        jLabel6.setPreferredSize(new java.awt.Dimension(200, 25));

        lastNameJTextField.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N
        lastNameJTextField.setPreferredSize(new java.awt.Dimension(200, 25));
        lastNameJTextField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                lastNameJTextFieldKeyTyped(evt);
            }
        });

        firstNameJTextField.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N
        firstNameJTextField.setPreferredSize(new java.awt.Dimension(200, 25));
        firstNameJTextField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                firstNameJTextFieldKeyTyped(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N
        jLabel7.setText("First Name");
        jLabel7.setPreferredSize(new java.awt.Dimension(200, 25));

        jLabel8.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N
        jLabel8.setText("Gender");
        jLabel8.setPreferredSize(new java.awt.Dimension(200, 25));

        genderJComboBox.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N
        genderJComboBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Male", "Female", "Unknown" }));
        genderJComboBox.setPreferredSize(new java.awt.Dimension(200, 25));
        genderJComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                genderJComboBoxActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel8, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(25, 25, 25)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lastNameJTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(genderJComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(firstNameJTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(16, 16, 16))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(firstNameJTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lastNameJTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(genderJComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(40, 40, 40))
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 0, 11))); // NOI18N
        jPanel2.setPreferredSize(new java.awt.Dimension(460, 200));

        nameJTextField.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N
        nameJTextField.setPreferredSize(new java.awt.Dimension(200, 25));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N
        jLabel2.setText("Password");
        jLabel2.setPreferredSize(new java.awt.Dimension(200, 25));

        passwordJTextField.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N
        passwordJTextField.setPreferredSize(new java.awt.Dimension(200, 25));

        jLabel10.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N
        jLabel10.setText("User Type");
        jLabel10.setPreferredSize(new java.awt.Dimension(200, 25));

        userTypeJComboBox.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N
        userTypeJComboBox.setPreferredSize(new java.awt.Dimension(200, 25));
        userTypeJComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                userTypeJComboBoxActionPerformed(evt);
            }
        });

        btnFileExplorer.setText("Open File Explorer");
        btnFileExplorer.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N
        btnFileExplorer.setPreferredSize(new java.awt.Dimension(200, 25));
        btnFileExplorer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFileExplorerActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N
        jLabel4.setText("Photo Upload");
        jLabel4.setPreferredSize(new java.awt.Dimension(200, 25));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N
        jLabel1.setText("User Name");
        jLabel1.setPreferredSize(new java.awt.Dimension(200, 25));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(15, 15, 15)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(passwordJTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(nameJTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnFileExplorer, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(userTypeJComboBox, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(21, 21, 21))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(nameJTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(passwordJTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(userTypeJComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnFileExplorer, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(15, 15, 15))
        );

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 0, 11))); // NOI18N
        jPanel3.setPreferredSize(new java.awt.Dimension(460, 200));

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N
        jLabel3.setText("Weight");
        jLabel3.setPreferredSize(new java.awt.Dimension(200, 25));

        weightJTextField.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N
        weightJTextField.setPreferredSize(new java.awt.Dimension(200, 25));
        weightJTextField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                weightJTextFieldKeyTyped(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N
        jLabel5.setText("Height");
        jLabel5.setPreferredSize(new java.awt.Dimension(200, 25));

        heightJTextField.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N
        heightJTextField.setPreferredSize(new java.awt.Dimension(200, 25));
        heightJTextField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                heightJTextFieldKeyTyped(evt);
            }
        });

        jLabel9.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N
        jLabel9.setText("Age");
        jLabel9.setPreferredSize(new java.awt.Dimension(200, 25));

        ageSpinner.setModel(new javax.swing.SpinnerNumberModel(10, 10, 100, 1));
        ageSpinner.setPreferredSize(new java.awt.Dimension(200, 25));

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(25, 25, 25)
                        .addComponent(weightJTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(25, 25, 25)
                        .addComponent(ageSpinner, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(25, 25, 25)
                        .addComponent(heightJTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(15, 15, 15))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(weightJTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(heightJTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(22, 22, 22)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(ageSpinner, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(57, 57, 57))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(443, 443, 443)
                        .addComponent(jLabel11))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(37, 37, 37)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(402, 402, 402)
                        .addComponent(createUserJButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(273, 273, 273)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(62, 62, 62))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(50, 50, 50)
                .addComponent(jLabel11)
                .addGap(50, 50, 50)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(50, 50, 50)
                .addComponent(createUserJButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(61, 61, 61))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void createUserJButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_createUserJButtonActionPerformed
        
        if(business.getNetworkList().isEmpty()){
            JOptionPane.showMessageDialog(null, "Please create the Network structure first.","ERROR",JOptionPane.ERROR_MESSAGE);
            return;
        }
        String userName = nameJTextField.getText();
        String password = passwordJTextField.getText();
        String fName = firstNameJTextField.getText().replaceAll("^\\s+|\\s+$", "");
        String lName = lastNameJTextField.getText().replaceAll("^\\s+|\\s+$", "");
         if (fName.equalsIgnoreCase("") || lName.equalsIgnoreCase("")) {
            JOptionPane.showMessageDialog(null, "Please fill in the details first");
            return;
        }
        Profile profile = null;
        Type t = (Type) userTypeJComboBox.getSelectedItem();

        Organization organization = null;
        
        for (Network network : business.getNetworkList()) {
            for (Enterprise en : network.getEnterpriseDirectory().getEnterpriseList()) {
                organization = en.getOrganizationDirectory().searchOrganization(t);
                if (organization != null) {
                    enterprise = en;
                }
                break;
            }
        }
        for (Profile pr : organization.getSupportedProfile()) {
            profile = pr.CreateProfile();
        }
        if (!organization.getUserAccountDirectory().checkIfUsernameIsUnique(userName)) {
            JOptionPane.showMessageDialog(null, userName + " is not Unique.Please choose a different user name");
            return;
        };
        Employee employee = organization.getEmployeeDirectory().createEmployee(fName + " " + lName);
        employee.setWeight(weightJTextField.getText());
        employee.setHeight(heightJTextField.getText());
        employee.setGender(genderJComboBox.getSelectedItem().toString());
        employee.setPhotoLink(photoLink);
        UserAccount ua = organization.getUserAccountDirectory().createUserAccount(userName, password, employee, profile);
        ua.getPatient().setAge(Integer.parseInt(ageSpinner.getValue().toString()));
        JOptionPane.showMessageDialog(null, "User has been Created");
    }//GEN-LAST:event_createUserJButtonActionPerformed

    private void genderJComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_genderJComboBoxActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_genderJComboBoxActionPerformed


    private void btnFileExplorerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFileExplorerActionPerformed
        // TODO add your handling code here:
        if (imageChooser == null) {
            imageChooser = new WebFileChooser();
            imageChooser.setMultiSelectionEnabled(false);
            imageChooser.setAcceptAllFileFilterUsed(false);
            imageChooser.addChoosableFileFilter(GlobalConstants.IMAGES_FILTER);
        }
        if (file != null) {
            imageChooser.setSelectedFile(file);
        }
        if (imageChooser.showOpenDialog(this) == WebFileChooser.APPROVE_OPTION) {
            file = imageChooser.getSelectedFile();
            btnFileExplorer.setIcon(FileUtils.getFileIcon(file));
            btnFileExplorer.setText(FileUtils.getDisplayFileName(file));
            photoLink = file.getAbsolutePath();
}


    }//GEN-LAST:event_btnFileExplorerActionPerformed

    private void userTypeJComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_userTypeJComboBoxActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_userTypeJComboBoxActionPerformed

    private void firstNameJTextFieldKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_firstNameJTextFieldKeyTyped
        restrictAlphabetinTxtFields(evt);
    }//GEN-LAST:event_firstNameJTextFieldKeyTyped

    private void lastNameJTextFieldKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_lastNameJTextFieldKeyTyped
        restrictAlphabetinTxtFields(evt);
    }//GEN-LAST:event_lastNameJTextFieldKeyTyped

    private void weightJTextFieldKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_weightJTextFieldKeyTyped
        restrictNumericinTxtFields(evt);
    }//GEN-LAST:event_weightJTextFieldKeyTyped

    private void heightJTextFieldKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_heightJTextFieldKeyTyped
        restrictNumericinTxtFields(evt);
    }//GEN-LAST:event_heightJTextFieldKeyTyped


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JSpinner ageSpinner;
    private com.alee.laf.button.WebButton btnFileExplorer;
    private javax.swing.JButton createUserJButton;
    private javax.swing.JTextField firstNameJTextField;
    private javax.swing.JComboBox genderJComboBox;
    private javax.swing.JTextField heightJTextField;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JTextField lastNameJTextField;
    private javax.swing.JTextField nameJTextField;
    private javax.swing.JTextField passwordJTextField;
    private javax.swing.JComboBox userTypeJComboBox;
    private javax.swing.JTextField weightJTextField;
    // End of variables declaration//GEN-END:variables
}
