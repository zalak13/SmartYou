/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Profile;

import Business.EcoSystem;
import Business.Enterprise.Enterprise;
import Business.Organization.Organization;
import Business.UserAccount.UserAccount;
import UserInterface.FinancialAdvisorProfile.FinancialAdvisorWorkAreaJPanel;
import javax.swing.JPanel;

/**
 *
 * @author Zak
 */
public class FinancialAdvisorProfile extends Profile{
    
    @Override
    public JPanel createWorkArea(JPanel userProcessContainer, UserAccount account, Organization organization, Enterprise enterprise, EcoSystem business) {
        return new FinancialAdvisorWorkAreaJPanel(userProcessContainer,account,organization,enterprise,business);
           //return new BankerWorkAreaJPanel(userProcessContainer, business);
    }
    
    @Override
    public Profile CreateProfile() {
        FinancialAdvisorProfile fap = new FinancialAdvisorProfile();
        return fap; //To change body of generated methods, choose Tools | Templates.
    }
}
