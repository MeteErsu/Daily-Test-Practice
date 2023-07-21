package tests.junit_Practice;

import org.junit.Test;
import org.openqa.selenium.By;
import utilities.TestBase;

public class P11_HandleDropdown extends TestBase {

    @Test
    public void dropDownTest (){
        //1. http://zero.webappsecurity.com/ Adresine gidin

        driver.get("http://zero.webappsecurity.com/");

        //2. Sign in butonuna basin

        driver.findElement(By.xpath("//button[@id='signin_button']")).click();

        //3. Login kutusuna “username” yazin

        driver.findElement(By.xpath("//input[@id='user_login']")).sendKeys("username");
        wait(2);

        //4. Password kutusuna “password.” yazin

        driver.findElement(By.xpath("//input[@id='user_password']")).sendKeys("password");
        wait(2);

        //5. Sign in tusuna basin

        driver.findElement(By.xpath("//input[@name='submit']")).click();

        //6. Pay Bills sayfasina gidin



        //7. “Purchase Foreign Currency” tusuna basin
        //8. “Currency” drop down menusunden Eurozone’u secin
        //9. “amount” kutusuna bir sayi girin
        //10. “US Dollars” in secilmedigini test edin
        //11. “Selected currency” butonunu secin
        //12. “Calculate Costs” butonuna basin sonra “purchase” butonuna basin
        //13. “Foreign currency cash was successfully purchased.” yazisinin ciktigini
        //kontrol edin.



    }

}
