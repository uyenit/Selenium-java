/*
lable --> lbl
link text ---> lnk
radio bytton ---> rad
checkbox ---> chk
 */
package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.How;
import org.testng.Assert;

public class LoginPage extends BasePage{
    private By usernameTxt = By.id("username");
    private By passwordTxt =By.id("password");
    private By loginBtn = By.xpath("//button//*[contains(.,'Login')]");

    @Override
    public void open() {
        driver.get("https://the-internet.herokuapp.com/login");
    }

    public String  getCurrentUrl(){
        return driver.getCurrentUrl();
    }

    public void login(String userName, String passWord) {
        fill(usernameTxt,userName);
        fill(passwordTxt,passWord);
        click(loginBtn);
    }

    public boolean isLoggedIn(){
        return (getCurrentUrl().equals("https://the-internet.herokuapp.com/secure"));
    }
}
