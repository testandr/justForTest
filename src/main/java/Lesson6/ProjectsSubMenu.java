package Lesson6;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProjectsSubMenu extends BaseView{
    public ProjectsSubMenu(WebDriver webDriver) {
        super(webDriver);
    }

    @FindBy(xpath = "//span[.='Все проекты']")
    public WebElement allProjectsPoint;

    public CreateProjectPage allProjectsPointClick(){
        allProjectsPoint.click();
        return new CreateProjectPage(webDriver);
    }

}
