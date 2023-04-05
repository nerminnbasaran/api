package base_urls;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.config.RestAssuredConfig;
import io.restassured.http.*;
import io.restassured.mapper.ObjectMapper;
import io.restassured.mapper.ObjectMapperType;
import io.restassured.specification.RedirectSpecification;
import io.restassured.specification.RequestSpecification;
import org.junit.Before;

import java.io.File;
import java.io.InputStream;
import java.security.KeyStore;
import java.util.Collection;
import java.util.Map;

public class GorestBaseUrl {

    protected RequestSpecification spec;

    @Before
    public void setUp(){

        spec = new RequestSpecBuilder().setContentType(ContentType.JSON).setBaseUri("https://gorest.co.in/public/v1").build();




    }
}
