import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class FirstTest {

    // пример переенной для элемента по XPath
    // By nameOfVariable = By.xpath("");
    By cardNumberFrom = By.xpath("//input[@data-qa-node='numberdebitSource']");

    @Test
    void checkP2pMinSum(){

        // https://www.browserstack.com/guide/setproperty-in-selenium
//        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

        //TODO:
        //driver.manage().addCookie("");

        driver.get("https://next.privat24.ua/money-transfer/card");
        driver.findElement(cardNumberFrom).sendKeys("4004159115449003");

        // ввести номер exp date отправителя
        // ввести номер cvv отправителя
        // ввести номер карты получателя
        // ввести сумму перевода
        // подтвердить платеж
        // создать проверку, что платеж создан корректно
    }

}
