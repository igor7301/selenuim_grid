package com.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

/**
 * Created by Serhii_Pirohov on 23.06.2015.
 */
public class GooglePage extends Page {
    private WebDriver driver;

    private static final String URL = "http://google.com/";

    private static final By SEARCH_INPUT = By.name("q");
    private static final By SEARCH_BTN = By.name("btnK");


    public GooglePage(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }


    public void search(String name) {
        driver.findElement(By.cssSelector(".gsfi")).sendKeys("gjhgjh");
//        driver.findElement(By.name("btnK")).click();
        driver.findElement(By.cssSelector(".gsfi")).sendKeys(Keys.ENTER);
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

    public void open() {
        driver.navigate().to("http://www.google.com");



    }
}
