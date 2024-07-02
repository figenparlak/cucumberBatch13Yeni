package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.CommonMethods;

public class LoginPage extends CommonMethods {
    @FindBy(id="txtUsername")
    public WebElement usernameTextField;

    @FindBy(id="txtPassword")
    public WebElement passwordTextField;

    @FindBy(id="btnLogin")
    public WebElement loginButton;

    @FindBy(id="spanMessage")
    public WebElement error1;

    //bu bir constructer
    public LoginPage(){


      // Sayfa Nesne Modeli, bir web sayfasında erişilebilen web öğeleri için bir nesne deposu oluşturmak için
        // kullanılan bir tasarım modelidir.
        // Sayfa nesnelerini tanımlamak için By ek açıklamasını kullanır ve
        // her nesnenin başlatılması gerekir. POM'un ayrıca önbellek depolama alanı da vardır
        //Page Factory ise POM'u basitçe uygulayan bir sınıftır.
        // Optimizasyon açısından Page Factory, POM'dan daha optimize edilmiştir.
        // Sayfa nesneleri için FindBy ek açıklamasını kullanır .
        // Her nesne POM gibi başlatma gerektirmez ve tüm öğeler initElements() ile başlatılır .
        // İhtiyaç duymadığından önbellek depolama alanı yoktur.
        PageFactory.initElements(driver,this);
    }

}
