package herokuapp_smoketest;

import base_urls.HerOkuAppBaseUrl;
import io.restassured.response.Response;
import org.junit.Test;
import pojos.BookingDatesPojo;
import pojos.BookingPojo;
import utils.ObjectMapperUtils;

import static herokuapp_smoketest.S1_Post.bookingId;
import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

public class S3_Get extends HerOkuAppBaseUrl {
    /*
    Given
        https://restful-booker.herokuapp.com/booking/{id}
    When
        Send get request
    Then
        Status code should be 200
    And
        Body should be :
           {
            "firstname": "Mark",
            "lastname": "Twain",
            "totalprice": 555,
            "depositpaid": false,
            "bookingdates": {
                "checkin": "2023-01-01",
                "checkout": "2024-01-01"
            },
            "additionalneeds": "Extra Pillow"
          }
     */

    @Test
    public void getTest() {
        //Set the url
        spec.pathParams("first", "booking", "second", bookingId );

        //Set the expected data
        BookingDatesPojo bookingDatesPojo = new BookingDatesPojo("2023-01-01","2024-01-01");
        BookingPojo expectedData = new BookingPojo("Mark","Twin",555,false,bookingDatesPojo,"Extra Pillow");
        System.out.println("expectedData = " + expectedData);

        //Send the request and get the response
        Response response = given(spec).get("{first}/{second}");
        response.prettyPrint();

        //Do Assertion
        BookingPojo actualData = ObjectMapperUtils.convertJsonToJavaObject(response.asString(),BookingPojo.class);
        System.out.println("actualData = " + actualData);

        assertEquals(200, response.getStatusCode());

        assertEquals(expectedData.getFirstname(), actualData.getFirstname());
        assertEquals(expectedData.getLastname(), actualData.getLastname());
        assertEquals(expectedData.getTotalprice(), actualData.getTotalprice());
        assertEquals(expectedData.getDepositpaid(), actualData.getDepositpaid());
        assertEquals(bookingDatesPojo.getCheckin(), actualData.getBookingdates().getCheckin());
        assertEquals(bookingDatesPojo.getCheckout(), actualData.getBookingdates().getCheckout());
        assertEquals(expectedData.getAdditionalneeds(), actualData.getAdditionalneeds());


    }
}
