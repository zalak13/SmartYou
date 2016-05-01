/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Appliances;

import java.util.ArrayList;

/**
 *
 * @author Zak
 */
public class ApplianceDirectory {
    private ArrayList<Appliance> applianceList;

    public ApplianceDirectory() {
        applianceList = new ArrayList<Appliance>();
    }
    
    public ArrayList<Appliance> getApplianceList() {
        return applianceList;
    }

    public void setApplianceList(ArrayList<Appliance> applianceList) {
        this.applianceList = applianceList;
    }
    
    public Appliance addAppliance() {
        Appliance objAppliance = new Appliance();
        applianceList.add(objAppliance);
        return objAppliance;
    }

    public void deleteAppliance(Appliance appliance) {
        applianceList.remove(appliance);
    }   
}
