package com.pageobjects;

import org.openqa.selenium.WebDriver;

/**
 * Created by Igor on 25.09.15.
 */
public abstract class Page {
    private WebDriver driver;

    public Page(WebDriver driver) {
      this.driver = driver;
    }
}
