package utils;

import models.Project;

import java.io.File;

public class ProjectDirector {

    public static Project getProject() { //ToDo: придумать нормальное название, подключить faker
        return new Project.Builder()
                .setName("Project")
                .setSummary("12234556")
                .setDefaultAccess("Tester")
                .setDemoProject(false)
                .uploadAvatar(ProjectDirector.class.getClassLoader().getResource("data" + File.separator + "upload.jpg").getPath())
                .build();
    }

    public static Project getDemoProject() {
        return new Project.Builder()
                .setDemoProject(true)
                .build();
    }
}