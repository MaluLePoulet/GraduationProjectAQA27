package models;

import java.util.Objects;

public class Project {

    private String name;
    private String summary;
    private String defaultAccess;
    private boolean isDemoProject;
    private String uploadAvatar;

    public String getName() {
        return name;
    }

    public String getSummary() {
        return summary;
    }

    public String getDefaultAccess() {
        return defaultAccess;
    }

    public boolean isDemoProject() {
        return isDemoProject;
    }

    public String getUploadAvatar() {
        return uploadAvatar;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Project project = (Project) o;
        return isDemoProject == project.isDemoProject && Objects.equals(name, project.name) && Objects.equals(summary, project.summary) && Objects.equals(defaultAccess, project.defaultAccess) && Objects.equals(uploadAvatar, project.uploadAvatar);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, summary, defaultAccess, isDemoProject, uploadAvatar);
    }

    public static class Builder {
        private Project newProject;

        public Builder() {
            this.newProject = new Project();
        }

        public Builder setName(String name) {
            newProject.name = name;
            return this;
        }

        public Builder setSummary(String summary) {
            newProject.summary = summary;
            return this;
        }

        public Builder setDefaultAccess(String defaultAccess) {
            newProject.defaultAccess = defaultAccess;
            return this;
        }

        public Builder setDemoProject(boolean isDemoProject) {
            newProject.isDemoProject = isDemoProject;
            return this;
        }

        public Builder uploadAvatar(String uploadAvatar) {
            newProject.uploadAvatar = uploadAvatar;
            return this;
        }

        public Project build() {
            return newProject;
        }
    }
}