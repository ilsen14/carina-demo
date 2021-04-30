package com.qaprosoft.carina.demo.gui.pages;

import com.qaprosoft.carina.core.gui.AbstractPage;
import org.openqa.selenium.WebDriver;

public class ToolsPage extends AbstractPage {

    public ToolsPage(WebDriver driver) {
        super(driver);
        setPageURL("/tools.php3");
    }
}
