/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.UserAccount;

import Business.Appliances.ApplianceDirectory;
import Business.Employee.Employee;
import Business.Investor.Investor;
import Business.Patient.Patient;
import Business.Profile.Profile;
import Business.WorkRequest.WorkQueue;

/**
 *
 * @author Zak
 */
public class UserAccount {

    private String username;
    private String password;
    private Employee employee;
    private Profile profile;
    private WorkQueue workQueue;
    private ApplianceDirectory applianceDirectory;
    private Patient patient;
    private Investor investor;
   
    public UserAccount() {
        workQueue = new WorkQueue();
        applianceDirectory = new ApplianceDirectory();
        patient = new Patient();
        investor = new Investor();
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public Employee getEmployee() {
        return employee;
    }

    public Profile getProfile() {
        return profile;
    }

    public void setProfile(Profile profile) {
        this.profile = profile;
    }

    public WorkQueue getWorkQueue() {
        return workQueue;
    }

    public ApplianceDirectory getApplianceDirectory() {
        return applianceDirectory;
    }

    public void setApplianceDirectory(ApplianceDirectory applianceDirectory) {
        this.applianceDirectory = applianceDirectory;
    }

    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }

    public Investor getInvestor() {
        return investor;
    }

    public void setInvestor(Investor investor) {
        this.investor = investor;
    }

    @Override
    public String toString() {
        return username;
    }
}
