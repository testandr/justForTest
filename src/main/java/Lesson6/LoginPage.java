package Lesson6;

import io.qameta.allure.Step;
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

    @Step("Заполнить поле логина")
    public LoginPage fillLogin(String login){
        inputLogin.sendKeys(login);
        return this;
    }

    @Step("Заполнить поле пароль")
    public LoginPage fillPassword(String password){
        inputPassword.sendKeys(password);
        return this;
    }

    @Step("Нажать на кнопку 'Войти'")
    public MainPage submitLogin(){
        buttonLogin.click();
        return new MainPage(webDriver);
    }

    @Step("Авторизироваться на сайте")
    public void login(String login, String password) {
        inputLogin.sendKeys(login);
        inputPassword.sendKeys(password);
        buttonLogin.click();
    }


}
