package com.suneee.kubernetes.model.jenkins;

import java.util.Map;

public class JenkinsBuild {

    private String jobName;
    private String jobNumber;
    private Map<String, Object> formParams;

    public String getJobName() {
        return jobName;
    }

    public void setJobName(String jobName) {
        this.jobName = jobName;
    }

    public String getJobNumber() {
        return jobNumber;
    }

    public void setJobNumber(String jobNumber) {
        this.jobNumber = jobNumber;
    }

    public Map<String, Object> getFormParams() {
        return formParams;
    }

    public void setFormParams(Map<String, Object> formParams) {
        this.formParams = formParams;
    }
}
