package com.qaprosoft.carina.demo.mobile.gui.pages.common;

import org.openqa.selenium.WebDriver;

import com.qaprosoft.carina.core.gui.AbstractPage;


public abstract class ContactUsPageBase extends AbstractPage {

    public ContactUsPageBase(WebDriver driver) {
        super(driver);
    }

    public abstract void typeName(String name);

    public abstract void typeEmail(String email);

    public abstract void typeQuestion(String question);

    public abstract void submit();

    public abstract boolean isSuccessMessagePresent();

    public abstract boolean isRecaptchaPresent();

}
