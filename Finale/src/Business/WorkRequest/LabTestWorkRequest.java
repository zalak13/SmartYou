/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.WorkRequest;

import Business.Patient.Patient;

/**
 *
 * @author Zak
 */
public class LabTestWorkRequest extends WorkRequest{
    private String testResult;
    private Patient patient;

    public LabTestWorkRequest() {
        //userAccount = new UserAccount();
    }
    
    public String getTestResult() {
        return testResult;
    }

    public void setTestResult(String testResult) {
        this.testResult = testResult;
    }

    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }

}
