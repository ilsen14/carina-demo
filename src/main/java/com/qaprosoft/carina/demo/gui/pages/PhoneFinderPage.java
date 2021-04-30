package com.qaprosoft.carina.demo.gui.pages;

import com.qaprosoft.carina.core.gui.AbstractPage;
import org.openqa.selenium.WebDriver;

public class PhoneFinderPage extends AbstractPage {

    public PhoneFinderPage(WebDriver driver) {
        super(driver);
        setPageURL("/search.php3?");
    }
}
