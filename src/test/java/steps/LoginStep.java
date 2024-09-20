package steps;

import baseEntities.BaseStep;
import models.User;
import pages.LoginPage;
import pages.ProjectsPage;

public class LoginStep extends BaseStep {

    public ProjectsPage successfulLogin(User user) {
        login(user);
        return projectsPage;
    }

    public LoginPage incorrectLogin(User user) {
        login(user);
        return loginPage;
    }

    private void login(User user) {
        loginPage
                .setEmail(user.getEmail())
                .setPassword(user.getPassword())
                .clickLoginButton();
    }
}