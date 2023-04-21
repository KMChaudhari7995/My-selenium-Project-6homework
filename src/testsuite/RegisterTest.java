package testsuite;

import browserfactory.BaseTest;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class RegisterTest extends BaseTest {

    String baseUrl = "https://magento.softwaretestingboard.com/";

    @Before
    public void setUp(){
        openBrowser(baseUrl);//opening Url

    }

    @Test
    public void verifyThatSignInPageDisplay(){
        //click on Create an Account
        driver.findElement(By.xpath("//div[@class='panel header']//ul[@class='header links']//li//a[contains(text(),'Create an Account')]")).click();
        String expectedMessage ="Create New Customer Account";//verify the message
        WebElement actualMessage = driver.findElement(By.xpath("//span[@class='base']"));//find element for actualmessage
        String actualMessage1= actualMessage.getText();//Storing the actual message
        Assert.assertEquals("Error Message is not displayed",expectedMessage,actualMessage1);//comparing both message

    }
@Test
    public void userShouldRegisterAccountSuccessfully(){
        driver.findElement(By.xpath("//div[@class='panel header']//ul[@class='header links']//li//a[contains(text(),'Create an Account')]")).click();//find element crear an Account and click
        driver.findElement(By.id("firstname")).sendKeys("Khushbu579");//
        driver.findElement(By.id("lastname")).sendKeys("Chaudhari579");
        driver.findElement(By.name("is_subscribed")).click();
        driver.findElement(By.name("email")).sendKeys("kmchaudhari579@gmail.com");
        driver.findElement(By.id("password")).sendKeys("12345kmc@");
        driver.findElement(By.name("password_confirmation")).sendKeys("12345kmc@");
        driver.findElement(By.xpath("//div[@class='primary']//button[@class='action submit primary']")).click();
        String expectedMessage = "Thank you for registering with Main Website Store";
        WebElement actualMessage  = driver.findElement(By.xpath("//div[@class='message-success success message']"));
        String actualMessage1 = actualMessage.getText().substring(0,49);
        // System.out.println(actualMessage1);
        Assert.assertEquals("Error Message You are not successfully log in",expectedMessage,actualMessage1);
        driver.findElement(By.xpath("//div[@class='panel header']//button[@data-action='customer-menu-toggle']")).click();
        driver.findElement(By.xpath("//div[@class='panel wrapper']//div[@class='customer-menu']//a[@href='https://magento.softwaretestingboard.com/customer/account/logout/']")).click();
        String expectedResult ="You are signed out";
        WebElement actualResult = driver.findElement(By.xpath("//span[@class='base']"));
        String actualResult1 = actualResult.getText().substring(0,18);
       // System.out.println(actualResult1);
       Assert.assertEquals("Error",expectedResult,actualResult1);

    }




    @After
    public void tearDown() {
       // driver.quit();
        //  closeBrowser();
    }

}
