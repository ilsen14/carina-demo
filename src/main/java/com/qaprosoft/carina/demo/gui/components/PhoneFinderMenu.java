package com.qaprosoft.carina.demo.gui.components;

import org.apache.log4j.Logger;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractUIObject;
import com.qaprosoft.carina.demo.gui.pages.BrandModelsPage;

public class PhoneFinderMenu extends AbstractUIObject {

    private final static Logger LOGGER = Logger.getLogger(PhoneFinderMenu.class);

    @FindBy(xpath = "//a[text()='%s']")
    private ExtendedWebElement openModelSearch;

    public PhoneFinderMenu(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
    }

    public BrandModelsPage openModelSearch(String text){
        LOGGER.info("Apple Search Page is opened!");
        openModelSearch.format(text).click();
        return new BrandModelsPage(driver);
    }
}
