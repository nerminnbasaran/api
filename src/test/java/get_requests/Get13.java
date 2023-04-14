package get_requests;

import base_urls.DummyRestApiBaseUrl;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.Test;


import java.util.Collections;
import java.util.List;


import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.hasItems;
import static org.hamcrest.Matchers.hasSize;
import static org.junit.Assert.assertEquals;

public class Get13 extends DummyRestApiBaseUrl {
        /*
        Given
            https://dummy.restapiexample.com/api/v1/employees
        When
            User sends Get Request to the Url
        Then
            Status code is 200
        And
            There are 24 employees
        And
            "Tiger Nixon" and "Garrett Winters" are among the employees
        And
            The greatest age is 66
        And
            The name of the lowest age is "[Tatyana Fitzpatrick]"
        And
            Total salary of all employees is 6,644,770
        */

    @Test
    public void get13(){

        //Set the URL
        spec.pathParams("first","api","second","v1","third","employees");

        //Send the request and get the response
        Response response = given(spec).get("{first}/{second}/{third}");
        response.prettyPrint();

        // Status code is 200 -- There are 24 employees -- "Tiger Nixon" and "Garrett Winters" are among the employees
        response.then().
                statusCode(200).
                body("data",hasSize(24),"data.employee_name", hasItems("Tiger Nixon","Garrett Winters"));

        //The greatest age is 66
        JsonPath jsonPath = response.jsonPath();

        List<Integer> ages = jsonPath.getList("data.employee_age");
        System.out.println("ages = " + ages);

        Collections.sort(ages);
        System.out.println("ages = " + ages);

        //size()-1
        assertEquals(66,(int) ages.get(ages.size()-1));

        // The name of the lowest age is "[Tatyana Fitzpatrick]"
        String nameOfLowestAge = jsonPath.getString("data.findAll{it.employee_age=="+ages.get(0)+"}.employee_name");
        System.out.println("nameOfLowestAge = " + nameOfLowestAge);

        assertEquals("[Tatyana Fitzpatrick]",nameOfLowestAge);

        //Total salary of all employees is 6,644,770
        List<Integer> salaries = jsonPath.getList("data.employee_salary");

        //1.way:
        int sum = 0;
        for(int w: salaries){
            sum+=w;
        }
        System.out.println("sum = " + sum);

        assertEquals(6644770,sum);

        //2.way:Programming Language
        int sumOfSalariesLambda = salaries.stream().reduce(0,(t,u)->(t+u));
        System.out.println("sumOfSalariesLambda = " + sumOfSalariesLambda);

        assertEquals(6644770,sumOfSalariesLambda);

        //3.way:
        int sumOfSalariesLambdaSecond = salaries.stream().reduce(0,Math::addExact);
        System.out.println("sumOfSalariesLambdaSecond = " + sumOfSalariesLambdaSecond);

        assertEquals(6644770,sumOfSalariesLambdaSecond);


    }










}
