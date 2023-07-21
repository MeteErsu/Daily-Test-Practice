package tests.junit_Practice;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import utilities.TestBase;

public class P12_Alert extends TestBase {

     @Test
     public void test01(){
      //1. Test
      //- https://the-internet.herokuapp.com/javascript_alerts adresine gidin

      driver.get("https://the-internet.herokuapp.com/javascript_alerts");

      //- 1.alert'e tiklayin

      driver.findElement(By.xpath("//button[@onclick='jsAlert()']")).click();

      //- Alert'deki yazinin "I am a JS Alert" oldugunu test edin

      String expectedAlert = "I am a JS Alert";
      String actualAlert = driver.switchTo().alert().getText();

      Assert.assertEquals(expectedAlert,actualAlert);
      wait(3);

      //- OK tusuna basip alert'i kapatin

      driver.switchTo().alert().accept();

     }

     @Test
     public void test02(){

      //2.Test
      //- https://the-internet.herokuapp.com/javascript_alerts adresine gidin

      driver.get("https://the-internet.herokuapp.com/javascript_alerts");

      //- 2.alert'e tiklayalim

      driver.findElement(By.xpath("//button[@onclick='jsConfirm()']")).click();
      wait(2);

      //- Cancel'a basip, cikan sonuc yazisinin "You clicked: Cancel" oldugunu test edin

      driver.switchTo().alert().dismiss();
      wait(3);

      String expectedSonucYazisi = "You clicked: Cancel";
      String actualSonucYazisi = driver.findElement(By.xpath("//p[@id='result']")).getText();

      Assert.assertEquals(expectedSonucYazisi,actualSonucYazisi);
     }
     @Test
     public void test03(){

      //3.Test
      //- https://the-internet.herokuapp.com/javascript_alerts adresine gidin

      driver.get("https://the-internet.herokuapp.com/javascript_alerts");

      //- 3.alert'e tiklayalim

      driver.findElement(By.xpath("//button[@onclick='jsPrompt()']")).click();
      wait(2);

      //- Cikan prompt ekranina "Abdullah" yazdiralim

      driver.switchTo().alert().sendKeys("Abdullah");
      wait(2);

      //- OK tusuna basarak alert'i kapatalim

      driver.switchTo().alert().accept();
      wait(2);

      //- Cikan sonuc yazisinin Abdullah icerdigini test edelim

      String expectedIcerik = "Abdullah";
      String actualSonucIcerik = driver.findElement(By.xpath("//p[@id='result']")).getText();

      Assert.assertTrue(actualSonucIcerik.contains(expectedIcerik));

     }




}
