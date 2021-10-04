import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class SetupBrowser {

    public static WebDriver ChromeDriverSetup(){
        System.setProperty(
                "webdriver.chrome.driver", "D:\\browser_drivers/chromedriver.exe"
        );
        WebDriver webDriver = new ChromeDriver();
        return webDriver;
    }
}
