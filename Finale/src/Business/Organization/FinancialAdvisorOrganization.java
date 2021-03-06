/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Organization;

import Business.Profile.FinancialAdvisorProfile;
import Business.Profile.Profile;
import java.util.ArrayList;

/**
 *
 * @author Zak
 */
public class FinancialAdvisorOrganization extends Organization {
    public FinancialAdvisorOrganization() {
        super(Organization.Type.FinancialAdvisor.getValue());
    }
    
    @Override
    public ArrayList<Profile> getSupportedProfile() {
        ArrayList<Profile> profiles = new ArrayList<>();
        profiles.add(new FinancialAdvisorProfile());
        return profiles;
    }
}
