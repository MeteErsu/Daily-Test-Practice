package tests.junit_Practice;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import utilities.TestBase;

import java.security.PublicKey;

public class P4_Assertions extends TestBase {


    // https://www.bestbuy.com/ Adresine gidin farkli test method’lari olusturarak
    //   asagidaki testleri yapin




    @Test
    //○ Sayfa URL’inin https://www.bestbuy.com/ ‘a esit oldugunu test edin
        public void urlTest (){
        driver.get("https://www.bestbuy.com/");
        String expectedUrl = "https://www.bestbuy.com/";
        String actualUrl = driver.getCurrentUrl();

        Assert.assertEquals(expectedUrl,actualUrl);

    }
    @Test
    //○ titleTest => Sayfa başlığının “Rest” içermediğini(contains) test edin
    public void titleTest (){
        driver.get("https://www.bestbuy.com/");
        String unexpectedIcerik = "Rest";
        String actualTitle = driver.getTitle();

        Assert.assertFalse(actualTitle.contains(unexpectedIcerik));
    }

    @Test
    //○ logoTest => BestBuy logosunun görüntülendigini test edin
    public void logoTest (){
        driver.get("https://www.bestbuy.com/");
        Assert.assertTrue(driver.findElement(By.className("logo")).isDisplayed());
    }

    @Test
    //○ FrancaisLinkTest => Fransizca Linkin görüntülendiğini test edin
    public void francaisLinkTest (){
        driver.get("https://www.bestbuy.com/");
        Assert.assertTrue(driver.findElement(By.xpath("//button[@lang='fr']")).isDisplayed());
    }


}
