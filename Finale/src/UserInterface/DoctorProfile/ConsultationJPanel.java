/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UserInterface.DoctorProfile;

import Business.Employee.EmployeeDirectory;
import Business.Enterprise.Enterprise;
import Business.Organization.AppUsersOrganization;
import Business.Organization.DoctorOrganization;
import Business.Organization.Organization;
import Business.UserAccount.UserAccount;
import Business.WorkRequest.WorkQueue;
import Business.WorkRequest.WorkRequest;
import com.alee.extended.layout.ComponentPanelLayout;
import com.alee.extended.panel.WebAccordion;
import com.alee.extended.panel.WebAccordionStyle;
import com.alee.laf.button.WebButton;
import com.alee.laf.optionpane.WebOptionPane;
import com.alee.laf.scroll.WebScrollPane;
import java.awt.CardLayout;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author Zak
 */
public class ConsultationJPanel extends javax.swing.JPanel {

    private JPanel userProcessContainer;
    private UserAccount doctorUserAccount;
    private Enterprise enterprise;
    private EmployeeDirectory patient;
    private ArrayList<UserAccount> uaList;
    private ImageIcon icon = null;
    private WebAccordion accordion = null;

    /**
     * Creates new form ConsultationJPanel
     */
    public ConsultationJPanel(JPanel upc, UserAccount acc, Enterprise e) {
        initComponents();
        userProcessContainer = upc;
        doctorUserAccount = acc;
        enterprise = e;
        uaList = patientList();
        icon = new ImageIcon();
        webAccordion1.setAccordionStyle(WebAccordionStyle.accordionStyle);
        accordion = webAccordion1;
        WebAccordionExample();
    }

    public final void WebAccordionExample() {
        BufferedImage img = null;
        try {
            img = ImageIO.read(getClass().getResource("/images/anonymous.png"));
            //ImageIO.read(new File(userAccount.getEmployee().getPhotoLink()));//
        } catch (IOException e) {
            e.printStackTrace();
        }
        Image dimg = img.getScaledInstance(100, 100, Image.SCALE_SMOOTH);
        icon.setImage(dimg);
        accordion.setMultiplySelectionAllowed(false);
        boolean flagArr[] = new boolean[uaList.size()];
        int i = 0;
        for (UserAccount patientUserAccount : uaList) {
            flagArr[i] = false;
            JPanel pl = panelCreation(patientUserAccount, flagArr, i);
            accordion.addPane(icon, patientUserAccount.getEmployee().toString(), createCustomForContent(pl));
            i++;
        }
    }

    public JPanel panelCreation(UserAccount pUA, boolean[] flagArr, int pos) {
        JPanel panel = new JPanel(new ComponentPanelLayout());
        JLabel label1 = new JLabel();
        JLabel label2 = new JLabel();
        JLabel label3 = new JLabel();

        WebButton btnConsultation = new WebButton();
        btnConsultation.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                int result = WebOptionPane.showConfirmDialog(null, "Do you agree to Privacy rights", "Confirm", WebOptionPane.YES_NO_OPTION,
                        WebOptionPane.QUESTION_MESSAGE);
                if (result == WebOptionPane.YES_OPTION) {
                    flagArr[pos] = true;
                    WorkQueue wq = getDoctorWorkQueue();
                        for (WorkRequest wr : wq.getWorkRequestList()) {
                            if (wr.getSender().equals(pUA)) {
                                wr.setReceiver(doctorUserAccount);
                            }
                        }
                   // System.err.println(flagArr[pos]);
                }
            }
        });
        btnConsultation.setText("Consulation Privacy");
        btnConsultation.setPreferredSize(76, 20);
        WebButton btnVitalSigns = new WebButton();

        btnVitalSigns.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                if (!flagArr[pos]) {
                    WebOptionPane.showMessageDialog(null, "Please accept the terms and condtions before proceeding");
                    return;
                }
                VitalSignsJPanel vitalSignsJPanel = new VitalSignsJPanel(userProcessContainer, pUA.getPatient(), pUA.getEmployee().getName());
                userProcessContainer.add("vitalSignsJPanel", vitalSignsJPanel);
                CardLayout layout = (CardLayout) userProcessContainer.getLayout();
                layout.next(userProcessContainer);
            }
        });
        btnVitalSigns.setText("Vital Signs");
        btnVitalSigns.setPreferredSize(76, 20);
        WebButton btnActivities = new WebButton();
        btnActivities.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                if (!flagArr[pos]) {
                    WebOptionPane.showMessageDialog(null, "Please accept the terms and condtions before proceeding");
                    return;
                }
                ActivitiesJPanel activitiesJPanel = new ActivitiesJPanel(userProcessContainer, doctorUserAccount,pUA, getDoctorWorkQueue());
                userProcessContainer.add("activitiesJPanel", activitiesJPanel);
                CardLayout layout = (CardLayout) userProcessContainer.getLayout();
                layout.next(userProcessContainer);
            }
        });
        btnActivities.setText("Activities List");
        btnActivities.setPreferredSize(76, 20);
        WebButton btnConsult = new WebButton();
        btnConsult.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                if (!flagArr[pos]) {
                    WebOptionPane.showMessageDialog(null, "Please accept the terms and condtions before proceeding");
                    return;
                }
                ConsultJPanel consultJPanel = new ConsultJPanel(userProcessContainer, doctorUserAccount,pUA, getDoctorWorkQueue());
                userProcessContainer.add("consultJPanel", consultJPanel);
                CardLayout layout = (CardLayout) userProcessContainer.getLayout();
                layout.next(userProcessContainer);
            }
        });
        btnConsult.setText("Consult");
        btnConsult.setPreferredSize(76, 20);
        label1.setText("<html><b>Name: </b>" + pUA.getEmployee().getName()+"</html>");
        label2.setText("<html><b>Weight: </b>" + pUA.getEmployee().getWeight()+"</html>");
        label3.setText("<html><b>Height: </b>" + pUA.getEmployee().getHeight()+"</html>");
        panel.add(label1);
        panel.add(label2);
        panel.add(label3);
        panel.add(btnConsultation);
        panel.add(btnVitalSigns);
        panel.add(btnActivities);
        panel.add(btnConsult);
        return panel;
    }
    
    public WorkQueue getDoctorWorkQueue(){
        WorkQueue wq = null;
         Organization org = null;
                    for (Organization organization : enterprise.getOrganizationDirectory().getOrganizationList()) {
                        if (organization instanceof DoctorOrganization) {
                            org = organization;
                            break;
                        }
                    }
                    if (org != null) {
                        wq=org.getWorkQueue();
                    }
        return wq;
    }

    public WebScrollPane createCustomForContent(JPanel panel) {
        return createCustomContent(150, 150, panel);
    }

    public WebScrollPane createCustomContent(final int w, final int h, JPanel panel) {

        final WebScrollPane scrollPane = new WebScrollPane(panel, true);
        scrollPane.setPreferredSize(new Dimension(w, h));
        return scrollPane;
    }

    public ArrayList patientList() {
        for (Organization org : enterprise.getOrganizationDirectory().getOrganizationList()) {
            if (org instanceof AppUsersOrganization) {
                return org.getUserAccountDirectory().getUserAccountList();
            }
        }
        return null;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane2 = new javax.swing.JScrollPane();
        jPanel1 = new javax.swing.JPanel();
        webAccordion1 = new com.alee.extended.panel.WebAccordion();
        backJButton = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setPreferredSize(new java.awt.Dimension(1025, 682));

        jScrollPane2.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        jScrollPane2.setPreferredSize(new java.awt.Dimension(405, 527));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(webAccordion1, javax.swing.GroupLayout.PREFERRED_SIZE, 400, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(webAccordion1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jScrollPane2.setViewportView(jPanel1);

        backJButton.setText("<< Back");
        backJButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backJButtonActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel1.setText("My Clientele");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(300, 300, 300)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 421, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(backJButton))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(447, 447, 447)
                        .addComponent(jLabel1)))
                .addGap(304, 304, 304))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(70, 70, 70)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 477, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(60, 60, 60)
                .addComponent(backJButton)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void backJButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backJButtonActionPerformed
        userProcessContainer.remove(this);
        CardLayout layout = (CardLayout) userProcessContainer.getLayout();
        layout.previous(userProcessContainer);
    }//GEN-LAST:event_backJButtonActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton backJButton;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane2;
    private com.alee.extended.panel.WebAccordion webAccordion1;
    // End of variables declaration//GEN-END:variables
}
