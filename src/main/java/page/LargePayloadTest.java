package page;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import java.nio.file.Files;
import java.nio.file.Paths;

public class LargePayloadTest {

    public static void main(String[] args) throws Exception {
        // Set base URI
        RestAssured.baseURI = "https://api.example.com";

        // Read the large JSON payload from a file
        String largePayload = readPayloadFromFile("src/test/resources/largePayload.json");

        // Send the payload in a POST request
        Response response = sendPostRequest("/students", largePayload);

        // Print the response
        System.out.println("Response: " + response.asString());
    }

    // Utility method to read the payload from a file
    private static String readPayloadFromFile(String filePath) throws Exception {
        return new String(Files.readAllBytes(Paths.get(filePath)));
    }

    // Utility method to send a POST request with the payload
    private static Response sendPostRequest(String endpoint, String payload) {
        RequestSpecification request = RestAssured
                .given()
                .header("Content-Type", "application/json")
                .body(payload);

        return request
                .when()
                .post(endpoint)
                .then()
                .statusCode(200) // Expecting HTTP 200 OK
                .extract().response();
    }
}

