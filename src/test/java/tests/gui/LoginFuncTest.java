package tests.gui;

import baseEntities.BaseGuiTest;
import io.qameta.allure.Description;
import org.testng.annotations.Test;
import utils.UserDirector;

import static com.codeborne.selenide.Condition.*;

public class LoginFuncTest extends BaseGuiTest {

    @Test(description = "Boundary Value Testing for Input Field")
    @Description("Test to check the input field for boundary values")
    public void firstLoginTests() {
        loginStep
                .incorrectLogin(UserDirector.getUserWithIncorrectPassword())
                .getBlockMessage()
                .shouldBe(visible);
    }

@Test(description = "Incorrect Value Testing for Input Field")
@Description("Test for using incorrect data")
public void secondLoginTests() {
        loginStep
                .incorrectLogin(UserDirector.getUserWithIncorrectEmail())
                .getBlockMessage()
                .shouldBe(visible);
    }
}

