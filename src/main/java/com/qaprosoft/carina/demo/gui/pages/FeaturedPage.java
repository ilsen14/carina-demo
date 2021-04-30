package com.qaprosoft.carina.demo.gui.pages;

import com.qaprosoft.carina.core.gui.AbstractPage;
import org.openqa.selenium.WebDriver;

public class FeaturedPage extends AbstractPage {

    public FeaturedPage(WebDriver driver) {
        super(driver);
        setPageURL("/news.php3?sTag=Featured");
    }
}
