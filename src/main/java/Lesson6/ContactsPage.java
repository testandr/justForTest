package Lesson6;

import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

public class ContactsPage extends BaseView{

    public ContactsPage(WebDriver webDriver) {
        super(webDriver);
    }

    @FindBy(xpath = "//a[.='Создать контактное лицо']")
    public WebElement createNewContactButton;

    public CreateContactPage createContactButtonClick(){
        waitForLoadersInvisibility();
        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(@id, 'grid-crm-contact-grid')]")));
        createNewContactButton.click();
        return new CreateContactPage(webDriver);
    }

    @FindBy(xpath = "//table[@class='grid table-hover table table-bordered table-condensed']//tr/td[contains(@class, 'grid-body-cell-fio')]")
    public WebElement tableNameColumn;

    @FindBy(xpath = "//div[contains(@class, 'btn filter-criteria-selector')]")
    public WebElement filterSelector;

    @FindBy(xpath = "//div[@class='value-field-frame']//input[@type='text']")
    public WebElement nameFilterSearchField;

    public ContactsPage fillNameFilterSearchField(String lastName){
        webDriverWait.until(ExpectedConditions.elementToBeClickable(nameFilterSearchField));
        nameFilterSearchField.sendKeys(lastName);
        return this;
    }

    @FindBy(xpath = "//div[@class='value-field-frame']//button[@class='btn btn-primary filter-update']")
    public WebElement nameFilterUpdateButton;

    public ContactsPage nameFilterUpdateButtonClick(){
        nameFilterUpdateButton.click();
        return this;
    }

    public ContactsPage checkIfNewContactIsCreated(String lastName){
        waitForLoadersInvisibility();
        webDriver.findElement(By.xpath("//div[contains(text(), 'ФИО')]")).click();
        fillNameFilterSearchField(lastName);
        nameFilterUpdateButtonClick();
        waitForLoadersInvisibility();
        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(@id, 'grid-crm-contact-grid')]")));
        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='grid-container']")));
        Assertions.assertEquals(tableNameColumn.getText(), lastName);
        return this;
    }
}
