package packt.selenium.task.tests;


import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.assertEquals;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import packt.selenium.task.pageobjects.GuerrillaMail;
import packt.selenium.task.pageobjects.Gmail;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.ie.InternetExplorerDriver;
/**
 * Created by Sufian on 9/27/2016.
 */
public class GuerrillaMailTest {
    private WebDriver driver;
    private GuerrillaMail GuerrillaMail;

    @Before
    public void setUp() throws Exception {
        System.setProperty("webdriver.chrome.driver",
               "C:\\Users\\Sufian\\Desktop\\chromedriver.exe");
       // System.setProperty("webdriver.ie.driver",
       //         "C:\\\\Users\\\\Sufian\\\\Desktop\\IEDriverServer.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }
    @After
    public void tearDown() throws Exception {
        driver.quit();
    }

    @Test
    public void taskTest_PageObjectDesignPattern() throws Exception {
        String to = "sufianamara92@gmail.com";
        String subject = "test";
        String body = "another test";
        String emaillogin = "_placeYourEmailHere";
        String password = "_PasswordHere";
        GuerrillaMail email= new GuerrillaMail(driver);
        email.sendEmail(to,subject,body);
        Gmail gmail = new Gmail(driver);
        gmail.openGmail(emaillogin,password);
        gmail.checkMail(to,subject,body);


    }
}
