package tests.testNG_Practice;


import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.ConfigReader;
import utilities.Driver;

public class YoutubeAssertions {


    //1) https://www.youtube.com adresine gidin
    //2) Aşağıdaki adları kullanarak 4 test metodu oluşturun ve gerekli testleri yapin

    @Test
    public void titleTest (){

        //○ titleTest => Sayfa başlığının “YouTube” oldugunu test edin
        Driver.getDriver().get(ConfigReader.getProperty("youtubeUrl"));
        String expectedTitle = "YouTube";
        String actualTitle = Driver.getDriver().getTitle();
        Assert.assertEquals(actualTitle,expectedTitle);
        Driver.closeDriver();

    }
    @Test
    public void imageTest () {

        //○ imageTest => YouTube resminin görüntülendiğini (isDisplayed()) test edin
        Driver.getDriver().get(ConfigReader.getProperty("youtubeUrl"));
        Assert.assertTrue(Driver.getDriver().findElement(By.xpath("(//a[@id='logo'])[1]")).isDisplayed());
        Driver.closeDriver();

    }
    @Test
    public void searchBoxTest () {

        //○ Search Box 'in erisilebilir oldugunu test edin (isEnabled())
        Driver.getDriver().get(ConfigReader.getProperty("youtubeUrl"));
        Assert.assertTrue(Driver.getDriver().findElement(By.xpath("//input[@id='search']")).isEnabled());
        Driver.closeDriver();

    }
    @Test
    public void wrongTitleTest () {

        //○ wrongTitleTest => Sayfa basliginin “youtube” olmadigini dogrulayin
        Driver.getDriver().get(ConfigReader.getProperty("youtubeUrl"));
        String expectedTitle = "youtube";
        String actualTitle = Driver.getDriver().getTitle();
        Assert.assertFalse(actualTitle.equals(expectedTitle));
        Driver.closeDriver();

    }
}
