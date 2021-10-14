package Lesson6;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

public class CreateContactPage extends BaseView{

    public CreateContactPage(WebDriver webDriver) {
        super(webDriver);
    }

    @FindBy(xpath = "//input[@name='crm_contact[lastName]']")
    public WebElement lastNameField;


    public CreateContactPage fillLastNameField(String lastName){
        waitForLoadersInvisibility();
        webDriverWait.until(ExpectedConditions.elementToBeClickable(lastNameField));
        lastNameField.sendKeys(lastName);
        return this;
    }

    @FindBy(xpath = "//input[@name='crm_contact[firstName]']")
    public WebElement firstNameField;

    public CreateContactPage fillFirstNameField(String firstName){
        waitForLoadersInvisibility();
        firstNameField.sendKeys(firstName);
        return this;
    }

    @FindBy(xpath = "//span[@class='select2-chosen']")
    public WebElement organizationSelect;

    public CreateContactPage openOrganizationSelectList(){
        organizationSelect.click();
        return this;
    }

    @FindBy(xpath = "//input[contains(@class, 'select2-focused')]")
    public WebElement findOrganizationInputField;

    public CreateContactPage fillOrganizationInputField(String organizationName){
        findOrganizationInputField.sendKeys(organizationName);
        return this;
    }

    @FindBy(xpath = "//li[@class='select2-results-dept-0 select2-result select2-result-selectable select2-highlighted']")
    public WebElement organizationSearchResult;

    public CreateContactPage selectOrganization(){
        webDriverWait.until(ExpectedConditions.elementToBeClickable(organizationSearchResult));
        organizationSearchResult.click();
        return this;
    }

    @FindBy(xpath = "//input[@name='crm_contact[jobTitle]']")
    public WebElement jobTitleField;

    public CreateContactPage fillJobTitleField(String jobTitle){
        jobTitleField.sendKeys(jobTitle);
        return this;
    }

    @FindBy(xpath = "//button[@data-action='{\"route\":\"crm_contact_update\",\"params\":{\"id\":\"$id\"}}']")
    public WebElement applyContactButton;

    public CreateContactPage applyContactButtonClick(){
        waitForLoadersInvisibility();
        applyContactButton.click();
        return new CreateContactPage(webDriver);
    }


    @FindBy(xpath = "//button[@data-action='{\"route\":\"crm_contact_index\"}']")
    public WebElement saveAndCloseContactButton;

    public ContactsPage saveAndCloseContactButtonClick(){
        waitForLoadersInvisibility();
        saveAndCloseContactButton.click();
        return new ContactsPage(webDriver);
    }
}
