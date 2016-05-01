/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UserInterface.DoctorProfile;

import Business.Enterprise.Enterprise;
import Business.UserAccount.UserAccount;
import Business.WorkRequest.ActivityWorkRequest;
import Business.WorkRequest.WorkQueue;
import Business.WorkRequest.WorkRequest;
import java.awt.CardLayout;
import java.util.Date;
import java.util.concurrent.TimeUnit;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Zak
 */
public class ActivitiesJPanel extends javax.swing.JPanel {

    private JPanel userProcessContainer;
    private WorkQueue workQueue;
    private UserAccount doctorUserAccount;
    private UserAccount patientUserAccount;
    private Enterprise enterprise;

    /**
     * Creates new form ActivitiesJPanel
     */
    public ActivitiesJPanel(JPanel upc, UserAccount dua,UserAccount pua , WorkQueue wq) {
        initComponents();
        userProcessContainer = upc;
        doctorUserAccount = dua;
        patientUserAccount = pua;
        workQueue = wq;
        nameLabel.setText("<html><b>Name: " + patientUserAccount.getEmployee().getName()+"</b></html>");
        populateTable();
    }

    public static long getDateDiff(Date date1, Date date2, TimeUnit timeUnit) {
        long diffInMillies = date1.getTime() - date2.getTime();
        return timeUnit.convert(diffInMillies, TimeUnit.MILLISECONDS);
    }

    public void populateTable() {
        DefaultTableModel model = (DefaultTableModel) activitiesListJTable.getModel();
        model.setRowCount(0);

        for (WorkRequest request : workQueue.getWorkRequestList()) {
            ActivityWorkRequest awr = (ActivityWorkRequest) request;
            if (awr.getSender().equals(patientUserAccount) && awr.getReceiver().equals(doctorUserAccount)) {
                Object[] row = new Object[6];
                row[0] = awr.getMessage();
                row[1] = awr.getVitalSign().getBloodPressure();
                row[2] = awr.getVitalSign().getHeartRate();
                row[3] = awr.getVitalSign().getRespiratoryRate();
                row[4] = awr.getVitalSign().getTemperature();
                row[5] = getLastModified(awr.getVitalSign().getTimestamp());
                model.addRow(row);

            }
        }
    }

    public String getLastModified(Date d){
        String s ="Just Now";
        if(getDateDiff(new Date(),d , TimeUnit.DAYS)<=0){
                 if(getDateDiff(new Date(),d , TimeUnit.HOURS)<=0){
                    s=  String.valueOf(getDateDiff(new Date(), d, TimeUnit.MINUTES)) + " minutes ago";
                 } else
                     s=  String.valueOf(getDateDiff(new Date(), d, TimeUnit.HOURS)) + " hours ago";
        }else
        s = String.valueOf(getDateDiff(new Date(),d , TimeUnit.DAYS)) + " days ago";
        return s;
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
        btnBack = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        activitiesListJTable = new javax.swing.JTable();
        nameLabel = new javax.swing.JLabel();

        setPreferredSize(new java.awt.Dimension(1025, 682));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel1.setText("Activities List");

        btnBack.setText("<< Back");
        btnBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBackActionPerformed(evt);
            }
        });

        activitiesListJTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Activity", "Blood Pressure", "Pulse Rate", "Respiratory Rate", "Temperature", "Last Activity Log"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, true, true, true, true, true
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane2.setViewportView(activitiesListJTable);

        nameLabel.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        nameLabel.setText("Patient Name: ");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(btnBack, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(306, 306, 306)
                        .addComponent(jLabel1))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(42, 42, 42)
                        .addComponent(nameLabel)))
                .addGap(606, 606, 606))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 983, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(50, 50, 50)
                .addComponent(jLabel1)
                .addGap(50, 50, 50)
                .addComponent(nameLabel)
                .addGap(50, 50, 50)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(50, 50, 50)
                .addComponent(btnBack)
                .addGap(247, 247, 247))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBackActionPerformed
        // TODO add your handling code here:
        userProcessContainer.remove(this);
        CardLayout layout = (CardLayout) userProcessContainer.getLayout();
        layout.previous(userProcessContainer);
    }//GEN-LAST:event_btnBackActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable activitiesListJTable;
    private javax.swing.JButton btnBack;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel nameLabel;
    // End of variables declaration//GEN-END:variables
}
