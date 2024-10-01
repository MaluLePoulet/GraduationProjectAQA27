package utils;

public class Endpoints {
    public static final String GET_AUTOMATION_RUN = "automation/runs/{automation_run_id}";
    public static final String GET_AUTOMATION_RUNS = "projects/{project_id}/automation/runs";
    public static final String ADD_AUTOMATION_RUN = "projects/{project_id}/automation/runs";

    public static final String GET_PROJECTS = "projects/view/{project_id}";
    public static final String GET_PROJECT = "projects";
    public static final String GET_ADMIN_RESOURCE = "admin/{resource}";
}