package steps;

import static io.restassured.RestAssured.*;

import io.cucumber.java.nl.Stel;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.response.Response;
import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class FirstApiTest {



    @Test(priority = -1)
    public void postApiRequest() {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("name", "Prashant");
        jsonObject.put("job", "QA");
        baseURI = "https://reqres.in/api/user";
        Response resp = given()
                .contentType(ContentType.JSON)
                .header("Content-type", "application/json")

                .body(jsonObject.toJSONString())
                .when().post();

        Assert.assertEquals(resp.getStatusCode(), 201);
        System.out.println("Status code is " + resp.getStatusCode());
    }

    @Test(priority = 1)
    public void patchApiRequest() {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("name", "Prashant");
        jsonObject.put("job", "QA Automation");
        baseURI = "https://reqres.in/api/user/907";
        given()
                .contentType(ContentType.JSON)
                .header("Content-type", "application/json")

                .body(jsonObject.toJSONString())
                .when().patch().then().log().all();

       /* Assert.assertEquals(resp.getStatusCode(),200);
        System.out.println("Status code is "+resp.getStatusCode());*/
    }

    @Test(priority = 1)
    public void getApiRequest() {
        Response resp = get("https://reqres.in/api/user");
        System.out.println(resp.asString());
        Assert.assertEquals(resp.getStatusCode(), 200);
        System.out.println("Status code is " + resp.getStatusCode());
    }

   // @Test
    public void putApiRequest() {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("name", "Prashant warule");
        jsonObject.put("job", "QA Automation");
        baseURI = "https://reqres.in/api/user/907";
        given()
                .contentType(ContentType.JSON)
                .header("Content-type", "application/json")

                .body(jsonObject.toJSONString())
                .when().patch().then().log().all();

       /* Assert.assertEquals(resp.getStatusCode(),200);
        System.out.println("Status code is "+resp.getStatusCode());*/
    }

    //@Test
    public void deleteApiRequest() {
        baseURI = "https://reqres.in/api/user/907";
        when().delete().then().log().all().statusCode(204);

       /* Assert.assertEquals(resp.getStatusCode(),200);
        System.out.println("Status code is "+resp.getStatusCode());*/
    }

   // @Test
    public void getApiRequest2() {
        baseURI = "https://reqres.in/api/user/907";
        given()
                .header("Authorization", "Bearer your_bearer_token_here")  // Pass the Bearer token in the header
                .when()
                .get("/api/user/907")  // Specify the endpoint
                .then()
                .log().all();
    }

   // @Test
    public void getAndValidateHeaders(List<String> expHeaderList) {
        Response response = get("https://api.example.com/users/1");
        // Get all headers
        Headers allHeaders = response.getHeaders();
        // Print all headers
        for (Header header : allHeaders) {
            String actHeader = header.getValue();
            System.out.println(header.getName() + ": " + header.getValue());
            for (String expHeader : expHeaderList) {
                Assert.assertEquals(actHeader,expHeader);
            }
        }
    }


}
