/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.WorkRequest;

import Business.Patient.VitalSign;

/**
 *
 * @author Zak
 */
public class ConsultingWorkRequest extends WorkRequest{
    private String consultingDescription;
    private String patientResponse;
    
    public ConsultingWorkRequest() {
    }

    public String getConsultingDescription() {
        return consultingDescription;
    }

    public void setConsultingDescription(String consultingDescription) {
        this.consultingDescription = consultingDescription;
    }

    public String getPatientResponse() {
        return patientResponse;
    }

    public void setPatientResponse(String patientResponse) {
        this.patientResponse = patientResponse;
    }
    
    
}
