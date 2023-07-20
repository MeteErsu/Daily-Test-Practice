package tests.junit_Practice;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import utilities.TestBase;

import java.util.List;

public class P10_HandleDropdown extends TestBase {

    @Test
    public void DropDownAmazon () {
        //● Bir class oluşturun: C3_DropDownAmazon
        //● https://www.amazon.com/ adresine gidin.
        //- Test 1
        driver.get("https://www.amazon.com/");
        //Arama kutusunun yanindaki kategori menusundeki kategori sayisinin 45
        //oldugunu test edin

        WebElement dropDownMenu = driver.findElement(By.id("searchDropdownBox"));

        Select select = new Select(dropDownMenu);

        List<WebElement> kategoriListesi = select.getOptions();

        int expectedKategoriSayisi = 45;
        int actualKategoriSayisi = kategoriListesi.size();

        Assert.assertEquals(expectedKategoriSayisi, actualKategoriSayisi);
    }

        @Test
        public void booksTest (){
            //-Test 2
            driver.get("https://www.amazon.com/");

            WebElement dropDownMenu = driver.findElement(By.id("searchDropdownBox"));
            Select select = new Select(dropDownMenu);

            //1. Kategori menusunden Books secenegini secin

            select.selectByIndex(5);

            //2. Arama kutusuna Java yazin ve aratin

            driver.findElement(By.id("twotabsearchtextbox")).sendKeys("Java"+ Keys.ENTER);

            //3. Bulunan sonuc sayisini yazdirin

            String sonucYazisi = driver.findElement(By.xpath("//h1[@class='a-size-base s-desktop-toolbar a-text-normal']")).getText();

            //4. Sonucun Java kelimesini icerdigini test edin

            Assert.assertTrue(sonucYazisi.contains("Java"));
        }




    }



