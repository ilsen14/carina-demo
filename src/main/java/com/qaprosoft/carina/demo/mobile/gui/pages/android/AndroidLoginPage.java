package com.qaprosoft.carina.demo.mobile.gui.pages.android;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import com.qaprosoft.carina.core.foundation.utils.factory.DeviceType;
import com.qaprosoft.carina.core.foundation.utils.factory.DeviceType.Type;
import com.qaprosoft.carina.core.foundation.utils.mobile.IMobileUtils;
import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.demo.enums.GenderEnum;
import com.qaprosoft.carina.demo.mobile.gui.pages.common.CarinaDescriptionPageBase;
import com.qaprosoft.carina.demo.mobile.gui.pages.common.LoginPageBase;

@DeviceType(pageType = Type.ANDROID_PHONE, parentClass = LoginPageBase.class)
public class AndroidLoginPage extends LoginPageBase implements IMobileUtils {

    @FindBy(id = "name")
    private ExtendedWebElement nameInputField;

    @FindBy(id = "password")
    private ExtendedWebElement passwordInputField;

    @FindBy(xpath = "//android.widget.RadioButton%s")
    private ExtendedWebElement genderRadioBtn;

    @FindBy(id = "checkbox")
    private ExtendedWebElement privacyPolicyCheckbox;

    @FindBy(id = "login_button")
    private ExtendedWebElement loginBtn;

    public AndroidLoginPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public void typeName(String name) {
        nameInputField.type(name);
        hideKeyboard();
    }

    @Override
    public void typePassword(String password) {
        passwordInputField.type(password);
    }

    @Override
    public void selectGender(GenderEnum gender) {
        genderRadioBtn.format(gender.getGender()).click();
    }

    @Override
    public void checkPrivacyPolicyCheckbox() {
        privacyPolicyCheckbox.click();
    }

    @Override
    public CarinaDescriptionPageBase clickLoginBtn() {
        waitUntil(ExpectedConditions.presenceOfElementLocated(loginBtn.getBy()), 10);
        loginBtn.click();
        return initPage(getDriver(), CarinaDescriptionPageBase.class);
    }

    @Override
    public boolean isLoginBtnActive() {
        return Boolean.parseBoolean(loginBtn.getAttribute("enabled"));
    }

    @Override
    public CarinaDescriptionPageBase login() {
        String username = "Test user";
        String password = RandomStringUtils.randomAlphabetic(10);
        typeName(username);
        typePassword(password);
        selectGender(GenderEnum.MALE);
        checkPrivacyPolicyCheckbox();
        return clickLoginBtn();
    }

    @Override
    public boolean isNameInputFieldPresent() {
        return nameInputField.isPresent();
    }

    @Override
    public boolean isNameTextPrinted(String username) {
        return username.equals(nameInputField.getText());
    }

    @Override
    public boolean isPasswordInputFieldPresent() {
        return passwordInputField.isPresent();
    }

    @Override
    public boolean isPasswordTextPrinted(String password) {
        return password.equals(passwordInputField.getText());
    }

    @Override
    public boolean isGenderRadioBtnPresent(GenderEnum gender) {
        return genderRadioBtn.format(gender.getGender()).isPresent();
    }

    @Override
    public boolean isGenderButtonChecked(GenderEnum gender) {
        return genderRadioBtn.format(gender.getGender()).isChecked();
    }

    @Override
    public boolean isPrivacyPolicyCheckBoxPresent() {
        return privacyPolicyCheckbox.isPresent();
    }

    @Override
    public boolean isPrivacyPolicyCheckBoxChecked() {
        return privacyPolicyCheckbox.isChecked();
    }

    @Override
    public boolean isLoginPageOpened() {
        return loginBtn.isElementPresent();
    }
}
