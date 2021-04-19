package com.qaprosoft.carina.demo.mobile.gui.pages.android;

import org.openqa.selenium.WebDriver;

import com.qaprosoft.carina.core.foundation.utils.factory.DeviceType;
import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.foundation.webdriver.locator.ExtendedFindBy;
import com.qaprosoft.carina.demo.mobile.gui.pages.common.MapsPageBase;

@DeviceType(pageType = DeviceType.Type.ANDROID_PHONE, parentClass = MapsPageBase.class)
public class AndroidMapsPage extends MapsPageBase {

    @ExtendedFindBy(androidUIAutomator ="new UiSelector().description(\"Zoom in\")")
    private ExtendedWebElement zoomInButton;

    @ExtendedFindBy(androidUIAutomator ="new UiSelector().description(\"Zoom out\")")
    private ExtendedWebElement zoomOutButton;

    @ExtendedFindBy(androidUIAutomator ="new UiSelector().resourceIdMatches(\".*id/drawer_layout\")")
    private ExtendedWebElement innerLayout;

    public AndroidMapsPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public boolean isZoomInButtonPresent() {
        return zoomInButton.isPresent();
    }

    @Override
    public boolean isZoomOutButtonPresent() {
        return zoomOutButton.isPresent();
    }

    @Override
    public boolean isMapsPageOpened() {
        return innerLayout.isElementPresent();
    }

    @Override
    public boolean isZoomInButtonHigherPlaced() {
        return (zoomInButton.getLocation().getY()) > (zoomOutButton.getLocation().getY());
        }
    }
