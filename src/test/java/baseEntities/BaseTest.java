package baseEntities;

import com.codeborne.selenide.AssertionMode;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.WebDriverRunner;
import com.codeborne.selenide.testng.SoftAsserts;
import configuration.ReadProperties;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Listeners;
import steps.LoginStep;

import static com.codeborne.selenide.Selenide.open;

@Listeners(SoftAsserts.class)
public class BaseTest {
    protected ProjectStep projectStep;
    protected LoginStep loginStep;

    @BeforeSuite
    public void beforeSuite() {
        Configuration.baseUrl = ReadProperties.getUrl();
        Configuration.assertionMode = AssertionMode.SOFT;

        projectStep = new ProjectStep();
        loginStep = new LoginStep();
    }

    @BeforeMethod
    public void setUp() {
        open("/");
        WebDriverRunner.driver().getWebDriver().manage().window().maximize();
    }
}