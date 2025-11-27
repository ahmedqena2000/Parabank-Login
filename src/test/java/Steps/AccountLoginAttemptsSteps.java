package Steps;

import MyPages.AccountLoginAttempts;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import Hooks.hooksClass;
import org.testng.Assert;

import java.time.Duration;

public class AccountLoginAttemptsSteps {
    WebDriverWait wait;
    AccountLoginAttempts accountLoginAttempts;

   @Given("the user is on the Login page")
   public void navigateToLoginPage(){
       accountLoginAttempts=new AccountLoginAttempts(hooksClass.driver);
       wait= new WebDriverWait(hooksClass.driver, Duration.ofSeconds(3));
       wait.until(ExpectedConditions.visibilityOf(accountLoginAttempts.getLoginTitle()));
   }
   @When("the user entered invalid {string} and invalid {string}")
   public void enterUserCredentials(String Username, String Password) {
       accountLoginAttempts.enterUserName(Username);
       accountLoginAttempts.enterPassword(Password);
   }

   @And("user clicked on login button")
    public void clickLogin(){
    wait.until(ExpectedConditions.elementToBeClickable(accountLoginAttempts.getLoginButton()));
    accountLoginAttempts.clickLoginButton();

    accountLoginAttempts.clearUsername();
    accountLoginAttempts.clearPassword();
   }

   @Then("the system should display that the account is locked")
    public void verifyExceedingAllowedAttempts(){
      wait.until(ExpectedConditions.visibilityOf(accountLoginAttempts.getErrorMessage()));
      String message= accountLoginAttempts.getErrorLoginMessage();
       Assert.assertEquals(message,"Account is locked due failed login");
   }

}
