import org.testng.Assert;
import org.testng.annotations.Test;

public class ForgetLoginInfoPageTest extends BaseClass{
    ForgetLoginInfoPage forgetLoginInfoPage;
    @Test
    public void VerifySSN_numberAcceptDigitsOnly() throws InterruptedException {
        forgetLoginInfoPage=new ForgetLoginInfoPage(driver);
        Thread.sleep(2000);
        forgetLoginInfoPage.OpenForgetLoginInfoPage();
        forgetLoginInfoPage.enterFirstName("SAYED");
        forgetLoginInfoPage.enterLastName("ALI");
        forgetLoginInfoPage.enterAddress("SDAT");
        forgetLoginInfoPage.enterCity("SADTR");
        forgetLoginInfoPage.enterState("GOOD");
        forgetLoginInfoPage.enterZipCode("011000");
        forgetLoginInfoPage.enterSSN_Number("abc123456");
        forgetLoginInfoPage.SubmitInfo();
        forgetLoginInfoPage.GetErrorMessage();
        Assert.assertEquals(forgetLoginInfoPage.GetErrorMessage(),"SSN only accept digits");

    }
    @Test
    public void VerifySSn_numberShorter() throws InterruptedException {
        forgetLoginInfoPage=new ForgetLoginInfoPage(driver);
        Thread.sleep(2000);
        forgetLoginInfoPage.OpenForgetLoginInfoPage();
        forgetLoginInfoPage.enterFirstName("SAYED");
        forgetLoginInfoPage.enterLastName("ALI");
        forgetLoginInfoPage.enterAddress("SDAT");
        forgetLoginInfoPage.enterCity("SADTR");
        forgetLoginInfoPage.enterState("GOOD");
        forgetLoginInfoPage.enterZipCode("011000");
        forgetLoginInfoPage.enterSSN_Number("12345678");
        forgetLoginInfoPage.SubmitInfo();
        forgetLoginInfoPage.GetErrorMessage();
        Assert.assertEquals(forgetLoginInfoPage.GetErrorMessage(),"SSN number is less than 9digits");

    }
    @Test
    public void VerifySSn_numberLonger() throws InterruptedException {
        forgetLoginInfoPage=new ForgetLoginInfoPage(driver);
        Thread.sleep(2000);
        forgetLoginInfoPage.OpenForgetLoginInfoPage();
        forgetLoginInfoPage.enterFirstName("SAYED");
        forgetLoginInfoPage.enterLastName("ALI");
        forgetLoginInfoPage.enterAddress("SDAT");
        forgetLoginInfoPage.enterCity("SADTR");
        forgetLoginInfoPage.enterState("GOOD");
        forgetLoginInfoPage.enterZipCode("011000");
        forgetLoginInfoPage.enterSSN_Number("1234567890");
        forgetLoginInfoPage.SubmitInfo();
        forgetLoginInfoPage.GetErrorMessage();
        Assert.assertEquals(forgetLoginInfoPage.GetErrorMessage(),"SSN number is greater than 9digits");
    }
}
