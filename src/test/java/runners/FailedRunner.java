package runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        //features we use to provide the path of all the features file
        features = "@target/failed.txt",
        //glue is where we find implementations for gherkin steps
        //we provide the path of package where we defined all the steps

        // glue yu yazdiktan sonra artik RunnerClass i calistirsanda steps ler cikmiyor
        glue = "steps",



        plugin = {"pretty",}




)



public class FailedRunner {
}
