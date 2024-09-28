package tests.api;

import baseEntities.BaseApiTest;
import io.qameta.allure.Description;
import io.restassured.response.Response;
import models.AutomationRun;
import models.Result;
import models.Results;
import org.apache.http.HttpStatus;
import org.testng.Assert;
import org.testng.annotations.Test;


public class AutomationRunsApiTest extends BaseApiTest {
    private Result actualAutomationRun;

    @Test(description = "Add automation run")
    @Description("This is to test if API requests POST and GET automation run work correctly")
    public void addAutomationRun() {
        AutomationRun expectedAutomationRun = automationRunService.addAutomationRun(154);
        actualAutomationRun = automationRunService.getAutomationRun(expectedAutomationRun.getId());

        System.out.println(actualAutomationRun);
        System.out.println(expectedAutomationRun);

        Assert.assertEquals(actualAutomationRun.getResult().getId(), expectedAutomationRun.getId());
    }

    @Test(description = "Get automation runs")
    @Description("This is to test if API request GET automation runs works correctly")
    public void getAutomationRuns() {
        Response response = automationRunService.getAutomationRuns(154);
        Results results = response.getBody().as(Results.class);

        System.out.println(results);
        Assert.assertEquals(response.getStatusCode(), HttpStatus.SC_OK);
    }
}