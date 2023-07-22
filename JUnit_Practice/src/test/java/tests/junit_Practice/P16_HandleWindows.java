package tests.junit_Practice;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.WindowType;
import utilities.TestBase;

import java.sql.SQLOutput;
import java.util.Set;

public class P16_HandleWindows extends TestBase {

    @Test
    public void windowHandleTest (){

        //● Yeni bir class olusturun: WindowHandle
        //● Amazon anasayfa adresine gidin.

        driver.get("https://www.amazon.com");

        //● Sayfa’nin window handle degerini String bir degiskene atayin

        String amazonWHDegeri = driver.getWindowHandle();
        System.out.println(amazonWHDegeri);

        //● Sayfa title’nin “Amazon” icerdigini test edin

        String expectedTitleAmazon = "Amazon";
        String actualTitleAmazon = driver.getTitle();
        Assert.assertTrue(actualTitleAmazon.contains(expectedTitleAmazon));
        wait(2);

        //● Yeni bir tab olusturup, acilan tab’da wisequarter.com adresine gidin

        driver.switchTo().newWindow(WindowType.TAB).get("https://www.wisequarter.com");

        //● Sayfa title’nin “wisequarter” icerdigini test edin

        Set<String> wHDegerleri = driver.getWindowHandles();
        System.out.println(wHDegerleri);
        String wiseWHDegeri = "";
        for (String each:wHDegerleri
             ) {
            if (!each.equals(amazonWHDegeri)){
                wiseWHDegeri=each;
            }
        }

        driver.switchTo().window(wiseWHDegeri);
        System.out.println(wiseWHDegeri);
        System.out.println(driver.getTitle());
        String expectedTitleWise = "Wise";
        String actualTitleWise = driver.getTitle();
        Assert.assertTrue(actualTitleWise.contains(expectedTitleWise));
        wait(2);

        //● Yeni bir window olusturup, acilan sayfada walmart.com adresine gidin

        driver.switchTo().newWindow(WindowType.WINDOW).get("https://www.walmart.com");

        //● Sayfa title’nin “Walmart” icerdigini test edin

        System.out.println(driver.getTitle());
     /*   String walmartWHDegeri = "";
        for (String each:wHDegerleri
        ) {
            if (!(amazonWHDegeri.equals(each) && wiseWHDegeri.equals(each))){
                walmartWHDegeri=each;
            }
        }
        driver.switchTo().window(walmartWHDegeri);*/
        String expectedTitleWalmart = "Walmart";
        String actualTitleWalmart = driver.getTitle();
        Assert.assertTrue(actualTitleWalmart.contains(expectedTitleWalmart));
        wait(2);

        //● Ilk acilan sayfaya donun ve amazon sayfasina dondugunuzu test edin

        driver.switchTo().window(amazonWHDegeri);
        String expectedUrlAmazon = "https://www.amazon.com/";
        String actualUrlAmazon = driver.getCurrentUrl();
        Assert.assertEquals(expectedUrlAmazon,actualUrlAmazon);
        wait(2);



    }

}
