package tests.gui;

import baseEntities.BaseGuiTest;
import io.qameta.allure.Allure;
import io.qameta.allure.Description;
import org.testng.annotations.Test;
import pages.ProjectsPage;
import utils.ProjectDirector;
import utils.UserDirector;

import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Condition.*;

public class DeleteProjectTest extends BaseGuiTest {
    private ProjectsPage projectsPage = new ProjectsPage();

    @Test(description = "Delete project and check dialog window")
    @Description("Test to check the display of the dialog box and removal of the project entity")
    public void deleteTest() {
        loginStep
                .successfulLogin(UserDirector.getAdmin())
                .createNewProject();

        projectStep
                .addProject(ProjectDirector.getProject())
                .clickManageProjectsButton();
        Allure.step("Delete project", () ->
            projectsPage.getDeleteButton()
                    .click());

        Allure.step("Verify that the Delete project dialog window is displayed", () -> {
            $("div.dialog__header__content__title[data-target='title']")
                    .shouldHave(text("Delete project"))
                    .shouldBe(visible);
        });

        Allure.step("Click on the confirmation checkbox", () ->
            $("label[data-target='confirmationLabel']").click());

        Allure.step("Verify that delete button is visible and enabled, then click", () ->
            $("button.ui.negative.button[data-action='click->doDelete'][data-target='deleteButton']")
                    .shouldBe(visible)
                    .shouldNotBe(disabled)
                    .click());
    }
}