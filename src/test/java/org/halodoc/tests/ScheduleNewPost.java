package org.halodoc.tests;

import org.halodoc.framework.BaseLib;
import org.halodoc.pages.AddPostPage;
import org.halodoc.pages.HomePage;
import org.halodoc.pages.LoginPage;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class ScheduleNewPost extends BaseLib {

    static LoginPage loginPage = new LoginPage();
    static HomePage homePage = new HomePage();
    static AddPostPage addPostPage = new AddPostPage();

    @BeforeTest
    public void login(){
        initTest();
        home();
        loginPage.login();
        Assert.assertTrue(homePage.verifyHomePage(),"My site link is not visible post login");
    }
    
    @Test(description = "Scheduling a new post")
    public void scheduleNewPost(){
        //homePage.clickMySite();
        homePage.navigateTo("Site.Posts");
        homePage.clickAddNewPost();
        /*addPostPage.switchToAddPostIframe();
        addPostPage.addTitle("DemoPost"+generateRandomNumber());
        addPostPage.saveDraft();
        addPostPage.clickAddBlock();*/
    }

    @AfterClass
    public void closeBrowsers(){
        driver.close();
    }
}
