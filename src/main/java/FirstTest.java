import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class FirstTest {

    // пример переенной для элемента по XPath
    // By nameOfVariable = By.xpath("");
    String URL_MOBI_PAY = "https://next.privat24.ua/mobile";
    By phoneNumber = By.xpath("//input[@data-qa-node='phone-number']");
    By amount = By.xpath("//input[@data-qa-node='amount']");
    By cardNumber = By.xpath("//input[@data-qa-node='numberdebitSource']");
    By expDate = By.xpath("//input[@data-qa-node='expiredebitSource']");
    By cvv = By.xpath("//input[@data-qa-node='cvvdebitSource']");
    By firstName = By.xpath("//input[@data-qa-node='firstNamedebitSource']");
    By lastName = By.xpath("//input[@data-qa-node='lastNamedebitSource']");
    By submitButton = By.xpath("//button[@data-qa-node='submit']");
    By details = By.xpath("//div[@data-qa-node='details']");

    @Test
    void checkP2pMinSum() {

        // https://www.browserstack.com/guide/setproperty-in-selenium
//        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));

        driver.get(URL_MOBI_PAY);
        driver.findElement(phoneNumber).sendKeys("686979712");
        driver.findElement(amount).sendKeys(Keys.chord(Keys.chord(Keys.COMMAND, "a"), Keys.DELETE));
        driver.findElement(amount).sendKeys("200");
        driver.findElement(cardNumber).sendKeys("4004159115449003");
        driver.findElement(expDate).sendKeys("1025");
        driver.findElement(cvv).sendKeys("123");
        driver.findElement(submitButton).submit();

        Assertions.assertEquals("Поповнення телефону. На номер +380686979712", driver.findElement(details).getText());

        driver.close();

    }

}
