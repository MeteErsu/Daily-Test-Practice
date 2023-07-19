package tests.junit_Practice;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import utilities.TestBase;

import java.util.List;

public class P9_HandleDropdown extends TestBase {

    @Test
    public void dropDownTest (){
        //● Bir class oluşturun: DropDown
        //● https://the-internet.herokuapp.com/dropdown adresine gidin.

        driver.get("https://the-internet.herokuapp.com/dropdown");

        //1.Index kullanarak Seçenek 1’i (Option 1) seçin ve yazdırın

        WebElement dropDownMenu = driver.findElement(By.xpath("//select[@id='dropdown']"));

        Select select = new Select(dropDownMenu);

        select.selectByIndex(1);
        System.out.println("index ile secilen Seçenek 1 "+select.getFirstSelectedOption().getText());
        wait(2);
        //2.Value kullanarak Seçenek 2'yi (Option 2) seçin ve yazdırın

        select.selectByValue("2");
        System.out.println("value ile secilen Seçenek 2 "+select.getFirstSelectedOption().getText());
        wait(2);
        //3.Visible Text(Görünen metin) kullanarak Seçenek 1’i (Option 1) seçin ve yazdırın

        select.selectByVisibleText("Option 1");
        System.out.println("Visible Text ile secilen Seçenek 1 "+select.getFirstSelectedOption().getText());
        wait(2);

        //4.Tüm dropdown değerleri(value) yazdırın

        List<WebElement> dropDownListesi =select.getOptions();
        for (WebElement eachElement: dropDownListesi
             ) {
            System.out.println(eachElement.getText());
        }

        //5. Dropdown’un boyutunun 4 olduğunu test edin

        int expectedBoyut = 4;
        int actualBoyut = dropDownListesi.size();

        Assert.assertEquals(expectedBoyut,actualBoyut);

    }

}
