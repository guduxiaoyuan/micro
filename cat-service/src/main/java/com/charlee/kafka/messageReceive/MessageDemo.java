package com.charlee.kafka.messageReceive;

import java.util.Date;

/**
 * Created by zhaohy on 2019/6/26.
 */
public class MessageDemo implements java.io.Serializable{

    private String eType;

    private String execution_start;

    private String wfId;

    private String exId;

    private String taskId;

    private String taskName;

    private String atomId;

    private String status;

    private Object input;

    private Object output;

    private Date timeStamp;

    public String geteType() {
        return eType;
    }

    public void seteType(String eType) {
        this.eType = eType;
    }

    public String getExecution_start() {
        return execution_start;
    }

    public void setExecution_start(String execution_start) {
        this.execution_start = execution_start;
    }

    public String getWfId() {
        return wfId;
    }

    public void setWfId(String wfId) {
        this.wfId = wfId;
    }

    public String getExId() {
        return exId;
    }

    public void setExId(String exId) {
        this.exId = exId;
    }

    public String getTaskId() {
        return taskId;
    }

    public void setTaskId(String taskId) {
        this.taskId = taskId;
    }

    public String getTaskName() {
        return taskName;
    }

    public void setTaskName(String taskName) {
        this.taskName = taskName;
    }

    public String getAtomId() {
        return atomId;
    }

    public void setAtomId(String atomId) {
        this.atomId = atomId;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Object getInput() {
        return input;
    }

    public void setInput(Object input) {
        this.input = input;
    }

    public Object getOutput() {
        return output;
    }

    public void setOutput(Object output) {
        this.output = output;
    }

    public Date getTimeStamp() {
        return timeStamp;
    }

    public void setTimeStamp(Date timeStamp) {
        this.timeStamp = timeStamp;
    }
}
