package tests.junit_Practice;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import utilities.TestBase;

public class P5_Assertions extends TestBase {

    //1) Bir class oluşturun: YoutubeAssertions
    //2) https://www.youtube.com adresine gidin
    //3) Aşağıdaki adları kullanarak 4 test metodu oluşturun ve gerekli testleri yapin
    @Test
    public void titleTest() {
        //○ titleTest => Sayfa başlığının “YouTube” oldugunu test edin
        driver.get("https://www.youtube.com");
        String expectedTitle = "YouTube";
        String actualTitle = driver.getTitle();

        Assert.assertEquals(expectedTitle,actualTitle);
    }
    @Test
    public void imageTest() {
        //○ imageTest => YouTube resminin görüntülendiğini (isDisplayed()) test edin
        driver.get("https://www.youtube.com");
        Assert.assertTrue(driver.findElement(By.xpath("(//div[@class='style-scope ytd-topbar-logo-renderer'])[1]")).isDisplayed());
    }
    @Test
    public void searchBoxTest () {
        //○ Search Box 'in erisilebilir oldugunu test edin (isEnabled())
        driver.get("https://www.youtube.com");
        Assert.assertTrue(driver.findElement(By.xpath("//input[@id='search']")).isEnabled());

    }
    //○ wrongTitleTest => Sayfa basliginin “youtube” olmadigini dogrulayin

    @Test
    public void wrongTitleTest (){
        driver.get("https://www.youtube.com");
        String unexpectedTitle = "youtube";
        String actualTitle = driver.getTitle();

        Assert.assertNotEquals(unexpectedTitle,actualTitle);

    }
}
