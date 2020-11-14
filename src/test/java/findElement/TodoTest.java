package findElement;

import TestCase.BaseTest;
import browser.Browser;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.TodoPage;

public class TodoTest extends BaseTest {
    @Test
    void addNewTask() {
        TodoPage todoPage = new TodoPage();
        todoPage.open();
        int currentItemLeft = todoPage.getItemLeft();
        todoPage.addNewTask("task 1");
        todoPage.selectTab("All");
        Assert.assertTrue(todoPage.getTask("task 1").isDisplayed());
        
        todoPage.selectTab("Active");
        Assert.assertTrue(todoPage.getTask("task 1").isDisplayed());
        Assert.assertEquals(todoPage.getItemLeft(), currentItemLeft+1);
    }
}
