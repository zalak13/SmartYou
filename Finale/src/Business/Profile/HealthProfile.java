/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Profile;

import Business.EcoSystem;
import Business.Enterprise.Enterprise;
import Business.Organization.Organization;
import Business.Patient.Patient;
import Business.UserAccount.UserAccount;
import UserInterface.AppUsersProfile.Setup.HealthWorkAreaJPanel;
import javax.swing.JPanel;

/**
 *
 * @author Zak
 */
public class HealthProfile extends Profile{
    public HealthProfile() {
    }
   
    
    @Override
    public JPanel createWorkArea(JPanel userProcessContainer, UserAccount account, Organization organization, Enterprise enterprise, EcoSystem business) {
           return new HealthWorkAreaJPanel(userProcessContainer, account,business);
    }
    
}
