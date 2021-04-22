package com.qaprosoft.carina.demo.mobile.gui.pages.common;

import org.openqa.selenium.WebDriver;

import com.qaprosoft.carina.core.gui.AbstractPage;

public abstract class LoginPageBase extends AbstractPage {

	public LoginPageBase(WebDriver driver) {
		super(driver);
	}

	public abstract void typeName(String name);

	public abstract void typePassword(String password);

	public abstract void selectGender();

	public abstract void checkPrivacyPolicyCheckbox();

	public abstract CarinaDescriptionPageBase clickLoginBtn();

	public abstract boolean isLoginBtnActive();

	public abstract CarinaDescriptionPageBase login();

	public abstract boolean isNameInputFieldPresent();

	public abstract boolean isNameTextPrinted(String username);

	public abstract boolean isPasswordInputFieldPresent();

	public abstract boolean isPasswordTextPrinted(String password);

	public abstract boolean isGenderRadioBtnPresent();

	public abstract boolean isPrivacyPolicyCheckBoxPresent();

	public abstract boolean isGenderRadioBtnChecked();

	public abstract boolean isPrivacyPolicyCheckBoxChecked();

	public abstract boolean isLoginPageOpened();

}
