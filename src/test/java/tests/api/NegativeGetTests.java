package tests.api;

import baseEntities.BaseApiTest;
import io.qameta.allure.Allure;
import io.qameta.allure.Description;
import io.restassured.response.Response;
import org.apache.http.HttpStatus;
import org.testng.annotations.Test;
import utils.Endpoints;

import static io.restassured.RestAssured.given;

public class NegativeGetTests extends BaseApiTest {
    private static final String INVALID_AUTH_TOKEN = "invalid_token";

    @Test(description = "Try to get info without valid token")
    @Description("This get request test checks the result when receiving information with an invalid token")
    public void invalidTokenTest() {
        Allure.step("Send GET request with invalid token", () -> {
            Response response = given()
                    .header("Authorization", "Bearer " + INVALID_AUTH_TOKEN)  // Пробел добавлен между Bearer и токеном
                    .get(Endpoints.GET_PROJECT);

            Allure.step("Verify response status is 401 Unauthorized", () -> {
                response.then().statusCode(HttpStatus.SC_UNAUTHORIZED);
            });
        });
    }

    @Test(description = "An attempt to open a non-existent project")
    @Description("This test checks if an error is shown when trying to open a non-existent project")
    public void getNonExistentProjectTest() {
        Allure.step("Send GET request for non-existent project", () -> {
            Response response = given()
                    .header("Authorization", "Bearer " + getToken())
                    .get(Endpoints.GET_PROJECTS.replace("{project_id}", "5gg74t7"));

            Allure.step("Verify response status is 404 Not Found", () -> {
                response.then().statusCode(HttpStatus.SC_NOT_FOUND);
            });
        });
    }

    @Test(description = "An attempt to open a non-existent admin")
    @Description("This test checks if an error is shown when trying to open a non-existent admin")
    public void getNonExistentAdminResourceTest() {
        Allure.step("Send GET request for non-existent admin resource", () -> {
            Response response = given()
                    .header("Authorization", "Bearer " + getToken())
                    .when()
                    .get(Endpoints.GET_ADMIN_RESOURCE.replace("{resource}", "giihg"));

            Allure.step("Verify response status is 404 Not Found", () -> {
                response.then().statusCode(HttpStatus.SC_NOT_FOUND);
            });
        });
    }
}