package Lesson5;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CreateNewContact {
    public CreateNewContact() {

    }

    String crm_url = "https://crm.geekbrains.space/";
        String user_login_part = "user/login";
        String contact_part = "contact/";
        String loginPage = crm_url+user_login_part;
        String contactsPage = crm_url+contact_part;
        String lastName = "testLastName";
        String firstName = "testFirstName";
        String organization = "Alya";
        String job = "testJob";


//        Authorization auth = new Authorization();
//        WebDriver driver = SetupBrowser.ChromeDriverSetup();
//        WebDriverWait wait = new WebDriverWait(driver, 10);
//
//        driver.get(loginPage);
//        Authorization.userLogin(driver, auth.username, auth.password);
//
//        // Решил тут просто перейти на нужную страницу, хочу посмотреть уроки с подробным описанием работы actions перед тем как пользоваться
//        driver.get(contactsPage);
//
//        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[contains(@class, 'navigation')]//a[@href='/contact/create']")));
//        driver.findElement(By.xpath("//div[contains(@class, 'navigation')]//a[@href='/contact/create']")).click();
//        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@name='crm_contact[lastName]']")));
//        driver.findElement(By.xpath("//input[@name='crm_contact[lastName]']")).sendKeys(lastName);
//        driver.findElement(By.xpath("//input[@name='crm_contact[firstName]']")).sendKeys(firstName);
//        driver.findElement(By.xpath("//span[@class='select2-chosen']")).click();
//        driver.findElement(By.xpath("//input[contains(@class, 'select2-focused')]")).sendKeys(organization);
//        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//li[@class='select2-results-dept-0 select2-result select2-result-selectable select2-highlighted']")));
//        driver.findElement(By.xpath("//li[@class='select2-results-dept-0 select2-result select2-result-selectable select2-highlighted']")).click();
//        driver.findElement(By.xpath("//input[@name='crm_contact[jobTitle]']")).sendKeys(job);
//        driver.findElement(By.xpath("//button[@data-action='{\"route\":\"crm_contact_update\",\"params\":{\"id\":\"$id\"}}']")).click();
//
//        driver.quit();


}
