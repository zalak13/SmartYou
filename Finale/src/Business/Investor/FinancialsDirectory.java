/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Investor;

import java.util.ArrayList;

/**
 *
 * @author Zak
 */
public class FinancialsDirectory {
    private ArrayList<Financials> financialsList;

    public FinancialsDirectory() {
        financialsList = new ArrayList<Financials>();
    }
    
    public ArrayList<Financials> getFinancialsList() {
        return financialsList;
    }

    public void setFinancialsList(ArrayList<Financials> financialsList) {
        this.financialsList = financialsList;
    }
    
    public Financials addFinancials() {
        Financials objFinancials = new Financials();
        financialsList.add(objFinancials);
        return objFinancials;
    }

    public void deleteFinancials(Financials financials) {
        financialsList.remove(financials);
    }   
}
