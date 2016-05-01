/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.WorkRequest;

import java.util.Date;

/**
 *
 * @author Zak
 */
public class TransactionWorkRequest extends WorkRequest{
   private String transactionID;
    private Float debitAmount;
    private Float creditAmount;
    private Double creditBilling;
    private Date txnTimeStamp;
    
    public TransactionWorkRequest() {
    }

    public String getTransactionID() {
        return transactionID;
    }

    public void setTransactionID(String transactionID) {
        this.transactionID = transactionID;
    }

    public Float getDebitAmount() {
        return debitAmount;
    }

    public void setDebitAmount(Float debitAmount) {
        this.debitAmount = debitAmount;
    }

    public Float getCreditAmount() {
        return creditAmount;
    }

    public void setCreditAmount(Float creditAmount) {
        this.creditAmount = creditAmount;
    }

    public Date getTxnTimeStamp() {
        return txnTimeStamp;
    }

    public void setTxnTimeStamp(Date txnTimeStamp) {
        this.txnTimeStamp = txnTimeStamp;
    }

    public Double getCreditBilling() {
        return creditBilling;
    }

    public void setCreditBilling(Double creditBilling) {
        this.creditBilling = creditBilling;
    }

}
