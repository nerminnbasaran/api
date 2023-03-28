package practice;

import base_urls.HerOkuAppBaseUrl;
import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.greaterThan;
import static org.hamcrest.Matchers.hasSize;

public class Homework_4 extends HerOkuAppBaseUrl {
    /*
        Given
            https://restful-booker.herokuapp.com/booking?firstname=Brandon&lastname=Wilson
        When
            User sends get request to the URL
        Then
            Status code is 200
        And
            Among the data there should be someone whose firstname is "Brandon" and lastname is "Wilson"

 */
    @Test
    public void h4(){
        //Set the URL
        spec.pathParam("first","booking").
                queryParams("firstname","Brandon","lastname","Wilson");


        //Send the request and get the response
        Response response = given(spec).when().get("{first}");
        response.prettyPrint();

        //Do assertion
        response.then().statusCode(200).body("",hasSize(greaterThan(0)));//It fails because api response is "[]"
    }


}
