package practice;

import base_urls.AutomationExerciseBaseUrl;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class Homework_10 extends AutomationExerciseBaseUrl {
    /*
    Given
        https://automationexercise.com/api/productsList
    When
        User sends Get request
        Note: use prettyPrint like: response.jsonPath().prettyPrint()
    Then
        Assert that number of "Women" usertype is 12

*/
    @Test
    public void h10(){

        spec.pathParams("first","api","second","productList");




        Response response =given(spec).get("{first}/{second}");

        JsonPath jsonPath =response.jsonPath();

        response.jsonPath().prettyPrint();




    }


}
