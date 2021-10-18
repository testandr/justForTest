package Lesson6;

import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

public class ProjectsPage extends BaseView{
    public ProjectsPage(WebDriver webDriver) {
        super(webDriver);
    }

    @FindBy(xpath = "//a[.='Создать проект']")
    public WebElement createProjectButton;

    public CreateProjectPage createProjectButtonClick(){
        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(@id, 'grid-crm-project-grid')]")));
        createProjectButton.click();
        return new CreateProjectPage(webDriver);
    }

    @FindBy(xpath = "//table//tbody//td[contains(@class, 'grid-body-cell-name')]")
    public WebElement tableNameColumn;

    @FindBy(xpath = "//div[@class='value-field-frame']//button[@class='btn btn-primary filter-update']")
    public WebElement nameFilterUpdateButton;

    public ProjectsPage nameFilterUpdateButtonClick(){
        nameFilterUpdateButton.click();
        return this;
    }


    public ProjectsPage checkIfProjectIsCreated(String projectName){
        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(@id, 'grid-crm-project-grid')]")));
        webDriverWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//tbody[@class='grid-body']")));
        webDriverWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//tbody[@class='grid-body']/tr/td")));
        webDriver.findElement(By.xpath("//div[contains(text(), 'Наименование')]")).click();
        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='value-field-frame']//input[@type='text']")));
        webDriver.findElement(By.xpath("//div[@class='value-field-frame']//input[@type='text']")).sendKeys(projectName);
        nameFilterUpdateButtonClick();
        waitForLoadersInvisibility();
        Assertions.assertEquals(tableNameColumn.getText(), projectName);
        return this;
    }
}
