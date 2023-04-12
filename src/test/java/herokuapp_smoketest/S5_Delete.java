package herokuapp_smoketest;

import base_urls.HerOkuAppBaseUrl;
import io.restassured.response.Response;
import org.junit.Test;

import static herokuapp_smoketest.S1_Post.bookingId;
import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

public class S5_Delete extends HerOkuAppBaseUrl {

    /*
    Given
         https://restful-booker.herokuapp.com/booking/{id}

     When
        Send delete request

    Then
        Status code should be 201

    And
        Body should be "created"
     */

     @Test
    public void deleteTest(){
         //Set the URL
         spec.pathParams("first","booking","second",bookingId);

         //Set the expected data
         String expectedData = "Created";

         //Send the request and get the response
         Response response = given(spec).delete("{first}/{second}");
         response.prettyPrint();

         //Do Assertion
         assertEquals(201,response.getStatusCode());
         assertEquals(expectedData,response.asString());


     }

}
