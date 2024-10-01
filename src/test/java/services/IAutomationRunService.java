package services;

import io.restassured.response.Response;
import models.AutomationRun;
import models.Result;

public interface IAutomationRunService {
    AutomationRun addAutomationRun(int projectId);

    Result getAutomationRun(int automationRunId);

    Response getAutomationRuns(int projectId);
}