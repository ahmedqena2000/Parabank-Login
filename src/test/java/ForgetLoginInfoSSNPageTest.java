import org.testng.Assert;
import org.testng.annotations.Test;

public class ForgetLoginInfoSSNPageTest extends BaseClass{
    ForgetLoginInfoSSNPage forgetLoginInfoPage;
    @Test
    public void VerifySSN_numberAcceptDigitsOnly() throws InterruptedException {
        forgetLoginInfoPage=new ForgetLoginInfoSSNPage(driver);
        Thread.sleep(2000);
        forgetLoginInfoPage.OpenForgetLoginInfoPage();
        forgetLoginInfoPage.enterFirstName("JOE");
        forgetLoginInfoPage.enterLastName("SHOW");
        forgetLoginInfoPage.enterAddress("SADAT");
        forgetLoginInfoPage.enterCity("SADAT_2");
        forgetLoginInfoPage.enterState("GOOD");
        forgetLoginInfoPage.enterZipCode("0112000");
        forgetLoginInfoPage.enterSSN_Number("abc123456");
        forgetLoginInfoPage.SubmitInfo();
        forgetLoginInfoPage.GetErrorMessage();
        Assert.assertEquals(forgetLoginInfoPage.GetErrorMessage(),"SSN only accept digits");

    }
    @Test
    public void VerifySSn_numberShorter() throws InterruptedException {
        forgetLoginInfoPage=new ForgetLoginInfoSSNPage(driver);
        Thread.sleep(2000);
        forgetLoginInfoPage.OpenForgetLoginInfoPage();
        forgetLoginInfoPage.enterFirstName("JOE");
        forgetLoginInfoPage.enterLastName("SHOW");
        forgetLoginInfoPage.enterAddress("SADAT");
        forgetLoginInfoPage.enterCity("SADA_2");
        forgetLoginInfoPage.enterState("GOOD");
        forgetLoginInfoPage.enterZipCode("011000");
        forgetLoginInfoPage.enterSSN_Number("12345678");
        forgetLoginInfoPage.SubmitInfo();
        forgetLoginInfoPage.GetErrorMessage();
        Assert.assertEquals(forgetLoginInfoPage.GetErrorMessage(),"SSN number is less than 9digits");

    }
    @Test
    public void VerifySSn_numberLonger() throws InterruptedException {
        forgetLoginInfoPage=new ForgetLoginInfoSSNPage(driver);
        Thread.sleep(2000);
        forgetLoginInfoPage.OpenForgetLoginInfoPage();
        forgetLoginInfoPage.enterFirstName("JOE");
        forgetLoginInfoPage.enterLastName("SHOW");
        forgetLoginInfoPage.enterAddress("SADAT");
        forgetLoginInfoPage.enterCity("SADAT_2");
        forgetLoginInfoPage.enterState("GOOD");
        forgetLoginInfoPage.enterZipCode("011000");
        forgetLoginInfoPage.enterSSN_Number("1234567890");
        forgetLoginInfoPage.SubmitInfo();
        forgetLoginInfoPage.GetErrorMessage();
        Assert.assertEquals(forgetLoginInfoPage.GetErrorMessage(),"SSN number is greater than 9digits");
    }
}
