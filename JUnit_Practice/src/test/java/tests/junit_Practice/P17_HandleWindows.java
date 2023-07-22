package tests.junit_Practice;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import utilities.TestBase;

import java.util.Set;

public class P17_HandleWindows extends TestBase {


    @Test
    public void windowHandle2 (){

        //● Tests package’inda yeni bir class olusturun: WindowHandle2
        //● https://the-internet.herokuapp.com/windows adresine gidin.

        driver.get("https://the-internet.herokuapp.com/windows");
        String ilkWHD = driver.getWindowHandle();

        //● Sayfadaki textin “Opening a new window” olduğunu doğrulayın.

        String expectedText = "Opening a new window";
        String actualText = driver.findElement(By.tagName("h3")).getText();
        Assert.assertEquals(expectedText,actualText);

        //● Sayfa başlığının(title) “The Internet” olduğunu doğrulayın.

        String expectedTitleIlk = "The Internet";
        String actualTitleIlk = driver.getTitle();
        Assert.assertEquals(expectedTitleIlk,actualTitleIlk);

        //● Click Here butonuna basın.

        driver.findElement(By.xpath("//a[@href='/windows/new']")).click();

        //● Acilan yeni pencerenin sayfa başlığının (title) “New Window” oldugunu dogrulayin.

        Set<String> wHDSeti = driver.getWindowHandles();
        String ikinciWHD = "";
        for (String each:wHDSeti
             ) {
            if (!each.equals(ilkWHD)){
                ikinciWHD=each;
            }
        }

        driver.switchTo().window(ikinciWHD);
        String expectedTitleIkinci = "New Window";
        String actualTitleIkinci = driver.getTitle();
        Assert.assertEquals(actualTitleIkinci,actualTitleIkinci);

        //● Sayfadaki textin “New Window” olduğunu doğrulayın.

        String expectedTextIkinci = "New Window";
        String actualTextIkinci = driver.findElement(By.tagName("h3")).getText();
        Assert.assertEquals(expectedTextIkinci,actualTextIkinci);

        //● Bir önceki pencereye geri döndükten sonra sayfa başlığının “The Internet”
        //olduğunu doğrulayın.

        driver.switchTo().window(ilkWHD);

        String expectedTitleSon = "The Internet";
        String actualTitleSon = driver.getTitle();
        Assert.assertEquals(expectedTitleSon,actualTitleSon);

    }

}
