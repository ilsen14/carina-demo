package com.qaprosoft.carina.demo;

import com.qaprosoft.carina.demo.enums.GenderEnum;
import org.apache.commons.lang3.RandomStringUtils;
import org.testng.annotations.Test;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import com.qaprosoft.carina.core.foundation.AbstractTest;
import com.qaprosoft.carina.core.foundation.utils.mobile.IMobileUtils;
import com.qaprosoft.carina.core.foundation.utils.ownership.MethodOwner;
import com.qaprosoft.carina.demo.utils.MobileContextUtils;
import com.qaprosoft.carina.demo.utils.MobileContextUtils.View;
import com.qaprosoft.carina.demo.mobile.gui.pages.common.CarinaDescriptionPageBase;
import com.qaprosoft.carina.demo.mobile.gui.pages.common.ContactUsPageBase;
import com.qaprosoft.carina.demo.mobile.gui.pages.common.LoginPageBase;
import com.qaprosoft.carina.demo.mobile.gui.pages.common.MapsPageBase;
import com.qaprosoft.carina.demo.mobile.gui.pages.common.UIElementsPageBase;
import com.qaprosoft.carina.demo.mobile.gui.pages.common.WebViewPageBase;
import com.qaprosoft.carina.demo.mobile.gui.pages.common.WelcomePageBase;
import com.zebrunner.agent.core.annotation.TestLabel;

public class MobileSampleTest extends AbstractTest implements IMobileUtils {

    @Test(description = "JIRA#DEMO-0011")
    @MethodOwner(owner = "qpsdemo")
    @TestLabel(name = "feature", value = {"mobile", "regression"})
    public void testLoginUser() {
        String username = "Test user";
        String password = RandomStringUtils.randomAlphabetic(10);
        WelcomePageBase welcomePage = initPage(getDriver(), WelcomePageBase.class);
        Assert.assertTrue(welcomePage.isPageOpened(), "Welcome page isn't opened");
        LoginPageBase loginPage = welcomePage.clickNextBtn();
        Assert.assertFalse(loginPage.isLoginBtnActive(), "Login button is active when it should be disabled");
        loginPage.typeName(username);
        loginPage.typePassword(password);
        loginPage.selectGender();
        loginPage.checkPrivacyPolicyCheckbox();
        CarinaDescriptionPageBase carinaDescriptionPage = loginPage.clickLoginBtn();
        Assert.assertTrue(carinaDescriptionPage.isPageOpened(), "Carina description page isn't opened");
    }

	@Test(description = "JIRA#DEMO-0011")
    @MethodOwner(owner = "qpsdemo")
    @TestLabel(name = "feature", value = {"mobile", "regression"})
    public void testWebView() {
        WelcomePageBase welcomePage = initPage(getDriver(), WelcomePageBase.class);
        LoginPageBase loginPage = welcomePage.clickNextBtn();
        loginPage.login();
        WebViewPageBase webViewPageBase = initPage(getDriver(), WebViewPageBase.class);
        MobileContextUtils contextHelper = new MobileContextUtils();
        contextHelper.switchMobileContext(View.WEB);
        ContactUsPageBase contactUsPage = webViewPageBase.goToContactUsPage();
        contactUsPage.typeName("John Doe");
        contactUsPage.typeEmail("some@email.com");
        contactUsPage.typeQuestion("This is a message");
        //TODO: [VD] move page driver related action outside from test class!
        hideKeyboard();
        contactUsPage.submit();
        Assert.assertTrue(contactUsPage.isSuccessMessagePresent() || contactUsPage.isRecaptchaPresent(),
            "message was not sent or captcha was not displayed");
    }

    @Test(description = "JIRA#DEMO-0011")
    @MethodOwner(owner = "qpsdemo")
    @TestLabel(name = "feature", value = {"mobile", "acceptance"})
    public void testUIElements() {
        WelcomePageBase welcomePage = initPage(getDriver(), WelcomePageBase.class);
        LoginPageBase loginPage = welcomePage.clickNextBtn();
        CarinaDescriptionPageBase carinaDescriptionPage = loginPage.login();
        UIElementsPageBase uiElements = carinaDescriptionPage.navigateToUIElementsPage();
        final String text = "some text";
        final String date = "22/10/2018";
        final String email = "some@email.com";
        uiElements.typeText(text);
        Assert.assertEquals(uiElements.getText(), text, "Text was not typed");
        uiElements.typeDate(date);
        Assert.assertEquals(uiElements.getDate(), date, "Date was not typed");
        uiElements.typeEmail(email);
        Assert.assertEquals(uiElements.getEmail(), email, "Email was not typed");
        uiElements.swipeToFemaleRadioButton();
        uiElements.checkCopy();
        Assert.assertTrue(uiElements.isCopyChecked(), "Copy checkbox was not checked");
        uiElements.clickOnFemaleRadioButton();
        Assert.assertTrue(uiElements.isFemaleRadioButtonSelected(), "Female radio button was not selected!");
        uiElements.clickOnOtherRadioButton();
        Assert.assertTrue(uiElements.isOthersRadioButtonSelected(), "Others radio button was not selected!");
    }

    @Test(description = "JIRA#DEMO-0011")
    @MethodOwner(owner = "qpsdemo")
    @TestLabel(name = "feature", value = {"mobile", "acceptance"})
    public void testUserLogin(){
        SoftAssert softAssert = new SoftAssert();
        String username = "Test user";
        String password = RandomStringUtils.randomAlphabetic(10);
        WelcomePageBase welcomePage = initPage(getDriver(), WelcomePageBase.class);
        LoginPageBase loginPage = welcomePage.clickNextBtn();
        Assert.assertTrue(loginPage.isLoginPageOpened(), "Page is not opened");
        softAssert.assertTrue(loginPage.isNameInputFieldPresent(), "Name Input Field is not present");
        softAssert.assertTrue(loginPage.isPasswordInputFieldPresent(), "Password Input Filed is not Present!");
        softAssert.assertTrue(loginPage.isGenderRadioBtnPresent(), "Gender Radio Button is not Present");
        softAssert.assertTrue(loginPage.isPrivacyPolicyCheckBoxPresent(), "Privacy Policy Field is not Present");
        loginPage.typeName(username);
        loginPage.typePassword(password);
        softAssert.assertTrue(loginPage.isNameTextPrinted(username), "Name was not printed in  the field");
        softAssert.assertTrue(loginPage.isPasswordTextPrinted(password), "Name was not printed in  the field");
        loginPage.selectGender();
        softAssert.assertTrue(loginPage.isGenderButtonChecked(GenderEnum.MALE));
        softAssert.assertFalse(loginPage.isLoginBtnActive(), "Login button is not active");
        loginPage.checkPrivacyPolicyCheckbox();
        softAssert.assertTrue(loginPage.isPrivacyPolicyCheckBoxChecked(), "Privacy Policy is not Checked");
        CarinaDescriptionPageBase carinaDescriptionPage = loginPage.clickLoginBtn();
        Assert.assertTrue(carinaDescriptionPage.isPageOpened(), "Carina description page isn't opened");
        softAssert.assertAll();
    }

    @Test(description = "JIRA#DEMO-0011")
    @MethodOwner(owner = "isenko")
    @TestLabel(name = "feature", value = {"mobile", "acceptance"})
    public void testVerifyMapFeatures(){
        SoftAssert softAssert = new SoftAssert();
        String username = "Test user";
        String password = RandomStringUtils.randomAlphabetic(10);
        WelcomePageBase welcomePage = initPage(getDriver(), WelcomePageBase.class);
        LoginPageBase loginPage = welcomePage.clickNextBtn();
        Assert.assertTrue(loginPage.isLoginPageOpened(), "Login page is not opened!");
        softAssert.assertTrue(loginPage.isNameInputFieldPresent(), "Name input field is missing");
        softAssert.assertTrue(loginPage.isPasswordInputFieldPresent(), "Password input field is missing");
        softAssert.assertTrue(loginPage.isGenderRadioBtnPresent(), "Gender Radio Button is not Present");
        softAssert.assertTrue(loginPage.isPrivacyPolicyCheckBoxPresent(), "Privacy Policy Field is not Present");
        loginPage.typeName(username);
        loginPage.typePassword(password);
        softAssert.assertTrue(loginPage.isNameTextPrinted(username), "Username was not printed");
        softAssert.assertTrue(loginPage.isPasswordTextPrinted(password), "Password was not printed");
//        loginPage.selectGender();
        softAssert.assertTrue(loginPage.isGenderButtonChecked(GenderEnum.MALE));
        softAssert.assertFalse(loginPage.isLoginBtnActive(), "Login button is not active");
        loginPage.checkPrivacyPolicyCheckbox();
        softAssert.assertTrue(loginPage.isPrivacyPolicyCheckBoxChecked(), "Privacy Policy is not Checked");
        CarinaDescriptionPageBase carinaDescriptionPage = loginPage.clickLoginBtn();
        Assert.assertTrue(carinaDescriptionPage.isPageOpened(), "Carina description page isn't opened");
        MapsPageBase mapPage = carinaDescriptionPage.navigateToMapPage();
        Assert.assertTrue(mapPage.isMapsPageOpened(), "Map Page is not opened!");
        softAssert.assertTrue(mapPage.isZoomInButtonPresent(), "There is no zoom in button");
        softAssert.assertTrue(mapPage.isZoomOutButtonPresent(), "There is no zoom out button");
        Assert.assertTrue(mapPage.isZoomInButtonHigherPlaced(), "Zoom in Button is lower than Zoom out");
        softAssert.assertAll();
    }
}

