package com.qaprosoft.carina.demo.mobile.gui.pages.common;

import org.openqa.selenium.WebDriver;

import com.qaprosoft.carina.core.gui.AbstractPage;

public abstract class WebViewPageBase extends AbstractPage {

    public WebViewPageBase(WebDriver driver) {
        super(driver);
    }

    public abstract ContactUsPageBase goToContactUsPage();

}
