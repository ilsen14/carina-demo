package com.qaprosoft.carina.demo.gui.pages;

import org.openqa.selenium.WebDriver;

import com.qaprosoft.carina.core.gui.AbstractPage;

public class ContactPage extends AbstractPage {

    public ContactPage(WebDriver driver) {
        super(driver);
        setPageURL("/contact.php3");
    }
}
