package tests.junit_Practice;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class P1 {
    // Kullanici https://www.google.com adresine gider
    // Çıkıyorsa Kullanici cookies i kabul eder
    // Arama Kutusuna karşilastirma yapmak istedigi para birimlerini girer
    // Para birimlerinin karsilastirmasini alin usdt ti tl
    // Karsilastirilacak olan para biriminin 30 dan kucuk oldugu test edilir
    // yorum yapılabilir

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
    public void test01 (){

        driver.get("https://www.google.com");
        driver.findElement(By.xpath("//*[@id='APjFqb']")).sendKeys("usd to tl"+ Keys.ENTER);
        WebElement sonuc = driver.findElement(By.xpath("//span[@class='DFlfde SwHCTb']"));
        String sonucStr = sonuc.getText().replaceAll(",",".");
        Double sonucDouble = Double.parseDouble(sonucStr);
        Assert.assertTrue(sonucDouble<30);



    }
}
