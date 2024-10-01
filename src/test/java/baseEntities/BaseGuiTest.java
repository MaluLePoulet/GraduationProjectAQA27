package baseEntities;

import com.codeborne.selenide.AssertionMode;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.WebDriverRunner;
import com.codeborne.selenide.logevents.SelenideLogger;
import com.codeborne.selenide.testng.SoftAsserts;
import configuration.ReadProperties;
import io.qameta.allure.selenide.AllureSelenide;
import org.testng.annotations.*;
import steps.LoginStep;
import steps.ProjectStep;

import static com.codeborne.selenide.Selenide.open;

@Listeners(SoftAsserts.class)
public class BaseGuiTest {
    protected LoginStep loginStep;
    protected ProjectStep projectStep;

    @BeforeTest
    public void beforeTest() {
        SelenideLogger.addListener("AllureSelenide", new AllureSelenide());
        Configuration.baseUrl = ReadProperties.getUrl();
        Configuration.assertionMode = AssertionMode.SOFT;
    }

    @BeforeClass
    public void setUp() {
        open("/");
        WebDriverRunner.driver().getWebDriver().manage().window().maximize();

        loginStep = new LoginStep();
        projectStep = new ProjectStep();
    }
}