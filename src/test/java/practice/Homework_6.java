package practice;

import base_urls.ReqresBaseUrl;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.Assert;
import org.junit.Test;
import org.testng.asserts.SoftAssert;

import java.util.List;
import java.util.ListResourceBundle;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

public class Homework_6 extends ReqresBaseUrl {
    /*
       Given
              https://reqres.in/api/unknown/
       When
            I send GET Request to the URL
       Then

            1)Status code is 200
            2)Print all pantone_values
            3)Print all ids greater than 3 on the console
              Assert that there are 3 ids greater than 3
            4)Print all names whose ids are less than 3 on the console
              Assert that the number of names whose ids are less than 3 is 2
    */

    @Test
    public void h6(){
        //Set the URL
        spec.pathParam("first","unknown");

        //Send the request and get the response
        Response response =given(spec).get("/{first}");
        response.then().statusCode(200).contentType(ContentType.JSON);

        //Do assertion
        // 1)Status code is 200
       response.then().assertThat().statusCode(200);
        //assertEquals(200,response.statusCode());
        //2)Print all pantone_values
        JsonPath jsonPath = response.jsonPath();
        List<String> pantoneValues = jsonPath.getList("data.pantone_value");
        System.out.println("pantoneValues = " + pantoneValues);

        //3)Print all ids greater than 3 on the console
        List<Integer> idList = jsonPath.getList("data.findAll{it.id>3}.id");
        System.out.println("idList = " + idList);

        //Assert that there are 3 ids greater than 3
        assertEquals(3,idList.size());
        //4)Print all names whose ids are less than 3 on the console
        List<String> namesList = jsonPath.getList("data.findAll{it.id<3}.name");
        System.out.println("namesList = " + namesList);
        //Assert that the number of names whose ids are less than 3 is 2
        assertEquals(2,namesList.size());
    }
}
