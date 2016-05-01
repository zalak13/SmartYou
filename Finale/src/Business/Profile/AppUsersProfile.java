/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Profile;

import Business.Appliances.ApplianceDirectory;
import Business.EcoSystem;
import Business.Enterprise.Enterprise;
import Business.Organization.Organization;
import Business.UserAccount.UserAccount;
import UserInterface.AppUsersProfile.AppUsersWorkAreaJPanel;
import UserInterface.AppUsersProfile.NewAppUsersWorkAreaJPanel;
import java.awt.Graphics;
import javax.swing.JPanel;

/**
 *
 * @author Zak
 */
public class AppUsersProfile extends Profile{
    private HealthProfile healthProfile;
    private FinanceProfile financeProfile;
    private HomeMakerProfile homeMakerProfile;
    private ApplianceDirectory applianceList;
    
    public AppUsersProfile() {
        healthProfile = new HealthProfile();
        financeProfile = new FinanceProfile();
        homeMakerProfile = new HomeMakerProfile();
        applianceList = new ApplianceDirectory();
    }
 
    
    @Override
    public JPanel createWorkArea(JPanel userProcessContainer, UserAccount account, Organization organization, Enterprise enterprise, EcoSystem business) {
            if(account==null){
           return new NewAppUsersWorkAreaJPanel(userProcessContainer, business,enterprise);
            }
            return new AppUsersWorkAreaJPanel(userProcessContainer, business,account,enterprise);
    }

    @Override
    public Profile CreateProfile() {
        AppUsersProfile aup = new AppUsersProfile();
        return aup; //To change body of generated methods, choose Tools | Templates.
    }
    
}
