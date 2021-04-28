package com.qaprosoft.carina.demo.gui.components;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractUIObject;

public class GlossaryItem extends AbstractUIObject {

    @FindBy(xpath = "./a")
    private List<ExtendedWebElement> glossaryItems;

    public GlossaryItem(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
    }

    private List<String> items = new ArrayList<>();

    public List<String> getTitles() {
        for (ExtendedWebElement elem : glossaryItems) {
            items.add(elem.getText().toUpperCase());
        }
        return items;
    }
}

