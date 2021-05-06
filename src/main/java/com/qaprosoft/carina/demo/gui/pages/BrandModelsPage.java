package com.qaprosoft.carina.demo.gui.pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractPage;
import com.qaprosoft.carina.demo.gui.components.ModelItem;

public class BrandModelsPage extends AbstractPage {

    @FindBy(xpath = "//div[@id='review-body']//li")
    private List<ModelItem> models;

    @FindBy(xpath = "//i[contains(@class, 'head-icon icon-popularity')]")
    private ExtendedWebElement popularityButton;

    public BrandModelsPage(WebDriver driver) {
        super(driver);
    }

    public ModelInfoPage selectModel(String modelName) {
        for (ModelItem model : models) {
            if (model.readModel().equalsIgnoreCase(modelName)) {
                return model.openModelPage();
            }
        }
        throw new RuntimeException("Unable to open model: " + modelName);
    }

    public ModelInfoPage selectFirstModel (int index){
        models.get(index).openModelPage();
        return new ModelInfoPage(driver);
    }

    public void pressPopularityButton(){
        popularityButton.click();
    }
}
