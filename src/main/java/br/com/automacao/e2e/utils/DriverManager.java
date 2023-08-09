package br.com.automacao.e2e.utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import static io.github.bonigarcia.wdm.WebDriverManager.chromedriver;

public abstract class DriverManager {
    private static WebDriver driver;

    public static WebDriver getDriver(){
        if(driver == null){
            chromedriver().setup();
            ChromeOptions options = new ChromeOptions();
            options.addArguments("--start-maximized");
            options.addArguments("--incognito");
            options.addArguments("--remote-allow-origins=*");
            driver = new ChromeDriver(options);
        }
        return driver;
    }
    public static void quitDriver(){
        if (driver != null){
            driver.quit();
            driver = null;
        }
    }
}
