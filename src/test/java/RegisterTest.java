import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

public class RegisterTest extends BaseClass{
    RegisterPage registerPage;
    WebDriverWait wait;

    @Test
    public void verifySuccessfulRegistration() throws InterruptedException {

        registerPage = new RegisterPage(driver);
        Thread.sleep(3000);
        registerPage.enterFirstName("Jana");
        Thread.sleep(1000);
        registerPage.EnterLastName("Ahmed");
        Thread.sleep(1000);
        registerPage.EnterAddress("Aswan");
        Thread.sleep(1000);
        registerPage.EnterCity("aswan_city");
        Thread.sleep(1000);
        registerPage.EnterState("UPPER");
        Thread.sleep(1000);
        registerPage.EnterZipInput("0011000");
        Thread.sleep(1000);
        registerPage.EnterPhoneNumber("01001010000");
        Thread.sleep(1000);
        registerPage.EnterSSN("1234567842411");
        Thread.sleep(1000);
        registerPage.EnterUserName("Jana_Ahmed");
        Thread.sleep(1000);
        registerPage.EnterPassword("88888888");
        Thread.sleep(1000);
        registerPage.EnterConfirmPassword("88888888");
        Thread.sleep(1000);
        registerPage.ClickRegisterButton();
        Thread.sleep(1000);
        Assert.assertTrue(registerPage.isRegisterSuccess());

    }
    @Test
    public void CheckDuplicateUser() throws InterruptedException {
        registerPage = new RegisterPage(driver);
        Thread.sleep(3000);
        registerPage.enterFirstName("WALID");
        Thread.sleep(1000);
        registerPage.EnterLastName("AHMED");
        registerPage.EnterAddress("EGYPT");
        registerPage.EnterCity("ASWAN");
        registerPage.EnterState("aswan");
        registerPage.EnterZipInput("0011000");
        registerPage.EnterPhoneNumber("01234567889");
        registerPage.EnterSSN("30122019900");
        registerPage.EnterUserName("WALID_AHMED");
        registerPage.EnterPassword("1234567089");
        registerPage.EnterConfirmPassword("1234567089");
        registerPage.ClickRegisterButton();
        Thread.sleep(2000);
        registerPage.logOutButton.click();
        Thread.sleep(3000);
        registerPage.openRegisterForm();
        Thread.sleep(2000);
        registerPage.enterFirstName("Walid");
        registerPage.EnterLastName("Ahmed");
        registerPage.EnterAddress("ASWAN1");
        registerPage.EnterCity("aswan_First");
        registerPage.EnterState("Upperr");
        registerPage.EnterZipInput("01100011");
        registerPage.EnterPhoneNumber("0100056897");
        registerPage.EnterSSN("30052000225411");
        registerPage.EnterUserName("WALID_AHMED");
        registerPage.EnterPassword("01888888888");
        registerPage.EnterConfirmPassword("01888888888");
        registerPage.ClickRegisterButton();
        Thread.sleep(1000);
        registerPage.getDuplicateUserMessage();
        Assert.assertEquals(registerPage.getDuplicateUserMessage(),"This username already exists.");

    }
    @Test
    public void CheckEmptyFieldsRegistration() throws InterruptedException {
        registerPage = new RegisterPage(driver);
        Thread.sleep(2000);
        registerPage.ClickRegisterButton();
        Assert.assertEquals(registerPage.getRequiredFirstNameMessage(),"First name is required.");
        Assert.assertEquals(registerPage.getRequiredLastNameMessage(),"Last name is required.");

    }


}
