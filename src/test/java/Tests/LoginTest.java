package Tests;

import Base.Base;
import Pages.HomePage;
import Pages.LoginPage;
import Pages.TransferFundsPage;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class LoginTest extends Base {


    @BeforeMethod
    public void pageSetUp(){
        driver= new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        driver.manage().window().maximize();

        driver.get("http://zero.webappsecurity.com");


        loginPage = new LoginPage(driver);
        homePage = new HomePage(driver);
        transferFundsPage= new TransferFundsPage(driver);


    }



    @Test
    public void userCanLogInWithValidCredentials(){
        loginPage.clickSignIn();
        loginPage.fillUsernameField("username");
        loginPage.fillPasswordField("password");
        loginPage.clickKeepMeSignedIn();
        loginPage.clickSubmit();


        driver.navigate().back();

        Assert.assertEquals(driver.getCurrentUrl(), "http://zero.webappsecurity.com/index.html");
        Assert.assertTrue(homePage.getUsernameIcon().isDisplayed());


    }

    @Test
    public void userCannotLogInWithInvalidCredentials(){
        loginPage.clickSignIn();
        loginPage.fillUsernameField("invalidusername");
        loginPage.fillPasswordField("invalidpassword");
        loginPage.clickKeepMeSignedIn();
        loginPage.clickSubmit();

        Assert.assertEquals(loginPage.getError().getText().trim(), "Login and/or password are wrong.");

        Assert.assertEquals(driver.getCurrentUrl(), "http://zero.webappsecurity.com/login.html?login_error=true");
    }

    @Test
    public void userCanLogOut() throws InterruptedException {
        loginPage.clickSignIn();
        loginPage.fillUsernameField("username");
        loginPage.fillPasswordField("password");
        loginPage.clickKeepMeSignedIn();
        loginPage.clickSubmit();


        driver.navigate().back();

        driver.wait(3000);

        homePage.clickUsernameDropdown();  //ispraviti
        homePage.clickLogOut();


    }

}
