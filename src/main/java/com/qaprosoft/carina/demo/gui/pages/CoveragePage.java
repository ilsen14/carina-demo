package com.qaprosoft.carina.demo.gui.pages;

import org.openqa.selenium.WebDriver;

import com.qaprosoft.carina.core.gui.AbstractPage;

public class CoveragePage extends AbstractPage {

    public CoveragePage(WebDriver driver) {
        super(driver);
        setPageURL("/network-bands.php3");
    }
}
