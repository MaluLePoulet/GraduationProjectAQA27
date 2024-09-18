package steps;

import baseEntities.BaseStep;
import models.Project;
import pages.AddProjectPage;

public class ProjectStep extends BaseStep {

    public void addProject(Project project) { //ToDo: return ProjectInstancePage
        setTextValues(project)
                .setDemoProjectTo(project.isDemoProject())
                .clickAddProjectButton();
    }

    public void addProjectWithAvatar(Project project) { //ToDo: return ProjectInstancePage
        setTextValues(project)
                .clickSelectAvatarButton()
                .uploadAvatar(project.getUploadAvatar())
                .clickAddProjectButton();
    }

    private AddProjectPage setTextValues(Project project) { // ToDo: придумать нормальное название
        addProjectPage
                .setProjectName(project.getName())
                .setSummary(project.getSummary())
                .setDefaultAccess(project.getDefaultAccess());
        return addProjectPage;
    }
}