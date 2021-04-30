package com.qaprosoft.carina.demo.gui.pages;

import org.openqa.selenium.WebDriver;

import com.qaprosoft.carina.core.gui.AbstractPage;

public class DealsPage extends AbstractPage {

    public DealsPage(WebDriver driver) {
        super(driver);
        setPageURL("/deals.php3");
    }
}
