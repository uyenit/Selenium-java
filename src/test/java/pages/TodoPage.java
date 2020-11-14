package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class TodoPage extends BasePage{
    WebDriver driver;
    private By newTodoTxt = By.className("new-todo");
    public void addNewTask(String byName) {
        fill(newTodoTxt, byName + "\n");
    }

    public WebElement getTask(String byName) {
        return driver.findElement(By.xpath(String.format("//label[.='%s']",byName)));
    }

    public void selectTab(String name) {
        driver.findElement(By.xpath(String.format("//a[.='%s']",name))).click();
    }

    public int getItemLeft() {
        int itemCount = 0;
        if(driver.findElement(By.xpath("//span[@class='todo-count']/strong")).isDisplayed()) {
            itemCount = Integer.parseInt(driver.findElement(By.xpath("//span[@class='todo-count']/strong")).getText());
        }
        return itemCount;
    }

    @Override
    public void open() {

    }
}
