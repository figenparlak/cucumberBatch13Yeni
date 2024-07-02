package steps;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.DashBoardPage;
import pages.EmployeeInformationPage;
import utils.CommonMethods;

import static utils.CommonMethods.click;

public class EmployeeSearchSteps extends CommonMethods {


    @When("user clicks on PIM option")
    public void user_clicks_on_pim_option() {
       // DashBoardPage dash= new DashBoardPage();
        click(dash.pimOption);
    }
    @When("user clicks on employee list option")
    public void user_clicks_on_employee_list_option() {
       //  DashBoardPage dash= new DashBoardPage();
         click(dash.addEmployeeOption);
    }
    @When("user enters valid employee id")
    public void user_enters_valid_employee_id() {
       // EmployeeInformationPage emp = new EmployeeInformationPage();
        sendText(emp.idEmployeeSearch,"33405969");

    }
    @When("user clicks on search button")
    public void user_clicks_on_search_button() {
       // EmployeeInformationPage emp = new EmployeeInformationPage();
        click(emp.searchBtn);

    }
    @Then("user is able to see the employee")
    public void user_is_able_to_see_the_employee() {

        System.out.println("gecti");

    }

    @When("user enters name of the employee")
    public void user_enters_name_of_the_employee() {
        sendText(emp.nameEmployeeSearch,"kirmizi");


    }

}
