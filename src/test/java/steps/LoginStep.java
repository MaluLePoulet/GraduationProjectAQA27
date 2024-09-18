package steps;

import baseEntities.BaseStep;
import pages.LoginPage;
import pages.ProjectsPage;

public class LoginStep extends BaseStep {

    public LoginStep() {
        super();
    }

    public ProjectsPage successfulLogin(String username, String password) {
        login(username, password);

        return projectsPage;
    }

    public LoginPage incorrectLogin(String username, String password) {
        login(username, password);
        return loginPage;
    }

    private void login(String username, String password) {
        loginPage
                .setEmail(username)
                .setPassword(password)
                .clickLoginButton();
    }
}
