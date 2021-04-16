package com.qaprosoft.carina.demo.mobile.gui.pages.ios;

import com.qaprosoft.carina.demo.consant.ProjectConstants;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.WebDriver;

import com.qaprosoft.carina.core.foundation.utils.factory.DeviceType;
import com.qaprosoft.carina.core.foundation.utils.factory.DeviceType.Type;
import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.foundation.webdriver.decorator.annotations.Predicate;
import com.qaprosoft.carina.demo.mobile.gui.pages.common.CarinaDescriptionPageBase;
import com.qaprosoft.carina.demo.mobile.gui.pages.common.ChartsPageBase;
import com.qaprosoft.carina.demo.mobile.gui.pages.common.MapsPageBase;
import com.qaprosoft.carina.demo.mobile.gui.pages.common.UIElementsPageBase;
import com.qaprosoft.carina.demo.mobile.gui.pages.common.WebViewPageBase;

@DeviceType(pageType = Type.IOS_PHONE, parentClass = CarinaDescriptionPageBase.class)
public class IOSCarinaDescriptionPage extends CarinaDescriptionPageBase {

    @FindBy(xpath = "name = 'CARINA' AND type = 'XCUIElementTypeStaticText'")
    @Predicate
    private ExtendedWebElement webViewTitle;

    public IOSCarinaDescriptionPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public WebViewPageBase navigateToWebViewPage() {
        throw new UnsupportedOperationException(ProjectConstants.UNIMPLEMENTED_IOS);
    }

    @Override
    public ChartsPageBase navigateToChartsPage() {
        throw new UnsupportedOperationException(ProjectConstants.UNIMPLEMENTED_IOS);
    }

    @Override
    public MapsPageBase navigateToMapPage() {
        throw new UnsupportedOperationException(ProjectConstants.UNIMPLEMENTED_IOS);
    }

    @Override
    public UIElementsPageBase navigateToUIElementsPage() {
        throw new UnsupportedOperationException(ProjectConstants.UNIMPLEMENTED_IOS);
    }

    @Override
    public boolean isPageOpened() {
        throw new UnsupportedOperationException(ProjectConstants.UNIMPLEMENTED_IOS);
    }

}
