package com.qaprosoft.carina.demo.gui.components;

import org.testng.Assert;

import com.qaprosoft.carina.core.foundation.webdriver.IDriverPool;
import com.qaprosoft.carina.demo.gui.components.compare.LoginForm;
import com.qaprosoft.carina.demo.gui.pages.HomePage;

public class LoginService implements IDriverPool {

    public HomePage login(String email, String pass) {
        HomePage homePage = new HomePage(getDriver());
        homePage.open();
        Assert.assertTrue(homePage.isPageOpened(), "Home page is not opened");
        TopMenu topMenu = homePage.getTopMenu();
        LoginForm loginForm = topMenu.pressLoginButton();
        loginForm.login(email, pass);
        Assert.assertTrue(topMenu.isUserLoggedIn(), "User wasn't login on website");
        return new HomePage(getDriver());
    }
}
