package tests.junit_Practice;

import org.junit.Test;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

import javax.swing.*;

public class P18_Actions_Mause extends TestBase {

    @Test
    public void mouseActions1 (){

        //1- Yeni bir class olusturalim: MouseActions1
        //2- https://the-internet.herokuapp.com/context_menu sitesine gidin

        driver.get("https://the-internet.herokuapp.com/context_menu");

        //3- Cizili alan uzerinde sag click yapin

        Actions action = new Actions(driver)

        //4- Alert’te cikan yazinin “You selected a context menu” oldugunu test edin.
        //5- Tamam diyerek alert’i kapatalim
        //6- Elemental Selenium linkine tiklayalim
        //7- Acilan sayfada h1 taginda “Elemental Selenium” yazdigini test edelim

    }

}
