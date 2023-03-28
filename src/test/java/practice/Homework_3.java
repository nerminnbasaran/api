package practice;

import base_urls.ReqresBaseUrl;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.Test;
import org.testng.asserts.SoftAssert;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class Homework_3 extends ReqresBaseUrl {
    /*
       Given
           https://reqres.in/api/users/2
       When
           User send GET Request to the URL
       Then
           HTTP Status Code should be 200
       And
           Response format should be “application/json”
       And
           “email” is “janet.weaver@reqres.in”,
       And
           “first_name” is "Janet"
       And
           “last_name” is "Weaver"
       And
           "text" is "To keep ReqRes free, contributions towards server costs are appreciated!"
    */
    @Test
    public void h3(){
        //Set the URL
        spec.pathParams("first","api","second","users","third",2);

        //Set the expected data

        //Send the request and get the response
        Response response =given(spec).when().get("{first}/{second}/{third}");
        response.prettyPrint();

        //Do Assertion
        response.then().statusCode(200).contentType(ContentType.JSON).body("data.email",equalTo("janet.weaver@reqres.in"),
                "data.first_name",equalTo("Janet"),
                "data.last_name",equalTo("Weaver"),
                "support.text",equalTo("To keep ReqRes free, contributions towards server costs are appreciated!"));
        //With Soft Assertion
        JsonPath jsonPath = response.jsonPath();
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(jsonPath.getString("email"),"janet.weaver@reqres.in");
        softAssert.assertEquals(jsonPath.getString("first_name"),"Janet");
        softAssert.assertEquals(jsonPath.getString("last_name"),"Weaver");
        softAssert.assertEquals(jsonPath.getString("text"),"To keep ReqRes free, contributions towards server costs are appreciated!");


    }
}
