package tests.gui;

import baseEntities.BaseGuiTest;
import io.qameta.allure.Description;
import org.testng.annotations.Test;
import pages.AddProjectPage;
import utils.ProjectDirector;
import utils.UserDirector;

import java.io.File;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;

public class ProjectFuncTest extends BaseGuiTest {
    protected AddProjectPage addProjectPage = new AddProjectPage();

    @Test(description = "Exceeded values test")
    @Description("This is to test if the field that allows a certain number of symbols works correctly")
    public void exceededValuesTest() {
        loginStep
                .successfulLogin(UserDirector.getAdmin())
                .createNewProject();
        addProjectPage
                .setSummary("This text contains way way way way more than eighty symbols. The exact number is 83")
                .getSummaryInput()
                .shouldNotBe(empty)
                .shouldHave(value("This text contains way way way way more than eighty symbols. The exact number is"));
        $(".maxlength-counter__counter")
                .shouldHave(text("80/80"));
    }

    @Test(dependsOnMethods = "exceededValuesTest", description = "Popup test")
    @Description("This is to test if the popup functionality works correctly")
    public void popupTest() {
        addProjectPage
                .getDefaultAccessTooltip()
                .hover();
        $(".popup.popup--visible")
                .should(exist)
                .shouldHave(text("You can assign project-specific permissions to users and groups. All users without project-specific permissions automatically use this configured default access (e.g. their global role)."));
    }

    @Test(dependsOnMethods = "popupTest", description = "File Upload test")
    @Description("This is to test if file uploading functionality works correctly")
    public void fileUploadTest() {
        addProjectPage
                .uploadAvatar
                        (ProjectFuncTest.class
                                .getClassLoader()
                                .getResource("data" + File.separator + "upload.jpg")
                                .getPath());

        $(".avatar.avatar--64 img")
                .shouldHave(attributeMatching("src", ".*aqa27.testmo.net/attachments/view/.*"))
                .shouldBe(visible);
    }

    @Test(dependsOnMethods = "fileUploadTest", description = "Create project test")
    @Description("This is to test if creation of the project works correctly")
    public void createProjectTest() {
        projectStep.addProject(ProjectDirector.getProject());
        $(".page-header__title")
                .shouldHave(text("Our project"))
                .shouldBe(visible);
    }
}