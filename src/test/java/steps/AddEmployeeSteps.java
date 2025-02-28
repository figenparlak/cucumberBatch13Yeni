package steps;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utils.CommonMethods;
import utils.Constants;
import utils.ExcelReader;

import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class AddEmployeeSteps extends CommonMethods {

    @When("user clicks on add employee option")
    public void user_clicks_on_add_employee_option() {
    click(dash.addEmployeeOption);
    }
    @When("user enters firstName , middleName and lastName")
    public void user_enters_first_name_middle_name_and_last_name() {
        sendText(addEmployeePage.firstName ,"zeyno");
        sendText(addEmployeePage.middleName ,"purki");
        sendText(addEmployeePage.lastName ,"bright");
    }
    @When("user clicks on save button")
    public void user_clicks_on_save_button() {
        click(addEmployeePage.saveButton);
    }
    @Then("employee added successfully")
    public void employee_added_successfully() {
        //homework - verify added employee
        System.out.println("Employee added");
    }
    @When("user enters {string} , {string} and {string}")
    //firsname middlename ve lastname i biz duzelttik string 1 2 3 yaziyordu
    public void user_enters_and(String firstName, String middleName, String lastname) {

        sendText(addEmployeePage.firstName,firstName);
        sendText(addEmployeePage.middleName,middleName);
        sendText(addEmployeePage.lastName,lastname);

    }

    @When("user enter {string} , {string} and {string}")
    public void user_enter_and(String fn, String mn, String ln) {

        sendText(addEmployeePage.firstName,fn);
        sendText(addEmployeePage.middleName , mn);
        sendText(addEmployeePage.lastName ,ln);

    }

  //  public void user_adds_multiple_employees_and_verify_they_are_added(io.cucumber.datatable.DataTable dataTable) {
    // basta asagidaki boyleydi biz degistirdik
    @When("user adds multiple employees and verify they are added")
    public void user_adds_multiple_employees_and_verify_they_are_added(DataTable dataTable) throws InterruptedException {
       // List<Map< String ,String>> olanini sectik
        //to  get the data from feature file in the form of list of maps
        // burada asagidaki list map in ornegi var https://onecompiler.com/java/3urmp9w25
            List<Map<String,String>> employeeNames = dataTable.asMaps();

            for (Map<String, String> emp:
                    employeeNames) {
                String firstNameValue =  emp.get("firstName");
                String middleNameValue = emp.get("middleName");
                String lastNameValue = emp.get("lastName");

                //it will enter fresh values after each iteration
                sendText(addEmployeePage.firstName, firstNameValue);
                sendText(addEmployeePage.middleName, middleNameValue);
                sendText(addEmployeePage.lastName, lastNameValue);

                click(addEmployeePage.saveButton);

                //we dont want to execute hooks multiple time
                //we dont want to execute background multiple time
                //we will click on add employee option to add another employee till
                //the time we are getting fresh values from feature file
                Thread.sleep(2000);
                click(dash.addEmployeeOption);
                Thread.sleep(2000);

                //verify that the employee added

            }

        }

    @When("user adds multiple employees from excel file using {string} sheet and verify the employee has added")
    public void user_adds_multiple_employees_from_excel_file_using_sheet_and_verify_the_employee_has_added(String sheetName) throws InterruptedException {

        List<Map<String, String>> newEmployees = ExcelReader.excelListIntoMap(Constants.TEST_DATA_FILEPATH, sheetName);

        Iterator<Map<String, String>> itr = newEmployees.iterator();
        while (itr.hasNext()){
            Map<String, String> mapNewEmp = itr.next();
            sendText(addEmployeePage.firstName, mapNewEmp.get("firstName"));
            sendText(addEmployeePage.middleName, mapNewEmp.get("middleName"));
            sendText(addEmployeePage.lastName, mapNewEmp.get("lastName"));

            sendText(addEmployeePage.photograph, mapNewEmp.get("photogr aph"));
            if(!addEmployeePage.checkBox.isSelected()){
                click(addEmployeePage.checkBox);
            }

            sendText(addEmployeePage.usernameEmployee, mapNewEmp.get("username"));
            sendText(addEmployeePage.passwordEmployee, mapNewEmp.get("password"));
            sendText(addEmployeePage.confirmPasswordEmployee, mapNewEmp.get("confirmPassword"));

             // ID number degeri(value) sitede otomatik olarak veriliyor.onu almak icin yadik.her kaydedilen icin
           String empIdValue= addEmployeePage.empIdLoc.getAttribute("value");
            System.out.println(empIdValue);
            //Thread.sleep(8000);
            click(addEmployeePage.saveButton);

            //till this point we have added the employee and captured the emp id
            Thread.sleep(4000);
            //  click(dash.employeeListOption);
            jsClick(dash.employeeListOption);
            Thread.sleep(8000);

            sendText(emp.idEmployeeSearch, empIdValue);
            Thread.sleep(8000);
            //click(emp.idEmployeeSearch);
            jsClick(emp.searchBtn);

            //verify the details of my employee
            //verifying firstname middlename and lastname

            List<WebElement> rowData =  driver.findElements(By.xpath("//table[@id='resultTable']/tbody/tr"));

            for (int i=0; i<rowData.size(); i++){
                System.out.println("I am inside the loop");

                //this line is going to return text of every single row for the element available in it
                String rowText = rowData.get(i).getText();
                System.out.println(rowText);

                String expectedData =  empIdValue + " " + mapNewEmp.get("firstName") + " " +
                        mapNewEmp.get("middleName") + " " + mapNewEmp.get("lastName");

                System.out.println(expectedData);
                Assert.assertEquals(expectedData, rowText);

            }


/*
           //kaydettik kisiyi
          click(addEmployeePage.saveButton);



         //aldigimiz ID value yi verify etmek icicn employi liste tikladik
            Thread.sleep(4000);

         // click(dash.employeeListOption);
          jsClick(dash.employeeListOption);
         //aldigimiz ID degerini yerine gonderdik
            Thread.sleep(4000);
          sendText(emp.idEmployeeSearch,emIdValue);
          click(emp.idEmployeeSearch);

            //verify the details of my employee
            //verifying firstname middlename and lastname
            List<WebElement> rowData =  driver.findElements(By.xpath("//table[@id='resultTable']/tbody/tr"));
            System.out.println(rowData.size());
            for (int i=0; i<rowData.size(); i++){
                System.out.println("I am inside the loop");

                //this line is going to return text of every single row for the element available in it
                String rowText = rowData.get(i).getText();
                System.out.println(rowText);}*/


            //assertion in homework
            Thread.sleep(2000);
            click(dash.addEmployeeOption);

        }


    }


}





