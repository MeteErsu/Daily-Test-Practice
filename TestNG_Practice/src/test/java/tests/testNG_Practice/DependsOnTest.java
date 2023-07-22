package tests.testNG_Practice;


import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.AmazonPage;
import utilities.ConfigReader;
import utilities.Driver;

import static org.testng.TestRunner.PriorityWeight.dependsOnMethods;

public class DependsOnTest {

    @Test
    public void anasayfaTest () {

        //● Bir class oluşturun: DependsOnTest
        //● https://www.amazon.com/ adresine gidin.
        //1. Test : Amazon ana sayfaya gittiginizi test edin
        Driver.getDriver().get(ConfigReader.getProperty("amazonUrl"));
        String expectedUrl = "https://www.amazon.com/";
        String actualUrl = Driver.getDriver().getCurrentUrl();
        Assert.assertEquals(actualUrl, expectedUrl);

    }
    @Test (dependsOnMethods = "anasayfaTest")
    public void aramaTesti () {

        //2. Test : 1.Test basarili ise search Box’i kullanarak “Nutella” icin arama yapin
        //ve aramanizin gerceklestigini Test edin

        AmazonPage amazonPage = new AmazonPage();
        amazonPage.aramaKutusu.sendKeys(ConfigReader.getProperty("amazonArananKelime")+ Keys.ENTER);
    }
    @Test (dependsOnMethods = "aramaTesti")
    public void urunFiyatTesti (){
        //3.Test : “Nutella” icin arama yapildiysa ilk urunu tiklayin ve fiyatinin $16.83
        //oldugunu test edin
        AmazonPage amazonPage = new AmazonPage();
        String expectedFiyat = "16.83";
        String actualFiyat = Driver.getDriver().findElement(By.xpath("(//span[@class='a-price'])[1]")).getText();
        Assert.assertEquals(actualFiyat,expectedFiyat);
        Driver.closeDriver();
    }

}
