package lecture6.gitHub.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import lecture6.constant.GitHubApiConstants;
import lecture6.constant.RequestType;
import lecture6.executors.IRequestExecutor;
import lecture6.helper.ParseHelper;
import lecture6.model.GitHubUser;

public class GitHubController {

    private final Map<String, String> params = new HashMap<>();
    private IRequestExecutor requestExecutor;

    public GitHubController(IRequestExecutor requestExecutor, String name, String value) {
        this.requestExecutor = requestExecutor;
        params.put(name, value);
    }

    public void sendCollaboratorInvite(String name) {
        requestExecutor.doRequest(GitHubApiConstants.BASE_URL + GitHubApiConstants.URL_COLLABORATOR + "/" + name, RequestType.PUT, params);
    }

    public List<GitHubUser> getContributors() {
        return ParseHelper.parse(requestExecutor.doRequest(GitHubApiConstants.BASE_URL + GitHubApiConstants.URL_COLLABORATOR, RequestType.GET, params),
                                 GitHubUser.class);
    }
}
