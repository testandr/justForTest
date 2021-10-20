package Lesson6;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ExpensesSubMenu extends BaseView {
    @FindBy(xpath = "//span[.='Заявки на расходы']")
    public WebElement createExpenseButton;

    public ExpensesSubMenu(WebDriver webDriver) {
        super(webDriver);
    }

    @Step("Нажать на кнопку рассходы")
    public ExpensesPage expensesButtonClick(){
        createExpenseButton.click();
        return new ExpensesPage(webDriver);
    }
}
