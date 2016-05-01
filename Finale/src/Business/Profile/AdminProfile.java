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
import UserInterface.AdministrativeProfile.AdminWorkAreaJPanel;
import javax.swing.JPanel;

/**
 *
 * @author Zak
 */
public class AdminProfile extends Profile{

    @Override
    public JPanel createWorkArea(JPanel userProcessContainer, UserAccount account, Organization organization, Enterprise enterprise, EcoSystem business) {
           return new AdminWorkAreaJPanel(userProcessContainer, enterprise);
    }

}
