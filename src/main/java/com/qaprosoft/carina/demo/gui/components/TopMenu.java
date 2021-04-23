package com.qaprosoft.carina.demo.gui.components;

import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractUIObject;
import com.qaprosoft.carina.demo.gui.components.compare.LoginForm;
import org.testng.asserts.SoftAssert;

public class TopMenu extends AbstractUIObject{

    @FindBy(xpath = "//a[contains(@href, 'tipus.php3')]")
    private ExtendedWebElement tipsTopIcon;

    @FindBy (xpath = "//a[contains(@href, 'https://www.facebook.com/GSMArenacom-189627474421')][1]")
    private ExtendedWebElement facebookTopIcon;

    @FindBy(xpath = "//a[contains(@href, 'https://twitter.com/gsmarena_com')][1]")
    private ExtendedWebElement twitterTopIcon;

    @FindBy(xpath = "//a[contains(@href, 'https://www.instagram.com/gsmarenateam')][1]")
    private ExtendedWebElement instagramTopIcon;

    @FindBy(xpath = "//a[contains(@class, 'yt-icon')][1]")
    private ExtendedWebElement youtubeTopIcon;

    @FindBy(id = "login-popup2")
    private LoginForm loginForm;

    @FindBy(xpath = "//a[contains(@class, 'rss-icon')][1]")
    private ExtendedWebElement newsTopIcon;

    @FindBy(xpath = "//a[contains(@class, 'login-icon')]")
    private ExtendedWebElement loginIcon;

    @FindBy(xpath = "//a[contains(@href, 'register.php3')]")
    private ExtendedWebElement signUpIcon;

    @FindBy(id = "topsearch-text")
    private ExtendedWebElement searchButtonIcon;

    @FindBy(xpath = "//span[contains(@id, 'login-popup2')]")
    private ExtendedWebElement popLogin;

    @FindBy(xpath = "//a[contains(@id, 'login-active')]")
    private ExtendedWebElement activeLogin;

    @FindBy(id = "nick-submit")
    private ExtendedWebElement loginButton;

    public TopMenu(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
    }

    public boolean isSearchTopIconPresent(){
        return searchButtonIcon.isPresent();
    }

    public boolean isTipsTopIconPresent(){
        return tipsTopIcon.isPresent();
    }

    public boolean isInstagramTopIconPresent(){
        return instagramTopIcon.isPresent();
    }

    public boolean isFacebookTopIconPresent(){
        return facebookTopIcon.isPresent();
    }

    public boolean isNewsTopIconPresent(){
        return newsTopIcon.isPresent();
    }

    public boolean isYouTubeTopIconPresent(){
        return youtubeTopIcon.isPresent();
    }

    public boolean isLoginIconPresent(){
        return loginIcon.isPresent();
    }

    public boolean isSignUpIconPresent(){
        return signUpIcon.isPresent();
    }

    public boolean isTwitterIconPresent(){
        return twitterTopIcon.isPresent();
    }

    public LoginForm pressLoginButton(){
        loginIcon.click();
        return loginForm;
    }

    public boolean isUserLoggedIn(){
        return activeLogin.isPresent();
    }

    public void validateIconsPresent(SoftAssert softAssert) {
        softAssert.assertTrue(isSearchTopIconPresent(), "There is no search icon");
        softAssert.assertTrue(isTipsTopIconPresent(), "There is no tips icon");
        softAssert.assertTrue(isFacebookTopIconPresent(), "There is no facebook icon");
        softAssert.assertTrue(isInstagramTopIconPresent(), "Instagram icon is not found");
        softAssert.assertTrue(isTwitterIconPresent(), "Can't find twitter button");
        softAssert.assertTrue(isNewsTopIconPresent(), "News icon is not present");
        softAssert.assertTrue(isLoginIconPresent(), "Login button is not present");
        softAssert.assertTrue(isSignUpIconPresent(), "SignUp icon is absent");
        softAssert.assertTrue(isYouTubeTopIconPresent(), "There is no youtube icon");
    }
}
