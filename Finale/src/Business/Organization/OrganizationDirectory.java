/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Organization;

import java.util.ArrayList;

/**
 *
 * @author Zak
 */
public class OrganizationDirectory {

    private ArrayList<Organization> organizationList;

    public OrganizationDirectory() {
        organizationList = new ArrayList<>();
    }

    public ArrayList<Organization> getOrganizationList() {
        return organizationList;
    }

    public Organization createOrganization(Organization.Type type) {
        Organization organization = null;
        if (type.getValue().equals(Organization.Type.AppUsers.getValue())) {
            organization = new AppUsersOrganization();
            organizationList.add(organization);
        } else if (type.getValue().equals(Organization.Type.Doctor.getValue())) {
            organization = new DoctorOrganization();
            organizationList.add(organization);
        } else if (type.getValue().equals(Organization.Type.FinancialAdvisor.getValue())) {
            organization = new FinancialAdvisorOrganization();
            organizationList.add(organization);
        }
        return organization;
    }
    
    public Organization searchOrganization(Organization.Type type) {
        for (Organization organization : organizationList) {
            if(organization.getName().equals(type.getValue()) ){
                return organization;
            }
        }
        return null;
    }
}

