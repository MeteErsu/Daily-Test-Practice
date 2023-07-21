package tests.junit_Practice;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

public class P14_IFrame extends TestBase {

    @Test
    public void iframeTest (){
        //1 ) https://the-internet.herokuapp.com/iframe adresine gidin.
        //2 ) Bir metod olusturun: iframeTest

        driver.get("https://the-internet.herokuapp.com/iframe");

        //- “An IFrame containing….” textinin erisilebilir oldugunu test edin ve konsolda yazdirin.

        WebElement anIframeElementi= driver.findElement(By.tagName("h3"));
        Assert.assertTrue(anIframeElementi.isEnabled());
        System.out.println(anIframeElementi.getText());

        //- Text Box’a “Merhaba Dunya!” yazin.

        WebElement iFrameElementi = driver.findElement(By.id("mce_0_ifr"));
        driver.switchTo().frame(iFrameElementi);

        WebElement textBoxElementi = driver.findElement(By.tagName("p"));
        textBoxElementi.clear();
        textBoxElementi.sendKeys("Merhaba Dunya");

        //- TextBox’in altinda bulunan “Elemental Selenium” linkini textinin
        //gorunur oldugunu dogrulayin ve konsolda yazdirin.

        driver.switchTo().defaultContent();
        WebElement elementalSeleniumElementi = driver.findElement(By.xpath("//*[text() ='Elemental Selenium']"));
        Assert.assertTrue(elementalSeleniumElementi.isDisplayed());
        System.out.println(elementalSeleniumElementi.getText());

        elementalSeleniumElementi.click();

        wait(10);


    }

}
