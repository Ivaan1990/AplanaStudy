package SeleniumEdu;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.*;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.concurrent.TimeUnit;

/**
 *
 * @author Ivan Yushin
 * @see #fillForm(By, String)
 * @see #findElementAndClick(String)
 * @see #scrollPage(String)
 */
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

        scrollPage("//*[contains(@class, 'thumbnail-footer')]/a[contains(text(),'Рассчитать')]"); /* Скроллер */
        findElementAndClick("//*[text()=' ок ']");
        findElementAndClick("//*[contains(@class, 'thumbnail-footer')]/a[contains(text(),'Рассчитать')]");
        findText(
                "Страхование выезжающих за рубеж",
                drv.findElement(By.xpath("//div[@class='page-header']/span [@class ='h1']")).getText().trim()
        );
        Wait<WebDriver> wait = new WebDriverWait(drv, 10,1000);
        wait.until(ExpectedConditions.visibilityOf(drv.findElement(By.xpath("//*[contains(@data-test-value, 'Multiple')]"))));
        findElementAndClick("//*[contains(@data-test-value, 'Multiple')]");

        scrollPage("//*[contains(@class, 'actual-input')]");
        wait.until(ExpectedConditions.visibilityOf(drv.findElement(By.xpath("//*[contains(@class, 'actual-input')]"))));
        fillForm(By.xpath("//*[contains(@data-bind, 'attr: _params.input,')]"), "шенген");  // вводим страну

        scrollPage("//*[contains(@class, 'btn-content-subtitle small')]");
        findElementAndClick("//*[contains(@class, 'tt-menu tt')]");
        findElementAndClick("//*[contains(@ id, 'ArrivalCountryList')]");
        new Select(drv.findElement(By.name("ArrivalCountryList"))).selectByVisibleText("Испания");
        findElementAndClick("//*[contains(@data-bind, 'value: FirstDepartureDate.')]");
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
        String date = dateOfJourney.function();
        while (true){
            fillForm(By.xpath("//*[contains(@data-bind, 'value: FirstDepartureDate.')]"), date); // ДАТА ПОЕЗДКИ
            String val = drv.findElement(By.xpath("//*[contains(@data-bind, 'value: FirstDepartureDate.')]")).getAttribute("value");
            if (validationForm(date, val)){
                System.out.println("Дата поездки корректна");
                break;
            }
            System.err.println("Дата поездки введена некорректно, пробуем еще раз");
        }
        findElementAndClick("//*[contains(@data-bind, 'btnRadioGroupValue: 90')]");

        scrollPage("//*[contains(@class, 'form-control')][contains(@data-bind, 'attr: _params.fullName.attr,')]");
        String temp = "//*[contains(@class, 'form-control')][contains(@data-bind, 'attr: _params.fullName.attr,')]";
        findElementAndClick(temp);
        fillForm(By.xpath(temp), "Yushin Ivan"); // ФАМИЛИЯ ИМЯ

        temp = "//*[contains(@data-bind, 'value: BirthDay.computedView')]";
        findElementAndClick(temp);
        String birthDate = "01111990";
        while (true){
            fillForm(By.xpath(temp), birthDate); // ДАТА РОЖДЕНИЯ
            String val = drv.findElement(By.xpath(temp)).getAttribute("value");
            if(validationForm(birthDate, val)) {
                System.out.println("Дата рождения введена корректно");
                break;
            }
            System.err.println("Дата рождения введена не корректно, исправляем");
        }

        scrollPage("//*[contains(@data-test-name, 'IsProcessingPersonalDataToCalculate')]");
        findElementAndClick("//*[contains(text(), 'активный отдых или спорт')]/ancestor::div[@class=\"calc-vzr-toggle-risk-group\"]//div[@class=\"toggle off toggle-rgs\"]");
        scrollPage("//*[contains(@data-test-name, 'IsProcessingPersonalDataToCalculate')]");
        findElementAndClick("//*[contains(@data-test-name, 'IsProcessingPersonalDataToCalculate')]");
        findElementAndClick("//*[contains(@data-bind, 'disable: Misc.NextButtonDisabled')]");
    }

    /**
     *
     * Скроллер страницы
     */
    private static void scrollPage(String xPath){
        ((JavascriptExecutor)drv).executeScript("arguments[0].scrollIntoView();", drv.findElement(By.xpath(xPath)));
    }

    /**
     *
     * @param locator
     * @param fill текст который заполняем в форму
     */
    public static void fillForm(By locator, String fill){
        Wait<WebDriver> wait = new WebDriverWait(drv, 10,1000);
        drv.findElement(locator).click();
        drv.findElement(locator).clear();
        wait.until(ExpectedConditions.visibilityOf(drv.findElement((locator))));
        drv.findElement(locator).sendKeys(fill);
    }

    /**
     *
     * @param xPath параметр принимает xpath
     */
    private static void findElementAndClick(String xPath){
        drv.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
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
    public static boolean validationForm(String expect, String actual){
        StringBuilder builder = new StringBuilder();
        char[] arr = actual.toCharArray();
        for(char symb : arr){
            if (symb != '.' ) builder.append(symb);
        }
        return expect.equalsIgnoreCase(builder.toString());
    }
}