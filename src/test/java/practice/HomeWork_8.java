package practice;

import base_urls.PetStoreBaseUrl;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Test;
import test_data.PetStoreTestData;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

public class HomeWork_8 extends PetStoreBaseUrl {

   /*
    Type automation code to create a 'user' by using "https://petstore.swagger.io/"" documantation.
    */
     /*
        Given
            1) https://petstore.swagger.io/v2/user
            2) {
                  "username": "JohnDoe",
                  "firstName": "JohnDoe",
                  "lastName": "Doe",
                  "email": "john@doe.com",
                  "password": "1234",
                  "phone": "1234",
                  "userStatus": 123
                }
        When
            I send POST Request to the Url
        Then
            Status code is 200
            And response body should be like {
                                                "code": 200,
                                                "type": "unknown",
                                                "message": "6874988058"
                                             }
     */

    @Test
    public void h8(){
        //Set the URL
        spec.pathParams("first","v2","second","user");

        //Set the expected data
        Map<String,Object> expectedData = new PetStoreTestData().expectedDataMapMethod("JohnDoe","JohnDoe","Doe","john@doe.com","1234","1234",123);
        System.out.println("expectedData = " + expectedData);

        //Send the request and get the response
        Response response =given(spec).contentType(ContentType.JSON).body(expectedData).post("{first}/{second}");
        response.prettyPrint();

        Map<String,Object> actualData = response.as(HashMap.class);
        System.out.println("actualData = " + actualData);

        //Do Assertion
        assertEquals(200,response.statusCode());
        assertEquals(200,actualData.get("code"));
        assertEquals("unknown",actualData.get("type"));
        assertEquals("6874988058",actualData.get("message"));


    }


    }

