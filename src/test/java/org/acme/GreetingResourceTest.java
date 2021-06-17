package org.acme;

import io.quarkus.test.junit.QuarkusTest;
import java.util.logging.Logger;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static java.util.logging.Level.INFO;
import static java.util.logging.Level.SEVERE;
import static java.util.logging.Level.WARNING;
import static org.hamcrest.CoreMatchers.is;

@QuarkusTest
public class GreetingResourceTest {

    private static final Logger LOG = Logger.getLogger("Access");

    @Test
    public void testHelloEndpoint() {

        LOG.log(INFO, "test info");
        LOG.log(WARNING, "test warning");
        LOG.log(SEVERE, "test severe");

        given()
          .when().get("/hello-resteasy")
          .then()
             .statusCode(200)
             .body(is("Hello RESTEasy"));
    }

}