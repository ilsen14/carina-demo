package com.qaprosoft.carina.demo.gui.pages;

import org.openqa.selenium.WebDriver;

import com.qaprosoft.carina.core.gui.AbstractPage;

public class ToolsPage extends AbstractPage {

    public ToolsPage(WebDriver driver) {
        super(driver);
        setPageURL("/tools.php3");
    }
}
