package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage {

    WebDriver driver;
    WebElement signIn;
    WebElement userNameField;
    WebElement passwordField;
    WebElement checkBoxKeepMeSigned;
    WebElement signInButton;
    WebElement error;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    public WebElement getSignIn() {
        return driver.findElement(By.id("signin_button"));
    }

    public WebElement getUserNameField() {
        return driver.findElement(By.id("user_login"));
    }

    public WebElement getPasswordField() {
        return driver.findElement(By.id("user_password"));
    }

    public WebElement getCheckBoxKeepMeSigned() {
        return driver.findElement(By.id("user_remember_me"));
    }

    public WebElement getSignInButton() {
        return driver.findElement(By.cssSelector("input[type='submit']"));
    }

    public WebElement getError() {
        return driver.findElement(By.cssSelector("div[class='alert alert-error']"));
    }

    //=================================

    public void clickSignIn(){
        getSignIn().click();
    }

    public void fillUsernameField(String username){
        getUserNameField().clear();
        getUserNameField().sendKeys(username);
    }

    public void fillPasswordField(String password){
        getPasswordField().clear();
        getPasswordField().sendKeys(password);
    }

    public void clickKeepMeSignedIn(){
        getCheckBoxKeepMeSigned().click();
    }

    public void clickSubmit(){
        getSignInButton().click();
    }
}
