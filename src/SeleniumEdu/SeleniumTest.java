package SeleniumEdu;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class SeleniumTest {
    private static WebDriver drv;

    public static void main(String[] args) throws InterruptedException {
        System.out.println("Test start");
        System.setProperty("webdriver.chrome.driver", "drv/chromedriver.exe");

        drv = new ChromeDriver();
        drv.manage().timeouts().implicitlyWait(30, TimeUnit .SECONDS);
        drv.manage().window().maximize();
        drv.get("https://www.rgs.ru/");

        //Thread.sleep(800);
        drv.findElement(By.xpath("//*/ol/li/a[contains(text(), 'Страхование')]")).click();
       // Thread.sleep(1200);
        drv.findElement(By.xpath("//li[contains(@class, 'link')]/a[contains(text(), 'ДМС')]")).click();

        //проверяем на наличие текста
        String text = drv.findElement(By.xpath("//span[@class='h1']")).getText();
        compareText(text, "Дбровольное медицинское страхование (ДМС)");
    }

    private static void compareText(String actual, String expected){
        if (actual.contains(expected)){
            System.out.println("Текст верный: " + expected);
        } else {
            System.err.println("Мы ищем: " + expected + "\nВместо него " + actual);
        }
    }
}