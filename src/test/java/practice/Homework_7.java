package practice;

import base_urls.ReqresBaseUrl;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Test;
import test_data.ReqresTestData;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

public class Homework_7 extends ReqresBaseUrl {
    /*
        Given
            1) https://reqres.in/api/users
            2) {
                "name": "morpheus",
                "job": "leader"
                }
        When
            I send POST Request to the Url
        Then
            Status code is 201
            And response body should be like {
                                                "name": "morpheus",
                                                "job": "leader",
                                                "id": "496",
                                                "createdAt": "2022-10-04T15:18:56.372Z"
                                              }
     */

    @Test
    public void h7(){
        //Set the URL
        spec.pathParams("first","api","second","users");

        //Set the expected data
        ReqresTestData reqresTestData = new ReqresTestData();
        Map<String,String> expectedData = reqresTestData.expectedDataMapMethod("morpheus","leader");
        System.out.println("expectedData = " + expectedData);

        //Send the request and get the response
        Response response =given(spec).contentType(ContentType.JSON).body(expectedData).when().post("{first}/{second}");
        response.prettyPrint();

        //Do Assertion
        Map<String,String> actualData = response.as(HashMap.class);
        System.out.println("actualData = " + actualData);

        assertEquals(201,response.getStatusCode());
        assertEquals(expectedData.get("name"),actualData.get("name"));
        assertEquals(expectedData.get("job"),actualData.get("job"));


    }




}
