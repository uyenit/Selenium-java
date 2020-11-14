package findElement;

import org.testng.annotations.*;

public class TestNgDemo {
    @BeforeSuite
        void beforeSuit() {
            System.out.println("");
        }
    @BeforeTest
    void beforeTest() {
        System.out.println("");
    }
    @BeforeClass
    void beforeClass() {
        System.out.println("");
    }

    @BeforeMethod
    void beforeMethod() {
        System.out.println("");
    }

    @Test
    void tc01() {
        System.out.println("tc1");
    }

    void tc02() {
        System.out.println("tc1");
    }

    void tc03() {
        System.out.println("tc1");
    }

    void tc04() {
        System.out.println("tc1");
    }

    void tc05() {
        System.out.println("tc1");
    }

}
