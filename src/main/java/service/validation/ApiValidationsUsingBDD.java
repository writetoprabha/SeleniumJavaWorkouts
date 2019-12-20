package service.validation;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.hasXPath;

public class ApiValidationsUsingBDD {

    @Test(enabled = true)
    public void getCityWeather(){
        given()
        .when()
            .get("http://restapi.demoqa.com/utilities/weather/city/Hyderabad")
        .then()
            .body("City", equalTo("Hyderabad"))
            .statusCode(200)
            .header("Content-Type", "application/json")
            .log().all();
    }

    @Test(enabled = true)
    public void postRegisterCustomer() {

        JSONObject requestPayload = new JSONObject();
        requestPayload.put("FirstName", "aslkdjfla");
        requestPayload.put("LastName", "alsdjflkasg");
        requestPayload.put("UserName", "alskdfjlasigh");
        requestPayload.put("Password", "asldgasgfa");
        requestPayload.put("Email", "asldfkjalsf@gmail.com");

        given()
            .header("Content-Type", "application/json")
            .body(requestPayload.toJSONString())
        .when()
            .post("http://restapi.demoqa.com/customer/register")
        .then()
            .statusCode(200)
            .body("fault", equalTo("FAULT_USER_ALREADY_EXISTS"))
            .log().all();
    }

    @Test(enabled = true)
    public void getCustomerListInXml(){
        given()
        .when()
            .get("http://thomas-bayer.com/sqlrest/CUSTOMER/")
        .then()
            .statusCode(200)
            .body(hasXPath("/CUSTOMERList/CUSTOMER[text()=23]"))
            .header("Content-Type", "application/xml")
            .log().all();

        given()
        .when()
            .get("http://thomas-bayer.com/sqlrest/CUSTOMER/15")
        .then()
            .statusCode(200)
            .body("CUSTOMER.text()", equalTo("15BillClancy319 Upland Pl.Seattle"))
            .log().all();
    }

}
