package com.qaprosoft.carina.demo.gui.components.compare;

import org.openqa.selenium.SearchContext;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.WebDriver;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractUIObject;

public class LoginForm extends AbstractUIObject {

    @FindBy(xpath = "//input[contains(@id, 'email')]")
    private ExtendedWebElement emailTextField;

    @FindBy(xpath = "//input[contains(@id, 'upass')]")
    private ExtendedWebElement passwordTextField;

    @FindBy(xpath = "//input[contains(@id, 'nick-submit')]")
    private ExtendedWebElement loginButton;

    @FindBy(xpath = "//div[contains(@class,'res-error')]/p")
    public ExtendedWebElement textError;

    public LoginForm(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
    }

    public void login(String email, String pass){
        emailTextField.type(email);
        passwordTextField.type(pass);
        loginButton.click();
    }

    public String errorMassage() {
        return textError.getText();
    }

}
