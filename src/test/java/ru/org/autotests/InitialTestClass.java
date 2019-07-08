package ru.org.autotests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.concurrent.TimeUnit;

public class InitialTestClass {


    static WebDriver driver;

    public WebDriver initializeDriver() {


        ChromeOptions options = new ChromeOptions();
//        options.addArguments("--incognito");
//        options.setPageLoadStrategy(PageLoadStrategy.NORMAL);
        driver = new ChromeDriver(options);
        return driver;
    }

    public WebDriver setPropertyWindow() {
        driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        return driver;
    }

    public void closeBrowser() {
        driver.close();
    }

}
