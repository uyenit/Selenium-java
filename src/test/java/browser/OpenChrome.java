package browser;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class OpenChrome {
    public static void main(String[] args) {
        WebDriver drive = new ChromeDriver();//open browser
        //drive.get("https://google.com.vn");
        // navigate to what do you want?
        drive.navigate().to("https://google.com.vn");
        //drive.manage().window().fullscreen();// size of view port
        drive.manage().window().maximize();
        //drive.close();
        drive.quit();

    }
}
