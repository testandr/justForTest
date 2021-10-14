package Lesson6;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BaseView {


    @FindBy(xpath = "//input[@id='prependedInput']")
    public WebElement inputLogin;

    @FindBy(xpath = "//input[@id='prependedInput2']")
    public WebElement inputPassword;

    @FindBy(xpath = "//button[@id='_submit']")
    public WebElement buttonLogin;

    public LoginPage(WebDriver webDriver) {
        super(webDriver);
    }

    public LoginPage fillLogin(String login){
        inputLogin.sendKeys(login);
        return this;
    }

    public LoginPage fillPassword(String password){
        inputPassword.sendKeys(password);
        return this;
    }

    public MainPage submitLogin(){
        buttonLogin.click();
        return new MainPage(webDriver);
    }

    public void login(String login, String password) {
        inputLogin.sendKeys(login);
        inputPassword.sendKeys(password);
        buttonLogin.click();
    }


}
