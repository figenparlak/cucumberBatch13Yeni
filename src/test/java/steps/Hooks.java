package steps;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import utils.CommonMethods;

public class Hooks extends CommonMethods {
    // hooks klasinda yurutmeden once ve sonra calistilmasi gerekenler oluyor
    @Before
    public void start(){

        openBrowserAndLaunchApplication();
    }
    @After
    //scenario class from cucumber holds the complete information of the execution
    // simdi burada kapanistan hemen once screenShot alinmasini istiyorz.
    // commonmethods taki date alma ve takescreenshot metodlarina baglanarak
    // screenshot alinmasini sagliyoruz
    public void close(Scenario scenario){
        byte[] pic;

        if(scenario.isFailed()){
        // scenario.getname stepslerdeki hangi scenario yu yurutuyorsak onun adini aliyor
            pic = takeScreenshot("failed/" + scenario.getName());
        }else{
            pic = takeScreenshot("passed/" + scenario.getName());
        }

        //it will attach the screenshot in report
        //pic holds the screenshot, image/png defines the extesnion of image
        //scenario.getname is to provide the name
        scenario.attach(pic, "image/png", scenario.getName());





        closeBrowser();
    }



}
