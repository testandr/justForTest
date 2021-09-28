import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Authorization {

    public Authorization() {
    }

    public String username = "Applanatest1";
    public String password = "Student2020!";

    public static void userLogin(WebDriver webDriver, String username, String password){
        webDriver.findElement(By.xpath("//input[@id='prependedInput']"))
                .sendKeys(username);
        webDriver.findElement(By.xpath("//input[@id='prependedInput2']"))
                .sendKeys(password);
        webDriver.findElement(By.xpath("//button[@id='_submit']")).click();
    }
}
