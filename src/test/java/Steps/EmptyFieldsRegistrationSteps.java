package Steps;

import Hooks.hooksClass;
import MyPages.RegisterPage;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

public class EmptyFieldsRegistrationSteps {
    WebDriverWait wait;
    RegisterPage registerPage;
    public EmptyFieldsRegistrationSteps(){
        registerPage = new RegisterPage(hooksClass.driver);
        wait=new WebDriverWait(hooksClass.driver,Duration.ofSeconds(3));
    }
    @When("the user submits the registration form without entering any data")
    public void checkEmptyFieldsRegistration(){
        //registerPage.openRegisterForm();
        registerPage.clickRegisterButton();
        //wait.until(ExpectedConditions.visibilityOf(registerPage.getErrorFirstName()));
        //wait.until(ExpectedConditions.visibilityOf(registerPage.getErrorLastName()));
        }
    @Then("validation messages should be displayed for all mandatory fields")
    public void checkEmptyFieldsMessage(){
        Assert.assertEquals(registerPage.getRequiredFirstNameMessage(),"First name is required.");
        Assert.assertEquals(registerPage.getRequiredLastNameMessage(),"Last name is required.");

    }

}

