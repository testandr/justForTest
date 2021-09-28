import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class CreateExpenseRequest {

    public static void main(String[] args) throws InterruptedException {

        String crm_url = "https://crm.geekbrains.space/";
        String user_login_part = "user/login";
        String expense_part = "expense-request/";
        String loginPage = crm_url+user_login_part;
        String expenseRequestPage = crm_url+expense_part;
        String appointmentText = "Description for expense request";
        String requestedAmount = "10";

        Authorization auth = new Authorization();
        WebDriver driver = SetupBrowser.ChromeDriverSetup();
        WebDriverWait wait = new WebDriverWait(driver, 10);

        driver.get(loginPage);
        Authorization.userLogin(driver, auth.username, auth.password);

        // Решил тут просто перейти на нужную страницу, хочу посмотреть уроки с подробным описанием работы actions перед тем как пользоваться
        driver.get(expenseRequestPage);

        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[contains(@class, 'navigation')]//a[@href='/expense-request/create']")));
        driver.findElement(By.xpath("//div[contains(@class, 'navigation')]//a[@href='/expense-request/create']")).click();
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//textarea[@name='crm_expense_request[description]']")));
        driver.findElement(By.xpath("//textarea[@name='crm_expense_request[description]']")).sendKeys(appointmentText);
        driver.findElement(By.xpath("//select[@name='crm_expense_request[businessUnit]']")).click();
        driver.findElement(By.xpath("//option[@value='1']")).click();
        driver.findElement(By.xpath("//select[@name='crm_expense_request[expenditure]']")).click();
        driver.findElement(By.xpath("//option[@value='75']")).click();
        driver.findElement(By.xpath("//select[@name='crm_expense_request[expenditure]']")).click();
        driver.findElement(By.xpath("//input[@name='crm_expense_request[sumPlan]']")).sendKeys(requestedAmount);
        driver.findElement(By.xpath("//input[contains(@id, 'date_selector_crm_expense_request_datePlan-uid')]")).click();
        driver.findElement(By.xpath("//button[@data-handler='today']")).click();
        driver.findElement(By.xpath("//div[@class='pull-right title-buttons-container']//button[@data-action='{\"route\":\"crm_expense_request_update\",\"params\":{\"id\":\"$id\"}}']")).click();

        driver.quit();
    }
}
