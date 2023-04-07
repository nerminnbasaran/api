package practice;

import base_urls.AutomationExerciseBaseUrl;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

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

        spec.pathParams("first","api","second","productsList");

        Response response =given(spec).get("{first}/{second}");
        response.jsonPath().prettyPrint();

        JsonPath jsonPath =response.jsonPath();
        int numOfWomenUser = jsonPath.getList("products.findAll{it.category.usertype.usertype=='Women'}").size();
        assertEquals(12,numOfWomenUser);



    }


}
