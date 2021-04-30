package com.qaprosoft.carina.demo.gui.pages;

import org.openqa.selenium.WebDriver;

import com.qaprosoft.carina.core.gui.AbstractPage;

public class VideosPage extends AbstractPage {

    public VideosPage(WebDriver driver) {
        super(driver);
        setPageURL("/videos.php3");
    }
}
