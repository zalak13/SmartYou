/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UserInterface.AppUsersProfile.Activities;

import Business.Appliances.Appliance;
import Business.Enterprise.Enterprise;
import Business.Investor.Financials;
import Business.Organization.Organization;
import Business.UserAccount.UserAccount;
import UserInterface.AppUsersProfile.Setup.InitialBankSetupJPanel;
import java.awt.CardLayout;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 *
 * @author Zak
 */
public class ActivitiesWorkAreaJPanel extends javax.swing.JPanel {

    private Enterprise enterprise;
    private UserAccount userAccount;
    private JPanel userProcessContainer;

    /**
     * Creates new form ActivitiesWorkAreaJPanel
     */
    public ActivitiesWorkAreaJPanel(JPanel upc, UserAccount acc, Enterprise e) {
        initComponents();
        userProcessContainer = upc;
        userAccount = acc;
        enterprise = e;
        populateFinancialActivities();
        btnPerform.setVisible(false);
    }

    public void populateFinancialActivities() {
        financialActivitiesComboBox.removeAllItems();
        for (Financials fin : userAccount.getInvestor().getFinancialsDirectory().getFinancialsList()) {
            financialActivitiesComboBox.addItem(fin);
        }
    }

    public boolean CheckApplianceStatus() {
        boolean isHouseSetup = false;
        boolean isHealthSetup = false;
        for (Appliance app : userAccount.getApplianceDirectory().getApplianceList()) {
            if (app.getApplianceType().equalsIgnoreCase("Home")) {
                isHouseSetup = true;
            }
            if (app.getApplianceType().equalsIgnoreCase("Health")) {
                isHealthSetup = true;
            }
        }
        if (!isHealthSetup) {
            JOptionPane.showMessageDialog(null, "Please setup the Health appliances before using this feature.");
            return false;
        }
        if (!isHouseSetup) {
            JOptionPane.showMessageDialog(null, "Please setup the House appliances before using this feature.");
            return false;
        }
        return true;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnRunning = new com.alee.laf.button.WebButton();
        btnStudy = new com.alee.laf.button.WebButton();
        btnSleeping = new com.alee.laf.button.WebButton();
        btnPerform = new com.alee.laf.button.WebButton();
        webLabel1 = new com.alee.laf.label.WebLabel();
        btnBack = new javax.swing.JButton();
        financialActivitiesComboBox = new javax.swing.JComboBox();

        setPreferredSize(new java.awt.Dimension(1025, 682));

        btnRunning.setText("Running");
        btnRunning.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N
        btnRunning.setPreferredSize(new java.awt.Dimension(200, 25));
        btnRunning.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRunningActionPerformed(evt);
            }
        });

        btnStudy.setText("Study");
        btnStudy.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N
        btnStudy.setPreferredSize(new java.awt.Dimension(200, 25));
        btnStudy.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnStudyActionPerformed(evt);
            }
        });

        btnSleeping.setText("Sleeping");
        btnSleeping.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N
        btnSleeping.setPreferredSize(new java.awt.Dimension(200, 25));
        btnSleeping.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSleepingActionPerformed(evt);
            }
        });

        btnPerform.setText(">>");
        btnPerform.setPreferredSize(new java.awt.Dimension(50, 25));
        btnPerform.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPerformActionPerformed(evt);
            }
        });

        webLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        webLabel1.setText("Activities List");
        webLabel1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N

        btnBack.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N
        btnBack.setText("<< Back");
        btnBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBackActionPerformed(evt);
            }
        });

        financialActivitiesComboBox.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N
        financialActivitiesComboBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        financialActivitiesComboBox.setToolTipText("Select the Activity from the Box");
        financialActivitiesComboBox.setPreferredSize(new java.awt.Dimension(200, 25));
        financialActivitiesComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                financialActivitiesComboBoxActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(350, 350, 350)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(btnStudy, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnRunning, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnSleeping, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(financialActivitiesComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(37, 37, 37)
                                .addComponent(webLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(100, 100, 100)
                        .addComponent(btnPerform, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(41, 41, 41)
                        .addComponent(btnBack, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(419, 419, 419))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(80, 80, 80)
                .addComponent(webLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(50, 50, 50)
                .addComponent(btnRunning, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(50, 50, 50)
                .addComponent(btnStudy, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(50, 50, 50)
                .addComponent(btnSleeping, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(50, 50, 50)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnPerform, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(financialActivitiesComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(150, 150, 150)
                .addComponent(btnBack)
                .addGap(42, 42, 42))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnRunningActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRunningActionPerformed
        // TODO add your handling code here:
        if (CheckApplianceStatus()) {
            RunningJPanel runningJPanel = new RunningJPanel(userProcessContainer, userAccount, enterprise, btnRunning.getText());
            userProcessContainer.add("runningJPanel", runningJPanel);
            CardLayout layout = (CardLayout) userProcessContainer.getLayout();
            layout.next(userProcessContainer);
        }
    }//GEN-LAST:event_btnRunningActionPerformed

    private void btnBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBackActionPerformed
        // TODO add your handling code here:
        userProcessContainer.remove(this);
        CardLayout layout = (CardLayout) userProcessContainer.getLayout();
        layout.previous(userProcessContainer);
    }//GEN-LAST:event_btnBackActionPerformed

    private void btnStudyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnStudyActionPerformed
        // TODO add your handling code here:
        if (CheckApplianceStatus()) {
            StudyJPanel studyJPanel = new StudyJPanel(userProcessContainer, userAccount, enterprise, btnStudy.getText());
            userProcessContainer.add("studyJPanel", studyJPanel);
            CardLayout layout = (CardLayout) userProcessContainer.getLayout();
            layout.next(userProcessContainer);
        }
    }//GEN-LAST:event_btnStudyActionPerformed

    private void btnSleepingActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSleepingActionPerformed
        // TODO add your handling code here:
        if (CheckApplianceStatus()) {
            SleepingJPanel sleepingJPanel = new SleepingJPanel(userProcessContainer, userAccount, enterprise, btnSleeping.getText());
            userProcessContainer.add("sleepingJPanel", sleepingJPanel);
            CardLayout layout = (CardLayout) userProcessContainer.getLayout();
            layout.next(userProcessContainer);
        }
    }//GEN-LAST:event_btnSleepingActionPerformed

    private void financialActivitiesComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_financialActivitiesComboBoxActionPerformed
        // TODO add your handling code here:
        btnPerform.setVisible(true);
    }//GEN-LAST:event_financialActivitiesComboBoxActionPerformed

    private void btnPerformActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPerformActionPerformed
        // TODO add your handling code here:
        FinancialTransactionJPanel financialTransactionJPanel = new FinancialTransactionJPanel(userProcessContainer, userAccount, enterprise, financialActivitiesComboBox.getSelectedItem().toString());
        userProcessContainer.add("financialTransactionJPanel", financialTransactionJPanel);
        CardLayout layout = (CardLayout) userProcessContainer.getLayout();
        layout.next(userProcessContainer);
    }//GEN-LAST:event_btnPerformActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBack;
    private com.alee.laf.button.WebButton btnPerform;
    private com.alee.laf.button.WebButton btnRunning;
    private com.alee.laf.button.WebButton btnSleeping;
    private com.alee.laf.button.WebButton btnStudy;
    private javax.swing.JComboBox financialActivitiesComboBox;
    private com.alee.laf.label.WebLabel webLabel1;
    // End of variables declaration//GEN-END:variables
}
