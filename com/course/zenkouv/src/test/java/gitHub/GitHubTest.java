package gitHub;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import lecture6.constant.GitHubApiConstants;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class GitHubTest {

    private static final String COLLABORATOR_NAME = "Shakezila";

    @BeforeClass
    public void setup() {
        RestAssured.baseURI = GitHubApiConstants.BASE_URL;
    }

    @Test
    public void testCollaborators() {
        Response response = given().auth().oauth2(GitHubApiConstants.ACCESS_TOKEN).get(GitHubApiConstants.URL_COLLABORATOR);
        Assert.assertEquals(response.getStatusCode(), 200);
    }

    @Test
    public void testInviteCollaborators() {
        Response response = given().auth().oauth2(GitHubApiConstants.ACCESS_TOKEN).when().put(GitHubApiConstants.URL_COLLABORATOR + COLLABORATOR_NAME);
        Assert.assertEquals(response.getStatusCode(), 201);
    }

    @AfterClass
    public void dispose() {
        RestAssured.reset();
    }
}
