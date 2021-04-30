package com.qaprosoft.carina.demo.gui.pages;

import org.openqa.selenium.WebDriver;

import com.qaprosoft.carina.core.gui.AbstractPage;

public class FeaturedPage extends AbstractPage {

    public FeaturedPage(WebDriver driver) {
        super(driver);
        setPageURL("/news.php3?sTag=Featured");
    }
}
