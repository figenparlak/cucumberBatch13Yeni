package steps;


import io.cucumber.datatable.DataTable;
import io.cucumber.java.DataTableType;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import utils.CommonMethods;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

public class DashboardSteps extends CommonMethods {
    @Then("verify all the dashboard tabs")
    public void verify_all_the_dashboard_tabs(DataTable dataTable) {
        //this list is for expected values
        //altsira boyle degildi
        // List<String> expectedTabs =dataTable.asList(); boyleydi
        // asagidaki hatayi aliyordum
        //io.cucumber.datatable.UndefinedDataTableTypeException: Can't convert DataTable to List<java.lang.String>.
       // bende boyle yaptim oldu
         List<String> expectedTabs =  dataTable.transpose().asList();

        //this list is for actual values
        List<String> actualTabs = new ArrayList<>();

        for (WebElement ele: dash.dashboardTabs) {
            //storing the string value of a webelement from application
            actualTabs.add(ele.getText());
        }
        System.out.println(actualTabs);
       System.out.println(expectedTabs);
        //to verify both the list
        Assert.assertTrue(expectedTabs.equals(actualTabs));
          // Assert.assertEquals(error,errorActual);
        //yukarida ustteki assert u kullanmadik cunku bu testte  iki listeyi karsilastiriyoruz
        // yani verify ettik yani iki listenin esit oldugunu onayladik



    }




}