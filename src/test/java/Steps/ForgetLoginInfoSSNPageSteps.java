package Steps;
import Hooks.hooksClass;
import MyPages.ForgetLoginInfoSSNPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ForgetLoginInfoSSNPageSteps {
    ForgetLoginInfoSSNPage forgetLoginInfoPage;
    @Given("the user is on the Forgot Login Info page")
    public void navigateToForgotLoginInfoPage() throws InterruptedException {
        forgetLoginInfoPage=new ForgetLoginInfoSSNPage(hooksClass.driver);
        Thread.sleep(2000);
        forgetLoginInfoPage.OpenForgetLoginInfoPage();
    }
    @When("the user enters non-numeric characters into the SSN field")
    public void enterUserData() {

        forgetLoginInfoPage.enterFirstName("JOE");
        forgetLoginInfoPage.enterLastName("SHOW");
        forgetLoginInfoPage.enterAddress("SADAT");
        forgetLoginInfoPage.enterCity("SADAT_2");
        forgetLoginInfoPage.enterState("GOOD");
        forgetLoginInfoPage.enterZipCode("0112000");
        forgetLoginInfoPage.enterSSN_Number("abc123456");
        forgetLoginInfoPage.submitInfo();
    }
    @Then("system should display an error message")
     public void checkNonNumericSSNMessage(){
        forgetLoginInfoPage.GetErrorMessage();
        Assert.assertEquals(forgetLoginInfoPage.GetErrorMessage(),"SSN only accept digits");

    }
    @When("the user enters the SSN less than 9 digits")
    public void VerifySSn_numberShorter() throws InterruptedException {
        forgetLoginInfoPage = new ForgetLoginInfoSSNPage(hooksClass.driver);
        Thread.sleep(2000);
        forgetLoginInfoPage.OpenForgetLoginInfoPage();
        forgetLoginInfoPage.enterFirstName("JOE");
        forgetLoginInfoPage.enterLastName("SHOW");
        forgetLoginInfoPage.enterAddress("SADAT");
        forgetLoginInfoPage.enterCity("SADA_2");
        forgetLoginInfoPage.enterState("GOOD");
        forgetLoginInfoPage.enterZipCode("011000");
        forgetLoginInfoPage.enterSSN_Number("12345678");
        forgetLoginInfoPage.submitInfo();
    }
    @Then("system should display validation message for short SSN number")
    public void checkSSN_NumberIsLess_Than_9_Digits(){
        forgetLoginInfoPage.GetErrorMessage();
        Assert.assertEquals(forgetLoginInfoPage.GetErrorMessage(),"SSN number is less than 9digits");

    }
    @When("the user enters the SSN greater than 9 digits")
    public void VerifySSn_numberLonger() throws InterruptedException {
        forgetLoginInfoPage = new ForgetLoginInfoSSNPage(hooksClass.driver);
        Thread.sleep(2000);
        forgetLoginInfoPage.OpenForgetLoginInfoPage();
        forgetLoginInfoPage.enterFirstName("JOE");
        forgetLoginInfoPage.enterLastName("SHOW");
        forgetLoginInfoPage.enterAddress("SADAT");
        forgetLoginInfoPage.enterCity("SADAT_2");
        forgetLoginInfoPage.enterState("GOOD");
        forgetLoginInfoPage.enterZipCode("011000");
        forgetLoginInfoPage.enterSSN_Number("1234567890");
        forgetLoginInfoPage.submitInfo();
    }
    @Then("system should display validation message for long SSN number")
    public void check_SSN_Number_Is_Greater_Than_9_Digits(){
        forgetLoginInfoPage.GetErrorMessage();
        Assert.assertEquals(forgetLoginInfoPage.GetErrorMessage(),"SSN number is greater than 9digits");
    }
}

