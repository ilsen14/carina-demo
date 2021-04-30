package com.qaprosoft.carina.demo.gui.pages;

import org.openqa.selenium.WebDriver;

import com.qaprosoft.carina.core.gui.AbstractPage;

public class ReviewsPage extends AbstractPage {

    public ReviewsPage(WebDriver driver) {
        super(driver);
        setPageURL("/reviews.php3");
    }
}
