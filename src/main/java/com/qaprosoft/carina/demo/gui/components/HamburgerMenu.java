package com.qaprosoft.carina.demo.gui.components;

import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractUIObject;
import com.qaprosoft.carina.demo.gui.pages.ContactPage;
import com.qaprosoft.carina.demo.gui.pages.CoveragePage;
import com.qaprosoft.carina.demo.gui.pages.DealsPage;
import com.qaprosoft.carina.demo.gui.pages.FeaturedPage;
import com.qaprosoft.carina.demo.gui.pages.HomePage;
import com.qaprosoft.carina.demo.gui.pages.NewsPage;
import com.qaprosoft.carina.demo.gui.pages.ReviewsPage;
import com.qaprosoft.carina.demo.gui.pages.SearchPage;
import com.qaprosoft.carina.demo.gui.pages.ToolsPage;
import com.qaprosoft.carina.demo.gui.pages.VideosPage;

public class HamburgerMenu extends AbstractUIObject {

    @FindBy(xpath = "//a[contains(text(),'Home')][1]")
    private ExtendedWebElement homeLink;

    @FindBy(xpath = "//a[contains(text(),'News')][1]")
    private ExtendedWebElement newsLink;

    @FindBy(xpath = "//a[contains(text(),'Reviews')][1]")
    private ExtendedWebElement reviewsLink;

    @FindBy(xpath = "//a[contains(text(),'Videos')][1]")
    private ExtendedWebElement videosLink;

    @FindBy(xpath = "//a[contains(text(),'Featured')][1]")
    private ExtendedWebElement featuredLink;

    @FindBy(xpath = "//a[contains(text(),'Phone Finder')][1]")
    private ExtendedWebElement phoneFinderLink;

    @FindBy(xpath = "//a[contains(text(),'Deals')][1]")
    private ExtendedWebElement dealsLink;

    @FindBy(xpath = "//a[contains(text(),'Tools')][1]")
    private ExtendedWebElement toolsLink;

    @FindBy(xpath = "//a[contains(text(),'Coverage')][1]")
    private ExtendedWebElement coverageLink;

    @FindBy(xpath = "//a[contains(text(),'Contact')][1]")
    private ExtendedWebElement contactLink;

    public HamburgerMenu(WebDriver driver) {
        super(driver);
    }

    public HamburgerMenu(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
    }

    public HomePage openHomePage() {
        homeLink.click();
        return new HomePage(driver);
    }

    public ContactPage openContactPage() {
        contactLink.click();
        return new ContactPage(driver);
    }

    public CoveragePage openCoveragePage(){
        coverageLink.click();
        return new CoveragePage(driver);
    }

    public DealsPage openDealsPage(){
        dealsLink.click();
        return new DealsPage(driver);
    }

    public FeaturedPage openFeaturedPage(){
        featuredLink.click();
        return new FeaturedPage(driver);
    }

    public NewsPage openNewsPage(){
        newsLink.click();
        return new NewsPage(driver);
    }

    public SearchPage openPhoneFinderPage(){
        phoneFinderLink.click();
        return new SearchPage(driver);
    }

    public ReviewsPage openReviewsPage(){
        reviewsLink.click();
        return new ReviewsPage(driver);
    }

    public ToolsPage openToolsPage(){
        toolsLink.click();
        return new ToolsPage(driver);
    }

    public VideosPage openVideosPage(){
        videosLink.click();
        return new VideosPage(driver);
    }

    public boolean verifyPhoneSearchButtonPresence(){
        return phoneFinderLink.isPresent();
    }

    public void click() {
    }
}
