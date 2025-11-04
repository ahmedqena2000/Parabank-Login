import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import java.time.Duration;

public class BaseClass {
WebDriver driver;
@BeforeClass
    public void Setup(){
    driver=new ChromeDriver();
    driver.get("https://parabank.parasoft.com/parabank/index.htm");
    driver.manage().window().maximize();
    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
}
@AfterClass
 public void Quit(){
   if (driver!=null){
    driver.quit();
    }
}

}
