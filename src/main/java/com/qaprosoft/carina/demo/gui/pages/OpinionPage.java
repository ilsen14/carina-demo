package com.qaprosoft.carina.demo.gui.components;

import java.util.List;

import org.apache.log4j.Logger;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractUIObject;

public class OpinionPage extends AbstractUIObject {

    private final static Logger LOGGER = Logger.getLogger(OpinionPage.class);

    @FindBy(xpath = "//div[@class='user-thread']")
    private List<ReviewItem> reviewItems;

    @FindBy(xpath = "//option[@value='0']")
    private ExtendedWebElement newestFirst;

    @FindBy(xpath = "//option[@value='1']")
    private ExtendedWebElement oldestFirst;

    @FindBy(xpath = "//option[@value='2']")
    private ExtendedWebElement bestRating;

    public OpinionPage(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
    }

    public void selectNewestItems(){
        newestFirst.click();
    }

    public void selectOldestItems(){
        oldestFirst.click();
    }

    public void selectBestRating(){
        bestRating.click();
    }

//
//    public boolean verifyAlphabeticalOrder(List<GlossaryItem> glossaryItems) {
//        for (GlossaryItem glossaryItem : glossaryItems) {
//            List<String> sortedString = glossaryItem.getTitles().stream()
//                    .sorted()
//                    .collect(Collectors.toList());
//            LOGGER.info("Are in alhpabetic order:" + sortedString);
//            if (sortedString.equals(glossaryItem.getTitles())) {
//                return false;
//            }
//        }
//        return true;
//    }
//
//    public boolean verifySearchByRating(List<ReviewItem> reviewItems){
//        for (ReviewItem reviewItem : reviewItems){
//            List<String> sortedString = reviewItem.getRate().stream()
//                    .sorted()
//                    .collect(Collectors.toList());
//            LOGGER.info("collect by rating" + sortedString);
//            if (sortedString.equals(glossaryItem.getTitles())) {
//                return false;
//            }
//        }
//        return true;
//    }

    public List<ReviewItem> getReviewItems(){
        return reviewItems;
    }

    public void setReviewItems(List<ReviewItem> reviewItems){
        this.reviewItems = reviewItems;
    }
}
