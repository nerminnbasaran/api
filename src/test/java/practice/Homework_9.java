package practice;

import base_urls.PetStoreBaseUrl;
import io.restassured.response.Response;
import org.junit.Test;
import pojos.PetCategoryPojo;
import pojos.Petpojo;

import static io.restassured.RestAssured.given;

public class Homework_9 extends PetStoreBaseUrl {

    //Using the https://petstore.swagger.io/ document, write an automation test that finds the number of "pets"
    // with a status of "available" and asserts that those are more than 100.

    //

    //https://petstore.swagger.io/v2/pet/findByStatus?status=available
    @Test
    public void h9(){
        spec.pathParams("first","v2","second","pet","third","findByStatus?status=available");

       Petpojo expectedData = new Petpojo("available");
        System.out.println("expectedData = " + expectedData);

       Response response= given(spec).body(expectedData).get("{first}/{second}/{third}");
       response.prettyPrint();

      Petpojo actualData = response.as(Petpojo.class);
        System.out.println("actualData = " + actualData);


    }

}
