package SeleniumEdu;

import com.gargoylesoftware.htmlunit.javascript.background.JavaScriptExecutor;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.*;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.concurrent.TimeUnit;

public class Travel {
    static {
        System.setProperty("webdriver.chrome.driver", "drv/chromedriver.exe");
    }
    private static WebDriver drv = new ChromeDriver();

    public static void main(String[] args) throws InterruptedException {
        System.out.println("Travel");
        drv.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        drv.manage().window().maximize();
        drv.get("https://www.rgs.ru/");

        findElementAndClick("//*/ol/li/a[contains(text(), 'Страхование')]");
        findElementAndClick("//*[contains(text(), 'Выезжающим за рубеж')]");

        JavascriptExecutor jseScroller = (JavascriptExecutor)drv;  /* скороллер страницы */
        jseScroller.executeScript("scroll(0, 1000);");
        findElementAndClick("//*[text()=' ок ']");
        findElementAndClick("//*/a[contains(text(), 'Рассчитать')]");

        jseScroller.executeScript("window.scrollBy(0,-250)", "");

        /** Поиск нужного текста */
        findText(
                "Страхование выезжающих за рубеж",
                drv.findElement(By.xpath("//div[@class='page-header']/span [@class ='h1']")).getText().trim()
        );

        findElementAndClick("//*[contains(@class, 'btn-content-subtitle small')]");
        jseScroller.executeScript("scroll(0, 500);");
        drv.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        fillForm(By.xpath("//*[contains(@class, 'actual-input')]"), "шенген");
        findElementAndClick("//*[contains(@class, 'tt-menu tt')]");
        findElementAndClick("//*[contains(@ id, 'ArrivalCountryList')]");
        new Select(drv.findElement(By.name("ArrivalCountryList"))).selectByVisibleText("Испания");
        findElementAndClick("//*[contains(@data-bind, 'value: FirstDepartureDate.')]");

        /** @see Iselen функциональный интерфейс, возвращает дату поездки +14 дней */
        Iselen dateOfJourney = () -> {
            LocalDate today = LocalDate.now();
            LocalDate date = today.plus(14, ChronoUnit.DAYS);
            String[] split = date.toString().split("-");
            StringBuilder builder = new StringBuilder();
            for (int i = split.length - 1; i >= 0; i--) {
                builder.append(split[i]);
            }
            return builder.toString();
        };
        fillForm(By.xpath("//*[contains(@data-bind, 'value: FirstDepartureDate.')]"), dateOfJourney.function());
        findElementAndClick("//*[contains(@data-bind, 'btnRadioGroupValue: 90')]");

        jseScroller.executeScript("window.scrollBy(0,460)", "");
        String temp = "//*[contains(@class, 'form-control')][contains(@data-bind, 'attr: _params.fullName.attr,')]";
        findElementAndClick(temp);
        fillForm(By.xpath(temp), "Yushin Ivan");
        temp = "//*[contains(@data-bind, 'value: BirthDay.computedView')]";
        findElementAndClick(temp);

        String birthDate = "01111990";
        fillForm(By.xpath(temp), birthDate);
        findElementAndClick("//*[contains(text(), 'активный отдых или спорт')]/ancestor::div[@class=\"calc-vzr-toggle-risk-group\"]//div[@class=\"toggle off toggle-rgs\"]");

        jseScroller.executeScript("scroll(0, 1600);");
        drv.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        findElementAndClick("//*[contains(@data-test-name, 'IsProcessingPersonalDataToCalculate')]");
        findElementAndClick("//*[contains(@data-bind, 'disable: Misc.NextButtonDisabled')]");
        drv.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        validationErrorTexts();
    }

    /**
     *
     * валидация полей ввода
     * на текущий момент только год рождения
     */
    public static void validationErrorTexts(){
        try {
            boolean checkCorrectDate = drv.findElement(By.xpath("//*[text()='Неверная дата']")).getText().equalsIgnoreCase("Неверная дата");
            if (checkCorrectDate){
                System.err.println("Введён некорректный формат даты");
                drv.quit();
            }
        } catch (NoSuchElementException ex){
            System.out.println("Дата введена корректно");
        } catch (NullPointerException ex){
            System.out.println("Дата введена корректно");
        }
    }

    /**
     *
     * @param locator
     * @param fill текст который заполняем в форму
     */
    public static void fillForm(By locator, String fill){
        drv.findElement(locator).click();
        drv.findElement(locator).clear();
        drv.findElement(locator).sendKeys(fill);
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