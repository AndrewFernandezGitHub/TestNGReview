package ReviewClass01;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
//if webdriver is provided, dont do @beforemethod, watch how webdriver is declared
public class DataDrivenTesting {
    WebDriver driver;

    @DataProvider(name = "credentials")
    public Object[][] data() {
        Object[][] login = {
                {"unknown@codility.com", "password", "You shall not pass! Arr!"},
                {"unknowncodilitycom", "password", "Enter a valid email"},
                {"", "password", "Email is required"},
                {"login@codility.com", "", "Password is required"}};
        return login;
    }
    //validate for credentials
    //give test dataProvider name we initialized earlier, credentials
    @Test(dataProvider = "credentials")
    public void validateCredentials(String email, String password, String expectedMsg){
        WebElement validateEmail = driver.findElement(By.id("email-input"));
        WebElement validatePassword = driver.findElement(By.id("password-input"));
        WebElement loginButton = driver.findElement(By.id("login-button"));
        //send the credentials
        validateEmail.sendKeys(email);
        validatePassword.sendKeys(password);
        loginButton.click();
        WebElement actualMsg=driver.findElement(By.xpath("//div[@id='messages']/div"));
        String actualMessage=actualMsg.getText();
        //Assert and check
        Assert.assertEquals(actualMessage,expectedMsg);



    }
    //check for valid credentials
    @Test
    public void verifyCorrectCredentials(){
        WebElement validateEmail = driver.findElement(By.id("email-input"));
        WebElement validatePassword = driver.findElement(By.id("password-input"));
        WebElement loginButton = driver.findElement(By.id("login-button"));
        //send the credentials
        validateEmail.sendKeys("login@codility.com");
        validatePassword.sendKeys("password");
        loginButton.click();
        WebElement actualMsg=driver.findElement(By.xpath("//div[@class='message success']"));
        String actualMessage=actualMsg.getText();
        String expectedMsg="Welcome to Codility";
        //Assert and check
        Assert.assertEquals(actualMessage,expectedMsg);
    }

    //check the visibility of the elements
    @Test
    public void VisibilityOfLoginElements() {
        WebElement email = driver.findElement(By.id("email-input"));
        WebElement password = driver.findElement(By.id("password-input"));
        boolean isEmailDisplayed = email.isDisplayed();
        boolean isPasswordDisplayed = password.isDisplayed();
        Assert.assertTrue(isEmailDisplayed);
        Assert.assertTrue(isPasswordDisplayed);

    }

    @BeforeMethod
    public void openBrowser() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("https://codility-frontend-prod.s3.amazonaws.com/media/task_static/qa_login_page/9a83bda125cd7398f9f482a3d6d45ea4/static/attachments/reference_page.html");
    }

    @AfterMethod
    public void closeBrowser() {
        driver.quit();
    }


}
