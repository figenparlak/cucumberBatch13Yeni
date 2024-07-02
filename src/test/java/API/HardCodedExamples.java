package API;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import org.junit.Assert;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.* ;// alttaki gibi yapinca body de sorun cikiyor
//import static org.hamcrest.CoreMatchers.equalTo;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class HardCodedExamples {
   // bu clasta yaptiklarimiz hardcode ornegi .cucumberla yapmiyoruz
    String baseURI=RestAssured.baseURI="http://hrm.syntaxtechs.net/syntaxapi/api";

    //CRUD operation we perfom
    // allttaki token 12 saatte bir  gecersis oluyor postmandan yenileyeceksin unutma

    String token ="Bearer eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJpYXQiOjE3MTE2NTUzNjEsImlzcyI6ImxvY2FsaG9zdCIsImV4cCI6MTcxMTY5ODU2MSwidXNlcklkIjoiNjUzMyJ9.VXfyZ8VfvcNhEjvbISe7G3zj0irQtwBGrkTH7ZLGZh8";
    static String employee_id ;

    @Test
    public  void bgetCreatedEmployee(){
        RequestSpecification preparedRequest = given().header("Content-Type", "application/json").header("Authorization" ,token).queryParam("employee_id" ,employee_id);
        Response response =preparedRequest.when().get( "/getOneEmployee.php");
        response.prettyPrint();

    }
    //cucumber kullanmiyoaz suan.@Test org.junit ten
       @Test //org.junit
    // to create normal/reguler employee
    public  void  acreateEmployee(){
           RequestSpecification prepareRequest = given().header("Content-Type", "application/json").
                   header("Authorization", token).body( "{\n" +
                           "  \"emp_firstname\": \"Esen\",\n" +
                           "  \"emp_lastname\": \"gungor\",\n" +
                           "  \"emp_middle_name\": \"purki\",\n" +
                           "  \"emp_gender\": \"F\",\n" +
                           "  \"emp_birthday\": \"2001-01-01\",\n" +
                           "  \"emp_status\": \"normal\",\n" +
                           "  \"emp_job_title\": \"QA test \"\n" +
                           "}");

           // hitting the endpoint
           Response response = prepareRequest.when().post("/createEmployee.php");
           response.prettyPrint();

           //assertions and validation
           // Verifying the correct status code of the request
           response.then().assertThat().statusCode(201);
           response.then().assertThat().body("Employee.emp_middle_name", equalTo("purki"));
           response.then().assertThat().body("Employee.emp_firstname", equalTo("Esen"));
           response.then().assertThat().body("Employee.emp_lastname", equalTo("gungor"));
           response.then().assertThat().body("Message", equalTo("Employee Created"));

           //verifying the response headers
           response.then().assertThat().header("Server", "Apache/2.4.39 (Win64) PHP/7.2.18");

           //to get the employee id from the body
           employee_id = response.jsonPath().getString("Employee.employee_id");
           System.out.println(employee_id);
       }
@Test
       public  void  cupdateEmployee(){
// DIKKAAT postmanda employee olusturunca response ta gender cikmiyo burada ben ekledim esik olamaz body
        RequestSpecification prepareRequest = given().header("Content-Type", "application/json" )
                .header("Authorization", token).body( " {\n" +
                        "        \"employee_id\": \""+employee_id+"\",\n" +
                        "        \"emp_firstname\": \"Esen2\",\n" +
                        "         \"emp_gender\": \"M\",\n" +
                        "        \"emp_middle_name\": \"purki2\",\n" +
                        "        \"emp_lastname\": \"gungor2\",\n" +
                        "        \"emp_birthday\": \"2023-05-05\",\n" +
                        "        \"emp_job_title\": \"QA \",\n" +
                        "        \"emp_status\": \"normaly\"\n" +
                        "    }" );
        Response response= prepareRequest.when().put("/updateEmployee.php");
        //response.prettyPrint();

        response.then().assertThat().statusCode(200);
       }
@Test
       public void dupdatedEmployee(){

        RequestSpecification  prepareRequest= given().header("Content-Type", "application/json").header("Authorization",token).queryParam("employee_id",employee_id);
        Response responce = prepareRequest.when().get("/getOneEmployee.php");
        responce.prettyPrint();
   //  BAK ONEMLIIII!!!! asagidaki satirda body icinde ("employee.emp_lastname") kucuk harfle employee yazdik create metodunda buyuk hafle basliyordu.
    //  clasi run edersen consoldaki response badilerdede aynisini gorurusun
        responce.then().assertThat().body("employee.emp_lastname",equalTo("gungor2"));

       }




}
