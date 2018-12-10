package lecture6.gitHub;

import java.util.List;

import lecture6.executors.IRequestExecutor;
import lecture6.gitHub.controller.GitHubController;
import lecture6.model.GitHubUser;

public class GitHub {

    private final String accessToken = "99bf21f4176231db1a2ef8743272957c2465b573";
    private final String tokenParamName = "access_token";
    private GitHubController gitHubController;

    public GitHub(IRequestExecutor executor) {
        gitHubController = new GitHubController(executor, tokenParamName, accessToken);
    }

    public void invite(String name) {
        gitHubController.sendCollaboratorInvite(name);
    }

    public List<GitHubUser> getCollaborators() {
        return gitHubController.getContributors();
    }
}
