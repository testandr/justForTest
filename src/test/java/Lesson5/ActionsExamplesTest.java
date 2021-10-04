package Lesson5;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ActionsExamplesTest {
    WebDriver driver;
    WebDriverWait webDriverWait;

    @BeforeAll
    static void registerDriver(){
        System.setProperty(
                "webdriver.chrome.driver", "D:\\browser_drivers/chromedriver.exe"
        );
        WebDriver webDriver = new ChromeDriver();
    }

    @BeforeEach
    void setUpBrowser(){
        driver = new ChromeDriver();
        webDriverWait = new WebDriverWait(driver, 5);
        driver.get("https://crm.geekbrains.space/");
        driver.findElement(By.xpath("//input[@id='prependedInput']"))
                .sendKeys("Applanatest1");
        driver.findElement(By.xpath("//input[@id='prependedInput2']"))
                .sendKeys("Student2020!");
        driver.findElement(By.xpath("//button[@id='_submit']")).click();
    }

    @Test
    void dragAndDropTest() throws InterruptedException {
        Actions actions = new Actions(driver);
        driver.get("https://crm.geekbrains.space/dashboard");
        driver.findElement(By.xpath("//a[@title='Настройки представления']")).click();
        actions.clickAndHold(driver.findElement(By.xpath("//label[.='Наименование']//ancestor::tr//span[@title='Move column']")))
                .dragAndDrop(driver.findElement(By.xpath("//label[.='Наименование']//ancestor::tr")),
                        driver.findElement(By.xpath("//label[.='Владелец']//ancestor::tr")))
                .build()
                .perform();
        Thread.sleep(5000);

    }


    @AfterEach
    void tearDown(){
        driver.close();
        driver.quit();
    }
}
