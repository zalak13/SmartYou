/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Appliances;

import Business.Patient.VitalSign;
import java.util.Date;

/**
 *
 * @author Zak
 */
public class Appliance {

    
    private String applianceName;
    private String status;
    private boolean IsAutoSync;
    private Date lastSynced;
    private String applianceType;
    private String appInfo;

    public Appliance() {
    
    }

    
    public String getApplianceName() {
        return applianceName;
    }

    public void setApplianceName(String applianceName) {
        this.applianceName = applianceName;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public boolean isAutoSync() {
        return IsAutoSync;
    }

    public void setAutoSync(boolean IsAutoSync) {
        this.IsAutoSync = IsAutoSync;
    }

    public Date getLastSynced() {
        return lastSynced;
    }

    public void setLastSynced(Date lastSynced) {
        this.lastSynced = lastSynced;
    }

    public String getApplianceType() {
        return applianceType;
    }

    public void setApplianceType(String ApplianceType) {
        this.applianceType = ApplianceType;
    }
    
    public String getAppInfo() {
        return appInfo;
    }

    public void setAppInfo(String appInfo) {
        this.appInfo = appInfo;
    }

    @Override
    public String toString() {
        return applianceName; //To change body of generated methods, choose Tools | Templates.
    }
}
