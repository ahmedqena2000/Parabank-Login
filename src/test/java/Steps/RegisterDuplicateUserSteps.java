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
import org.testng.annotations.Test;

import java.time.Duration;

public class RegisterDuplicateUserSteps {
    RegisterPage registerPage;
    WebDriverWait wait;
    public RegisterDuplicateUserSteps(){
        registerPage=new RegisterPage(hooksClass.driver);
        wait=new WebDriverWait(hooksClass.driver,Duration.ofSeconds(3));
    }
    @Given("the user already exists with username")
    public void registerUser(){
        registerPage.enterFirstName("Youssef");
        registerPage.enterFirstName("Gamal");
        registerPage.enterAddress("Cairo");
        registerPage.enterCity("ASWAN");
        registerPage.enterState("aswan");
        registerPage.enterZipInput("00211000");
        registerPage.enterPhoneNumber("01234567889");
        registerPage.enterSSN("30122019900");
        registerPage.enterUserName("Y_Gamal");
        registerPage.enterPassword("1234567089");
        registerPage.enterConfirmPassword("1234567089");
        wait.until(ExpectedConditions.elementToBeClickable(registerPage.getRegisterButton()));
        Assert.assertTrue(registerPage.isRegisterSuccess());}

    @And("the user is logged out")
    public void loggingOut(){
        wait.until(ExpectedConditions.visibilityOf(registerPage.getLoggingOutButton()));
        registerPage.getLoggingOutButton().click();
    }

    @When("user register with same username")
    public void register_same_user() throws InterruptedException {
        registerPage.openRegisterForm();
        Thread.sleep(2000);
        registerPage.enterFirstName("Ali");
        registerPage.enterLastName("Alaa");
        registerPage.enterAddress("Cairo");
        registerPage.enterCity("Aswan");
        registerPage.enterState("Upper");
        registerPage.enterZipInput("011200011");
        registerPage.enterPhoneNumber("0100056897");
        registerPage.enterSSN("30052000225411");
        registerPage.enterUserName("Y_Gamal");
        registerPage.enterPassword("018888888882");
        registerPage.enterConfirmPassword("018888888882");}
    @And("clicked the Register button")
    public void ClickedRegisterButton(){
        wait.until(ExpectedConditions.elementToBeClickable(registerPage.getRegisterButton()));
        registerPage.clickRegisterButton();
        }
    @Then("an error message should be displayed the username already exists")
    public void checkDuplicatedUserError(){
        registerPage.getDuplicateUserMessage();
        Assert.assertEquals(registerPage.getDuplicateUserMessage(),"This username already exists.");

    }
}

