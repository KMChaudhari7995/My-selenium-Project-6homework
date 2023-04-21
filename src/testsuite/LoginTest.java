package testsuite;

import browserfactory.BaseTest;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class LoginTest extends BaseTest {

    String baseUrl ="https://magento.softwaretestingboard.com/";
    @Before
    public void setUp() {
        openBrowser(baseUrl);//opening Url
    }

    @Test
    public void userShouldLoginSuccessfullyWithValidCredentials() {
        driver.findElement(By.xpath("//div[@class='panel wrapper']//a[contains(text(),'Sign In')]")).click();
        driver.findElement(By.xpath("//input[@id='email']")).sendKeys("khshbuc@gmail.com");
        driver.findElement(By.xpath("//input[@name='login[password]']")).sendKeys("12345@kmc");
        driver.findElement(By.xpath("//button[@class='action login primary']")).click();
        String expectedMessage = "Welcome";//"welcome";
        WebElement actualMessage = driver.findElement(By.xpath("//div[@class='panel header']//span[contains(text(),'Welcome, khushbu Chaudhari!') ]"));
        String actualMessage1 = actualMessage.getText().substring(0,7);
 //      System.out.println(actualMessage1);
         Assert.assertEquals("Error Message", expectedMessage, actualMessage1);
    }

    @Test
    public void verifyTheErrorMessageWithInvalidCredentials() {
        driver.findElement(By.xpath("//div[@class='panel wrapper']//a[contains(text(),'Sign In')]")).click();
        driver.findElement(By.xpath("//input[@id='email']")).sendKeys("khushbu1234567@gmail.com");
        driver.findElement(By.xpath("//input[@name='login[password]']")).sendKeys("123456");
        driver.findElement(By.xpath("//button[@class='action login primary']")).click();
        String expectedMessage ="The account sign-in was incorrect or your account is disabled temporarily. Please wait and try again later.";
        WebElement actualMessage = driver.findElement(By.xpath("//div[@class='message-error error message']"));
        String actualMessage1 =actualMessage.getText();
       System.out.println(actualMessage1);
       Assert.assertEquals("Error Message",expectedMessage,actualMessage1);
    }

    @Test
    public void userShouldLogOutSuccessfully (){
        driver.findElement(By.xpath("//div[@class='panel wrapper']//a[contains(text(),'Sign In')]")).click();
        driver.findElement(By.xpath("//input[@id='email']")).sendKeys("khshbuc@gmail.com");
        driver.findElement(By.xpath("//input[@name='login[password]']")).sendKeys("12345@kmc");
        driver.findElement(By.xpath("//button[@class='action login primary']")).click();
        String expectedMessage = "Welcome";
        WebElement actualMessage = driver.findElement(By.xpath("//div[@class='panel header']//span[contains(text(),'Welcome, khushbu Chaudhari!') ]"));
        String actualMessageText = actualMessage.getText().substring(0,7);
        Assert.assertEquals("False",expectedMessage,actualMessageText);
        driver.findElement(By.xpath("//div[@class='panel header']//button[@class='action switch']")).click();
        driver.findElement(By.xpath("//li[@class='customer-welcome active']//div[@class='customer-menu']//a[@href='https://magento.softwaretestingboard.com/customer/account/logout/']")).click();
        String expectedMessage1 = "You are signed out";
        WebElement actualMessage1 = driver.findElement(By.xpath("//span[@class='base']"));
        String actualMessageText1 = actualMessage1.getText();
        Assert.assertEquals("You are Signed Out",expectedMessage1,actualMessageText1);

    }

    @After
    public void tearDown() {
        // driver.quit();
        //  closeBrowser();
    }

}
