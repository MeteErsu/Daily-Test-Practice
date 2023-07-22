package tests.junit_Practice;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

import java.util.List;

public class P15_IFrame extends TestBase {

    @Test
    public void iframeTest (){

        //1) http://demo.guru99.com/test/guru99home/ sitesine gidiniz

        driver.get("http://demo.guru99.com/test/guru99home/");

        //2) sayfadaki iframe sayısını bulunuz.

        List<WebElement> iframeList = driver.findElements(By.tagName("iframe"));
        int iframeCount = iframeList.size();
        System.out.println(iframeCount);
        wait(3);

        //3) ilk iframe'deki (Youtube) play butonuna tıklayınız.

        driver.switchTo().frame(0);

        driver.findElement(By.xpath("//button[@aria-label='Oynat']")).click();
        wait(3);

        //4) ilk iframe'den çıkıp ana sayfaya dönünüz

        driver.switchTo().defaultContent();

        //5) ikinci iframe'deki (Jmeter Made Easy) linke (https://www.guru99.com/live-selenium-project.html) tıklayınız

        driver.switchTo().frame(1);
        driver.findElement(By.xpath("//a[@href='http://www.guru99.com/live-selenium-project.html']")).click();
        wait(3);



    }

}
