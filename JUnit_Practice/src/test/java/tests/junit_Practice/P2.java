package practice;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class P2 {

    static WebDriver driver ;
    @Before
    public void setUp (){

        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

    }

    @After
    public void tearDown(){
        driver.close();
    }

    @Test
    public void amazonCheckBoxTest () throws InterruptedException {

        driver.get("https://www.amazon.com/gp/goldbox?ref_=nav_cs_gb");

        //Prime Programs kismindaki ilk uc checkbox i locate edin
        //uc checkbox i isaretleyin
        //her uc checkbox in isaretli oldugunu dogrulayin

        WebElement birinciCB = driver.findElement(By.xpath("//input[@data-csa-c-element-id='filter-prime-eligible']"));
        WebElement ikinciCB = driver.findElement(By.xpath("//input[@data-csa-c-element-id='filter-prime-early-access']"));
        WebElement ucuncuCB = driver.findElement(By.xpath("//input[@data-csa-c-element-id='filter-prime-early-exclusive']"));

        if (!birinciCB.isSelected()){
            birinciCB.click();
        }
        Thread.sleep(2000);

        if (!ikinciCB.isSelected()){
            ikinciCB.click();
        }
        Thread.sleep(2000);

        if (!ucuncuCB.isSelected()){
            ucuncuCB.click();
        }
        Thread.sleep(2000);

        Assert.assertTrue(birinciCB.isSelected()&&ikinciCB.isSelected()&&ucuncuCB.isSelected());


    }




}
