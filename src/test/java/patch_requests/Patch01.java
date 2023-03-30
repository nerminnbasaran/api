package patch_requests;

import base_urls.JSonPlaceHolderBaseUrl;
import io.restassured.response.Response;
import org.junit.Test;
import test_data.JSonPlaceHolderTestData;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

public class Patch01 extends JSonPlaceHolderBaseUrl {
      /*
   Given
       1) https://jsonplaceholder.typicode.com/todos/198
       2) {
            "title": "Read the books"
          }
   When
        I send PATCH Request to the Url
   Then
         Status code is 200
         And response body is like   {
                                   "userId": 10,
                                   "title": "Read the books",
                                   "completed": true,
                                   "id": 198
                                  }
    */

    @Test
    public void patch01(){

        //Set the URL
        spec.pathParams("first","todos","second",198);

        //Set the expected data
        Map<String,Object> expectedData = new JSonPlaceHolderTestData().expectedDataMapMethod(null,"Read the books",null);
        System.out.println("expectedData = " + expectedData);

        //Send the request and get the response
        Response response =given(spec).body(expectedData).patch("{first}/{second}");

        //Do Assertion
        Map<String,Object> actualData = response.as(HashMap.class);
        System.out.println("actualData = " + actualData);

        assertEquals(200,response.statusCode());
        assertEquals(expectedData.get("title"),actualData.get("title"));

        //If you want to assert whole body
        assertEquals(10,actualData.get("userId"));
        assertEquals(true,actualData.get("completed"));



    }












}
