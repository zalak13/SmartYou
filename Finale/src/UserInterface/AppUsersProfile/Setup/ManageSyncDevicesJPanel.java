/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UserInterface.AppUsersProfile.Setup;

import Business.Appliances.Appliance;
import Business.UserAccount.UserAccount;
import java.awt.CardLayout;
import java.awt.Component;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Zak
 */
public class ManageSyncDevicesJPanel extends javax.swing.JPanel {

    private JPanel userProcessContainer;
    private UserAccount userAccount;
    private HomeMakerWorkAreaJPanel homeMakerWorkAreaJPanel;
    private HealthWorkAreaJPanel healthWorkAreaJPanel;
    private boolean isHealthPanel = true;

    /**
     * Creates new form ManageSyncDevicesJPanel
     */
    public ManageSyncDevicesJPanel(JPanel upc, UserAccount ua, HomeMakerWorkAreaJPanel hmwajp) {
        initComponents();
        userProcessContainer = upc;
        userAccount = ua;
        homeMakerWorkAreaJPanel = hmwajp;
        isHealthPanel = false;
        applianceTypeTextField.setText("Home");
        populateApplianceComboBox("Home");
        populateTable();
    }

    public ManageSyncDevicesJPanel(JPanel upc, UserAccount ua, HealthWorkAreaJPanel hwajp) {
        initComponents();
        userProcessContainer = upc;
        userAccount = ua;
        healthWorkAreaJPanel = hwajp;
        applianceTypeTextField.setText("Health");
        populateApplianceComboBox("Health");
        populateTable();

    }

    public void populateApplianceComboBox(String apptype) {
        applianceJComboBox.removeAllItems();
        if (apptype.equalsIgnoreCase("Health")) {
            applianceJComboBox.addItem("Health Band");
            applianceJComboBox.addItem("Heart Monitor");
            applianceJComboBox.addItem("Temperature Monitor");
        } else if (apptype.equalsIgnoreCase("Home")) {
            applianceJComboBox.addItem("Lights");
            applianceJComboBox.addItem("Home Thermostat");
            applianceJComboBox.addItem("Music Player");
            applianceJComboBox.addItem("Automatic Kettle");
        }
    }

    public void populateTable() {
        DefaultTableModel model = (DefaultTableModel) applianceJTable.getModel();
        model.setRowCount(0);

        for (Appliance appliance : userAccount.getApplianceDirectory().getApplianceList()) {
            Object[] row = new Object[1];
            if (appliance.getApplianceType().equalsIgnoreCase("Health") && isHealthPanel) {
                row[0] = appliance;
                model.addRow(row);
            } else if (appliance.getApplianceType().equalsIgnoreCase("Home") && !isHealthPanel) {
                row[0] = appliance;
                model.addRow(row);
            }
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

        submitJButton = new javax.swing.JButton();
        backJButton = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        applianceJTable = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        statusJComboBox = new javax.swing.JComboBox();
        AutoSyncStatusJComboBox = new javax.swing.JComboBox();
        jLabel4 = new javax.swing.JLabel();
        applianceJComboBox = new javax.swing.JComboBox();
        applianceTypeTextField = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();

        setPreferredSize(new java.awt.Dimension(1025, 682));

        submitJButton.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N
        submitJButton.setText("Submit");
        submitJButton.setPreferredSize(new java.awt.Dimension(200, 25));
        submitJButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                submitJButtonActionPerformed(evt);
            }
        });

        backJButton.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N
        backJButton.setText("<< Back");
        backJButton.setPreferredSize(new java.awt.Dimension(100, 25));
        backJButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backJButtonActionPerformed(evt);
            }
        });

        applianceJTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Appliance Name"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(applianceJTable);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N
        jLabel1.setText("Device Name");
        jLabel1.setPreferredSize(new java.awt.Dimension(200, 25));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N
        jLabel2.setText("Status");
        jLabel2.setPreferredSize(new java.awt.Dimension(200, 25));

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N
        jLabel3.setText("Auto-Sync");
        jLabel3.setPreferredSize(new java.awt.Dimension(200, 25));

        statusJComboBox.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N
        statusJComboBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "ON", "OFF" }));
        statusJComboBox.setPreferredSize(new java.awt.Dimension(200, 25));
        statusJComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                statusJComboBoxActionPerformed(evt);
            }
        });

        AutoSyncStatusJComboBox.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N
        AutoSyncStatusJComboBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "TRUE", "FALSE" }));
        AutoSyncStatusJComboBox.setPreferredSize(new java.awt.Dimension(200, 25));
        AutoSyncStatusJComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AutoSyncStatusJComboBoxActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N
        jLabel4.setText("Appliance Type");
        jLabel4.setPreferredSize(new java.awt.Dimension(200, 25));

        applianceJComboBox.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N
        applianceJComboBox.setPreferredSize(new java.awt.Dimension(200, 25));
        applianceJComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                applianceJComboBoxActionPerformed(evt);
            }
        });

        applianceTypeTextField.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N
        applianceTypeTextField.setEnabled(false);
        applianceTypeTextField.setPreferredSize(new java.awt.Dimension(200, 25));

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel5.setText("Manage Appliances");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(350, 350, 350)
                        .addComponent(jLabel5))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(200, 200, 200)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(141, 141, 141)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(statusJComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(AutoSyncStatusJComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(applianceJComboBox, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(applianceTypeTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(submitJButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(36, 36, 36)
                        .addComponent(backJButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(284, 284, 284))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(50, 50, 50)
                .addComponent(jLabel5)
                .addGap(50, 50, 50)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(40, 40, 40)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(applianceTypeTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(applianceJComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(statusJComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(AutoSyncStatusJComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(40, 40, 40)
                .addComponent(submitJButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28)
                .addComponent(backJButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(75, 75, 75))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void submitJButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_submitJButtonActionPerformed
        ArrayList<String> appList = new ArrayList<>();
        for (int count = 0; count < applianceJTable.getRowCount(); count++) {
            appList.add(applianceJTable.getValueAt(count, 0).toString());
        }
        String type = (String) applianceJComboBox.getSelectedItem();
        if (appList.contains(type)) {
            JOptionPane.showMessageDialog(this, "Appliance is already added to user Account", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        Appliance appliance = userAccount.getApplianceDirectory().addAppliance();
        appliance.setApplianceName(applianceJComboBox.getSelectedItem().toString());
        appliance.setStatus(statusJComboBox.getSelectedItem().toString());
        appliance.setAutoSync(Boolean.parseBoolean(AutoSyncStatusJComboBox.getSelectedItem().toString()));
        appliance.setApplianceType(applianceTypeTextField.getText());
        appliance.setLastSynced(new Date());
        populateTable();
    }//GEN-LAST:event_submitJButtonActionPerformed

    private void backJButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backJButtonActionPerformed
        userProcessContainer.remove(this);
        CardLayout cardLayout = (CardLayout) userProcessContainer.getLayout();
        cardLayout.previous(userProcessContainer);
        if (isHealthPanel) {
            healthWorkAreaJPanel.populateTable();
        } else {
            homeMakerWorkAreaJPanel.populateTable();
        }
    }//GEN-LAST:event_backJButtonActionPerformed

    private void statusJComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_statusJComboBoxActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_statusJComboBoxActionPerformed

    private void AutoSyncStatusJComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AutoSyncStatusJComboBoxActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_AutoSyncStatusJComboBoxActionPerformed

    private void applianceJComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_applianceJComboBoxActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_applianceJComboBoxActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox AutoSyncStatusJComboBox;
    private javax.swing.JComboBox applianceJComboBox;
    private javax.swing.JTable applianceJTable;
    private javax.swing.JTextField applianceTypeTextField;
    private javax.swing.JButton backJButton;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JComboBox statusJComboBox;
    private javax.swing.JButton submitJButton;
    // End of variables declaration//GEN-END:variables
}
