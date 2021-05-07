package com.qaprosoft.carina.demo.gui.pages;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractPage;

public class OpinionPage extends AbstractPage {

    private final static Logger LOGGER = Logger.getLogger(OpinionPage.class);


    @FindBy(xpath = "//option[@value='0']")
    private ExtendedWebElement newestFirst;

    @FindBy(xpath = "//option[@value='1']")
    private ExtendedWebElement oldestFirst;

    @FindBy(xpath = "//option[@value='2']")
    private ExtendedWebElement bestRating;

    @FindBy(xpath = "//a[@class='voting-link vote-up' ][1]")
    private List<ExtendedWebElement> voteUpLink;

    @FindBy(xpath = "//a[@class='voting-link vote-down']")
    private List<ExtendedWebElement> voteDownLink;

    @FindBy(xpath = "//span[@class='thumbs-score']")
    private List<ExtendedWebElement> thumbsScore;

    @FindBy(xpath = "//li[@class='upost']/time")
    private List<ExtendedWebElement> postDate;

    public OpinionPage(WebDriver driver) {
        super(driver);
    }

    public void selectNewestItems() {
        LOGGER.info("Newest items selected");
        newestFirst.click();
    }

    public void selectOldestItems() {
        oldestFirst.click();
    }

    public void selectBestRating() {
        LOGGER.info("Items with best rating selected");
        bestRating.click();
    }

    public boolean verifyCommentsSortedByRating() {
        if (!thumbsScore.isEmpty()) {
            for (int i = 0; i < thumbsScore.size() - 1; i++) {
                int previousRating = Integer.parseInt(thumbsScore.get(i).getText());
                int nextRating = Integer.parseInt(thumbsScore.get(i + 1).getText());
                LOGGER.info(previousRating + ">=" + nextRating );
                if (!(previousRating >= nextRating)) {
                    return false;
                }
            }
        }
        return true;
    }

    public boolean verifyCommentsAreSortedByDate() {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd-mm-yyyy");
        for (int i = 0; i < postDate.size() - 1; i++) {
            String firstDate = postDate.get(i).getText();
            String secondDate = postDate.get(i + 1).getText();
            Date date = null;
            Date date2 = null;
            try {
               date = simpleDateFormat.parse(firstDate);
               date2 = simpleDateFormat.parse(secondDate);
                int result = date.compareTo(date2);
                if (result == 1) {
                    return false;
                }
            } catch (ParseException e) {
                e.printStackTrace();
            }
            return true;
        }
        return false;
    }

    public boolean verifyRatingButtonIsClicked(int index) {
        int initialRating = Integer.parseInt(thumbsScore.get(index).getText());
        LOGGER.info("Increase rating button is clicked");
        voteUpLink.get(index).click();
        int ratingAfterClick = Integer.parseInt(thumbsScore.get(index).getText());
        if (!thumbsScore.isEmpty()) {
            if (!(ratingAfterClick == initialRating + 1)) {
                return false;
            }
            return true;
        }
        return false;
    }

    public boolean verifyRatingButtonUnclicked(int index) {
        int initialRating = Integer.parseInt(thumbsScore.get(index).getText());
        LOGGER.info("Unvote button has been clicked!");
        voteDownLink.get(index).click();
        int ratingAfterClick = Integer.parseInt(thumbsScore.get(index).getText());
        if (!thumbsScore.isEmpty()) {
            if (!(initialRating - ratingAfterClick == 1)) {
                return false;
            }
            return true;
        }
        return false;
    }
}

