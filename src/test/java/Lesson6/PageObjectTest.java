package Lesson6;


import io.qameta.allure.Description;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PageObjectTest {
    WebDriver webDriver;
    WebDriverWait webDriverWait;

    @BeforeAll
    static void registerDriver(){
        System.setProperty(
                "webdriver.chrome.driver", "D:\\browser_drivers/chromedriver.exe"
        );
    }

    @BeforeEach
    void setUpBrowser(){
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--start-maximized");
        webDriver = new ChromeDriver(options);
        webDriverWait = new WebDriverWait(webDriver, 10);
        webDriver.get("https://crm.geekbrains.space/");
    }

    @Test
    void loginTest(){
        new LoginPage(webDriver)
                .fillLogin("Applanatest1")
                .fillPassword("Student2020!")
                .submitLogin()
                .navigationMenu.openNavigationSubMenuItems("Расходы");
    }

    @Test
    void loginTest2(){
        new LoginPage(webDriver)
                .fillLogin("Applanatest1")
                .fillPassword("Student2020!")
                .submitLogin();
        new MainPage(webDriver)
                .navigationMenu.openNavigationSubMenuItems("Расходы");
    }

    @Test
    @Description("Тест: Позитивный сценарий создания заявки на расход")
    void createExpenseRequestPositiveTest() throws InterruptedException {
        new LoginPage(webDriver)
                .fillLogin("Applanatest1")
                .fillPassword("Student2020!")
                .submitLogin();
        new MainPage(webDriver)
                .navigationMenu.openNavigationSubMenuItems("Расходы");
        new ExpensesSubMenu(webDriver)
                .expensesButtonClick();
        new ExpensesPage(webDriver)
                .createExpenseButtonClick();
        new CreateExpensePage(webDriver)
                .fillExpenseAppointment("Description for expense request")
                .selectBusinessUnit("Research & Development")
                .selecteEpenditure("01101 - ОС: вычислительная техника инфраструктуры")
                .fillInSumPlan("10")
                .datePlanCLick()
                .todayButtonCLick()
                .applyExpenseButtonCLick()
                .saveAndClosExpenseButtonCLick();
        new ExpensesPage(webDriver)
                .checkIfExpenseRequestIsCreated("Description for expense request");
    }

    @Test
    void createNewContactPositiveTest(){
        new LoginPage(webDriver)
                .fillLogin("Applanatest1")
                .fillPassword("Student2020!")
                .submitLogin();
        new MainPage(webDriver)
                .navigationMenu.openNavigationSubMenuItems("Контрагенты");
        new CounterpartiesSubMenu(webDriver)
                .contactFacesButtonClick();
        new ContactsPage(webDriver)
                .createContactButtonClick();
        new CreateContactPage(webDriver)
                .fillLastNameField("testLastName1")
                .fillFirstNameField("testFirstName1")
                .openOrganizationSelectList()
                .fillOrganizationInputField("Alya")
                .selectOrganization()
                .fillJobTitleField("testJob")
                .applyContactButtonClick()
                .saveAndCloseContactButtonClick();
        new ContactsPage(webDriver)
                .checkIfNewContactIsCreated("testLastName1" +" " + "testFirstName1");
    }

    @Test
    void createNewProjectPositiveTest(){
        new LoginPage(webDriver)
                .fillLogin("Applanatest1")
                .fillPassword("Student2020!")
                .submitLogin();
        new MainPage(webDriver)
                .navigationMenu.openNavigationSubMenuItems("Проекты");
        new ProjectsSubMenu(webDriver)
                .allProjectsPointClick();
        new ProjectsPage(webDriver)
                .createProjectButtonClick();
        new CreateProjectPage(webDriver)
                .fillProjectNameField("Autotest0014")
                .organizationSelectorClick()
                .fillOrganizationSelectorSearchField("Alya")
                .selectOrganization()
                .contactPersonSelectorClick()
                .fillContactPersonSearchField("Иванов Петр")
                .selectContactPerson()
                .chooseOptionFromPriority("Низкий")
                .chooseOptionFromFinanceSource("Внутреннее")
                .chooseOptionFromBusinessUnit("Research & Development")
                .chooseOptionFromCurator("Applanatest Applanatest Applanatest")
                .chooseOptionFromRp("Applanatest Applanatest Applanatest")
                .chooseOptionFromAdministrator("Applanatest Applanatest Applanatest")
                .chooseOptionFromManager("Applanatest Applanatest Applanatest")
                .checkboxSkipSpeedChecksClick()
                .applyNewProjectButtonClick()
                .saveAndCloseNewProjectButtonClick();
        new ProjectsPage(webDriver)
                .checkIfProjectIsCreated("Autotest0014");

    }

    @AfterEach
    void tearDown(){
        webDriver.quit();
    }

}
