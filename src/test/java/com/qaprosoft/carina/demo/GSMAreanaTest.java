package com.qaprosoft.carina.demo;

import java.util.List;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.testng.annotations.Test;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import com.qaprosoft.carina.core.foundation.AbstractTest;
import com.qaprosoft.carina.core.foundation.utils.ownership.MethodOwner;
import com.qaprosoft.carina.core.foundation.utils.tag.Priority;
import com.qaprosoft.carina.core.foundation.utils.tag.TestPriority;
import com.qaprosoft.carina.demo.consant.ProjectConstants;
import com.qaprosoft.carina.demo.gui.components.compare.LoginForm;
import com.qaprosoft.carina.demo.gui.components.FooterMenu;
import com.qaprosoft.carina.demo.gui.components.LoginService;
import com.qaprosoft.carina.demo.gui.components.NewsItem;
import com.qaprosoft.carina.demo.gui.components.TopMenu;
import com.qaprosoft.carina.demo.gui.components.User;
import com.qaprosoft.carina.demo.gui.components.UserService;
import com.qaprosoft.carina.demo.gui.pages.NewsPage;
import com.qaprosoft.carina.demo.gui.pages.HomePage;
import com.qaprosoft.carina.demo.gui.pages.ArticlePage;
import com.zebrunner.agent.core.annotation.TestLabel;

public class GSMAreanaTest extends AbstractTest{

    @Test(description = "JIRA#AUTO-0008")
    @MethodOwner(owner = "ilsen")
    @TestPriority(Priority.P1)
    @TestLabel(name = "feature", value = {"web", "regression"})
    public void verifyComponentsPresence(){
        SoftAssert softAssert = new SoftAssert();
        HomePage homePage = new HomePage(getDriver());
        homePage.open();
        Assert.assertTrue(homePage.isPageOpened(), "Home page is not opened");
        TopMenu topMenu = homePage.getTopMenu();
        softAssert.assertTrue(topMenu.isSearchTopIconPresent(), "There is no search icon");
        softAssert.assertTrue(topMenu.isTipsTopIconPresent(), "There is no tips icon");
        softAssert.assertTrue(topMenu.isFacebookTopIconPresent(), "There is no facebook icon");
        softAssert.assertTrue(topMenu.isInstagramTopIconPresent(), "Instagram icon is not found");
        softAssert.assertTrue(topMenu.isTwitterIconPresent(), "Can't find twitter button");
        softAssert.assertTrue(topMenu.isNewsTopIconPresent(),"News icon is not present");
        softAssert.assertTrue(topMenu.isLoginIconPresent(), "Login button is not present");
        softAssert.assertTrue(topMenu.isSignUpIconPresent(),"SignUp icon is absent");
        softAssert.assertTrue(topMenu.isYouTubeTopIconPresent(), "There is no youtube icon");
        softAssert.assertAll();
    }

    @Test(description = "JIRA#AUTO-0008")
    @MethodOwner(owner = "ilsen")
    @TestPriority(Priority.P1)
    @TestLabel(name = "feature", value = {"web", "regression"})
    public void testUserLogin(){
        UserService userService = new UserService();
        User user = userService.getUser();
        LoginService loginService = new LoginService();
        loginService.login(user.getEmail(),user.getPassword());
    }

    @Test(description = "JIRA#AUTO-0008")
    @MethodOwner(owner = "ilsen")
    @TestLabel(name = "feature", value = { "web", "regression" })
    public void testWrongEmail() {
        String invalidEmail = "Reason: User record not found.";
        UserService userService = new UserService();
        User user = userService.getUser();
        HomePage homePage = new HomePage(getDriver());
        homePage.open();
        Assert.assertTrue(homePage.isPageOpened(), "Page is not opened");
        TopMenu topMenu = homePage.getTopMenu();
        LoginForm loginForm = topMenu.pressLoginButton();
        loginForm.login(ProjectConstants.WRONG_EMAIL, user.getPassword());
        Assert.assertEquals(loginForm.errorMassage(), invalidEmail, "You entered invalid Email");
    }

    @Test(description = "JIRA#AUTO-0008")
    @MethodOwner(owner = "ilsen")
    @TestLabel(name = "feature", value = { "web", "regression" })
    public void testWrongPass() {
        String wrongPass = "Reason: Wrong password.";
        UserService userService = new UserService();
        User user = userService.getUser();
        HomePage homePage = new HomePage(getDriver());
        homePage.open();
        Assert.assertTrue(homePage.isPageOpened(), "Page is not opened");
        TopMenu topMenu = homePage.getTopMenu();
        LoginForm loginForm = topMenu.pressLoginButton();
        loginForm.login(user.getEmail(), ProjectConstants.WRONG_PASSWORD);
        Assert.assertEquals(loginForm.errorMassage(), wrongPass, "You entered wrong password");
    }

    @Test(description = "JIRA#AUTO-008")
    @MethodOwner(owner = "ilsen")
    @TestLabel(name = "feature" , value = {"web", "regression"})
    public void compareArticleTitles(){
        UserService userService = new UserService();
        User user = userService.getUser();
        LoginService loginService = new LoginService();
        loginService.login(user.getEmail(),user.getPassword());
        HomePage homePage = new HomePage(getDriver());
        FooterMenu footerMenu = homePage.getFooterMenu();
        NewsPage newsPage = footerMenu.openNewsPage();
        Assert.assertTrue(newsPage.isPageOpened(),"News page is opened");
        NewsItem newsItem = newsPage.getNewsItem(4);
        String newsItemTitle = newsItem.getNewsItemTitle();
        ArticlePage articlePage = newsItem.openArticlePage();
        Assert.assertEquals(newsItemTitle, articlePage.getArticleTitle(), "Text is not same");
    }

    @Test(description = "JIRA#AUTO-008")
    @MethodOwner(owner = "ilsen")
    @TestLabel(name = "feature" , value = {"web", "regression"})
    public void verifyIphoneSearch(){
        final String searchIphone = "Iphone";
        UserService userService = new UserService();
        User user = userService.getUser();
        LoginService loginService = new LoginService();
        loginService.login(user.getEmail(), user.getPassword());
        HomePage homePage = new HomePage(getDriver());
        FooterMenu footerMenu = homePage.getFooterMenu();
        NewsPage newsPage = footerMenu.openNewsPage();
        List<NewsItem> news = newsPage.searchNews(searchIphone);
        Assert.assertFalse(CollectionUtils.isEmpty(news));
        for(NewsItem iphoneSearchList : news) {
            Assert.assertTrue(StringUtils.containsIgnoreCase(iphoneSearchList.getNewsItemTitle(), searchIphone), "Invalid search results!");
        }
    }
}
