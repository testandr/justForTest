package Lesson5;

import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

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

        webDriverWait.until(driver -> driver.findElements(By.xpath("//thead[@class='grid-header']//th[contains(@class, 'sortable')]")))
                .get(0).getText().equals("ВЛАДЕЛЕЦ");

        List<WebElement> headers = driver.findElements(By.xpath("//thead[@class='grid-header']//th[contains(@class, 'sortable')]"));
        Assertions.assertEquals("ВЛАДЕЛЕЦ",headers.get(0).getText());

        Thread.sleep(5000);
    }

    @Test
    void checkRowColorChangeAfterCheckBoxClickTest(){
        driver.get("https://crm.geekbrains.space/dashboard");
        driver.findElement(By.xpath("//thead[@class='grid-header']//input")).click();
        String elementColor = driver.findElement(By.xpath("//tbody[@class='grid-body']/tr[1]"))
                .getCssValue("background-color");
        Assertions.assertEquals(elementColor, "rgba(254, 250, 237, 1)");
    }

    @Test
    void iframeTest() {
        driver.get("https://crm.geekbrains.space/project/create/");

        driver.switchTo()
                .frame(driver.findElement(By.xpath("//iframe[contains(@id, 'crm_project_planning')]")));
        driver.findElement(By.xpath("//body")).sendKeys("Test");
        driver.switchTo().defaultContent();
        driver.findElement(By.xpath("//input[@name='crm_project[name]']")).sendKeys("Test");

    }

    @AfterEach
    void tearDown(){
        driver.close();
        driver.quit();
    }
}
