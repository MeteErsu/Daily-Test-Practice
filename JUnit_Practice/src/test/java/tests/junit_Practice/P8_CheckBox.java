package tests.junit_Practice;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

public class P8_CheckBox extends TestBase {
    @Test
    public void checkBoxTest (){

        //a. Verilen web sayfasına gidin.https://facebook.com
        driver.get("https://facebook.com");
        //b. Cookies’i kabul edin
        //c. Create an account buton’una basin

        driver.findElement(By.xpath("//a[@data-testid='open-registration-form-button']")).click();

        //d. Radio button elementlerini locate edin ve size uygun olani secin

        WebElement kadinRadioButton = driver.findElement(By.xpath("(//input[@name='sex'])[1]"));
        WebElement erkekRadioButton = driver.findElement(By.xpath("(//input[@name='sex'])[2]"));
        WebElement ozelRadioButton = driver.findElement(By.xpath("(//input[@name='sex'])[3]"));

        erkekRadioButton.click();
        wait(3);

        //e. Sectiginiz radio button’un seçili, ötekilerin seçili olmadigini test edin

        Assert.assertTrue(erkekRadioButton.isSelected());
        Assert.assertFalse(kadinRadioButton.isSelected());
        Assert.assertFalse(ozelRadioButton.isSelected());
    }

}
