package browser;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxBinary;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class Browser {
    private static WebDriver driver;

    public static WebDriver getDriver() {
        return driver;
    }

    public static void launch(String browserName) {
        if (browserName.equals("ie")) {
            driver = new InternetExplorerDriver();
        } else if (browserName.equals("chrome")) {
            ChromeOptions chromeOptions = new ChromeOptions();
            chromeOptions.setHeadless(true);

            driver = new ChromeDriver(chromeOptions);
        } else if(browserName.equals("firefox")) {
            FirefoxBinary firefoxBinary = new FirefoxBinary();
            firefoxBinary.addCommandLineOptions("--headless");
            FirefoxOptions firefoxOptions = new FirefoxOptions();
            firefoxOptions.setBinary(firefoxBinary);
            driver = new FirefoxDriver(firefoxOptions);
        }
       driver.manage().window().maximize();
    }
    public static void quit(){
        if(driver != null) {
            driver.quit();
        }

    }
}
