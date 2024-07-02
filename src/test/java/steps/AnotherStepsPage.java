package steps;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import utils.CommonMethods;

public class AnotherStepsPage extends CommonMethods {

    public void user_is_navigated_to_hrms_application() {
        //asagidakileri sildik cunku bunlari commenmethods klasinda olusturduk.tekrar tekrar kolayca cagirmak icin
        // WebDriverManager.chromedriver().setup();
        //  driver =new ChromeDriver();
        //  driver.get("http://hrm.syntaxtechs.net/humanresources/symfony/web/index.php/auth/login");
        openBrowserAndLaunchApplication();
    }
    @When("user enters invalid username and password")
    public void user_enters_invalid_username_and_password() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }


    public static class EmployeeSearchSteps extends CommonMethods {



     /*  @When("user clicks on PIM option")
        public void user_clicks_on_pim_option() {
            // Write code here that turns the phrase above into concrete actions
            throw new io.cucumber.java.PendingException();
        }
        @When("user clicks on employee list option")
        public void user_clicks_on_employee_list_option() {

        }
        @When("user enters valid employee id")
        public void user_enters_valid_employee_id() {
            // Write code here that turns the phrase above into concrete actions
            throw new io.cucumber.java.PendingException();
        }
        @When("user clicks on search button")
        public void user_clicks_on_search_button() {
            // Write code here that turns the phrase above into concrete actions
            throw new io.cucumber.java.PendingException();
        }
        @Then("user is able to see the employee")
        public void user_is_able_to_see_the_employee() {
            // Write code here that turns the phrase above into concrete actions
            throw new io.cucumber.java.PendingException();
        }*/
    }
}
