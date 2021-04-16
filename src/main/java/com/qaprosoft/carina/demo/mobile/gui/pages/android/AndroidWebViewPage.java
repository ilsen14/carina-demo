package com.qaprosoft.carina.demo.mobile.gui.pages.android;

import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.WebDriver;

import com.qaprosoft.carina.core.foundation.utils.factory.DeviceType;
import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.demo.mobile.gui.pages.common.ContactUsPageBase;
import com.qaprosoft.carina.demo.mobile.gui.pages.common.WebViewPageBase;

@DeviceType(pageType = DeviceType.Type.ANDROID_PHONE, parentClass = WebViewPageBase.class)
public class AndroidWebViewPage extends WebViewPageBase {

    @FindBy(className = "t708__btn")
    private ExtendedWebElement contactUsLink;

    @FindBy(className = "android.widget.ImageButton")
    private ExtendedWebElement leftMenuButton;

    @FindBy(xpath = "//android.widget.CheckedTextView[@text = 'Map']")
    private ExtendedWebElement mapLink;

    public AndroidWebViewPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public ContactUsPageBase goToContactUsPage() {
        contactUsLink.click();
        return initPage(getDriver(), ContactUsPageBase.class);
    }
}
