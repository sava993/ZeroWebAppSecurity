package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class TransferFundsPage {
    WebDriver driver;

    WebElement transferFundsIcon;

    WebElement fromAccount;
    WebElement toAccount;

    WebElement amount;

    WebElement description;

    WebElement continueButton;

    WebElement submitButton;

    WebElement successfulTransfer;

    public TransferFundsPage(WebDriver driver) {
        this.driver = driver;
    }

    public WebElement getTransferFundsIcon() {
        return driver.findElement(By.id("transfer_funds_link"));
    }

    public WebElement getFromAccount() {
        return driver.findElement(By.id("tf_fromAccountId"));
    }

    public WebElement getToAccount() {
        return driver.findElement(By.id("tf_toAccountId"));
    }

    public WebElement getAmount() {
        return driver.findElement(By.id("tf_amount"));
    }

    public WebElement getDescription() {
        return driver.findElement(By.id("tf_description"));
    }

    public WebElement getContinueButton() {
        return driver.findElement(By.id("btn_submit"));
    }

    public WebElement getSubmitButton() {
        return driver.findElement(By.id("btn_submit"));
    }

    public WebElement getSuccessfulTransfer() {
        return driver.findElement(By.cssSelector("div[class='alert alert-success']"));
    }

    //===============================

    public void fillAmount(String amount){

        getAmount().sendKeys(amount);
    }

    public void fillDescription(String description){

        getDescription().sendKeys(description);
    }

    public void clickContinue(){
        getContinueButton().click();
    }

    public void clickTransferFundsIcon(){
        getTransferFundsIcon().click();
    }

    public void clickSubmit(){
        getSubmitButton().click();
    }
}
