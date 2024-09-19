package pages;

import baseEntities.BasePage;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class LoginPage extends BasePage {
    private final By WELCOME_MESSAGE_LOCATOR = By.xpath("//h1[contains(text(), 'Welcome! Please log in:')]");
    private final SelenideElement EMAIL_INPUT_LOCATOR = $("[placeholder='Email']");
    private final SelenideElement PASSWORD_INPUT_LOCATOR = $("[placeholder='Password']");
    private final SelenideElement LOGIN_BUTTON_LOCATOR = $(".ui.primary.button");
    private final SelenideElement MESSAGE_BLOCK_LOCATOR = $(".message-block.message-block--negative.message-block--scroll");

    @Override
    protected SelenideElement getPageIdentifier() {
        return $(WELCOME_MESSAGE_LOCATOR);
    }

    public SelenideElement getEmailInput() {
        return EMAIL_INPUT_LOCATOR;
    }

    public SelenideElement getPasswordInput() {
        return PASSWORD_INPUT_LOCATOR;
    }

    public SelenideElement getLoginButton() {
        return LOGIN_BUTTON_LOCATOR;
    }

    public SelenideElement getBlockMessage() {
        return MESSAGE_BLOCK_LOCATOR;
    }

    public LoginPage setEmail(String email) {
        getEmailInput().val(email);
        return this;
    }

    public LoginPage setPassword(String password) {
        getPasswordInput().val(password);
        return this;
    }

    public ProjectsPage clickLoginButton() {
        getLoginButton().click();
        return new ProjectsPage();
    }
}