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
        registerPage.enterFirstName("Jana1");
        Thread.sleep(1000);
        registerPage.EnterLastName("Ahmed1");
        Thread.sleep(1000);
        registerPage.EnterAddress("Aswan1");
        Thread.sleep(1000);
        registerPage.EnterCity("aswan_city1");
        Thread.sleep(1000);
        registerPage.EnterState("UPPER1");
        Thread.sleep(1000);
        registerPage.EnterZipInput("00111000");
        Thread.sleep(1000);
        registerPage.EnterPhoneNumber("010010110000");
        Thread.sleep(1000);
        registerPage.EnterSSN("12345678421411");
        Thread.sleep(1000);
        registerPage.EnterUserName("Jana_Ahmed1");
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
        registerPage.enterFirstName("WALID1");
        Thread.sleep(1000);
        registerPage.EnterLastName("AHMED1");
        registerPage.EnterAddress("EGYPT");
        registerPage.EnterCity("ASWAN1");
        registerPage.EnterState("aswan1");
        registerPage.EnterZipInput("00111000");
        registerPage.EnterPhoneNumber("01234567889");
        registerPage.EnterSSN("30122019900");
        registerPage.EnterUserName("WALID1_AHMED1");
        registerPage.EnterPassword("1234567089");
        registerPage.EnterConfirmPassword("1234567089");
        registerPage.ClickRegisterButton();
        Thread.sleep(2000);
        registerPage.logOutButton.click();
        Thread.sleep(3000);
        registerPage.openRegisterForm();
        Thread.sleep(2000);
        registerPage.enterFirstName("Walid2");
        registerPage.EnterLastName("Ahmed2");
        registerPage.EnterAddress("ASWAN2");
        registerPage.EnterCity("aswan_First2");
        registerPage.EnterState("Upperr2");
        registerPage.EnterZipInput("011200011");
        registerPage.EnterPhoneNumber("0100056897");
        registerPage.EnterSSN("30052000225411");
        registerPage.EnterUserName("WALID1_AHMED1");
        registerPage.EnterPassword("018888888882");
        registerPage.EnterConfirmPassword("018888888882");
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
