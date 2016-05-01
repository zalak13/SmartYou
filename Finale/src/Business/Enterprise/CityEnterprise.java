/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Enterprise;

import Business.Profile.Profile;
import java.util.ArrayList;

/**
 *
 * @author Zak
 */
public class CityEnterprise extends Enterprise{
    public CityEnterprise(String name) {
        super(name, Enterprise.EnterpriseType.City);
    }

    @Override
    public ArrayList<Profile> getSupportedProfile() {
        return null;
    }    
}
