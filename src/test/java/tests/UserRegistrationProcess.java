package tests;

import com.github.javafaker.Faker;
import org.testng.annotations.Test;
import requestBuilder.ApiRequestBuilder;
import static org.hamcrest.CoreMatchers.equalTo;


public class UserRegistrationProcess {
    static String registeredEmail;

    @Test()
    public void userRegistration(){
        registeredEmail = Faker.instance().internet().emailAddress();
        ApiRequestBuilder.registerUserResponse("Register","Jsonapi",registeredEmail,"@12345678", "1deae17a-c67a-4bb0-bdeb-df0fc9e2e526")
                .then()
                .log().all()
                .assertThat()
                .statusCode(201)
                .body("success", equalTo(true));
    }

    @Test(priority = 1)
    public void adminLoginTest(){

        ApiRequestBuilder.loginUserResponse("admin@gmail.com", "@12345678")
                .then()
                .log().all()
                .assertThat()
                .statusCode(200)
                .body("success", equalTo(true));
    }

    @Test(priority = 2 , dependsOnMethods = "adminLoginTest")
    public void approveUserRegistration(){
        ApiRequestBuilder.approveUserRegistrationResponse()
                .then()
                .log().all()
                .assertThat()
                .statusCode(200)
                .body("success", equalTo(true));
    }

    @Test(priority = 3, dependsOnMethods = "approveUserRegistration")
    public void role(){
        ApiRequestBuilder.roleResponse("admin")
                .then()
                .log().all()
                .assertThat()
                .statusCode(200)
                .body("success", equalTo(true));
    }

    @Test(priority = 4,dependsOnMethods = "approveUserRegistration")
    public void userLoginTest(){

        ApiRequestBuilder.loginNewUserResponse(registeredEmail, "@12345678")
                .then()
                .log().all()
                .assertThat()
                .statusCode(200)
                .body("success", equalTo(true));
    }


    @Test(priority = 5, dependsOnMethods = "role")
    public void deleteTheNewUser(){
        ApiRequestBuilder.deleteUserResponse()
                .then()
                .log().all()
                .assertThat()
                .statusCode(200)
                .body("success", equalTo(true));
    }

}
