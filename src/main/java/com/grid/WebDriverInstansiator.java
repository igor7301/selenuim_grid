package com.grid;

import org.openqa.selenium.WebDriver;

import java.net.MalformedURLException;

public class WebDriverInstansiator {

    private static InheritableThreadLocal<WebDriver> webDriver = new InheritableThreadLocal<WebDriver>();
    private static WebDriverFactory factory;

    public static void setDriver(String browserName, String browserVersion, String platform) throws MalformedURLException {
        factory = new WebDriverFactory();
        WebDriver driver = factory.getWebDriver(browserName, browserVersion, platform);
        if (driver != null) {

            webDriver.set(driver);
        }
    }

    public static WebDriver getDriver(){
        return webDriver.get();
    }

}
