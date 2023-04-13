package utils;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;

public class AuthenticationGmiBank {

    public static String gmiBankToken(){

        /*
        {
         "password": "Mark.123",
         "rememberMe": true,
         "username": "mark_twain"
         }
         */
        Map<String,Object> postBody = new HashMap<>();
        postBody.put("password","Mark.123");
        postBody.put("mark_twain")
        given().body().post("https://gmibank.com/api/authenticate");

    }
}
