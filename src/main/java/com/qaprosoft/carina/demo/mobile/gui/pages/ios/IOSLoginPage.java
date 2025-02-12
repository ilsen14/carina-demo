package com.qaprosoft.carina.demo.mobile.gui.pages.ios;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.WebDriver;

import com.qaprosoft.carina.core.foundation.utils.factory.DeviceType;
import com.qaprosoft.carina.core.foundation.utils.factory.DeviceType.Type;
import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.foundation.webdriver.decorator.annotations.ClassChain;
import com.qaprosoft.carina.core.foundation.webdriver.decorator.annotations.Predicate;
import com.qaprosoft.carina.demo.enums.GenderEnum;
import com.qaprosoft.carina.demo.mobile.gui.pages.common.CarinaDescriptionPageBase;
import com.qaprosoft.carina.demo.mobile.gui.pages.common.LoginPageBase;
import com.qaprosoft.carina.demo.consant.ProjectConstants;

@DeviceType(pageType = Type.IOS_PHONE, parentClass = LoginPageBase.class)
public class IOSLoginPage extends LoginPageBase {

	@FindBy(xpath = "type = 'XCUIElementTypeTextField'")
	@Predicate
	private ExtendedWebElement nameInputField;

	@FindBy(xpath = "type = 'XCUIElementTypeSecureTextField'")
	@Predicate
	private ExtendedWebElement passwordInputField;

	@FindBy(xpath = "name = 'Male' AND type = 'XCUIElementTypeButton'")
	@Predicate
	private ExtendedWebElement maleRadioBtn;

	@FindBy(xpath = "**/XCUIElementTypeButton[`name == 'Female'`]")
	@ClassChain
	private ExtendedWebElement femaleRadioBtn;

	@FindBy(xpath = "**/XCUIElementTypeButton[`name CONTAINS 'checkbox'`]")
	@ClassChain
	private ExtendedWebElement privacyPolicyCheckbox;

	@FindBy(xpath = "name = 'LOGIN'")
	@Predicate
	private ExtendedWebElement loginBtn;

	public IOSLoginPage(WebDriver driver) {
		super(driver);
	}
	@Override
	public void typeName(String name) {
		nameInputField.type(name);
	}

	@Override
	public void typePassword(String password) {
		passwordInputField.type(password);
	}

	@Override
	public void selectGender(GenderEnum gender) {
		throw new UnsupportedOperationException(ProjectConstants.UNIMPLEMENTED_IOS);
	}

	@Override
	public void checkPrivacyPolicyCheckbox() {
		privacyPolicyCheckbox.click();
	}

	@Override
	public CarinaDescriptionPageBase clickLoginBtn() {
		loginBtn.click();
		return initPage(getDriver(), CarinaDescriptionPageBase.class);
	}

	@Override
	public boolean isLoginBtnActive() {
		return Boolean.parseBoolean(loginBtn.getAttribute("enabled"));
	}

	@Override
	public CarinaDescriptionPageBase login(){
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
		throw new UnsupportedOperationException(ProjectConstants.UNIMPLEMENTED_IOS);
	}

	@Override
	public boolean isNameTextPrinted(String username) {
		throw new UnsupportedOperationException(ProjectConstants.UNIMPLEMENTED_IOS);
	}

	@Override
	public boolean isPasswordInputFieldPresent() {
		throw new UnsupportedOperationException(ProjectConstants.UNIMPLEMENTED_IOS);
	}

	@Override
	public boolean isPasswordTextPrinted(String password) {
		throw new UnsupportedOperationException(ProjectConstants.UNIMPLEMENTED_IOS);
	}

	@Override
	public boolean isPrivacyPolicyCheckBoxPresent() {
		throw new UnsupportedOperationException(ProjectConstants.UNIMPLEMENTED_IOS);
	}

	@Override
	public boolean isPrivacyPolicyCheckBoxChecked() {
		throw new UnsupportedOperationException(ProjectConstants.UNIMPLEMENTED_IOS);
	}

	@Override
	public boolean isLoginPageOpened() {
		throw new UnsupportedOperationException(ProjectConstants.UNIMPLEMENTED_IOS);
	}

	@Override
	public boolean isGenderRadioBtnPresent(GenderEnum gender) {
		throw new UnsupportedOperationException(ProjectConstants.UNIMPLEMENTED_IOS);
	}

	@Override
	public boolean isGenderButtonChecked(GenderEnum gender) {
		throw new UnsupportedOperationException(ProjectConstants.UNIMPLEMENTED_IOS);
	}
}
