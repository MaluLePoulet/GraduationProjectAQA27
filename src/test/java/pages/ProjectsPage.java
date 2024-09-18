package pages;

import baseEntities.BasePage;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selectors.byClassName;
import static com.codeborne.selenide.Selenide.$;

public class ProjectsPage extends BasePage {
    private final SelenideElement PROJECTS_TITLE_LOCATOR = $(byClassName("page-title__title"));
    private final SelenideElement PROJECT_ADD_BUTTON_LOCATOR = $(".ui.basic.compact.button");
    private final SelenideElement OPEN_PROJECT_LOCATOR = $("a[href='https://aqa27.testmo.net/projects/view/1']");

    @Override
    protected SelenideElement getPageIdentifier() {
        return $(PROJECTS_TITLE_LOCATOR);
    }

    public SelenideElement getProjectAddButton() {
        return PROJECT_ADD_BUTTON_LOCATOR;
    }

    public SelenideElement getOpenProjectLink() {
        return OPEN_PROJECT_LOCATOR;
    }

    public AddProjectPage createNewProject() {
        getProjectAddButton().click();
        return new AddProjectPage();
    }

}
