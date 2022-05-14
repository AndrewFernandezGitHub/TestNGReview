package ReviewClass01;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class HardAssertions {
    WebDriver driver;

    @BeforeMethod
    public void openBrowser() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("https://alternativebrewing.com.au/blogs/coffee-guides/coffee-grinding-guide");
    }

    //make sure coffee grinding guide is located in page title
    @Test
    public void testTitle() {
        //get the title web element and store in a string

        String actualTitle = driver.findElement(By.xpath("//h1[@class='page__title heading h1']")).getText();
        String expectedTitle = "Coffee Grinding Guide";
        Assert.assertEquals(actualTitle,expectedTitle);
        System.out.println("Expected title is "+expectedTitle+"Actual title we pulled in Webelement is "+actualTitle);

        //with hard assertion, if first assertion fails, tests stop.
        //this makes soft assertions appealing because you can continue to check multiple cases if one fails
        String actualTitle2= driver.findElement(By.id("coffeefreshnessisfleetingHeader")).getText();
        String expectedTitle2="Coffee Freshness Is Fleeting";
        Assert.assertEquals(actualTitle2,expectedTitle2);
        System.out.println("Expected title is "+expectedTitle2+"Actual title we pulled in Webelement is "+actualTitle2);


    }
}
