package steps;

import baseEntities.BaseStep;
import models.Project;
import pages.AddProjectPage;
import pages.instances.ProjectInstancePage;

public class ProjectStep extends BaseStep {

    public ProjectInstancePage addProject(Project project) {
        setTextFieldsValues(project)
                .setDemoProjectTo(project.isDemoProject())
                .clickAddProjectButton();
        return new ProjectInstancePage();
    }

    public ProjectInstancePage addProjectWithAvatar(Project project) {
        setTextFieldsValues(project)
                .clickSelectAvatarButton()
                .uploadAvatar(project.getUploadAvatar())
                .clickAddProjectButton();
        return new ProjectInstancePage();
    }

    private AddProjectPage setTextFieldsValues(Project project) {
        addProjectPage
                .setProjectName(project.getName())
                .setSummary(project.getSummary())
                .setDefaultAccess(project.getDefaultAccess());
        return addProjectPage;
    }
}