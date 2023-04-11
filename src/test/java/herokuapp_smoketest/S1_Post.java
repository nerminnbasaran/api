package herokuapp_smoketest;

import base_urls.HerOkuAppBaseUrl;
import io.restassured.response.Response;
import org.junit.Test;
import pojos.BookingDatesPojo;
import pojos.BookingPojo;
import pojos.BookingResponsePojo;
import utils.ObjectMapperUtils;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

public class S1_Post extends HerOkuAppBaseUrl {
    /*
    Given
         https://restful-booker.herokuapp.com/booking
    And
         {
        "firstname" : "Jim",
        "lastname" : "Brown",
        "totalprice" : 111,
        "depositpaid" : true,
        "bookingdates" : {
            "checkin" : "2018-01-01",
            "checkout" : "2019-01-01"
        },
        "additionalneeds" : "Breakfast"
        }
    When
        Send post request
    Then
        Status code should be 200
    And
        Response body should be:

            "bookingid": 5729,
            "booking": {
                "firstname": "Jim",
                "lastname": "Brown",
                "totalprice": 111,
                "depositpaid": true,
                "bookingdates": {
                    "checkin": "2018-01-01",
                    "checkout": "2019-01-01"
                },
                "additionalneeds": "Breakfast"
            }
        }


     */

    public static int bookingId;//We put the created bookingId into a container and use it in other classes.

    @Test
    public void post() {
        spec.pathParam("first", "booking");

        BookingDatesPojo bookingDatesPojo = new BookingDatesPojo("2018-01-01", "2019-01-01");
        BookingPojo expectedData = new BookingPojo("Jim", "Brown", 111, true, bookingDatesPojo, "Breakfast");
        System.out.println("expectedData = " + expectedData);

        Response response = given(spec).body(expectedData).post("{first}");
        response.prettyPrint();

        BookingResponsePojo actualData = ObjectMapperUtils.convertJsonToJavaObject(response.asString(), BookingResponsePojo.class);
        //With convertJsonToJavaObject() method we handled throw exception issue
        System.out.println("actualData = " + actualData);

        assertEquals(200, response.getStatusCode());
        assertEquals(expectedData.getFirstname(), actualData.getBooking().getFirstname());
        assertEquals(expectedData.getLastname(), actualData.getBooking().getLastname());
        assertEquals(expectedData.getTotalprice(), actualData.getBooking().getTotalprice());
        assertEquals(expectedData.getDepositpaid(), actualData.getBooking().getDepositpaid());

        assertEquals(bookingDatesPojo.getCheckin(), actualData.getBooking().getBookingdates().getCheckin());
        assertEquals(bookingDatesPojo.getCheckout(), actualData.getBooking().getBookingdates().getCheckout());

        assertEquals(expectedData.getAdditionalneeds(), actualData.getBooking().getAdditionalneeds());

        bookingId = actualData.getBookingid();




    }
}
