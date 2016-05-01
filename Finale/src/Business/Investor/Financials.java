/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Investor;

import java.util.Date;

/**
 *
 * @author Zak
 */
public class Financials {
    private String source;
    private String modeofSource;
    private boolean IsAutoSync;
    private Date lastUpdated;
    
    public Financials(){
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public String getModeofSource() {
        return modeofSource;
    }

    public void setModeofSource(String modeofSource) {
        this.modeofSource = modeofSource;
    }

    public boolean isAutoSync() {
        return IsAutoSync;
    }

    public void setIsAutoSync(boolean IsAutoSync) {
        this.IsAutoSync = IsAutoSync;
    }
    public Date getLastUpdated() {
        return lastUpdated;
    }

    public void setLastUpdated(Date lastUpdated) {
        this.lastUpdated = lastUpdated;
    }

  @Override
    public String toString() {
        return source; //To change body of generated methods, choose Tools | Templates.
    }    

}
