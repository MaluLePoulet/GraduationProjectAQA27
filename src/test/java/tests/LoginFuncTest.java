package tests;

import baseEntities.BaseTest;
import io.qameta.allure.Description;
import org.testng.annotations.Test;
import utils.UserDirector;

import static com.codeborne.selenide.Condition.*;

public class LoginFuncTest extends BaseTest {

    @Test
    public void differentLoginTests() {
        loginStep
                .incorrectLogin(UserDirector.getUserWithIncorrectPassword())
                .getBlockMessage()
                .shouldBe(visible);

        loginStep
                .incorrectLogin(UserDirector.getUserWithIncorrectEmail())
                .getBlockMessage()
                .shouldBe(visible);
    }
}
