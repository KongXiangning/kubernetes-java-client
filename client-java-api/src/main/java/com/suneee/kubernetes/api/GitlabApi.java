package com.suneee.kubernetes.api;

import com.google.gson.reflect.TypeToken;
import com.suneee.kubernetes.ApiResponse;
import com.suneee.kubernetes.common.ApiCommon;
import com.suneee.kubernetes.http.ApiClient;
import com.suneee.kubernetes.http.ApiException;
import com.suneee.kubernetes.http.GitlabClient;
import com.suneee.kubernetes.model.gitlab.Project;
import com.suneee.kubernetes.model.gitlab.ProjectLog;
import com.suneee.kubernetes.model.jenkins.JenkinsState;
import okhttp3.Call;

import java.lang.reflect.Type;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GitlabApi {

    private ApiClient apiClient;
    private ApiCommon apiCommon;

    public GitlabApi(){
        apiClient = GitlabClient.getApiClient();
        apiCommon = new ApiCommon(apiClient);
    }

    public String getProjectId(String name,String path)throws ApiException{
        if (name == null || name.isEmpty()) {
            throw new ApiException("Missing the required parameter 'name'");
        }
        if (path == null || path.isEmpty()){
            throw new ApiException("Missing the required parameter 'path'");
        }

        String localVarPath = "/api/v4/projects?search={name}"
                .replaceAll("\\{" + "name" + "\\}", apiClient.escapeString(name));

        Call call = apiCommon.getCallGetFormData(localVarPath);
        Type localVarReturnType = new TypeToken<List<Project>>(){}.getType();
        ApiResponse<List<Project>> resp = apiClient.execute(call,localVarReturnType);
        List<Project> list = resp.getData();
        for (Project project : list) {
            if (project.getPathWithNamespace().equals(path)){
                return project.getId();
            }
        }
        return null;
    }

    public ProjectLog getProjectLog(String id,String branch)throws ApiException{
        if (id == null || id.isEmpty()) {
            throw new ApiException("Missing the required parameter 'id'");
        }
        if (branch == null || branch.isEmpty()){
            throw new ApiException("Missing the required parameter 'branch'");
        }

        String localVarPath = "/api/v4/projects/{id}/repository/branches/{branch}"
                .replaceAll("\\{" + "id" + "\\}", apiClient.escapeString(id))
                .replaceAll("\\{" + "branch" + "\\}", apiClient.escapeString(branch));

        Call call = apiCommon.getCallGetFormData(localVarPath);
        Type localVarReturnType = new TypeToken<ProjectLog>(){}.getType();
        ApiResponse<ProjectLog> resp = apiClient.execute(call,localVarReturnType);
        return resp.getData();
    }

    public void tagProject(String id,String refId,String tagName,String message,String releaseDescription)throws ApiException{
        if (id == null || id.isEmpty()) {
            throw new ApiException("Missing the required parameter 'id'");
        }
        if (refId == null || refId.isEmpty()){
            throw new ApiException("Missing the required parameter 'refId'");
        }
        if (tagName == null || tagName.isEmpty()){
            throw new ApiException("Missing the required parameter 'tagName'");
        }

        Map<String, Object> formParams = new HashMap<>();
        formParams.put("tag_name",tagName);
        formParams.put("ref",refId);
        if (message != null && !message.isEmpty()){
            formParams.put("message",message);
        }
        if (releaseDescription != null && !releaseDescription.isEmpty()){
            formParams.put("release_description",releaseDescription);
        }

        String localVarPath = "/api/v4/projects/{id}/repository/tags"
                .replaceAll("\\{" + "id" + "\\}", apiClient.escapeString(id));

        Call call = apiCommon.getCallPostFormData(localVarPath,formParams);
        apiClient.execute(call,null);
    }
}
