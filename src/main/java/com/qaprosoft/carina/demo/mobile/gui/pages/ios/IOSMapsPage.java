package com.qaprosoft.carina.demo.mobile.gui.pages.ios;

import com.qaprosoft.carina.core.foundation.utils.factory.DeviceType;
import com.qaprosoft.carina.core.foundation.utils.factory.DeviceType.Type;
import com.qaprosoft.carina.demo.consant.ProjectConstants;
import com.qaprosoft.carina.demo.mobile.gui.pages.common.MapsPageBase;
import org.openqa.selenium.WebDriver;

@DeviceType(pageType = Type.IOS_PHONE, parentClass = MapsPageBase.class)
class IOSMapsPage extends MapsPageBase {


    public IOSMapsPage(WebDriver driver) {
        super(driver);
    }


    @Override
    public boolean isZoomInButtonPresent() {
        throw new UnsupportedOperationException(ProjectConstants.UNIMPLEMENTED_IOS);
    }

    @Override
    public boolean isZoomOutButtonPresent() {
        throw new UnsupportedOperationException(ProjectConstants.UNIMPLEMENTED_IOS);
    }

    @Override
    public boolean isMapsPageOpened() {
        throw new UnsupportedOperationException(ProjectConstants.UNIMPLEMENTED_IOS);
    }

    @Override
    public boolean isZoomInButtonHigherPlaced() {
        throw new UnsupportedOperationException(ProjectConstants.UNIMPLEMENTED_IOS);
    }
}
