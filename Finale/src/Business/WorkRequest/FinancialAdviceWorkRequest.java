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
public class FinancialAdviceWorkRequest extends WorkRequest{
    private String adviceDescription;
    private String investorResponse;
    
    public FinancialAdviceWorkRequest() {
    }

    public String getAdviceDescription() {
        return adviceDescription;
    }

    public void setAdviceDescription(String adviceDescription) {
        this.adviceDescription = adviceDescription;
    }

    public String getInvestorResponse() {
        return investorResponse;
    }

    public void setInvestorResponse(String investorResponse) {
        this.investorResponse = investorResponse;
    }
    
    
}
