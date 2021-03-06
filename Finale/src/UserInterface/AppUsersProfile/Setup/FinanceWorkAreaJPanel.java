/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UserInterface.AppUsersProfile.Setup;

import Business.EcoSystem;
import Business.Investor.Financials;
import Business.UserAccount.UserAccount;
import java.awt.CardLayout;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Zak
 */
public class FinanceWorkAreaJPanel extends javax.swing.JPanel {
    private JPanel userProcessContainer;
    private EcoSystem business;
    private UserAccount userAccount;
    /**
     * Creates new form healthWorkAreaJPanel
     */
    public FinanceWorkAreaJPanel(JPanel upc,UserAccount ua,EcoSystem e) {
        initComponents();
        userProcessContainer = upc;
        userAccount = ua;
        business = e;
        populateTable();
    }
    
    public void populateTable(){
        DefaultTableModel model = (DefaultTableModel) financialsTable.getModel();
        model.setRowCount(0);
        
        for (Financials financials : userAccount.getInvestor().getFinancialsDirectory().getFinancialsList()){
            Object[] row = new Object[4];
            row[0] =financials;
            row[1] = financials.getModeofSource();
            row[2] = financials.isAutoSync();
            row[3] = financials.getLastUpdated();
            model.addRow(row);
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

        jLabel1 = new javax.swing.JLabel();
        btnManageFinancialSources = new javax.swing.JButton();
        btnInitialBankSetup = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        financialsTable = new javax.swing.JTable();
        backJButton = new javax.swing.JButton();

        setPreferredSize(new java.awt.Dimension(1025, 682));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel1.setText("Finance Profile");

        btnManageFinancialSources.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N
        btnManageFinancialSources.setText("Manage Financial Sources");
        btnManageFinancialSources.setPreferredSize(new java.awt.Dimension(200, 25));
        btnManageFinancialSources.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnManageFinancialSourcesActionPerformed(evt);
            }
        });

        btnInitialBankSetup.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N
        btnInitialBankSetup.setText("Initial Bank Setup");
        btnInitialBankSetup.setPreferredSize(new java.awt.Dimension(200, 25));
        btnInitialBankSetup.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnInitialBankSetupActionPerformed(evt);
            }
        });

        financialsTable.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N
        financialsTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Source", "Mode Of Source", "IsAutoSync", "Last Updated"
            }
        ));
        jScrollPane1.setViewportView(financialsTable);

        backJButton.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N
        backJButton.setText("<< Back");
        backJButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backJButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(377, 377, 377)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(150, 150, 150)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 632, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btnInitialBankSetup, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(232, 232, 232)
                                .addComponent(btnManageFinancialSources, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(backJButton, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(243, 243, 243))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(80, 80, 80)
                .addComponent(jLabel1)
                .addGap(50, 50, 50)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(50, 50, 50)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnManageFinancialSources, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnInitialBankSetup, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(90, 90, 90)
                .addComponent(backJButton)
                .addGap(148, 148, 148))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnManageFinancialSourcesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnManageFinancialSourcesActionPerformed
        // TODO add your handling code here:
        ManageFundsJPanel manageFundsJPanel = new ManageFundsJPanel(userProcessContainer, userAccount);
        userProcessContainer.add("manageFundsJPanel", manageFundsJPanel);
        CardLayout layout = (CardLayout) userProcessContainer.getLayout();
        layout.next(userProcessContainer);        
    }//GEN-LAST:event_btnManageFinancialSourcesActionPerformed

    private void btnInitialBankSetupActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnInitialBankSetupActionPerformed
        // TODO add your handling code here:
        if(!userAccount.getInvestor().getSocialSecurityNumber().isEmpty()){
            JOptionPane.showMessageDialog(null, "Initial Setup is already done.");
            return ;
        }
        InitialBankSetupJPanel initialBankSetupJPanel = new InitialBankSetupJPanel(userProcessContainer, userAccount);
        userProcessContainer.add("initialBankSetupJPanel", initialBankSetupJPanel);
        CardLayout layout = (CardLayout) userProcessContainer.getLayout();
        layout.next(userProcessContainer);        
    }//GEN-LAST:event_btnInitialBankSetupActionPerformed

    private void backJButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backJButtonActionPerformed
        // TODO add your handling code here:
        userProcessContainer.remove(this);
        CardLayout layout = (CardLayout) userProcessContainer.getLayout();
        layout.previous(userProcessContainer);
    }//GEN-LAST:event_backJButtonActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton backJButton;
    private javax.swing.JButton btnInitialBankSetup;
    private javax.swing.JButton btnManageFinancialSources;
    private javax.swing.JTable financialsTable;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
