/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UserInterface.FinancialAdvisorProfile;

import Business.Enterprise.Enterprise;
import Business.Organization.AppUsersOrganization;
import Business.Organization.FinancialAdvisorOrganization;
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
public class ClienteleDetailsJPanel extends javax.swing.JPanel {

    private JPanel userProcessContainer;
    private UserAccount financialAdvisorUserAccount;
    private Enterprise enterprise;
    
    private ArrayList<UserAccount> uaList;
    private ImageIcon icon = null;
    private WebAccordion accordion = null;

    /**
     * Creates new form ConsultationJPanel
     */
    public ClienteleDetailsJPanel(JPanel upc, UserAccount acc, Enterprise e) {
        initComponents();
        userProcessContainer = upc;
        financialAdvisorUserAccount = acc;
        enterprise = e;
        uaList = investorList();
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
        for (UserAccount investorUserAccount : uaList) {
            flagArr[i] = false;
            JPanel pl = panelCreation(investorUserAccount, flagArr, i);
            accordion.addPane(icon, investorUserAccount.getEmployee().toString(), createCustomForContent(pl));
            i++;
        }
    }

    public JPanel panelCreation(UserAccount iUA, boolean[] flagArr, int pos) {
        JPanel panel = new JPanel(new ComponentPanelLayout());
        JLabel label1 = new JLabel();

        WebButton btnConsultation = new WebButton();
        btnConsultation.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                int result = WebOptionPane.showConfirmDialog(null, "Do you agree to Users Privacy Policy", "Confirm", WebOptionPane.YES_NO_OPTION,
                        WebOptionPane.QUESTION_MESSAGE);
                if (result == WebOptionPane.YES_OPTION) {
                    flagArr[pos] = true;
                    WorkQueue wq = getFinancialAdvisorWorkQueue();
                        for (WorkRequest wr : wq.getWorkRequestList()) {
                            if (wr.getSender().equals(iUA)) {
                                wr.setReceiver(financialAdvisorUserAccount);
                            }
                        }
                   // System.err.println(flagArr[pos]);
                }
            }
        });
        btnConsultation.setText("User Privacy Policy");
        btnConsultation.setPreferredSize(76, 20);
        WebButton btnActivities = new WebButton();
        btnActivities.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                if (!flagArr[pos]) {
                    WebOptionPane.showMessageDialog(null, "Please accept the terms and condtions before proceeding");
                    return;
                }
                FinancialActivitiesJPanel financialActivitiesJPanel = new FinancialActivitiesJPanel(userProcessContainer, financialAdvisorUserAccount,iUA, getFinancialAdvisorWorkQueue());
                userProcessContainer.add("financialActivitiesJPanel", financialActivitiesJPanel);
                CardLayout layout = (CardLayout) userProcessContainer.getLayout();
                layout.next(userProcessContainer);
            }
        });
        btnActivities.setText("Activities List");
        btnActivities.setPreferredSize(76, 20);
        WebButton btnAdvice = new WebButton();
        btnAdvice.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                if (!flagArr[pos]) {
                    WebOptionPane.showMessageDialog(null, "Please accept the terms and condtions before proceeding");
                    return;
                }
                AdviceJPanel adviceJPanel = new AdviceJPanel(userProcessContainer, financialAdvisorUserAccount,iUA, getFinancialAdvisorWorkQueue());
                userProcessContainer.add("adviceJPanel", adviceJPanel);
                CardLayout layout = (CardLayout) userProcessContainer.getLayout();
                layout.next(userProcessContainer);
            }
        });
        btnAdvice.setText("Financial Advice");
        btnAdvice.setPreferredSize(76, 20);
        label1.setText("<html><b>Name: </b>" + iUA.getEmployee().getName()+"</html>");
        panel.add(label1);
        panel.add(btnConsultation);
        panel.add(btnActivities);
        panel.add(btnAdvice);
        return panel;
    }
    
    public WorkQueue getFinancialAdvisorWorkQueue(){
        WorkQueue wq = null;
         Organization org = null;
                    for (Organization organization : enterprise.getOrganizationDirectory().getOrganizationList()) {
                        if (organization instanceof FinancialAdvisorOrganization) {
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
        return createCustomContent(150, 100, panel);
    }

    public WebScrollPane createCustomContent(final int w, final int h, JPanel panel) {

        final WebScrollPane scrollPane = new WebScrollPane(panel, true);
        scrollPane.setPreferredSize(new Dimension(w, h));
        return scrollPane;
    }

    public ArrayList investorList() {
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
        jLabel1 = new javax.swing.JLabel();
        backJButton = new javax.swing.JButton();

        setPreferredSize(new java.awt.Dimension(1025, 682));

        jScrollPane2.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        jScrollPane2.setPreferredSize(new java.awt.Dimension(500, 527));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(webAccordion1, javax.swing.GroupLayout.PREFERRED_SIZE, 400, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(67, 67, 67))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(webAccordion1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        jScrollPane2.setViewportView(jPanel1);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel1.setText("My Clientele");

        backJButton.setText("<<Back");
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
                        .addGap(300, 300, 300)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 420, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(backJButton))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(448, 448, 448)
                        .addComponent(jLabel1)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(80, 80, 80)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 366, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(120, 120, 120)
                .addComponent(backJButton)
                .addGap(41, 41, 41))
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
