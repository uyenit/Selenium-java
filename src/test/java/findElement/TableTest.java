package findElement;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
/*
    number of columns = //table/thead/tr/th
    number of rows = //table/tbody/tr
    one column = //table/thead/tr/td[index]
    one row = //table/tbody/tr[index]/td
    all cells = //table/tbody/tr/td
    a cell = //table/tbody/tr[row_index]/td[cpl_index]
    a table = Array[row][column]
    table[i][j]
 */

public class TableTest {
    @Test
    void largeTablePerson() {
        WebDriver driver = new ChromeDriver();
        driver.get("https://the-internet.herokuapp.com/tables");
        driver.manage().window().maximize();
        List<WebElement> listElement = driver.findElements(By.xpath("//table [@id='table1']/tbody/tr/td[4]"));
        List<Float> dues = new ArrayList<>();
        listElement.forEach(element -> dues.add(Float.valueOf(element.getText().trim().replace("$",""))));
        //System.out.println(dues);

        /*List<Float> a =  listElement
                .stream()
                .map(element -> {
                    return Float.valueOf(element.getText().trim().replace("$",""));
                })
                .collect(Collectors.toList());

         */

        System.out.println(getLargestIndex(dues));

        String lastNameLocator = "//table [@id='table1']/tbody/tr[%s]/td[2]";
        String firstNameLocator = "//table [@id='table1']/tbody/tr[%s]/td[1]";

        String firstName = driver.findElement(By.xpath(String.format(firstNameLocator,getLargestIndex(dues) +1))).getText();
        String lastName = driver.findElement(By.xpath(String.format(lastNameLocator,getLargestIndex(dues) + 1))).getText();
        Assert.assertEquals(String.format("%s %s",lastName,firstName),"Doe Jason");
    }

    static int getLargestIndex(List<Float> givenList) {
        float largest = givenList.get(0);
        int largestIndex = 0;
        for (int i = 0; i < givenList.size(); i++) {
            if(largest < givenList.get(i)) {
                largest = givenList.get(i);
                largestIndex = i;
            }
        }
        return largestIndex;
    }
    @Test
    void allCellValue() {
        WebDriver driver = new ChromeDriver();
        driver.get("https://the-internet.herokuapp.com/tables");
        driver.manage().window().maximize();
        //List<WebElement> cells = driver.findElements(By.xpath("//table [@id='table1']/tbody/tr/td"));
        //cells.stream().forEach(element -> System.out.println(element.getText()));
        //cells.stream().forEach(element -> System.out.println(element.findElement(By.tagName("td")).getText()));



        List<WebElement> rows = driver.findElements(By.xpath("//table [@id='table1']/tbody/tr"));
        List<Person> persons = rows.stream().map(element -> {
            return toPerson(element);
        }).collect(Collectors.toList());

        List<Float> dues = persons.stream().map(Person::getDue).collect(Collectors.toList());
        persons.stream().forEach(person -> System.out.println(person.getDue()));



    }

    private Person toPerson(WebElement element) {
        String lastName = element.findElements(By.tagName("td")).get(0).getText();
        String firstName = element.findElements(By.tagName("td")).get(1).getText();
        String email = element.findElements(By.tagName("td")).get(2).getText();
        Float due = Float.valueOf(element.findElements(By.tagName("td")).get(3).getText().trim().replace("$",""));
        String website = element.findElements(By.tagName("td")).get(4).getText();
        Person person = new Person(lastName,firstName,email,website,due);
        return person;

    }
}
