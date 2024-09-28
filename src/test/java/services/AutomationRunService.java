package services;

import io.restassured.mapper.ObjectMapperType;

import io.restassured.response.Response;
import models.AutomationRun;
import models.Result;
import org.apache.http.HttpStatus;
import utils.Endpoints;

import static io.restassured.RestAssured.given;

public class AutomationRunService implements IAutomationRunService {

    @Override
    public Result getAutomationRun(int automationRunId) {
        return given()
                .pathParam("automation_run_id", automationRunId)
                .log().all()
                .when()
                .get(Endpoints.GET_AUTOMATION_RUN)
                .then()
                .statusCode(HttpStatus.SC_OK)
                .log().body()
                .extract()
                .as(Result.class, ObjectMapperType.GSON);
    }

    @Override
    public AutomationRun addAutomationRun(int projectId) {
        return given()
                .pathParam("project_id", projectId)
                .body(AutomationRunService.class.getClassLoader().getResourceAsStream("expectedARTmp.json"))
                .log().body()
                .when()
                .post(Endpoints.ADD_AUTOMATION_RUN)
                .then()
                .statusCode(HttpStatus.SC_CREATED)
                .log().body()
                .extract().as(AutomationRun.class, ObjectMapperType.GSON);
    }

    @Override
    public Response getAutomationRuns(int projectId) {
        return given()
                .pathParam("project_id", projectId)
                .when()
                .get(Endpoints.GET_AUTOMATION_RUNS)
                .then()
                .log().body()
                .extract().response();
    }
}