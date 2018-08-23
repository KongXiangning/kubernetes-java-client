package com.suneee.kubernetes.model.gitlab;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class ProjectLog implements Serializable {

    @SerializedName("name")
    private String name;
    @SerializedName("commit")
    private ProjectCommit commit;
    @SerializedName("merged")
    private boolean merged;
    @SerializedName("protected")
    private boolean protecteds;
    @SerializedName("developers_can_push")
    private boolean developersCanPush;
    @SerializedName("developers_can_merge")
    private boolean developersCanMerge;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ProjectCommit getCommit() {
        return commit;
    }

    public void setCommit(ProjectCommit commit) {
        this.commit = commit;
    }

    public boolean isMerged() {
        return merged;
    }

    public void setMerged(boolean merged) {
        this.merged = merged;
    }

    public boolean isProtecteds() {
        return protecteds;
    }

    public void setProtecteds(boolean protecteds) {
        this.protecteds = protecteds;
    }

    public boolean isDevelopersCanPush() {
        return developersCanPush;
    }

    public void setDevelopersCanPush(boolean developersCanPush) {
        this.developersCanPush = developersCanPush;
    }

    public boolean isDevelopersCanMerge() {
        return developersCanMerge;
    }

    public void setDevelopersCanMerge(boolean developersCanMerge) {
        this.developersCanMerge = developersCanMerge;
    }
}
