package post_requests;

import base_urls.JSonPlaceHolderBaseUrl;
import io.restassured.response.Response;
import org.codehaus.jackson.map.ObjectMapper;
import org.junit.Test;
import pojos.JsonPlaceHolderPojo;

import java.io.IOException;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

public class Post05ObjectMapper_Pojo extends JSonPlaceHolderBaseUrl {
     /*
   Given
      1) https://jsonplaceholder.typicode.com/todos
      2) {
            "userId": 55,
            "title": "Tidy your room",
            "completed": false
          }


       I send POST Request to the Url
   Then
       Status code is 201
   And
       response body is like {
                               "userId": 55,
                               "title": "Tidy your room",
                               "completed": false,
                               "id": 201
                               }
    */

    @Test
    public void post05() throws IOException {
        //Set the URL
        spec.pathParam("first","todos");

        //Set the expected data
        JsonPlaceHolderPojo expectedData = new JsonPlaceHolderPojo(55,"Tidy your room",false);
        System.out.println("expectedData = " + expectedData);

        //Send the request and get the response
        Response response =given(spec).body(expectedData).post("{first}");
        response.prettyPrint();

        //Do Assertion
        JsonPlaceHolderPojo actualData = new ObjectMapper().readValue(response.asString(), JsonPlaceHolderPojo.class);
        System.out.println("actualData = " + actualData);

        assertEquals(201,response.getStatusCode());
        assertEquals(expectedData.getCompleted(),actualData.getCompleted());
        assertEquals(expectedData.getTitle(),actualData.getTitle());
        assertEquals(expectedData.getUserId(),actualData.getUserId());



    }
}
