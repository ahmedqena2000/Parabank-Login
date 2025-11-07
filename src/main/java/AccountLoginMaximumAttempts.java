import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class AccountLoginMaximumAttempts {
    WebDriver driver;
    WebDriverWait wait;
    WebElement username;
    WebElement password;
    WebElement loginButton;
    WebElement errorLoginMessage;
    public AccountLoginMaximumAttempts(WebDriver driver){
        this.driver=driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(5));
    }
    public void enterUserName(String user){
        username=driver.findElement(By.cssSelector("input[name=\"username\"]"));
        username.sendKeys(user);
    }
    public void enterPassword( String pass){
        password=driver.findElement(By.cssSelector("input[name=\"password\"]"));
        password.sendKeys(pass);
    }
    public void clickLoginButton(){
        loginButton=driver.findElement(By.cssSelector("input[value=\"Log In\"]"));
        loginButton.click();
    }
    public void clearUsername(){
        username=driver.findElement(By.cssSelector("input[name=\"username\"]"));
        username.clear();
    }
    public void clearPassword(){
        password=driver.findElement(By.cssSelector("input[name=\"password\"]"));
        password.clear();
    }
    public String getErrorLoginMessage(){
        errorLoginMessage=driver.findElement(By.xpath("//p[@class=\"error\"]"));
        return errorLoginMessage.getText();
    }
}

