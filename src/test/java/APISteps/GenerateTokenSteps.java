package APISteps;

import io.cucumber.java.en.Given;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import utils.CommonMethods;

import static io.restassured.RestAssured.given;

public class GenerateTokenSteps   {

    String baseURI = RestAssured.baseURI = "http://hrm.syntaxtechs.net/syntaxapi/api";
    public static String token;

    @Given("a JWT is generated")
    public void a_jwt_is_generated() {
        RequestSpecification preparedRequest = given().header("Content-Type", "application/json").body("{\n" +
                "  \"email\": \"batch1334@abc.com\",\n" +
                "  \"password\": \"1231234pt\"\n" +
                "}");
        Response responce = preparedRequest.when().post("/generateToken.php");
    // alt satirda parantes icindeki token postmenda token olustururken aldigimiz response taki key olan token
       token ="Bearer " + responce.jsonPath().getString("token");
        System.out.println(token);
    }

}
