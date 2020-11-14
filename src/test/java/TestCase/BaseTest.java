package TestCase;

import browser.Browser;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;

public class BaseTest {
    @Parameters({"browserName"})
    @BeforeClass
    public void setUp(String browserName) {
        Browser.launch(browserName);
    }
    @AfterClass
    public void tearDown() {
        Browser.quit();
    }
}
