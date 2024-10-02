package services;

import io.qameta.allure.Allure;
import io.restassured.mapper.ObjectMapperType;
import io.restassured.response.Response;
import models.AutomationRun;
import models.Result;
import org.apache.http.HttpStatus;
import utils.Endpoints;

import static baseEntities.BaseApiTest.AUTH_TOKEN;
import static io.restassured.RestAssured.given;

public class AutomationRunService implements IAutomationRunService {

    @Override
    public Result getAutomationRun(int automationRunId) {
        return Allure.step("Send GET request to retrieve automation run by ID, verify response status is 200 OK", () ->
                given()
                        .header("Authorization", "Bearer " + AUTH_TOKEN)
                        .pathParam("automation_run_id", automationRunId)
                        .log().all()
                        .when()
                        .get(Endpoints.GET_AUTOMATION_RUN)
                        .then()
                        .statusCode(HttpStatus.SC_OK)
                        .log().body()
                        .extract()
                        .as(Result.class, ObjectMapperType.GSON));
    }

    @Override
    public AutomationRun addAutomationRun(int projectId) {
        return Allure.step("Send POST request to add a new automation run", () ->
                given()
                        .header("Authorization", "Bearer " + AUTH_TOKEN)
                        .pathParam("project_id", projectId)
                        .body(AutomationRunService.class.getClassLoader().getResourceAsStream("expectedARTmp.json"))
                        .log().body()
                        .when()
                        .post(Endpoints.ADD_AUTOMATION_RUN)
                        .then()
                        .statusCode(HttpStatus.SC_CREATED)
                        .log().body()
                        .extract().as(AutomationRun.class, ObjectMapperType.GSON));
    }

    @Override
    public Response getAutomationRuns(int projectId) {
        return Allure.step("Send GET request to retrieve all automation runs for project", () ->
                given()
                        .header("Authorization", "Bearer " + AUTH_TOKEN)
                        .pathParam("project_id", projectId)
                        .when()
                        .get(Endpoints.GET_AUTOMATION_RUNS)
                        .then()
                        .log().body()
                        .extract().response());
    }
}