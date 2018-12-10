package lecture6;

import lecture6.executors.restAssured.RestAssuredExecutor;
import lecture6.gitHub.GitHub;

public class GitHubApplication {

    public static void main(String[] args) {
        GitHub gitHub = new GitHub(new RestAssuredExecutor());
        gitHub.invite("shakezila");
        gitHub.getCollaborators().forEach(System.out::println);
    }
}
