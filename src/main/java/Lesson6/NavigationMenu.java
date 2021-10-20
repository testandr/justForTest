package Lesson6;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

import java.util.List;


public class NavigationMenu extends BaseView {

    ExpensesSubMenu expensesSubMenu;
    CounterpartiesSubMenu counterpartiesSubMenu;
    ProjectsSubMenu projectsSubMenu;

    public NavigationMenu(WebDriver webDriver) {
        super(webDriver);
        expensesSubMenu = new ExpensesSubMenu(webDriver);
        counterpartiesSubMenu = new CounterpartiesSubMenu(webDriver);
        projectsSubMenu = new ProjectsSubMenu(webDriver);
    }

    @FindBy(xpath = "//ul[@class='nav nav-multilevel main-menu']/li")
    public List<WebElement> navigationMenuItems;

    @Step("Открыть пункт навигационного меню")
    public void openNavigationSubMenuItems(String menuName){
        Actions actions = new Actions(webDriver);
        actions.moveToElement(navigationMenuItems.stream().filter(element -> element.getText().equals(menuName))
                .findFirst().get()).build().perform();
    }
}
