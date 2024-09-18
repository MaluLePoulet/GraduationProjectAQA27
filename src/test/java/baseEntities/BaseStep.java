package baseEntities;

import pages.AddProjectPage;
import pages.LoginPage;
import pages.ProjectsPage;

public class BaseStep {
    protected AddProjectPage addProjectPage;
    protected LoginPage loginPage;
    protected ProjectsPage projectsPage;


    public BaseStep() {
        addProjectPage = new AddProjectPage();
        loginPage = new LoginPage();
        projectsPage = new ProjectsPage();
    }
}