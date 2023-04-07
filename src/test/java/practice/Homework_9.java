package practice;

import base_urls.PetStoreBaseUrl;
import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertTrue;

public class Homework_9 extends PetStoreBaseUrl {

    //Using the https://petstore.swagger.io/ document, write an automation test that finds the number of "pets"
    // with a status of "available" and asserts that those are more than 100.

    //https://petstore.swagger.io/v2/pet/findByStatus?status=available

    @Test
    public void h9(){

        spec.pathParams("first","v2","second","pet","third","findByStatus").
                queryParam("status","available");

        Response response = given(spec).get("{first}/{second}/{third}");
        response.prettyPrint();

        int numOfAvailablePets = response.jsonPath().getList("id").size();
        assertTrue(numOfAvailablePets>100);



    }





}
