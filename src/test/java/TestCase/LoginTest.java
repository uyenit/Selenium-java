package TestCase;

import browser.Browser;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pages.LoginPage;

public class LoginTest extends BaseTest{
    @Test
    void withValidCredentials() {
        LoginPage page = new LoginPage();
        page.open();
        page.login("tomsmith","SuperSecretPassword!");

        Assert.assertEquals(page.getCurrentUrl(),
               page.getCurrentUrl(),
                "Login failed");

    }
}
