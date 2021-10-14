package Lesson6;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

public class CreateProjectPage extends BaseView{

    public CreateProjectPage(WebDriver webDriver) {
        super(webDriver);
    }

    @FindBy(xpath = "//input[@name='crm_project[name]']")
    public WebElement projectNameField;

    public CreateProjectPage fillProjectNameField(String projectName){
        waitForLoadersInvisibility();
        webDriverWait.until(ExpectedConditions.elementToBeClickable(projectNameField));
        projectNameField.sendKeys(projectName);
        return this;
    }

    @FindBy(xpath = "//div[@class='select2-container select2 input-widget']//span[@class='select2-chosen']")
    public WebElement organizationSelector;

    public CreateProjectPage organizationSelectorClick(){
        organizationSelector.click();
        return this;
    }

    @FindBy(xpath = "//input[contains(@class, 'select2-focused')]")
    public WebElement organizationSelectorSearchField;

    public CreateProjectPage fillOrganizationSelectorSearchField(String organization){
        webDriverWait.until(ExpectedConditions.elementToBeClickable(organizationSelectorSearchField));
        organizationSelectorSearchField.sendKeys(organization);
        return this;
    }

    @FindBy(xpath = "//li[@class='select2-results-dept-0 select2-result select2-result-selectable select2-highlighted']")
    public WebElement organizationSelectorSearchResult;

    public CreateProjectPage selectOrganization(){
        webDriverWait.until(ExpectedConditions.elementToBeClickable(organizationSelectorSearchResult));
        organizationSelectorSearchResult.click();
        return this;
    }

    @FindBy(xpath = "//div[contains(@class, 'select2-container select2 select2-container-disabled')]")
    public WebElement lockedContactPersonSelector;

    @FindBy(xpath = "//div[@class='select2-container select2']//a[@class='select2-choice']")
    public WebElement contactPersonSelector;

    public CreateProjectPage contactPersonSelectorClick(){
        webDriverWait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath(String.valueOf(lockedContactPersonSelector))));
        webDriverWait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[contains(@id, 's2id_crm_project_contactMain-uid')]")));
//        webDriverWait.until(ExpectedConditions.elementToBeClickable(By.xpath(String.valueOf(contactPersonSelector))));
//        contactPersonSelector.click();
        webDriver.findElement(By.xpath("//div[contains(@id, 's2id_crm_project_contactMain-uid')]")).click();
        return this;
    }

    @FindBy(xpath="//input[contains(@class, 'select2-focused')]")
    public WebElement contactPersonSearchField;

    public CreateProjectPage fillContactPersonSearchField(String contactPerson){
        webDriverWait.until(ExpectedConditions.elementToBeClickable(contactPersonSearchField));
        contactPersonSearchField.sendKeys(contactPerson);
        return this;
    }

    @FindBy(xpath = "//li[@class='select2-results-dept-0 select2-result select2-result-selectable select2-highlighted']")
    public WebElement contactPersonSearchResult;

    public CreateProjectPage selectContactPerson(){
        webDriverWait.until(ExpectedConditions.elementToBeClickable(contactPersonSearchResult));
        contactPersonSearchResult.click();
        return this;
    }

    @FindBy(xpath = "//select[@name='crm_project[priority]']")
    public WebElement prioritySelect;

    public CreateProjectPage chooseOptionFromPriority(String option){
        new Select(prioritySelect).selectByVisibleText(option);
        return this;
    }

    @FindBy(xpath = "//select[@name='crm_project[financeSource]']")
    public WebElement financeSourceSelect;

    public CreateProjectPage chooseOptionFromFinanceSource(String option){
        new Select(financeSourceSelect).selectByVisibleText(option);
        return this;
    }

    @FindBy(xpath = "//select[@name='crm_project[businessUnit]']")
    public WebElement businessUnitSelect;

    public CreateProjectPage chooseOptionFromBusinessUnit(String option){
        new Select(businessUnitSelect).selectByVisibleText(option);
        return this;
    }

    @FindBy(xpath = "//select[@name='crm_project[curator]']")
    public WebElement curatorSelect;

    public CreateProjectPage chooseOptionFromCurator(String option){
        new Select(curatorSelect).selectByVisibleText(option);
        return this;
    }

    @FindBy(xpath = "//select[@name='crm_project[rp]']")
    public WebElement rpSelect;

    public CreateProjectPage chooseOptionFromRp(String option){
        new Select(rpSelect).selectByVisibleText(option);
        return this;
    }

    @FindBy(xpath = "//select[@name='crm_project[administrator]']")
    public WebElement administratorSelect;

    public CreateProjectPage chooseOptionFromAdministrator(String option){
        new Select(administratorSelect).selectByVisibleText(option);
        return this;
    }

    @FindBy(xpath = "//select[@name='crm_project[manager]']")
    public WebElement managerSelect;

    public CreateProjectPage chooseOptionFromManager(String option){
        new Select(managerSelect).selectByVisibleText(option);
        return this;
    }

    @FindBy(xpath = "//input[@name='crm_project[skipSpeedChecks]']")
    public WebElement checkboxSkipSpeedChecks;

    public CreateProjectPage checkboxSkipSpeedChecksClick(){
        checkboxSkipSpeedChecks.click();
        return this;
    }

    @FindBy(xpath = "//button[@data-action='{\"route\":\"crm_project_update\",\"params\":{\"id\":\"$id\"}}']")
    public WebElement createNewProjectButton;

    public ProjectsPage createNewProjectButtonClick(){
        createNewProjectButton.click();
        return new ProjectsPage(webDriver);
    }

}
