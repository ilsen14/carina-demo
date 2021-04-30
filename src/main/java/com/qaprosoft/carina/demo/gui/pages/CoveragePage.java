package com.qaprosoft.carina.demo.gui.pages;

import com.qaprosoft.carina.core.gui.AbstractPage;
import org.openqa.selenium.WebDriver;

public class CoveragePage extends AbstractPage {

    public CoveragePage(WebDriver driver) {
        super(driver);
        setPageURL("/network-bands.php3");
    }
}
