package Steps;

import Hooks.hooksClass;
import MyPages.RegisterPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class RegisterSteps{
    WebDriverWait wait;

    RegisterPage registerPage = new RegisterPage(hooksClass.driver);

    @Given("the user is on the Registration page")
    public void CheckOnRegisterPage(){
        Assert.assertEquals(registerPage.getSigningUpWord(),"Signing up is easy!");
    }
    @When("the user enters valid registration details")
    public void verifySuccessfulRegistration() {
        registerPage.enterFirstName("Amin");
        //Thread.sleep(1000);
        registerPage.enterLastName("Ahmed");
        //Thread.sleep(1000);
        registerPage.enterAddress("Cairo");
        //Thread.sleep(1000);
        registerPage.enterCity("aswan_city");
        //Thread.sleep(1000);
        registerPage.enterState("south");
        //Thread.sleep(1000);
        registerPage.enterZipInput("00111000");
        //Thread.sleep(1000);
        registerPage.enterPhoneNumber("010010110000");
        //Thread.sleep(1000);
        registerPage.enterSSN("12345678421411");
       // Thread.sleep(1000);
        registerPage.enterUserName("Amin_Ahmed");
        //Thread.sleep(1000);
        registerPage.enterPassword("88888888");
        //Thread.sleep(1000);
        registerPage.enterConfirmPassword("88888888");
        //Thread.sleep(1000);
    }
    @And("click the Register button")
       public void ClickRegister() {
        wait.until(ExpectedConditions.elementToBeClickable(registerPage.getRegisterButton()));
        registerPage.clickRegisterButton();

    }
    @Then("the account should be created successfully")
      public void VerifyRegistration(){
        Assert.assertTrue(registerPage.isRegisterSuccess());

    }
}
