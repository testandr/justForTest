package Lesson6;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

public class CreateExpensePage extends BaseView{

    public CreateExpensePage(WebDriver webDriver) {
        super(webDriver);
    }

    @FindBy(xpath = "//textarea[@name='crm_expense_request[description]']")
    public WebElement expenseAppointment;

    public CreateExpensePage fillExpenseAppointment(String appointment){
        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='container']")));
        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//form[contains(@id, 'crm_expense_request-uid')]")));
        expenseAppointment.sendKeys(appointment);
        return this;
    }

    @FindBy(xpath = "//select[@name='crm_expense_request[businessUnit]']")
    public WebElement businessUnitSelect;

    public CreateExpensePage selectBusinessUnit(String option){
//        new Select(expenditureSelect).selectByVisibleText(option);
        new Select(businessUnitSelect).selectByIndex(1);
        return this;
    }

    @FindBy(xpath = "//select[@name='crm_expense_request[expenditure]']")
    public WebElement expenditureSelect;

    public CreateExpensePage selecteEpenditure(String option){
//        new Select(businessUnitSelect).selectByVisibleText(option);
        new Select(expenditureSelect).selectByIndex(75);
        return this;
    }

    @FindBy(xpath = "//input[@name='crm_expense_request[sumPlan]']")
    public WebElement sumPlan;

    public CreateExpensePage fillInSumPlan(String amount){
        sumPlan.sendKeys(amount);
        return this;
    }

    @FindBy(xpath = "//input[contains(@id, 'date_selector_crm_expense_request_datePlan-uid')]")
    public WebElement datePlan;

    public CreateExpensePage datePlanCLick(){
        datePlan.click();
        return this;
    }

    @FindBy(xpath = "//button[@data-handler='today']")
    public WebElement todayButton;

    public CreateExpensePage todayButtonCLick(){
        todayButton.click();
        return this;
    }

    @FindBy(xpath = "//button[@data-action='{\"route\":\"crm_expense_request_index\"}']")
    public WebElement saveAndCloseExpenseButton;

    public ExpensesPage saveAndClosExpenseButtonCLick(){
        waitForLoadersInvisibility();
        saveAndCloseExpenseButton.click();
        return new ExpensesPage(webDriver);
    }

    @FindBy(xpath = "//button[@data-action='{\"route\":\"crm_expense_request_update\",\"params\":{\"id\":\"$id\"}}']")
    public WebElement applyExpenseButton;

    public CreateExpensePage applyExpenseButtonCLick(){
        waitForLoadersInvisibility();
        applyExpenseButton.click();
        return new CreateExpensePage(webDriver);
    }
}
