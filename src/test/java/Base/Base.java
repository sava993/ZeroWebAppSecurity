package Base;

import Pages.HomePage;
import Pages.LoginPage;
import Pages.TransferFundsPage;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.BeforeClass;

public class Base {

    public WebDriver driver;
    public WebDriver wait;

    public LoginPage loginPage;
    public HomePage homePage;
    public TransferFundsPage transferFundsPage;


    @BeforeClass
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.setAcceptInsecureCerts(true);
        options.addArguments("--ignore-certificate-errors");
    }
}
