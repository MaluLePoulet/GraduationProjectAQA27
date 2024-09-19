package utils;

import models.Project;

import java.io.File;

public class ProjectDirector {

    public static Project getProject() {
        return new Project.Builder()
                .setName("Our Project")
                .setSummary("This project is created by Yana and Lera")
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