package com.suneee.kubernetes.model.gitlab;

import com.google.gson.annotations.SerializedName;
import org.joda.time.DateTime;

import java.io.Serializable;

public class ProjectCommit implements Serializable {

    @SerializedName("id")
    private String id;
    @SerializedName("short_id")
    private String shortId;
    @SerializedName("title")
    private String title;
    @SerializedName("created_at")
    private DateTime createdAt;
    @SerializedName("message")
    private String message;
    @SerializedName("author_name")
    private String authorName;
    @SerializedName("author_email")
    private String authorEmail;
    @SerializedName("authored_date")
    private DateTime authoredDate;
    @SerializedName("committer_name")
    private String committerName;
    @SerializedName("committer_email")
    private String committerEmail;
    @SerializedName("committed_date")
    private DateTime committedDate;


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getShortId() {
        return shortId;
    }

    public void setShortId(String shortId) {
        this.shortId = shortId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public DateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(DateTime createdAt) {
        this.createdAt = createdAt;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getAuthorName() {
        return authorName;
    }

    public void setAuthorName(String authorName) {
        this.authorName = authorName;
    }

    public String getAuthorEmail() {
        return authorEmail;
    }

    public void setAuthorEmail(String authorEmail) {
        this.authorEmail = authorEmail;
    }

    public DateTime getAuthoredDate() {
        return authoredDate;
    }

    public void setAuthoredDate(DateTime authoredDate) {
        this.authoredDate = authoredDate;
    }

    public String getCommitterName() {
        return committerName;
    }

    public void setCommitterName(String committerName) {
        this.committerName = committerName;
    }

    public String getCommitterEmail() {
        return committerEmail;
    }

    public void setCommitterEmail(String committerEmail) {
        this.committerEmail = committerEmail;
    }

    public DateTime getCommittedDate() {
        return committedDate;
    }

    public void setCommittedDate(DateTime committedDate) {
        this.committedDate = committedDate;
    }
}
