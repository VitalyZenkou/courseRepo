package lecture6.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class GitHubUser {

    private String login;
    private int id;

    public void setLogin(String login) {
        this.login = login;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "GitHubUser{" +
                "login='" + login + '\'' +
                ", id=" + id +
                '}';
    }
}
