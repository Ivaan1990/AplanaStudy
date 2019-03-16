package SeleniumEdu;

import com.gargoylesoftware.htmlunit.javascript.background.JavaScriptExecutor;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.*;

import java.util.concurrent.TimeUnit;

public class Travel {
    static {
        System.setProperty("webdriver.chrome.driver", "drv/chromedriver.exe");
    }
    private static WebDriver drv = new ChromeDriver();

    public static void main(String[] args) throws InterruptedException {
        System.out.println("Travel");
        drv.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        drv.manage().window().maximize();
        drv.get("https://www.rgs.ru/");

        findElementAndClick("//*/ol/li/a[contains(text(), 'Страхование')]");
        findElementAndClick("//*[contains(text(), 'Выезжающим за рубеж')]");

        // скролим вниз
        WebElement scroll = drv.findElement(By.xpath("//*/a[contains(text(), 'Рассчитать')]"));
        for (int i = 0; i < 3; i++) {
            scroll.sendKeys(Keys.ARROW_DOWN);
        }
        Thread.sleep(500);
        findElementAndClick("//*/a[contains(text(), 'Рассчитать')]");
        findElementAndClick("//*[text()=' ок ']");

        JavascriptExecutor jse = (JavascriptExecutor)drv;
        //Thread.sleep(500);
        jse.executeScript("window.scrollBy(0,-250)", "");

        /** Поиск нужного текста */
        findText(
                "Страхование выезжающих за рубеж",
                drv.findElement(By.xpath("//div[@class='page-header']/span [@class ='h1']")).getText().trim()
        );

        Wait<WebDriver> wait = new WebDriverWait(drv, 10,1000);
        wait.until(ExpectedConditions.visibilityOf(drv.findElement(By.xpath("//*[text()=' в течение года ']"))));


        findElementAndClick("//*[text()=' в течение года ']");

        jse.executeScript("scroll(0, 500);");
        fillForm(By.xpath("//*[contains(@class, 'actual-input')]"), "шенген");
        findElementAndClick("//*[contains(@class, 'tt-menu tt')]");
        findElementAndClick("//*[contains(@ id, 'ArrivalCountryList')]");

        new Select(drv.findElement(By.name("ArrivalCountryList"))).selectByVisibleText("Испания");
        findElementAndClick("//*[contains(@data-bind, 'value: FirstDepartureDate.')]");
        String temp = "30032019";
        fillForm(By.xpath("//*[contains(@data-bind, 'value: FirstDepartureDate.')]"), temp);
        findElementAndClick("//*[contains(@data-bind, 'btnRadioGroupValue: 90')]");
        jse.executeScript("window.scrollBy(0,460)", "");
        Thread.sleep(400);
        temp = "//*[contains(@class, 'form-control')][contains(@data-bind, 'attr: _params.fullName.attr,')]";
        findElementAndClick(temp);
        fillForm(By.xpath(temp), "Yushin Ivan");
        temp = "//*[contains(@data-bind, 'value: BirthDay.computedView')]";
        findElementAndClick(temp);
        fillForm(By.xpath(temp), "01111990");
        Thread.sleep(400);
        findElementAndClick("//*[contains(@class, 'toggle toggle-rgs off')]");
        //jse.executeScript("window.scrollBy(0,460)", "");
    }

    /**
     * 01:52 про филлформ
     * @param locator
     * @param destination текст который заполняем в форму
     */
    public static void fillForm(By locator, String destination){
        drv.findElement(locator).click();
        drv.findElement(locator).clear();
        drv.findElement(locator).sendKeys(destination);
    }

    /**
     *
     * @param xPath параметр принимает xpath
     */
    private static void findElementAndClick(String xPath){
        drv.findElement(By.xpath(xPath)).click();
    }

    /**
     *
     * @param text первый параметр текст который хотим найти
     * @param line второй который извлечён из страницы drv.findElement
     */
    private static void findText(String text, String line) {
        if (text.equalsIgnoreCase(line)){
            System.out.println("Заголовок соответствует требуемому");
        } else {
            System.out.println("Заголовок не соответствует заданному");
        }
    }
}