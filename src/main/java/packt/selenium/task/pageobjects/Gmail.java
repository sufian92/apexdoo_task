package packt.selenium.task.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import java.util.*;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;
/**
 * Created by Sufian on 9/27/2016.
 */
public class Gmail {
    private WebDriver driver;
    private String baseUrl;

    public Gmail(WebDriver driver) {

        this.driver = driver;
        driver.manage().window().maximize();
        baseUrl = "https://accounts.google.com/ServiceLogin?service=mail&continue=https://mail.google.com/mail/#identifier";
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.get(baseUrl + "/");


    }

    public void openGmail (String email, String password ){
        driver.findElement(By.name("Email")).sendKeys(email);
        driver.findElement(By.id("next")).click();
        driver.findElement(By.name("Passwd")).sendKeys(password);
        driver.findElement(By.id("signIn")).click();
        WebDriverWait wait = new WebDriverWait(driver,180);
        wait.until(ExpectedConditions.textToBePresentInElementLocated(By.cssSelector("[href='https://mail.google.com/mail/u/0/#inbox']"),"Inbox (1)"));
        driver.findElement(By.className("yW")).click();




    }

    public void checkMail (String to, String subjectfrom, String textfrom){
        String subject = driver.findElement(By.className("hP")).getText();
        String email = driver.findElement(By.cssSelector("[email='sufianamara92@gmail.com']")).getText();
        String text = driver.findElement(By.xpath("//div[@dir = 'ltr']//div//p")).getText();
        //System.out.println(subject);
       // System.out.println(email);
       // System.out.println(text);

        if (!email.equals("me") || !subject.equals(subjectfrom) || !text.equals(textfrom)){
            throw new WrongDataException("The sent email does not match the received email! ");
        }

    }
}
