import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class AccountLoginTest extends BaseClass{
    AccountLogin accountLogin;
    WebDriverWait wait;
    static int attemptAccount;
    @DataProvider(name = "loginData")
    public Object [][] MyLoginData() {
        return new Object[][]{
                {"TRIKA", "12345"},
                {"TRIKA", "123"},
                {"TRIKA", "1456"}
        };
    }
    @Test(dataProvider = "loginData")

    public void VerifyAccountLockedMaximumAttempts(String userName, String PassWord) throws InterruptedException {
        accountLogin=new AccountLogin(driver);
        attemptAccount++;
        accountLogin.enterUserName(userName);
        accountLogin.enterPassword(PassWord);
        accountLogin.clickLoginButton();
        Thread.sleep(2000);
        accountLogin.clearUsername();
        accountLogin.clearPassword();
        if (attemptAccount==3){
            accountLogin.getErrorLoginMessage();
            Assert.assertEquals(accountLogin.getErrorLoginMessage(),"Account is locked due failed login");
        }

    }
}