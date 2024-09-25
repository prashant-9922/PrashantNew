package steps;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.annotations.Test;


import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

public class JsonPlaceholderTest {

    @Test
    public void testGetPosts() {
        RestAssured.baseURI = "https://jsonplaceholder.typicode.com";

        // GET request to retrieve posts
        given()
                .when()
                .post("/posts")
                .then()
                .statusCode(200)
                .body("size()", greaterThan(0)); // Ensure there's at least one post
    }

    @Test
    public void testUnauthorizedAccess() {
        // Base URL for the API (example)
        RestAssured.baseURI = "https://jsonplaceholder.typicode.com";

        // Attempt to access a protected resource without authentication
        Response response = given()
                .when()
                .get("/posts"); // Assume this requires authentication in a real API

        System.out.println(response.asString());
    }

    @Test
    public void testCreatePost() {
        RestAssured.baseURI = "https://jsonplaceholder.typicode.com";

        // POST request to create a new post
        Response response = given()
                .header("Content-Type", "application/json")
                .body("{ \"title\": \"foo\", \"body\": \"bar\", \"userId\": 1 }")
                .when()
                .post("/posts");

        // Assertions
        response.then()
                .statusCode(201)
                .body("title", equalTo("foo"))
                .body("body", equalTo("bar"));
    }
}

