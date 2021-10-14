package Lesson6;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class BaseView {
    WebDriver webDriver;
    WebDriverWait webDriverWait;

    @FindBy(xpath = "//div[@class='loader-mask shown']")
    public WebElement tableLoader;

    @FindBy(xpath = "//body[@class='desktop-version lang-ru loading']")
    public WebElement pageLoader;

    public BaseView(WebDriver webDriver) {
        this.webDriver = webDriver;
        this.webDriverWait = new WebDriverWait(webDriver, 10);
        PageFactory.initElements(webDriver, this);
    }

    public boolean checkIfElementWithTextIsPresent(List<WebElement> descriptions, String appointmentText){
        boolean status = false;
        for (int i = 0; i < descriptions.size(); i++){
            System.out.println(descriptions.get(i).getText());
            if (descriptions.get(i).getText().contains(appointmentText)){
                status = true;
            }
        }
        return status;
    }

    public void waitForLoadersInvisibility(){
        webDriverWait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath(String.valueOf(pageLoader))));
        webDriverWait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath(String.valueOf(tableLoader))));
        webDriverWait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@class='loader-overlay']")));
    }
}
