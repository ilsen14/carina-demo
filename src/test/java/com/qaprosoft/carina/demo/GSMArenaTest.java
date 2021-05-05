package com.qaprosoft.carina.demo;

import java.util.HashMap;
import java.util.List;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import com.qaprosoft.carina.core.foundation.AbstractTest;
import com.qaprosoft.carina.core.foundation.dataprovider.annotations.XlsDataSourceParameters;
import com.qaprosoft.carina.core.foundation.utils.ownership.MethodOwner;
import com.qaprosoft.carina.core.foundation.utils.tag.Priority;
import com.qaprosoft.carina.core.foundation.utils.tag.TestPriority;
import com.qaprosoft.carina.demo.consant.ProjectConstants;
import com.qaprosoft.carina.demo.gui.components.compare.LoginForm;
import com.qaprosoft.carina.demo.gui.components.HamburgerMenu;
import com.qaprosoft.carina.demo.gui.components.NewsItem;
import com.qaprosoft.carina.demo.gui.components.TopMenu;
import com.qaprosoft.carina.demo.gui.pages.ArticlePage;
import com.qaprosoft.carina.demo.gui.pages.ContactPage;
import com.qaprosoft.carina.demo.gui.pages.CoveragePage;
import com.qaprosoft.carina.demo.gui.pages.DealsPage;
import com.qaprosoft.carina.demo.gui.pages.FeaturedPage;
import com.qaprosoft.carina.demo.gui.pages.GlossaryPage;
import com.qaprosoft.carina.demo.gui.pages.HomePage;
import com.qaprosoft.carina.demo.gui.pages.NewsPage;
import com.qaprosoft.carina.demo.gui.pages.PhoneSearchResultPage;
import com.qaprosoft.carina.demo.gui.pages.ReviewsPage;
import com.qaprosoft.carina.demo.gui.pages.SearchPage;
import com.qaprosoft.carina.demo.gui.pages.ToolsPage;
import com.qaprosoft.carina.demo.gui.pages.VideosPage;
import com.qaprosoft.carina.demo.services.LoginService;
import com.qaprosoft.carina.demo.services.User;
import com.qaprosoft.carina.demo.services.UserService;
import com.zebrunner.agent.core.annotation.TestLabel;

public class GSMArenaTest extends AbstractTest{

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
        topMenu.validateTopMainMenuElements(softAssert);
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
        LoginForm loginForm = homePage.getTopMenu().pressLoginButton();
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
        LoginForm loginForm = homePage.getTopMenu().pressLoginButton();
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
        NewsPage newsPage = homePage.getFooterMenu().openNewsPage();
        Assert.assertTrue(newsPage.isPageOpened(),"News page is opened");
        NewsItem newsItem = newsPage.getNewsItem(4);
        String newsItemTitle = newsItem.getNewsItemTitle();
        ArticlePage articlePage = newsItem.openArticlePage();
        Assert.assertEquals(newsItemTitle, articlePage.getArticleTitle(), "Text is not same");
    }

    @Test(description = "JIRA#AUTO-0008")
    @MethodOwner(owner = "ilsen")
    @Parameters({"phoneSearch"})
    public void verifyPhoneSearch(String search) {
        UserService userService = new UserService();
        User user = userService.getUser();
        LoginService loginService = new LoginService();
        loginService.login(user.getEmail(), user.getPassword());
        HomePage homePage = new HomePage(getDriver());
        NewsPage newsPage = homePage.getFooterMenu().openNewsPage();
        List<NewsItem> news = newsPage.searchNews(search);
        Assert.assertFalse(CollectionUtils.isEmpty(news), "Failed search");
        for (NewsItem searchList : news) {
            Assert.assertTrue(StringUtils.containsIgnoreCase(searchList.getNewsItemTitle(), search), "Invalid search results!");
        }
    }

    @Test(dataProvider = "DataProvider")
    @MethodOwner(owner = "ilsen")
    @XlsDataSourceParameters(path = "xls/phoneSearch.xlsx", sheet = "phoneSheet", dsUid = "TUID")
    public void verifyPhoneSearchUsingXLS(HashMap<String, String> device) {
        final String phone = device.get("brand");
        UserService userService = new UserService();
        User user = userService.getUser();
        LoginService loginService = new LoginService();
        loginService.login(user.getEmail(), user.getPassword());
        HomePage homePage = new HomePage(getDriver());
        NewsPage newsPage = homePage.getFooterMenu().openNewsPage();
        List<NewsItem> news = newsPage.searchNews(phone);
        Assert.assertFalse(CollectionUtils.isEmpty(news), "Failed search");
        for (NewsItem searchList : news) {
            Assert.assertTrue(StringUtils.containsIgnoreCase(searchList.getNewsItemTitle(), phone), "Invalid search results!");
        }
    }

    @Test(description = "JIRA#AUTO-0008")
    @MethodOwner(owner = "ilsen")
    @TestLabel(name = "feature", value = { "web", "regression" })
    public void testVerifyGlossaryFirstLetterInTitle() {
        HomePage homePage = new HomePage(getDriver());
        homePage.open();
        GlossaryPage glossaryPage = homePage.getFooterMenu().openGlossaryPage();
        Assert.assertTrue(glossaryPage.isPageOpened(), "Glossary Page isn't opened");
        Assert.assertTrue(glossaryPage.verifyHeaderAndTextEquality(), "Elements don't match");
        Assert.assertTrue(glossaryPage.verifyTitleByFirstLetter(), "Not alphabet sort");
    }

    @Test(description = "JIRA#AUTO-0008")
    @MethodOwner(owner = "ilsen")
    @TestLabel(name = "feature", value = { "web", "regression" })
    public void testVerifyGlossaryTextByAlphabets() {
        HomePage homePage = new HomePage(getDriver());
        homePage.open();
        GlossaryPage glossaryPage = homePage.getFooterMenu().openGlossaryPage();
        Assert.assertTrue(glossaryPage.isPageOpened(), "Glossary Page isn't opened");
        Assert.assertTrue(glossaryPage.verifyHeaderAndTextEquality(), "Header and text items don't match");
        Assert.assertTrue(glossaryPage.verifyAlphabeticalOrder(glossaryPage.glossaryItem));
    }

    @Test
    @MethodOwner(owner = "ilsen")
    public void verifyHamburgerPageOpening() {
        HomePage homePage = new HomePage(getDriver());
        homePage.open();
        Assert.assertTrue(homePage.isPageOpened(), "HomePage is not opened!");
        HamburgerMenu hamburgerMenu = homePage.getTopMenu().openHamburgerMenu();
        ContactPage contactPage = hamburgerMenu.openContactPage();
        Assert.assertTrue(contactPage.isPageOpened(), "Contact Page is not opened");
        CoveragePage coveragePage = hamburgerMenu.openCoveragePage();
        Assert.assertTrue(coveragePage.isPageOpened(), "Coverage Page is not opened");
        DealsPage dealsPage = hamburgerMenu.openDealsPage();
        Assert.assertTrue(dealsPage.isPageOpened(), "Deals Page is not opened");
        FeaturedPage featuredPage = hamburgerMenu.openFeaturedPage();
        Assert.assertTrue(featuredPage.isPageOpened(), "Featured Page is not opened");
        NewsPage newsPage = hamburgerMenu.openNewsPage();
        Assert.assertTrue(newsPage.isPageOpened(), "News page is not opened");
        SearchPage phoneFinderPage = hamburgerMenu.openPhoneFinderPage();
        Assert.assertTrue(phoneFinderPage.isPageOpened(), "Phone Finder page is not opened");
        ReviewsPage reviewsPage = hamburgerMenu.openReviewsPage();
        Assert.assertTrue(reviewsPage.isPageOpened(), "Review Page is not opened!");
        ToolsPage toolsPage = hamburgerMenu.openToolsPage();
        Assert.assertTrue(toolsPage.isPageOpened(), "Tools Page is not opened");
        VideosPage videosPage = hamburgerMenu.openVideosPage();
        Assert.assertTrue(videosPage.isPageOpened(), "Vidoes page is not opened");
    }

    @Test
    @MethodOwner(owner = "ilsen")
    public void verifyXiaomiSearch(){
        final String phone = "Xiaomi";
        HomePage homePage = new HomePage(getDriver());
        homePage.open();
        Assert.assertTrue(homePage.isPageOpened(),"Home page is not opened!");
        HamburgerMenu hamburgerMenu = homePage.getTopMenu().openHamburgerMenu();
        Assert.assertTrue(hamburgerMenu.verifyPhoneSearchButtonPresence(),"Phone Search button is not absent");
        SearchPage searchPage = hamburgerMenu.openPhoneFinderPage();
        Assert.assertTrue(searchPage.isPageOpened(), "Page is not opened");
        searchPage.selectBrand(phone);
        Assert.assertTrue(searchPage.isSearchButtonPresent(), "Search button is absent");
        String titleSearchResult = searchPage.getSearchResultText();
        PhoneSearchResultPage resultPage = searchPage.pressSearch();
        Assert.assertTrue(resultPage.isTextPresent(titleSearchResult));
        Assert.assertTrue(resultPage.verifySearchByCurrentBrand(phone));
        Assert.assertTrue(resultPage.isBtnClickHerePresent(),"Click here button is missing");
        searchPage = resultPage.pressClickHereBtn();
        Assert.assertTrue(searchPage.isPageOpened(), "Search Page is not opened");
    }

    @Test
    @MethodOwner(owner = "ilsen")
    public void verifyIphoneSearch(){
        UserService userService = new UserService();
        User user = userService.getUser();
        LoginService loginService = new LoginService();
        loginService.login(user.getEmail(), user.getPassword());
        HomePage homePage = new HomePage(getDriver());
    }
}
