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



}
