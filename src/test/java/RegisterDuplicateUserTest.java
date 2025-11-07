import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class RegisterDuplicateUserTest extends BaseClass{
    RegisterPage registerPage;
    WebDriverWait wait;
    @Test
    public void CheckDuplicateUser() throws InterruptedException {
        registerPage = new RegisterPage(driver);
        wait=new WebDriverWait(driver, Duration.ofSeconds(2));
        Thread.sleep(3000);
        registerPage.enterFirstName("WALID31");
        Thread.sleep(1000);
        registerPage.EnterLastName("AHMED31");
        registerPage.EnterAddress("EGYPT2");
        registerPage.EnterCity("ASWAN2");
        registerPage.EnterState("aswan2");
        registerPage.EnterZipInput("00211000");
        registerPage.EnterPhoneNumber("01234567889");
        registerPage.EnterSSN("30122019900");
        registerPage.EnterUserName("WALID31_AHMED31");
        registerPage.EnterPassword("1234567089");
        registerPage.EnterConfirmPassword("1234567089");
        registerPage.ClickRegisterButton();
        Assert.assertTrue(registerPage.isRegisterSuccess());
        wait.until(ExpectedConditions.visibilityOf(registerPage.logOutButton));
        registerPage.logOutButton.click();
        Thread.sleep(3000);
        registerPage.openRegisterForm();
        Thread.sleep(2000);
        registerPage.enterFirstName("Walid41");
        registerPage.EnterLastName("Ahmed41");
        registerPage.EnterAddress("ASWAN3");
        registerPage.EnterCity("aswan_First2");
        registerPage.EnterState("Upperr2");
        registerPage.EnterZipInput("011200011");
        registerPage.EnterPhoneNumber("0100056897");
        registerPage.EnterSSN("30052000225411");
        registerPage.EnterUserName("WALID31_AHMED31");
        registerPage.EnterPassword("018888888882");
        registerPage.EnterConfirmPassword("018888888882");
        registerPage.ClickRegisterButton();
        Thread.sleep(1000);
        registerPage.getDuplicateUserMessage();
        Assert.assertEquals(registerPage.getDuplicateUserMessage(),"This username already exists.");

    }
}
