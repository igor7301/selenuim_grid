package com.grid;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.remote.MobileBrowserType;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.remote.MobilePlatform;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;

//import io.selendroid.standalone.server.model.SelendroidStandaloneDriver;

/**
 * Created by Igor on 25.09.15.
 */
public class WebDriverFactory {

    public static WebDriver getWebDriver(String name, String browserVersion, String platform) throws MalformedURLException {
        WebDriver driver = null;
        DesiredCapabilities capability = new DesiredCapabilities();


        if ("WIN".equalsIgnoreCase(platform)){

            capability.setPlatform(Platform.WINDOWS);
            if("CHROME".equalsIgnoreCase(name)){
//                System.setProperty("webdriver.chrome.driver", "Z:\\Downloads\\chromedriverwin\\chromedriver.exe");

            }
            driver= new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), capability);

        }
        else if ("MAC".equalsIgnoreCase(platform)) {
            capability.setBrowserName(name);
            capability.setVersion(browserVersion);

            capability.setPlatform(Platform.MAC);
            if("CHROME".equalsIgnoreCase(name)){
                System.setProperty("webdriver.chrome.driver", "/Users/Igor/Downloads/chromedriver");

            }

                driver= new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), capability);


        }
        else if ("ANDROID".equalsIgnoreCase(platform)) {
//            capability.setPlatform(Platform.ANDROID);
//            capability.setCapability("device", "Android");
//            capability.setCapability("deviceName", "X9LDU15411001673");
            capability.setCapability("deviceName", "emulator-5554");
//            capability.setCapability("browserName", "Chrome");
//            capability.setCapability("platformVersion", "4.4.2");
//            capability.setCapability("platformName", "Android");
            try {
//                driver = new SelendroidDriver(SelendroidCapabilities.android());
                driver = new AndroidDriver(new URL("http://localhost:4444/wd/hub"), capability);
            } catch (Exception e) {
                e.printStackTrace();
            }

        }
        else if ("IOS".equalsIgnoreCase(platform)) {


            capability.setCapability(MobileCapabilityType.PLATFORM_NAME, MobilePlatform.IOS);
            capability.setCapability(MobileCapabilityType.DEVICE_NAME, "iPhone 6 Plus");
            capability.setCapability(MobileCapabilityType.BROWSER_NAME, MobileBrowserType.SAFARI);

            driver = new IOSDriver(new URL("http://127.0.0.1:4725/wd/hub"), capability);
        }





        return driver;
    }
}
