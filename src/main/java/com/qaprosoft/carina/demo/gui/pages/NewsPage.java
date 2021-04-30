package com.qaprosoft.carina.demo.gui.pages;

import java.util.List;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractPage;
import com.qaprosoft.carina.demo.gui.components.NewsItem;

public class NewsPage extends AbstractPage {

    private final static Logger LOGGER = Logger.getLogger(NewsPage.class);
    
    @FindBy(className="searchFor")
    private ExtendedWebElement searchTextField;
    
    @FindBy(xpath="//input[@value='Search']")
    private ExtendedWebElement searchButton;
    
    @FindBy(xpath="//div[@class='news-item']")
    private List<NewsItem> news;

    public NewsPage(WebDriver driver) {
        super(driver);
        setPageURL("/news.php3");
    }

    public List<NewsItem> searchNews(String searchText) {
        searchTextField.type(searchText);
        LOGGER.info("Typed :" + searchText);
        searchButton.click();
        return news;
    }

    public NewsItem getNewsItem(int index){
        return news.get(index);
    }
}
