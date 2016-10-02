package packt.selenium.task.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.concurrent.TimeUnit;
/**
 * Created by Sufian on 9/27/2016.
 */
public class GuerrillaMail {
    private WebDriver driver;
    private String baseUrl;

    public GuerrillaMail(WebDriver driver) {

        this.driver = driver;
        driver.manage().window().maximize();
        baseUrl = "https://www.guerrillamail.com";
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.get(baseUrl + "/");



    }

    public void sendEmail (String to, String subject, String body){
        driver.findElement(By.id("nav-item-compose")).click();

        driver.findElement(By.name("to")).sendKeys(to);
        driver.findElement(By.name("subject")).sendKeys(subject);
        driver.findElement(By.name("body")).sendKeys(body);
        driver.findElement(By.id("send-button")).click();
        //  driver.findElement(By.id("recaptcha-anchor")).click();
    }
}
