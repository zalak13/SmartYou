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
import javax.swing.JPanel;

/**
 *
 * @author Zak
 */
public abstract class Profile {
      public enum ProfileType{
        Admin("Admin"),
        AppUsersProfile("Application Users Profile"),
        BankerProfile("Banker Profile"),
        DoctorProfile("Doctor Profile"),
        HealthProfile("Health Profile"),
        FinanceProfile("Finance Profile"),
        HomeMakerProfile("Home Maker Profile");
        
        private String value;
        private ProfileType(String value){
            this.value = value;
        }

        public String getValue() {
            return value;
        }

        @Override
        public String toString() {
            return value;
        }
    }
    
    public abstract JPanel createWorkArea(JPanel userProcessContainer, 
            UserAccount account, 
            Organization organization, 
            Enterprise enterprise, 
            EcoSystem business);
    
    public Profile CreateProfile(){
        return null;
    }
 
    @Override
    public String toString() {
        return this.getClass().getName();
    }
}
