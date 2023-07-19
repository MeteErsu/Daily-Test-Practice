package tests.junit_Practice;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import utilities.TestBase;

public class P6_Assertions extends TestBase {


    @Test
    public void yanlisEmailTesti (){
        //1. Bir Class olusturalim YanlisEmailTesti
        //2. https://www.n11.com/ sayfasina gidelim
        driver.get("https://www.n11.com/");
        //3. Giris yap butonuna basalim
        driver.findElement(By.xpath("//a[@class='btnSignIn']")).click();
        wait(2);
        //4. Email kutusuna @isareti olmayan bir mail yazip enter’a bastigimizda
        driver.findElement(By.xpath("//input[@id='email']")).sendKeys("metegmail.com"+ Keys.ENTER);
        // “Lütfen geçerli bir e-posta adresi girin.” uyarisi ciktigini test edelim
        wait(2);
        Assert.assertTrue(driver.findElement(By.xpath("//div[@data-errormessagefor='email']")).isDisplayed());

    }

}
