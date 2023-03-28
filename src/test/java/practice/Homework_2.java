package practice;

import base_urls.ReqresBaseUrl;
import io.restassured.response.Response;
import org.junit.Assert;
import org.junit.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.hasSize;

public class Homework_2 extends ReqresBaseUrl {
    /*
        Given
            https://reqres.in/api/users/23
        When
            User send a GET Request to the url
        Then
            HTTP Status code should be 404
        And
            Status Line should be HTTP/1.1 404 Not Found
        And
            Server is "cloudflare"
        And
            Response body should be empty

     */
    @Test
    public void h2(){
        //Set the URL
        spec.pathParams("first","api","second","users","third",23);

        //Set the expected data

        //Send the request and get the response
        Response response =given(spec).get("{first}/{second}/{third}");
        response.prettyPrint();

        //Do Assertion
        response.
                then().statusCode(404).statusLine("HTTP/1.1 404 Not Found").header("Server",equalTo("cloudflare"));

     //   Assert.assertEquals("cloudflare",response.header("Server"));
        Assert.assertEquals("{}",response.asString());




    }

}
