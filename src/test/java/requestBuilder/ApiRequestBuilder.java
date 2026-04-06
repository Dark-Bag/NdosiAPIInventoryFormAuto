package requestBuilder;

import io.restassured.RestAssured;
import io.restassured.response.Response;

import static common.BaseURIs.baseURL;
import static payloadBuilder.PayloadBuilder.*;

public class ApiRequestBuilder {

    static String authToken;
    static String registeredUserId;

    public static Response loginUserResponse(String email, String password) {

        String apiPath = "/APIDEV/login";
        Response response = RestAssured.given()
                .baseUri(baseURL)
                .basePath(apiPath)
                .header("Content-Type", "application/json")
                .body(loginPayload(email, password))
                .log().all()
                .post()
                .then().extract().response();
        authToken = response.jsonPath().getString("data.token");
        return response;
    }

    public static Response registerUserResponse(String firstName, String lastName, String email, String password, String groupId) {

        String apiPath = "/APIDEV/register";
        Response response = RestAssured.given()
                .baseUri(baseURL)
                .basePath(apiPath)
                .header("Content-Type", "application/json")
                .body(registerUserPayload(firstName, lastName, email, password, groupId))
                .log().all()
                .post()
                .then().extract().response();
        registeredUserId = response.jsonPath().getString("data.id");
        return response;
    }

    public static Response approveUserRegistrationResponse() {

        String apiPath = "/APIDEV/admin/users/"+registeredUserId+"/approve";
        return RestAssured.given()
                .baseUri(baseURL)
                .basePath(apiPath)
                .header("Content-Type", "application/json")
                .header("Authorization", "Bearer " + authToken)
                .log().all()
                .put()
                .then().extract().response();
    }

    public static Response roleResponse(String role) {

        String apiPath = "/APIDEV/admin/users/"+registeredUserId+"/role";
        return RestAssured.given()
                .baseUri(baseURL)
                .basePath(apiPath)
                .header("Content-Type", "application/json")
                .header("Authorization", "Bearer " + authToken)
                .log().all()
                .body(role(role))
                .put()
                .then().extract().response();
    }


    public static Response deleteUserResponse() {

        String apiPath = "/APIDEV/admin/users/"+registeredUserId+"";
        return RestAssured.given()
                .baseUri(baseURL)
                .basePath(apiPath)
                .header("Content-Type", "application/json")
                .header("Authorization", "Bearer " + authToken)
                .log().all()
                .delete()
                .then().extract().response();
    }

    public static Response loginNewUserResponse(String email, String password) {

        String apiPath = "/APIDEV/login";
        Response response = RestAssured.given()
                .baseUri(baseURL)
                .basePath(apiPath)
                .header("Content-Type", "application/json")
                .body(loginPayload(email, password))
                .log().all()
                .post()
                .then().extract().response();
        return response;
    }


}
