package org.halodoc.pages;

import org.halodoc.framework.BaseLib;
import org.openqa.selenium.Keys;

import java.util.Properties;

public class AddPostPage extends BaseLib {
    static Properties properties;
    public AddPostPage(){
        properties=loadPropFile("AddPostPage.properties");
    }

    public void switchToAddPostIframe(){
        waitForServer(15);
        switchToFrame(properties.getProperty("addPostIframe"));
    }

    public void addTitle(String title){
        waitForServer();
        setText(properties.getProperty("titleInput"),title);
    }

    public void saveDraft(){
        waitForServer();
        clickItem(properties.getProperty("saveDraftButton"));
    }

    public void clickAddBlock(){

    }

    public void searchElement(String query){

    }
}
