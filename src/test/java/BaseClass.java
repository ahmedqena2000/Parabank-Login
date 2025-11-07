import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import java.time.Duration;

public class BaseClass {
WebDriver driver;
@BeforeMethod
    public void Setup(){
    driver=new ChromeDriver();
    driver.get("https://parabank.parasoft.com/parabank/index.htm");
    driver.manage().window().maximize();
    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
}
@AfterMethod
 public void Quit(){
   if (driver!=null){
    driver.quit();
    }
}

}
