package com.suneee.kubernetes.model.gitlab;

import com.google.gson.annotations.SerializedName;

public class Project {

    @SerializedName("id")
    private String id;
    @SerializedName("description")
    private String description;
    @SerializedName("default_branch")
    private String defaultBranch;
    @SerializedName("ssh_url_to_repo")
    private String sshUrlToRepo;
    @SerializedName("http_url_to_repo")
    private String httpUrlToRepo;
    @SerializedName("web_url")
    private String webUrl;

    @SerializedName("name")
    private String name;

    @SerializedName("name_with_namespace")
    private String nameWithNamespace;

    @SerializedName("path")
    private String path;

    @SerializedName("path_with_namespace")
    private String pathWithNamespace;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDefaultBranch() {
        return defaultBranch;
    }

    public void setDefaultBranch(String defaultBranch) {
        this.defaultBranch = defaultBranch;
    }

    public String getSshUrlToRepo() {
        return sshUrlToRepo;
    }

    public void setSshUrlToRepo(String sshUrlToRepo) {
        this.sshUrlToRepo = sshUrlToRepo;
    }

    public String getHttpUrlToRepo() {
        return httpUrlToRepo;
    }

    public void setHttpUrlToRepo(String httpUrlToRepo) {
        this.httpUrlToRepo = httpUrlToRepo;
    }

    public String getWebUrl() {
        return webUrl;
    }

    public void setWebUrl(String webUrl) {
        this.webUrl = webUrl;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNameWithNamespace() {
        return nameWithNamespace;
    }

    public void setNameWithNamespace(String nameWithNamespace) {
        this.nameWithNamespace = nameWithNamespace;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public String getPathWithNamespace() {
        return pathWithNamespace;
    }

    public void setPathWithNamespace(String pathWithNamespace) {
        this.pathWithNamespace = pathWithNamespace;
    }
}
