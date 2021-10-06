package Lesson5;

import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;


public class homework {
    WebDriver driver;
    WebDriverWait webDriverWait;
    Info info = new Info();

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

        driver.get(info.loginPage);
        driver.findElement(By.xpath("//input[@id='prependedInput']"))
                .sendKeys("Applanatest1");
        driver.findElement(By.xpath("//input[@id='prependedInput2']"))
                .sendKeys("Student2020!");
        driver.findElement(By.xpath("//button[@id='_submit']")).click();
    }

    @Test
    @DisplayName("Позитивный сценарий создания нового проекта")

    /*
    * Перед запуском нужно поменять в переменной createProject.name цифру на следующую
    */
    void positiveCreateNewProjectTest(){
        driver.get(info.createProjectPage);

        webDriverWait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@name='crm_project[name]']")));
        driver.findElement(By.xpath("//input[@name='crm_project[name]']")).sendKeys(info.name);
        driver.findElement(By.xpath("//span[@class='select2-chosen']")).click();
        driver.findElement(By.xpath("//input[contains(@class, 'select2-focused')]")).sendKeys(info.organization);
        webDriverWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//li[@class='select2-results-dept-0 select2-result select2-result-selectable select2-highlighted']")));
        driver.findElement(By.xpath("//li[@class='select2-results-dept-0 select2-result select2-result-selectable select2-highlighted']")).click();
        webDriverWait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[contains(@class, 'select2-container select2 select2-container-disabled')]")));

        webDriverWait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class='select2-container select2']//a[@class='select2-choice']")));
        driver.findElement(By.xpath("//div[@class='select2-container select2']//a[@class='select2-choice']")).click();
        driver.findElement(By.xpath("//input[contains(@class, 'select2-focused')]")).sendKeys(info.primaryContactPerson);
        webDriverWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//li[@class='select2-results-dept-0 select2-result select2-result-selectable select2-highlighted']")));
        driver.findElement(By.xpath("//li[@class='select2-results-dept-0 select2-result select2-result-selectable select2-highlighted']")).click();

        driver.findElement(By.xpath("//select[@name='crm_project[priority]']")).click();
        driver.findElement(By.xpath("//select[@name='crm_project[priority]']/option[@value='1']")).click();
        driver.findElement(By.xpath("//select[@name='crm_project[financeSource]']")).click();
        driver.findElement(By.xpath("//select[@name='crm_project[financeSource]']/option[@value='2']")).click();
        driver.findElement(By.xpath("//select[@name='crm_project[businessUnit]']")).click();
        driver.findElement(By.xpath("//select[@name='crm_project[businessUnit]']/option[@value='1']")).click();
        driver.findElement(By.xpath("//select[@name='crm_project[curator]']")).click();
        driver.findElement(By.xpath("//select[@name='crm_project[curator]']/option[@value='115']")).click();
        driver.findElement(By.xpath("//select[@name='crm_project[rp]']")).click();
        driver.findElement(By.xpath("//select[@name='crm_project[rp]']/option[@value='115']")).click();
        driver.findElement(By.xpath("//select[@name='crm_project[administrator]']")).click();
        driver.findElement(By.xpath("//select[@name='crm_project[administrator]']/option[@value='115']")).click();
        driver.findElement(By.xpath("//select[@name='crm_project[manager]']")).click();
        driver.findElement(By.xpath("//select[@name='crm_project[manager]']/option[@value='115']")).click();
        driver.findElement(By.xpath("//input[@name='crm_project[skipSpeedChecks]']")).click();
        driver.findElement(By.xpath("//button[@data-action='{\"route\":\"crm_project_update\",\"params\":{\"id\":\"$id\"}}']")).click();

        driver.get(info.projectPage);
        webDriverWait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//table//tbody//td[contains(@class, 'grid-body-cell-name')]")));
        List<WebElement> buttons = driver.findElements(By.xpath("//div[contains(@class, 'btn filter-criteria-selector')]"));
        for (int i = 0; i < buttons.size(); i++){
            if (buttons.get(i).getText().contains("Наименование")){
                buttons.get(i).click();
            }
        }
        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='value-field-frame']//input[@type='text']")));
        driver.findElement(By.xpath("//div[@class='value-field-frame']//input[@type='text']")).sendKeys(info.name);
        driver.findElement(By.xpath("//div[@class='value-field-frame']//button[@class='btn btn-primary filter-update']")).click();
        webDriverWait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@class='loader-mask shown']")));
        Assertions.assertEquals(driver.findElement(By.xpath("//table//tbody//td[contains(@class, 'grid-body-cell-name')]")).getText(), info.name);

    }

    @Test
    @DisplayName("Позитивный сценарий создания нового контакта")

        /*
         * Перед запуском нужно поменять в переменных info.lastName и info.firstName цифру на следующую
         */
    void positiveCreateNewContactTest(){
        driver.get(info.createContactPage);

        webDriverWait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@name='crm_contact[lastName]']")));
        driver.findElement(By.xpath("//input[@name='crm_contact[lastName]']")).sendKeys(info.lastName);
        driver.findElement(By.xpath("//input[@name='crm_contact[firstName]']")).sendKeys(info.firstName);
        driver.findElement(By.xpath("//span[@class='select2-chosen']")).click();
        driver.findElement(By.xpath("//input[contains(@class, 'select2-focused')]")).sendKeys(info.organization);
        webDriverWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//li[@class='select2-results-dept-0 select2-result select2-result-selectable select2-highlighted']")));
        driver.findElement(By.xpath("//li[@class='select2-results-dept-0 select2-result select2-result-selectable select2-highlighted']")).click();
        driver.findElement(By.xpath("//input[@name='crm_contact[jobTitle]']")).sendKeys(info.job);
        driver.findElement(By.xpath("//button[@data-action='{\"route\":\"crm_contact_update\",\"params\":{\"id\":\"$id\"}}']")).click();

        driver.get(info.contactsPage);

        webDriverWait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//table//tbody//td[contains(@class, 'grid-body-cell-name')]")));
        List<WebElement> buttons = driver.findElements(By.xpath("//div[contains(@class, 'btn filter-criteria-selector')]"));
        for (int i = 0; i < buttons.size(); i++){
            if (buttons.get(i).getText().contains("ФИО")){
                buttons.get(i).click();
            }
        }
        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='value-field-frame']//input[@type='text']")));
        driver.findElement(By.xpath("//div[@class='value-field-frame']//input[@type='text']")).sendKeys(info.lastName);
        driver.findElement(By.xpath("//div[@class='value-field-frame']//button[@class='btn btn-primary filter-update']")).click();
        webDriverWait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@class='loader-mask shown']")));
        Assertions.assertEquals(driver.findElement(By.xpath("//table//tbody//td[contains(@class, 'grid-body-cell-name')]")).getText(), info.lastName);

    }


    @Test
    @DisplayName("Позитивный сценарий создания новой заявки на расход")

        /*
         * Перед запуском нужно поменять в переменной info.appointmentText цифру на следующую
         */
    void positiveCreateNewExpenseRequestTest(){
        driver.get(info.createExpenseRequestPage);

        webDriverWait.until(ExpectedConditions.elementToBeClickable(By.xpath("//textarea[@name='crm_expense_request[description]']")));
        driver.findElement(By.xpath("//textarea[@name='crm_expense_request[description]']")).sendKeys(info.appointmentText);
        driver.findElement(By.xpath("//select[@name='crm_expense_request[businessUnit]']")).click();
        driver.findElement(By.xpath("//option[@value='1']")).click();
        driver.findElement(By.xpath("//select[@name='crm_expense_request[expenditure]']")).click();
        driver.findElement(By.xpath("//option[@value='75']")).click();
        driver.findElement(By.xpath("//select[@name='crm_expense_request[expenditure]']")).click();
        driver.findElement(By.xpath("//input[@name='crm_expense_request[sumPlan]']")).sendKeys(info.requestedAmount);
        driver.findElement(By.xpath("//input[contains(@id, 'date_selector_crm_expense_request_datePlan-uid')]")).click();
        driver.findElement(By.xpath("//button[@data-handler='today']")).click();
        driver.findElement(By.xpath("//div[@class='pull-right title-buttons-container']//button[@data-action='{\"route\":\"crm_expense_request_update\",\"params\":{\"id\":\"$id\"}}']")).click();
        webDriverWait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@class='loader-mask shown']")));

        driver.get(info.expenseFilteredByDatePage);
        webDriverWait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@class='loader-mask shown']")));

        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//table[contains(@class, 'grid')]//tbody//td[contains(@class, 'grid-body-cell-description')]")));
        List<WebElement> descriptions = driver.findElements(By.xpath("//table[contains(@class, 'grid')]//tbody//td[contains(@class, 'grid-body-cell-description')]"));
        Assertions.assertTrue(info.checkIfElementWithTextIsPresent(descriptions, info.appointmentText));

    }

    @AfterEach
    void tearDown(){
        driver.close();
        driver.quit();
    }
}
