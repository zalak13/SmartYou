/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UserInterface.AppUsersProfile.DetailAnalysis;

import Business.EcoSystem;
import Business.Patient.VitalSign;
import Business.UserAccount.UserAccount;
import com.alee.laf.label.WebLabel;
import com.alee.laf.tabbedpane.WebTabbedPane;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import javax.swing.JPanel;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;

/**
 *
 * @author Zak
 */
public class DetailAnalysisJPanel extends javax.swing.JPanel {
    private JPanel userProcessContainer;
    private EcoSystem business;
    private UserAccount userAccount;
    /**
     * Creates new form DetailAnalysisJPanel
     */
    public DetailAnalysisJPanel(JPanel upc, EcoSystem e, UserAccount ua) {
        initComponents();
        userProcessContainer = upc;
        userAccount = ua;
        business = e;
        populateGraphs();
    }
    
    public void populateGraphs(){
        drawGraph(bloodPressurePanel,"Blood Pressure");
        drawGraph(pulseRatePanel,"Pulse Rate");
        drawGraph(respiratoryRatePanel,"Respiratory Rate");
        drawGraph(temperaturePanel,"Temperature");
        WebTabbedPane tabbedPane3 =vitalSignsTabbedPane;
        tabbedPane3.removeAll();
        tabbedPane3.addTab ( "Blood Pressure", bloodPressurePanel );
        tabbedPane3.addTab ( "Pulse Rate", pulseRatePanel );
        tabbedPane3.addTab ( "Respiratory Rate", respiratoryRatePanel );
        tabbedPane3.addTab ( "Temperature", temperaturePanel );
    }
    
    public ChartPanel getChartPanel(String vitalSignType){
        
        int count = 1;
       DefaultCategoryDataset dataSet = new DefaultCategoryDataset();
       for (VitalSign vitalSign : userAccount.getPatient().getVitalSignHistory().getVitalSignList()) {
           String str = String.valueOf(count);
           if(vitalSignType.equalsIgnoreCase("Blood Pressure")){
               vitalSignType = "Blood Pressure";
               dataSet.addValue(vitalSign.getBloodPressure(), "Blood Pressure", str);
           }else if(vitalSignType.equalsIgnoreCase("Pulse Rate")){
               vitalSignType = "Pulse Rate";
               dataSet.addValue(vitalSign.getHeartRate(), "Pulse Rate", str);
           }else if(vitalSignType.equalsIgnoreCase("Respiratory Rate")){
               vitalSignType = "Respiratory Rate";
               dataSet.addValue(vitalSign.getRespiratoryRate(), "Respiratory Rate", str);
           }else if(vitalSignType.equalsIgnoreCase("Temperature")){
               vitalSignType = "Temperature";
               dataSet.addValue(vitalSign.getTemperature(), "Temperature", str);
           }
           count++;
       }
       JFreeChart chartFactory = ChartFactory.createLineChart(vitalSignType+" Chart", "Timestamp", vitalSignType, dataSet); 
       CategoryPlot plot = chartFactory.getCategoryPlot();
       plot.setBackgroundPaint(Color.WHITE);
       plot.setRangeGridlinePaint(Color.blue);
       ChartPanel chartPanel = new ChartPanel(chartFactory);
       return chartPanel;
    }
    
    public void drawGraph(JPanel panel,String vsType){
        panel.removeAll();
        panel.add(getChartPanel(vsType),BorderLayout.CENTER);
        panel.validate();
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
        webButton1 = new com.alee.laf.button.WebButton();
        vitalSignsTabbedPane = new com.alee.laf.tabbedpane.WebTabbedPane();
        bloodPressurePanel = new javax.swing.JPanel();
        pulseRatePanel = new javax.swing.JPanel();
        respiratoryRatePanel = new javax.swing.JPanel();
        temperaturePanel = new javax.swing.JPanel();

        setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N
        setPreferredSize(new java.awt.Dimension(1025, 682));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel1.setText("Detail Analysis");

        webButton1.setText("Refresh");
        webButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                webButton1ActionPerformed(evt);
            }
        });

        vitalSignsTabbedPane.setTabPlacement(javax.swing.JTabbedPane.LEFT);
        vitalSignsTabbedPane.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N
        vitalSignsTabbedPane.setPreferredSize(new java.awt.Dimension(1000, 250));

        bloodPressurePanel.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N
        bloodPressurePanel.setLayout(new java.awt.BorderLayout());
        vitalSignsTabbedPane.addTab("Blood Pressure", bloodPressurePanel);

        pulseRatePanel.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N
        pulseRatePanel.setPreferredSize(new java.awt.Dimension(925, 250));
        pulseRatePanel.setLayout(new java.awt.BorderLayout());
        vitalSignsTabbedPane.addTab("Pulse Rate", pulseRatePanel);

        respiratoryRatePanel.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N
        respiratoryRatePanel.setLayout(new java.awt.BorderLayout());
        vitalSignsTabbedPane.addTab("Respiratory Rate", respiratoryRatePanel);

        temperaturePanel.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N
        temperaturePanel.setPreferredSize(new java.awt.Dimension(925, 250));
        temperaturePanel.setLayout(new java.awt.BorderLayout());
        vitalSignsTabbedPane.addTab("Temperature", temperaturePanel);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(202, 202, 202)
                .addComponent(webButton1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(278, 278, 278))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(361, 361, 361)
                        .addComponent(jLabel1))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(40, 40, 40)
                        .addComponent(vitalSignsTabbedPane, javax.swing.GroupLayout.DEFAULT_SIZE, 945, Short.MAX_VALUE)))
                .addGap(40, 40, 40))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(50, 50, 50)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(webButton1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(58, 58, 58)))
                .addGap(26, 26, 26)
                .addComponent(vitalSignsTabbedPane, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(273, 273, 273))
        );

        vitalSignsTabbedPane.getAccessibleContext().setAccessibleName("Blood Pressure");
    }// </editor-fold>//GEN-END:initComponents

    private void webButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_webButton1ActionPerformed
        // TODO add your handling code here:
        populateGraphs();
    }//GEN-LAST:event_webButton1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel bloodPressurePanel;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel pulseRatePanel;
    private javax.swing.JPanel respiratoryRatePanel;
    private javax.swing.JPanel temperaturePanel;
    private com.alee.laf.tabbedpane.WebTabbedPane vitalSignsTabbedPane;
    private com.alee.laf.button.WebButton webButton1;
    // End of variables declaration//GEN-END:variables
}
