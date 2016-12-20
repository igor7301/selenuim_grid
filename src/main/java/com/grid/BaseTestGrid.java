package com.grid;

//import com.grid.shedule.core.WebDriverInstansiator;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import java.io.File;
import java.net.MalformedURLException;

public class BaseTestGrid {

    @Parameters({"browserName", "browserVersion", "platform"})
    @BeforeTest
    public void setUp(@Optional String browserName, String browserVersion, String  platform){
        try {
            WebDriverInstansiator.setDriver(browserName, browserVersion, platform);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
    }

    @

    @AfterTest
    public void tearDown() throws Exception{
        if(WebDriverInstansiator.getDriver() != null){

            File scr =  ((TakesScreenshot)WebDriverInstansiator.getDriver()).getScreenshotAs(OutputType.FILE);
            FileUtils.copyFile(scr, new File("screenshot.png"));

            WebDriverInstansiator.getDriver().quit();
        }
    }

}
