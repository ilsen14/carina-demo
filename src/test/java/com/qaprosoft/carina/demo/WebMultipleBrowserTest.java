package com.qaprosoft.carina.demo;

import java.util.List;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.qaprosoft.carina.core.foundation.AbstractTest;
import com.qaprosoft.carina.core.foundation.utils.ownership.MethodOwner;
import com.qaprosoft.carina.core.foundation.webdriver.Screenshot;
import com.qaprosoft.carina.core.foundation.webdriver.core.capability.impl.desktop.ChromeCapabilities;
import com.qaprosoft.carina.core.foundation.webdriver.core.capability.impl.desktop.FirefoxCapabilities;
import com.qaprosoft.carina.demo.gui.components.NewsItem;
import com.qaprosoft.carina.demo.gui.pages.HomePage;
import com.qaprosoft.carina.demo.gui.pages.NewsPage;

public class WebMultipleBrowserTest extends AbstractTest {

    @Test
    @MethodOwner(owner = "qpsdemo")
    public void multipleBrowserTest() {
        HomePage chromeHomePage = new HomePage(getDriver("chrome", new ChromeCapabilities().getCapability("Chrome Test")));
        chromeHomePage.open();
        Assert.assertTrue(chromeHomePage.isPageOpened(), "Chrome home page is not opened!");

        HomePage firefoxHomePage = new HomePage(getDriver("firefox", new FirefoxCapabilities().getCapability("Firefox Test")));
        firefoxHomePage.open();
        Assert.assertTrue(firefoxHomePage.isPageOpened(), "Firefox home page is not opened!");
        Assert.assertEquals(firefoxHomePage.getDriver().getTitle(), "GSMArena.com - mobile phone reviews, news, specifications and more...");
        Screenshot.capture(firefoxHomePage.getDriver(), "Firefox capture!");

        NewsPage newsPage = chromeHomePage.getFooterMenu().openNewsPage();
        final String searchQ = "iphone";
        List<NewsItem> news = newsPage.searchNews(searchQ);
        Screenshot.capture(chromeHomePage.getDriver(), "Chrome capture!");
        Assert.assertFalse(CollectionUtils.isEmpty(news), "News not found!");

        for(NewsItem n : news) {
            System.out.println(n.getNewsItemTitle());
            Assert.assertTrue(StringUtils.containsIgnoreCase(n.getNewsItemTitle(), searchQ), "Invalid search results!");
        }

    }
}