package baseEntities;

import configuration.ReadProperties;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.apache.http.protocol.HTTP;
import org.testng.annotations.BeforeClass;
import services.AutomationRunService;

import static io.restassured.RestAssured.given;

public class BaseApiTest {
    protected static final String AUTH_TOKEN = "testmo_api_eyJpdiI6ImFBZXkreHpsZkM0T1dHMkxBZHFIZHc9PSIsInZhbHVlIjoidFhWK3FuWGpJMHFETUlRWUd0NGZSNHJXTWp1V3E1dG1qSzNhSE52K2dYVT0iLCJtYWMiOiIyZDJlNTQ0Y2MxYmViYzZmNDQwNDRjMzRmOGE3YjYxYWY1N2MwYjljYWFiZDk4OTM5MDc2NzAzOTg2NmQ0MmEwIiwidGFnIjoiIn0=";
    protected AutomationRunService automationRunService;

    @BeforeClass
    public void setUpApiClient() {
        RestAssured.baseURI = ReadProperties.getUri();

        RestAssured.requestSpecification = given()
                .header(HTTP.CONTENT_TYPE, ContentType.JSON)
                .header("Authorization", "Bearer " + AUTH_TOKEN);

        automationRunService = new AutomationRunService();
    }
}