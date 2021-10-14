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

    @FindBy(xpath = "//div[contains(@class, 'btn filter-criteria-selector')]")
    public WebElement filterSelector;

    @FindBy(xpath = "//div[@class='value-field-frame']//input[@type='text']")
    public WebElement nameFilterSearchField;

    public ProjectsPage fillNameFilterSearchField(String lastName){
        nameFilterSearchField.sendKeys(lastName);
        return this;
    }

    @FindBy(xpath = "//div[@class='value-field-frame']//button[@class='btn btn-primary filter-update']")
    public WebElement nameFilterUpdateButton;

    public ProjectsPage nameFilterUpdateButtonClick(){
        nameFilterUpdateButton.click();
        return this;
    }


    public ProjectsPage checkIfProjectIsCreated(String projectName){
        webDriverWait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath(String.valueOf(tableNameColumn))));
        List<WebElement> buttons = webDriver.findElements(By.xpath(String.valueOf(filterSelector)));
        for (int i = 0; i < buttons.size(); i++){
        if (buttons.get(i).getText().contains("Наименование")){
            buttons.get(i).click();
            }
        }
        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(String.valueOf(nameFilterSearchField))));
        fillNameFilterSearchField(projectName);
        nameFilterUpdateButtonClick();
        webDriverWait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath(String.valueOf(tableLoader))));
        Assertions.assertEquals(tableNameColumn.getText(), projectName);
        return this;
    }
}
