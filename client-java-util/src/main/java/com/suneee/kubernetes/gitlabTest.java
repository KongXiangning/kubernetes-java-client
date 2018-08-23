package com.suneee.kubernetes;

import com.suneee.kubernetes.api.GitlabApi;
import com.suneee.kubernetes.auth.PrivateToken;
import com.suneee.kubernetes.common.ApiCommon;
import com.suneee.kubernetes.http.ApiException;
import com.suneee.kubernetes.http.GitlabClient;
import com.suneee.kubernetes.model.gitlab.ProjectLog;

public class gitlabTest {

    private static ApiCommon apiCommon;

    final static String ip = "http://git.scn.weilian.cn";

    public static void main(String[] args) {
        GitlabClient apiClient = GitlabClient.getApiClient();
        apiClient.setBasePath(ip);
        PrivateToken privateToken = (PrivateToken) apiClient.getAuthentication("BasicAuth");
        privateToken.setTokenName("Private-Token");
        privateToken.setTokenValue("B_8oATSrQqXe-YZAAZ-7");

        apiCommon = new ApiCommon(apiClient);

        GitlabApi gitlabApi = new GitlabApi();
        try {
            /*String id = gitlabApi.getProjectId("base","test/base");
            System.out.println(id);
            ProjectLog log = gitlabApi.getProjectLog(id,"master");
            System.out.println(log.getCommit().getId());
            System.out.println(log);*/
            gitlabApi.tagProject("303","eb091912b432a028e05b68bc1f097e1b201f54ce","test3","ooo","abc");
        } catch (ApiException e) {
            e.printStackTrace();
        }
    }
}
