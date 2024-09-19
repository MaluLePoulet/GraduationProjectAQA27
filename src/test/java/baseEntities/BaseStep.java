package baseEntities;

import pages.AddProjectPage;
import pages.LoginPage;
import pages.ProjectsPage;

public class BaseStep {
    protected LoginPage loginPage;
    protected ProjectsPage projectsPage;
    protected AddProjectPage addProjectPage;

    public BaseStep() {
        loginPage = new LoginPage();
        projectsPage = new ProjectsPage();
        addProjectPage = new AddProjectPage();
    }
}