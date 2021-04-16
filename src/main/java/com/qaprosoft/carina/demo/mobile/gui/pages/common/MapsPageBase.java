package com.qaprosoft.carina.demo.mobile.gui.pages.common;

import org.openqa.selenium.WebDriver;

import com.qaprosoft.carina.core.gui.AbstractPage;

public abstract class MapsPageBase extends AbstractPage {

    public MapsPageBase(WebDriver driver) {
        super(driver);
    }

    public abstract boolean isZoomInButtonPresent();

    public abstract boolean isZoomOutButtonPresent();

    public abstract boolean isZoomInButtonHigherPlaced();

    public abstract boolean isMapsPageOpened();

}
