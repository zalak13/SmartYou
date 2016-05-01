/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Investor;

/**
 *
 * @author Zak
 */
public class Investor {
    private FinancialsDirectory financialsDirectory;
    private String SocialSecurityNumber;
    private String BankAccountNumber;
    private String BankName;
    private double DebitProfile;
    private double CreditProfile;
    
    
    public Investor(){
        financialsDirectory = new FinancialsDirectory();
    }

    public FinancialsDirectory getFinancialsDirectory() {
        return financialsDirectory;
    }

    public void setFinancialsDirectory(FinancialsDirectory financialsDirectory) {
        this.financialsDirectory = financialsDirectory;
    }
    
    public String getSocialSecurityNumber() {
        return SocialSecurityNumber;
    }

    public void setSocialSecurityNumber(String SocialSecurityNumber) {
        this.SocialSecurityNumber = SocialSecurityNumber;
    }

    public String getBankAccountNumber() {
        return BankAccountNumber;
    }

    public void setBankAccountNumber(String BankAccountNumber) {
        this.BankAccountNumber = BankAccountNumber;
    }

    public String getBankName() {
        return BankName;
    }

    public void setBankName(String BankName) {
        this.BankName = BankName;
    }

    public double getDebitProfile() {
        return DebitProfile;
    }

    public void setDebitProfile(double DebitProfile) {
        this.DebitProfile = DebitProfile;
    }

    public double getCreditProfile() {
        return CreditProfile;
    }

    public void setCreditProfile(double CreditProfile) {
        this.CreditProfile = CreditProfile;
    }
    
}
