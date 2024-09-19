package pages.instances;

import baseEntities.BasePage;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;
import pages.ProjectsPage;

import static com.codeborne.selenide.Selenide.$;

public class ProjectInstancePage extends BasePage {
    String projectName = $(".page-header__title").getText();
    private static final String PAGE_HEADER_TITLE_LOCATOR = "//div[contains(@class, 'page-header__title') and contains(text(), 'replace')]";
    private final SelenideElement MANAGE_PROJECTS_BUTTON = $(".page-header__toolbar__actions .ui.compact.button");

    @Override
    protected SelenideElement getPageIdentifier() {
        return $(By.xpath(PAGE_HEADER_TITLE_LOCATOR.replace("replace", projectName)));
    }

    public SelenideElement getManageProjectsButton() {
        return MANAGE_PROJECTS_BUTTON;
    }

    public ProjectsPage clickManageProjectsButton() {
        getManageProjectsButton().click();
        return new ProjectsPage();
    }
}