package com.qaprosoft.carina.demo.gui.pages;

import org.apache.log4j.Logger;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.WebDriver;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractPage;

public class SearchPage extends AbstractPage {

    private static final Logger LOGGER = Logger.getLogger(SearchPage.class);
    final String title = "Phone Finder";

    @FindBy(xpath = "//button[contains(@class, 'btn')][1]")
    private ExtendedWebElement phoneSelectField;

    @FindBy(xpath = "//input[@class='pf-button']")
    private ExtendedWebElement searchButton;

    @FindBy(xpath ="//input[contains(@class, 'form-control')][1]")
    private ExtendedWebElement inputPhoneBrand;

    @FindBy(xpath = "//span[@class='text' and contains(text(), '%s')]")
    private ExtendedWebElement brandName;

    @FindBy(xpath = "//h1[@class='article-info-name']")
    private ExtendedWebElement phoneFinderTitle;

    @FindBy(xpath = "//span[@class='pf-border']/span")
    private ExtendedWebElement searchResult;

    public SearchPage(WebDriver driver) {
        super(driver);
        setPageURL("/search.php3?");
    }

    public void selectBrand(String text){
        LOGGER.info("Press brand field");
        phoneSelectField.click();
        LOGGER.info("Search brand:" + text);
        inputPhoneBrand.type(text);
        brandName.format(text).click();
    }

    public PhoneSearchResultPage pressSearch(){
        LOGGER.info("Search result page is opened!");
        searchButton.click();
        return new PhoneSearchResultPage(getDriver());
    }

    public boolean isSearchButtonPresent() {
        return searchButton.isPresent();
    }

    public String getSearchResultText(){
        return searchResult.getText();
    }
}
