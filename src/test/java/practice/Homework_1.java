package practice;

import base_urls.ReqresBaseUrl;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class Homework_1 extends ReqresBaseUrl {
    /*
        Given
            https://reqres.in/api/users/3
        When
            User sends a GET Request to the url
        Then
            HTTP Status Code should be 200
        And
            Content Type should be JSON
        And
            Status Line should be HTTP/1.1 200 OK
     */


    @Test
    public void h1(){
        //Set the URL
        spec.pathParams("first","api","second","users","third",3);

        //Set the expected data

        //Send the request and get the response
        Response response= given(spec).get("{first}/{second}/{third}");
        response.prettyPrint();

        //Do Assertion
        response.
                then().
                statusCode(200).
                contentType(ContentType.JSON).
                statusLine("HTTP/1.1 200 OK");



    }


}
