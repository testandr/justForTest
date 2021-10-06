package Lesson5;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import static Lesson4.Functions.areaTriangle;

public class Main {
    public static void main(String[] args) {
        System.out.println(areaTriangle(3, 4, 5));
    }
}
