import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class EmptyFieldsRegistration extends BaseClass{
    WebDriverWait wait;
    RegisterPage registerPage;
    @Test
    public void CheckEmptyFieldsRegistration() throws InterruptedException {
        registerPage = new RegisterPage(driver);
        wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        registerPage.openRegisterForm();
        registerPage.ClickRegisterButton();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("customer.firstName.errors")));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("customer.lastName.errors")));
        Assert.assertEquals(registerPage.getRequiredFirstNameMessage(),"First name is required.");
        Assert.assertEquals(registerPage.getRequiredLastNameMessage(),"Last name is required.");

    }
}
