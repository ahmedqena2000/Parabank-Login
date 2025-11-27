package Hooks;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class hooksClass {
 public static WebDriver driver;
   @Before
    public void Setup(){
    driver=new ChromeDriver();
    driver.get("https://parabank.parasoft.com/parabank/index.htm");
    driver.manage().window().maximize();
    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
}
  @After
 public void Quit(){
   if (driver!=null){
    driver.quit();
    }
}

}
