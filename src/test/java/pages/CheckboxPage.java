package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CheckboxPage {
    private String checkBoxName = "//form[@id ='checkboxes']/input[%s]";


    public CheckboxPage(WebDriver driver) {
        this.driver = driver;
    }

    private WebDriver driver;
    public void open() {
        driver.get("https://the-internet.herokuapp.com/checkbox");
    }


    public void check(WebElement element) {
        if(!element.isSelected()){
            element.click();
        }
    }

    public void checkOn(String checkBoxName) {
        check(getCheckbox(checkBoxName));
    }
    public WebElement getCheckbox(String checkBoxName) {
        return driver.findElement(By.xpath(String.format(checkBoxName,checkBoxName)));
    }


}
