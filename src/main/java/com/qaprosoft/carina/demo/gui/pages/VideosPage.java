package com.qaprosoft.carina.demo.gui.pages;

import com.qaprosoft.carina.core.gui.AbstractPage;
import org.openqa.selenium.WebDriver;

public class VideosPage extends AbstractPage {

    public VideosPage(WebDriver driver) {
        super(driver);
        setPageURL("/videos.php3");
    }
}
