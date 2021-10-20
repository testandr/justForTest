package Lesson6;


import io.qameta.allure.Step;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

public class ExpensesPage extends BaseView{

    public ExpensesPage(WebDriver webDriver) {
        super(webDriver);
    }

    @FindBy(xpath = "//div[contains(@class, 'navigation')]//a[@title='Создать заявку на расход']")
    public WebElement createExpenseButton;

    @FindBy(xpath = "//tbody//tr[contains(@class, 'grid-row row-click-action')]")
    public WebElement tRow;

    @FindBy(xpath = "//tbody//td[contains(@class, 'grid-body-cell-description')]")
    public WebElement tableExpenseDescriptionRow;

    @Step("Нажать на кнопку \"Создать заявку на расход\"")
    public CreateExpensePage createExpenseButtonClick(){
//        webDriverWait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath(String.valueOf(pageLoader))));
//        webDriverWait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath(String.valueOf(tableLoader))));
        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(@id, 'grid-crm-expense-request-grid')]")));
        createExpenseButton.click();
        return new CreateExpensePage(webDriver);
    }

    public ExpensesPage checkIfExpenseRequestIsCreated(String appointmentText){
        waitForLoadersInvisibility();
        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(@id, 'grid-crm-expense-request-grid')]")));
        webDriverWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//tbody[@class='grid-body']")));
        webDriverWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//tbody[@class='grid-body']/tr/td")));
        webDriver.findElement(By.xpath("//div[contains(text(), 'Создан в')]")).click();
        List<WebElement> dateInputs = webDriver.findElements(By.xpath("//div[@class='dropdown datefilter']/input[@class='datepicker-input date-visual-element']"));
        for(int i = 0; i < dateInputs.size(); i++){
            dateInputs.get(i).click();
            webDriverWait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class='dropdown datefilter open']//button[@data-handler='today']")));
            webDriver.findElement(By.xpath("//div[@class='dropdown datefilter open']//button[@data-handler='today']")).click();
        }
        webDriver.findElement(By.xpath("//button[@class='btn btn-primary filter-update']")).click();
        waitForLoadersInvisibility();
        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(@id, 'grid-crm-expense-request-grid')]")));

        List<WebElement> descriptions = webDriver.findElements(By.xpath("//table[@class='grid table-hover table table-bordered table-condensed']//tr/td[contains(@class, 'description')]"));
        Assertions.assertTrue(checkIfElementWithTextIsPresent(descriptions, appointmentText));
        return this;
    }
}
