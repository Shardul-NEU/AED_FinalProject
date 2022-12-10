/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

/**
 *
 * @author Shardul
 */
public class Security {
    private String court_ID;
    private String courtname;
    private String status;
    private String currentHeadCount;
    private String totalIns;
    private String totalOuts;

    public String getCourt_ID() {
        return court_ID;
    }

    public void setCourt_ID(String court_ID) {
        this.court_ID = court_ID;
    }

    public String getCourtname() {
        return courtname;
    }

    public void setCourtname(String courtname) {
        this.courtname = courtname;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getCurrentHeadCount() {
        return currentHeadCount;
    }

    public void setCurrentHeadCount(String currentHeadCount) {
        this.currentHeadCount = currentHeadCount;
    }

    public String getTotalIns() {
        return totalIns;
    }

    public void setTotalIns(String totalIns) {
        this.totalIns = totalIns;
    }

    public String getTotalOuts() {
        return totalOuts;
    }

    public void setTotalOuts(String totalOuts) {
        this.totalOuts = totalOuts;
    }
}

