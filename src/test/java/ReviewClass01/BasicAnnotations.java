package ReviewClass01;

//import org.testng.annotations.*  this will import all dependencies in specifid library
import org.testng.annotations.*;

public class BasicAnnotations {

    @BeforeMethod
    public void beforeMethod(){
        System.out.println("I am before method being executed before each test such as opening browser/login directions");
    }

    @Test
    public void test1(){
        System.out.println("I am test 1");
    }
    @Test
    public void test2(){
        System.out.println("I am test 2");
    }
    @AfterMethod
    public void afterMethod(){
        System.out.println("I am after method being executed after each test ");
    }
    @BeforeClass
    public void beforeClass(){
        System.out.println("I am before class method");
    }
    @AfterClass
    public void afterClass(){
        System.out.println("I am after class method");
    }
    @BeforeTest
    public void beforeTest(){
        System.out.println("I am before test method");
    }
    @AfterTest
    public void afterTest(){
        System.out.println("I am after test method");
    }
    @BeforeSuite
    public void beforeSuite(){
        System.out.println("I am before suite");
    }
}
