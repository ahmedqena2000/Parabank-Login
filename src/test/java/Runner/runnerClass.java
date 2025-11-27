package Runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        features = "src/test/java/Features",
        glue = {"Steps","Hooks"}
)
public class runnerClass extends AbstractTestNGCucumberTests {
}
