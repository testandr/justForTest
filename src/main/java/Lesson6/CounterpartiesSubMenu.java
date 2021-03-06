package Lesson6;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class CounterpartiesSubMenu extends BaseView {
    @FindBy(xpath = "//span[.='Контактные лица']")
    public WebElement contactFacesButton;

    public CounterpartiesSubMenu(WebDriver webDriver) {
        super(webDriver);
    }

    public ContactsPage contactFacesButtonClick() {
        contactFacesButton.click();
        waitForLoadersInvisibility();
        return new ContactsPage(webDriver);
    }
}
