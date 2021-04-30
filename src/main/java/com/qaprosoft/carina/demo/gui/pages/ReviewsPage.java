package com.qaprosoft.carina.demo.gui.pages;

import com.qaprosoft.carina.core.gui.AbstractPage;
import org.openqa.selenium.WebDriver;

public class ReviewsPage extends AbstractPage {

    public ReviewsPage(WebDriver driver) {
        super(driver);
        setPageURL("/reviews.php3");
    }
}
