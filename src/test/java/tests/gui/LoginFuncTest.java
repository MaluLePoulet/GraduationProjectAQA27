package tests.gui;

import baseEntities.BaseGuiTest;
import io.qameta.allure.Allure;
import io.qameta.allure.Description;
import org.testng.annotations.Test;
import utils.UserDirector;

import static com.codeborne.selenide.Condition.*;

public class LoginFuncTest extends BaseGuiTest {

    @Test(description = "Boundary Value Testing for Input Field")
    @Description("Test to check the input field for boundary values")
    public void firstLoginTests() {
        Allure.step("Attempt login with password out of permissible bounds", () -> {
            loginStep
                    .incorrectLogin(UserDirector.getUserWithIncorrectPassword())
                    .getBlockMessage()
                    .shouldBe(visible);
        });
    }

    @Test(description = "Incorrect Value Testing for Input Field")
    @Description("Test for using incorrect data")
    public void secondLoginTests() {
        Allure.step("Attempt login with incorrect email", () -> {
            loginStep
                    .incorrectLogin(UserDirector.getUserWithIncorrectEmail())
                    .getBlockMessage()
                    .shouldBe(visible);
        });
    }
}