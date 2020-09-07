package org.halodoc.pages;

import org.halodoc.framework.BaseLib;
import org.openqa.selenium.By;

import java.util.Properties;

public class HomePage extends BaseLib {
    static Properties properties;
    public HomePage(){
        properties=loadPropFile("HomePage.properties");
    }

    public boolean verifyHomePage(){
        waitForServer();
        return verifyElement(properties.getProperty("mySitelink"));
    }

    public void clickMySite(){
        String classNames = getProperties(properties.getProperty("mySitelink"),"class");
        if(!classNames.contains("is-active")){
            System.out.println("click my sites link");
            driver.findElement(By.xpath(properties.getProperty("mySitelink"))).click();
        }
        else {
            System.out.println("My Sites is already clicked");
        }
    }

    public void navigateTo(String menuItem){
        String[] navigations = menuItem.split("\\.");
        for(String linkName : navigations){
            String xpath = properties.getProperty("navigation").replace("{xpathInput}",linkName);
            System.out.println("xpath to click : "+xpath);
            waitForServer();
            clickItem(xpath);
        }
    }

    public void clickAddNewPost(){
        waitForServer();
        clickItem(properties.getProperty("addNewPostButton"));
    }
}
