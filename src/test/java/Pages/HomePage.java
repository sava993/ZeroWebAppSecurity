package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomePage {
    WebDriver driver;

    WebElement usernameIcon;

    WebElement logOut;

    WebElement usernameDropdown;

    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    public WebElement getUsernameIcon() {
        return driver.findElement(By.cssSelector("i[class='icon-user']"));
    }

    public WebElement getLogOut() {
        return driver.findElement(By.id("logout_link"));
    }

    public WebElement getUsernameDropdown() {
        return driver.findElement(By.cssSelector("b[class='caret']"));
    }

    //==================================

    public void clickUsernameIcon(){
        getUsernameIcon().click();
    }

    public void clickLogOut(){
        getLogOut().click();
    }

    public void clickUsernameDropdown(){
        getUsernameDropdown().click();
    }
}
