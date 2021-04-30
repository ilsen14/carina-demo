package com.qaprosoft.carina.demo.gui.pages;

import com.qaprosoft.carina.core.gui.AbstractPage;
import org.openqa.selenium.WebDriver;

public class DealsPage extends AbstractPage {

    public DealsPage(WebDriver driver) {
        super(driver);
        setPageURL("/deals.php3");
    }
}
