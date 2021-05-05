package com.qaprosoft.carina.demo.gui.pages;

import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractPage;

public class PhoneSearchResultPage extends AbstractPage {

    private static final Logger LOGGER = Logger.getLogger(PhoneSearchResultPage.class);
    private final String TITLE_RESULT_PAGE = "Phone finder results";

    @FindBy(xpath = "//h1[@class='article-info-name']")
    private ExtendedWebElement resultTitlePage;

    @FindBy(xpath = "//div[@class='st-text']")
    private ExtendedWebElement resultText;

    @FindBy(xpath = "//div[@class='makers']//span")
    private List<ExtendedWebElement> phoneResult;

    @FindBy(xpath = "//a[contains(text(),'click here')]")
    private ExtendedWebElement clickHereBtn;

    public PhoneSearchResultPage(WebDriver driver) {
        super(driver);
    }

    public boolean isOpened() {
        return resultTitlePage.getText().equals(TITLE_RESULT_PAGE);
    }

    public boolean isBtnClickHerePresent() {
        return clickHereBtn.isPresent();
    }

    public SearchPage pressClickHereBtn(){
        LOGGER.info("Press if you want to return to Search Page");
        clickHereBtn.click();
        return new SearchPage(getDriver());
    }

    public boolean isTextPresent(String resultTextBtn) {
        final String searchText = "Your search returned " + resultTextBtn + ".";
        final String refineText = "To refine your search click here.";
        LOGGER.info("Check for containsn searchText" + searchText);
        LOGGER.info("Check for containsn searchText" + refineText);
        return StringUtils.containsIgnoreCase(resultText.getText(), searchText)
                & StringUtils.containsIgnoreCase(resultText.getText(), refineText);
    }

    public boolean verifySearchByCurrentBrand(String modelPhone) {
        LOGGER.info("Сheck for presence in the title " + modelPhone);
        for (ExtendedWebElement model : phoneResult) {
            if (!StringUtils.containsIgnoreCase(model.getText(), modelPhone)) {
                LOGGER.error("This model not include " + modelPhone);
                return false;
            }
        }
        return true;
    }
}
