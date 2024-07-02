package steps;

import pages.AddEmplooyeePage;
import pages.DashBoardPage;
import pages.EmployeeInformationPage;
import pages.LoginPage;
import utils.Constants;

public class PageInitializer {

    public static LoginPage login;
    public static EmployeeInformationPage emp;
    public  static DashBoardPage dash;

    public static AddEmplooyeePage addEmployeePage;



    public static void initializePageObjects(){

       login= new LoginPage();
       emp= new EmployeeInformationPage();
       dash= new DashBoardPage();
       addEmployeePage = new AddEmplooyeePage();


    }

}
