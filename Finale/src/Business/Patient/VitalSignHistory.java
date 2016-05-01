/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Patient;

import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author Zak
 */
public class VitalSignHistory {

    private ArrayList<VitalSign> vitalSignList;

    public VitalSignHistory() {
        vitalSignList = new ArrayList<VitalSign>();
    }

    public ArrayList<VitalSign> getVitalSignList() {
        return vitalSignList;
    }

    public void setVitalSignList(ArrayList<VitalSign> vitalSignList) {
        this.vitalSignList = vitalSignList;
    }

    public VitalSign addVitalSign() {
        VitalSign objVitalSign = new VitalSign();
        vitalSignList.add(objVitalSign);
        return objVitalSign;
    }

    public VitalSign addVitalSign(float respiratoryRate, float heartRate,float bloodPressure, float temperature) {
        VitalSign objVitalSign = new VitalSign();
        objVitalSign.setRespiratoryRate(respiratoryRate);
        objVitalSign.setHeartRate(heartRate);
        objVitalSign.setBloodPressure(bloodPressure);
        objVitalSign.setTemperature(temperature);
        objVitalSign.setTimestamp(new Date());
        vitalSignList.add(objVitalSign);
        return objVitalSign;
    }
    
    public void deleteVitalSign(VitalSign vitalSign) {
        vitalSignList.remove(vitalSign);
    }
}
