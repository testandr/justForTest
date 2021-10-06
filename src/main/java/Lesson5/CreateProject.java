package Lesson5;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;




public class CreateProject {

    String crm_url = "https://crm.geekbrains.space/";
    String user_login_part = "user/login";
    String project_part = "project/";
    String create_part = "create/";
    String loginPage = crm_url + user_login_part;
    String projectPage = crm_url + project_part;
    String createProjectPage = crm_url + project_part + create_part;
    String name = "Autotest5";
    String organization = "Alya";
    String primaryContactPerson = "Иванов Петр";

    public CreateProject() {

    }





//        Lesson5.Authorization auth = new Lesson5.Authorization();
//        WebDriver driver = Lesson5.SetupBrowser.ChromeDriverSetup();
//        WebDriverWait wait = new WebDriverWait(driver, 10);
//
//        driver.get(loginPage);
//        Lesson5.Authorization.userLogin(driver, auth.username, auth.password);
//
//        // Решил тут просто перейти на нужную страницу, хочу посмотреть уроки с подробным описанием работы actions перед тем как пользоваться
//        driver.get(projectPage);
//
//        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[contains(@class, 'navigation')]//a[@href='/project/create/']")));
//        driver.findElement(By.xpath("//div[contains(@class, 'navigation')]//a[@href='/project/create/']")).click();
//        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@name='crm_project[name]']")));
//        driver.findElement(By.xpath("//input[@name='crm_project[name]']")).sendKeys(name);
//        driver.findElement(By.xpath("//span[@class='select2-chosen']")).click();
//        driver.findElement(By.xpath("//input[contains(@class, 'select2-focused')]")).sendKeys(organization);
//        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//li[@class='select2-results-dept-0 select2-result select2-result-selectable select2-highlighted']")));
//        driver.findElement(By.xpath("//li[@class='select2-results-dept-0 select2-result select2-result-selectable select2-highlighted']")).click();
//        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[contains(@class, 'select2-container select2 select2-container-disabled')]")));
//
//        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class='select2-container select2']//a[@class='select2-choice']")));
//        driver.findElement(By.xpath("//div[@class='select2-container select2']//a[@class='select2-choice']")).click();
//        driver.findElement(By.xpath("//input[contains(@class, 'select2-focused')]")).sendKeys(primaryContactPerson);
//        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//li[@class='select2-results-dept-0 select2-result select2-result-selectable select2-highlighted']")));
//        driver.findElement(By.xpath("//li[@class='select2-results-dept-0 select2-result select2-result-selectable select2-highlighted']")).click();
//
//        driver.findElement(By.xpath("//select[@name='crm_project[priority]']")).click();
//        driver.findElement(By.xpath("//select[@name='crm_project[priority]']/option[@value='1']")).click();
//        driver.findElement(By.xpath("//select[@name='crm_project[financeSource]']")).click();
//        driver.findElement(By.xpath("//select[@name='crm_project[financeSource]']/option[@value='2']")).click();
//        driver.findElement(By.xpath("//select[@name='crm_project[businessUnit]']")).click();
//        driver.findElement(By.xpath("//select[@name='crm_project[businessUnit]']/option[@value='1']")).click();
//        driver.findElement(By.xpath("//select[@name='crm_project[curator]']")).click();
//        driver.findElement(By.xpath("//select[@name='crm_project[curator]']/option[@value='115']")).click();
//        driver.findElement(By.xpath("//select[@name='crm_project[rp]']")).click();
//        driver.findElement(By.xpath("//select[@name='crm_project[rp]']/option[@value='115']")).click();
//        driver.findElement(By.xpath("//select[@name='crm_project[administrator]']")).click();
//        driver.findElement(By.xpath("//select[@name='crm_project[administrator]']/option[@value='115']")).click();
//        driver.findElement(By.xpath("//select[@name='crm_project[manager]']")).click();
//        driver.findElement(By.xpath("//select[@name='crm_project[manager]']/option[@value='115']")).click();
//        driver.findElement(By.xpath("//input[@name='crm_project[skipSpeedChecks]']")).click();
//        driver.findElement(By.xpath("//button[@data-action='{\"route\":\"crm_project_update\",\"params\":{\"id\":\"$id\"}}']")).click();
//
//        driver.quit();

}
