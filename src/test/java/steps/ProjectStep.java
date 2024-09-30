package steps;

import baseEntities.BaseStep;
import io.qameta.allure.Allure;
import models.Project;
import pages.AddProjectPage;
import pages.instances.ProjectInstancePage;

public class ProjectStep extends BaseStep {

    public ProjectInstancePage addProject(Project project) {
        Allure.step("Add project", () -> {
            setTextFieldsValues(project);
            Allure.step("Set demo project", () -> {
                addProjectPage.setDemoProjectTo(project.isDemoProject());
            });
            addProjectPage.clickAddProjectButton();
        });
        return new ProjectInstancePage();
    }

    public ProjectInstancePage addProjectWithAvatar(Project project) {
        Allure.step("Add project with avatar", () -> {
            setTextFieldsValues(project);
            Allure.step("Upload file", () -> {
                addProjectPage.uploadAvatar(project.getUploadAvatar());
            });
            addProjectPage.clickAddProjectButton();
        });
        return new ProjectInstancePage();
    }

    private AddProjectPage setTextFieldsValues(Project project) {
        Allure.step("Set text fields", () -> {
            Allure.step("Set name", () -> {
                addProjectPage.setProjectName(project.getName());
            });

            Allure.step("Set summary", () -> {
                addProjectPage.setSummary(project.getSummary());
            });

            Allure.step("Set default access", () -> {
                addProjectPage.setDefaultAccess(project.getDefaultAccess());
            });
        });
        return addProjectPage;
    }
}