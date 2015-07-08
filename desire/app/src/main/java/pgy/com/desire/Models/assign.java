package pgy.com.desire.Models;

import java.io.Serializable;
import java.sql.Date;

/**
 * Created by pengguangyu on 2015/7/2.
 */
public class assign implements Serializable {

    public static final String ID = "proId";
    public static final String NAME = "projectName";
    public static final String NUMBER = "assignNumber";
    public static final String PROCESS = "currentProcess";
    public static final String DEADLINE = "deadline";

    private int proId;
    private String projectName;
    private int assignNumber;
    private int currentProcess;
    private Date deadline;

    public int getProId() {
        return proId;
    }

    public void setProId(int proId) {
        this.proId = proId;
    }

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public int getAssignNumber() {
        return assignNumber;
    }

    public void setAssignNumber(int assignNumber) {
        this.assignNumber = assignNumber;
    }

    public int getCurrentProcess() {
        return currentProcess;
    }

    public void setCurrentProcess(int currentProcess) {
        this.currentProcess = currentProcess;
    }

    public Date getDeadline() {
        return deadline;
    }

    public void setDeadline(Date deadline) {
        this.deadline = deadline;
    }
}
