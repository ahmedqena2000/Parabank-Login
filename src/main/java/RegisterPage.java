import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class RegisterPage {
    WebDriver driver;
    WebElement registerClick;
    WebElement firstName;
    WebElement lastName;
    WebElement address;
    WebElement city;
    WebElement state;
    WebElement zipInput;
    WebElement phoneNumber;
    WebElement ssnNumber;
    WebElement userName;
    WebElement password;
    WebElement confirmPassword;
    WebElement registerButton;
    WebElement successMessage;
    WebDriverWait wait;
    WebElement duplicateUserErrorMessage;
    WebElement requiredFirstNameMessage;
    WebElement requiredLastNameMessage;
    WebElement logOutButton;

public RegisterPage(WebDriver driver) {
    this.driver = driver;
    this.wait = new WebDriverWait(driver, Duration.ofSeconds(5));
    openRegisterForm();

}

public void openRegisterForm(){
    registerClick = driver.findElement(By.linkText("Register"));
    registerClick.click();
    }
    public void enterFirstName(String FirstName){
        firstName = driver.findElement(By.id("customer.firstName"));
    firstName.sendKeys(FirstName);
    }
    public void EnterLastName(String LastName){
        lastName = driver.findElement(By.id("customer.lastName"));
        lastName.sendKeys(LastName);
    }
    public void EnterAddress(String Address){
        address = driver.findElement(By.id("customer.address.street"));
        address.sendKeys(Address);
    }
    public void EnterCity(String City){
        city = driver.findElement(By.id("customer.address.city"));
    city.sendKeys(City);
    }
    public void EnterState(String State){
        state = driver.findElement(By.id("customer.address.state"));
    state.sendKeys(State);
    }
    public void EnterZipInput(String ZipField){
        zipInput = driver.findElement(By.id("customer.address.zipCode"));
    zipInput.sendKeys(ZipField);
    }
    public void EnterPhoneNumber(String PhoneNumber){
        phoneNumber = driver.findElement(By.id("customer.phoneNumber"));
    phoneNumber.sendKeys(PhoneNumber);
    }
    public void EnterSSN(String SSN){
        ssnNumber = driver.findElement(By.id("customer.ssn"));
    ssnNumber.sendKeys(SSN);
    }
    public void EnterUserName(String User){
        userName = driver.findElement(By.id("customer.username"));
    userName.sendKeys(User);
    }
    public void EnterPassword(String Password){
        password = driver.findElement(By.id("customer.password"));
    password.sendKeys(Password);
    }
    public void EnterConfirmPassword(String Confirm){
        confirmPassword = driver.findElement(By.id("repeatedPassword"));
    confirmPassword.sendKeys(Confirm);
    }
    public void ClickRegisterButton(){
      wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("input[value='Register']")));
      registerButton = driver.findElement(By.cssSelector("input[value='Register']"));
      registerButton.click();
      successMessage = driver.findElement(By.xpath("//h1[@class=\"title\"]"));
      if (successMessage.getText().contains("Welcome")){
          logOutButton = driver.findElement(By.linkText("Log Out"));
      }

    }
    public String getDuplicateUserMessage(){
        duplicateUserErrorMessage = driver.findElement(By.id("customer.username.errors"));
        return duplicateUserErrorMessage.getText();
    }
    public boolean isRegisterSuccess(){

    return successMessage.isDisplayed();
    }

    public String getRequiredFirstNameMessage(){
    requiredFirstNameMessage =driver.findElement(By.id("customer.firstName.errors"));
    return requiredFirstNameMessage.getText();
    }
    public String getRequiredLastNameMessage(){
    requiredLastNameMessage =driver.findElement(By.id("customer.lastName.errors"));
    return requiredLastNameMessage.getText();
    }
}

