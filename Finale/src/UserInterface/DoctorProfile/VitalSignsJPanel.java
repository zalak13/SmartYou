/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UserInterface.DoctorProfile;

import Business.Patient.Patient;
import Business.Patient.VitalSign;
import java.awt.CardLayout;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Zak
 */
public class VitalSignsJPanel extends javax.swing.JPanel {

    private JPanel userProcessContainer;
    private Patient patient;
    private String patientName;

    /**
     * Creates new form VitalSignsJPanel
     */
    public VitalSignsJPanel(JPanel upc, Patient p, String n) {
        initComponents();
        userProcessContainer = upc;
        patient = p;
        patientName = n;
        NameLabel.setText(n.toUpperCase() + " Vital Signs");
        populateTable();
    }

    public void populateTable() {
        DefaultTableModel dtm = (DefaultTableModel) vitalSignTable.getModel();
        int rowCount = vitalSignTable.getRowCount();
        for (int i = rowCount - 1; i >= 0; i--) {
            dtm.removeRow(i);
        }
        for (VitalSign vitalSign : patient.getVitalSignHistory().getVitalSignList()) {
            Object row[] = new Object[5]; // In order to delete the complete object instead of just the attribute.
            row[0] = vitalSign.getRespiratoryRate();
            row[1] = vitalSign.getHeartRate();
            row[2] = vitalSign.getTemperature();
            row[3] = vitalSign.getBloodPressure();
            row[4] = vitalSign.getTimestamp();
            dtm.addRow(row);
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

        NameLabel = new javax.swing.JLabel();
        btnBack2 = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        vitalSignTable = new javax.swing.JTable();

        setPreferredSize(new java.awt.Dimension(1025, 682));

        NameLabel.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        NameLabel.setText("Vital Signs");

        btnBack2.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N
        btnBack2.setText("<< Back");
        btnBack2.setPreferredSize(new java.awt.Dimension(100, 25));
        btnBack2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBack2ActionPerformed(evt);
            }
        });

        jScrollPane2.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N

        vitalSignTable.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N
        vitalSignTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Respiratory Rate", "Pulse Rate", "Temperature", "Blood Pressure", "Time Stamp"
            }
        ));
        jScrollPane2.setViewportView(vitalSignTable);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(43, 43, 43)
                .addComponent(jScrollPane2)
                .addGap(147, 147, 147))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(btnBack2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(441, 441, 441)
                        .addComponent(NameLabel)))
                .addGap(495, 495, 495))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(50, 50, 50)
                .addComponent(NameLabel)
                .addGap(50, 50, 50)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 222, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(100, 100, 100)
                .addComponent(btnBack2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnBack2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBack2ActionPerformed
        // TODO add your handling code here:
        userProcessContainer.remove(this);
        CardLayout layout = (CardLayout) userProcessContainer.getLayout();
        layout.previous(userProcessContainer);
    }//GEN-LAST:event_btnBack2ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel NameLabel;
    private javax.swing.JButton btnBack2;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable vitalSignTable;
    // End of variables declaration//GEN-END:variables
}
