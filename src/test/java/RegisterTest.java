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
//        registerPage.openRegisterForm();
        registerPage.enterFirstName("vdha");
        Thread.sleep(1000);
        registerPage.EnterLastName("ahrs");
        Thread.sleep(1000);
        registerPage.EnterAddress("rfft");
        Thread.sleep(1000);
        registerPage.EnterCity("thg Cidty");
        Thread.sleep(1000);
        registerPage.EnterState("fhdd");
        Thread.sleep(1000);
        registerPage.EnterZipInput("691710");
        Thread.sleep(1000);
        registerPage.EnterPhoneNumber("01001010000");
        Thread.sleep(1000);
        registerPage.EnterSSN("1234567842411");
        Thread.sleep(1000);
        registerPage.EnterUserName("Ahmez_A25");
        Thread.sleep(1000);
        registerPage.EnterPassword("00000000");
        Thread.sleep(1000);
        registerPage.EnterConfirmPassword("00000000");
        Thread.sleep(1000);
        registerPage.ClickRegisterButton();
        Thread.sleep(1000);
        Assert.assertTrue(registerPage.isRegisterSuccess());

    }
    @Test
    public void CheckDuplicateUser() throws InterruptedException {
        registerPage = new RegisterPage(driver);
        Thread.sleep(3000);
        registerPage.enterFirstName("Lionel");
        registerPage.EnterLastName("Messi");
        registerPage.EnterAddress("Barcelona");
        registerPage.EnterCity("Spain");
        registerPage.EnterState("Catalan");
        registerPage.EnterZipInput("1101101");
        registerPage.EnterPhoneNumber("010011100");
        registerPage.EnterSSN("10101011010110");
        registerPage.EnterUserName("Messi_2022");
        registerPage.EnterPassword("1234567089");
        registerPage.EnterConfirmPassword("1234567089");
        registerPage.ClickRegisterButton();
        Thread.sleep(2000);
        registerPage.logOutButton.click();
        Thread.sleep(3000);
        registerPage.openRegisterForm();
        Thread.sleep(2000);
        registerPage.enterFirstName("ZAIN");
        registerPage.EnterLastName("Ahmed");
        registerPage.EnterAddress("Asdann");
        registerPage.EnterCity("AswanFidrst");
        registerPage.EnterState("Upperr");
        registerPage.EnterZipInput("568741");
        registerPage.EnterPhoneNumber("0100056897");
        registerPage.EnterSSN("30052000225411");
        registerPage.EnterUserName("jeyor_ahmed");
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
