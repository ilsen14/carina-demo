package com.qaprosoft.carina.demo.mobile.gui.pages.android;

import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.WebDriver;

import com.qaprosoft.carina.core.foundation.utils.factory.DeviceType;
import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.demo.mobile.gui.pages.common.ContactUsPageBase;

@DeviceType(pageType = DeviceType.Type.ANDROID_PHONE, parentClass = ContactUsPageBase.class)
public class AndroidContactUsPage extends ContactUsPageBase {

    @FindBy(xpath = "//input[@name='Email']")
    private ExtendedWebElement emailField;

    @FindBy(xpath = "//input[@name='Name']")
    private ExtendedWebElement nameField;

    @FindBy(xpath = "//textarea[@name='Textarea']")
    private ExtendedWebElement questionField;

    @FindBy(xpath = "//button[@type='submit' and text()='Send']")
    private ExtendedWebElement submitButton;

    @FindBy(xpath = "//div[contains(@class,'t-form__successbox')]")
    private ExtendedWebElement successLabel;

    @FindBy(id = "g-recaptcha-response")
    private ExtendedWebElement recaptcha;

    public AndroidContactUsPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public void typeName(String name) {
        nameField.type(name);
    }

    @Override
    public void typeEmail(String email) {
        emailField.type(email);
    }

    @Override
    public void typeQuestion(String question) {
        questionField.type(question);
    }

    @Override
    public void submit() {
        submitButton.click();
    }

    @Override
    public boolean isSuccessMessagePresent() {
        return successLabel.isElementPresent();
    }

    @Override
    public boolean isRecaptchaPresent() {
        return recaptcha.isElementPresent();
    }

}
