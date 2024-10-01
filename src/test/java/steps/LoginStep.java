package steps;

import baseEntities.BaseStep;
import io.qameta.allure.Allure;
import models.User;
import pages.LoginPage;
import pages.ProjectsPage;

public class LoginStep extends BaseStep {

    public ProjectsPage successfulLogin(User user) {
        Allure.step("Successful login", () ->
            login(user));
        return projectsPage;
    }

    public LoginPage incorrectLogin(User user) {
        Allure.step("Incorrect login", () ->
            login(user));
        return loginPage;
    }

    private void login(User user) {
        Allure.step("Login", () -> {
            Allure.step("Set email", () -> {
                loginPage.setEmail(user.getEmail());
            });

            Allure.step("Set password", () -> {
                loginPage.setPassword(user.getPassword());
            });
            loginPage.clickLoginButton();
        });
    }
}