package pages;

import baseEntities.BasePage;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import elements.HiddenCheckbox;
import org.openqa.selenium.By;

import java.io.File;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class AddProjectPage extends BasePage {
    private final By PAGE_TITLE_LOCATOR = By.xpath("//div[contains(text(), 'Add project')]");
    private final SelenideElement PROJECT_NAME_INPUT_LOCATOR = $("[placeholder='Project name']");
    private final SelenideElement SUMMARY_INPUT_LOCATOR = $("div > textarea");
    private final SelenideElement DEFAULT_ACCESS_DROPDOWN_LOCATOR = $(".dropdown");
    private final SelenideElement DEMO_PROJECT_CHECKBOX_LOCATOR = $("[data-target='addDemoProject']");
    private final SelenideElement SELECT_AVATAR_BUTTON_LOCATOR = $(".fluid.button");
    private final SelenideElement UPLOAD_AVATAR_BUTTON_LOCATOR = $("[type='file']");
    private final SelenideElement ADD_PROJECT_BUTTON_LOCATOR = $(".button.primary");

    @Override
    protected SelenideElement getPageIdentifier() {
        return $(PAGE_TITLE_LOCATOR);
    }

    public SelenideElement getProjectNameInput() {
        return PROJECT_NAME_INPUT_LOCATOR;
    }

    public SelenideElement getSummaryInput() {
        return SUMMARY_INPUT_LOCATOR;
    }

    public SelenideElement getDefaultAccessDropdown() {
        return DEFAULT_ACCESS_DROPDOWN_LOCATOR;
    }

    public HiddenCheckbox getDemoProjectCheckbox() {
        return new HiddenCheckbox(DEMO_PROJECT_CHECKBOX_LOCATOR);
    }

    public SelenideElement getSelectAvatarButton() {
        return SELECT_AVATAR_BUTTON_LOCATOR;
    }

    public SelenideElement getUploadAvatarButton() {
        return UPLOAD_AVATAR_BUTTON_LOCATOR;
    }

    public SelenideElement getAddProjectButton() {
        return ADD_PROJECT_BUTTON_LOCATOR;
    }

    public AddProjectPage setProjectName(String projectName) {
        getProjectNameInput().val(projectName);
        return this;
    }

    public AddProjectPage setSummary(String summary) {
        getSummaryInput().val(summary);
        return this;
    }

    public AddProjectPage setDefaultAccess(String visibleText) {
        getDefaultAccessDropdown().click();
        ElementsCollection options = $$("[data-type='item']");
        for (SelenideElement element : options) {
            String text = element.getText();
            if (text.equals(visibleText)) {
                element.click();
                break;
            }
        }
        return this;
    }

    public AddProjectPage setDemoProjectTo(boolean flag) {
        getDemoProjectCheckbox().setFlag(flag);
        return this;
    }

    public AddProjectPage clickSelectAvatarButton() {
        getSelectAvatarButton().click();
        return this;
    }

    public AddProjectPage uploadAvatar(String path) {
        getUploadAvatarButton().uploadFile(new File(path));
        return this;
    }

    public void clickAddProjectButton() { // ToDo: возвращает ProjectInstancePage
        getAddProjectButton().click();
    }
}