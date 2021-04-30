package com.qaprosoft.carina.demo.gui.pages;

import org.openqa.selenium.WebDriver;

import com.qaprosoft.carina.core.gui.AbstractPage;

public class PhoneFinderPage extends AbstractPage {

    public PhoneFinderPage(WebDriver driver) {
        super(driver);
        setPageURL("/search.php3?");
    }
}
