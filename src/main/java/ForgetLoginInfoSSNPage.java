import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ForgetLoginInfoSSNPage {
    WebDriver driver;
    WebDriverWait wait;
    WebElement forgetLoginInfoButton;
    WebElement ssnField;
    WebElement errorMessage;
    WebElement findLoginInfoButton;
    WebElement firstName;
    WebElement lastName;
    WebElement address;
    WebElement city;
    WebElement state;
    WebElement zipCode;

    public ForgetLoginInfoSSNPage(WebDriver driver){
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(5));
    }
    public void OpenForgetLoginInfoPage(){
        forgetLoginInfoButton =driver.findElement(By.linkText("Forgot login info?"));
        forgetLoginInfoButton.click();
    }
    public void enterFirstName(String fName){
        firstName=driver.findElement(By.id("firstName"));
        firstName.sendKeys(fName);
    }
    public void enterLastName(String lname){
        lastName=driver.findElement(By.id("lastName"));
        lastName.sendKeys(lname);
    }
    public void enterAddress(String addres){
        address=driver.findElement(By.id("address.street"));
        address.sendKeys(addres);
    }
    public void enterCity(String Cty){
        city=driver.findElement(By.id("address.city"));
        city.sendKeys(Cty);
    }
    public void enterState(String Stat){
        state=driver.findElement(By.id("address.state"));
        state.sendKeys(Stat);
    }
    public void enterZipCode(String zip){
        zipCode=driver.findElement(By.id("address.zipCode"));
        zipCode.sendKeys(zip);
    }
    public void enterSSN_Number(String ssn){
        ssnField=driver.findElement(By.id("ssn"));
        ssnField.sendKeys(ssn);
    }
    public void SubmitInfo(){
        findLoginInfoButton= driver.findElement(By.cssSelector("input[value='Find My Login Info']"));
        findLoginInfoButton.click();
    }
    public String GetErrorMessage(){
        
        errorMessage=driver.findElement(By.xpath("//*[@class='error']"));
        return errorMessage.getText();
    }



}
