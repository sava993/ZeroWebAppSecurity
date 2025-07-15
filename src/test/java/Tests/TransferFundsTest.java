package Tests;

import Base.Base;
import Pages.HomePage;
import Pages.LoginPage;
import Pages.TransferFundsPage;
import org.junit.Assert;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class TransferFundsTest extends Base {

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
    public void transferFundsToSavings() throws InterruptedException {
        loginPage.clickSignIn();
        loginPage.fillUsernameField("username");
        loginPage.fillPasswordField("password");
        loginPage.clickKeepMeSignedIn();
        loginPage.clickSubmit();


        driver.navigate().back();

        transferFundsPage.clickTransferFundsIcon();
        transferFundsPage.fillAmount("3000");
        transferFundsPage.fillDescription("savings");
        transferFundsPage.clickContinue();
        driver.wait(1000);
        transferFundsPage.clickSubmit(); //ispraviti

        Assert.assertEquals(transferFundsPage.getSuccessfulTransfer().getText().trim(), "You successfully submitted your transaction.");
    }

}
