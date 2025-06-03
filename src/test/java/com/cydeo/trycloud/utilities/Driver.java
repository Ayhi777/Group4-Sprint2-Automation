package com.cydeo.trycloud.utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.time.Duration;

public class Driver {
    private Driver(){}

    private static InheritableThreadLocal<WebDriver> driver = new InheritableThreadLocal<>();

    public static WebDriver getDriver(){

        if(driver.get() == null){

            String browserType = ConfigurationReader.getProperty("browser");

            switch (browserType){
                case "chrome":

                    driver.set(new ChromeDriver());
                    driver.get().manage().window().maximize();
                    driver.get().manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
                    break;
                case "firefox":

                    driver.set(new FirefoxDriver());
                    driver.get().manage().window().maximize();
                    driver.get().manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
                    break;
                case "headless-chrome":

                    ChromeOptions option = new ChromeOptions();
                    option.addArguments("--headless=new");
                    driver.set(new ChromeDriver(option));
                    driver.get().manage().window().maximize();
                    driver.get().manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
                    break;
            }

        }

        return driver.get();

    }

    public static void closeDriver(){
        if (driver.get()!=null){

            driver.get().quit();

            driver.remove();
        }
    }
}
