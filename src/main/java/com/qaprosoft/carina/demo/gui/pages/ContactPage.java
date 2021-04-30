package com.qaprosoft.carina.demo.gui.pages;

import com.qaprosoft.carina.core.gui.AbstractPage;
import org.openqa.selenium.WebDriver;

public class ContactPage extends AbstractPage {

    public ContactPage(WebDriver driver) {
        super(driver);
        setPageURL("/contact.php3");
    }
}
